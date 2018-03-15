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
package org.terasoluna.gfw.functionaltest.app.date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terasoluna.gfw.functionaltest.app.FunctionTestSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:META-INF/spring/seleniumContext.xml" })
public class DateTest extends FunctionTestSupport {

    private static final DateTimeFormatter dateTimeFormat = DateTimeFormat
            .forPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private static final DateTimeFormatter timeFormat = DateTimeFormat
            .forPattern("HH:mm:ss.SSS");

    @Test
    public void test01_01_serverTimeReturn() {
        driver.findElement(By.id("serverTimeReturn_01_01")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

    }

    @Test
    public void test01_02_serverTimeReturn() {
        driver.findElement(By.id("serverTimeReturn_01_02")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Timestamp"));

    }

    @Test
    public void test01_03_serverTimeReturn() {
        driver.findElement(By.id("serverTimeReturn_01_03")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.util.Date"));

    }

    @Test
    public void test01_04_serverTimeReturn() {
        driver.findElement(By.id("serverTimeReturn_01_04")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Date"));

    }

    @Test
    public void test01_05_serverTimeReturn() {
        driver.findElement(By.id("serverTimeReturn_01_05")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = timeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = timeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = timeFormat.parseDateTime(lastExpectedDateString)
                .getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Time"));

    }

    @Test
    public void test02_01_dbFixationTimeReturn() {
        driver.findElement(By.id("dbFixationTimeReturn_02_01")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();

        // check Date
        assertThat(serverTimeString, is("2013-01-01 01:01:01.000"));

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

    }

    @Test
    public void test02_02_dbFixationTimeReturn() {
        driver.findElement(By.id("dbFixationTimeReturn_02_02")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();

        // check Date
        assertThat(serverTimeString, is("2013-01-01 01:01:01.000"));

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Timestamp"));

    }

    @Test
    public void test02_03_dbFixationTimeReturn() {
        driver.findElement(By.id("dbFixationTimeReturn_02_03")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();

        // check Date
        assertThat(serverTimeString, is("2013-01-01 01:01:01.000"));

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.util.Date"));

    }

    @Test
    public void test02_04_dbFixationTimeReturn() {
        driver.findElement(By.id("dbFixationTimeReturn_02_04")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();

        // check Date
        assertThat(serverTimeString, is("2013-01-01 00:00:00.000"));

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Date"));

    }

    @Test
    public void test02_05_dbFixationTimeReturn() {
        driver.findElement(By.id("dbFixationTimeReturn_02_05")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();

        // check Date
        assertThat(serverTimeString, is("01:01:01.000"));

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Time"));

    }

    @Test
    public void test02_06_dbFixationTimeReturn() {
        driver.findElement(By.id("management")).click();

        // System Date Delete
        driver.findElement(By.id("deleteSystemDate")).click();

        driver.findElement(By.id("dbFixationTimeReturn_02_06")).click();

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Data Access Error..."));

    }

    @Test
    public void test03_01_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "-86400000",
                driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_01")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .plusDays(1).getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

    }

    @Test
    public void test03_02_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "-86400000",
                driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_02")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .plusDays(1).getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Timestamp"));

    }

    @Test
    public void test03_03_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "-86400000",
                driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_03")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .plusDays(1).getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.util.Date"));
    }

    @Test
    public void test03_04_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "-86400000",
                driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_04")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .plusDays(1).getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Date"));

    }

    @Test
    public void test03_05_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "-3600000", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_05")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = timeFormat.parseDateTime(serverTimeString).plusHours(
                1).getMillis();
        long firstExpectedDate = timeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = timeFormat.parseDateTime(lastExpectedDateString)
                .getMillis();

        // converting "actualDate" correctly
        long millisecZeroOclock = timeFormat.parseDateTime("00:00:00.000")
                .getMillis();
        long millisecOneOclock = timeFormat.parseDateTime("01:00:00.000")
                .getMillis();
        long millisecTwentythreeOclock = timeFormat.parseDateTime(
                "23:00:00.000").getMillis();
        int millsecTwentyfourHours = 86400000;
        // 00:00:00.000 <= firstExpectedDate < 01:00:00.000 & 23:00:00.000 <= actualDate
        if (millisecZeroOclock <= firstExpectedDate
                && firstExpectedDate < millisecOneOclock
                && millisecTwentythreeOclock <= actualDate) {
            actualDate = actualDate - millsecTwentyfourHours;
        }

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class java.sql.Time"));

    }

    @Test
    public void test03_06_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "-86400", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_06")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .plusDays(1).getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_07_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "1440", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_07")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).plusDays(1).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).plusDays(1).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

    }

    @Test
    public void test03_08_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "-24", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_08")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .plusDays(1).getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_09_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "1", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_09")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).plusDays(1).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).plusDays(1).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_10_adjustedDateReturn() {
        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "1", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("management")).click();
        driver.findElement(By.id("reloadAdjustedDate")).click();

        driver.findElement(By.id("adjustedDateReturn_03_10")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).plusDays(1).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).plusDays(1).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("Date")).click();

        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "2", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("management")).click();
        driver.findElement(By.id("reloadAdjustedDate")).click();

        driver.findElement(By.id("adjustedDateReturn_03_10")).click();

        // screen date get
        serverTimeString = driver.findElement(By.id("serverTime")).getText();
        firstExpectedDateString = driver.findElement(By.id("firstExpectedDate"))
                .getText();
        lastExpectedDateString = driver.findElement(By.id("lastExpectedDate"))
                .getText();

        // convert String from DateTime
        actualDate = dateTimeFormat.parseDateTime(serverTimeString).getMillis();
        firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).plusDays(2).getMillis();
        lastExpectedDate = dateTimeFormat.parseDateTime(lastExpectedDateString)
                .plusDays(2).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

        // screen capture
        screenCapture.save(driver);
    }

    @Test
    public void test03_11_adjustedDateReturn() {

        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "1", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_11")).click();

        // screen date get
        String serverTimeString = driver.findElement(By.id("serverTime"))
                .getText();
        String firstExpectedDateString = driver.findElement(By.id(
                "firstExpectedDate")).getText();
        String lastExpectedDateString = driver.findElement(By.id(
                "lastExpectedDate")).getText();

        // convert String from DateTime
        long actualDate = dateTimeFormat.parseDateTime(serverTimeString)
                .getMillis();
        long firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).plusDays(1).getMillis();
        long lastExpectedDate = dateTimeFormat.parseDateTime(
                lastExpectedDateString).plusDays(1).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("Date")).click();

        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "3", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_11")).click();

        // screen date get
        serverTimeString = driver.findElement(By.id("serverTime")).getText();
        firstExpectedDateString = driver.findElement(By.id("firstExpectedDate"))
                .getText();
        lastExpectedDateString = driver.findElement(By.id("lastExpectedDate"))
                .getText();

        // convert String from DateTime
        actualDate = dateTimeFormat.parseDateTime(serverTimeString).getMillis();
        firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).plusDays(3).getMillis();
        lastExpectedDate = dateTimeFormat.parseDateTime(lastExpectedDateString)
                .plusDays(3).getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("Date")).click();

        // update adjustedValue
        driver.findElement(By.id("management")).click();
        inputFieldAccessor.overrideValue(By.id("diffTime"), "0", driver);
        driver.findElement(By.id("btn-diff")).click();

        driver.findElement(By.id("adjustedDateReturn_03_11")).click();

        // screen date get
        serverTimeString = driver.findElement(By.id("serverTime")).getText();
        firstExpectedDateString = driver.findElement(By.id("firstExpectedDate"))
                .getText();
        lastExpectedDateString = driver.findElement(By.id("lastExpectedDate"))
                .getText();

        // convert String from DateTime
        actualDate = dateTimeFormat.parseDateTime(serverTimeString).getMillis();
        firstExpectedDate = dateTimeFormat.parseDateTime(
                firstExpectedDateString).getMillis();
        lastExpectedDate = dateTimeFormat.parseDateTime(lastExpectedDateString)
                .getMillis();

        // check Date
        assertDate(actualDate, firstExpectedDate, lastExpectedDate);

        // check return type
        assertThat(driver.findElement(By.id("type")).getText(), is(
                "class org.joda.time.DateTime"));

    }

    @Test
    public void test03_12_adjustedDateReturn() {

        // delete Operation Date
        driver.findElement(By.id("management")).click();
        driver.findElement(By.id("deleteOperationDate")).click();

        driver.findElement(By.id("adjustedDateReturn_03_12")).click();

        // error page screen
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is(
                "Data Access Error..."));

        // screen capture
        screenCapture.save(driver);

        driver.get(applicationContextUrl);
        driver.findElement(By.id("Date")).click();

        // insert adjustedValue
        driver.findElement(By.id("management")).click();
        driver.findElement(By.id("insertOperationDate")).click();
    }

    private void assertDate(long actualDate, long firstExpectedDate,
            long lastExpectedDate) {
        assertThat(actualDate, greaterThanOrEqualTo(firstExpectedDate));
        assertThat(actualDate, lessThanOrEqualTo(lastExpectedDate));
    }
}
