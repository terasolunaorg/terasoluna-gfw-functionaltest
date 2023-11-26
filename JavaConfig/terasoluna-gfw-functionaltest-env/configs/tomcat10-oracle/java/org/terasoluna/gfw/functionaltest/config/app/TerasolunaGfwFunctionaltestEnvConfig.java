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

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.terasoluna.gfw.common.sequencer.JdbcSequencer;
import org.terasoluna.gfw.common.time.DefaultClockFactory;

import jakarta.persistence.EntityManagerFactory;

/**
 * Define settings for the environment.
 */
@Configuration
public class TerasolunaGfwFunctionaltestEnvConfig {

    /**
     * Configure {@link DefaultClockFactory}.
     * @return Bean of configured {@link DefaultClockFactory}
     */
    @Bean("dateFactory")
    public DefaultClockFactory dateFactory() {
        return new DefaultClockFactory();
    }

    /**
     * Configure {@link DataSource} bean.
     * @return Bean of configured {@link JndiObjectFactoryBean}
     * @throws NamingException
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("jdbc/gfwFunctionaltestDataSource");
        bean.setExpectedType(javax.sql.DataSource.class);
        bean.setResourceRef(true);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @return Bean of configured {@link JdbcSequencer}
     * @throws NamingException
     */
    @Bean("integerSeq")
    public JdbcSequencer<Integer> integerSeq() throws NamingException {
        JdbcSequencer<Integer> jdbcSequencer = new JdbcSequencer<Integer>();
        jdbcSequencer.setDataSource(dataSource());
        jdbcSequencer.setSequenceClass(java.lang.Integer.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT INTEGER_SEQ.nextval AS seq FROM DUAL");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT INTEGER_SEQ.currval AS seq FROM DUAL");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @return Bean of configured {@link JdbcSequencer}
     * @throws NamingException
     */
    @Bean("longSeq")
    public JdbcSequencer<Long> longSeq() throws NamingException {
        JdbcSequencer<Long> jdbcSequencer = new JdbcSequencer<Long>();
        jdbcSequencer.setDataSource(dataSource());
        jdbcSequencer.setSequenceClass(java.lang.Long.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT LONG_SEQ.nextval AS seq FROM DUAL");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT LONG_SEQ.currval AS seq FROM DUAL");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @return Bean of configured {@link JdbcSequencer}
     * @throws NamingException
     */
    @Bean("bigIntegerSeq")
    public JdbcSequencer<BigInteger> bigIntegerSeq() throws NamingException {
        JdbcSequencer<BigInteger> jdbcSequencer = new JdbcSequencer<BigInteger>();
        jdbcSequencer.setDataSource(dataSource());
        jdbcSequencer.setSequenceClass(java.math.BigInteger.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT BIG_INTEGER_SEQ.nextval AS seq FROM DUAL");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT BIG_INTEGER_SEQ.currval AS seq FROM DUAL");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @return Bean of configured {@link JdbcSequencer}
     * @throws NamingException
     */
    @Bean("stringSeq")
    public JdbcSequencer<String> stringSeq() throws NamingException {
        JdbcSequencer<String> jdbcSequencer = new JdbcSequencer<String>();
        jdbcSequencer.setDataSource(dataSource());
        jdbcSequencer.setSequenceClass(java.lang.String.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT LPAD(STRING_SEQ.nextval, 10, '0') AS seq FROM DUAL");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT LPAD(STRING_SEQ.currval, 10, '0') AS seq FROM DUAL");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @return Bean of configured {@link JdbcSequencer}
     * @throws NamingException
     */
    @Bean("notFoundSeq")
    public JdbcSequencer<Integer> notFoundSeq() throws NamingException {
        JdbcSequencer<Integer> jdbcSequencer = new JdbcSequencer<Integer>();
        jdbcSequencer.setDataSource(dataSource());
        jdbcSequencer.setSequenceClass(java.lang.Integer.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT NOT_FOUND_SEQ.nextval AS seq FROM DUAL");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT NOT_FOUND_SEQ.currval AS seq FROM DUAL");
        return jdbcSequencer;
    }

    /**
     * Configuration to set up database during initialization.
     * @return Bean of configured {@link DataSourceInitializer}
     * @throws NamingException
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer() throws NamingException {
        DataSourceInitializer bean = new DataSourceInitializer();
        bean.setDataSource(dataSource());
        return bean;
    }

    /**
     * Configure {@link TransactionManager} bean.
     * @return Bean of configured {@link DataSourceTransactionManager}
     * @throws NamingException
     */
    @Bean("dataSourceTransactionManager")
    public TransactionManager dataSourceTransactionManager() throws NamingException {
        DataSourceTransactionManager bean = new DataSourceTransactionManager();
        bean.setDataSource(dataSource());
        bean.setRollbackOnCommitFailure(true);
        return bean;
    }

    /**
     * Configure {@link TransactionManager} bean for use with JPA.
     * @param entityManagerFactory EntityManager used within a transaction
     * @return Bean of configured {@link JpaTransactionManager}
     */
    @Bean("transactionManager")
    public TransactionManager jpaTransactionManager(
            EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager bean = new JpaTransactionManager();
        bean.setEntityManagerFactory(entityManagerFactory);
        return bean;
    }

    /**
     * Configure {@link LocalContainerEntityManagerFactoryBean} bean.
     * @return Bean of configured {@link LocalContainerEntityManagerFactoryBean}
     */
    protected static LocalContainerEntityManagerFactoryBean abstractEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        Map<String, Object> param = new LinkedHashMap<String, Object>();
        bean.setJpaPropertyMap(param);
        return bean;
    }

    /**
     * Configure {@link DataSource} bean.
     * @return Bean of configured {@link BasicDataSource}
     */
    @Bean(name = "dataSourceForLogging", destroyMethod = "close")
    public DataSource dataSourceForLogging() {
        BasicDataSource bean = new BasicDataSource();
        bean.setDriverClassName("org.h2.Driver");
        bean.setUrl(
                "jdbc:h2:mem:terasoluna-gfw-functionaltest;DB_CLOSE_DELAY=-1");
        bean.setUsername("sa");
        bean.setPassword("");
        bean.setDefaultAutoCommit(false);
        return bean;
    }
}
