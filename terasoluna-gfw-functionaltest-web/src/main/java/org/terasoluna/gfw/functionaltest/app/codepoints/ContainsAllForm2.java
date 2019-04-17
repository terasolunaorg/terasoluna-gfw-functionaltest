/*
 * Copyright(c) 2013 NTT DATA Corporation.
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
