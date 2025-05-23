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
package org.terasoluna.gfw.functionaltest.app.codelist;

import java.io.Serializable;

import org.terasoluna.gfw.common.codelist.ExistInCodeList;

/**
 * Customer form object.
 */
public class ExistInCheckForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExistInCodeList(codeListId = "SAMPLE_CODELIST")
    private String item1;

    @ExistInCodeList(codeListId = "CHARACTER_CODELIST")
    private Character item2;

    @ExistInCodeList(codeListId = "NUMBER_CODELIST")
    private Integer item3;

    @ExistInCodeList(codeListId = "NUMBER_FORMATTED_CODELIST")
    private Long item4;

    private String item6;

    @ExistInCodeList(codeListId = "SAMPLE_CODELIST",
            message = "This is a custom message notifying that value doesn't exist in sample codelist")
    private String item7;

    @ExistInSampleCodeList
    private String item8;

    @ExistInCodeList.List(value = {@ExistInCodeList(codeListId = "SAMPLE_CODELIST",
            message = "This is a custom message notifying that value doesn't exist in sample codelist"),
            @ExistInCodeList(codeListId = "SAMPLE_MUTIPLE_CODELIST",
                    message = "This is a custom message notifying that value doesn't exist in sample multiple codelist")})
    private String item9;

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public Character getItem2() {
        return item2;
    }

    public void setItem2(Character item2) {
        this.item2 = item2;
    }

    public Integer getItem3() {
        return item3;
    }

    public void setItem3(Integer item3) {
        this.item3 = item3;
    }

    public Long getItem4() {
        return item4;
    }

    public void setItem4(Long item4) {
        this.item4 = item4;
    }

    @ExistInCodeList(codeListId = "SAMPLE_CODELIST")
    public String getItem6() {
        return item6;
    }

    public void setItem6(String item6) {
        this.item6 = item6;
    }

    public String getItem7() {
        return item7;
    }

    public void setItem7(String item7) {
        this.item7 = item7;
    }

    public String getItem8() {
        return item8;
    }

    public void setItem8(String item8) {
        this.item8 = item8;
    }

    public String getItem9() {
        return item9;
    }

    public void setItem9(String item9) {
        this.item9 = item9;
    }
}
