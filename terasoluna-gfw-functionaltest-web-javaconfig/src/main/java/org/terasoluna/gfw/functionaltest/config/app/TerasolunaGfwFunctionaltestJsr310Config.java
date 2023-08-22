package org.terasoluna.gfw.functionaltest.config.app;

import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.terasoluna.gfw.common.time.ConfigurableAdjustClockFactory;
import org.terasoluna.gfw.common.time.ConfigurableClockFactory;
import org.terasoluna.gfw.common.time.DefaultClockFactory;
import org.terasoluna.gfw.common.time.JdbcAdjustClockFactory;
import org.terasoluna.gfw.common.time.JdbcClockFactory;

/**
 * ClockFactory configuration definition.
 */
@Configuration
public class TerasolunaGfwFunctionaltestJsr310Config {

    /**
     * Configure {@link DefaultClockFactory}.
     * @return Bean of configured {@link DefaultClockFactory}
     */
    @Bean("defaultClockFactory")
    public DefaultClockFactory dateFactory() {
        return new DefaultClockFactory();
    }

    /**
     * Configure {@link ConfigurableClockFactory} bean.
     * @return Bean of configured {@link ConfigurableClockFactory}
     */
    @Bean("defaultConfigurableClockFactory")
    public ConfigurableClockFactory defaultConfigurableClockFactory() {
        ConfigurableClockFactory factory = new ConfigurableClockFactory("2012-09-11T02:25:15");
        return factory;
    }

    /**
     * Configure {@link ConfigurableClockFactory} bean.
     * @return Bean of configured {@link ConfigurableClockFactory}
     */
    @Bean("patternConfigurableClockFactory")
    public ConfigurableClockFactory patternConfigurableClockFactory() {
        ConfigurableClockFactory factory = new ConfigurableClockFactory("2012/09/11 02:25:15", "uuuu/MM/dd HH:mm:ss");
        return factory;
    }

    /**
     * Configure {@link ConfigurableClockFactory} bean.
     * @return Bean of configured {@link ConfigurableClockFactory}
     */
    @Bean("dateAndTimeConfigurableClockFactory")
    public ConfigurableClockFactory dateAndTimeConfigurableClockFactory() {
        ConfigurableClockFactory factory = new ConfigurableClockFactory("2012/09/11 02:25:15", FormatStyle.MEDIUM, FormatStyle.MEDIUM);
        return factory;
    }

    /**
     * Configure {@link ConfigurableAdjustClockFactory} bean.
     * @return Bean of configured {@link ConfigurableAdjustClockFactory}
     */
    @Bean("configurableAdjustClockFactory")
    public ConfigurableAdjustClockFactory configurableAdjustClockFactory() {
        ConfigurableAdjustClockFactory factory = new ConfigurableAdjustClockFactory(1, ChronoUnit.DAYS);
        return factory;
    }

    /**
     * Configure {@link JdbcClockFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcClockFactory}
     */
    @Bean("defaultJdbcClockFactory")
    public JdbcClockFactory defaultJdbcClockFactory(DataSource dataSource) {
        JdbcClockFactory factory = new JdbcClockFactory(dataSource, "SELECT now FROM system_date");
        return factory;
    }

    /**
     * Configure {@link JdbcAdjustClockFactory} bean.
     * @param dataSource DataSource defined by TerasolunaGfwFunctionaltestEnvConfig#dataSource()
     * @return Bean of configured {@link JdbcAdjustClockFactory}
     */
    @Bean("adjustJdbcClockFactory")
    public JdbcAdjustClockFactory adjustJdbcClockFactory(
            DataSource dataSource) {
        JdbcAdjustClockFactory factory = new JdbcAdjustClockFactory(dataSource, "SELECT diff FROM operation_date where operation_date_id='2'", ChronoUnit.SECONDS);
        return factory;
    }
}
