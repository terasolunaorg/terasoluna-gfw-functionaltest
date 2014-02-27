/*
 * Copyright (C) 2013 terasoluna.org
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

import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.StringUtils;

public class DBLogProvider {

    private final NamedParameterJdbcOperations jdbcOperations;

    public DBLogProvider (JdbcOperations jdbcOperations) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(jdbcOperations);
    }

    public NamedParameterJdbcOperations getJdbcOperations() {
        return jdbcOperations;
    }

    public long countNotContainsError() {
        return countNotContainsError(null);
    }

    public long countNotContainsError(String xTrack) {
        return countNotContainsLevels(xTrack, "ERROR");
    }

    public long countNotContainsWarn() {
        return countNotContainsWarn(null);
    }

    public long countNotContainsWarn(String xTrack) {
        return countNotContainsLevels(xTrack, "WARN");
    }

    public long countNotContainsWarnAndError() {
        return countNotContainsWarnAndError(null);
    }

    public long countNotContainsWarnAndError(String xTrack) {
        return countNotContainsLevels(xTrack, "WARN", "ERROR");
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

    public long countContainsByMessage(String loggerName, String message) {
        return count(null, loggerName, message);
    }

    public long count(String xTrack, String loggerName,
            String message) {
        long count = getCountInLogContainsByMessage(xTrack, loggerName, message);
        return count;
    }

    public long countContainsByRegexMessage(String loggerNamePattern,
            String messagePattern) {
        return countContainsByRegexMessage(null, loggerNamePattern, messagePattern);
    }

    public long countContainsByRegexMessage(String xTrack,
            String loggerNamePattern, String messagePattern) {
        long count = getCountInLogContainsByRegexMessage(xTrack,
                loggerNamePattern, messagePattern);
        return count;
    }

    public long countContainsByRegexExceptionMessage(String xTrack,
            String loggerNamePattern, String messagePattern,
            String exceptionMessagePattern) {

        StringBuilder sql = new StringBuilder();
        StringBuilder where = new StringBuilder();
        sql.append("SELECT COUNT(e.*) FROM logging_event e");
        where.append(" WHERE e.formatted_message REGEXP :message");

        sql.append(" JOIN logging_event_exception ee ON ee.event_id = e.event_id");
        where.append(" AND ee.I = '0' AND ee.TRACE_LINE REGEXP :exceptionMessage");

        if (StringUtils.hasText(xTrack)) {
            sql.append(" JOIN logging_event_property ep ON ep.event_id = e.event_id");
            where.append(" AND ep.mapped_key = 'X-Track' AND ep.mapped_value = :xTrack");
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

    public long countContainsByRegexStackTrace(String stackTracePattern) {

        StringBuilder sql = new StringBuilder();
        StringBuilder where = new StringBuilder();
        sql.append("SELECT COUNT(e.*) FROM logging_event_exception e");
        where.append(" WHERE e.TRACE_LINE REGEXP :stackTrace");
        sql.append(where);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("stackTrace", stackTracePattern);
        Long count = jdbcOperations.queryForObject(sql.toString(), params,
                Long.class);
        return count;
    }

    public long countNotContainsByMessage(String loggerName, String message) {
        return count(null, loggerName, message);
    }

    public long countNotContainsByMessage(String xTrack, String loggerName,
            String message) {
        long count = getCountInLogContainsByMessage(xTrack, loggerName, message);
        return count;
    }

    public long countNotContainsByRegexMessage(String loggerNamePattern,
            String messagePattern) {
        return countContainsByRegexMessage(null, loggerNamePattern, messagePattern);
    }

    public long countNotContainsByRegexMessage(String xTrack,
            String loggerNamePattern, String messagePattern) {
        long count = getCountInLogContainsByRegexMessage(xTrack,
                loggerNamePattern, messagePattern);
        return count;
    }

    public List<String> getLogByRegexMessage(String xTrack,
            String loggerNamePattern, String messagePattern) {

        StringBuilder sql = new StringBuilder();
        StringBuilder where = new StringBuilder();
        sql.append("SELECT e.formatted_message FROM logging_event e");
        where.append(" WHERE e.formatted_message REGEXP :message");
        if (StringUtils.hasText(xTrack)) {
            sql.append(" JOIN logging_event_property ep ON ep.event_id = e.event_id");
            where.append(" AND ep.mapped_key = 'X-Track' AND ep.mapped_value = :xTrack");
        }
        if (StringUtils.hasText(loggerNamePattern)) {
            where.append(" AND e.logger_name REGEXP :loggerName");
        }
        StringBuilder orderBy = new StringBuilder();
        orderBy.append(" ORDER BY e.event_id ASC");
        sql.append(where).append(orderBy);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("xTrack", xTrack);
        params.addValue("loggerName", loggerNamePattern);
        params.addValue("message", messagePattern);

        return jdbcOperations
                .queryForList(sql.toString(), params, String.class);
    }

    public long countContainsMessageAndLevels(String message, String level) {

        return countContainsMessageAndLevelsAndLogger(message, level, null);
    }

    public long countContainsMessageAndLevelsAndLogger(String message, String level, String loggerName) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(e.*) FROM logging_event e WHERE e.formatted_message REGEXP :message AND e.level_string = :level");

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
    
    protected long countNotContainsLevels(String xTrack, String... levels) {

        StringBuilder sql = new StringBuilder();
        StringBuilder where = new StringBuilder();
        sql.append("SELECT COUNT(e.*) FROM logging_event e");
        where.append(" WHERE e.level_string IN (");
        for (int i = 0; i < levels.length; i++) {
            if (0 < i) {
                where.append(",");
            }
            where.append(":level").append(i);
        }
        where.append(")");
        if (StringUtils.hasText(xTrack)) {
            sql.append(" JOIN logging_event_property ep ON ep.event_id = e.event_id");
            where.append(" AND ep.mapped_key = 'X-Track' AND ep.mapped_value = :xTrack");
        }
        sql.append(where);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("xTrack", xTrack);
        for (int i = 0; i < levels.length; i++) {
            params.addValue("level" + i, levels[i]);
        }
        Long count = jdbcOperations.queryForObject(sql.toString(), params,
                Long.class);
        return count;
    }

    private long getCountInLogContainsByRegexMessage(String xTrack,
            String loggerNamePattern, String messagePattern) {

        StringBuilder sql = new StringBuilder();
        StringBuilder where = new StringBuilder();
        sql.append("SELECT COUNT(e.*) FROM logging_event e");
        where.append(" WHERE e.formatted_message REGEXP :message");
        if (StringUtils.hasText(xTrack)) {
            sql.append(" JOIN logging_event_property ep ON ep.event_id = e.event_id");
            where.append(" AND ep.mapped_key = 'X-Track' AND ep.mapped_value = :xTrack");
        }
        if (StringUtils.hasText(loggerNamePattern)) {
            where.append(" AND e.logger_name REGEXP :loggerName");
        }
        sql.append(where);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("xTrack", xTrack);
        params.addValue("loggerName", loggerNamePattern);
        params.addValue("message", messagePattern);

        return jdbcOperations
                .queryForObject(sql.toString(), params, Long.class);

    }

    private long getCountInLogContainsByMessage(String xTrack,
            String loggerName, String message) {
        StringBuilder sql = new StringBuilder();
        StringBuilder where = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM logging_event e");
        where.append(" WHERE e.formatted_message = :message");
        if (StringUtils.hasText(xTrack)) {
            sql.append("JOIN logging_event_property ep ON ep.event_id = e.event_id AND ep.mapped");
            where.append(" AND ep.mapped_key = 'X-Track' AND ep.mapped_value = :xTrack");
        }
        if (StringUtils.hasText(loggerName)) {
            where.append(" AND e.logger_name = :loggerName");
        }
        sql.append(where);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("xTrack", xTrack);
        params.addValue("loggerName", loggerName);
        params.addValue("message", message);
        return jdbcOperations
                .queryForObject(sql.toString(), params, Long.class);
    }
}
