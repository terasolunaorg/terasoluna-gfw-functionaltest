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
package org.terasoluna.gfw.functionaltest.domain.service.date;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.functionaltest.domain.TransactionManagers;

@Service
@Transactional(value = TransactionManagers.DATASOURCE)
public class DateServiceImpl implements DateService {

    private static final String INSERT_OPERATION_DATE = "INSERT INTO operation_date(operation_date_id, diff) VALUES (:operation_date_id, :diff)";

    private static final String UPDATE_DIFF_BY_ID = "UPDATE operation_date SET diff=:diff where operation_date_id=:operation_date_id";

    private static final String DELETE_OPERATION_DATE_BY_ID = "delete from operation_date where operation_date_id=:operation_date_id";

    private static final String DELETE_SYSTEM_DATE_BY_ID = "delete from system_date where system_date_id=:system_date_id";

    @Inject
    protected NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insertOperationDate(String id, String diffTime) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("diff", new Long(diffTime));
        params.put("operation_date_id", new Integer(id));

        jdbcTemplate.update(INSERT_OPERATION_DATE, params);
    }

    @Override
    public void updateOperationDate(String id, String diffTime) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("diff", new Long(diffTime));
        params.put("operation_date_id", new Integer(id));

        jdbcTemplate.update(UPDATE_DIFF_BY_ID, params);
    }

    @Override
    public void deleteOperationDate(int id) {
        jdbcTemplate.update(DELETE_OPERATION_DATE_BY_ID, Collections
                .singletonMap("operation_date_id", new Integer(id)));
    }

    @Override
    public void deleteSystemDate(int id) {
        jdbcTemplate.update(DELETE_SYSTEM_DATE_BY_ID, Collections.singletonMap(
                "system_date_id", new Integer(id)));
    }

}
