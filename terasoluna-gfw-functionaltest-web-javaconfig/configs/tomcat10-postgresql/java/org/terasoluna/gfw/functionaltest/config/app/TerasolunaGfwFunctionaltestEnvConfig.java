package org.terasoluna.gfw.functionaltest.config.app;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.config.ContextLifecycleScheduledTaskRegistrar;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.transaction.TransactionManager;
import org.terasoluna.gfw.common.date.jodatime.DefaultJodaTimeDateFactory;
import org.terasoluna.gfw.common.sequencer.JdbcSequencer;
import org.terasoluna.gfw.functionaltest.domain.DBLogCleaner;

import jakarta.persistence.EntityManagerFactory;

/**
 * Define settings for the environment.
 */
@Configuration
public class TerasolunaGfwFunctionaltestEnvConfig {

    /**
     * Configure {@link DefaultJodaTimeDateFactory}.
     * @return Bean of configured {@link DefaultJodaTimeDateFactory}
     */
    @Bean("dateFactory")
    public DefaultJodaTimeDateFactory dateFactory() {
        return new DefaultJodaTimeDateFactory();
    }

    /**
     * Configure {@link DataSource} bean.
     * @return Bean of configured {@link BasicDataSource}
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
                "SELECT TO_CHAR(nextval('STRING_SEQ'),'FM0000000000') AS seq");
        jdbcSequencer.setCurrentValueQuery(
                "SELECT TO_CHAR(currval('STRING_SEQ'),'FM0000000000') AS seq");
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
     * Define the {@link LocalContainerEntityManagerFactoryBean} used in JPA.
     * @param dataSource Bean defined by #dataSource()
     * @param jpaVendorAdapter HibernateJpaVendorAdapter defined by TerasolunaGfwFunctionaltestInfraConfig#jpaVendorAdapter()
     * @return Bean of configured {@link LocalContainerEntityManagerFactoryBean}
     */
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource,
            @Qualifier("jpaVendorAdapter") HibernateJpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = TerasolunaGfwFunctionaltestInfraConfig
                .abstractEntityManagerFactory(jpaVendorAdapter);
        entityManagerFactoryBean.setDataSource(dataSource);
        return entityManagerFactoryBean;
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

    /**
     * Configure {@link DBLogCleaner} bean.
     * @param dataSource Bean defined by #dataSourceForLogging()
     * @return Bean of configured {@link DBLogCleaner}
     */
    @Bean("dbLogCleaner")
    public DBLogCleaner dbLogCleaner(DataSource dataSourceForLogging) {
        DBLogCleaner bean = new DBLogCleaner();
        bean.setDataSource(dataSourceForLogging);
        return bean;
    }

    /**
     * Configure ScheduledTaskRegistrar.
     * @param dbLogCleaner Bean defined by #dbLogCleaner()
     * @return Bean of configured {@link ScheduledTaskRegistrar}
     * @throws NoSuchMethodException if the bean could not get {@link ScheduledTaskRegistrar}
     */
    @Bean("dbLogCleanupTaskScheduler")
    public ScheduledTaskRegistrar dbLogCleanupTaskScheduler(
            DBLogCleaner dbLogCleaner) throws NoSuchMethodException {
        ScheduledTaskRegistrar bean = new ContextLifecycleScheduledTaskRegistrar();
        List<TriggerTask> list = new ArrayList<TriggerTask>();
        list.add(new TriggerTask(dbLogCleanupTaskScheduledMethodRunnable(
                dbLogCleaner), dbLogCleanupTrigger()));
        bean.setTriggerTasksList(list);
        return bean;
    }

    /**
     * Configure ScheduledMethodRunnable.
     * @param dbLogCleaner Bean defined by #dbLogCleaner()
     * @return Bean of configured {@link ScheduledMethodRunnable}
     * @throws NoSuchMethodException if the bean could not get {@link ScheduledMethodRunnable}
     */
    private ScheduledMethodRunnable dbLogCleanupTaskScheduledMethodRunnable(
            DBLogCleaner dbLogCleaner) throws NoSuchMethodException {
        return new ScheduledMethodRunnable(dbLogCleaner, "cleanup");
    }

    /**
     * Configure CronTrigger.
     * @return Bean of configured {@link CronTrigger}
     */
    private CronTrigger dbLogCleanupTrigger() {
        return new CronTrigger("0 0 6 * * ?");
    }
}
