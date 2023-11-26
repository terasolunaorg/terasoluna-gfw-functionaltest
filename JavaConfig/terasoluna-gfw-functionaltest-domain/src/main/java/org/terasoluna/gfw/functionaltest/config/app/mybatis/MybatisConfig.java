/*
 * Copyright(c) 2023 NTT Corporation.
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
package org.terasoluna.gfw.functionaltest.config.app.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeAliasRegistry;

/**
 * Mybatis config.
 */
public class MybatisConfig {

    /**
     * Settings Mybatis config.
     * @return Configured {@link Configuration}
     */
    public static Configuration configuration() {
        Configuration configuration = new Configuration();
        setSettings(configuration);
        setTypeAliases(configuration.getTypeAliasRegistry());
        return configuration;
    }

    /**
     * Settings MyBatis behaves.
     * @param configuration Accepted at configuration
     */
    private static void setSettings(Configuration configuration) {
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
    }

    /**
     * Settings type aliases.
     * @param typeAliasRegistry Accepted at configuration
     */
    private static void setTypeAliases(TypeAliasRegistry typeAliasRegistry) {
        typeAliasRegistry.registerAliases(
                "org.terasoluna.gfw.functionaltest.domain.model");
    }

}
