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
package org.terasoluna.gfw.functionaltest.app;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.StringUtils;

public class DBLogProvider {

    private final NamedParameterJdbcOperations jdbcOperations;

    public DBLogProvider(JdbcOperations jdbcOperations) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(jdbcOperations);
    }

    public NamedParameterJdbcOperations getJdbcOperations() {
        return jdbcOperations;
    }

    public void waitForAssertion() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForAssertion(long waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long countContainsByRegexExceptionMessage(String xTrack,
            String loggerNamePattern, String messagePattern,
            String exceptionMessagePattern) {

        StringBuilder sql = new StringBuilder();
        StringBuilder where = new StringBuilder();
        sql.append("SELECT COUNT(e.*) FROM logging_event e");
        where.append(" WHERE e.formatted_message REGEXP :message");

        sql.append(
                " JOIN logging_event_exception ee ON ee.event_id = e.event_id");
        where.append(
                " AND ee.I = '0' AND ee.TRACE_LINE REGEXP :exceptionMessage");

        if (StringUtils.hasText(xTrack)) {
            sql.append(
                    " JOIN logging_event_property ep ON ep.event_id = e.event_id");
            where.append(
                    " AND ep.mapped_key = 'X-Track' AND ep.mapped_value = :xTrack");
        }
        if (StringUtils.hasText(loggerNamePattern)) {
            where.append(" AND e.logger_name REGEXP :loggerName");
        }
        sql.append(where);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("xTrack", xTrack);
        params.addValue("loggerName", loggerNamePattern);
        params.addValue("message", messagePattern);
        params.addValue("exceptionMessage", exceptionMessagePattern);
        Long count = jdbcOperations.queryForObject(sql.toString(), params,
                Long.class);
        return count;
    }

    public long countContainsMessageAndLevels(String message, String level) {

        return countContainsMessageAndLevelsAndLogger(message, level, null);
    }

    public long countContainsMessageAndLevelsAndLogger(String message,
            String level, String loggerName) {

        StringBuilder sql = new StringBuilder();
        sql.append(
                "SELECT COUNT(e.*) FROM logging_event e WHERE e.formatted_message REGEXP :message AND e.level_string = :level");

        if (StringUtils.hasText(loggerName)) {
            sql.append(" AND e.logger_name = :loggerName");
        }

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("message", message);
        params.addValue("level", level);
        params.addValue("loggerName", loggerName);

        Long count = jdbcOperations.queryForObject(sql.toString(), params,
                Long.class);
        return count;
    }

}
