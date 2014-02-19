package org.terasoluna.gfw.functionaltest.app.codelist;

import org.terasoluna.gfw.common.codelist.EnumCodeList.CodeListItem;

public enum LabelNames implements CodeListItem {

    label1("key1"),

    label2("key2"),

    label3("key3");

    private String value;

    private LabelNames(String value) {
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
