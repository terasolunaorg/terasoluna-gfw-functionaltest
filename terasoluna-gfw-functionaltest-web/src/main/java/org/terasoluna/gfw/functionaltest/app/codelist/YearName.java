package org.terasoluna.gfw.functionaltest.app.codelist;

import org.terasoluna.gfw.common.codelist.EnumCodeList.CodeListItem;

public enum YearName implements CodeListItem {

    January("1"),

    February("2"),

    March("3"),

    April("4"),

    May("5"),

    June("6"),

    July("7"),

    August("8"),

    September("9"),

    October("10"),

    November("11"),

    December("12");

    private String value;

    private YearName(String value) {
        this.value = value;
    }

    @Override
    public String getCodeLabel() {
        return this.name();
    }

    @Override
    public String getCodeValue() {
        return this.value;
    }
}
