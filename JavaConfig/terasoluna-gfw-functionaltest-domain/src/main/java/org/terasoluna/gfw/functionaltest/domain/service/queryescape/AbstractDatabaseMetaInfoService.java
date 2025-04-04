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
package org.terasoluna.gfw.functionaltest.domain.service.queryescape;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public abstract class AbstractDatabaseMetaInfoService implements DatabaseMetaInfoService {
    private String databaseId;

    private String oracleVersion;

    @Inject
    OracleVersionRetriever oracleVersionRetriever;

    @Override
    public final String getDatabaseId() {
        return this.databaseId;
    }

    @Override
    public String getOracleVersion() {
        return this.oracleVersion;
    }

    protected abstract String getDatabaseIdInternal();

    @PostConstruct
    public void init() {
        this.databaseId = getDatabaseIdInternal();
        if ("oracle".equalsIgnoreCase(this.databaseId)) {
            this.oracleVersion = oracleVersionRetriever.getVersion();
        }
    }
}
