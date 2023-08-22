package org.terasoluna.gfw.functionaltest.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Bean definition to TestContext configure .
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = TestContextConfig.class)
public class TestContextConfig {

    /**
     * Configure {@link JdbcTemplate} bean.
     * @param dataSource Bean defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcTemplate}
     */
    @Bean
    public JdbcTemplate testJdbcTemplate(DataSource dataSource) {
        JdbcTemplate bean = new JdbcTemplate();
        bean.setDataSource(dataSource);
        return bean;
    }
}
