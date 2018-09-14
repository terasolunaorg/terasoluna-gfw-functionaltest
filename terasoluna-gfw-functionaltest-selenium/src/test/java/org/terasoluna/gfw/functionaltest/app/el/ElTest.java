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
package org.terasoluna.gfw.functionaltest.app.el;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class ElTest extends FunctionTestSupport {

    private boolean acceptNextAlert = true;

    @Test
    public void test01_XSS_Measures() {

        driver.findElement(By.id("01")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "<script>alert(\"XSS Attack\")</script>", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 01_01 Test
        // It is an error if the dialog alert has gone out
        assertThat(driver.findElement(By.id("xssOutput")).getText(), is(
                "<script>alert(\"XSS Attack\")</script>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("01")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "<script>alert('XSS Attack')</script>", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 01_02 Test
        // It is an error if the dialog alert has gone out
        assertThat(driver.findElement(By.id("xssOutput")).getText(), is(
                "<script>alert('XSS Attack')</script>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("01")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "Spring Framework", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 01_03 Test
        assertThat(driver.findElement(By.id("xssOutput")).getText(), is(
                "Spring Framework"));
    }

    @Test
    public void test02_URL_Encoding() {

        driver.findElement(By.id("02")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "http://localhost:8080/spring?hl=ja&tab=Tw#hl=ja&q=あいうえお",
                driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 02_01 Test
        assertThat(driver.findElement(By.id("urlOutput")).getText(), is(
                "http://localhost:8080/spring?hl%3Dja%26tab%3DTw%23hl%3Dja%26q%3D%E3%81%82%E3%81%84%E3%81%86%E3%81%88%E3%81%8A"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("02")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "http://localhost:8080/spring", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 02_02 Test
        assertThat(driver.findElement(By.id("urlOutput")).getText(), is(
                "http://localhost:8080/spring"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("02")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"), "TEST[]#=&TEST",
                driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 02_03 Test
        assertThat(driver.findElement(By.id("urlOutput")).getText(), is(
                "TEST%5B%5D%23%3D%26TEST"));
    }

    @Test
    public void test03_New_Line() throws IOException {

        driver.findElement(By.id("03")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "Spring\nmvc\nspring mvc", driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 03_01 Test
        WebElement newLineOutput = driver.findElement(By.id("newLineOutput"));
        BufferedReader newLineOutputTextReader = new BufferedReader(new StringReader(newLineOutput
                .getText()));
        try {
            assertThat(newLineOutputTextReader.readLine(), is("Spring"));
            assertThat(newLineOutputTextReader.readLine(), is("mvc"));
            assertThat(newLineOutputTextReader.readLine(), is("spring mvc"));
            assertThat(newLineOutputTextReader.readLine(), nullValue());
        } finally {
            newLineOutputTextReader.close();
        }
        assertThat(newLineOutput.findElements(By.tagName("br")).size(), is(2));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("03")).click();

        inputFieldAccessor.overrideValue(By.id("text-output"), "Spring_Mvc",
                driver);
        driver.findElement(By.id("btn-output")).click();

        // output data 03_02 Test
        assertThat(driver.getPageSource().contains("Spring_Mvc"), is(true));
    }

    @Test
    public void test04_Cut_String() {

        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "SpringSpringSpringSpringSpringS", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_01 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(), is(
                "SpringSpringSpringSpringSpring"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "SpringSpringSpringSpringSprin", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_02 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(), is(
                "SpringSpringSpringSpringSprin"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "SpringSpringSpringSpringSpring", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_03 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(), is(
                "SpringSpringSpringSpringSpring"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("04")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "スプリングエムブイシー（ＳＰＲＩＮＧ　ＭＶＣ）、スプリングセキュリティー", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 04_04 Test
        assertThat(driver.findElement(By.id("cutOutput")).getText(), is(
                "スプリングエムブイシー（ＳＰＲＩＮＧ　ＭＶＣ）、スプリングセ"));
    }

    @Test
    public void test05_URL_Link() {

        driver.findElement(By.id("05")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "123456789http://example.com/tour/ 01234567890", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 05_01 Test
        assertThat(driver.findElement(By.id("linkOutput")).getText(), is(
                "123456789http://example.com/tour/ 01234567890"));
        // output link
        assertThat(driver.findElement(By.linkText("http://example.com/tour/"))
                .getText(), is("http://example.com/tour/"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("05")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "123456789https://example.com/tour/ 01234567890", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 05_02 Test
        assertThat(driver.findElement(By.id("linkOutput")).getText(), is(
                "123456789https://example.com/tour/ 01234567890"));
        // output link
        assertThat(driver.findElement(By.linkText("https://example.com/tour/"))
                .getText(), is("https://example.com/tour/"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("05_04")).click();
        inputFieldAccessor.overrideValue(By.id("text-outputQueryParam"),
                "tera&1", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 05_04 Test
        assertThat(driver.findElement(By.id("linkUOutput")).getText(), is(
                "http://localhost:8080/terasoluna-gfw-functionaltest-web/el/output_05_04?name=tera%261"));
        // output link
        assertThat(driver.findElement(By.linkText(
                "http://localhost:8080/terasoluna-gfw-functionaltest-web/el/output_05_04?name=tera%261"))
                .getText(), is(
                        "http://localhost:8080/terasoluna-gfw-functionaltest-web/el/output_05_04?name=tera%261"));
        // inheriting of query Test
        driver.navigate().to(applicationContextUrl
                + "/el/output_05_04?name=tera%261");
    }

    @Test(expected = NoSuchElementException.class)
    public void test05_URL_NO_Link() {

        driver.findElement(By.id("05")).click();
        inputFieldAccessor.overrideValue(By.id("text-output"),
                "123456789ttps://example.com/tour/ 01234567890", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 05_03 Test
        assertThat(driver.findElement(By.id("linkOutput")).getText(), is(
                "123456789ttps://example.com/tour/ 01234567890"));

        try {
            // No link
            driver.findElement(By.linkText("ttps://example.com/tour/"));
            fail("error route");
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    @Test
    public void test06_Query_Display() {

        driver.findElement(By.id("06_01-02")).click();

        // output 06_01-02 Test
        assertThat(driver.findElement(By.id("queryOutput")).getText(), is(
                "Date=Tue%20Oct%2001%2000:00:00%20JST%202013&String=Spring&int=100"));
        assertThat(driver.findElement(By.id("noAndQueryOutput")).getText(), is(
                "%26String=framework&Long=100&boolean=true&DateTime=10/1/13%2012:00%20AM"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();

        inputFieldAccessor.overrideValue(By.id("name"), "hoge", driver);
        new Select(driver.findElement(By.id("main"))).selectByVisibleText(
                "YES");
        inputFieldAccessor.overrideValue(By.id("age"), "10", driver);
        inputFieldAccessor.overrideValue(By.id("dateOfBirth"), "2000-01-01",
                driver);
        new Select(driver.findElement(By.id("countries"))).selectByVisibleText(
                "JA");
        driver.findElement(By.id("btn-output")).click();

        // output 06_03 Test
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=1&size=10&age=10&countries%5B0%5D=JA&dateOfBirth=2000-01-01&main=true&name=hoge')]"))
                .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();
        driver.findElement(By.id("btn-output")).click();

        // output 06_04 Test
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=1&size=10&age=0&countries=&_dateOfBirth=&main=false&name=')]"))
                .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();

        inputFieldAccessor.overrideValue(By.id("name"),
                "<script>alert('XSS Attack')</script>", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 06_05 Test
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, \"?page=1&size=10&age=0&countries=&_dateOfBirth=&main=false&name=%3Cscript%3Ealert('XSS%20Attack')%3C/script%3E\")]"))
                .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();

        inputFieldAccessor.overrideValue(By.id("name"), "あいうえお", driver);
        driver.findElement(By.id("btn-output")).click();

        // output 06_06 Test
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=1&size=10&age=0&countries=&_dateOfBirth=&main=false&name=%E3%81%82%E3%81%84%E3%81%86%E3%81%88%E3%81%8A')]"))
                .getText(), is("2"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_07")).click();

        // output 06_07 Test
        assertThat(driver.findElement(By.id("queryOutput")).getText(), is(""));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("06_03-")).click();

        inputFieldAccessor.overrideValue(By.id("name"), "TEST[]#=&TEST",
                driver);
        driver.findElement(By.id("btn-output")).click();

        // output 06_08 Test
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=1&size=10&age=0&countries=&_dateOfBirth=&main=false&name=TEST%5B%5D%23%3D%26TEST')]"))
                .getText(), is("2"));
    }

    @Test
    public void test06_09_NestedJavaBean() {
        driver.findElement(By.id("06_09")).click();

        inputFieldAccessor.overrideValue(By.id("criteria.name"), "yamada",
                driver);
        inputFieldAccessor.overrideValue(By.id("criteria.age"), "20", driver);
        inputFieldAccessor.overrideValue(By.id("rememberCriteria"), "true",
                driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_09 Test
        assertThat(driver.findElement(By.id("criteria.name")).getAttribute(
                "value"), is("yamada"));
        assertThat(driver.findElement(By.id("criteria.age")).getAttribute(
                "value"), is("20"));
        assertThat(driver.findElement(By.id("rememberCriteria")).getAttribute(
                "value"), is("true"));
    }

    @Test
    public void test06_10_ListOfJavaBean() {
        driver.findElement(By.id("06_10")).click();

        inputFieldAccessor.overrideValue(By.id("criteria0.name"), "yamada",
                driver);
        inputFieldAccessor.overrideValue(By.id("criteria0.age"), "20", driver);
        inputFieldAccessor.overrideValue(By.id("criteria1.name"), "tanaka",
                driver);
        inputFieldAccessor.overrideValue(By.id("criteria1.age"), "50", driver);
        inputFieldAccessor.overrideValue(By.id("operator"), "AND", driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_10 Test
        assertThat(driver.findElement(By.id("criteria0.name")).getAttribute(
                "value"), is("yamada"));
        assertThat(driver.findElement(By.id("criteria0.age")).getAttribute(
                "value"), is("20"));
        assertThat(driver.findElement(By.id("criteria1.name")).getAttribute(
                "value"), is("tanaka"));
        assertThat(driver.findElement(By.id("criteria1.age")).getAttribute(
                "value"), is("50"));
        assertThat(driver.findElement(By.id("operator")).getAttribute("value"),
                is("AND"));
    }

    @Test
    public void test06_11_SimpleJavaBeanAndListOfJavaBean() {
        driver.findElement(By.id("06_11")).click();

        inputFieldAccessor.overrideValue(By.id("criteria.name"), "suzuki",
                driver);
        inputFieldAccessor.overrideValue(By.id("criteria.age"), "30", driver);
        inputFieldAccessor.overrideValue(By.id("users0.name"), "yamada",
                driver);
        inputFieldAccessor.overrideValue(By.id("users0.age"), "20", driver);
        inputFieldAccessor.overrideValue(By.id("users1.name"), "tanaka",
                driver);
        inputFieldAccessor.overrideValue(By.id("users1.age"), "50", driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_11 Test
        assertThat(driver.findElement(By.id("criteria.name")).getAttribute(
                "value"), is("suzuki"));
        assertThat(driver.findElement(By.id("criteria.age")).getAttribute(
                "value"), is("30"));
        assertThat(driver.findElement(By.id("users0.name")).getAttribute(
                "value"), is("yamada"));
        assertThat(driver.findElement(By.id("users0.age")).getAttribute(
                "value"), is("20"));
        assertThat(driver.findElement(By.id("users1.name")).getAttribute(
                "value"), is("tanaka"));
        assertThat(driver.findElement(By.id("users1.age")).getAttribute(
                "value"), is("50"));
    }

    @Test
    public void test06_12_MapOfSimpleValue() {
        driver.findElement(By.id("06_12")).click();

        inputFieldAccessor.overrideValue(By.id("etcaaa"), "111", driver);
        inputFieldAccessor.overrideValue(By.id("etcbbb"), "222", driver);
        inputFieldAccessor.overrideValue(By.id("etcccc"), "333", driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_12 Test
        assertThat(driver.findElement(By.id("etcaaa")).getAttribute("value"),
                is("111"));
        assertThat(driver.findElement(By.id("etcbbb")).getAttribute("value"),
                is("222"));
        assertThat(driver.findElement(By.id("etcccc")).getAttribute("value"),
                is("333"));
    }

    @Test
    public void test06_13_DateTimeFormat() {
        driver.findElement(By.id("06_13")).click();

        inputFieldAccessor.overrideValue(By.id("date"), "2015-04-01", driver);
        inputFieldAccessor.overrideValue(By.id("localDate"), "2015-06-10",
                driver);
        inputFieldAccessor.overrideValue(By.id("item.date"), "2015-05-01",
                driver);
        inputFieldAccessor.overrideValue(By.id("item.localDate"), "2015-07-10",
                driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_13 Test
        assertThat(driver.findElement(By.id("date")).getAttribute("value"), is(
                "2015-04-01"));
        assertThat(driver.findElement(By.id("localDate")).getAttribute("value"),
                is("2015-06-10"));
        assertThat(driver.findElement(By.id("item.date")).getAttribute("value"),
                is("2015-05-01"));
        assertThat(driver.findElement(By.id("item.localDate")).getAttribute(
                "value"), is("2015-07-10"));
    }

    @Test
    public void test06_14_Array() {
        driver.findElement(By.id("06_14")).click();

        inputFieldAccessor.overrideValue(By.id("array10"), "1", driver);
        inputFieldAccessor.overrideValue(By.id("array11"), "2", driver);
        inputFieldAccessor.overrideValue(By.id("array12"), "3", driver);
        inputFieldAccessor.overrideValue(By.id("array20"), "1.1", driver);
        inputFieldAccessor.overrideValue(By.id("array21"), "1.2", driver);
        inputFieldAccessor.overrideValue(By.id("array30"), "4", driver);
        inputFieldAccessor.overrideValue(By.id("array31"), "5", driver);
        inputFieldAccessor.overrideValue(By.id("array32"), "6", driver);
        inputFieldAccessor.overrideValue(By.id("array40"), "a", driver);
        inputFieldAccessor.overrideValue(By.id("array41"), "b", driver);
        inputFieldAccessor.overrideValue(By.id("array42"), "c", driver);
        inputFieldAccessor.overrideValue(By.id("item.array10"), "11", driver);
        inputFieldAccessor.overrideValue(By.id("item.array11"), "12", driver);
        inputFieldAccessor.overrideValue(By.id("item.array12"), "13", driver);
        inputFieldAccessor.overrideValue(By.id("item.array20"), "11.1", driver);
        inputFieldAccessor.overrideValue(By.id("item.array21"), "11.2", driver);
        inputFieldAccessor.overrideValue(By.id("item.array30"), "14", driver);
        inputFieldAccessor.overrideValue(By.id("item.array31"), "15", driver);
        inputFieldAccessor.overrideValue(By.id("item.array32"), "16", driver);
        inputFieldAccessor.overrideValue(By.id("item.array40"), "d", driver);
        inputFieldAccessor.overrideValue(By.id("item.array41"), "e", driver);
        inputFieldAccessor.overrideValue(By.id("item.array42"), "f", driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_14 Test
        assertThat(driver.findElement(By.id("array10")).getAttribute("value"),
                is("1"));
        assertThat(driver.findElement(By.id("array11")).getAttribute("value"),
                is("2"));
        assertThat(driver.findElement(By.id("array12")).getAttribute("value"),
                is("3"));
        assertThat(driver.findElement(By.id("array20")).getAttribute("value"),
                is("1.1"));
        assertThat(driver.findElement(By.id("array21")).getAttribute("value"),
                is("1.2"));
        assertThat(driver.findElement(By.id("array30")).getAttribute("value"),
                is("4"));
        assertThat(driver.findElement(By.id("array31")).getAttribute("value"),
                is("5"));
        assertThat(driver.findElement(By.id("array32")).getAttribute("value"),
                is("6"));
        assertThat(driver.findElement(By.id("array40")).getAttribute("value"),
                is("a"));
        assertThat(driver.findElement(By.id("array41")).getAttribute("value"),
                is("b"));
        assertThat(driver.findElement(By.id("array42")).getAttribute("value"),
                is("c"));
        assertThat(driver.findElement(By.id("item.array10")).getAttribute(
                "value"), is("11"));
        assertThat(driver.findElement(By.id("item.array11")).getAttribute(
                "value"), is("12"));
        assertThat(driver.findElement(By.id("item.array12")).getAttribute(
                "value"), is("13"));
        assertThat(driver.findElement(By.id("item.array20")).getAttribute(
                "value"), is("11.1"));
        assertThat(driver.findElement(By.id("item.array21")).getAttribute(
                "value"), is("11.2"));
        assertThat(driver.findElement(By.id("item.array30")).getAttribute(
                "value"), is("14"));
        assertThat(driver.findElement(By.id("item.array31")).getAttribute(
                "value"), is("15"));
        assertThat(driver.findElement(By.id("item.array32")).getAttribute(
                "value"), is("16"));
        assertThat(driver.findElement(By.id("item.array40")).getAttribute(
                "value"), is("d"));
        assertThat(driver.findElement(By.id("item.array41")).getAttribute(
                "value"), is("e"));
        assertThat(driver.findElement(By.id("item.array42")).getAttribute(
                "value"), is("f"));
    }

    @Test
    public void test06_15_SimpleJavaBeanDefaultTrim() {
        driver.findElement(By.id("06_15")).click();

        inputFieldAccessor.overrideValue(By.id("name"), "", driver);
        inputFieldAccessor.overrideValue(By.id("age"), "", driver);

        inputFieldAccessor.overrideValue(By.id("item.name"), "", driver);
        inputFieldAccessor.overrideValue(By.id("item.age"), "", driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_15 Test
        assertThat(driver.findElement(By.id("name")).getAttribute("value"), is(
                ""));
        assertThat(driver.findElement(By.id("age")).getAttribute("value"), is(
                ""));

        assertThat(driver.findElement(By.id("item.name")).getAttribute("value"),
                is(""));
        assertThat(driver.findElement(By.id("item.age")).getAttribute("value"),
                is(""));

        assertThat(driver.findElement(By.id("nameString")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("ageString")).getText(), is(
                "null"));

        assertThat(driver.findElement(By.id("nameStringItem")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("ageStringItem")).getText(), is(
                "null"));
    }

    @Test
    public void test06_16_ListOfSimpleValueDefaultTrim() {
        driver.findElement(By.id("06_16")).click();

        inputFieldAccessor.overrideValue(By.id("listA0"), "", driver);
        inputFieldAccessor.overrideValue(By.id("listA1"), "", driver);
        inputFieldAccessor.overrideValue(By.id("listA2"), "", driver);
        driver.findElement(By.id("listB1")).click();
        driver.findElement(By.id("listB2")).click();
        driver.findElement(By.id("listB3")).click();
        Select select = new Select(driver.findElement(By.id("listC")));
        select.deselectAll();
        select.selectByValue("");

        inputFieldAccessor.overrideValue(By.id("item.listA0"), "", driver);
        inputFieldAccessor.overrideValue(By.id("item.listA1"), "", driver);
        inputFieldAccessor.overrideValue(By.id("item.listA2"), "", driver);
        driver.findElement(By.id("item.listB1")).click();
        driver.findElement(By.id("item.listB2")).click();
        driver.findElement(By.id("item.listB3")).click();
        Select selectItem = new Select(driver.findElement(By.id("item.listC")));
        selectItem.deselectAll();
        selectItem.selectByValue("");

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_16 Test
        assertThat(driver.findElement(By.id("listA0")).getAttribute("value"),
                is(""));
        assertThat(driver.findElement(By.id("listA1")).getAttribute("value"),
                is(""));
        assertThat(driver.findElement(By.id("listA2")).getAttribute("value"),
                is(""));
        assertThat(driver.findElement(By.id("listB1")).isSelected(), is(false));
        assertThat(driver.findElement(By.id("listB2")).isSelected(), is(false));
        assertThat(driver.findElement(By.id("listB3")).isSelected(), is(false));
        Select selectResult = new Select(driver.findElement(By.id("listC")));
        assertThat(selectResult.getAllSelectedOptions().size(), is(1));
        assertThat(selectResult.getFirstSelectedOption().getAttribute("value"),
                is(""));

        assertThat(driver.findElement(By.id("item.listA0")).getAttribute(
                "value"), is(""));
        assertThat(driver.findElement(By.id("item.listA1")).getAttribute(
                "value"), is(""));
        assertThat(driver.findElement(By.id("item.listA2")).getAttribute(
                "value"), is(""));
        assertThat(driver.findElement(By.id("item.listB1")).isSelected(), is(
                false));
        assertThat(driver.findElement(By.id("item.listB2")).isSelected(), is(
                false));
        assertThat(driver.findElement(By.id("item.listB3")).isSelected(), is(
                false));
        Select selectItemResult = new Select(driver.findElement(By.id(
                "item.listC")));
        assertThat(selectItemResult.getAllSelectedOptions().size(), is(1));
        assertThat(selectItemResult.getFirstSelectedOption().getAttribute(
                "value"), is(""));

        assertThat(driver.findElement(By.id("listA0String")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("listA1String")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("listA2String")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("listBString")).getText(), is(
                "[]"));
        assertThat(driver.findElement(By.id("listCString")).getText(), is(
                "[]"));

        assertThat(driver.findElement(By.id("listA0StringItem")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("listA1StringItem")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("listA2StringItem")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("listBStringItem")).getText(), is(
                "[]"));
        assertThat(driver.findElement(By.id("listCStringItem")).getText(), is(
                "[]"));
    }

    @Test
    public void test06_17_MapOfSimpleValueDefaultTrim() {
        driver.findElement(By.id("06_17")).click();

        inputFieldAccessor.overrideValue(By.id("mapAa"), "", driver);
        inputFieldAccessor.overrideValue(By.id("mapAb"), "", driver);
        inputFieldAccessor.overrideValue(By.id("mapAc"), "", driver);

        inputFieldAccessor.overrideValue(By.id("item.mapAd"), "", driver);
        inputFieldAccessor.overrideValue(By.id("item.mapAe"), "", driver);
        inputFieldAccessor.overrideValue(By.id("item.mapAf"), "", driver);

        driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.id("pagination")).findElement(By.linkText("2"))
                .click();

        // output 06_17 Test
        assertThat(driver.findElement(By.id("mapAa")).getAttribute("value"), is(
                ""));
        assertThat(driver.findElement(By.id("mapAb")).getAttribute("value"), is(
                ""));
        assertThat(driver.findElement(By.id("mapAc")).getAttribute("value"), is(
                ""));

        assertThat(driver.findElement(By.id("item.mapAd")).getAttribute(
                "value"), is(""));
        assertThat(driver.findElement(By.id("item.mapAe")).getAttribute(
                "value"), is(""));
        assertThat(driver.findElement(By.id("item.mapAf")).getAttribute(
                "value"), is(""));

        assertThat(driver.findElement(By.id("mapA0String")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("mapA1String")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("mapA2String")).getText(), is(
                "null"));

        assertThat(driver.findElement(By.id("mapA0StringItem")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("mapA1StringItem")).getText(), is(
                "null"));
        assertThat(driver.findElement(By.id("mapA2StringItem")).getText(), is(
                "null"));
    }

    @Test
    public void test07_JavaScript_XSS_Measures() {
        driver.findElement(By.id("07_01")).click();
        driver.findElement(By.id("write")).click();

        // output 07_01 Test
        assertThat(driver.findElement(By.id("message")).getText(), is(
                "<script></script><script>alert('XSS Attack');</script></script> <h2>JavaScript XSS Measures f:js()</h2>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("07_02")).click();
        driver.findElement(By.id("write")).click();

        // output 07_02 Test
        assertThat(driver.findElement(By.id("message")).getText(), is(
                "<script></script><script>alert(\"XSS Attack\");</script></script> <h2>JavaScript XSS Measures f:js()</h2>"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("07_03")).click();
        driver.findElement(By.id("write")).click();

        // output 07_03 Test
        assertThat(driver.findElement(By.id("message")).getText(), is(
                "<script>Spring Framework</script> <h2>JavaScript XSS Measures f:js()</h2>"));

    }

    @Test
    public void test08_EventHandler_XSS_Measures() {
        driver.findElement(By.id("08_01")).click();
        driver.findElement(By.id("write")).click();

        // output 08_01 Test
        assertThat(closeAlertAndGetItsText(), is(
                "input ');alert('XSS Attack');// . )"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("08_02")).click();
        driver.findElement(By.id("write")).click();

        // output 08_02 Test
        assertThat(closeAlertAndGetItsText(), is(
                "input ');alert(\"XSS Attack\");// . )"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("EL")).click();
        driver.findElement(By.id("08_03")).click();
        driver.findElement(By.id("write")).click();

        // output 08_03 Test
        assertThat(closeAlertAndGetItsText(), is("input Spring Framework"));

    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
