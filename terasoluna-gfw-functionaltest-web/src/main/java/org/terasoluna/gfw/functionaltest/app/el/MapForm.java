/*
 * Copyright (C) 2013-2015 terasoluna.org
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
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MapForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, String> mapA;

    private MapFormItem item;

    public MapForm(Map<String, String> mapA, MapFormItem item) {
        this.mapA = mapA;
        this.item = item;
    }

    public MapForm() {
    }

    public Map<String, String> getMapA() {
        return mapA;
    }

    public void setMapA(Map<String, String> mapA) {
        this.mapA = mapA;
    }

    public MapFormItem getItem() {
        return item;
    }

    public void setItem(MapFormItem item) {
        this.item = item;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
