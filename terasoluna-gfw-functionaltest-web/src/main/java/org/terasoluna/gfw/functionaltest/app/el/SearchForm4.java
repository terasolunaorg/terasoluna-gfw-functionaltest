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
package org.terasoluna.gfw.functionaltest.app.el;

import java.util.Map;

public class SearchForm4 {
    private Map<String, String> etc;

    public SearchForm4(Map<String, String> etc) {
        this.etc = etc;
    }

    public SearchForm4() {
    }

    public Map<String, String> getEtc() {
        return etc;
    }

    public void setEtc(Map<String, String> etc) {
        this.etc = etc;
    }
}
