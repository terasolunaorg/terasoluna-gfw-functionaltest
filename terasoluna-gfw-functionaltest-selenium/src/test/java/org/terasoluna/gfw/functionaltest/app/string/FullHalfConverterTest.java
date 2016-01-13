package org.terasoluna.gfw.functionaltest.app.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.terasoluna.gfw.common.fullhalf.DefaultFullHalf;
import org.terasoluna.gfw.common.fullhalf.FullHalfPairsBuilder;

public class FullHalfConverterTest {

    @Test
    public void fullHalfConverterTest01() {
        assertThat(DefaultFullHalf.INSTANCE.toFullwidth("ｱﾞ!A8ｶﾞザ"),
                is("ア゛！Ａ８ガザ"));
    }

    @Test
    public void fullHalfConverterTest02() {
        assertThat(DefaultFullHalf.INSTANCE.toHalfwidth("Ａ！アガｻ"), is("A!ｱｶﾞｻ"));
    }

    @Test
    public void customFullHalfTest01() {
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

        for (int i = 0; i < testData.length; i++) {
            assertThat(CustomFullHalf.INSTANCE.toHalfwidth(testData[i][0]),
                    is(testData[i][1]));
            assertThat(CustomFullHalf.INSTANCE.toFullwidth(testData[i][1]),
                    is(testData[i][0]));
        }

    }
    
    @Test
    public void customFullHalfTest02() {
        assertThat(CustomFullHalf.INSTANCE.toHalfwidth("ハローワールド！"), is("ﾊﾛ-ﾜ-ﾙﾄﾞ!"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void fullHalfPairsBuilderErrorTest01() {
        new FullHalfPairsBuilder().pair("", "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullHalfPairsBuilderErrorTest02() {
        new FullHalfPairsBuilder().pair(null, "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullHalfPairsBuilderErrorTest03() {
        new FullHalfPairsBuilder().pair("ａａ", "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullHalfPairsBuilderErrorTest04() {
        new FullHalfPairsBuilder().pair("ａ", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullHalfPairsBuilderErrorTest05() {
        new FullHalfPairsBuilder().pair("ａ", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullHalfPairsBuilderErrorTest06() {
        new FullHalfPairsBuilder().pair("ａ", "aaa");
    }

}
