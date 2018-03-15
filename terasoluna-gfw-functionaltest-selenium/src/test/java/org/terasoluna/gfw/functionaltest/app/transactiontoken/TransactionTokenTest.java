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
package org.terasoluna.gfw.functionaltest.app.transactiontoken;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;
import org.terasoluna.gfw.functionaltest.app.ScreenCaptureWebDriverEventListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class TransactionTokenTest extends FunctionTestSupport {

    private static final Set<String> testCasesOfRebootTarget = new HashSet<String>(Arrays
            .asList("test03_01_defaultTokenStoreSizeOver",
                    "test03_02_customTokenStoreSizeOverClassMethodNamespace",
                    "test03_03_customTokenStoreSizeOverMethodOnlyNamespace",
                    "test03_04_customTokenStoreSizeOverGlobalNamespace"));

    protected EventFiringWebDriver driver;

    public TransactionTokenTest() {
        disableSetupDefaultWebDriver();
    }

    @Before
    public void setUp() {
        if (testCasesOfRebootTarget.contains(testName.getMethodName())) {
            quitDefaultWebDriver();
        }
        bootDefaultWebDriver();
        driver = new EventFiringWebDriver(getDefaultWebDriver());
        driver.register(new ScreenCaptureWebDriverEventListener(screenCapture));
    }

    @After
    public void tearDown() {
        if (testCasesOfRebootTarget.contains(testName.getMethodName())) {
            quitDefaultWebDriver();
        }
    }

    @Test
    public void test01_01_tokenCreationWithClassNameSpace() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn1")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value").matches(
                        "transactiontoken~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test01_02_tokenCreationWithClassAndMethodNameSpaces() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn2")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value").matches(
                        "transactiontoken/create~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test01_03_tokenCreationWithMethodNameSpace() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn3")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value").matches(
                        "create~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test01_04_tokenCreationWithGlobalNameSpace() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn4")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value").matches(
                        "globalToken~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test02_01_normalBeginInEndScenario() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

        // check
        currentToken = newToken;
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        driver.findElement(By.id("btn-check")).click();
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertThat(newToken, is(currentToken));

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));

    }

    @Test
    public void test02_02_normalBeginInEndScenarioNamespaceAttribute() {
        driver.findElement(By.id("link5")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

        // check
        currentToken = newToken;
        driver.findElement(By.id("btn-check")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertThat(newToken, is(currentToken));

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));

    }

    @Test
    public void test02_03_normalBeginInEndScenarioWithGlobalNamespace() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow2")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertThat(currentToken.split("~")[0], is("globalToken"));
        assertUpdateTokenValue(newToken, currentToken);

        // check
        currentToken = newToken;
        driver.findElement(By.id("btn-check")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertThat(newToken, is(currentToken));

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));
    }

    @Test
    public void test02_04_normalBeginEndScenario() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));

    }

    @Test
    public void test02_05_normalBeginInScenarioWithTokenRemove() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        driver.findElement(By.id("btn-in-finish")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));

    }

    @Test
    public void test02_06_normalBeginInEndScenarioWithBack() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        String currentTokenName = currentToken.split("~")[0];
        String newTokenName = newToken.split("~")[0];
        String currentTokenKey = currentToken.split("~")[1];
        String newTokenKey = newToken.split("~")[1];
        String currentTokenValue = currentToken.split("~")[2];
        String newTokenValue = newToken.split("~")[2];
        assertThat(newTokenName, is(currentTokenName));
        assertThat(newTokenKey, is(currentTokenKey));
        assertThat(newTokenValue, is(not(currentTokenValue)));

        driver.findElement(By.id("btn-back")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        currentToken = newToken;
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        currentTokenName = currentToken.split("~")[0];
        newTokenName = newToken.split("~")[0];
        currentTokenKey = currentToken.split("~")[1];
        newTokenKey = newToken.split("~")[1];
        currentTokenValue = currentToken.split("~")[2];
        newTokenValue = newToken.split("~")[2];
        assertThat(newTokenName, is(currentTokenName));
        assertThat(newTokenKey, is(currentTokenKey));
        assertThat(newTokenValue, is(not(currentTokenValue)));

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        currentToken = newToken;
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        currentTokenName = currentToken.split("~")[0];
        newTokenName = newToken.split("~")[0];
        currentTokenKey = currentToken.split("~")[1];
        newTokenKey = newToken.split("~")[1];
        currentTokenValue = currentToken.split("~")[2];
        newTokenValue = newToken.split("~")[2];
        assertThat(newTokenName, is(currentTokenName));
        assertThat(newTokenKey, is(currentTokenKey));
        assertThat(newTokenValue, is(not(currentTokenValue)));

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));
    }

    @Test
    public void test02_07_normalBeginInputErrorBegin() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow5_1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        driver.findElement(By.id("btn-flow5_2")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        String currentTokenName = currentToken.split("~")[0];
        String newTokenName = newToken.split("~")[0];
        String currentTokenKey = currentToken.split("~")[1];
        String newTokenKey = newToken.split("~")[1];
        String currentTokenValue = currentToken.split("~")[2];
        String newTokenValue = newToken.split("~")[2];

        assertThat(newTokenName, is(currentTokenName));
        assertThat(newTokenKey, is(not(currentTokenKey)));
        assertThat(newTokenValue, is(not(currentTokenValue)));

    }

    @Test
    public void test02_08_beginAndEndWithError() {
        driver.findElement(By.id("link2")).click();

        // token generation
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        // error occurs in end and returns back to step-1 screen with transaction token destroyed
        driver.findElement(By.id("btn-end-error")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));
    }

    @Test
    public void test02_09_beginAndInWithError() {
        driver.findElement(By.id("link2")).click();

        // token generation
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        // error occurs in IN and returns back to step-2 screen but transaction token not destroyed
        driver.findElement(By.id("btn-in-finish-error")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        // Check whether transaction token is updated
        // key will remain same, only value will be updated
        String currentTokenName = currentToken.split("~")[0];
        String newTokenName = newToken.split("~")[0];
        String currentTokenKey = currentToken.split("~")[1];
        String newTokenKey = newToken.split("~")[1];
        String currentTokenValue = currentToken.split("~")[2];
        String newTokenValue = newToken.split("~")[2];
        assertThat(newTokenName, is(currentTokenName));
        assertThat(newTokenKey, is(currentTokenKey));
        assertThat(newTokenValue, is(not(currentTokenValue)));

        // this time no error and token is destroyed
        driver.findElement(By.id("btn-in-finish")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));
    }

    @Test
    public void test02_10_inWithoutBegin() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow3")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test02_11_beginAndInWithBrowserBackAndError() {

        driver.findElement(By.id("link2")).click();

        // token generation
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        // Browser Back Simulation
        // consider that back button is clicked and old token is sent again for IN/END request
        // As Browser back in not working, request is sent to END method instead of IN again
        // Expected Flow : BEGIN -> IN -> Browser Back -> IN (token error)
        // Actual implemented flow : BEGIN -> IN -> END (Token error since token generated in BEGIN is passed instead of that
        // updated after IN)

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(
                "document.getElementsByName('_TRANSACTION_TOKEN')[0].setAttribute('type', 'text');");
        jse.executeScript(
                "document.getElementsByName('_TRANSACTION_TOKEN')[0].value = '"
                        + currentToken + "';");

        driver.findElement(By.id("btn-end")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test02_12_beginInWithTokenMismatch() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow7")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));

    }

    @Test
    public void test02_13_endWithoutBegin() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow4")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test02_14_beginEndWithTokenMismatch() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow7")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        driver.findElement(By.id("btn-end")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test02_15_normalBeginInOnly() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        String currentTokenName = currentToken.split("~")[0];
        String newTokenName = newToken.split("~")[0];
        String currentTokenKey = currentToken.split("~")[1];
        String newTokenKey = newToken.split("~")[1];
        String currentTokenValue = currentToken.split("~")[2];
        String newTokenValue = newToken.split("~")[2];
        assertThat(newTokenName, is(currentTokenName));
        assertThat(newTokenKey, is(currentTokenKey));
        assertThat(newTokenValue, is(not(currentTokenValue)));
    }

    @Test
    public void test02_16_normalBeginCheckInScenario() {
        driver.findElement(By.id("link2")).click();

        // begin
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        // filedownload (check)
        driver.findElement(By.id("btn-download01")).click();

        // in
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

    }

    @Test
    public void test02_17_beginInBackCheckScenario() {
        driver.findElement(By.id("link2")).click();

        // begin
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");

        // in
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")),
                notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

        // Browser Back Simulation
        // consider that back button is clicked and old token is sent again for UPDATE request
        // As Browser back in not working, request is sent to UPDATE method with oldtoken
        // Expected Flow : BEGIN -> IN -> Browser Back -> UPDATE
        // Actual implemented flow : BEGIN -> IN -> UPDATE(old token)

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(
                "document.getElementsByName('_TRANSACTION_TOKEN')[0].setAttribute('type', 'text');");
        jse.executeScript(
                "document.getElementsByName('_TRANSACTION_TOKEN')[0].value = '"
                        + currentToken + "';");

        // check
        driver.findElement(By.id("btn-check")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));

    }

    @Test
    public void test02_18_checkWithoutBegin() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow8")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test03_01_defaultTokenStoreSizeOver() {

        if (driver.getWrappedDriver() instanceof InternetExplorerDriver) {
            logger.warn(testName.getMethodName()
                    + " is not support Internet Explorer.");
            return;
        }

        // Main window
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow1")).click();
        String mainWindow = driver.getWindowHandle();

        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("open-new-window")).click();
            driver.switchTo().window(new LinkedList<String>(driver
                    .getWindowHandles()).getLast());
            driver.findElement(By.id("link2")).click();
            driver.findElement(By.id("btn-flow1")).click();
        }

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test03_02_customTokenStoreSizeOverClassMethodNamespace() {

        if (driver.getWrappedDriver() instanceof InternetExplorerDriver) {
            logger.warn(testName.getMethodName()
                    + " is not support Internet Explorer.");
            return;
        }

        // TODO this test fails if the other namespace starts with the main namespace

        // Main window
        // start some non conflicting operation
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin1-other")).click();
        String mainWindow = driver.getWindowHandle();

        // Conflict window
        // Start conflicting operation
        driver.findElement(By.id("open-new-window")).click();
        driver.switchTo().window(new LinkedList<String>(driver
                .getWindowHandles()).getLast());
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin1")).click();
        String conflictWindow = driver.getWindowHandle();

        for (int i = 0; i < 2; i++) {
            // Other window
            driver.findElement(By.id("open-new-window")).click();
            driver.switchTo().window(new LinkedList<String>(driver
                    .getWindowHandles()).getLast());
            driver.findElement(By.id("link3")).click();
            driver.findElement(By.id("btn-begin1")).click();
        }

        // Complete non conflicting operation main window
        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in1-other")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(not(
                "Transaction Token Error")));

        // Check transaction token error for the operation of which transaction token has expired
        // Click for in
        driver.switchTo().window(conflictWindow);
        driver.findElement(By.id("btn-in1")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test03_03_customTokenStoreSizeOverMethodOnlyNamespace() {

        if (driver.getWrappedDriver() instanceof InternetExplorerDriver) {
            logger.warn(testName.getMethodName()
                    + " is not support Internet Explorer.");
            return;
        }

        // Main window
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin2")).click();
        String mainWindow = driver.getWindowHandle();

        for (int i = 0; i < 2; i++) {
            // Other window
            driver.findElement(By.id("open-new-window")).click();
            driver.switchTo().window(new LinkedList<String>(driver
                    .getWindowHandles()).getLast());
            driver.findElement(By.id("link3")).click();
            driver.findElement(By.id("btn-begin2")).click();
        }

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in2")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test03_04_customTokenStoreSizeOverGlobalNamespace() {

        if (driver.getWrappedDriver() instanceof InternetExplorerDriver) {
            logger.warn(testName.getMethodName()
                    + " is not support Internet Explorer.");
            return;
        }

        // Main window
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin3")).click();
        String mainWindow = driver.getWindowHandle();

        // Other window
        driver.findElement(By.id("open-new-window")).click();
        driver.switchTo().window(new LinkedList<String>(driver
                .getWindowHandles()).getLast());
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin3")).click();

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in3")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test03_05_defaultTokenStoreSizeOpen() {

        if (driver.getWrappedDriver() instanceof InternetExplorerDriver) {
            logger.warn(testName.getMethodName()
                    + " is not support Internet Explorer.");
            return;
        }

        // Main window
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow1")).click();
        String mainWindow = driver.getWindowHandle();

        // The default maximum number of open window(create token)
        for (int i = 0; i < 9; i++) {
            driver.findElement(By.id("open-new-window")).click();
            driver.switchTo().window(new LinkedList<String>(driver
                    .getWindowHandles()).getLast());
            driver.findElement(By.id("link2")).click();
            driver.findElement(By.id("btn-flow1")).click();
        }

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value").matches(
                        "transactiontoken~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test03_06_defaultTokenStoreSizeOpenCheck() {

        if (driver.getWrappedDriver() instanceof InternetExplorerDriver) {
            logger.warn(testName.getMethodName()
                    + " is not support Internet Explorer.");
            return;
        }

        // Main window
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow1")).click();
        String mainWindow = driver.getWindowHandle();

        // The default maximum number of open window(create token)
        for (int i = 0; i < 9; i++) {
            driver.findElement(By.id("open-new-window")).click();
            driver.switchTo().window(new LinkedList<String>(driver
                    .getWindowHandles()).getLast());
            driver.findElement(By.id("link2")).click();
            driver.findElement(By.id("btn-flow1")).click();
        }

        // Other window token check is OK (Overwrite token of the first window)
        driver.switchTo().window(new LinkedList<String>(driver
                .getWindowHandles()).get(4));
        driver.findElement(By.name("redo1")).click();
        driver.findElement(By.id("btn-flow1")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value").matches(
                        "transactiontoken~[0-9a-z]{32}~[0-9a-z]{32}"));

        // Token check of the open window in the first is NG
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Transaction Token Error"));
    }

    @Test
    public void test04_01_tokenRenderingWithJSPTag() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow6")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN"))
                .getAttribute("value").matches(
                        "globalToken~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    private void assertUpdateTokenValue(String token1, String token2) {
        String token1Name = token1.split("~")[0];
        String token2Name = token2.split("~")[0];
        String token1Key = token1.split("~")[1];
        String token2Key = token2.split("~")[1];
        String token1Value = token1.split("~")[2];
        String token2Value = token2.split("~")[2];

        assertThat(token2Name, is(token1Name));
        assertThat(token2Key, is(token1Key));
        assertThat(token2Value, is(not(token1Value)));
    }

}
