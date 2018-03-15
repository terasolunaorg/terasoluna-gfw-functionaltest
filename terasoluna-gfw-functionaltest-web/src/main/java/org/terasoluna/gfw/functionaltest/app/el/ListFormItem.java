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

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ListFormItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> listA;

    private List<String> listB;

    private List<String> listC;

    public ListFormItem(List<String> listA, List<String> listB,
            List<String> listC) {
        this.listA = listA;
        this.listB = listB;
        this.listC = listC;
    }

    public ListFormItem() {
    }

    public List<String> getListA() {
        return listA;
    }

    public void setListA(List<String> listA) {
        this.listA = listA;
    }

    public List<String> getListB() {
        return listB;
    }

    public void setListB(List<String> listB) {
        this.listB = listB;
    }

    public List<String> getListC() {
        return listC;
    }

    public void setListC(List<String> listC) {
        this.listC = listC;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
