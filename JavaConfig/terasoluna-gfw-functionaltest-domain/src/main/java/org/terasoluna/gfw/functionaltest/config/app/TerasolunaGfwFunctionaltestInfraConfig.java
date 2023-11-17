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
package org.terasoluna.gfw.functionaltest.config.app;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.terasoluna.gfw.functionaltest.config.app.mybatis.MybatisConfig;
import org.terasoluna.gfw.functionaltest.domain.DBLogCleaner;

import jakarta.inject.Inject;

/**
 * Bean definitions for infrastructure layer.
 */
@Configuration
@EnableJpaRepositories("org.terasoluna.gfw.functionaltest.domain.repository")
@EnableScheduling
@MapperScan("org.terasoluna.gfw.functionaltest.domain.repository")
@Import({ TerasolunaGfwFunctionaltestEnvConfig.class })
public class TerasolunaGfwFunctionaltestInfraConfig implements
                                                    SchedulingConfigurer {

    /**
     * Database property.
     */
    @Value("${database}")
    private Database database;

    /**
     * Bean of DataSource
     */
    @Inject
    private DataSource dataSourceForLogging;

    /**
     * Configure {@link HibernateJpaVendorAdapter} bean.
     * @return Bean of configured {@link HibernateJpaVendorAdapter}
     */
    @Bean("jpaVendorAdapter")
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setShowSql(false);
        bean.setDatabase(database);
        return bean;
    }

    /**
     * Configure {@link LocalContainerEntityManagerFactoryBean} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link LocalContainerEntityManagerFactoryBean}
     */
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean bean = TerasolunaGfwFunctionaltestEnvConfig
                .abstractEntityManagerFactory();
        bean.setPackagesToScan(
                "org.terasoluna.gfw.functionaltest.domain.model");
        bean.setJpaVendorAdapter(jpaVendorAdapter());
        bean.setDataSource(dataSource);

        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("hibernate.hbm2ddl.auto", "none");
        param.put("hibernate.ejb.naming_strategy",
                "org.hibernate.cfg.ImprovedNamingStrategy");
        param.put("hibernate.connection.charSet", "UTF-8");
        param.put("hibernate.show_sql", false);
        param.put("hibernate.format_sql", false);
        param.put("hibernate.use_sql_comments", true);
        param.put("hibernate.jdbc.batch_size", 30);
        param.put("hibernate.jdbc.fetch_size", 100);
        bean.getJpaPropertyMap().putAll(param);

        return bean;
    }

    /**
     * Configure {@link NamedParameterJdbcTemplate} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link NamedParameterJdbcTemplate}
     */
    @Bean("jdbcTemplate")
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        NamedParameterJdbcTemplate bean = new NamedParameterJdbcTemplate(dataSource);
        return bean;
    }

    /**
     * Configure {@link VendorDatabaseIdProvider} bean.
     * @return Bean of configured {@link VendorDatabaseIdProvider}
     */
    @Bean("databaseIdProvider")
    public VendorDatabaseIdProvider databaseIdProvider() {
        VendorDatabaseIdProvider bean = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle", "oracle");
        properties.setProperty("PostgreSQL", "postgres");
        properties.setProperty("H2", "h2");
        bean.setProperties(properties);
        return bean;
    }

    /**
     * Configure {@link SqlSessionFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link SqlSessionFactoryBean}
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(MybatisConfig.configuration());
        bean.setDatabaseIdProvider(databaseIdProvider());
        return bean;
    }

    /**
     * Configure {@link DBLogCleaner} bean.
     * @return Bean of configured {@link DBLogCleaner}
     */
    @Bean("dbLogCleaner")
    public DBLogCleaner dbLogCleaner() {
        DBLogCleaner bean = new DBLogCleaner();
        bean.setDataSource(dataSourceForLogging);
        return bean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(dbLogCleanupTaskScheduler());
        taskRegistrar.addTriggerTask(() -> dbLogCleaner().cleanup(),
                new CronTrigger("0 0 6 * * ?"));
    }

    /**
     * Configure {@link Executor} bean.
     * @return Bean of configured {@link Executor}
     */
    @Bean("dbLogCleanupTaskScheduler")
    public Executor dbLogCleanupTaskScheduler() {
        return Executors.newSingleThreadScheduledExecutor();
    }

}
