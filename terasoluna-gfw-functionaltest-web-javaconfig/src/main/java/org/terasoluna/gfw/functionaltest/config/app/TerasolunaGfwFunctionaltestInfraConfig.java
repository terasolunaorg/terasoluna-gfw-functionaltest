package org.terasoluna.gfw.functionaltest.config.app;

import java.util.LinkedHashMap;
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
import org.terasoluna.gfw.functionaltest.config.app.mybatis.MybatisConfig;

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
     * @param jpaVendorAdapter HibernateJpaVendorAdapter defined by #jpaVendorAdapter()
     * @return Bean of configured {@link LocalContainerEntityManagerFactoryBean}
     */
    protected static LocalContainerEntityManagerFactoryBean abstractEntityManagerFactory(
            HibernateJpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan(
                "org.terasoluna.gfw.functionaltest.domain.model");
        bean.setJpaVendorAdapter(jpaVendorAdapter);
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
        bean.setJpaPropertyMap(param);
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
}
