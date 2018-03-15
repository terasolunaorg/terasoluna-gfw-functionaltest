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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

public class DBLog {

    private static final Logger logger = LoggerFactory.getLogger(DBLog.class);

    @Value("${selenium.enableDbLog}")
    protected boolean enableDbLog;

    private File evidenceSavingDirectory;

    private JdbcTemplate jdbcTemplate;

    private final AtomicInteger sequence = new AtomicInteger(0);

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setFetchSize(500);
    }

    public void setUp(File evidenceSavingDirectory) {
        sequence.set(0);
        this.evidenceSavingDirectory = evidenceSavingDirectory;
    }

    public void save() {
        save((String) null);
    }

    public void save(String subTitle) {
        if (!enableDbLog) {
            return;
        }
        saveForced(subTitle);
    }

    public void saveForced(String subTitle) {

        if (StringUtils.isEmpty(subTitle)) {
            subTitle = "";
        } else {
            subTitle = "-" + subTitle;
        }

        int sequenceNo = sequence.incrementAndGet();

        writeLog("SELECT * FROM logging_event ORDER BY event_id ASC",
                sequenceNo, subTitle, "logging_event");

        writeLog(
                "SELECT * FROM logging_event_property ORDER BY event_id ASC, mapped_key ASC",
                sequenceNo, subTitle, "logging_event_property");

        writeLog(
                "SELECT * FROM logging_event_exception ORDER BY event_id ASC, i ASC",
                sequenceNo, subTitle, "logging_event_exception");

    }

    private void writeLog(String sql, int sequenceNo, String subTitle,
            String tableName) {
        String evidenceFile = String.format("dblog_%03d%s-%s.log", sequenceNo,
                subTitle, tableName);
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        try {
            FileUtils.writeLines(
                    new File(evidenceSavingDirectory, evidenceFile), results);
        } catch (IOException e) {
            logger.error(e.toString());
        } finally {
            results.clear();
            results = null;
        }
    }

}
