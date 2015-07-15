package org.terasoluna.gfw.functionaltest.app.el;

import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class DateFormItem5 {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    public DateFormItem5() {
    }

    public DateFormItem5(Date date, LocalDate localDate) {
        this.date = date;
        this.localDate = localDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
