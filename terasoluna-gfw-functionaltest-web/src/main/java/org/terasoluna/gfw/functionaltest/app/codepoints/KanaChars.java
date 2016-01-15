package org.terasoluna.gfw.functionaltest.app.codepoints;

import org.terasoluna.gfw.common.codepoints.CodePoints;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Katakana;

public class KanaChars extends CodePoints {

	private static final long serialVersionUID = -3521885543489596312L;

	public KanaChars() {
		super(new JIS_X_0208_Katakana().subtract(new CodePoints("｡｢｣､･")));
	}
}
