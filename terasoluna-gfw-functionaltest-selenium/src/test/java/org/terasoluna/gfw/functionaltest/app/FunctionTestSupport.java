/*
 * Copyright (C) 2013 terasoluna.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.terasoluna.gfw.functionaltest.app;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.util.ReflectionUtils;

public class FunctionTestSupport extends ApplicationObjectSupport {

    private final Set<WebDriver> webDrivers = new HashSet<WebDriver>();

    @Value("${selenium.serverUrl}")
    protected String serverUrl;

    @Value("${selenium.contextName}")
    protected String contextName;

    @Value("${selenium.applicationContextUrl}")
    protected String applicationContextUrl;

    @Value("${selenium.evidenceBaseDirectory}")
    protected String evidenceBaseDirectory;

    @Inject
    protected ScreenCapture screenCapture;

    @Inject
    protected PageSource pageSource;

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatchman testWatchmanForFailed = new TestWatchman() {
        @Override
        public void succeeded(FrameworkMethod method) {
            onSucceeded();
            succeededEvidence();
        }

        public void failed(Throwable e, FrameworkMethod method) {
            onFailed(e);
            failedEvidence();
        }

        @Override
        public void finished(FrameworkMethod method) {
            onFinished();
            quitWebDrivers();
        }
    };

    protected FunctionTestSupport() {
    }

    @Before
    public final void setUpEvidence() {

        String simplePackageName = this.getClass().getPackage().getName()
                .replaceAll(".*\\.", "");
        String testCaseName = testName.getMethodName().replaceAll("^test", "");

        File evidenceSavingDirectory = new File(String.format("%s/%s/%s",
                evidenceBaseDirectory, simplePackageName, testCaseName));

        logger.debug("evidenceSavingDirectory is " + evidenceSavingDirectory
                .getAbsolutePath());
        
        screenCapture.setUp(evidenceSavingDirectory);
        pageSource.setUp(evidenceSavingDirectory);
    }

    @Before
    public final void bindWebDrivers() {
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {

            if (!WebDriver.class.equals(field.getType())) {
                continue;
            }
            Object object = null;
            try {
                field.setAccessible(true);
                object = ReflectionUtils.getField(field, this);
            } finally {
                field.setAccessible(false);
            }
            if (object == null) {
                continue;
            }
            webDrivers.add(WebDriver.class.cast(object));
        }
    }

    protected void bindWebDriver(WebDriver webDriver) {
        webDrivers.add(webDriver);
    }

    protected void unbindWebDriver(WebDriver webDriver) {
        webDrivers.remove(webDriver);
    }

    private void quitWebDrivers() {
        for (WebDriver webDriver : webDrivers) {
            try {
                webDriver.quit();
            } catch (Throwable t) {
                logger.error("failed quit.", t);
            }
        }
        webDrivers.clear();
    }

    private void succeededEvidence() {
        String subTitle = "succeeded";
        for (WebDriver webDriver : webDrivers) {
            try {
                screenCapture.save(webDriver, subTitle);
            } catch (Throwable t) {
                logger.error("failed screen capture.", t);
            }
            try {
                pageSource.save(webDriver, subTitle);
            } catch (Throwable t) {
                logger.error("failed screen PageSource.", t);
            }
        }
    }

    private void failedEvidence() {
        String subTitle = "failed";
        for (WebDriver webDriver : webDrivers) {
            try {
                screenCapture.saveForced(webDriver, subTitle);
            } catch (Throwable t) {
                logger.error("failed screen capture.", t);
            }
            try {
                pageSource.saveForced(webDriver, subTitle);
            } catch (Throwable t) {
                logger.error("failed screen PageSource.", t);
            }
        }
    }

    protected void onSucceeded() {
    }

    protected void onFailed(Throwable e) {
    }

    protected void onFinished() {
    }

}
