package org.terasoluna.gfw.functionaltest.app.codepoints;

import org.terasoluna.gfw.common.codepoints.CodePoints;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Hiragana;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Katakana;

public class HiraganaKatakanaChars extends CodePoints {
	
	private static final long serialVersionUID = -3934979655604225633L;

	public HiraganaKatakanaChars() {
		super(new JIS_X_0208_Hiragana().union(new  JIS_X_0208_Katakana()));
	}
}
