package org.terasoluna.gfw.functionaltest.app.codepoints;

import java.io.Serializable;

public class ContainsAllForm4 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String targetValue;

    private Integer codePointsA[];

    private Integer codePointsB[];

    private String operation;

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public Integer[] getCodePointsA() {
        return codePointsA;
    }

    public void setCodePointsA(Integer codePointsA[]) {
        this.codePointsA = codePointsA;
    }

    public Integer[] getCodePointsB() {
        return codePointsB;
    }

    public void setCodePointsB(Integer codePointsB[]) {
        this.codePointsB = codePointsB;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
