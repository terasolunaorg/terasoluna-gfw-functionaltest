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
package org.terasoluna.gfw.functionaltest.domain.common.datetime;

import org.terasoluna.gfw.common.codelist.EnumCodeList.CodeListItem;

public enum MonthOfYear implements CodeListItem {

    JANUARY("January", "1"),

    FEBRUARY("February", "2"),

    MARCH("March", "3"),

    APRIL("April", "4"),

    MAY("May", "5"),

    JUNE("June", "6"),

    JULY("July", "7"),

    AUGUST("August", "8"),

    SEPTEMBER("September", "9"),

    OCTOBER("October", "10"),

    NOVEMBER("November", "11"),

    DECEMBER("December", "12");

    private final String label;

    private final String value;

    private MonthOfYear(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String getCodeLabel() {
        return this.label;
    }

    @Override
    public String getCodeValue() {
        return this.value;
    }
}
