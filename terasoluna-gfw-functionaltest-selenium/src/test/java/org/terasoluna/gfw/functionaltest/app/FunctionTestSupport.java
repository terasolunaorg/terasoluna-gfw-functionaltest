/*
 * Copyright (C) 2013-2018 NTT DATA Corporation
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
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ApplicationObjectSupport;
import org.terasoluna.gfw.functionaltest.domain.DBLogCleaner;

public class FunctionTestSupport extends ApplicationObjectSupport {

    private static final Logger classLogger = LoggerFactory.getLogger(
            FunctionTestSupport.class);

    protected static WebDriver driver;

    private static final Set<WebDriver> webDrivers = new HashSet<WebDriver>();

    protected static EventFiringWebDriver eventFiringWebDriver;

    @Value("${selenium.serverUrl}")
    protected String serverUrl;

    @Value("${selenium.contextName}")
    protected String contextName;

    @Value("${selenium.applicationContextUrl}")
    protected String applicationContextUrl;

    @Value("${selenium.evidenceBaseDirectory}")
    protected String evidenceBaseDirectory;

    protected WebDriverOperations webDriverOperations;

    @Inject
    protected ScreenCapture screenCapture;

    @Inject
    protected PageSource pageSource;

    @Inject
    protected DBLogProvider dbLogProvider;

    @Inject
    private DBLog dbLog;

    @Inject
    private DBLogCleaner dbLogCleaner;

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            onSucceeded();
            succeededEvidence();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            onFailed(e);
            failedEvidence();
        }

        @Override
        protected void finished(Description description) {
            onFinished();
        }
    };

    private boolean useSetupDefaultWebDriver = true;

    private String simplePackageName;

    protected WebDriverInputFieldAccessor inputFieldAccessor = WebDriverInputFieldAccessor.JAVASCRIPT;

    protected long defaultTimeoutSecForImplicitlyWait = 5;

    protected FunctionTestSupport() {
        this.simplePackageName = this.getClass().getPackage().getName()
                .replaceAll(".*\\.", "");
    }

    @Value("${selenium.webDriverInputFieldAccessor:JAVASCRIPT}")
    public void setWebDriverInputFieldAccessor(
            String webDriverInputFieldAccessor) {
        this.inputFieldAccessor = WebDriverInputFieldAccessor.valueOf(
                webDriverInputFieldAccessor.toUpperCase());
    }

    @AfterClass
    public final static void tearDownWebDrivers() {
        quitWebDrivers();
        driver = null;
    }

    @Before
    public final void setUpEvidence() {

        String testCaseName = testName.getMethodName().replaceAll("^test", "");

        File evidenceSavingDirectory = new File(String.format("%s/%s/%s",
                evidenceBaseDirectory, simplePackageName, testCaseName));

        logger.debug("evidenceSavingDirectory is " + evidenceSavingDirectory
                .getAbsolutePath());

        screenCapture.setUp(evidenceSavingDirectory);
        pageSource.setUp(evidenceSavingDirectory);

        dbLog.setUp(evidenceSavingDirectory);
    }

    @Before
    public final void setUpDefaultWebDriver() {
        if (!useSetupDefaultWebDriver) {
            return;
        }
        bootDefaultWebDriver();
    }

    @Before
    public final void setUpDBLog() {
        dbLogCleaner.cleanupAll();
    }

    protected void bindWebDriver(WebDriver webDriver) {
        webDrivers.add(webDriver);
    }

    protected void unbindWebDriver(WebDriver webDriver) {
        webDrivers.remove(webDriver);
    }

    protected void bootDefaultWebDriver() {
        if (driver == null) {
            driver = newWebDriver();
            eventFiringWebDriver = new EventFiringWebDriver(driver);
            WaitWebDriverEventListener waitWebDriverEventListener = getApplicationContext()
                    .getBean(WaitWebDriverEventListener.class);
            driver = eventFiringWebDriver.register(waitWebDriverEventListener);
        }
        driver.manage().timeouts().implicitlyWait(
                defaultTimeoutSecForImplicitlyWait, TimeUnit.SECONDS);
        driver.get(getPackageRootUrl());

        this.webDriverOperations = new WebDriverOperations(driver);
        this.webDriverOperations.setDefaultTimeoutForImplicitlyWait(
                defaultTimeoutSecForImplicitlyWait);
    }

    private WebDriver newWebDriver() {
        WebDriver webDriver = getApplicationContext().getBean(WebDriver.class);
        webDrivers.add(webDriver);
        return webDriver;
    }

    protected void quitDefaultWebDriver() {
        if (driver != null) {
            try {
                driver.get("about:config");
                driver.quit();
            } finally {
                driver = null;
            }
        }
    }

    protected WebDriver getDefaultWebDriver() {
        return driver;
    }

    protected String getPackageRootUrl() {
        return applicationContextUrl + "/" + simplePackageName + "/";
    }

    protected void disableSetupDefaultWebDriver() {
        this.useSetupDefaultWebDriver = false;
    }

    protected void enableSetupDefaultWebDriver() {
        this.useSetupDefaultWebDriver = true;
    }

    private static void quitWebDrivers() {
        for (WebDriver webDriver : webDrivers) {
            try {
                webDriver.get("about:config");
                webDriver.quit();
            } catch (Throwable t) {
                classLogger.error("failed quit.", t);
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
        try {
            dbLog.save(subTitle);
        } catch (Throwable t) {
            logger.error("failed dbLog capture.", t);
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
        try {
            dbLog.saveForced(subTitle);
        } catch (Throwable t) {
            logger.error("failed dbLog capture.", t);
        }
    }

    protected void onSucceeded() {
    }

    protected void onFailed(Throwable e) {
    }

    protected void onFinished() {
    }

}
