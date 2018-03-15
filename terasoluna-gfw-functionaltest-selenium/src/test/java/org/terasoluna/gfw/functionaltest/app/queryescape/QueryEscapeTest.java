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
package org.terasoluna.gfw.functionaltest.app.queryescape;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class QueryEscapeTest extends FunctionTestSupport {

    @Test
    public void test01_01_searchWithPrefixUsingMybatis() {

        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB%", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB%DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB%DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test01_02_searchWithPrefixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB_", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB_DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB_DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test01_03_searchWithPrefixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB％", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB％DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB％DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test01_04_searchWithPrefixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB＿", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB＿DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB＿DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test01_05_searchWithPrefixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "ABC", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "ABCDE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "ABCDE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test01_06_searchWithPrefixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB~", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB~DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB~DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test01_07_searchWithPrefixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 12"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "ABCDE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "ABCDE2"));
        assertThat(driver.findElement(By.xpath("//tr[3]//td[2]")).getText(), is(
                "AB%DE1"));
        assertThat(driver.findElement(By.xpath("//tr[4]//td[2]")).getText(), is(
                "AB%DE2"));
        assertThat(driver.findElement(By.xpath("//tr[5]//td[2]")).getText(), is(
                "AB_DE1"));
        assertThat(driver.findElement(By.xpath("//tr[6]//td[2]")).getText(), is(
                "AB_DE2"));
        assertThat(driver.findElement(By.xpath("//tr[7]//td[2]")).getText(), is(
                "AB％DE1"));
        assertThat(driver.findElement(By.xpath("//tr[8]//td[2]")).getText(), is(
                "AB％DE2"));
        assertThat(driver.findElement(By.xpath("//tr[9]//td[2]")).getText(), is(
                "AB＿DE1"));
        assertThat(driver.findElement(By.xpath("//tr[10]//td[2]")).getText(),
                is("AB＿DE2"));
        assertThat(driver.findElement(By.xpath("//tr[11]//td[2]")).getText(),
                is("AB~DE1"));
        assertThat(driver.findElement(By.xpath("//tr[12]//td[2]")).getText(),
                is("AB~DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test01_08_searchWithPrefixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with prefix test
        driver.findElement(By.id("nullTodoTitle")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "null todo title search result 0"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test02_01_searchWithSuffixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "%DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB%DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test02_02_searchWithSuffixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "_DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB_DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test02_03_searchWithSuffixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "％DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB％DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test02_04_searchWithSuffixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "＿DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB＿DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test02_05_searchWithSuffixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "CDE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "ABCDE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test02_06_searchWithSuffixUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "~DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB~DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test03_01_searchWithParticalUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B%D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB%DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB%DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test03_02_searchWithParticalUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B_D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB_DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB_DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test03_03_searchWithParticalUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B％D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB％DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB％DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test03_04_searchWithParticalUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B＿D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB＿DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB＿DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test03_05_searchWithParticalUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "BCD", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "ABCDE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "ABCDE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test03_06_searchWithParticalUsingMybatis() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link3")).click();
        } else {
            driver.findElement(By.id("link1")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B~D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB~DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB~DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test04_01_searchWithPrefixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB%", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB%DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB%DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test04_02_searchWithPrefixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB_", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB_DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB_DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test04_03_searchWithPrefixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB％", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB％DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB％DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test04_04_searchWithPrefixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB＿", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB＿DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB＿DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test04_05_searchWithPrefixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "ABC", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "ABCDE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "ABCDE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test04_06_searchWithPrefixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with prefix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "AB~", driver);
        driver.findElement(By.id("prefix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "prefix search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB~DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB~DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test05_01_searchWithSuffixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "%DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB%DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test05_02_searchWithSuffixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "_DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB_DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test05_03_searchWithSuffixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "％DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB％DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test05_04_searchWithSuffixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "＿DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB＿DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test05_05_searchWithSuffixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "CDE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "ABCDE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test05_06_searchWithSuffixUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with suffix test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "~DE1", driver);
        driver.findElement(By.id("suffix")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "suffix search result 1"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB~DE1"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test06_01_searchWithParticalUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B%D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB%DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB%DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test06_02_searchWithParticalUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B_D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB_DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB_DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test06_03_searchWithParticalUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B％D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB％DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB％DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test06_04_searchWithParticalUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B＿D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB＿DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB＿DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test06_05_searchWithParticalUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "BCD", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "ABCDE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "ABCDE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    @Test
    public void test06_06_searchWithParticalUsingJpa() {
        if (isWithFullWidth()) {
            driver.findElement(By.id("link4")).click();
        } else {
            driver.findElement(By.id("link2")).click();
        }

        // search with partical test
        inputFieldAccessor.overrideValue(By.id("todoTitle"), "B~D", driver);
        driver.findElement(By.id("partical")).click();

        // search result check
        assertThat(driver.findElement(By.id("searchresult")).getText(), is(
                "partical search result 2"));
        assertThat(driver.findElement(By.xpath("//td[2]")).getText(), is(
                "AB~DE1"));
        assertThat(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), is(
                "AB~DE2"));

        // screen capture (Automatic capture conducted at the end)
    }

    private boolean isWithFullWidth() {
        String databaseId = driver.findElement(By.id("databaseId")).getText();
        if ("oracle".equals(databaseId)) {
            String databaseVersion = driver.findElement(By.id(
                    "databaseVersion")).getText();
            String[] destStrArray = databaseVersion.split("\\.");
            String[] srcStrArray = "11.2.0.1.0".split("\\.");

            int max = destStrArray.length >= srcStrArray.length
                    ? destStrArray.length : srcStrArray.length;

            for (int i = 0; i < max; i++) {
                String dest = i < destStrArray.length ? destStrArray[i] : "";
                String src = i < srcStrArray.length ? srcStrArray[i] : "";

                int compareResult = dest.compareTo(src);

                if (compareResult > 0) {
                    return false;
                }

                if (compareResult < 0) {
                    return true;
                }
            }
            return true;
        } else if ("db2".equals(databaseId)) {
            return true;
        }
        return false;
    }
}
