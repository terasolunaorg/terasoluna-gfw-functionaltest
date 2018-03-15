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

import java.sql.Time;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.terasoluna.gfw.common.date.DateConvertUtils;
import org.terasoluna.gfw.common.date.jodatime.JodaTimeDateFactory;
import org.terasoluna.gfw.common.date.jodatime.JdbcAdjustedJodaTimeDateFactory;
import org.terasoluna.gfw.functionaltest.domain.service.date.DateService;

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

    @RequestMapping(method = RequestMethod.GET)
    public String index() {

        return "date/index";
    }

    @RequestMapping(value = "1_1", method = RequestMethod.GET)
    public String serverTimeReturn_01_01(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = dateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "1_2", method = RequestMethod.GET)
    public String serverTimeReturn_01_02(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Timestamp timestamp = dateFactory.newTimestamp();

        model.addAttribute("serverTime", timestamp);
        model.addAttribute("type", timestamp.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @RequestMapping(value = "1_3", method = RequestMethod.GET)
    public String serverTimeReturn_01_03(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        java.util.Date date = dateFactory.newDate();

        model.addAttribute("serverTime", date);
        model.addAttribute("type", date.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @RequestMapping(value = "1_4", method = RequestMethod.GET)
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

    @RequestMapping(value = "1_5", method = RequestMethod.GET)
    public String serverTimeReturn_01_05(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Time time = dateFactory.newTime();

        model.addAttribute("serverTime", time);
        model.addAttribute("type", time.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/timeDisplay";
    }

    @RequestMapping(value = "2_1", method = RequestMethod.GET)
    public String dbFixationTimeReturn_02_01(Model model) {

        DateTime dateTime = jdbcFixedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "2_2", method = RequestMethod.GET)
    public String dbFixationTimeReturn_02_02(Model model) {

        Timestamp timestamp = jdbcFixedDateFactory.newTimestamp();

        model.addAttribute("serverTime", timestamp);
        model.addAttribute("type", timestamp.getClass());

        return "date/dateDisplay";
    }

    @RequestMapping(value = "2_3", method = RequestMethod.GET)
    public String dbFixationTimeReturn_02_03(Model model) {

        java.util.Date date = jdbcFixedDateFactory.newDate();

        model.addAttribute("serverTime", date);
        model.addAttribute("type", date.getClass());

        return "date/dateDisplay";
    }

    @RequestMapping(value = "2_4", method = RequestMethod.GET)
    public String dbFixationTimeReturn_02_04(Model model) {

        java.sql.Date sqlDate = jdbcFixedDateFactory.newSqlDate();

        model.addAttribute("serverTime", sqlDate);
        model.addAttribute("type", sqlDate.getClass());

        return "date/dateDisplay";
    }

    @RequestMapping(value = "2_5", method = RequestMethod.GET)
    public String dbFixationTimeReturn_02_05(Model model) {

        Time time = jdbcFixedDateFactory.newTime();

        model.addAttribute("serverTime", time);
        model.addAttribute("type", time.getClass());

        return "date/timeDisplay";
    }

    @RequestMapping(value = "2_6", method = RequestMethod.GET)
    public String dbFixationTimeReturn_02_06(Model model) {

        dbErrorJdbcFixedDateFactory.newTime();

        return "date/timeDisplay";
    }

    @RequestMapping(value = "3_1", method = RequestMethod.GET)
    public String adjustedDateReturn_03_01(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = msecJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "3_2", method = RequestMethod.GET)
    public String adjustedDateReturn_03_02(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Timestamp timestamp = msecJdbcAdjustedDateFactory.newTimestamp();

        model.addAttribute("serverTime", timestamp);
        model.addAttribute("type", timestamp.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @RequestMapping(value = "3_3", method = RequestMethod.GET)
    public String adjustedDateReturn_03_03(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        java.util.Date date = msecJdbcAdjustedDateFactory.newDate();

        model.addAttribute("serverTime", date);
        model.addAttribute("type", date.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateDisplay";
    }

    @RequestMapping(value = "3_4", method = RequestMethod.GET)
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

    @RequestMapping(value = "3_5", method = RequestMethod.GET)
    public String adjustedDateReturn_03_05(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        Time time = msecJdbcAdjustedDateFactory.newTime();

        model.addAttribute("serverTime", time);
        model.addAttribute("type", time.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/timeDisplay";
    }

    @RequestMapping(value = "3_6", method = RequestMethod.GET)
    public String adjustedDateReturn_03_06(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = secJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "3_7", method = RequestMethod.GET)
    public String adjustedDateReturn_03_07(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = minuteJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "3_8", method = RequestMethod.GET)
    public String adjustedDateReturn_03_08(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = hourJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "3_9", method = RequestMethod.GET)
    public String adjustedDateReturn_03_09(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = dayJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "3_10", method = RequestMethod.GET)
    public String adjustedDateReturn_03_10(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = useCacheDayJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "3_11", method = RequestMethod.GET)
    public String adjustedDateReturn_03_11(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = noCacheJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "3_12", method = RequestMethod.GET)
    public String adjustedDateReturn_03_12(Model model) {

        model.addAttribute("firstExpectedDate", new java.util.Date());

        DateTime dateTime = dbErrorJdbcAdjustedDateFactory.newDateTime();

        model.addAttribute("serverTime", dateTime);
        model.addAttribute("type", dateTime.getClass());
        model.addAttribute("lastExpectedDate", new java.util.Date());

        return "date/dateTimeDisplay";
    }

    @RequestMapping(value = "manage", method = RequestMethod.GET)
    public String manage() {
        return "date/dateManage";
    }

    @RequestMapping(value = "diff", method = RequestMethod.POST)
    public String updateDiffTime(@RequestParam("diffTime") String diffTime) {
        dateService.updateOperationDate("1", diffTime);
        return "date/index";
    }

    @RequestMapping(value = "insertOperationDate", method = RequestMethod.GET)
    public String insertOperationDate() {
        dateService.insertOperationDate("2", "-86400000");
        return "date/index";
    }

    @RequestMapping(value = "deleteSystemDate", method = RequestMethod.GET)
    public String deleteSystemDate() {
        dateService.deleteSystemDate(2);
        return "date/index";
    }

    @RequestMapping(value = "deleteOperationDate", method = RequestMethod.GET)
    public String deleteOperationDate() {
        dateService.deleteOperationDate(2);
        return "date/index";
    }

    @RequestMapping(value = "reload", method = RequestMethod.GET)
    public String reloadAdjustedDate() {
        useCacheDayJdbcAdjustedDateFactory.reload();

        return "date/index";
    }
}
