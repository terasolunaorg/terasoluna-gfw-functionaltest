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
package org.terasoluna.gfw.functionaltest.app.codelist;

import java.io.Serializable;

import org.terasoluna.gfw.common.codelist.ExistInCodeList;

/**
 * Customer form object.
 */
public class ExistInCheckWrongCodeListForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExistInCodeList(codeListId = "WRONG_CODELIST")
    private String item5;

    public String getItem5() {
        return item5;
    }

    public void setItem5(String item5) {
        this.item5 = item5;
    }
}
