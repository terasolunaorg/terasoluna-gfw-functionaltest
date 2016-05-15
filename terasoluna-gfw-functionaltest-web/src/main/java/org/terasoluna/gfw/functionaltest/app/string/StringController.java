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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.common.fullhalf.DefaultFullHalf;
import org.terasoluna.gfw.common.fullhalf.FullHalfPairsBuilder;

@Controller
@RequestMapping(value = "string")
public class StringController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		
		return "string/index";
	}
	
	@RequestMapping(value="01", method = RequestMethod.GET)
	public String string01(Model model) {
		
		model.addAttribute("string", DefaultFullHalf.INSTANCE.toFullwidth("ｱﾞ!A8ｶﾞザ"));
		
		return "string/result";
	}
	
	@RequestMapping(value="02", method = RequestMethod.GET)
	public String string02(Model model) {
		
		model.addAttribute("string", DefaultFullHalf.INSTANCE.toHalfwidth("Ａ！アガｻ"));
		
		return "string/result";
	}
	
	@RequestMapping(value="03", method = RequestMethod.GET)
	public String string03(Model model) {
		
		boolean result = true;
		
        String[][] testData = { { "！", "!" }, { "＂", "\"" }, { "＃", "#" },
                { "＄", "$" }, { "％", "%" }, { "＆", "&" }, { "＇", "'" },
                { "（", "(" }, { "）", ")" }, { "＊", "*" }, { "＋", "+" },
                { "，", "," }, { "．", "." }, { "／", "/" },
                { "０", "0" }, { "１", "1" }, { "２", "2" }, { "３", "3" },
                { "４", "4" }, { "５", "5" }, { "６", "6" }, { "７", "7" },
                { "８", "8" }, { "９", "9" }, { "：", ":" }, { "；", ";" },
                { "＜", "<" }, { "＝", "=" }, { "＞", ">" }, { "？", "?" },
                { "＠", "@" }, { "Ａ", "A" }, { "Ｂ", "B" }, { "Ｃ", "C" },
                { "Ｄ", "D" }, { "Ｅ", "E" }, { "Ｆ", "F" }, { "Ｇ", "G" },
                { "Ｈ", "H" }, { "Ｉ", "I" }, { "Ｊ", "J" }, { "Ｋ", "K" },
                { "Ｌ", "L" }, { "Ｍ", "M" }, { "Ｎ", "N" }, { "Ｏ", "O" },
                { "Ｐ", "P" }, { "Ｑ", "Q" }, { "Ｒ", "R" }, { "Ｓ", "S" },
                { "Ｔ", "T" }, { "Ｕ", "U" }, { "Ｖ", "V" }, { "Ｗ", "W" },
                { "Ｘ", "X" }, { "Ｙ", "Y" }, { "Ｚ", "Z" }, { "［", "[" },
                { "＼", "\\" }, { "］", "]" }, { "＾", "^" }, { "＿", "_" },
                { "｀", "`" }, { "ａ", "a" }, { "ｂ", "b" }, { "ｃ", "c" },
                { "ｄ", "d" }, { "ｅ", "e" }, { "ｆ", "f" }, { "ｇ", "g" },
                { "ｈ", "h" }, { "ｉ", "i" }, { "ｊ", "j" }, { "ｋ", "k" },
                { "ｌ", "l" }, { "ｍ", "m" }, { "ｎ", "n" }, { "ｏ", "o" },
                { "ｐ", "p" }, { "ｑ", "q" }, { "ｒ", "r" }, { "ｓ", "s" },
                { "ｔ", "t" }, { "ｕ", "u" }, { "ｖ", "v" }, { "ｗ", "w" },
                { "ｘ", "x" }, { "ｙ", "y" }, { "ｚ", "z" }, { "｛", "{" },
                { "｜", "|" }, { "｝", "}" }, { "\uff5e", "~" }, { "。", "｡" },
                { "「", "｢" }, { "」", "｣" }, { "、", "､" }, { "・", "･" },
                { "ァ", "ｧ" }, { "ィ", "ｨ" }, { "ゥ", "ｩ" }, { "ェ", "ｪ" },
                { "ォ", "ｫ" }, { "ャ", "ｬ" }, { "ュ", "ｭ" }, { "ョ", "ｮ" },
                { "ッ", "ｯ" }, { "ア", "ｱ" }, { "イ", "ｲ" }, { "ウ", "ｳ" },
                { "エ", "ｴ" }, { "オ", "ｵ" }, { "カ", "ｶ" }, { "キ", "ｷ" },
                { "ク", "ｸ" }, { "ケ", "ｹ" }, { "コ", "ｺ" }, { "サ", "ｻ" },
                { "シ", "ｼ" }, { "ス", "ｽ" }, { "セ", "ｾ" }, { "ソ", "ｿ" },
                { "タ", "ﾀ" }, { "チ", "ﾁ" }, { "ツ", "ﾂ" }, { "テ", "ﾃ" },
                { "ト", "ﾄ" }, { "ナ", "ﾅ" }, { "ニ", "ﾆ" }, { "ヌ", "ﾇ" },
                { "ネ", "ﾈ" }, { "ノ", "ﾉ" }, { "ハ", "ﾊ" }, { "ヒ", "ﾋ" },
                { "フ", "ﾌ" }, { "ヘ", "ﾍ" }, { "ホ", "ﾎ" }, { "マ", "ﾏ" },
                { "ミ", "ﾐ" }, { "ム", "ﾑ" }, { "メ", "ﾒ" }, { "モ", "ﾓ" },
                { "ヤ", "ﾔ" }, { "ユ", "ﾕ" }, { "ヨ", "ﾖ" }, { "ラ", "ﾗ" },
                { "リ", "ﾘ" }, { "ル", "ﾙ" }, { "レ", "ﾚ" }, { "ロ", "ﾛ" },
                { "ワ", "ﾜ" }, { "ヲ", "ｦ" }, { "ン", "ﾝ" }, { "ガ", "ｶﾞ" },
                { "ギ", "ｷﾞ" }, { "グ", "ｸﾞ" }, { "ゲ", "ｹﾞ" }, { "ゴ", "ｺﾞ" },
                { "ザ", "ｻﾞ" }, { "ジ", "ｼﾞ" }, { "ズ", "ｽﾞ" }, { "ゼ", "ｾﾞ" },
                { "ゾ", "ｿﾞ" }, { "ダ", "ﾀﾞ" }, { "ヂ", "ﾁﾞ" }, { "ヅ", "ﾂﾞ" },
                { "デ", "ﾃﾞ" }, { "ド", "ﾄﾞ" }, { "バ", "ﾊﾞ" }, { "ビ", "ﾋﾞ" },
                { "ブ", "ﾌﾞ" }, { "べ", "ﾍﾞ" }, { "ボ", "ﾎﾞ" }, { "パ", "ﾊﾟ" },
                { "ピ", "ﾋﾟ" }, { "プ", "ﾌﾟ" }, { "ペ", "ﾍﾟ" }, { "ポ", "ﾎﾟ" },
                { "ヴ", "ｳﾞ" }, { "\u30f7", "ﾜﾞ" }, { "\u30fa", "ｦﾞ" },
                { "゛", "ﾞ" }, { "゜", "ﾟ" }, { "　", " " }, { "ー", "-" } };

        String[][] resultArray = new String[testData.length][2];

        for (int i = 0; i < testData.length; i++) {
        	resultArray[i][0] = CustomFullHalf.INSTANCE.toHalfwidth(testData[i][0]);
        	resultArray[i][1] = CustomFullHalf.INSTANCE.toFullwidth(testData[i][1]);
        }

        for (int i = 0; i < testData.length; i++) {
        	if (!testData[i][0].equals(resultArray[i][1])) {
        		result = false;
        	}
        	if (!testData[i][1].equals(resultArray[i][0])) {
        		result = false;
        	}
        }

        model.addAttribute("resultArray", resultArray);
        model.addAttribute("result", result);
		
		return "string/result";
	}
	
	@RequestMapping(value="04", method = RequestMethod.GET)
	public String string04(Model model) {
		
		model.addAttribute("string", CustomFullHalf.INSTANCE.toHalfwidth("ハローワールド！"));
		
		return "string/result";
	}
	
	@RequestMapping(value="05", method = RequestMethod.GET)
	public String string05(Model model) {

		boolean result = true;
		try {
			new FullHalfPairsBuilder().pair("", "a");
			result = false;
		} catch(Exception e) {
			if (!(e instanceof IllegalArgumentException)) {
				result = false;
			}
		}
		
		model.addAttribute("result", result);
		
		return "string/result";
	}
	
	@RequestMapping(value="06", method = RequestMethod.GET)
	public String string06(Model model) {

		boolean result = true;
		try {
			new FullHalfPairsBuilder().pair(null, "a");
			result = false;
		} catch(Exception e) {
			if (!(e instanceof IllegalArgumentException)) {
				result = false;
			}
		}
		
		model.addAttribute("result", result);
		
		return "string/result";
	}
	
	@RequestMapping(value="07", method = RequestMethod.GET)
	public String string07(Model model) {

		boolean result = true;
		try {
			new FullHalfPairsBuilder().pair("ａａ", "a");
			result = false;
		} catch(Exception e) {
			if (!(e instanceof IllegalArgumentException)) {
				result = false;
			}
		}
		
		model.addAttribute("result", result);
		
		return "string/result";
	}
	
	@RequestMapping(value="08", method = RequestMethod.GET)
	public String string08(Model model) {

		boolean result = true;
		try {
			new FullHalfPairsBuilder().pair("ａ", "");
			result = false;
		} catch(Exception e) {
			if (!(e instanceof IllegalArgumentException)) {
				result = false;
			}
		}
		
		model.addAttribute("result", result);
		
		return "string/result";
	}
	
	@RequestMapping(value="09", method = RequestMethod.GET)
	public String string09(Model model) {

		boolean result = true;
		try {
			new FullHalfPairsBuilder().pair("ａ", null);
			result = false;
		} catch(Exception e) {
			if (!(e instanceof IllegalArgumentException)) {
				result = false;
			}
		}
		
		model.addAttribute("result", result);
		
		return "string/result";
	}
	
	@RequestMapping(value="10", method = RequestMethod.GET)
	public String string10(Model model) {

		boolean result = true;
		try {
			new FullHalfPairsBuilder().pair("ａ", "aaa");
			result = false;
		} catch(Exception e) {
			if (!(e instanceof IllegalArgumentException)) {
				result = false;
			}
		}
		
		model.addAttribute("result", result);
		
		return "string/result";
	}
	
}
