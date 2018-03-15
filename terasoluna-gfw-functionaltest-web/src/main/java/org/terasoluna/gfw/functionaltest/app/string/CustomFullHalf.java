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

import org.terasoluna.gfw.common.fullhalf.FullHalfConverter;
import org.terasoluna.gfw.common.fullhalf.FullHalfPairsBuilder;

public class CustomFullHalf {

    private static final int FULL_HALF_CODE_DIFF = 0xFEE0;

    public static final FullHalfConverter INSTANCE;

    static {
        FullHalfPairsBuilder builder = new FullHalfPairsBuilder();

        builder.pair("ー", "-");

        for (char c = '!'; c <= '~'; c++) {
            String fullwidth = String.valueOf((char) (c + FULL_HALF_CODE_DIFF));
            builder.pair(fullwidth, String.valueOf(c));
        }

        builder.pair("。", "｡").pair("「", "｢").pair("」", "｣").pair("、", "､")
                .pair("・", "･").pair("ァ", "ｧ").pair("ィ", "ｨ").pair("ゥ", "ｩ")
                .pair("ェ", "ｪ").pair("ォ", "ｫ").pair("ャ", "ｬ").pair("ュ", "ｭ")
                .pair("ョ", "ｮ").pair("ッ", "ｯ").pair("ア", "ｱ").pair("イ", "ｲ")
                .pair("ウ", "ｳ").pair("エ", "ｴ").pair("オ", "ｵ").pair("カ", "ｶ")
                .pair("キ", "ｷ").pair("ク", "ｸ").pair("ケ", "ｹ").pair("コ", "ｺ")
                .pair("サ", "ｻ").pair("シ", "ｼ").pair("ス", "ｽ").pair("セ", "ｾ")
                .pair("ソ", "ｿ").pair("タ", "ﾀ").pair("チ", "ﾁ").pair("ツ", "ﾂ")
                .pair("テ", "ﾃ").pair("ト", "ﾄ").pair("ナ", "ﾅ").pair("ニ", "ﾆ")
                .pair("ヌ", "ﾇ").pair("ネ", "ﾈ").pair("ノ", "ﾉ").pair("ハ", "ﾊ")
                .pair("ヒ", "ﾋ").pair("フ", "ﾌ").pair("ヘ", "ﾍ").pair("ホ", "ﾎ")
                .pair("マ", "ﾏ").pair("ミ", "ﾐ").pair("ム", "ﾑ").pair("メ", "ﾒ")
                .pair("モ", "ﾓ").pair("ヤ", "ﾔ").pair("ユ", "ﾕ").pair("ヨ", "ﾖ")
                .pair("ラ", "ﾗ").pair("リ", "ﾘ").pair("ル", "ﾙ").pair("レ", "ﾚ")
                .pair("ロ", "ﾛ").pair("ワ", "ﾜ").pair("ヲ", "ｦ").pair("ン", "ﾝ")
                .pair("ガ", "ｶﾞ").pair("ギ", "ｷﾞ").pair("グ", "ｸﾞ").pair("ゲ", "ｹﾞ")
                .pair("ゴ", "ｺﾞ").pair("ザ", "ｻﾞ").pair("ジ", "ｼﾞ").pair("ズ", "ｽﾞ")
                .pair("ゼ", "ｾﾞ").pair("ゾ", "ｿﾞ").pair("ダ", "ﾀﾞ").pair("ヂ", "ﾁﾞ")
                .pair("ヅ", "ﾂﾞ").pair("デ", "ﾃﾞ").pair("ド", "ﾄﾞ").pair("バ", "ﾊﾞ")
                .pair("ビ", "ﾋﾞ").pair("ブ", "ﾌﾞ").pair("ベ", "ﾍﾞ").pair("ボ", "ﾎﾞ")
                .pair("パ", "ﾊﾟ").pair("ピ", "ﾋﾟ").pair("プ", "ﾌﾟ").pair("ペ", "ﾍﾟ")
                .pair("ポ", "ﾎﾟ").pair("ヴ", "ｳﾞ").pair("\u30f7", "ﾜﾞ").pair(
                        "\u30fa", "ｦﾞ").pair("゛", "ﾞ").pair("゜", "ﾟ").pair("　",
                                " ");

        INSTANCE = new FullHalfConverter(builder.build());
    }
}
