/*
 * Copyright (C) 2013-2016 terasoluna.org
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
@ContextConfiguration(locations = { "classpath:META-INF/spring/seleniumContext.xml" })
public class FullHalfConverterTest extends FunctionTestSupport {

    @Test
    public void fullHalfConverterTest01() {

        driver.findElement(By.id("fullHalfConverterTest01")).click();
		
        // input:"ｱﾞ!A8ｶﾞザ"
		String string = driver.findElement(By.id("string")).getText();

		assertThat(string, is("ア゛！Ａ８ガザ"));
    }

    @Test
    public void fullHalfConverterTest02() {

        driver.findElement(By.id("fullHalfConverterTest02")).click();
		
        // input:"Ａ！アガｻ"
		String string = driver.findElement(By.id("string")).getText();

		assertThat(string, is("A!ｱｶﾞｻ"));
    }

    @Test
    public void customFullHalfTest01() {

//    	Full Half mapping list { { "！", "!" }, { "＂", "\"" }, { "＃", "#" },
//                { "＄", "$" }, { "％", "%" }, { "＆", "&" }, { "＇", "'" },
//                { "（", "(" }, { "）", ")" }, { "＊", "*" }, { "＋", "+" },
//                { "，", "," }, { "．", "." }, { "／", "/" },
//                { "０", "0" }, { "１", "1" }, { "２", "2" }, { "３", "3" },
//                { "４", "4" }, { "５", "5" }, { "６", "6" }, { "７", "7" },
//                { "８", "8" }, { "９", "9" }, { "：", ":" }, { "；", ";" },
//                { "＜", "<" }, { "＝", "=" }, { "＞", ">" }, { "？", "?" },
//                { "＠", "@" }, { "Ａ", "A" }, { "Ｂ", "B" }, { "Ｃ", "C" },
//                { "Ｄ", "D" }, { "Ｅ", "E" }, { "Ｆ", "F" }, { "Ｇ", "G" },
//                { "Ｈ", "H" }, { "Ｉ", "I" }, { "Ｊ", "J" }, { "Ｋ", "K" },
//                { "Ｌ", "L" }, { "Ｍ", "M" }, { "Ｎ", "N" }, { "Ｏ", "O" },
//                { "Ｐ", "P" }, { "Ｑ", "Q" }, { "Ｒ", "R" }, { "Ｓ", "S" },
//                { "Ｔ", "T" }, { "Ｕ", "U" }, { "Ｖ", "V" }, { "Ｗ", "W" },
//                { "Ｘ", "X" }, { "Ｙ", "Y" }, { "Ｚ", "Z" }, { "［", "[" },
//                { "＼", "\\" }, { "］", "]" }, { "＾", "^" }, { "＿", "_" },
//                { "｀", "`" }, { "ａ", "a" }, { "ｂ", "b" }, { "ｃ", "c" },
//                { "ｄ", "d" }, { "ｅ", "e" }, { "ｆ", "f" }, { "ｇ", "g" },
//                { "ｈ", "h" }, { "ｉ", "i" }, { "ｊ", "j" }, { "ｋ", "k" },
//                { "ｌ", "l" }, { "ｍ", "m" }, { "ｎ", "n" }, { "ｏ", "o" },
//                { "ｐ", "p" }, { "ｑ", "q" }, { "ｒ", "r" }, { "ｓ", "s" },
//                { "ｔ", "t" }, { "ｕ", "u" }, { "ｖ", "v" }, { "ｗ", "w" },
//                { "ｘ", "x" }, { "ｙ", "y" }, { "ｚ", "z" }, { "｛", "{" },
//                { "｜", "|" }, { "｝", "}" }, { "\uff5e", "~" }, { "。", "｡" },
//                { "「", "｢" }, { "」", "｣" }, { "、", "､" }, { "・", "･" },
//                { "ァ", "ｧ" }, { "ィ", "ｨ" }, { "ゥ", "ｩ" }, { "ェ", "ｪ" },
//                { "ォ", "ｫ" }, { "ャ", "ｬ" }, { "ュ", "ｭ" }, { "ョ", "ｮ" },
//                { "ッ", "ｯ" }, { "ア", "ｱ" }, { "イ", "ｲ" }, { "ウ", "ｳ" },
//                { "エ", "ｴ" }, { "オ", "ｵ" }, { "カ", "ｶ" }, { "キ", "ｷ" },
//                { "ク", "ｸ" }, { "ケ", "ｹ" }, { "コ", "ｺ" }, { "サ", "ｻ" },
//                { "シ", "ｼ" }, { "ス", "ｽ" }, { "セ", "ｾ" }, { "ソ", "ｿ" },
//                { "タ", "ﾀ" }, { "チ", "ﾁ" }, { "ツ", "ﾂ" }, { "テ", "ﾃ" },
//                { "ト", "ﾄ" }, { "ナ", "ﾅ" }, { "ニ", "ﾆ" }, { "ヌ", "ﾇ" },
//                { "ネ", "ﾈ" }, { "ノ", "ﾉ" }, { "ハ", "ﾊ" }, { "ヒ", "ﾋ" },
//                { "フ", "ﾌ" }, { "ヘ", "ﾍ" }, { "ホ", "ﾎ" }, { "マ", "ﾏ" },
//                { "ミ", "ﾐ" }, { "ム", "ﾑ" }, { "メ", "ﾒ" }, { "モ", "ﾓ" },
//                { "ヤ", "ﾔ" }, { "ユ", "ﾕ" }, { "ヨ", "ﾖ" }, { "ラ", "ﾗ" },
//                { "リ", "ﾘ" }, { "ル", "ﾙ" }, { "レ", "ﾚ" }, { "ロ", "ﾛ" },
//                { "ワ", "ﾜ" }, { "ヲ", "ｦ" }, { "ン", "ﾝ" }, { "ガ", "ｶﾞ" },
//                { "ギ", "ｷﾞ" }, { "グ", "ｸﾞ" }, { "ゲ", "ｹﾞ" }, { "ゴ", "ｺﾞ" },
//                { "ザ", "ｻﾞ" }, { "ジ", "ｼﾞ" }, { "ズ", "ｽﾞ" }, { "ゼ", "ｾﾞ" },
//                { "ゾ", "ｿﾞ" }, { "ダ", "ﾀﾞ" }, { "ヂ", "ﾁﾞ" }, { "ヅ", "ﾂﾞ" },
//                { "デ", "ﾃﾞ" }, { "ド", "ﾄﾞ" }, { "バ", "ﾊﾞ" }, { "ビ", "ﾋﾞ" },
//                { "ブ", "ﾌﾞ" }, { "べ", "ﾍﾞ" }, { "ボ", "ﾎﾞ" }, { "パ", "ﾊﾟ" },
//                { "ピ", "ﾋﾟ" }, { "プ", "ﾌﾟ" }, { "ペ", "ﾍﾟ" }, { "ポ", "ﾎﾟ" },
//                { "ヴ", "ｳﾞ" }, { "\u30f7", "ﾜﾞ" }, { "\u30fa", "ｦﾞ" },
//                { "゛", "ﾞ" }, { "゜", "ﾟ" }, { "　", " " }, { "ー", "-" } };

        driver.findElement(By.id("customFullHalfTest01")).click();

        String result = driver.findElement(By.id("result")).getText();
        
        assertThat(result, is("true"));
    }
    
    @Test
    public void customFullHalfTest02() {

        driver.findElement(By.id("customFullHalfTest02")).click();
		
        // input:"ハローワールド！"
		String string = driver.findElement(By.id("string")).getText();

		assertThat(string, is("ﾊﾛ-ﾜ-ﾙﾄﾞ!"));
    }
    
    @Test
    public void fullHalfPairsBuilderErrorTest01() {

        driver.findElement(By.id("fullHalfPairsBuilderErrorTest01")).click();
		
        // pair("", "a")
		String result = driver.findElement(By.id("result")).getText();

		assertThat(result, is("true"));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest02() {

        driver.findElement(By.id("fullHalfPairsBuilderErrorTest02")).click();
		
        // pair(null, "a")
		String result = driver.findElement(By.id("result")).getText();

		assertThat(result, is("true"));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest03() {

        driver.findElement(By.id("fullHalfPairsBuilderErrorTest03")).click();
		
        // pair("ａａ", "a")
		String result = driver.findElement(By.id("result")).getText();

		assertThat(result, is("true"));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest04() {

        driver.findElement(By.id("fullHalfPairsBuilderErrorTest04")).click();
		
        // pair("ａ", "")
		String result = driver.findElement(By.id("result")).getText();

		assertThat(result, is("true"));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest05() {

        driver.findElement(By.id("fullHalfPairsBuilderErrorTest05")).click();
		
        // pair("ａ", null)
		String result = driver.findElement(By.id("result")).getText();

		assertThat(result, is("true"));
    }

    @Test
    public void fullHalfPairsBuilderErrorTest06() {

        driver.findElement(By.id("fullHalfPairsBuilderErrorTest06")).click();
		
        // pair("ａ", "aaa")
		String result = driver.findElement(By.id("result")).getText();

		assertThat(result, is("true"));
    }

}
