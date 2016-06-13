package org.terasoluna.gfw.functionaltest.app.codepoints;

import java.io.Serializable;

public class ContainsAllForm1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String targetValue;

    private String useInstanceKind;

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public String getUseInstanceKind() {
        return useInstanceKind;
    }

    public void setUseInstanceKind(String useInstanceKind) {
        this.useInstanceKind = useInstanceKind;
    }

}
