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
package org.terasoluna.gfw.functionaltest.app.pagination;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

public class PaginationTest extends FunctionTestSupport {

    @Test
    public void test01_01_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // all page display check
        assertThat(driver.findElement(By.xpath("//li[3]/a")).getText()).isEqualTo("1");
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText()).isEqualTo("2");
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText()).isEqualTo("3");

        // currentPage query check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[3]"))
                .getText()).isEqualTo("1");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        // screen capture
        screenCapture.save(driver);

        driver.findElement(By.linkText(">")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "2 Page"));

        // move page 2 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("2");

        screenCapture.save(driver);

        driver.findElement(By.linkText(">>")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "3 Page"));

        // move page 3 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("3");

        // screen capture
        screenCapture.save(driver);

    }

    @Test
    public void test01_02_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // all page display check
        for (int i = 1; i < 11; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber + "]/a")).getText())
                    .isEqualTo(String.valueOf(i));
        }

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        // screen capture
        screenCapture.save(driver);

        for (int i = 2; i < 11; i++) {
            driver.findElement(By.linkText(">")).click();
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);
        }
    }

    @Test
    public void test01_03_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_3")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // all page display check
        for (int i = 1; i < 11; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber + "]/a")).getText())
                    .isEqualTo(String.valueOf(i));
        }

        // 11 page no diplay
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText()).isNotEqualTo("11");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        driver.findElement(By.linkText("6")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "6 Page"));

        // move page 6 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("6");

        // all page display check
        for (int i = 1; i < 11; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber + "]/a")).getText())
                    .isEqualTo(String.valueOf(i));
        }

        driver.findElement(By.linkText("7")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "7 Page"));

        // move page 7 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("7");

        // all page display check
        for (int i = 2; i < 12; i++) {
            String elemnetNumber = String.valueOf(i + 1);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber + "]/a")).getText())
                    .isEqualTo(String.valueOf(i));
        }

        driver.findElement(By.linkText("<<")).click();

        for (int i = 1; i < 21; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test01_04_defaultSpecified() {

        driver.findElement(By.id("defaultSpecified_1_4")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // pagination no display
            driver.findElement(By.xpath("//li[3]/a"));
        });

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_05_defaultSpecified() {

        driver.findElement(By.id("defaultSpecified_1_5")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // pagination no display
            driver.findElement(By.xpath("//li[3]/a"));
        });

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test01_06_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_6")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // firstLink disabled
        assertThat(driver.findElement(By.xpath("//a[contains(@href, 'javascript:void(0)')]"))
                .getText()).isEqualTo("<<");
        // previousLink disabled
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]"))
                .getText()).isEqualTo("<");
        // nextLink active
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=1&size=10')])[2]"))
                .getText()).isEqualTo(">");
        // lastLink active
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=2&size=10')])[2]"))
                .getText()).isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_07_test_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_7")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        driver.findElement(By.linkText("2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "2 Page"));

        // firstLink active
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=0&size=10')]")).getText())
                        .isEqualTo("<<");
        // previousLink active
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=0&size=10')])[2]"))
                .getText()).isEqualTo("<");
        // nextLink active
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=2&size=10')])[2]"))
                .getText()).isEqualTo(">");
        // lastLink active
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=2&size=10')])[3]"))
                .getText()).isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("2");

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_08_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_8")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        driver.findElement(By.linkText("3")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "3 Page"));

        // firstLink active
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=0&size=10')]")).getText())
                        .isEqualTo("<<");
        // previousLink active
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=1&size=10')]")).getText())
                        .isEqualTo("<");
        // current page disabled
        assertThat(driver.findElement(By.xpath("//a[contains(@href, 'javascript:void(0)')]"))
                .getText()).isEqualTo("3");
        // nextLink disabled
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]"))
                .getText()).isEqualTo(">");
        // lastLink disabled
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[3]"))
                .getText()).isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("3");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo(">");

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_09_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_9")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        driver.findElement(By.linkText("3")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "3 Page"));

        // firstLink active
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=0&size=15')]")).getText())
                        .isEqualTo("<<");
        // previousLink active
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=1&size=15')]")).getText())
                        .isEqualTo("<");
        // nextLink disabled
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=3&size=15')])[2]"))
                .getText()).isEqualTo(">");
        // lastLink disabled
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=19&size=15')]")).getText())
                        .isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText()).isEqualTo(">>");

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("3");

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 21; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test01_10_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_10")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        driver.findElement(By.linkText("10")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "10 Page"));
        driver.findElement(By.linkText("13")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "13 Page"));

        // firstLink active
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=0&size=15')]")).getText())
                        .isEqualTo("<<");
        // previousLink active
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=11&size=15')]")).getText())
                        .isEqualTo("<");
        // nextLink disabled
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=13&size=15')])[2]"))
                .getText()).isEqualTo(">");
        // lastLink disabled
        assertThat(
                driver.findElement(By.xpath("//a[contains(@href, '?page=19&size=15')]")).getText())
                        .isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[13]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[14]/a")).getText()).isEqualTo(">>");

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("13");

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 21; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test01_11_defaultSpecified() {
        driver.findElement(By.id("defaultSpecified_1_11")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // default page
        String orgXtrack = driver.findElement(By.id("xtrack")).getText();

        // firstLink disabled click
        driver.findElement(By.linkText("<<")).click();
        String firstLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(firstLinkXtrack).isEqualTo(orgXtrack);

        // previousLink disabled click
        driver.findElement(By.linkText("<")).click();
        String previousLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(previousLinkXtrack).isEqualTo(orgXtrack);

        // currentPage(1Page) active click
        driver.findElement(By.linkText("<")).click();
        String currentPageXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(currentPageXtrack).isEqualTo(orgXtrack);

        // nextLink click
        driver.findElement(By.linkText(">")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "2 Page"));
        String nextLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // change xtrack
        assertThat(nextLinkXtrack).isNotEqualTo(orgXtrack);
    }

    @Test
    public void test02_01_pathTmplSpecified() {
        driver.findElement(By.id("pathTmplSpecified_2_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // current page url path
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[3]/a"))
                .getAttribute("href")).isEqualTo("javascript:void(0)");

        // change url path
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[4]/a"))
                .getAttribute("href")).isEqualTo(
                        serverUrl + "/" + contextName + "/pagination/2_1?page=1&size=100");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test03_01_queryTmplSpecified() {
        driver.findElement(By.id("queryTmplSpecified_3_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // current page query value
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[3]/a"))
                .getAttribute("href")).isEqualTo("javascript:void(0)");

        // change query value
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[4]/a"))
                .getAttribute("href"))
                        .isEqualTo(serverUrl + "/" + contextName
                                + "/pagination/3_1?page=1&size=100&sort=firstname,DESC");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));

            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test04_01_maxDisplayCountSpecified() {
        driver.findElement(By.id("maxDisplayCountSpecified_4_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // all page display check
        for (int i = 1; i < 21; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber + "]/a")).getText())
                    .isEqualTo(String.valueOf(i));
        }

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[23]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[24]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        driver.findElement(By.linkText("11")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "11 Page"));

        // move page 11 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("11");

        // all page display check
        for (int i = 1; i < 21; i++) {
            String elemnetNumber = String.valueOf(i + 2);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber + "]/a")).getText())
                    .isEqualTo(String.valueOf(i));
        }

        driver.findElement(By.linkText("12")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "12 Page"));

        // move page 12 page check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("12");

        // all page display check
        for (int i = 2; i < 21; i++) {
            String elemnetNumber = String.valueOf(i + 1);
            assertThat(driver.findElement(By.xpath("//li[" + elemnetNumber + "]/a")).getText())
                    .isEqualTo(String.valueOf(i));
        }

        driver.findElement(By.linkText("<<")).click();

        for (int i = 1; i < 31; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test04_02_maxDisplayCountSpecified() {

        driver.findElement(By.id("maxDisplayCountSpecified_4_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // all page display check not page number link
        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[3]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText()).isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]"))).isNotNull();

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // "active" class check
            driver.findElement(By.cssSelector("li.active > a"));
        });

        for (int i = 1; i < 31; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test05_01_outerElementSpecified() {
        driver.findElement(By.id("outerElementSpecified_5_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<div>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/div"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/div/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test06_01_innerElementSpecified() {
        driver.findElement(By.id("innerElementSpecified_6_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/div[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//div[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//div[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//div[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//div[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("div.active")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("div.disabled")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test07_01_firstLinkTextSpecified() {
        driver.findElement(By.id("firstLinkTextSpecified_7_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // first link value "*"
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("first");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText())
                .isEqualTo("first");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test07_02_firstLinkTextSpecified() {
        driver.findElement(By.id("firstLinkTextSpecified_7_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // firstLink no display
        // previousLink, nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("1");
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[1]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test08_01_previousLinkTextSpecified() {
        driver.findElement(By.id("previousLinkTextSpecified_8_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // Previous Link value "*"
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("prev");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test08_02_previousLinkTextSpecified() {
        driver.findElement(By.id("previousLinkTextSpecified_8_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // previousLink no display
        // firstLink, nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("1");
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // firstLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[1]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test09_01_nextLinkTextSpecified() {
        driver.findElement(By.id("nextLinkTextSpecified_9_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // Next Link value "*"
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo("next");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText("next")).click();
        }

    }

    @Test
    public void test09_02_nextLinkTextSpecified() {
        driver.findElement(By.id("nextLinkTextSpecified_9_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // nextLink no display
        // firstLink, previousLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText()).isEqualTo("3");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">>");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[1]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            driver.findElement(By.linkText(String.valueOf(i))).click();
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);
        }
    }

    @Test
    public void test10_01_lastLinkTextSpecified() {
        driver.findElement(By.id("lastLinkTextSpecified_10_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // Last Link value "*"
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo("last");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, firstLink, nextLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test10_02_lastLinkTextSpecified() {

        driver.findElement(By.id("lastLinkTextSpecified_10_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // lastLink no display
        // firstLink, previousLink, nextLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText()).isEqualTo("3");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[1]"))).isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // no last link
            driver.findElement(By.xpath("//li[7]/a"));
        });

        // screen capture
        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test11_01_disabledHrefSpecified() {
        driver.findElement(By.id("disabledHrefSpecified_11_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // firstLink, previousLink, current page value "#" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[1]/a"))
                .getAttribute("href"))
                        .isEqualTo(serverUrl + "/" + contextName + "/pagination/11_1" + "#");
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[2]/a"))
                .getAttribute("href"))
                        .isEqualTo(serverUrl + "/" + contextName + "/pagination/11_1" + "#");
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[3]/a"))
                .getAttribute("href"))
                        .isEqualTo(serverUrl + "/" + contextName + "/pagination/11_1" + "#");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        driver.findElement(By.linkText(">>")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "3 Page"));

        // nextLink, lastLink value "#" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[1]")).getText())
                .isEqualTo("3");
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]")).getText())
                .isEqualTo(">");
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[3]")).getText())
                .isEqualTo(">>");

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test11_02_disabledHrefSpecified() {
        driver.findElement(By.id("disabledHrefSpecified_11_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, firstLink check (does not have anchor)
        assertThat(driver.findElement(By.xpath("//li[1]")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]")).getText()).isEqualTo("<");
        // nextLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled")).getText()).isEqualTo("<<");

        driver.findElement(By.linkText(">>")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "3 Page"));

        // nextLink, lastLink value check (does not have anchor)
        assertThat(driver.findElement(By.xpath("//li[6]")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]")).getText()).isEqualTo(">>");

        driver.findElement(By.linkText("<<")).click();
        for (int i = 1; i <= 3; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
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
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // "active" class change "actv"
        assertThat(driver.findElement(By.cssSelector("li.actv > a")).getText()).isEqualTo("1");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test12_02_activeClassSpecified() {
        driver.findElement(By.id("activeClassSpecified_12_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // "active" class change ""
        assertThat(driver.findElement(By.xpath("//li[contains(@class, '')][3]")).getText())
                .isEqualTo("1");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test13_01_disabledClassSpecified() {
        driver.findElement(By.id("disabledClassSpecified_13_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // firstLink, previousLink class="dis" check
        assertThat(driver.findElement(By.xpath("//li[contains(@class, 'dis')][1]")).getText())
                .isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[contains(@class, 'dis')][2]")).getText())
                .isEqualTo("<");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test13_02_disabledClassSpecified() {
        driver.findElement(By.id("disabledClassSpecified_13_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // firstLink, previousLink class="dis" check
        assertThat(driver.findElement(By.xpath("//li[contains(@class, '')][1]")).getText())
                .isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[contains(@class, '')][2]")).getText())
                .isEqualTo("<");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test14_01_pathQueryTmplCombination() {
        driver.findElement(By.id("pathQueryTmplCombination_14_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // change path value
        assertThat(driver
                .findElement(By.xpath(
                        "//a[contains(@href, '/" + contextName + "/pagination/14_1/1/100')]"))
                .getAttribute("href"))
                        .isEqualTo(serverUrl + "/" + contextName + "/pagination/14_1/1/100");
        // first page
        assertThat(driver.findElement(By.xpath("//h1[2]")).getText()).isEqualTo("1 Page");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

    }

    @Test
    public void test15_01_outerInnerElementCombination() {
        driver.findElement(By.id("outerInnerElementCombination_15_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<span>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/span[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//span[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//span[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//span[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//span[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("span.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("span.disabled > a")).getText())
                .isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test16_01_firstLastLinkCombination() {

        driver.findElement(By.id("firstLastLinkCombination_16_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // firstLink, lastLink check, previousLink, nextLink, no display
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("first");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("1");
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText()).isEqualTo("3");
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText()).isEqualTo("last");

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]"))).isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText())
                .isEqualTo("first");

        driver.findElement(By.linkText("last")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "3 Page"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("3");

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // "last link" no check
            driver.findElement(By.xpath("//li[6]/a"));
        });

        driver.findElement(By.linkText("first")).click();
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.linkText(String.valueOf(i))).click();
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);
        }
    }

    @Test
    public void test16_02_firstLastLinkCombination() {

        driver.findElement(By.id("firstLastLinkCombination_16_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // firstLink, lastLink, previousLink, nextLink, no display
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("1");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("2");
        assertThat(driver.findElement(By.xpath("//li[3]/a")).getText()).isEqualTo("3");

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // "last link" no check
            driver.findElement(By.xpath("//li[4]/a"));
        });

        for (int i = 1; i < 4; i++) {
            driver.findElement(By.linkText(String.valueOf(i))).click();
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);
        }

    }

    @Test
    public void test17_01_previousNextLinkCombination() {

        driver.findElement(By.id("previousNextLinkCombination_17_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink check, firstLink, lastLink no display
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("prev");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("1");
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText()).isEqualTo("3");
        assertThat(driver.findElement(By.xpath("//li[5]/a")).getText()).isEqualTo("next");

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]"))).isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText())
                .isEqualTo("prev");

        driver.findElement(By.linkText("next")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "2 Page"));

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("2");

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // "last link" no check
            driver.findElement(By.xpath("//li[6]/a"));
        });

        driver.findElement(By.linkText("1")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText("next")).click();
        }
    }

    @Test
    public void test18_01_outerElementClassSpecified() {
        driver.findElement(By.id("outerElementClassSpecified_18_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside class "rightPosition" check
        assertThat(driver.findElement(By.xpath("//ul[contains(@class, 'rightPosition')][1]"))
                .getTagName()).isEqualTo("ul");

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test18_02_innerElementClassSpecified() {
        driver.findElement(By.id("innerElementClassSpecified_18_2")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // HTML tags inside class "enable" check
        assertThat(driver.findElement(By.cssSelector("li.enable > a")).getText()).isEqualTo("2");

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }
    }

    @Test
    public void test18_03_anchorClassSpecified() {
        driver.findElement(By.id("anchorClassSpecified_18_3")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[1]"))).isNotNull();

        // previousLink, nextLink, firstLink, lastLink check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("<<");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("<");
        assertThat(driver.findElement(By.xpath("//li[6]/a")).getText()).isEqualTo(">");
        assertThat(driver.findElement(By.xpath("//li[7]/a")).getText()).isEqualTo(">>");

        // previousLink value "javascript:void(0)" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, 'javascript:void(0)')])[2]")))
                .isNotNull();

        // "active" class check
        assertThat(driver.findElement(By.cssSelector("li.active > a")).getText()).isEqualTo("1");

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText()).isEqualTo("<<");

        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText(">")).click();
        }

        // All of HTML tags anchor class "link" check
        assertThat(driver.findElements(By.cssSelector("li > a.link")).size()).isEqualTo(14);
        assertThat(driver.findElements(By.cssSelector("li > a:not(.link)")).size()).isEqualTo(0);
    }

    @Test
    public void test19_01_screenDrawing() {

        driver.findElement(By.id("screenDrawing_19_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // HTML tags outside "<ul>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/ul[2]"))).isNotNull();
        // HTML tags inside "<li>" check
        assertThat(driver.findElement(By.xpath("/html/body/div/ul[2]/li[1]"))).isNotNull();

        // previousLink, nextLink change, firstLink, lastLink no display check
        assertThat(driver.findElement(By.xpath("//li[1]/a")).getText()).isEqualTo("prev");
        assertThat(driver.findElement(By.xpath("//li[2]/a")).getText()).isEqualTo("next");

        // previousLink value "#" check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '#')])[1]"))).isNotNull();

        // "disabled" class check
        assertThat(driver.findElement(By.cssSelector("li.disabled > a")).getText())
                .isEqualTo("prev");

        driver.findElement(By.linkText("next")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "2 Page"));
        driver.findElement(By.linkText("next")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "3 Page"));

        // move page 3 page check
        assertThat(driver.findElement(By.xpath("//td")).getText()).isEqualTo("201");

        assertThrows(NoSuchElementException.class, () -> {
            // Immediate time-out value set
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            // "last link" no check
            driver.findElement(By.xpath("//li[3]/a"));
        });

        driver.findElement(By.linkText("prev")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "2 Page"));
        driver.findElement(By.linkText("prev")).click();
        for (int i = 1; i < 4; i++) {
            // active page number check
            webDriverWait.until(textToBe(By.xpath("//h1[2]"), String.valueOf(i) + " Page"));
            // screen capture
            screenCapture.save(driver);

            driver.findElement(By.linkText("next")).click();
        }
    }

    @Test
    public void test20_01_searchWithCriteriaQueryAndFQuery() {
        driver.findElement(By.id("search_20_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("201");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("210");
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction")).findElement(By.linkText("3"))
                    .click();

            // assert 3 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("21");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("30");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("221");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("230");
        }
        // move next page(4 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction")).findElement(By.linkText(">"))
                    .click();

            // assert 4 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "4"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("31");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("40");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("231");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("240");
        }
        // move last page(10 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction")).findElement(By.linkText(">>"))
                    .click();

            // assert 10 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "10"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("91");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("291");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("300");
        }
        // move previous page(9 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction")).findElement(By.linkText("<"))
                    .click();

            // assert 9 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "9"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("81");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("90");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("281");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("290");
        }
        // move first page(1 page)
        {
            driver.findElement(By.id("paginationAndFQueryFunction")).findElement(By.linkText("<<"))
                    .click();

            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("201");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("210");
        }

    }

    @Test
    public void test20_02_searchWithCriteriaQueryAndFU() {
        driver.findElement(By.id("search_20_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("201");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("210");
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By.linkText("3"))
                    .click();

            // assert 3 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("21");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("30");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("221");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("230");
        }
        // move next page(4 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By.linkText(">"))
                    .click();

            // assert 4 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "4"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("31");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("40");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("231");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("240");
        }
        // move last page(10 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By.linkText(">>"))
                    .click();

            // assert 10 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "10"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("91");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("291");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("300");
        }
        // move previous page(9 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By.linkText("<"))
                    .click();

            // assert 9 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "9"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("81");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("90");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("281");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("290");
        }
        // move first page(1 page)
        {
            driver.findElement(By.id("paginationAndFUFunction")).findElement(By.linkText("<<"))
                    .click();

            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("201");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("210");
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
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("181");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("190");
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id("paginationDisableHtmlEscapeOfCriteriaQueryIsFalse"))
                    .findElement(By.linkText("2")).click();

            // assert 3 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("11");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("191");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("200");
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
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("181");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("190");
        }
        // move specified page(2 page)
        {
            driver.findElement(
                    By.id("paginationDisableHtmlEscapeByFQueryFunctionOfCriteriaQueryIsTrue"))
                    .findElement(By.linkText("2")).click();

            // assert 2 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("11");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("191");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("200");
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
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("181");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("190");
        }
        // move specified page(2 page)
        {
            driver.findElement(
                    By.id("paginationDisableHtmlEscapeByFUFunctionOfCriteriaQueryIsTrue"))
                    .findElement(By.linkText("2")).click();

            // assert 2 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("11");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("191");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("200");
        }
    }

    @Test
    public void test21_01_searchWithPathTmplAndCriteriaQueryByFQueryFunction() {
        driver.findElement(By.id("search_21_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("201");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("210");
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id("paginationCombinationOfPathTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("3")).click();
            // assert 3 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("21");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("30");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("221");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("230");

            // wait
            driver.findElement(By.tagName("body"));

            // check include
            // "/terasoluna-gfw-functionaltest-web/pagination/21_1/{page}/{size}" in
            // URL.
            assertTrue(driver.getCurrentUrl()
                    .contains("/terasoluna-gfw-functionaltest-web/pagination/21_1/2/10"));

            // check output of <f:query>.
            WebElement fqueryElement = driver
                    .findElement(By.id("paginationCombinationOfPathTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 5) {
                    continue;
                }
                assertTrue(fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                        .getAttribute("href").endsWith("name=%2B%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver)).isEqualTo("+ &=");

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fuElement = driver
                    .findElement(By.id("paginationCombinationOfPathTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(
                        fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"),
                        fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"));
            }
        }
    }

    @Test
    public void test21_02_searchWithPathTmplAndCriteriaQueryByFUFunction() {
        driver.findElement(By.id("search_21_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("201");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("210");
        }
        // move specified page(3 page)
        {
            driver.findElement(By.id("paginationCombinationOfPathTmplAndCriteriaQueryAndFU"))
                    .findElement(By.linkText("3")).click();
            // assert 3 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "3"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("21");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("30");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("221");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("230");

            // wait
            driver.findElement(By.tagName("body"));

            // check include
            // "/terasoluna-gfw-functionaltest-web/pagination/21_1/{page}/{size}" in
            // URL.
            assertTrue(driver.getCurrentUrl()
                    .contains("/terasoluna-gfw-functionaltest-web/pagination/21_1/2/10"));

            // check output of <f:u>.
            WebElement fuElement = driver
                    .findElement(By.id("paginationCombinationOfPathTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 5) {
                    continue;
                }
                assertTrue(fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                        .getAttribute("href").endsWith("name=%2B%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver)).isEqualTo("+ &=");

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fqueryElement = driver
                    .findElement(By.id("paginationCombinationOfPathTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(
                        fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"),
                        fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"));
            }
        }
    }

    @Test
    public void test22_01_searchWithQueryTmplAndCriteriaQueryByFQueryFunction() {
        driver.findElement(By.id("search_22_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("300");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("291");
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id("paginationCombinationOfQueryTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("11");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("290");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("281");

            // wait
            driver.findElement(By.tagName("body"));

            // check include "?page=1&size=10&sort=personId,DESC" in URL.
            assertTrue(driver.getCurrentUrl().contains("?page=1&size=10&sort=personId,DESC"));

            // check output of <f:query>.
            WebElement fqueryElement = driver.findElement(
                    By.id("paginationCombinationOfQueryTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 4) {
                    continue;
                }
                assertTrue(fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                        .getAttribute("href").endsWith("name=%2B%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver)).isEqualTo("+ &=");

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fuElement = driver
                    .findElement(By.id("paginationCombinationOfQueryTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(
                        fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"),
                        fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"));
            }
        }
    }

    @Test
    public void test22_02_searchWithQueryTmplAndCriteriaQueryByFUFunction() {
        driver.findElement(By.id("search_22_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("300");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("291");
        }
        // move specified page(2 page)
        {
            driver.findElement(By.id("paginationCombinationOfQueryTmplAndCriteriaQueryAndFU"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("11");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("290");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("281");
        }

        // wait
        driver.findElement(By.tagName("body"));

        // check include "?page=1&size=10&sort=personId,DESC" in URL.
        assertTrue(driver.getCurrentUrl().contains("?page=1&size=10&sort=personId,DESC"));

        // check output of <f:u>.
        WebElement fuElement =
                driver.findElement(By.id("paginationCombinationOfQueryTmplAndCriteriaQueryAndFU"));

        for (int count = 3; count <= 12; count++) {
            // skip current page
            if (count == 4) {
                continue;
            }
            assertTrue(fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                    .getAttribute("href").endsWith("name=%2B%20%26%3D"));
        }

        // check search condition parameter.
        assertThat(inputFieldAccessor.getValue(By.id("name"), driver)).isEqualTo("+ &=");

        // check output of <f:query> and <f:u> are the same URL.
        WebElement fqueryElement = driver
                .findElement(By.id("paginationCombinationOfQueryTmplAndCriteriaQueryAndFQuery"));

        for (int count = 3; count <= 12; count++) {
            assertEquals(
                    fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                            .getAttribute("href"),
                    fuElement.findElement(By.xpath("ul/li[" + count + "]/a")).getAttribute("href"));
        }
    }

    @Test
    public void test23_01_searchWithQueryTmplAndCriteriaQueryByFQueryFunction() {
        driver.findElement(By.id("search_23_1")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("250");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("241");
        }
        // move specified page(2 page)
        {
            driver.findElement(
                    By.id("paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("11");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("240");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("231");

            // wait
            driver.findElement(By.tagName("body"));

            // check include
            // "/terasoluna-gfw-functionaltest-web/pagination/23_1/{page}/{size}" in
            // URL.
            assertTrue(driver.getCurrentUrl()
                    .contains("/terasoluna-gfw-functionaltest-web/pagination/23_1/1/10"));

            // check include "?page=1&size=10&sort=firstname,DESC" in URL.
            assertTrue(driver.getCurrentUrl().contains("?page=1&size=10&sort=firstname,DESC"));

            // check output of <f:query>.
            WebElement fqueryElement = driver.findElement(
                    By.id("paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                // skip current page
                if (count == 4) {
                    continue;
                }
                assertTrue(fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                        .getAttribute("href").endsWith("name=%2B%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver)).isEqualTo("+ &=");

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fuElement = driver.findElement(
                    By.id("paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(
                        fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"),
                        fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"));
            }
        }
    }

    @Test
    public void test23_02_searchWithQueryTmplAndCriteriaQueryByFUFunction() {
        driver.findElement(By.id("search_23_2")).click();

        // search
        {
            inputFieldAccessor.appendValue(By.id("name"), "+ &=", driver);
            driver.findElement(By.id("searchButton")).click();
            // assert 1 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "1"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("1");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("10");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("250");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("241");
        }
        // move specified page(2 page)
        {
            driver.findElement(
                    By.id("paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"))
                    .findElement(By.linkText("2")).click();
            // assert 2 page
            webDriverWait.until(textToBe(By.id("pagePosition"), "2"));
            assertThat(driver.findElement(By.id("rangeStart")).getText()).isEqualTo("11");
            assertThat(driver.findElement(By.id("rangeEnd")).getText()).isEqualTo("20");
            assertThat(driver.findElement(By.id("totalResults")).getText()).isEqualTo("100");
            assertThat(driver.findElement(By.id("personId0")).getText()).isEqualTo("240");
            assertThat(driver.findElement(By.id("personId9")).getText()).isEqualTo("231");

            // wait
            driver.findElement(By.tagName("body"));

            // check include
            // "/terasoluna-gfw-functionaltest-web/pagination/23_1/{page}/{size}" in
            // URL.
            assertTrue(driver.getCurrentUrl()
                    .contains("/terasoluna-gfw-functionaltest-web/pagination/23_1/1/10"));

            // check include "?page=1&size=10&sort=firstname,DESC" in URL.
            assertTrue(driver.getCurrentUrl().contains("?page=1&size=10&sort=firstname,DESC"));

            // check output of <f:u>.
            WebElement fuElement = driver.findElement(
                    By.id("paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFU"));

            for (int count = 3; count <= 12; count++) {
                if (count == 4) {
                    continue;
                }
                assertTrue(fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                        .getAttribute("href").endsWith("name=%2B%20%26%3D"));
            }

            // check search condition parameter.
            assertThat(inputFieldAccessor.getValue(By.id("name"), driver)).isEqualTo("+ &=");

            // check output of <f:query> and <f:u> are the same URL.
            WebElement fqueryElement = driver.findElement(
                    By.id("paginationCombinationOfPathTmplAndQueryTmplAndCriteriaQueryAndFQuery"));

            for (int count = 3; count <= 12; count++) {
                assertEquals(
                        fqueryElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"),
                        fuElement.findElement(By.xpath("ul/li[" + count + "]/a"))
                                .getAttribute("href"));
            }
        }
    }

    @Test
    public void test24_01_enableLinkOfCurrentPage() {
        driver.findElement(By.id("enableLinkOfCurrentPage_24_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // default page
        String orgXtrack = driver.findElement(By.id("xtrack")).getText();

        // currentPage(1Page) link check
        assertThat(driver.findElement(By.xpath("(//a[contains(@href, '?page=0&size=15')])[1]"))
                .getText()).isEqualTo("1");

        // currentPage(1Page) active click
        driver.findElement(By.linkText("1")).click();
        String currentPageXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(currentPageXtrack).isNotEqualTo(orgXtrack);

    }

    @Test
    public void test25_01_disabledPageLinkWithJavaScript() {
        driver.findElement(By.id("disabledPageLinkWithJavaScript_25_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // firstLink, previousLink, current page value "#" check
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[1]/a"))
                .getAttribute("href")).isNotEqualTo("javascript:void(0)");
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[2]/a"))
                .getAttribute("href")).isNotEqualTo("javascript:void(0)");
        assertThat(driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[3]/a"))
                .getAttribute("href")).isNotEqualTo("javascript:void(0)");

        // default page
        String orgXtrack = driver.findElement(By.id("xtrack")).getText();

        // firstLink disabled click
        driver.findElement(By.linkText("<<")).click();
        String firstLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(firstLinkXtrack).isEqualTo(orgXtrack);

        // previousLink disabled click
        driver.findElement(By.linkText("<")).click();
        String previousLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(previousLinkXtrack).isEqualTo(orgXtrack);

        // currentPage(1Page) active click
        driver.findElement(By.linkText("<")).click();
        String currentPageXtrack = driver.findElement(By.id("xtrack")).getText();
        // not change xtrack
        assertThat(currentPageXtrack).isEqualTo(orgXtrack);

        // nextLink click
        driver.findElement(By.linkText(">")).click();
        String nextLinkXtrack = driver.findElement(By.id("xtrack")).getText();
        // change xtrack
        assertThat(nextLinkXtrack).isNotEqualTo(orgXtrack);

    }

    @Test
    public void test26_01_tagConfiguration() {
        driver.findElement(By.id("tagConfiguration_26_1")).click();
        webDriverWait.until(textToBe(By.xpath("//h1[2]"), "1 Page"));

        // outerElement close with </ul> confirm
        assertThat(driver.getPageSource().contains("<ul></ul>")).isTrue();

        // page soruce
        pageSource.save(driver);
    }

}
