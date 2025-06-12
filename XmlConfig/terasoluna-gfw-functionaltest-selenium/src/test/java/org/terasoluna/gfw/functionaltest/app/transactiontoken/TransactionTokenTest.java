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
package org.terasoluna.gfw.functionaltest.app.transactiontoken;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

public class TransactionTokenTest extends FunctionTestSupport {

    private static final Set<String> testCasesOfRebootTarget = new HashSet<String>(
            Arrays.asList("test03_01_defaultTokenStoreSizeOver",
                    "test03_02_customTokenStoreSizeOverClassMethodNamespace",
                    "test03_03_customTokenStoreSizeOverMethodOnlyNamespace",
                    "test03_04_customTokenStoreSizeOverGlobalNamespace"));

    public TransactionTokenTest() {
        disableSetupDefaultWebDriver();
    }

    @BeforeEach
    public void setUp() {
        if (testCasesOfRebootTarget.contains(testName)) {
            quitDefaultWebDriver();
        }
        bootDefaultWebDriver();
    }

    @AfterEach
    public void tearDown() {
        if (testCasesOfRebootTarget.contains(testName)) {
            quitDefaultWebDriver();
        }
    }

    @Test
    public void test01_01_tokenCreationWithClassNameSpace() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn1")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value")
                .matches("transactiontoken~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test01_02_tokenCreationWithClassAndMethodNameSpaces() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn2")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value")
                .matches("transactiontoken/create~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test01_03_tokenCreationWithMethodNameSpace() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn3")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value")
                .matches("create~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test01_04_tokenCreationWithGlobalNameSpace() {
        driver.findElement(By.id("link1")).click();
        driver.findElement(By.id("btn4")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value")
                .matches("globalToken~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test02_01_normalBeginInEndScenario() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

        // check
        currentToken = newToken;
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        driver.findElement(By.id("btn-check")).click();
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertThat(newToken, is(currentToken));

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));

    }

    @Test
    public void test02_02_normalBeginInEndScenarioNamespaceAttribute() {
        driver.findElement(By.id("link5")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

        // check
        currentToken = newToken;
        driver.findElement(By.id("btn-check")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertThat(newToken, is(currentToken));

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));

    }

    @Test
    public void test02_03_normalBeginInEndScenarioWithGlobalNamespace() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow2")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertThat(currentToken.split("~")[0], is("globalToken"));
        assertUpdateTokenValue(newToken, currentToken);

        // check
        currentToken = newToken;
        driver.findElement(By.id("btn-check")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertThat(newToken, is(currentToken));

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));
    }

    @Test
    public void test02_04_normalBeginEndScenario() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        driver.findElement(By.id("btn-end")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));

    }

    @Test
    public void test02_05_normalBeginInEndScenarioWithBack() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

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
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        currentToken = newToken;
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

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
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        currentToken = newToken;
        newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

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
    public void test02_06_normalBeginInputErrorBegin() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow5_1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        driver.findElement(By.id("btn-flow5_2")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

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
    public void test02_07_beginAndEndWithError() {
        driver.findElement(By.id("link2")).click();

        // token generation
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        // error occurs in end and returns back to step-1 screen with transaction token
        // destroyed
        driver.findElement(By.id("btn-end-error")).click();
        assertFalse(webDriverOperations.exists(By.name("_TRANSACTION_TOKEN")));
    }

    @Test
    public void test02_08_beginAndInWithError() {
        driver.findElement(By.id("link2")).click();

        // token generation
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        // error occurs in IN and returns back to step-2 screen but transaction token
        // not destroyed
        driver.findElement(By.id("btn-in-finish-error")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

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
    }

    @Test
    public void test02_09_inWithoutBegin() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow3")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test02_10_beginAndInWithBrowserBackAndError() {

        driver.findElement(By.id("link2")).click();

        // token generation
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        // Browser Back Simulation
        // consider that back button is clicked and old token is sent again for IN/END
        // request
        // As Browser back in not working, request is sent to END method instead of IN
        // again
        // Expected Flow : BEGIN -> IN -> Browser Back -> IN (token error)
        // Actual implemented flow : BEGIN -> IN -> END (Token error since token
        // generated in BEGIN
        // is passed instead of that
        // updated after IN)

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(
                "document.getElementsByName('_TRANSACTION_TOKEN')[0].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_TRANSACTION_TOKEN')[0].value = '"
                + currentToken + "';");

        driver.findElement(By.id("btn-end")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test02_11_beginInWithTokenMismatch() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow7")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));

    }

    @Test
    public void test02_12_endWithoutBegin() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow4")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test02_13_beginEndWithTokenMismatch() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow7")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        driver.findElement(By.id("btn-end")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test02_14_normalBeginInOnly() {
        driver.findElement(By.id("link2")).click();

        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

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
    public void test02_15_normalBeginCheckInScenario() {
        driver.findElement(By.id("link2")).click();

        // begin
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        // filedownload (check)
        driver.findElement(By.id("btn-download01")).click();

        // in
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

    }

    @Test
    public void test02_16_beginInBackCheckScenario() {
        driver.findElement(By.id("link2")).click();

        // begin
        driver.findElement(By.id("btn-flow1")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());

        String currentToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");

        // in
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.name("_TRANSACTION_TOKEN")), notNullValue());
        String newToken = driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value");
        assertUpdateTokenValue(newToken, currentToken);

        // Browser Back Simulation
        // consider that back button is clicked and old token is sent again for UPDATE
        // request
        // As Browser back in not working, request is sent to UPDATE method with
        // oldtoken
        // Expected Flow : BEGIN -> IN -> Browser Back -> UPDATE
        // Actual implemented flow : BEGIN -> IN -> UPDATE(old token)

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(
                "document.getElementsByName('_TRANSACTION_TOKEN')[0].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('_TRANSACTION_TOKEN')[0].value = '"
                + currentToken + "';");

        // check
        driver.findElement(By.id("btn-check")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));

    }

    @Test
    public void test02_17_checkWithoutBegin() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow8")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test03_01_defaultTokenStoreSizeOver() {

        // Main window
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow1")).click();
        String mainWindow = driver.getWindowHandle();

        for (int i = 0; i < 10; i++) {
            switchToNewWindow();
            driver.findElement(By.id("link2")).click();
            driver.findElement(By.id("btn-flow1")).click();
        }

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test03_02_customTokenStoreSizeOverClassMethodNamespace() {

        // TODO this test fails if the other namespace starts with the main namespace

        // Main window
        // start some non conflicting operation
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin1-other")).click();
        String mainWindow = driver.getWindowHandle();

        // Conflict window
        // Start conflicting operation
        switchToNewWindow();
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin1")).click();
        String conflictWindow = driver.getWindowHandle();

        for (int i = 0; i < 2; i++) {
            // Other window
            switchToNewWindow();
            driver.findElement(By.id("link3")).click();
            driver.findElement(By.id("btn-begin1")).click();
        }

        // Complete non conflicting operation main window
        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in1-other")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is(not("Transaction Token Error")));

        // Check transaction token error for the operation of which transaction token
        // has expired
        // Click for in
        driver.switchTo().window(conflictWindow);
        driver.findElement(By.id("btn-in1")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test03_03_customTokenStoreSizeOverMethodOnlyNamespace() {

        // Main window
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin2")).click();
        String mainWindow = driver.getWindowHandle();

        for (int i = 0; i < 2; i++) {
            // Other window
            switchToNewWindow();
            driver.findElement(By.id("link3")).click();
            driver.findElement(By.id("btn-begin2")).click();
        }

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in2")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test03_04_customTokenStoreSizeOverGlobalNamespace() {

        // Main window
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin3")).click();
        String mainWindow = driver.getWindowHandle();

        // Other window
        switchToNewWindow();
        driver.findElement(By.id("link3")).click();
        driver.findElement(By.id("btn-begin3")).click();

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in3")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test03_05_defaultTokenStoreSizeOpen() {

        // Main window
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow1")).click();
        String mainWindow = driver.getWindowHandle();

        // The default maximum number of open window(create token)
        for (int i = 0; i < 9; i++) {
            switchToNewWindow();
            driver.findElement(By.id("link2")).click();
            driver.findElement(By.id("btn-flow1")).click();
        }

        // Click for in
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value")
                .matches("transactiontoken~[0-9a-z]{32}~[0-9a-z]{32}"));
    }

    @Test
    public void test03_06_defaultTokenStoreSizeOpenCheck() {

        // Main window
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow1")).click();
        String mainWindow = driver.getWindowHandle();

        // The default maximum number of open window(create token)
        for (int i = 0; i < 9; i++) {
            switchToNewWindow();
            driver.findElement(By.id("link2")).click();
            driver.findElement(By.id("btn-flow1")).click();
        }

        // Other window token check is OK (Overwrite token of the first window)
        switchTo(Collections.singleton(mainWindow));
        driver.findElement(By.name("redo1")).click();
        driver.findElement(By.id("btn-flow1")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value")
                .matches("transactiontoken~[0-9a-z]{32}~[0-9a-z]{32}"));

        // Token check of the open window in the first is NG
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("btn-in")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(),
                is("Transaction Token Error"));
    }

    @Test
    public void test04_01_tokenRenderingWithJSPTag() {
        driver.findElement(By.id("link2")).click();
        driver.findElement(By.id("btn-flow6")).click();
        assertTrue(driver.findElement(By.name("_TRANSACTION_TOKEN")).getAttribute("value")
                .matches("globalToken~[0-9a-z]{32}~[0-9a-z]{32}"));
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

    private void switchToNewWindow() {
        Set<String> oldWindowHandles = driver.getWindowHandles();
        driver.findElement(By.id("open-new-window")).click();
        switchTo(oldWindowHandles);
    }

    private void switchTo(Set<String> excludeWindowHandles) {
        Set<String> currentWindowHandles = new LinkedHashSet<>(driver.getWindowHandles());
        currentWindowHandles.removeAll(excludeWindowHandles);
        driver.switchTo().window(currentWindowHandles.iterator().next());

    }
}
