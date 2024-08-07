/*
 * Copyright(c) 2024 NTT DATA Group Corporation.
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
package org.terasoluna.gfw.functionaltest.app.string;

import java.io.Serializable;

public class FullHalfForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String halfwidth;

    private String fullwidth;

    public String getHalfwidth() {
        return halfwidth;
    }

    public void setHalfwidth(String halfwidth) {
        this.halfwidth = halfwidth;
    }

    public String getFullwidth() {
        return fullwidth;
    }

    public void setFullwidth(String fullwidth) {
        this.fullwidth = fullwidth;
    }

}
