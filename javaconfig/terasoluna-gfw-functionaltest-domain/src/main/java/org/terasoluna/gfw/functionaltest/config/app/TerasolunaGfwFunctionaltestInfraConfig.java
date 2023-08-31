package org.terasoluna.gfw.functionaltest.config.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.config.ContextLifecycleScheduledTaskRegistrar;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.terasoluna.gfw.functionaltest.config.app.mybatis.MybatisConfig;
import org.terasoluna.gfw.functionaltest.domain.DBLogCleaner;

/**
 * Bean definitions for infrastructure layer.
 */
@Configuration
@EnableJpaRepositories("org.terasoluna.gfw.functionaltest.domain.repository")
@MapperScan("org.terasoluna.gfw.functionaltest.domain.repository")
@Import({ TerasolunaGfwFunctionaltestEnvConfig.class })
public class TerasolunaGfwFunctionaltestInfraConfig {

    /**
     * Database property.
     */
    @Value("${database}")
    Database database;

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
     * @param jpaVendorAdapter DataSource defined by #jpaVendorAdapter()
     * @return Bean of configured {@link LocalContainerEntityManagerFactoryBean}
     */
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource,
            @Qualifier("jpaVendorAdapter") HibernateJpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean bean = TerasolunaGfwFunctionaltestEnvConfig
                .abstractEntityManagerFactory();
        bean.setPackagesToScan(
                "org.terasoluna.gfw.functionaltest.domain.model");
        bean.setJpaVendorAdapter(jpaVendorAdapter);
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
     * @param databaseIdProvider defined by #databaseIdProvider()
     * @return Bean of configured {@link SqlSessionFactoryBean}
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource,
            @Qualifier("databaseIdProvider") VendorDatabaseIdProvider databaseIdProvider) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(MybatisConfig.configuration());
        bean.setDatabaseIdProvider(databaseIdProvider);
        return bean;
    }

    /**
     * Configure {@link DBLogCleaner} bean.
     * @param dataSource Bean defined by TerasolunaGfwFunctionaltestEnvConfig#dataSourceForLogging()
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
