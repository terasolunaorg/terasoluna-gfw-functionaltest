package org.terasoluna.gfw.functionaltest.app.codepoints;

import java.io.Serializable;

public class FirstExcludedCodePointForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String targetValue;

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

}
