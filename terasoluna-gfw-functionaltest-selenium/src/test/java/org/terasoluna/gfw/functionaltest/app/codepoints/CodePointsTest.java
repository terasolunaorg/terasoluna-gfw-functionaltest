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
package org.terasoluna.gfw.functionaltest.app.codepoints;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.common.codepoints.CodePoints;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class CodePointsTest extends FunctionTestSupport {

    @Test
    public void codePointsTest_01_01() {

        driver.findElement(By.id("codepoints01_01")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナ", driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "codePointsOf");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("instanceCheck")).getText(), is(
                "true"));
        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_02() {

        driver.findElement(By.id("codepoints01_02")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナ", driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "newJIS_X_0208_Katakana");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_03() {

        driver.findElement(By.id("codepoints01_03")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "ab", driver);
        inputFieldAccessor.overrideValue(By.id("codePoints0"), "0x0061",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePoints1"), "0x0062",
                driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "newCodePointsWithIntegerArray");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_04() {

        driver.findElement(By.id("codepoints01_04")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "ab", driver);
        inputFieldAccessor.overrideValue(By.id("codePoints0"), "0x0061",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePoints1"), "0x0062",
                driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "newCodePointsWithIntegerSet");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_05() {

        driver.findElement(By.id("codepoints01_05")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "ab", driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "newCodePonitsWithString");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_06() {

        driver.findElement(By.id("codepoints01_06")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "ab", driver);
        inputFieldAccessor.overrideValue(By.id("codePoints0"), "a", driver);
        inputFieldAccessor.overrideValue(By.id("codePoints1"), "b", driver);
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_07() {

        driver.findElement(By.id("codepoints01_07")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "abcd", driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA0"), "0x0061",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA1"), "0x0062",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsB0"), "0x0063",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsB1"), "0x0064",
                driver);
        new Select(driver.findElement(By.id("operation"))).selectByValue(
                "union");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_08() {

        driver.findElement(By.id("codepoints01_08")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "ab", driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA0"), "0x0061",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA1"), "0x0062",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA2"), "0x0063",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA3"), "0x0064",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsB0"), "0x0063",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsB1"), "0x0064",
                driver);
        new Select(driver.findElement(By.id("operation"))).selectByValue(
                "subtract");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_09() {

        driver.findElement(By.id("codepoints01_09")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "cd", driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA0"), "0x0061",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA1"), "0x0062",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA2"), "0x0063",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsA3"), "0x0064",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsB0"), "0x0063",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsB1"), "0x0064",
                driver);
        inputFieldAccessor.overrideValue(By.id("codePointsB2"), "0x0065",
                driver);
        new Select(driver.findElement(By.id("operation"))).selectByValue(
                "intersect");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_10() {

        driver.findElement(By.id("codepoints01_10")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カ", driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "codePointsOfWithJIS_X_0208_Katakana");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_11() {

        driver.findElement(By.id("codepoints01_11")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナ", driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "codePointsOfWithJIS_X_0208_Katakana");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "true"));
    }

    @Test
    public void codePointsTest_01_12() {

        driver.findElement(By.id("codepoints01_12")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナa", driver);
        new Select(driver.findElement(By.id("useInstanceKind"))).selectByValue(
                "codePointsOfWithJIS_X_0208_Katakana");
        driver.findElement(By.id("containsAll")).click();

        assertThat(driver.findElement(By.id("containsAll")).getText(), is(
                "false"));
    }

    @Test
    public void codePointsTest_01_13() {

        driver.findElement(By.id("codepoints01_13")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナ", driver);
        driver.findElement(By.id("getFirstExcludedCodePoint")).click();

        String codepoints = driver.findElement(By.id("firstExcludedCodepoint"))
                .getText();

        assertThat(Integer.parseInt(codepoints), is(CodePoints.NOT_FOUND));
    }

    @Test
    public void codePointsTest_01_14() {

        driver.findElement(By.id("codepoints01_14")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "aカナ", driver);
        driver.findElement(By.id("getFirstExcludedCodePoint")).click();

        String codepoints = driver.findElement(By.id("firstExcludedCodepoint"))
                .getText();

        assertThat(Integer.parseInt(codepoints), is(0x0061));
    }

    @Test
    public void codePointsTest_01_15() {

        driver.findElement(By.id("codepoints01_15")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カaナ", driver);
        driver.findElement(By.id("getFirstExcludedCodePoint")).click();

        String codepoints = driver.findElement(By.id("firstExcludedCodepoint"))
                .getText();

        assertThat(Integer.parseInt(codepoints), is(0x0061));
    }

    @Test
    public void codePointsTest_01_16() {

        driver.findElement(By.id("codepoints01_16")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナa", driver);
        driver.findElement(By.id("getFirstExcludedCodePoint")).click();

        String codepoints = driver.findElement(By.id("firstExcludedCodepoint"))
                .getText();

        assertThat(Integer.parseInt(codepoints), is(0x0061));
    }

    @Test
    public void codePointsTest_01_17() {

        driver.findElement(By.id("codepoints01_17")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナ", driver);
        driver.findElement(By.id("getExcludedCodePoints")).click();

        assertThat(driver.findElement(By.id("excludedCodepointsSize"))
                .getText(), is("0"));
    }

    @Test
    public void codePointsTest_01_18() {

        driver.findElement(By.id("codepoints01_18")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カナa", driver);
        driver.findElement(By.id("getExcludedCodePoints")).click();

        String excludedCodePoint1 = driver.findElement(By.id(
                "excludedCodePoint1")).getText();

        assertThat(driver.findElement(By.id("excludedCodepointsSize"))
                .getText(), is("1"));
        assertThat(Integer.parseInt(excludedCodePoint1), is(0x0061));
    }

    @Test
    public void codePointsTest_01_19() {

        driver.findElement(By.id("codepoints01_19")).click();

        inputFieldAccessor.overrideValue(By.id("targetValue"), "カaナb", driver);
        driver.findElement(By.id("getExcludedCodePoints")).click();

        String excludedCodePoint1 = driver.findElement(By.id(
                "excludedCodePoint1")).getText();
        String excludedCodePoint2 = driver.findElement(By.id(
                "excludedCodePoint2")).getText();

        assertThat(driver.findElement(By.id("excludedCodepointsSize"))
                .getText(), is("2"));
        assertThat(Integer.parseInt(excludedCodePoint1), is(0x0061));
        assertThat(Integer.parseInt(excludedCodePoint2), is(0x0062));
    }

}
