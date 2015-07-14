package org.terasoluna.gfw.functionaltest.app.el;

import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class DateForm5 {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    private DateFormItem5 item;

    public DateForm5() {
    }

    public DateForm5(Date date, LocalDate localDate, DateFormItem5 item) {
        this.date = date;
        this.localDate = localDate;
        this.item = item;
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

    public DateFormItem5 getItem() {
        return item;
    }

    public void setItem(DateFormItem5 item) {
        this.item = item;
    }
}
