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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;
import org.terasoluna.gfw.functionaltest.config.SeleniumContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SeleniumContextConfig.class})
public class CodeListTest extends FunctionTestSupport {

    public CodeListTest() {}

    @Before
    public void setUpLocale() {
        driver.findElement(By.linkText("English")).click();
    }

    @Test
    public void test01_01_form() {
        driver.findElement(By.id("codelist_01_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key1"));
        driver.findElement(By.id("btnback")).click();
        driver.findElement(By.id("codelist_01_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("label2");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key2"));
        driver.findElement(By.id("btnback")).click();
        driver.findElement(By.id("codelist_01_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test01_02_form() {
        driver.findElement(By.id("codelist_01_02")).click();
        assertThat(driver.findElement(By.id("item1")).getText(), is(""));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_01_form() {
        driver.findElement(By.id("codelist_02_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]")).getText(), is("1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText(), is("2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]")).getText(), is("3"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]")).getText(), is("4"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText(), is("5"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_02_form() {
        driver.findElement(By.id("codelist_02_02")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText(), is("5"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]")).getText(), is("4"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]")).getText(), is("3"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText(), is("2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]")).getText(), is("1"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_03_form() {
        driver.findElement(By.id("codelist_02_03")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText(), is("5"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText(), is("2"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("5");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("5"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_04_form() {
        driver.findElement(By.id("codelist_02_04")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"005\"]")).getText(), is("05"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"002\"]")).getText(), is("02"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("05");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("005"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_01_form() {
        driver.findElement(By.id("codelist_03_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("label2");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key2"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_02_form() {
        driver.findElement(By.id("codelist_03_02")).click();
        assertThat(driver.findElement(By.id("item1")).getText(), is(""));
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_03_form() {
        driver.findElement(By.id("codelist_03_03")).click();
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is("e.xx.9999"));
    }

    @Test
    public void test04_02_form() {
        driver.findElement(By.id("codelist_04_02")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.name("jdbcCodeListTestSelectCodeList")).click();
        driver.findElement(By.linkText("key2")).click();

        inputFieldAccessor.overrideValue(By.id("code"), "bbb", driver);
        inputFieldAccessor.overrideValue(By.id("value"), "aaa", driver);
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.name("jdbcCodeListTestRefreshCodeList")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"bbb\"]")).getText(),
                is("aaa"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btnback")).click();

        // reverting the change to DB state
        driver.findElement(By.id("codelist_04_02")).click();
        driver.findElement(By.name("jdbcCodeListTestSelectCodeList")).click();
        driver.findElement(By.linkText("bbb")).click();
        inputFieldAccessor.overrideValue(By.id("code"), "key2", driver);
        inputFieldAccessor.overrideValue(By.id("value"), "label2", driver);

        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn1")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"bbb\"]")).getText(),
                is("aaa"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.name("jdbcCodeListTestRefreshCodeList")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_01_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_06_01")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key1"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_02_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_06_02")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key1"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_03_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_06_03")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key1"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_01_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.id("codelist_11_01")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_02_form() {
        driver.findElement(By.linkText("Canada(French)")).click();
        driver.findElement(By.id("codelist_11_02")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("étiquette1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("étiquette2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("étiquette3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_03_form() {
        driver.findElement(By.linkText("France")).click();
        driver.findElement(By.id("codelist_11_03")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("étiquette un"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("étiquette deux"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("étiquette trois"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test11_04_form() {
        driver.findElement(By.linkText("German")).click();
        driver.findElement(By.id("codelist_11_04")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("ラベル3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Ignore("It is not implemented because there is a possibility that the application startup may fail due "
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
        assertThat(driver.findElement(By.id("cl-code1")).getText(), is("key1"));
        assertThat(driver.findElement(By.id("cl-label1")).getText(), is("label1"));
        assertThat(driver.findElement(By.id("cl-code2")).getText(), is("key2"));
        assertThat(driver.findElement(By.id("cl-label2")).getText(), is("label2"));
        assertThat(driver.findElement(By.id("cl-code3")).getText(), is("key3"));
        assertThat(driver.findElement(By.id("cl-label3")).getText(), is("label3"));

        assertThat(driver.findElement(By.id("en-code1")).getText(), is("key1"));
        assertThat(driver.findElement(By.id("en-label1")).getText(), is("label1"));
        assertThat(driver.findElement(By.id("en-code2")).getText(), is("key2"));
        assertThat(driver.findElement(By.id("en-label2")).getText(), is("label2"));
        assertThat(driver.findElement(By.id("en-code3")).getText(), is("key3"));
        assertThat(driver.findElement(By.id("en-label3")).getText(), is("label3"));

        assertThat(driver.findElement(By.id("ja-code1")).getText(), is("key1"));
        assertThat(driver.findElement(By.id("ja-label1")).getText(), is("ラベル1"));
        assertThat(driver.findElement(By.id("ja-code2")).getText(), is("key2"));
        assertThat(driver.findElement(By.id("ja-label2")).getText(), is("ラベル2"));
        assertThat(driver.findElement(By.id("ja-code3")).getText(), is("key3"));
        assertThat(driver.findElement(By.id("ja-label3")).getText(), is("ラベル3"));
    }

    private void assertTest12Changed() {
        assertThat(driver.findElement(By.id("cl-code1")).getText(), is("aaa"));
        assertThat(driver.findElement(By.id("cl-label1")).getText(), is("bbb"));
        assertThat(driver.findElement(By.id("cl-code2")).getText(), is("key2"));
        assertThat(driver.findElement(By.id("cl-label2")).getText(), is("label2"));
        assertThat(driver.findElement(By.id("cl-code3")).getText(), is("key3"));
        assertThat(driver.findElement(By.id("cl-label3")).getText(), is("label3"));

        assertThat(driver.findElement(By.id("en-code1")).getText(), is("aaa"));
        assertThat(driver.findElement(By.id("en-label1")).getText(), is("bbb"));
        assertThat(driver.findElement(By.id("en-code2")).getText(), is("key2"));
        assertThat(driver.findElement(By.id("en-label2")).getText(), is("label2"));
        assertThat(driver.findElement(By.id("en-code3")).getText(), is("key3"));
        assertThat(driver.findElement(By.id("en-label3")).getText(), is("label3"));

        assertThat(driver.findElement(By.id("ja-code1")).getText(), is("aaa"));
        assertThat(driver.findElement(By.id("ja-label1")).getText(), is("ＣＣＣ"));
        assertThat(driver.findElement(By.id("ja-code2")).getText(), is("key2"));
        assertThat(driver.findElement(By.id("ja-label2")).getText(), is("ラベル2"));
        assertThat(driver.findElement(By.id("ja-code3")).getText(), is("key3"));
        assertThat(driver.findElement(By.id("ja-label3")).getText(), is("ラベル3"));
    }

    @Test
    public void test07_01_form() {
        driver.findElement(By.id("codelist_07_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        assertThat(driver.findElement(By.id("list2")).getText(), is(""));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test07_03_form() {
        driver.findElement(By.id("codelist_07_03")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("ラベル3"));
        assertThat(driver.findElement(By.id("list2")).getText(), is(""));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test10_01_form() {
        driver.findElement(By.id("codelist_10_01")).click();
        assertThat(driver.findElement(By.cssSelector("div>ul>li")).getText(), is("Warn Message!!"));
        assertThat(webDriverOperations.exists(By.tagName("option")), is(false));
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test10_02_form() {
        driver.findElement(By.id("codelist_10_02")).click();
        assertThat(driver.findElement(By.cssSelector("div>ul>li")).getText(), is("Warn Message!!"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]")).getText(),
                is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]")).getText(),
                is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]")).getText(),
                is("label3"));
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key1"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_01_form() {
        driver.findElement(By.id("codelist_08_01")).click();
        inputFieldAccessor.overrideValue(By.id("item1"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1.errors")).getText(),
                is("Does not exist in SAMPLE_CODELIST"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_02_form() {
        driver.findElement(By.id("codelist_08_02")).click();
        inputFieldAccessor.overrideValue(By.id("item2"), "a", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        inputFieldAccessor.overrideValue(By.id("item2"), "h", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item2.errors")).getText(),
                is("Does not exist in CHARACTER_CODELIST"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_03_form() {
        driver.findElement(By.id("codelist_08_03")).click();
        inputFieldAccessor.overrideValue(By.id("item3"), "5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        inputFieldAccessor.overrideValue(By.id("item3"), "6", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item3.errors")).getText(),
                is("Does not exist in NUMBER_CODELIST"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_04_form() {
        driver.findElement(By.id("codelist_08_04")).click();
        inputFieldAccessor.overrideValue(By.id("item4"), "5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        inputFieldAccessor.overrideValue(By.id("item4"), "6", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item4.errors")).getText(),
                is("Does not exist in NUMBER_FORMATTED_CODELIST"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_05_form() {
        driver.findElement(By.id("codelist_08_05")).click();
        inputFieldAccessor.overrideValue(By.id("item5"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("System Error..."));
    }

    @Test
    public void test08_06_form() {
        driver.findElement(By.id("codelist_08_06")).click();
        inputFieldAccessor.overrideValue(By.id("item6"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item6.errors")).getText(),
                is("Does not exist in SAMPLE_CODELIST"));
        inputFieldAccessor.overrideValue(By.id("item6"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        driver.findElement(By.id("btn1")).click();
    }

    @Test
    public void test08_07_form() {
        driver.findElement(By.id("codelist_08_07")).click();
        inputFieldAccessor.overrideValue(By.id("item7"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item7.errors")).getText(), is(
                "This is a custom message notifying that value doesn't exist in sample codelist"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_08_form() {
        driver.findElement(By.id("codelist_08_08")).click();
        inputFieldAccessor.overrideValue(By.id("item8"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item8.errors")).getText(), is(
                "This message comes from extended codelist notifying that value doesn't exist in sample codelist"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_09_form() {
        driver.findElement(By.id("codelist_08_09")).click();

        // not error occured
        inputFieldAccessor.overrideValue(By.id("item9"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));

        // sample multiple codelist error occured
        inputFieldAccessor.overrideValue(By.id("item9"), "key2", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item9.errors")).getText(), is(
                "This is a custom message notifying that value doesn't exist in sample multiple codelist"));

        // sample codelist error occured
        inputFieldAccessor.overrideValue(By.id("item9"), "key4", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item9.errors")).getText(), is(
                "This is a custom message notifying that value doesn't exist in sample codelist"));

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
        assertThat(driver.findElement(By.id("item1Error")).getText(), is(""));
        assertThat(driver.findElement(By.id("item1Label")).getText(), is("label1"));

        // error occured
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1Error")).getText(),
                is("Does not exist in CL_CODELIST08_08"));
        assertThat(driver.findElement(By.id("item1Label")).getText(), is(""));
    }

    @Test
    public void test08_11_form() {
        // assert japanese message.
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.id("codelist_08_01")).click();
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1.errors")).getText(),
                is("SAMPLE_CODELIST にありません"));
    }

    @Test
    public void test09_01_form() {
        driver.findElement(By.id("codelist_09_01")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]")).getText(),
                is("January"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]")).getText(),
                is("February"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]")).getText(),
                is("March"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]")).getText(),
                is("April"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]")).getText(), is("May"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"6\"]")).getText(), is("June"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"7\"]")).getText(), is("July"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"8\"]")).getText(),
                is("August"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"9\"]")).getText(),
                is("September"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"10\"]")).getText(),
                is("October"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"11\"]")).getText(),
                is("November"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"12\"]")).getText(),
                is("December"));

        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("1"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("February");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("2"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("March");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("3"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("April");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("4"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("May");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("5"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("June");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("6"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("July");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("7"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("August");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("8"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("September");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("9"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("October");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("10"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("November");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("11"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.id("codelist_09_01")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("December");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("12"));
        driver.findElement(By.id("btnback")).click();
    }
}
