/*
 * Copyright(c) 2024 NTT DATA Group Corporation.
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
package org.terasoluna.gfw.functionaltest.domain.service.download;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.inject.Inject;

@Service
public class DownloadServiceImpl implements DownloadService {
    private static final String FIND_CONTENTS_BY_ID =
            "select contents from document where document_id=:documentId";

    @Inject
    protected NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public InputStream findContentsById(int documentId) {
        InputStream contentsStream = jdbcTemplate.queryForObject(FIND_CONTENTS_BY_ID,
                Collections.singletonMap("documentId", documentId), new RowMapper<InputStream>() {
                    public InputStream mapRow(ResultSet rs, int i) throws SQLException {
                        InputStream blobStream = rs.getBinaryStream("contents");
                        return blobStream;
                    }
                });
        return contentsStream;
    }
}
