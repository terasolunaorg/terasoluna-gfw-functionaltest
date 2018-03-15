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
package org.terasoluna.gfw.functionaltest.domain;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DBLogCleaner {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            DBLogCleaner.class);

    private long savedPeriodMinutes = TimeUnit.MINUTES.toHours(24);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setSavedPeriodMinutes(long savedPeriodMinutes) {
        this.savedPeriodMinutes = savedPeriodMinutes;
    }

    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional
    public void cleanup() {

        if (savedPeriodMinutes < 0) {
            return;
        }

        cleanup(savedPeriodMinutes);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void cleanupAll() {
        LOGGER.info("Begin cleanupAll.");

        cleanup(0L);

        LOGGER.info("Finished cleanupAll.");
    }

    private int cleanup(long savedPeriodMinutes) {
        // calculate cutoff date.
        Date cutoffDate = new Date(System.currentTimeMillis()
                - (TimeUnit.MINUTES.toMillis(savedPeriodMinutes)));

        LOGGER.info("Begin cleanup. cutoffDate is '{}'.", cutoffDate);

        // decide max event id of unnecessary log.
        MapSqlParameterSource queryParameters = new MapSqlParameterSource();
        queryParameters.addValue("cutoffDateMillis", cutoffDate.getTime());
        Long maxEventId = namedParameterJdbcTemplate.queryForObject(
                "SELECT MAX(event_id) FROM logging_event WHERE timestmp < :cutoffDateMillis",
                queryParameters, Long.class);

        // delete unnecessary log.
        int deletedCount = 0;
        if (maxEventId != null) {
            MapSqlParameterSource deleteParameters = new MapSqlParameterSource();
            deleteParameters.addValue("eventId", maxEventId);
            namedParameterJdbcTemplate.update(
                    "DELETE FROM logging_event_exception WHERE event_id <= :eventId",
                    deleteParameters);
            namedParameterJdbcTemplate.update(
                    "DELETE FROM logging_event_property WHERE event_id <= :eventId",
                    deleteParameters);
            deletedCount = namedParameterJdbcTemplate.update(
                    "DELETE FROM logging_event WHERE event_id <= :eventId",
                    deleteParameters);
            LOGGER.info("Finished cleanup. Deleted log count is '{}'.",
                    deletedCount);
        } else {
            LOGGER.info("Finished cleanup. Not exists target log.");
        }
        return deletedCount;
    }

}
