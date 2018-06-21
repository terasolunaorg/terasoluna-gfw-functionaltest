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
package org.terasoluna.gfw.functionaltest.app.pagination;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class PaginationTest extends FunctionTestSupport {

    @Test
    public void test01_01_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_1")).click();

        // all page display check
        assertThat(driver.findElement(By.xpath("//li[3]/a")).getText(), is(
                "1"));
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText(), is(
                "2"));
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText(), is(
                "3"));

        // currentPage query check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[3]")).getText(),
                is("1"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        // screen capture
        screenCapture.save(driver);

        driver.findElement(By.linkText(">")).click();

        // move page 2 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("2"));

        screenCapture.save(driver);

        driver.findElement(By.linkText(">>")).click();

        // move page 3 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("3"));

        // screen capture
        screenCapture.save(driver);

    }

    @Test
    public void test01_02_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_2")).click();

        // all page display check
        for (int i = 1; i < 11; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber
                    + "]/a")).getText(), is(String.valueOf(i)));
        }

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        // screen capture
        screenCapture.save(driver);

        for (int i = 2; i < 11; i++) {
            driver.findElement(By.linkText(">")).click();
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);
        }
    }

    @Test
    public void test01_03_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_3")).click();

        // all page display check
        for (int i = 1; i < 11; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber
                    + "]/a")).getText(), is(String.valueOf(i)));
        }

        // 11 page no diplay
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText(), not(
                "11"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        driver.findElement(By.linkText("6")).click();

        // move page 6 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("6"));

        // all page display check
        for (int i = 1; i < 11; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber
                    + "]/a")).getText(), is(String.valueOf(i)));
        }

        driver.findElement(By.linkText("7")).click();

        // move page 7 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("7"));

        // all page display check
        for (int i = 2; i < 12; i++) {
            String elemnetNumber = String.valueOf(i + 1);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber
                    + "]/a")).getText(), is(String.valueOf(i)));
        }

        driver.findElement(By.linkText("<<")).click();

        for (int i = 1; i < 21; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test(expected = NoSuchElementException.class)
    public void test01_04_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_4")).click();

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // pagination no display
            driver.findElement(By.xpath("//li[3]/a"));
            fail("error route");
        } catch (NoSuchElementException e) {

            // screen capture
            screenCapture.save(driver);

            throw e;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void test01_05_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_5")).click();

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // pagination no display
            driver.findElement(By.xpath("//li[3]/a"));
            fail("error route");
        } catch (NoSuchElementException e) {

            // screen capture
            screenCapture.save(driver);

            throw e;
        }
    }

    @Test
    public void test01_06_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_6")).click();

        // firstLink disabled
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, 'javascript:void(0)')]")).getText(), is(
                        "<<"));
        // previousLink disabled
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")).getText(),
                is("<"));
        // nextLink active
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=1&size=10')])[2]")).getText(), is(
                        ">"));
        // lastLink active
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=2&size=10')])[2]")).getText(), is(
                        ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_07_test_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_7")).click();

        driver.findElement(By.linkText("2")).click();

        // firstLink active
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=0&size=10')]")).getText(), is(
                        "<<"));
        // previousLink active
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=0&size=10')])[2]")).getText(), is(
                        "<"));
        // nextLink active
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=2&size=10')])[2]")).getText(), is(
                        ">"));
        // lastLink active
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=2&size=10')])[3]")).getText(), is(
                        ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("2"));

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_08_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_8")).click();

        driver.findElement(By.linkText("3")).click();

        // firstLink active
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=0&size=10')]")).getText(), is(
                        "<<"));
        // previousLink active
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=1&size=10')]")).getText(), is("<"));
        // current page disabled
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, 'javascript:void(0)')]")).getText(), is(
                        "3"));
        // nextLink disabled
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")).getText(),
                is(">"));
        // lastLink disabled
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[3]")).getText(),
                is(">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("3"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is(">"));

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_09_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_9")).click();

        driver.findElement(By.linkText("3")).click();

        // firstLink active
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=0&size=15')]")).getText(), is(
                        "<<"));
        // previousLink active
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=1&size=15')]")).getText(), is("<"));
        // nextLink disabled
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=3&size=15')])[2]")).getText(), is(
                        ">"));
        // lastLink disabled
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=19&size=15')]")).getText(), is(
                        ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText(), is(
                ">>"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("3"));

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 21; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test01_10_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_10")).click();

        driver.findElement(By.linkText("10")).click();
        driver.findElement(By.linkText("13")).click();

        // firstLink active
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=0&size=15')]")).getText(), is(
                        "<<"));
        // previousLink active
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=11&size=15')]")).getText(), is(
                        "<"));
        // nextLink disabled
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=13&size=15')])[2]")).getText(), is(
                        ">"));
        // lastLink disabled
        assertThat(driver.findElement(By.xpath(
                "//a[contains(@href, '?page=19&size=15')]")).getText(), is(
                        ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText(), is(
                ">>"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("13"));

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 21; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_11_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_11")).click();

        // default page
        String orgXtrack = driver.findElement(By.id("xtrack")).getText();

        // firstLink disabled click
        driver.findElement(By.linkText("<<")).click();
        String firstLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(firstLinkXtrack, is(orgXtrack));

        // previousLink disabled click
        driver.findElement(By.linkText("<")).click();
        String previousLinkXtrack = driver.findElement(By.id("xtrack"))
                .getText();
        // not change xtrack
        assertThat(previousLinkXtrack, is(orgXtrack));

        // currentPage(1Page) active click
        driver.findElement(By.linkText("<")).click();
        String currentPageXtrack = driver.findElement(By.id("xtrack"))
                .getText();
        // not change xtrack
        assertThat(currentPageXtrack, is(orgXtrack));

        // nextLink click
        driver.findElement(By.linkText(">")).click();
        String nextLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // change xtrack
        assertThat(nextLinkXtrack, is(not(orgXtrack)));
    }

    @Test
    public void test02_01_pathTmplSpecified() {
        driver.findElement(By.id("pathTmplSpecified_2_1")).click();

        // current page url path
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[3]/a")).getAttribute("href"), is(
                        "javascript:void(0)"));

        // change url path
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[4]/a")).getAttribute("href"), is(
                        serverUrl + "/" + contextName
                                + "/pagination/2_1?page=1&size=100"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test03_01_queryTmplSpecified() {
        driver.findElement(By.id("queryTmplSpecified_3_1")).click();

        // current page query value
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[3]/a")).getAttribute("href"), is(
                        "javascript:void(0)"));

        // change query value
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[4]/a")).getAttribute("href"), is(
                        serverUrl + "/" + contextName
                                + "/pagination/3_1?page=1&size=100&sort=firstname,DESC"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test04_01_maxDisplayCountSpecified() {
        driver.findElement(By.id("maxDisplayCountSpecified_4_1")).click();

        // all page display check
        for (int i = 1; i < 21; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber
                    + "]/a")).getText(), is(String.valueOf(i)));
        }

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[23]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[24]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        driver.findElement(By.linkText("11")).click();

        // move page 11 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("11"));

        // all page display check
        for (int i = 1; i < 21; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber
                    + "]/a")).getText(), is(String.valueOf(i)));
        }

        driver.findElement(By.linkText("12")).click();

        // move page 12 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("12"));

        // all page display check
        for (int i = 2; i < 21; i++) {
            String elemnetNumber = String.valueOf(i + 1);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber
                    + "]/a")).getText(), is(String.valueOf(i)));
        }

        driver.findElement(By.linkText("<<")).click();

        for (int i = 1; i < 31; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test(expected = NoSuchElementException.class)
    public void test04_02_maxDisplayCountSpecified() {
        driver.findElement(By.id("maxDisplayCountSpecified_4_2")).click();

        // all page display check not page number link
        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[3]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText(), is(
                ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[2]")), notNullValue());

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // "active" class check
            driver.findElement(By.cssSelector("li.active > a"));
            fail("error route");
        } catch (NoSuchElementException e) {

            for (int i = 1; i < 31; i++) {
                // active page number check
                assertThat(driver.findElement(By.xpath("//h1[2]")).getText(),
                        is(String.valueOf(i) + " Page"));
                // screen capture
                screenCapture.save(driver);

                driver.findElement(By.linkText(">")).click();
            }

            throw e;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void test04_03_maxDisplayCountSpecified() {
        driver.findElement(By.id("maxDisplayCountSpecified_4_3")).click();

        // all page display check not page number link
        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[3]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText(), is(
                ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[2]")), notNullValue());

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // "active" class check
            driver.findElement(By.cssSelector("li.active > a"));
            fail("error route");
        } catch (NoSuchElementException e) {

            for (int i = 1; i < 31; i++) {
                // active page number check
                assertThat(driver.findElement(By.xpath("//h1[2]")).getText(),
                        is(String.valueOf(i) + " Page"));
                // screen capture
                screenCapture.save(driver);

                driver.findElement(By.linkText(">")).click();
            }

            throw e;
        }
    }

    @Test
    public void test05_01_outerElementSpecified() {
        driver.findElement(By.id("outerElementSpecified_5_1")).click();

        // HTML tags outside "<div>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/div")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/div/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test06_01_innerElementSpecified() {
        driver.findElement(By.id("innerElementSpecified_6_1")).click();

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/div[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//div[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//div[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//div[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//div[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("div.active")).getText(),
                is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("div.disabled")).getText(),
                is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test07_01_firstLinkTextSpecified() {
        driver.findElement(By.id("firstLinkTextSpecified_7_1")).click();

        // first link value "*"
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "first"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("first"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test07_02_firstLinkTextSpecified() {
        driver.findElement(By.id("firstLinkTextSpecified_7_2")).click();

        // firstLink no display
        // previousLink, nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "1"));
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[1]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test08_01_previousLinkTextSpecified() {
        driver.findElement(By.id("previousLinkTextSpecified_8_1")).click();

        // Previous Link value "*"
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "prev"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test08_02_previousLinkTextSpecified() {
        driver.findElement(By.id("previousLinkTextSpecified_8_2")).click();

        // previousLink no display
        // firstLink, nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "1"));
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // firstLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[1]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test09_01_nextLinkTextSpecified() {
        driver.findElement(By.id("nextLinkTextSpecified_9_1")).click();

        // Next Link value "*"
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                "next"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText("next")).click();
        }

    }

    @Test
    public void test09_02_nextLinkTextSpecified() {
        driver.findElement(By.id("nextLinkTextSpecified_9_2")).click();

        // nextLink no display
        // firstLink, previousLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText(), is(
                "3"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">>"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[1]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            driver.findElement(By.linkText(String.valueOf(i))).click();
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);
        }
    }

    @Test
    public void test10_01_lastLinkTextSpecified() {
        driver.findElement(By.id("lastLinkTextSpecified_10_1")).click();

        // Last Link value "*"
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                "last"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, firstLink, nextLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test(expected = NoSuchElementException.class)
    public void test10_02_lastLinkTextSpecified() {
        driver.findElement(By.id("lastLinkTextSpecified_10_2")).click();

        // lastLink no display
        // firstLink, previousLink, nextLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText(), is(
                "3"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[1]")), notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // no last link
            driver.findElement(By.xpath("//li[7]/a"));
            fail("error route");
        } catch (NoSuchElementException e) {
            // screen capture
            for (int i = 1; i < 4; i++) {
                // active page number check
                assertThat(driver.findElement(By.xpath("//h1[2]")).getText(),
                        is(String.valueOf(i) + " Page"));
                // screen capture
                screenCapture.save(driver);

                driver.findElement(By.linkText(">")).click();
            }

            throw e;
        }
    }

    @Test
    public void test11_01_disabledHrefSpecified() {
        driver.findElement(By.id("disabledHrefSpecified_11_1")).click();

        // firstLink, previousLink, current page value "#" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[1]/a")).getAttribute("href"), is(
                        serverUrl + "/" + contextName + "/pagination/11_1"
                                + "#"));
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[2]/a")).getAttribute("href"), is(
                        serverUrl + "/" + contextName + "/pagination/11_1"
                                + "#"));
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[3]/a")).getAttribute("href"), is(
                        serverUrl + "/" + contextName + "/pagination/11_1"
                                + "#"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        driver.findElement(By.linkText(">>")).click();

        // nextLink, lastLink value "#" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[1]")).getText(), is("3"));
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[2]")).getText(), is(">"));
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[3]")).getText(), is(">>"));

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test11_02_disabledHrefSpecified() {
        driver.findElement(By.id("disabledHrefSpecified_11_2")).click();

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, firstLink check (does not have anchor)
        assertThat(driver.findElement(By.xpath("//li[1]")).getText(), is("<<"));
        assertThat(driver.findElement(By.xpath("//li[2]")).getText(), is("<"));
        // nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active")).getText(),
                is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled")).getText(),
                is("<<"));

        driver.findElement(By.linkText(">>")).click();

        // nextLink, lastLink value check (does not have anchor)
        assertThat(driver.findElement(By.xpath("//li[6]")).getText(), is(">"));
        assertThat(driver.findElement(By.xpath("//li[7]")).getText(), is(">>"));

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i <= 3; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);
            if (i < 3) {
                driver.findElement(By.linkText(">")).click();
            }
        }
    }

    @Test
    public void test12_01_activeClassSpecified() {
        driver.findElement(By.id("activeClassSpecified_12_1")).click();

        // "active" class change "actv"
        assertThat(driver.findElement(By.cssSelector("li.actv > a")).getText(),
                is("1"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test12_02_activeClassSpecified() {
        driver.findElement(By.id("activeClassSpecified_12_2")).click();

        // "active" class change ""
        assertThat(driver.findElement(By.xpath("//li[contains(@class, '')][3]"))
                .getText(), is("1"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test13_01_disabledClassSpecified() {
        driver.findElement(By.id("disabledClassSpecified_13_1")).click();

        // firstLink, previousLink class="dis" check
        assertThat(driver.findElement(By.xpath(
                "//li[contains(@class, 'dis')][1]")).getText(), is("<<"));
        assertThat(driver.findElement(By.xpath(
                "//li[contains(@class, 'dis')][2]")).getText(), is("<"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test13_02_disabledClassSpecified() {
        driver.findElement(By.id("disabledClassSpecified_13_2")).click();

        // firstLink, previousLink class="dis" check
        assertThat(driver.findElement(By.xpath("//li[contains(@class, '')][1]"))
                .getText(), is("<<"));
        assertThat(driver.findElement(By.xpath("//li[contains(@class, '')][2]"))
                .getText(), is("<"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test14_01_pathQueryTmplCombination() {
        driver.findElement(By.id("pathQueryTmplCombination_14_1")).click();

        // change path value
        assertThat(driver.findElement(By.xpath("//a[contains(@href, '/"
                + contextName + "/pagination/14_1/1/100')]")).getAttribute(
                        "href"), is(serverUrl + "/" + contextName
                                + "/pagination/14_1/1/100"));
        // first page
        assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test15_01_outerInnerElementCombination() {
        driver.findElement(By.id("outerInnerElementCombination_15_1")).click();

        // HTML tags outside "<span>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/span[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//span[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//span[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//span[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//span[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("span.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("span.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void test16_01_firstLastLinkCombination() {
        driver.findElement(By.id("firstLastLinkCombination_16_1")).click();

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // firstLink, lastLink check, previousLink, nextLink, no display
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "first"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "1"));
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText(), is(
                "3"));
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText(), is(
                "last"));

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[2]")), notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("first"));

        driver.findElement(By.linkText("last")).click();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("3"));

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // "last link" no check
            driver.findElement(By.xpath("//li[6]/a"));
            fail("error route");
        } catch (NoSuchElementException e) {
            driver.findElement(By.linkText("first")).click();
            for (int i = 1; i < 4; i++) {
                driver.findElement(By.linkText(String.valueOf(i))).click();
                // active page number check
                assertThat(driver.findElement(By.xpath("//h1[2]")).getText(),
                        is(String.valueOf(i) + " Page"));
                // screen capture
                screenCapture.save(driver);
            }

            throw e;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void test16_02_firstLastLinkCombination() {
        driver.findElement(By.id("firstLastLinkCombination_16_2")).click();

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // firstLink, lastLink, previousLink, nextLink, no display
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "1"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "2"));
        assertThat(driver.findElement(By.xpath("//li[3]/a")).getText(), is(
                "3"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // "last link" no check
            driver.findElement(By.xpath("//li[4]/a"));
            fail("error route");
        } catch (NoSuchElementException e) {

            for (int i = 1; i < 4; i++) {
                driver.findElement(By.linkText(String.valueOf(i))).click();
                // active page number check
                assertThat(driver.findElement(By.xpath("//h1[2]")).getText(),
                        is(String.valueOf(i) + " Page"));
                // screen capture
                screenCapture.save(driver);
            }

            throw e;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void test17_01_previousNextLinkCombination() {
        driver.findElement(By.id("previousNextLinkCombination_17_1")).click();

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink check, firstLink, lastLink no display
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "prev"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "1"));
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText(), is(
                "3"));
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText(), is(
                "next"));

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[2]")), notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("prev"));

        driver.findElement(By.linkText("next")).click();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("2"));

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // "last link" no check
            driver.findElement(By.xpath("//li[6]/a"));
            fail("error route");
        } catch (NoSuchElementException e) {

            driver.findElement(By.linkText("1")).click();
            for (int i = 1; i < 4; i++) {
                // active page number check
                assertThat(driver.findElement(By.xpath("//h1[2]")).getText(),
                        is(String.valueOf(i) + " Page"));
                // screen capture
                screenCapture.save(driver);

                driver.findElement(By.linkText("next")).click();
            }

            throw e;
        }
    }

    @Test
    public void test18_01_outerElementClassSpecified() {
        driver.findElement(By.id("outerElementClassSpecified_18_1")).click();

        // HTML tags outside class "rightPosition" check
        assertThat(driver.findElement(By.xpath(
                "//ul[contains(@class, 'rightPosition')][1]")).getTagName(), is(
                        "ul"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[2]/ul/li[1]")), notNullValue());

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "<<"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "<"));
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText(), is(
                ">"));
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText(), is(
                ">>"));

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, 'javascript:void(0)')])[2]")),
                notNullValue());

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a"))
                .getText(), is("1"));

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("<<"));

        for (int i = 1; i < 4; i++) {
            // active page number check
            assertThat(driver.findElement(By.xpath("//h1[2]")).getText(), is(
                    String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void test19_01_screenDrawing() {
        driver.findElement(By.id("screenDrawing_19_1")).click();

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/ul[2]")),
                notNullValue());
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/ul[2]/li[1]")),
                notNullValue());

        // previousLink, nextLink change, firstLink, lastLink no display check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText(), is(
                "prev"));
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText(), is(
                "next"));

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '#')])[1]")), notNullValue());

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a"))
                .getText(), is("prev"));

        driver.findElement(By.linkText("next")).click();
        driver.findElement(By.linkText("next")).click();

        // move page 3 page check
        assertThat(driver.findElement(By.xpath("//td")).getText(), is("201"));

        try {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            // "last link" no check
            driver.findElement(By.xpath("//li[3]/a"));
            fail("error route");
        } catch (NoSuchElementException e) {
            driver.findElement(By.linkText("prev")).click();
            driver.findElement(By.linkText("prev")).click();
            for (int i = 1; i < 4; i++) {
                // active page number check
                assertThat(driver.findElement(By.xpath("//h1[2]")).getText(),
                        is(String.valueOf(i) + " Page"));
                // screen capture
                screenCapture.save(driver);

                driver.findElement(By.linkText("next")).click();
            }

            throw e;
        }
    }

    @Test
    public void test20_01_searchWithCriteriaQueryAndFQuery() {
        driver.findElement(By.id("search_20_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "201"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "210"));
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction"))
                    .findElement(By.linkText("3")).click();

            // assert 3 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "21"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "30"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "221"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "230"));
        }
        // move next page(4 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction"))
                    .findElement(By.linkText(">")).click();

            // assert 4 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "4"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "31"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "40"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "231"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "240"));
        }
        // move last page(10 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction"))
                    .findElement(By.linkText(">>")).click();

            // assert 10 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "91"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "291"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "300"));
        }
        // move previous page(9 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction"))
                    .findElement(By.linkText("<")).click();

            // assert 9 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "9"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "81"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "90"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "281"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "290"));
        }
        // move first page(1 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction"))
                    .findElement(By.linkText("<<")).click();

            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "201"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "210"));
        }

    }

    @Test
    public void test20_02_searchWithCriteriaQueryAndFU() {
        driver.findElement(By.id("search_20_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "201"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "210"));
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By
                    .linkText("3")).click();

            // assert 3 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "21"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "30"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "221"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "230"));
        }
        // move next page(4 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By
                    .linkText(">")).click();

            // assert 4 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "4"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "31"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "40"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "231"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "240"));
        }
        // move last page(10 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By
                    .linkText(">>")).click();

            // assert 10 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "91"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "291"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "300"));
        }
        // move previous page(9 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By
                    .linkText("<")).click();

            // assert 9 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "9"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "81"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "90"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "281"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "290"));
        }
        // move first page(1 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By
                    .linkText("<<")).click();

            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "201"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "210"));
        }
    }

    @Test
    public void test20_03_searchWithCriteriaQueryAndDisableHtmlEscapeOfCriteriaQueryIsFalse() {
        driver.findElement(By.id("search_20_3")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "<>\"'", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "181"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "190"));
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id(
                    "paginationDisableHtmlEscapeOfCriteriaQueryIsFalse"))
                    .findElement(By.linkText("2")).click();

            // assert 3 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "11"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "191"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "200"));
        }
    }

    @Test
    public void test20_04_searchWithCriteriaQueryAndDisableHtmlEscapeByFQueryFunctionOfCriteriaQueryIsTrue() {
        driver.findElement(By.id("search_20_4")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "<>\"'", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "181"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "190"));
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id(
                    "paginationDisableHtmlEscapeByFQueryFunctionOfCriteriaQueryIsTrue"))
                    .findElement(By.linkText("2")).click();

            // assert 3 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "11"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "191"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "200"));
        }
    }

    @Test
    public void test20_05_searchWithCriteriaQueryAndDisableHtmlEscapeByFUFunctionOfCriteriaQueryIsTrue() {
        driver.findElement(By.id("search_20_4")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "<>\"'", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "181"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "190"));
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id(
                    "paginationDisableHtmlEscapeByFUFunctionOfCriteriaQueryIsTrue"))
                    .findElement(By.linkText("2")).click();

            // assert 3 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "11"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "191"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "200"));
        }
    }

    @Test
    public void test21_01_searchWithPathTmplAndCriteriaQueryByFQueryFunction() {
        driver.findElement(By.id("search_21_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "201"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "210"));
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("3")).click();
            // assert 3 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "21"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "30"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "221"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "230"));

            // wait
            driver.findElement(By.tagName("body"));

            // check include "/terasoluna-gfw-functionaltest-web/pagination/21_1/{page}/{size}" in URL.
            assertTrue(driver.getCurrentUrl().contains(
                    "/terasoluna-gfw-functionaltest-web/pagination/21_1/2/10"));

            // check output of <f:query>.
            WebElement fqueryElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 5) {
                    continue;
                }
                assertTrue(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href").endsWith(
                                "name=%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver), is(
                    " &="));

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fuElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href"), fuElement.findElement(By
                                .xpath("ul/li[" + count + "]/a")).getAttribute(
                                        "href"));
            }
        }
    }

    @Test
    public void test21_02_searchWithPathTmplAndCriteriaQueryByFUFunction() {
        driver.findElement(By.id("search_21_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "201"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "210"));
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndCriteriaQueryAndFU"))
                    .findElement(By.linkText("3")).click();
            // assert 3 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "21"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "30"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "221"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "230"));

            // wait
            driver.findElement(By.tagName("body"));

            // check include "/terasoluna-gfw-functionaltest-web/pagination/21_1/{page}/{size}" in URL.
            assertTrue(driver.getCurrentUrl().contains(
                    "/terasoluna-gfw-functionaltest-web/pagination/21_1/2/10"));

            // check output of <f:u>.
            WebElement fuElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 5) {
                    continue;
                }
                assertTrue(fuElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href").endsWith(
                                "name=%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver), is(
                    " &="));

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fqueryElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href"), fuElement.findElement(By
                                .xpath("ul/li[" + count + "]/a")).getAttribute(
                                        "href"));
            }
        }
    }

    @Test
    public void test22_01_searchWithQueryTmplAndCriteriaQueryByFQueryFunction() {
        driver.findElement(By.id("search_22_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "300"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "291"));
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id(
                    "paginationCombinationOfQueryTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "11"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "290"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "281"));

            // wait
            driver.findElement(By.tagName("body"));

            // check include "?page=1&size=10&sort=personId,DESC" in URL.
            assertTrue(driver.getCurrentUrl().contains(
                    "?page=1&size=10&sort=personId,DESC"));

            // check output of <f:query>.
            WebElement fqueryElement = driver.findElement(By.id(
                    "paginationCombinationOfQueryTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 4) {
                    continue;
                }
                assertTrue(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href").endsWith(
                                "name=%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver), is(
                    " &="));

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fuElement = driver.findElement(By.id(
                    "paginationCombinationOfQueryTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href"), fuElement.findElement(By
                                .xpath("ul/li[" + count + "]/a")).getAttribute(
                                        "href"));
            }
        }
    }

    @Test
    public void test22_02_searchWithQueryTmplAndCriteriaQueryByFUFunction() {
        driver.findElement(By.id("search_22_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "300"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "291"));
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id(
                    "paginationCombinationOfQueryTmplAndCriteriaQueryAndFU"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "11"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "290"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "281"));
        }

        // wait
        driver.findElement(By.tagName("body"));

        // check include "?page=1&size=10&sort=personId,DESC" in URL.
        assertTrue(driver.getCurrentUrl().contains(
                "?page=1&size=10&sort=personId,DESC"));

        // check output of <f:u>.
        WebElement fuElement = driver.findElement(By.id(
                "paginationCombinationOfQueryTmplAndCriteriaQueryAndFU"));

        for (int count = 3; count <= 12; count++) {
            // skip current page
            if (count == 4) {
                continue;
            }
            assertTrue(fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                    .getAttribute("href").endsWith("name=%20%26%3D"));
        }

        // check search condition parameter.
        assertThat(inputFieldAccessor.getValue(By.id("name"), driver), is(
                " &="));

        // check output of <f:query> and <f:u> are the same URL.
        WebElement fqueryElement = driver.findElement(By.id(
                "paginationCombinationOfQueryTmplAndCriteriaQueryAndFQuery"));

        for (int count = 3; count <= 12; count++) {
            assertEquals(fqueryElement.findElement(By.xpath("ul/li[" + count
                    + "]/a")).getAttribute("href"), fuElement.findElement(By
                            .xpath("ul/li[" + count + "]/a")).getAttribute(
                                    "href"));
        }
    }

    @Test
    public void test23_01_searchWithQueryTmplAndCriteriaQueryByFQueryFunction() {
        driver.findElement(By.id("search_23_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "250"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "241"));
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "11"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "240"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "231"));

            // wait
            driver.findElement(By.tagName("body"));

            // check include "/terasoluna-gfw-functionaltest-web/pagination/23_1/{page}/{size}" in URL.
            assertTrue(driver.getCurrentUrl().contains(
                    "/terasoluna-gfw-functionaltest-web/pagination/23_1/1/10"));

            // check include "?page=1&size=10&sort=firstname,DESC" in URL.
            assertTrue(driver.getCurrentUrl().contains(
                    "?page=1&size=10&sort=firstname,DESC"));

            // check output of <f:query>.
            WebElement fqueryElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 4) {
                    continue;
                }
                assertTrue(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href").endsWith(
                                "name=%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver), is(
                    " &="));

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fuElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href"), fuElement.findElement(By
                                .xpath("ul/li[" + count + "]/a")).getAttribute(
                                        "href"));
            }
        }
    }

    @Test
    public void test23_02_searchWithQueryTmplAndCriteriaQueryByFUFunction() {
        driver.findElement(By.id("search_23_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), " &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "1"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "10"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "250"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "241"));
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            assertThat(driver.findElement(By.id("pagePosition")).getText(), is(
                    "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText(), is(
                    "11"));
            assertThat(driver.findElement(By.id("rangeEnd")).getText(), is(
                    "20"));
            assertThat(driver.findElement(By.id("totalResults")).getText(), is(
                    "100"));
            assertThat(driver.findElement(By.id("personId0")).getText(), is(
                    "240"));
            assertThat(driver.findElement(By.id("personId9")).getText(), is(
                    "231"));

            // wait
            driver.findElement(By.tagName("body"));

            // check include "/terasoluna-gfw-functionaltest-web/pagination/23_1/{page}/{size}" in URL.
            assertTrue(driver.getCurrentUrl().contains(
                    "/terasoluna-gfw-functionaltest-web/pagination/23_1/1/10"));

            // check include "?page=1&size=10&sort=firstname,DESC" in URL.
            assertTrue(driver.getCurrentUrl().contains(
                    "?page=1&size=10&sort=firstname,DESC"));

            // check output of <f:u>.
            WebElement fuElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                if (count == 4) {
                    continue;
                }
                assertTrue(fuElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href").endsWith(
                                "name=%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver), is(
                    " &="));

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fqueryElement = driver.findElement(By.id(
                    "paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(fqueryElement.findElement(By.xpath("ul/li[" + count
                        + "]/a")).getAttribute("href"), fuElement.findElement(By
                                .xpath("ul/li[" + count + "]/a")).getAttribute(
                                        "href"));
            }
        }
    }

    @Test
    public void test24_01_enableLinkOfCurrentPage() {
        driver.findElement(By.id("enableLinkOfCurrentPage_24_1")).click();

        // default page
        String orgXtrack = driver.findElement(By.id("xtrack")).getText();

        // currentPage(1Page) link check
        assertThat(driver.findElement(By.xpath(
                "(//a[contains(@href, '?page=0&size=15')])[1]")).getText(), is(
                        "1"));

        // currentPage(1Page) active click
        driver.findElement(By.linkText("1")).click();
        String currentPageXtrack = driver.findElement(By.id("xtrack"))
                .getText();
        // not change xtrack
        assertThat(currentPageXtrack, is(not(orgXtrack)));

    }

    @Test
    public void test25_01_disabledPageLinkWithJavaScript() {
        driver.findElement(By.id("disabledPageLinkWithJavaScript_25_1"))
                .click();

        // firstLink, previousLink, current page value "#" check
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[1]/a")).getAttribute("href"), is(
                        not("javascript:void(0)")));
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[2]/a")).getAttribute("href"), is(
                        not("javascript:void(0)")));
        assertThat(driver.findElement(By.xpath(
                "/html/body/div/div[1]/ul/li[3]/a")).getAttribute("href"), is(
                        not("javascript:void(0)")));

        // default page
        String orgXtrack = driver.findElement(By.id("xtrack")).getText();

        // firstLink disabled click
        driver.findElement(By.linkText("<<")).click();
        String firstLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(firstLinkXtrack, is(orgXtrack));

        // previousLink disabled click
        driver.findElement(By.linkText("<")).click();
        String previousLinkXtrack = driver.findElement(By.id("xtrack"))
                .getText();
        // not change xtrack
        assertThat(previousLinkXtrack, is(orgXtrack));

        // currentPage(1Page) active click
        driver.findElement(By.linkText("<")).click();
        String currentPageXtrack = driver.findElement(By.id("xtrack"))
                .getText();
        // not change xtrack
        assertThat(currentPageXtrack, is(orgXtrack));

        // nextLink click
        driver.findElement(By.linkText(">")).click();
        String nextLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // change xtrack
        assertThat(nextLinkXtrack, is(not(orgXtrack)));

    }

    @Test
    public void test26_01_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_26_1")).click();

        // outerElement close with </ul> confirm
        assertThat(driver.getPageSource().contains("<ul></ul>"), is(true));

        // page soruce
        pageSource.save(driver);
    }

}
