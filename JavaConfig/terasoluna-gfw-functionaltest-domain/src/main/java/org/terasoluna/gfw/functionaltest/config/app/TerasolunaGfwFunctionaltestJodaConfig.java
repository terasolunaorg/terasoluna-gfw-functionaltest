package org.terasoluna.gfw.functionaltest.config.app;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.terasoluna.gfw.common.date.jodatime.DefaultJodaTimeDateFactory;
import org.terasoluna.gfw.common.date.jodatime.JdbcAdjustedJodaTimeDateFactory;
import org.terasoluna.gfw.common.date.jodatime.JdbcFixedJodaTimeDateFactory;

/**
 * JodaTimeDateFactory configuration definition.
 */
@Configuration
public class TerasolunaGfwFunctionaltestJodaConfig {

    /**
     * Configure {@link DefaultJodaTimeDateFactory}.
     * @return Bean of configured {@link DefaultJodaTimeDateFactory}
     */
    @Bean("dateFactory")
    public DefaultJodaTimeDateFactory dateFactory() {
        return new DefaultJodaTimeDateFactory();
    }

    /**
     * Configure {@link JdbcFixedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcFixedJodaTimeDateFactory}
     */
    @Bean("jdbcFixedDateFactory")
    public JdbcFixedJodaTimeDateFactory jdbcFixedJodaTimeDateFactory(
            DataSource dataSource) {
        JdbcFixedJodaTimeDateFactory factory = new JdbcFixedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setCurrentTimestampQuery(
                "SELECT now FROM system_date where system_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcFixedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcFixedJodaTimeDateFactory}
     */
    @Bean("dbErrorJdbcFixedDateFactory")
    public JdbcFixedJodaTimeDateFactory dbErrorJdbcFixedDateFactory(
            DataSource dataSource) {
        JdbcFixedJodaTimeDateFactory factory = new JdbcFixedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setCurrentTimestampQuery(
                "SELECT now FROM system_date where system_date_id='2'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("msecJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory msecJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setAdjustedValueQuery(
                "SELECT diff FROM operation_date where operation_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("secJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory secJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setAdjustedValueQuery(
                "SELECT diff * 1000 FROM operation_date where operation_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("minuteJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory minuteJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setAdjustedValueQuery(
                "SELECT diff * 60 * 1000 FROM operation_date where operation_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("hourJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory hourJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setAdjustedValueQuery(
                "SELECT diff * 60 * 60 * 1000 FROM operation_date where operation_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("dayJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory dayJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setAdjustedValueQuery(
                "SELECT diff * 24 * 60 * 60 * 1000 FROM operation_date where operation_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("useCacheDayJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory useCacheDayJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setUseCache(true);
        factory.setAdjustedValueQuery(
                "SELECT diff * 24 * 60 * 60 * 1000 FROM operation_date where operation_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("noCacheJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory noCacheJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setUseCache(false);
        factory.setAdjustedValueQuery(
                "SELECT diff * 24 * 60 * 60 * 1000 FROM operation_date where operation_date_id='1'");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustedJodaTimeDateFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustedJodaTimeDateFactory}
     */
    @Bean("dbErrorJdbcAdjustedDateFactory")
    public JdbcAdjustedJodaTimeDateFactory dbErrorJdbcAdjustedDateFactory(
            DataSource dataSource) {
        JdbcAdjustedJodaTimeDateFactory factory = new JdbcAdjustedJodaTimeDateFactory();
        factory.setDataSource(dataSource);
        factory.setAdjustedValueQuery(
                "SELECT diff * 24 * 60 * 60 * 1000 FROM operation_date where operation_date_id='2'");
        return factory;
    }
}
