/*
 * Copyright(c) 2024 NTT DATA Group Corporation.
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
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.terasoluna.gfw.functionaltest.app.webdrivers.WebDriverType;
import org.terasoluna.gfw.functionaltest.config.SeleniumContextConfig;
import org.terasoluna.gfw.functionaltest.domain.DBLogCleaner;
import jakarta.inject.Inject;

@SpringJUnitConfig(classes = {SeleniumContextConfig.class})
public abstract class FunctionTestSupport extends ApplicationObjectSupport {

    private static final Logger logger = LoggerFactory.getLogger(FunctionTestSupport.class);

    protected static WebDriver driver;

    private static final Set<WebDriver> webDrivers = new HashSet<WebDriver>();

    protected static WebDriverType driverType;

    @Value("${selenium.serverUrl}")
    protected String serverUrl;

    @Value("${selenium.contextName}")
    protected String contextName;

    @Value("${selenium.applicationContextUrl}")
    protected String applicationContextUrl;

    @Value("${selenium.evidenceBaseDirectory}")
    protected String evidenceBaseDirectory;

    protected WebDriverOperations webDriverOperations;

    protected WebDriverWait webDriverWait;

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

    public String testName;

    @RegisterExtension
    FunctionTestSupportExtension extension = new FunctionTestSupportExtension(this);

    private boolean useSetupDefaultWebDriver = true;

    private String simplePackageName;

    protected WebDriverInputFieldAccessor inputFieldAccessor =
            WebDriverInputFieldAccessor.JAVASCRIPT;

    protected Duration defaultTimeoutSecForImplicitlyWait;

    protected FunctionTestSupport() {
        this.simplePackageName = this.getClass().getPackage().getName().replaceAll(".*\\.", "");
    }

    @Value("${selenium.webDriverInputFieldAccessor:JAVASCRIPT}")
    public void setWebDriverInputFieldAccessor(String webDriverInputFieldAccessor) {
        this.inputFieldAccessor =
                WebDriverInputFieldAccessor.valueOf(webDriverInputFieldAccessor.toUpperCase());
    }

    @Value("${selenium.defaultTimeoutSecForImplicitlyWait:5}")
    public void setDefaultTimeoutSecForImplicitlyWait(long defaultTimeoutSecForImplicitlyWait) {
        this.defaultTimeoutSecForImplicitlyWait =
                Duration.ofSeconds(defaultTimeoutSecForImplicitlyWait);
    }

    @AfterAll
    public final static void tearDownWebDrivers() {
        quitWebDrivers();
        driver = null;
    }

    @BeforeEach
    public final void setUpEvidence(TestInfo testInfo) {

        Optional<Method> testMethod = testInfo.getTestMethod();
        if (testMethod.isPresent()) {
            this.testName = testMethod.get().getName();
        }
        String testCaseName = testName.replaceAll("^test", "");

        File evidenceSavingDirectory = new File(
                String.format("%s/%s/%s", evidenceBaseDirectory, simplePackageName, testCaseName));

        logger.debug("evidenceSavingDirectory is " + evidenceSavingDirectory.getAbsolutePath());

        screenCapture.setUp(evidenceSavingDirectory);
        pageSource.setUp(evidenceSavingDirectory);

        dbLog.setUp(evidenceSavingDirectory);
    }

    @BeforeEach
    public final void setUpDefaultWebDriver() {
        if (!useSetupDefaultWebDriver) {
            return;
        }
        bootDefaultWebDriver();
    }

    @BeforeEach
    public final void setUpWebDriverType() {
        if (driverType != null) {
            return;
        }

        List<String> profiles = new ArrayList<>(
                Arrays.asList(getApplicationContext().getEnvironment().getActiveProfiles()));
        profiles.addAll(
                Arrays.asList(getApplicationContext().getEnvironment().getDefaultProfiles()));

        for (String profile : profiles) {
            for (WebDriverType type : WebDriverType.values()) {
                if (type.toString().equalsIgnoreCase(profile)) {
                    driverType = type;
                    return;
                }
            }
        }

        driverType = WebDriverType.DEFAULT();
    }

    @BeforeEach
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
        }
        driver.manage().timeouts().implicitlyWait(this.defaultTimeoutSecForImplicitlyWait);
        driver.get(getPackageRootUrl());

        this.webDriverOperations = new WebDriverOperations(driver);
        this.webDriverOperations
                .setDefaultTimeoutForImplicitlyWait(this.defaultTimeoutSecForImplicitlyWait);
        this.webDriverWait = new WebDriverWait(driver, this.defaultTimeoutSecForImplicitlyWait);
    }

    private WebDriver newWebDriver() {
        WebDriver webDriver = getApplicationContext().getBean(WebDriver.class);
        webDrivers.add(webDriver);
        return webDriver;
    }

    protected void quitDefaultWebDriver() {
        if (driver != null) {
            try {
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
        return applicationContextUrl + "/" + simplePackageName;
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
                webDriver.quit();
            } catch (Throwable t) {
                logger.error("failed quit.", t);
            }
        }
        webDrivers.clear();
    }

    protected void succeededEvidence() {
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

    protected void failedEvidence() {
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

    protected void onSucceeded() {}

    protected void onFailed(Throwable e) {}

    protected void onFinished() {}
}
