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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class ConsistOfCheckTest extends FunctionTestSupport {

    @Test
    public void consistOfCheckSuccessTest() {

        driver.findElement(By.id("codepoints02_01")).click();

        String[][] testDatas = { { "jisX208Hiragana", "しめい" }, {
                "jisX208HiraganaKatakana", "メモめも" }, { "asciiCtrlChars",
                        "\u0007\b\t\u000b\r\n" }, // \a\b\t\v\r\n
                { "asciiPrntChars", " 012abcABC~" }, { "crlf", "\r\n" }, {
                        "jisX201Katakana", "｡ｶﾀｶﾅﾟ" }, { "jisX201LatinLetters",
                                " 012aB}‾" }, { "jisX208SpecialChars",
                                        "\u3000☆★〒◯" }, { "jisX208LatinLetters",
                                                "０Ａａｚ" }, { "jisX208Katakana",
                                                        "ァカナヶ" }, {
                                                                "jisX208GreekLetteres",
                                                                "ΑΦω" }, {
                                                                        "jisX0208CyrillicLetters",
                                                                        "АЯя" },
                { "jisX0208BoxDrawingChars", "─╋╂" }, { "jisX0208Kanji",
                        "亜椈熙" }, { "jisX0213Kanji", "亜窠𪚲" }, { "numberChars",
                                "01589" }, { "hiraganaKatakanaChars", "ひらカナ" },
                { "kanaChars", "カタカナ" } };
        for (String[] testData : testDatas) {
            this.setText(testData[0], testData[1]);
        }

        driver.findElement(By.id("check")).click();

        this.check("page_title", "CodePoints Check Success !");

    }

    @Test
    public void consistOfCheckErrorTest() {

        driver.findElement(By.id("codepoints02_01")).click();

        String[][] testDatas = { { "jisX208Hiragana", "しメい" }, {
                "jisX208HiraganaKatakana", "メモめもmemo" }, { "asciiCtrlChars",
                        "\u0007\b\tM\u000b\r\n" }, // \a\b\tM\v\r\n
                { "asciiPrntChars", "\u001f 012abcABC~" }, { "crlf", "\rA\n" },
                { "jisX201Katakana", " ｡ｶﾀｶﾅﾟ" }, { "jisX201LatinLetters",
                        "ｱ 012aB}‾" }, { "jisX208SpecialChars", "ア\u3000☆★〒◯" },
                { "jisX208LatinLetters", "０Ａアａｚ" }, { "jisX208Katakana",
                        "あァカナヶ" }, { "jisX208GreekLetteres", "ΑΦ・ω・" }, {
                                "jisX0208CyrillicLetters", "АЯяア" }, {
                                        "jisX0208BoxDrawingChars", "─あ╋╂" }, {
                                                "jisX0208Kanji", "亜椈熙ヰ" }, {
                                                        "jisX0213Kanji",
                                                        "亜窠𪚲ヰ" }, {
                                                                "numberChars",
                                                                "a01589" }, {
                                                                        "hiraganaKatakanaChars",
                                                                        "ひらカナA" },
                { "kanaChars", "カタカナ。" } };
        for (String[] testData : testDatas) {
            this.setText(testData[0], testData[1]);
        }

        driver.findElement(By.id("check")).click();

        this.check("page_title", "CodePoints Test");

        for (String[] testData : testDatas) {
            this.check(testData[0] + ".errors",
                    "not consist of specified code points");
        }
    }

    private void setText(String id, String text) {
        inputFieldAccessor.overrideValue(By.id(id), text, driver);
    }

    private void check(String id, String value) {
        assertThat(driver.findElement(By.id(id)).getText(), is(value));
    }
}
