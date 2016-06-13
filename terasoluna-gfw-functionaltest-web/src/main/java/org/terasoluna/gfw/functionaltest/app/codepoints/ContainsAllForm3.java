package org.terasoluna.gfw.functionaltest.app.codepoints;

import java.io.Serializable;

public class ContainsAllForm3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String targetValue;

    private String codePoints[];

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public String[] getCodePoints() {
        return codePoints;
    }

    public void setCodePoints(String codePoints[]) {
        this.codePoints = codePoints;
    }

}
