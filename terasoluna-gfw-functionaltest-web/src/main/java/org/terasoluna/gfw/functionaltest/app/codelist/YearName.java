package org.terasoluna.gfw.functionaltest.app.codelist;

import org.terasoluna.gfw.common.codelist.EnumCodeList.CodeListItem;

public enum YearName implements CodeListItem {

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

    private String label;

    private String value;

    private YearName(String label, String value) {
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
