package org.terasoluna.gfw.functionaltest.app.codepoints;

import java.io.Serializable;

public class ContainsAllForm2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String targetValue;

    private Integer codePoints[];

    private String useInstanceKind;

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public Integer[] getCodePoints() {
        return codePoints;
    }

    public void setCodePoints(Integer codePoints[]) {
        this.codePoints = codePoints;
    }

    public String getUseInstanceKind() {
        return useInstanceKind;
    }

    public void setUseInstanceKind(String useInstanceKind) {
        this.useInstanceKind = useInstanceKind;
    }

}
