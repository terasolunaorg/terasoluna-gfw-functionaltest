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
package org.terasoluna.gfw.functionaltest.app.codelist;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class CodeListTest extends FunctionTestSupport {

    public CodeListTest() {
    }

    @Test
    public void test01_01_form() {
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key1"));
        driver.findElement(By.id("btnback")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "label2");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key2"));
        driver.findElement(By.id("btnback")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "label3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test01_02_form() {
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]/a")).click();
        assertThat(driver.findElement(By.id("item1")).getText(), is(""));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_01_form() {
        driver.findElement(By.xpath("//tbody/tr[3]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]"))
                .getText(), is("1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]"))
                .getText(), is("2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]"))
                .getText(), is("3"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]"))
                .getText(), is("4"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]"))
                .getText(), is("5"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_02_form() {
        driver.findElement(By.xpath("//tbody/tr[4]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]"))
                .getText(), is("5"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]"))
                .getText(), is("4"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]"))
                .getText(), is("3"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]"))
                .getText(), is("2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]"))
                .getText(), is("1"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("3");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_03_form() {
        driver.findElement(By.xpath("//tbody/tr[5]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]"))
                .getText(), is("5"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]"))
                .getText(), is("2"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText("5");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("5"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test02_04_form() {
        driver.findElement(By.xpath("//tbody/tr[6]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"005\"]"))
                .getText(), is("05"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"002\"]"))
                .getText(), is("02"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "05");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("005"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_01_form() {
        driver.findElement(By.xpath("//tbody/tr[7]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "label2");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key2"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_02_form() {
        driver.findElement(By.xpath("//tbody/tr[8]/td[1]/a")).click();
        assertThat(driver.findElement(By.id("item1")).getText(), is(""));
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test03_03_form() {
        driver.findElement(By.xpath("//tbody/tr[9]/td[1]/a")).click();
        assertThat(driver.findElement(By.id("exceptionCode")).getText(), is(
                "e.xx.9999"));
    }

    @Test
    public void test04_02_form() {
        driver.findElement(By.xpath("//tbody/tr[10]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.name("jdbcCodeListTestSelectCodeList")).click();
        driver.findElement(By.linkText("key2")).click();

        inputFieldAccessor.overrideValue(By.id("code"), "bbb", driver);
        inputFieldAccessor.overrideValue(By.id("value"), "aaa", driver);
        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.name("jdbcCodeListTestRefreshCodeList")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"bbb\"]"))
                .getText(), is("aaa"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.id("btnback")).click();

        // reverting the change to DB state
        driver.findElement(By.xpath("//tbody/tr[10]/td[1]/a")).click();
        driver.findElement(By.name("jdbcCodeListTestSelectCodeList")).click();
        driver.findElement(By.linkText("bbb")).click();
        inputFieldAccessor.overrideValue(By.id("code"), "key2", driver);
        inputFieldAccessor.overrideValue(By.id("value"), "label2", driver);

        driver.findElement(By.id("btn1")).click();
        driver.findElement(By.id("btn1")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"bbb\"]"))
                .getText(), is("aaa"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.name("jdbcCodeListTestRefreshCodeList")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_01_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.xpath("//tbody/tr[11]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_02_form() {
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.xpath("//tbody/tr[12]/td[1]/a")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("ラベル3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_03_form() {
        driver.findElement(By.linkText("French")).click();
        driver.findElement(By.xpath("//tbody/tr[13]/td[1]/a")).click();

        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("ラベル3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_04_form() {
        driver.findElement(By.linkText("French")).click();
        driver.findElement(By.xpath("//tbody/tr[14]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_05_form() {
        driver.findElement(By.linkText("Chinese")).click();
        driver.findElement(By.xpath("//tbody/tr[15]/td[1]/a")).click();
        assertThat(driver.findElement(By.id("item1")).getText(), is(""));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_06_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.xpath("//tbody/tr[16]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_07_form() {
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.xpath("//tbody/tr[17]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("ラベル3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_08_form() {
        driver.findElement(By.linkText("French")).click();
        driver.findElement(By.xpath("//tbody/tr[18]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("ラベル3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_09_form() {
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.xpath("//tbody/tr[19]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_10_form() {
        driver.findElement(By.linkText("Japanese")).click();
        driver.findElement(By.xpath("//tbody/tr[20]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("ラベル3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test06_11_form() {
        driver.findElement(By.linkText("French")).click();
        driver.findElement(By.xpath("//tbody/tr[21]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("ラベル3"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test07_01_form() {
        driver.findElement(By.xpath("//tbody/tr[22]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        assertThat(driver.findElement(By.id("list2")).getText(), is(""));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test07_03_form() {
        driver.findElement(By.xpath("//tbody/tr[23]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("ラベル1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("ラベル2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("ラベル3"));
        assertThat(driver.findElement(By.id("list2")).getText(), is(""));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_01_form() {
        driver.findElement(By.xpath("//tbody/tr[24]/td[1]/a")).click();
        inputFieldAccessor.overrideValue(By.id("item1"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1.errors")).getText(), is(
                "Does not exist in SAMPLE_CODELIST"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_02_form() {
        driver.findElement(By.xpath("//tbody/tr[25]/td[1]/a")).click();
        inputFieldAccessor.overrideValue(By.id("item2"), "a", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        inputFieldAccessor.overrideValue(By.id("item2"), "h", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item2.errors")).getText(), is(
                "Does not exist in CHARACTER_CODELIST"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_03_form() {
        driver.findElement(By.xpath("//tbody/tr[26]/td[1]/a")).click();
        inputFieldAccessor.overrideValue(By.id("item3"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "System Error..."));
    }

    @Test
    public void test08_04_form() {
        driver.findElement(By.xpath("//tbody/tr[27]/td[1]/a")).click();
        inputFieldAccessor.overrideValue(By.id("item4"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item4.errors")).getText(), is(
                "Does not exist in SAMPLE_CODELIST"));
        inputFieldAccessor.overrideValue(By.id("item4"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));
        driver.findElement(By.id("btn1")).click();
    }

    @Test
    public void test08_05_form() {
        driver.findElement(By.xpath("//tbody/tr[28]/td[1]/a")).click();
        inputFieldAccessor.overrideValue(By.id("item5"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item5.errors")).getText(), is(
                "This is a custom message notifying that value doesnt exist in sample codelist"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_06_form() {
        driver.findElement(By.xpath("//tbody/tr[29]/td[1]/a")).click();
        inputFieldAccessor.overrideValue(By.id("item6"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item6.errors")).getText(), is(
                "This message comes from extended codelist notifying that value doesnt exist in sample codelist"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_07_form() {
        driver.findElement(By.xpath("//tbody/tr[30]/td[1]/a")).click();

        // not error occured
        inputFieldAccessor.overrideValue(By.id("item7"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("errors")).getText(), is(""));

        // sample multiple codelist error occured
        inputFieldAccessor.overrideValue(By.id("item7"), "key2", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item7.errors")).getText(), is(
                "This is a custom message notifying that value doesnt exist in sample multiple codelist"));

        // sample codelist error occured
        inputFieldAccessor.overrideValue(By.id("item7"), "key4", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item7.errors")).getText(), is(
                "This is a custom message notifying that value doesnt exist in sample codelist"));

        // sample multiple codelist and sample codelist error occured
        inputFieldAccessor.overrideValue(By.id("item7"), "key6", driver);
        driver.findElement(By.id("btn1")).click();
        assertNotSame(driver.findElement(By.id("item7.errors")).getText()
                .indexOf(
                        "This is a custom message notifying that value doesnt exist in sample codelist"),
                -1);
        assertNotSame(driver.findElement(By.id("item7.errors")).getText()
                .indexOf(
                        "This is a custom message notifying that value doesnt exist in sample multiple codelist"),
                -1);

        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test08_08_form() {
        driver.findElement(By.xpath("//tbody/tr[31]/td[1]/a")).click();

        // not error occured
        inputFieldAccessor.overrideValue(By.id("item1"), "key1", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1Error")).getText(), is(""));
        assertThat(driver.findElement(By.id("item1Label")).getText(), is(
                "label1"));

        // error occured
        inputFieldAccessor.overrideValue(By.id("item1"), "key5", driver);
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("item1Error")).getText(), is(
                "Does not exist in CL_CODELIST08_08"));
        assertThat(driver.findElement(By.id("item1Label")).getText(), is(""));
    }

    @Test
    public void test09_01_form() {
        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"1\"]"))
                .getText(), is("January"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"2\"]"))
                .getText(), is("February"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"3\"]"))
                .getText(), is("March"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"4\"]"))
                .getText(), is("April"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"5\"]"))
                .getText(), is("May"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"6\"]"))
                .getText(), is("June"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"7\"]"))
                .getText(), is("July"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"8\"]"))
                .getText(), is("August"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"9\"]"))
                .getText(), is("September"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"10\"]"))
                .getText(), is("October"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"11\"]"))
                .getText(), is("November"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"12\"]"))
                .getText(), is("December"));

        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("1"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "February");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("2"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "March");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("3"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "April");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("4"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "May");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("5"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "June");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("6"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "July");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("7"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "August");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("8"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "September");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("9"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "October");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("10"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "November");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("11"));
        driver.findElement(By.id("btnback")).click();

        driver.findElement(By.xpath("//tbody/tr[32]/td[1]/a")).click();
        new Select(driver.findElement(By.id("item1"))).selectByVisibleText(
                "December");
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("12"));
        driver.findElement(By.id("btnback")).click();
    }

    @Test
    public void test10_01_form() {
        driver.findElement(By.xpath("//tbody/tr[33]/td[1]/a")).click();
        assertThat(driver.findElement(By.cssSelector("option[value=\"key1\"]"))
                .getText(), is("label1"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key2\"]"))
                .getText(), is("label2"));
        assertThat(driver.findElement(By.cssSelector("option[value=\"key3\"]"))
                .getText(), is("label3"));
        driver.findElement(By.id("btn1")).click();
        assertThat(driver.findElement(By.id("output")).getText(), is("key1"));
        driver.findElement(By.id("btnback")).click();
    }

}
