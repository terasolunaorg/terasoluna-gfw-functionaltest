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

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.terasoluna.gfw.common.codepoints.ConsistOf;
import org.terasoluna.gfw.common.codepoints.catalog.ASCIIControlChars;
import org.terasoluna.gfw.common.codepoints.catalog.ASCIIPrintableChars;
import org.terasoluna.gfw.common.codepoints.catalog.CRLF;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0201_Katakana;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0201_LatinLetters;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_BoxDrawingChars;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_CyrillicLetters;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_GreekLetters;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Hiragana;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Kanji;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Katakana;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_LatinLetters;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_SpecialChars;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0213_Kanji;

public class ConsistOfCheckForm implements Serializable {

    private static final long serialVersionUID = -6382121894347244177L;

    @ConsistOf(JIS_X_0208_Hiragana.class)
    private String jisX208Hiragana;

    @ConsistOf({ JIS_X_0208_Hiragana.class, JIS_X_0208_Katakana.class })
    private String jisX208HiraganaKatakana;

    @ConsistOf(ASCIIControlChars.class)
    private String asciiCtrlChars;

    @ConsistOf(ASCIIPrintableChars.class)
    private String asciiPrntChars;

    @ConsistOf(CRLF.class)
    private String crlf;

    @ConsistOf(JIS_X_0201_Katakana.class)
    private String jisX201Katakana;

    @ConsistOf(JIS_X_0201_LatinLetters.class)
    private String jisX201LatinLetters;

    @ConsistOf(JIS_X_0208_SpecialChars.class)
    private String jisX208SpecialChars;

    @ConsistOf(JIS_X_0208_LatinLetters.class)
    private String jisX208LatinLetters;

    @ConsistOf(JIS_X_0208_Katakana.class)
    private String jisX208Katakana;

    @ConsistOf(JIS_X_0208_GreekLetters.class)
    private String jisX208GreekLetteres;

    @ConsistOf(JIS_X_0208_CyrillicLetters.class)
    private String jisX0208CyrillicLetters;

    @ConsistOf(JIS_X_0208_BoxDrawingChars.class)
    private String jisX0208BoxDrawingChars;

    @ConsistOf(JIS_X_0208_Kanji.class)
    private String jisX0208Kanji;

    @ConsistOf(JIS_X_0213_Kanji.class)
    private String jisX0213Kanji;

    @ConsistOf(NumberChars.class)
    private String numberChars;

    @ConsistOf(HiraganaKatakanaChars.class)
    private String hiraganaKatakanaChars;

    @ConsistOf(KanaChars.class)
    private String kanaChars;

    public String getJisX208Hiragana() {
        return jisX208Hiragana;
    }

    public void setJisX208Hiragana(String jisX208Hiragana) {
        this.jisX208Hiragana = jisX208Hiragana;
    }

    public String getJisX208HiraganaKatakana() {
        return jisX208HiraganaKatakana;
    }

    public void setJisX208HiraganaKatakana(String jisX208HiraganaKatakana) {
        this.jisX208HiraganaKatakana = jisX208HiraganaKatakana;
    }

    public String getAsciiCtrlChars() {
        return asciiCtrlChars;
    }

    public void setAsciiCtrlChars(String asciiCtrlChars) {
        this.asciiCtrlChars = asciiCtrlChars;
    }

    public String getAsciiPrntChars() {
        return asciiPrntChars;
    }

    public void setAsciiPrntChars(String asciiPrntChars) {
        this.asciiPrntChars = asciiPrntChars;
    }

    public String getCrlf() {
        return crlf;
    }

    public void setCrlf(String crlf) {
        this.crlf = crlf;
    }

    public String getJisX201Katakana() {
        return jisX201Katakana;
    }

    public void setJisX201Katakana(String jisX201Katakana) {
        this.jisX201Katakana = jisX201Katakana;
    }

    public String getJisX201LatinLetters() {
        return jisX201LatinLetters;
    }

    public void setJisX201LatinLetters(String jisX201LatinLetters) {
        this.jisX201LatinLetters = jisX201LatinLetters;
    }

    public String getJisX208SpecialChars() {
        return jisX208SpecialChars;
    }

    public void setJisX208SpecialChars(String jisX208SpecialChars) {
        this.jisX208SpecialChars = jisX208SpecialChars;
    }

    public String getJisX208LatinLetters() {
        return jisX208LatinLetters;
    }

    public void setJisX208LatinLetters(String jisX208LatinLetters) {
        this.jisX208LatinLetters = jisX208LatinLetters;
    }

    public String getJisX208Katakana() {
        return jisX208Katakana;
    }

    public void setJisX208Katakana(String jisX208Katakana) {
        this.jisX208Katakana = jisX208Katakana;
    }

    public String getJisX208GreekLetteres() {
        return jisX208GreekLetteres;
    }

    public void setJisX208GreekLetteres(String jisX208GreekLetteres) {
        this.jisX208GreekLetteres = jisX208GreekLetteres;
    }

    public String getJisX0208CyrillicLetters() {
        return jisX0208CyrillicLetters;
    }

    public void setJisX0208CyrillicLetters(String jisX0208CyrillicLetters) {
        this.jisX0208CyrillicLetters = jisX0208CyrillicLetters;
    }

    public String getJisX0208BoxDrawingChars() {
        return jisX0208BoxDrawingChars;
    }

    public void setJisX0208BoxDrawingChars(String jisX0208BoxDrawingChars) {
        this.jisX0208BoxDrawingChars = jisX0208BoxDrawingChars;
    }

    public String getJisX0208Kanji() {
        return jisX0208Kanji;
    }

    public void setJisX0208Kanji(String jisX0208Kanji) {
        this.jisX0208Kanji = jisX0208Kanji;
    }

    public String getJisX0213Kanji() {
        return jisX0213Kanji;
    }

    public void setJisX0213Kanji(String jisX0213Kanji) {
        this.jisX0213Kanji = jisX0213Kanji;
    }

    public String getNumberChars() {
        return numberChars;
    }

    public void setNumberChars(String numberChars) {
        this.numberChars = numberChars;
    }

    public String getHiraganaKatakanaChars() {
        return hiraganaKatakanaChars;
    }

    public void setHiraganaKatakanaChars(String hiraganaKatakanaChars) {
        this.hiraganaKatakanaChars = hiraganaKatakanaChars;
    }

    public String getKanaChars() {
        return kanaChars;
    }

    public void setKanaChars(String kanaChars) {
        this.kanaChars = kanaChars;
    }

    public List<String> getFieldNames() {
        ArrayList<String> fieldNameList = new ArrayList<String>();

        for (Field field : this.getClass().getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                fieldNameList.add(field.getName());
            }
        }

        return fieldNameList;
    }

}
