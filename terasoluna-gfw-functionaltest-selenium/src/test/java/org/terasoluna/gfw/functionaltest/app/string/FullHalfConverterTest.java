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
package org.terasoluna.gfw.functionaltest.app.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class FullHalfConverterTest extends FunctionTestSupport {

    @Test
    public void fullHalfConverterTest01_01() {

        driver.findElement(By.id("fullHalfConverter01")).click();

        inputFieldAccessor.overrideValue(By.id("halfwidth"), "ｱﾞ!A8ｶﾞザ",
                driver);
        driver.findElement(By.id("toFullwidth")).click();

        assertThat(driver.findElement(By.id("fullwidth")).getAttribute("value"),
                is("ア゛！Ａ８ガザ"));
    }

    @Test
    public void fullHalfConverterTest01_02() {

        driver.findElement(By.id("fullHalfConverter01")).click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "Ａ！アガｻ", driver);
        driver.findElement(By.id("toHalfwidth")).click();

        assertThat(driver.findElement(By.id("halfwidth")).getAttribute("value"),
                is("A!ｱｶﾞｻ"));
    }

    @Test
    public void customFullHalfTest02_01() {

        driver.findElement(By.id("customFullHalfConverter02")).click();

        String[][] testDatas = { { "！", "!" }, { "＂", "\"" }, { "＃", "#" }, {
                "＄", "$" }, { "％", "%" }, { "＆", "&" }, { "＇", "'" }, { "（",
                        "(" }, { "）", ")" }, { "＊", "*" }, { "＋", "+" }, { "，",
                                "," }, { "．", "." }, { "／", "/" }, { "０", "0" },
                { "１", "1" }, { "２", "2" }, { "３", "3" }, { "４", "4" }, { "５",
                        "5" }, { "６", "6" }, { "７", "7" }, { "８", "8" }, { "９",
                                "9" }, { "：", ":" }, { "；", ";" }, { "＜", "<" },
                { "＝", "=" }, { "＞", ">" }, { "？", "?" }, { "＠", "@" }, { "Ａ",
                        "A" }, { "Ｂ", "B" }, { "Ｃ", "C" }, { "Ｄ", "D" }, { "Ｅ",
                                "E" }, { "Ｆ", "F" }, { "Ｇ", "G" }, { "Ｈ", "H" },
                { "Ｉ", "I" }, { "Ｊ", "J" }, { "Ｋ", "K" }, { "Ｌ", "L" }, { "Ｍ",
                        "M" }, { "Ｎ", "N" }, { "Ｏ", "O" }, { "Ｐ", "P" }, { "Ｑ",
                                "Q" }, { "Ｒ", "R" }, { "Ｓ", "S" }, { "Ｔ", "T" },
                { "Ｕ", "U" }, { "Ｖ", "V" }, { "Ｗ", "W" }, { "Ｘ", "X" }, { "Ｙ",
                        "Y" }, { "Ｚ", "Z" }, { "［", "[" }, { "＼", "\\" }, { "］",
                                "]" }, { "＾", "^" }, { "＿", "_" }, { "｀", "`" },
                { "ａ", "a" }, { "ｂ", "b" }, { "ｃ", "c" }, { "ｄ", "d" }, { "ｅ",
                        "e" }, { "ｆ", "f" }, { "ｇ", "g" }, { "ｈ", "h" }, { "ｉ",
                                "i" }, { "ｊ", "j" }, { "ｋ", "k" }, { "ｌ", "l" },
                { "ｍ", "m" }, { "ｎ", "n" }, { "ｏ", "o" }, { "ｐ", "p" }, { "ｑ",
                        "q" }, { "ｒ", "r" }, { "ｓ", "s" }, { "ｔ", "t" }, { "ｕ",
                                "u" }, { "ｖ", "v" }, { "ｗ", "w" }, { "ｘ", "x" },
                { "ｙ", "y" }, { "ｚ", "z" }, { "｛", "{" }, { "｜", "|" }, { "｝",
                        "}" }, { "\uff5e", "~" }, { "。", "｡" }, { "「", "｢" }, {
                                "」", "｣" }, { "、", "､" }, { "・", "･" }, { "ァ",
                                        "ｧ" }, { "ィ", "ｨ" }, { "ゥ", "ｩ" }, {
                                                "ェ", "ｪ" }, { "ォ", "ｫ" }, { "ャ",
                                                        "ｬ" }, { "ュ", "ｭ" }, {
                                                                "ョ", "ｮ" }, {
                                                                        "ッ",
                                                                        "ｯ" }, {
                                                                                "ア",
                                                                                "ｱ" },
                { "イ", "ｲ" }, { "ウ", "ｳ" }, { "エ", "ｴ" }, { "オ", "ｵ" }, { "カ",
                        "ｶ" }, { "キ", "ｷ" }, { "ク", "ｸ" }, { "ケ", "ｹ" }, { "コ",
                                "ｺ" }, { "サ", "ｻ" }, { "シ", "ｼ" }, { "ス", "ｽ" },
                { "セ", "ｾ" }, { "ソ", "ｿ" }, { "タ", "ﾀ" }, { "チ", "ﾁ" }, { "ツ",
                        "ﾂ" }, { "テ", "ﾃ" }, { "ト", "ﾄ" }, { "ナ", "ﾅ" }, { "ニ",
                                "ﾆ" }, { "ヌ", "ﾇ" }, { "ネ", "ﾈ" }, { "ノ", "ﾉ" },
                { "ハ", "ﾊ" }, { "ヒ", "ﾋ" }, { "フ", "ﾌ" }, { "ヘ", "ﾍ" }, { "ホ",
                        "ﾎ" }, { "マ", "ﾏ" }, { "ミ", "ﾐ" }, { "ム", "ﾑ" }, { "メ",
                                "ﾒ" }, { "モ", "ﾓ" }, { "ヤ", "ﾔ" }, { "ユ", "ﾕ" },
                { "ヨ", "ﾖ" }, { "ラ", "ﾗ" }, { "リ", "ﾘ" }, { "ル", "ﾙ" }, { "レ",
                        "ﾚ" }, { "ロ", "ﾛ" }, { "ワ", "ﾜ" }, { "ヲ", "ｦ" }, { "ン",
                                "ﾝ" }, { "ガ", "ｶﾞ" }, { "ギ", "ｷﾞ" }, { "グ",
                                        "ｸﾞ" }, { "ゲ", "ｹﾞ" }, { "ゴ", "ｺﾞ" }, {
                                                "ザ", "ｻﾞ" }, { "ジ", "ｼﾞ" }, {
                                                        "ズ", "ｽﾞ" }, { "ゼ",
                                                                "ｾﾞ" }, { "ゾ",
                                                                        "ｿﾞ" },
                { "ダ", "ﾀﾞ" }, { "ヂ", "ﾁﾞ" }, { "ヅ", "ﾂﾞ" }, { "デ", "ﾃﾞ" }, {
                        "ド", "ﾄﾞ" }, { "バ", "ﾊﾞ" }, { "ビ", "ﾋﾞ" }, { "ブ",
                                "ﾌﾞ" }, { "ベ", "ﾍﾞ" }, { "ボ", "ﾎﾞ" }, { "パ",
                                        "ﾊﾟ" }, { "ピ", "ﾋﾟ" }, { "プ", "ﾌﾟ" }, {
                                                "ペ", "ﾍﾟ" }, { "ポ", "ﾎﾟ" }, {
                                                        "ヴ", "ｳﾞ" }, { "\u30f7",
                                                                "ﾜﾞ" }, {
                                                                        "\u30fa",
                                                                        "ｦﾞ" },
                { "゛", "ﾞ" }, { "゜", "ﾟ" }, { "　", " " }, { "ー", "-" } };

        for (String testData[] : testDatas) {

            inputFieldAccessor.overrideValue(By.id("halfwidth"), testData[1],
                    driver);
            driver.findElement(By.id("toFullwidth")).click();

            assertThat(driver.findElement(By.id("fullwidth")).getAttribute(
                    "value"), is(testData[0]));

            driver.findElement(By.id("toHalfwidth")).click();

            assertThat(driver.findElement(By.id("halfwidth")).getAttribute(
                    "value"), is(testData[1]));
        }

    }

    @Test
    public void customFullHalfTest02_02() {

        driver.findElement(By.id("customFullHalfConverter02")).click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "ハローワールド！",
                driver);
        driver.findElement(By.id("toHalfwidth")).click();

        assertThat(driver.findElement(By.id("halfwidth")).getAttribute("value"),
                is("ﾊﾛ-ﾜ-ﾙﾄﾞ!"));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest03_01() {

        driver.findElement(By.id("fullHalfPairsBuilder03")).click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "", driver);
        inputFieldAccessor.overrideValue(By.id("halfwidth"), "a", driver);
        driver.findElement(By.id("pair")).click();

        assertThat(dbLogProvider.countContainsByRegexExceptionMessage(null,
                null, "fullwidth must be 1 length string \\(fullwidth = \\)",
                "..*IllegalArgumentException..*"), is(1L));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest03_02() {

        driver.findElement(By.id("fullHalfPairsBuilderWithStringTrimmer03"))
                .click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "", driver);
        inputFieldAccessor.overrideValue(By.id("halfwidth"), "a", driver);
        driver.findElement(By.id("pair")).click();

        assertThat(dbLogProvider.countContainsByRegexExceptionMessage(null,
                null,
                "fullwidth must be 1 length string \\(fullwidth = null\\)",
                "..*IllegalArgumentException..*"), is(1L));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest03_03() {

        driver.findElement(By.id("fullHalfPairsBuilder03")).click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "ａａ", driver);
        inputFieldAccessor.overrideValue(By.id("halfwidth"), "a", driver);
        driver.findElement(By.id("pair")).click();

        assertThat(dbLogProvider.countContainsByRegexExceptionMessage(null,
                null, "fullwidth must be 1 length string \\(fullwidth = ａａ\\)",
                "..*IllegalArgumentException..*"), is(1L));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest03_04() {

        driver.findElement(By.id("fullHalfPairsBuilder03")).click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "ａ", driver);
        inputFieldAccessor.overrideValue(By.id("halfwidth"), "", driver);
        driver.findElement(By.id("pair")).click();

        assertThat(dbLogProvider.countContainsByRegexExceptionMessage(null,
                null,
                "halfwidth must be 1 or 2 length string \\(halfwidth = \\)",
                "..*IllegalArgumentException..*"), is(1L));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest03_05() {

        driver.findElement(By.id("fullHalfPairsBuilderWithStringTrimmer03"))
                .click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "ａ", driver);
        inputFieldAccessor.overrideValue(By.id("halfwidth"), "", driver);
        driver.findElement(By.id("pair")).click();

        assertThat(dbLogProvider.countContainsByRegexExceptionMessage(null,
                null,
                "halfwidth must be 1 or 2 length string \\(halfwidth = null\\)",
                "..*IllegalArgumentException..*"), is(1L));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest03_06() {

        driver.findElement(By.id("fullHalfPairsBuilder03")).click();

        inputFieldAccessor.overrideValue(By.id("fullwidth"), "ａ", driver);
        inputFieldAccessor.overrideValue(By.id("halfwidth"), "aaa", driver);
        driver.findElement(By.id("pair")).click();

        assertThat(dbLogProvider.countContainsByRegexExceptionMessage(null,
                null,
                "halfwidth must be 1 or 2 length string \\(halfwidth = aaa\\)",
                "..*IllegalArgumentException..*"), is(1L));
    }

}
