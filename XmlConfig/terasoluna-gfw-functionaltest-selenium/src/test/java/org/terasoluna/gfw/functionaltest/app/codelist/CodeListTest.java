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
package org.terasoluna.gfw.functionaltest.app.codelist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

public class CodeListTest extends FunctionTestSupport {

    public CodeListTest() {}

    @BeforeEach
    public void setUpLocale() {
        driver.findElement(By.linkText("English")).click();
    }

    @Test
    public void test01_01_form() {
        driver.findElement(By.id("codelist_01_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key1");
        driver.findElement(By.id("btnback")).click();
        driver.findElement(By.id("codelist_01_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("label2");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key2");
        driver.findElement(By.id("btnback")).click();
        driver.findElement(By.id("codelist_01_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key3");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test01_02_form() {
        driver.findElement(By.id("codelist_01_02")).click();
        assertThat(driver.findElement(By.id("item1")).getText()).isEqualTo("");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_01_form() {
        driver.findElement(By.id("codelist_02_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]")).getText())
                .isEqualTo("1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText())
                .isEqualTo("2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]")).getText())
                .isEqualTo("3");
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]")).getText())
                .isEqualTo("4");
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText())
                .isEqualTo("5");
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("3");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_02_form() {
        driver.findElement(By.id("codelist_02_02")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText())
                .isEqualTo("5");
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]")).getText())
                .isEqualTo("4");
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]")).getText())
                .isEqualTo("3");
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText())
                .isEqualTo("2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]")).getText())
                .isEqualTo("1");
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("3");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_03_form() {
        driver.findElement(By.id("codelist_02_03")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText())
                .isEqualTo("5");
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText())
                .isEqualTo("2");
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("5");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("5");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_04_form() {
        driver.findElement(By.id("codelist_02_04")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"005\"]")).getText())
                .isEqualTo("05");
        assertThat(driver.findElement(By.cssSelector("option[value=\"002\"]")).getText())
                .isEqualTo("02");
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("05");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("005");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_01_form() {
        driver.findElement(By.id("codelist_03_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("label2");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key2");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_02_form() {
        driver.findElement(By.id("codelist_03_02")).click();
        assertThat(driver.findElement(By.id("item1")).getText()).isEqualTo("");
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_03_form() {
        driver.findElement(By.id("codelist_03_03")).click();
        assertThat(driver.findElement(By.id("exceptionCode")).getText()).isEqualTo("e.xx.9999");
    }

    @Test
    public void test04_02_form() {
        driver.findElement(By.id("codelist_04_02")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.name("jdbcCodeListTestSelectCodeList")).click();
        driver.findElement(By.linkText("key2")).click();

        inputFieldAccessor.overrideValue(By.id("code"), "bbb", driver);
        inputFieldAccessor.overrideValue(By.id("value"), "aaa", driver);
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.name("jdbcCodeListTestRefreshCodeList")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"bbb\"]")).getText())
                .isEqualTo("aaa");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btnback")).click();

        // reverting the change to DB state
        driver.findElement(By.id("codelist_04_02")).click();
        driver.findElement(By.name("jdbcCodeListTestSelectCodeList")).click();
        driver.findElement(By.linkText("bbb")).click();
        inputFieldAccessor.overrideValue(By.id("code"), "key2", driver);
        inputFieldAccessor.overrideValue(By.id("value"), "label2", driver);

        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn1")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"bbb\"]")).getText())
                .isEqualTo("aaa");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.name("jdbcCodeListTestRefreshCodeList")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_01_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_06_01")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key1");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_02_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_06_02")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key1");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_03_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_06_03")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key1");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_01_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_11_01")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_02_form() {
        driver.findElement(By.linkText("Canada(French)")).click();
        driver.findElement(By.id("codelist_11_02")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("étiquette1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("étiquette2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("étiquette3");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_03_form() {
        driver.findElement(By.linkText("France")).click();
        driver.findElement(By.id("codelist_11_03")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("étiquette un");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("étiquette deux");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("étiquette trois");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_04_form() {
        driver.findElement(By.linkText("German")).click();
        driver.findElement(By.id("codelist_11_04")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("ラベル1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("ラベル2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("ラベル3");
        driver.findElement(By.id("btnback")).click();
    }

    @Disabled("It is not implemented because there is a possibility that the application startup may fail due "
            + "to　the definition of the bean that has not set the fallbackTo property")
    public void test11_05_form() {}

    @Test
    public void test12_01_form() {
        driver.findElement(By.id("codelist_12_01")).click();
        assertTest12Initial();

        inputFieldAccessor.overrideValue(By.id("code1"), "aaa", driver);
        inputFieldAccessor.overrideValue(By.id("labelEn1"), "bbb", driver);
        inputFieldAccessor.overrideValue(By.id("labelJa1"), "ＣＣＣ", driver);
        driver.findElement(By.id("btnUpdate")).click();

        driver.findElement(By.id("btnRefresh4")).click();
        assertTest12Changed();

        // Rollback codelist.
        inputFieldAccessor.overrideValue(By.id("code1"), "key1", driver);
        inputFieldAccessor.overrideValue(By.id("labelEn1"), "label1", driver);
        inputFieldAccessor.overrideValue(By.id("labelJa1"), "ラベル1", driver);
        driver.findElement(By.id("btnUpdate")).click();

        driver.findElement(By.id("btnRefresh4")).click();
        assertTest12Initial();
    }

    @Test
    public void test12_02_form() {
        driver.findElement(By.id("codelist_12_01")).click();
        assertTest12Initial();

        inputFieldAccessor.overrideValue(By.id("code1"), "aaa", driver);
        inputFieldAccessor.overrideValue(By.id("labelEn1"), "bbb", driver);
        inputFieldAccessor.overrideValue(By.id("labelJa1"), "ＣＣＣ", driver);
        driver.findElement(By.id("btnUpdate")).click();

        driver.findElement(By.id("btnRefresh2")).click();
        assertTest12Initial();

        driver.findElement(By.id("btnRefresh4")).click();
        assertTest12Changed();

        // Rollback codelist.
        inputFieldAccessor.overrideValue(By.id("code1"), "key1", driver);
        inputFieldAccessor.overrideValue(By.id("labelEn1"), "label1", driver);
        inputFieldAccessor.overrideValue(By.id("labelJa1"), "ラベル1", driver);
        driver.findElement(By.id("btnUpdate")).click();

        driver.findElement(By.id("btnRefresh4")).click();
        assertTest12Initial();
    }

    @Test
    public void test12_03_form() {
        driver.findElement(By.id("codelist_12_01")).click();
        assertTest12Initial();

        inputFieldAccessor.overrideValue(By.id("code1"), "aaa", driver);
        inputFieldAccessor.overrideValue(By.id("labelEn1"), "bbb", driver);
        inputFieldAccessor.overrideValue(By.id("labelJa1"), "ＣＣＣ", driver);
        driver.findElement(By.id("btnUpdate")).click();

        driver.findElement(By.id("btnRefresh3")).click();
        assertTest12Changed();

        // Rollback codelist.
        inputFieldAccessor.overrideValue(By.id("code1"), "key1", driver);
        inputFieldAccessor.overrideValue(By.id("labelEn1"), "label1", driver);
        inputFieldAccessor.overrideValue(By.id("labelJa1"), "ラベル1", driver);
        driver.findElement(By.id("btnUpdate")).click();

        driver.findElement(By.id("btnRefresh4")).click();
        assertTest12Initial();
    }

    private void assertTest12Initial() {
        assertThat(driver.findElement(By.id("cl-code1")).getText()).isEqualTo("key1");
        assertThat(driver.findElement(By.id("cl-label1")).getText()).isEqualTo("label1");
        assertThat(driver.findElement(By.id("cl-code2")).getText()).isEqualTo("key2");
        assertThat(driver.findElement(By.id("cl-label2")).getText()).isEqualTo("label2");
        assertThat(driver.findElement(By.id("cl-code3")).getText()).isEqualTo("key3");
        assertThat(driver.findElement(By.id("cl-label3")).getText()).isEqualTo("label3");

        assertThat(driver.findElement(By.id("en-code1")).getText()).isEqualTo("key1");
        assertThat(driver.findElement(By.id("en-label1")).getText()).isEqualTo("label1");
        assertThat(driver.findElement(By.id("en-code2")).getText()).isEqualTo("key2");
        assertThat(driver.findElement(By.id("en-label2")).getText()).isEqualTo("label2");
        assertThat(driver.findElement(By.id("en-code3")).getText()).isEqualTo("key3");
        assertThat(driver.findElement(By.id("en-label3")).getText()).isEqualTo("label3");

        assertThat(driver.findElement(By.id("ja-code1")).getText()).isEqualTo("key1");
        assertThat(driver.findElement(By.id("ja-label1")).getText()).isEqualTo("ラベル1");
        assertThat(driver.findElement(By.id("ja-code2")).getText()).isEqualTo("key2");
        assertThat(driver.findElement(By.id("ja-label2")).getText()).isEqualTo("ラベル2");
        assertThat(driver.findElement(By.id("ja-code3")).getText()).isEqualTo("key3");
        assertThat(driver.findElement(By.id("ja-label3")).getText()).isEqualTo("ラベル3");
    }

    private void assertTest12Changed() {
        assertThat(driver.findElement(By.id("cl-code1")).getText()).isEqualTo("aaa");
        assertThat(driver.findElement(By.id("cl-label1")).getText()).isEqualTo("bbb");
        assertThat(driver.findElement(By.id("cl-code2")).getText()).isEqualTo("key2");
        assertThat(driver.findElement(By.id("cl-label2")).getText()).isEqualTo("label2");
        assertThat(driver.findElement(By.id("cl-code3")).getText()).isEqualTo("key3");
        assertThat(driver.findElement(By.id("cl-label3")).getText()).isEqualTo("label3");

        assertThat(driver.findElement(By.id("en-code1")).getText()).isEqualTo("aaa");
        assertThat(driver.findElement(By.id("en-label1")).getText()).isEqualTo("bbb");
        assertThat(driver.findElement(By.id("en-code2")).getText()).isEqualTo("key2");
        assertThat(driver.findElement(By.id("en-label2")).getText()).isEqualTo("label2");
        assertThat(driver.findElement(By.id("en-code3")).getText()).isEqualTo("key3");
        assertThat(driver.findElement(By.id("en-label3")).getText()).isEqualTo("label3");

        assertThat(driver.findElement(By.id("ja-code1")).getText()).isEqualTo("aaa");
        assertThat(driver.findElement(By.id("ja-label1")).getText()).isEqualTo("ＣＣＣ");
        assertThat(driver.findElement(By.id("ja-code2")).getText()).isEqualTo("key2");
        assertThat(driver.findElement(By.id("ja-label2")).getText()).isEqualTo("ラベル2");
        assertThat(driver.findElement(By.id("ja-code3")).getText()).isEqualTo("key3");
        assertThat(driver.findElement(By.id("ja-label3")).getText()).isEqualTo("ラベル3");
    }

    @Test
    public void test07_01_form() {
        driver.findElement(By.id("codelist_07_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        assertThat(driver.findElement(By.id("list2")).getText()).isEqualTo("");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test07_03_form() {
        driver.findElement(By.id("codelist_07_03")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("ラベル1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("ラベル2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("ラベル3");
        assertThat(driver.findElement(By.id("list2")).getText()).isEqualTo("");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test10_01_form() {
        driver.findElement(By.id("codelist_10_01")).click();
        assertThat(driver.findElement(By.cssSelector("div>ul>li")).getText())
                .isEqualTo("Warn Message!!");
        assertThat(webDriverOperations.exists(By.tagName("option"))).isEqualTo(false);
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test10_02_form() {
        driver.findElement(By.id("codelist_10_02")).click();
        assertThat(driver.findElement(By.cssSelector("div>ul>li")).getText())
                .isEqualTo("Warn Message!!");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText())
                .isEqualTo("label1");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText())
                .isEqualTo("label2");
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText())
                .isEqualTo("label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("key1");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_01_form() {
        driver.findElement(By.id("codelist_08_01")).click();
        inputFieldAccessor.overrideValue(By.id("item1"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText()).isEqualTo("");
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1.errors")).getText())
                .isEqualTo("Does not exist in SAMPLE_CODELIST");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_02_form() {
        driver.findElement(By.id("codelist_08_02")).click();
        inputFieldAccessor.overrideValue(By.id("item2"), "a", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText()).isEqualTo("");
        inputFieldAccessor.overrideValue(By.id("item2"), "h", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item2.errors")).getText())
                .isEqualTo("Does not exist in CHARACTER_CODELIST");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_03_form() {
        driver.findElement(By.id("codelist_08_03")).click();
        inputFieldAccessor.overrideValue(By.id("item3"), "5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText()).isEqualTo("");
        inputFieldAccessor.overrideValue(By.id("item3"), "6", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item3.errors")).getText())
                .isEqualTo("Does not exist in NUMBER_CODELIST");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_04_form() {
        driver.findElement(By.id("codelist_08_04")).click();
        inputFieldAccessor.overrideValue(By.id("item4"), "5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText()).isEqualTo("");
        inputFieldAccessor.overrideValue(By.id("item4"), "6", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item4.errors")).getText())
                .isEqualTo("Does not exist in NUMBER_FORMATTED_CODELIST");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_05_form() {
        driver.findElement(By.id("codelist_08_05")).click();
        inputFieldAccessor.overrideValue(By.id("item5"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText()).isEqualTo("System Error...");
    }

    @Test
    public void test08_06_form() {
        driver.findElement(By.id("codelist_08_06")).click();
        inputFieldAccessor.overrideValue(By.id("item6"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item6.errors")).getText())
                .isEqualTo("Does not exist in SAMPLE_CODELIST");
        inputFieldAccessor.overrideValue(By.id("item6"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText()).isEqualTo("");
        driver.findElement(By.id("btn1")).click();
    }

    @Test
    public void test08_07_form() {
        driver.findElement(By.id("codelist_08_07")).click();
        inputFieldAccessor.overrideValue(By.id("item7"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item7.errors")).getText()).isEqualTo(
                "This is a custom message notifying that value doesn't exist in sample codelist");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_08_form() {
        driver.findElement(By.id("codelist_08_08")).click();
        inputFieldAccessor.overrideValue(By.id("item8"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item8.errors")).getText()).isEqualTo(
                "This message comes from extended codelist notifying that value doesn't exist in sample codelist");
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_09_form() {
        driver.findElement(By.id("codelist_08_09")).click();

        // not error occured
        inputFieldAccessor.overrideValue(By.id("item9"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText()).isEqualTo("");

        // sample multiple codelist error occured
        inputFieldAccessor.overrideValue(By.id("item9"), "key2", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item9.errors")).getText()).isEqualTo(
                "This is a custom message notifying that value doesn't exist in sample multiple codelist");

        // sample codelist error occured
        inputFieldAccessor.overrideValue(By.id("item9"), "key4", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item9.errors")).getText()).isEqualTo(
                "This is a custom message notifying that value doesn't exist in sample codelist");

        // sample multiple codelist and sample codelist error occured
        inputFieldAccessor.overrideValue(By.id("item9"), "key6", driver);
        driver.findElement(By.id("btn1")).click();
        assertNotSame(driver.findElement(By.id("item9.errors")).getText().indexOf(
                "This is a custom message notifying that value doesn't exist in sample codelist"),
                -1);
        assertNotSame(driver.findElement(By.id("item9.errors")).getText().indexOf(
                "This is a custom message notifying that value doesn't exist in sample multiple codelist"),
                -1);

        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_10_form() {
        driver.findElement(By.id("codelist_08_10")).click();

        // not error occured
        inputFieldAccessor.overrideValue(By.id("item1"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1Error")).getText()).isEqualTo("");
        assertThat(driver.findElement(By.id("item1Label")).getText()).isEqualTo("label1");

        // error occured
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1Error")).getText())
                .isEqualTo("Does not exist in CL_CODELIST08_08");
        assertThat(driver.findElement(By.id("item1Label")).getText()).isEqualTo("");
    }

    @Test
    public void test08_11_form() {
        // assert japanese message.
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.id("codelist_08_01")).click();
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1.errors")).getText())
                .isEqualTo("SAMPLE_CODELIST にありません");
    }

    @Test
    public void test09_01_form() {
        driver.findElement(By.id("codelist_09_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]")).getText())
                .isEqualTo("January");
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText())
                .isEqualTo("February");
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]")).getText())
                .isEqualTo("March");
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]")).getText())
                .isEqualTo("April");
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText())
                .isEqualTo("May");
        assertThat(driver.findElement(By.cssSelector("option[value=\"6\"]")).getText())
                .isEqualTo("June");
        assertThat(driver.findElement(By.cssSelector("option[value=\"7\"]")).getText())
                .isEqualTo("July");
        assertThat(driver.findElement(By.cssSelector("option[value=\"8\"]")).getText())
                .isEqualTo("August");
        assertThat(driver.findElement(By.cssSelector("option[value=\"9\"]")).getText())
                .isEqualTo("September");
        assertThat(driver.findElement(By.cssSelector("option[value=\"10\"]")).getText())
                .isEqualTo("October");
        assertThat(driver.findElement(By.cssSelector("option[value=\"11\"]")).getText())
                .isEqualTo("November");
        assertThat(driver.findElement(By.cssSelector("option[value=\"12\"]")).getText())
                .isEqualTo("December");

        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("1");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("February");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("2");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("March");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("3");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("April");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("4");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("May");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("5");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("June");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("6");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("July");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("7");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("August");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("8");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("September");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("9");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("October");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("10");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("November");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("11");
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("December");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText()).isEqualTo("12");
        driver.findElement(By.id("btnback")).click();
    }
}
