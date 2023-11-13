package org.terasoluna.gfw.functionaltest.config.app;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
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
     * DataSource.driverClassName property.
     */
    @Value("${database.driverClassName}")
    private String driverClassName;

    /**
     * DataSource.url property.
     */
    @Value("${database.url}")
    private String url;

    /**
     * DataSource.username property.
     */
    @Value("${database.username}")
    private String username;

    /**
     * DataSource.password property.
     */
    @Value("${database.password}")
    private String password;

    /**
     * DataSource.maxTotal property.
     */
    @Value("${cp.maxActive}")
    private Integer maxActive;

    /**
     * DataSource.maxIdle property.
     */
    @Value("${cp.maxIdle}")
    private Integer maxIdle;

    /**
     * DataSource.minIdle property.
     */
    @Value("${cp.minIdle}")
    private Integer minIdle;

    /**
     * DataSource.maxWaitMillis property.
     */
    @Value("${cp.maxWait}")
    private Integer maxWait;

    /**
     * Property databaseName.
     */
    @Value("${database}")
    private String database;

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
     * @return Bean of configured {@link BasicDataSource}
     */
    @Bean(name = "dataSource", destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource bean = new BasicDataSource();
        bean.setDriverClassName(driverClassName);
        bean.setUrl(url);
        bean.setUsername(username);
        bean.setPassword(password);
        bean.setDefaultAutoCommit(false);
        bean.setMaxTotal(maxActive);
        bean.setMaxIdle(maxIdle);
        bean.setMinIdle(minIdle);
        bean.setMaxWaitMillis(maxWait);
        return bean;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @param dataSource DataSource defined by #dataSource()
     * @return Bean of configured {@link JdbcSequencer}
     */
    @Bean("integerSeq")
    public JdbcSequencer<Integer> integerSeq(DataSource dataSource) {
        JdbcSequencer<Integer> jdbcSequencer = new JdbcSequencer<Integer>();
        jdbcSequencer.setDataSource(dataSource);
        jdbcSequencer.setSequenceClass(java.lang.Integer.class);
        jdbcSequencer.setNextValueQuery("SELECT nextval('INTEGER_SEQ') AS seq");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT currval('INTEGER_SEQ') AS seq");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @param dataSource DataSource defined by #dataSource()
     * @return Bean of configured {@link JdbcSequencer}
     */
    @Bean("longSeq")
    public JdbcSequencer<Long> longSeq(DataSource dataSource) {
        JdbcSequencer<Long> jdbcSequencer = new JdbcSequencer<Long>();
        jdbcSequencer.setDataSource(dataSource);
        jdbcSequencer.setSequenceClass(java.lang.Long.class);
        jdbcSequencer.setNextValueQuery("SELECT nextval('LONG_SEQ') AS seq");
        jdbcSequencer.setCurrentValueQuery("SELECT currval('LONG_SEQ') AS seq");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @param dataSource DataSource defined by #dataSource()
     * @return Bean of configured {@link JdbcSequencer}
     */
    @Bean("bigIntegerSeq")
    public JdbcSequencer<BigInteger> bigIntegerSeq(DataSource dataSource) {
        JdbcSequencer<BigInteger> jdbcSequencer = new JdbcSequencer<BigInteger>();
        jdbcSequencer.setDataSource(dataSource);
        jdbcSequencer.setSequenceClass(java.math.BigInteger.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT nextval('BIG_INTEGER_SEQ') AS seq");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT currval('BIG_INTEGER_SEQ') AS seq");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @param dataSource DataSource defined by #dataSource()
     * @return Bean of configured {@link JdbcSequencer}
     */
    @Bean("stringSeq")
    public JdbcSequencer<String> stringSeq(DataSource dataSource) {
        JdbcSequencer<String> jdbcSequencer = new JdbcSequencer<String>();
        jdbcSequencer.setDataSource(dataSource);
        jdbcSequencer.setSequenceClass(java.lang.String.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT LPAD(seq,10,'0') FROM (SELECT nextval('STRING_SEQ') AS seq)");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT LPAD(seq,10,'0') FROM (SELECT currval('STRING_SEQ') AS seq)");
        return jdbcSequencer;
    }

    /**
     * Configure {@link JdbcSequencer} bean.
     * @param dataSource DataSource defined by #dataSource()
     * @return Bean of configured {@link JdbcSequencer}
     */
    @Bean("notFoundSeq")
    public JdbcSequencer<Integer> notFoundSeq(DataSource dataSource) {
        JdbcSequencer<Integer> jdbcSequencer = new JdbcSequencer<Integer>();
        jdbcSequencer.setDataSource(dataSource);
        jdbcSequencer.setSequenceClass(java.lang.Integer.class);
        jdbcSequencer.setNextValueQuery(
                "SELECT nextval('NOT_FOUND_SEQ') AS seq");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT currval('NOT_FOUND_SEQ') AS seq");
        return jdbcSequencer;
    }

    /**
     * Configuration to set up database during initialization.
     * @param dataSource Bean defined by #dataSource()
     * @return Bean of configured {@link DataSourceInitializer}
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer bean = new DataSourceInitializer();
        bean.setDataSource(dataSource);

        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("/database/"
                + database + "-schema.sql"));
        databasePopulator.addScript(new ClassPathResource("/database/"
                + database + "-dataload.sql"));
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.setIgnoreFailedDrops(true);
        bean.setDatabasePopulator(databasePopulator);
        return bean;
    }

    /**
     * Configure {@link TransactionManager} bean.
     * @param dataSource Bean defined by #dataSource()
     * @return Bean of configured {@link DataSourceTransactionManager}
     */
    @Bean("dataSourceTransactionManager")
    public TransactionManager dataSourceTransactionManager(
            DataSource dataSource) {
        DataSourceTransactionManager bean = new DataSourceTransactionManager();
        bean.setDataSource(dataSource);
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
