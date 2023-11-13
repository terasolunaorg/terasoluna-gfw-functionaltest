package org.terasoluna.gfw.functionaltest.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.terasoluna.gfw.functionaltest.app.DBLog;
import org.terasoluna.gfw.functionaltest.app.DBLogProvider;
import org.terasoluna.gfw.functionaltest.app.PageSource;
import org.terasoluna.gfw.functionaltest.app.ScreenCapture;
import org.terasoluna.gfw.functionaltest.app.webdrivers.ChromeDriverFactoryBean;
import org.terasoluna.gfw.functionaltest.app.webdrivers.FirefoxDriverFactoryBean;
import org.terasoluna.gfw.functionaltest.app.webdrivers.HtmlUnitDriverEx;
import org.terasoluna.gfw.functionaltest.domain.DBLogCleaner;

import com.gargoylesoftware.htmlunit.BrowserVersion;

/**
 * Bean definition to SeleniumContext configure.
 */
@Configuration
@EnableTransactionManagement
public class SeleniumContextConfig {

    /**
     * selenium.dbHost property.
     */
    @Value("${selenium.logDbHost}")
    private String dbHost;

    /**
     * selenium.dbPort property.
     */
    @Value("${selenium.logDbPort}")
    private String dbPort;

    /**
     * selenium.htmlUnitBrowserVersion property.
     */
    @Value("${selenium.htmlUnitBrowserVersion}")
    private String htmlUnitBrowserVersion;

    /**
     * Configure {@link PropertySourcesPlaceholderConfigurer} bean.
     * @param properties Path where the property file is located
     * @return Bean of configured {@link PropertySourcesPlaceholderConfigurer}
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(
            @Value("classpath*:META-INF/spring/*.properties") Resource... properties) {
        PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
        bean.setLocations(properties);
        return bean;
    }

    /**
     * Configure the {@link DataSource} bean.
     * @return Bean of configured {@link BasicDataSource}
     */
    @Bean(name = "dataSourceForLogging", destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource bean = new BasicDataSource();
        bean.setDriverClassName("org.h2.Driver");
        bean.setUrl("jdbc:h2:tcp://" + dbHost + ":" + dbPort
                + "/mem:terasoluna-gfw-functionaltest");
        bean.setUsername("sa");
        bean.setPassword("");
        bean.setDefaultAutoCommit(false);
        return bean;
    }

    /**
     * Configure the {@link TransactionManager} bean.
     * @param dataSource Bean defined by #dataSource()
     * @see #dataSource()
     * @return Bean of configured {@link DataSourceTransactionManager}
     */
    @Bean("transactionManager")
    public TransactionManager transactionManager(
            @Qualifier("dataSourceForLogging") DataSource dataSource) {
        DataSourceTransactionManager bean = new DataSourceTransactionManager();
        bean.setDataSource(dataSource);
        bean.setRollbackOnCommitFailure(true);
        return bean;
    }

    /**
     * Configure the {@link ScreenCapture}.
     * @return Bean of configured {@link ScreenCapture}
     */
    @Bean("screenCapture")
    public ScreenCapture screenCapture() {
        return new ScreenCapture();
    }

    /**
     * Configure the {@link PageSource}.
     * @return Bean of configured {@link PageSource}
     */
    @Bean("pageSource")
    public PageSource pageSource() {
        return new PageSource();
    }

    /**
     * Configure the {@link RestTemplate}.
     * @return Bean of configured {@link RestTemplate}
     */
    @Bean("restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Configure the {@link JdbcTemplate} bean.
     * @param DataSource Bean defined by #dataSource()
     * @see #dataSource()
     * @return Bean of configured {@link JdbcTemplate}
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(
            @Qualifier("dataSourceForLogging") DataSource dataSource) {
        JdbcTemplate bean = new JdbcTemplate();
        bean.setDataSource(dataSource);
        bean.setFetchSize(100);
        return bean;
    }

    /**
     * Configure the {@link DBLogProvider}.
     * @param JdbcTemplate Bean defined by #JdbcTemplate()
     * @see #JdbcTemplate()
     * @return Bean of configured {@link DBLogProvider}
     */
    @Bean("dbLogAssertOperations")
    public DBLogProvider dbLogAssertOperations(JdbcTemplate jdbcTemplate) {
        DBLogProvider bean = new DBLogProvider(jdbcTemplate);
        return bean;
    }

    /**
     * Configure the {@link DBLog} bean.
     * @param DataSource Bean defined by #dataSource()
     * @see #dataSource()
     * @return Bean of configured {@link DBLog}
     */
    @Bean("dbLog")
    public DBLog dbLog(
            @Qualifier("dataSourceForLogging") DataSource dataSource) {
        DBLog bean = new DBLog();
        bean.setDataSource(dataSource);
        return bean;
    }

    /**
     * Configure the {@link DBLogCleaner} bean.
     * @param DataSource Bean defined by #dataSource()
     * @see #dataSource()
     * @return Bean of configured {@link DBLogCleaner}
     */
    @Bean("dbLogCleaner")
    public DBLogCleaner dbLogCleaner(
            @Qualifier("dataSourceForLogging") DataSource dataSource) {
        DBLogCleaner bean = new DBLogCleaner();
        bean.setDataSource(dataSource);
        return bean;
    }

    /**
     * Configure the {@link FirefoxDriverFactoryBean} bean.
     * @return Bean of configured {@link FirefoxDriverFactoryBean}
     */
    @Bean("webDriver")
    @Profile({ "firefox", "default" })
    @Scope("prototype")
    public FirefoxDriverFactoryBean firefoxDriverFactoryBean() {
        FirefoxDriverFactoryBean bean = new FirefoxDriverFactoryBean();
        bean.setPropertyFileLocation("wdm.properties");
        return bean;
    }

    /**
     * Configure the {@link ChromeDriverFactoryBean} bean.
     * @return Bean of configured {@link ChromeDriverFactoryBean}
     */
    @Bean("webDriver")
    @Profile({ "chrome" })
    @Scope("prototype")
    public ChromeDriverFactoryBean chromeDriverFactoryBean() {
        ChromeDriverFactoryBean bean = new ChromeDriverFactoryBean();
        bean.setPropertyFileLocation("wdm.properties");
        return bean;
    }

    private BrowserVersion getBrowserVersion(String version) {
        if ("FIREFOX".equals(version)) {
            return BrowserVersion.FIREFOX;
        } else if ("FIREFOX_ESR".equals(version)) {
            return BrowserVersion.FIREFOX_ESR;
        } else if ("CHROME".equals(version)) {
            return BrowserVersion.CHROME;
        } else if ("EDGE".equals(version)) {
            return BrowserVersion.EDGE;
        } else if ("INTERNET_EXPLORER".equals(version)) {
            return BrowserVersion.INTERNET_EXPLORER;
        } else {
            return BrowserVersion.BEST_SUPPORTED;
        }
    }

    /**
     * Configure the {@link HtmlUnitDriverEx} bean.
     * @return Bean of configured {@link HtmlUnitDriverEx}
     */
    @Bean("webDriver")
    @Profile({ "htmlunit" })
    @Scope("prototype")
    public HtmlUnitDriverEx htmlUnitDriverEx() {
        HtmlUnitDriverEx bean = new HtmlUnitDriverEx(getBrowserVersion(
                htmlUnitBrowserVersion), true);
        return bean;
    }

}
