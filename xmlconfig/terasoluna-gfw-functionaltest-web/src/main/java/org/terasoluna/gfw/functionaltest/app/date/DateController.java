/*
 * Copyright(c) 2013 NTT DATA Corporation.
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

import java.sql.Time;
import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.terasoluna.gfw.common.date.DateConvertUtils;
import org.terasoluna.gfw.common.date.jodatime.JdbcAdjustedJodaTimeDateFactory;
import org.terasoluna.gfw.common.date.jodatime.JodaTimeDateFactory;
import org.terasoluna.gfw.functionaltest.domain.service.date.DateService;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Controller
@RequestMapping(value = "date")
public class DateController {

    @Inject
    @Named("dateFactory")
    protected JodaTimeDateFactory dateFactory;

    @Inject
    @Named("jdbcFixedDateFactory")
    protected JodaTimeDateFactory jdbcFixedDateFactory;

    @Inject
    @Named("dbErrorJdbcFixedDateFactory")
    protected JodaTimeDateFactory dbErrorJdbcFixedDateFactory;

    @Inject
    @Named("msecJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory msecJdbcAdjustedDateFactory;

    @Inject
    @Named("secJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory secJdbcAdjustedDateFactory;

    @Inject
    @Named("minuteJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory minuteJdbcAdjustedDateFactory;

    @Inject
    @Named("hourJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory hourJdbcAdjustedDateFactory;

    @Inject
    @Named("dayJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory dayJdbcAdjustedDateFactory;

    @Inject
    @Named("useCacheDayJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory useCacheDayJdbcAdjustedDateFactory;

    @Inject
    @Named("noCacheJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory noCacheJdbcAdjustedDateFactory;

    @Inject
    @Named("dbErrorJdbcAdjustedDateFactory")
    protected JdbcAdjustedJodaTimeDateFactory dbErrorJdbcAdjustedDateFactory;

    @Inject
    protected DateService dateService;

    private static final DateTimeFormatter JODA_TIME_DATE_FORMATTER = DateTimeFormat
            .forPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @GetMapping
    public String index() {

        return "date/index";
    }

    @GetMapping(value = "1_1")
    public String serverTimeReturn_01_01(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = dateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "1_2")
    public String serverTimeReturn_01_02(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Timestamp timestamp = dateFactory.newTimestamp();

        model.addAttribute("serverTime", timestamp);
        model.addAttribute("type", timestamp.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @GetMapping(value = "1_3")
    public String serverTimeReturn_01_03(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        java.util.Date date = dateFactory.newDate();

        model.addAttribute("serverTime", date);
        model.addAttribute("type", date.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @GetMapping(value = "1_4")
    public String serverTimeReturn_01_04(Model model) {

        model.addAttribute("firstExpectedDate", DateConvertUtils
                .convertToSqlDate(new java.util.Date()));

        java.sql.Date sqlDate = dateFactory.newSqlDate();

        model.addAttribute("serverTime", sqlDate);
        model.addAttribute("type", sqlDate.getClass());
        model.addAttribute("lastExpectedDate", DateConvertUtils
                .convertToSqlDate(new java.util.Date()));

        return "date/dateDisplay";
    }

    @GetMapping(value = "1_5")
    public String serverTimeReturn_01_05(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Time time = dateFactory.newTime();

        model.addAttribute("serverTime", time);
        model.addAttribute("type", time.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/timeDisplay";
    }

    @GetMapping(value = "2_1")
    public String dbFixationTimeReturn_02_01(Model model) {

        DateTime dateTime = jdbcFixedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "2_2")
    public String dbFixationTimeReturn_02_02(Model model) {

        Timestamp timestamp = jdbcFixedDateFactory.newTimestamp();

        model.addAttribute("serverTime", timestamp);
        model.addAttribute("type", timestamp.getClass());

        return "date/dateDisplay";
    }

    @GetMapping(value = "2_3")
    public String dbFixationTimeReturn_02_03(Model model) {

        java.util.Date date = jdbcFixedDateFactory.newDate();

        model.addAttribute("serverTime", date);
        model.addAttribute("type", date.getClass());

        return "date/dateDisplay";
    }

    @GetMapping(value = "2_4")
    public String dbFixationTimeReturn_02_04(Model model) {

        java.sql.Date sqlDate = jdbcFixedDateFactory.newSqlDate();

        model.addAttribute("serverTime", sqlDate);
        model.addAttribute("type", sqlDate.getClass());

        return "date/dateDisplay";
    }

    @GetMapping(value = "2_5")
    public String dbFixationTimeReturn_02_05(Model model) {

        Time time = jdbcFixedDateFactory.newTime();

        model.addAttribute("serverTime", time);
        model.addAttribute("type", time.getClass());

        return "date/timeDisplay";
    }

    @GetMapping(value = "2_6")
    public String dbFixationTimeReturn_02_06(Model model) {

        dbErrorJdbcFixedDateFactory.newTime();

        return "date/timeDisplay";
    }

    @GetMapping(value = "3_1")
    public String adjustedDateReturn_03_01(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = msecJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "3_2")
    public String adjustedDateReturn_03_02(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Timestamp timestamp = msecJdbcAdjustedDateFactory.newTimestamp();

        model.addAttribute("serverTime", timestamp);
        model.addAttribute("type", timestamp.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @GetMapping(value = "3_3")
    public String adjustedDateReturn_03_03(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        java.util.Date date = msecJdbcAdjustedDateFactory.newDate();

        model.addAttribute("serverTime", date);
        model.addAttribute("type", date.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @GetMapping(value = "3_4")
    public String adjustedDateReturn_03_04(Model model) {

        model.addAttribute("firstExpectedDate", DateConvertUtils
                .convertToSqlDate(new java.util.Date()));

        java.sql.Date sqlDate = msecJdbcAdjustedDateFactory.newSqlDate();

        model.addAttribute("serverTime", sqlDate);
        model.addAttribute("type", sqlDate.getClass());
        model.addAttribute("lastExpectedDate", DateConvertUtils
                .convertToSqlDate(new java.util.Date()));

        return "date/dateDisplay";
    }

    @GetMapping(value = "3_5")
    public String adjustedDateReturn_03_05(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Time time = msecJdbcAdjustedDateFactory.newTime();

        model.addAttribute("serverTime", time);
        model.addAttribute("type", time.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/timeDisplay";
    }

    @GetMapping(value = "3_6")
    public String adjustedDateReturn_03_06(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = secJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "3_7")
    public String adjustedDateReturn_03_07(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = minuteJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "3_8")
    public String adjustedDateReturn_03_08(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = hourJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "3_9")
    public String adjustedDateReturn_03_09(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = dayJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "3_10")
    public String adjustedDateReturn_03_10(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = useCacheDayJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "3_11")
    public String adjustedDateReturn_03_11(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = noCacheJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "3_12")
    public String adjustedDateReturn_03_12(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = dbErrorJdbcAdjustedDateFactory.newDateTime();
        String dateTimeStr = dateTime.toString(JODA_TIME_DATE_FORMATTER);

        model.addAttribute("serverTime", dateTimeStr);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @GetMapping(value = "manage")
    public String manage() {
        return "date/dateManage";
    }

    @PostMapping(value = "diff")
    public String updateDiffTime(@RequestParam("diffTime") String diffTime) {
        dateService.updateOperationDate("1", diffTime);
        return "date/index";
    }

    @GetMapping(value = "insertOperationDate")
    public String insertOperationDate() {
        dateService.insertOperationDate("2", "-86400000");
        return "date/index";
    }

    @GetMapping(value = "deleteSystemDate")
    public String deleteSystemDate() {
        dateService.deleteSystemDate(2);
        return "date/index";
    }

    @GetMapping(value = "deleteOperationDate")
    public String deleteOperationDate() {
        dateService.deleteOperationDate(2);
        return "date/index";
    }

    @GetMapping(value = "reload")
    public String reloadAdjustedDate() {
        useCacheDayJdbcAdjustedDateFactory.reload();

        return "date/index";
    }
}
