package org.terasoluna.gfw.functionaltest.config.app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.terasoluna.gfw.common.exception.ExceptionCodeResolver;
import org.terasoluna.gfw.common.exception.ExceptionLogger;
import org.terasoluna.gfw.common.exception.SimpleMappingExceptionCodeResolver;
import org.terasoluna.gfw.functionaltest.app.exceptionhandling.ExceptionCodeExceptionLoggingFilter;
import org.terasoluna.gfw.functionaltest.app.exceptionhandling.MessageMappingExceptionCodeResolver;
import org.terasoluna.gfw.functionaltest.app.exceptionhandling.VariationExceptionLevelResolver;
import org.terasoluna.gfw.web.exception.ExceptionLoggingFilter;

/**
 * Application context.
 */
@Configuration
@EnableAspectJAutoProxy
@Import({ TerasolunaGfwFunctionaltestDomainConfig.class })
@ComponentScan(basePackages = {
        "org.terasoluna.gfw.functionaltest.config.env" })
public class ApplicationContextConfig {

    /**
     * Configure {@link PasswordEncoder} bean.
     * @param pbkdf2PasswordEncoder PasswordEncoder defined by #pbkdf2PasswordEncoder()
     * @param bCryptPasswordEncoder PasswordEncoder defined by #bCryptPasswordEncoder()
     * @return Bean of configured {@link DelegatingPasswordEncoder}
     */
    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder(
            Pbkdf2PasswordEncoder pbkdf2PasswordEncoder,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        Map<String, PasswordEncoder> idToPasswordEncoder = new HashMap<>();
        idToPasswordEncoder.put("pbkdf2", pbkdf2PasswordEncoder);
        idToPasswordEncoder.put("bcrypt", bCryptPasswordEncoder);
        return new DelegatingPasswordEncoder("pbkdf2", idToPasswordEncoder);
    }

    /**
     * Configure {@link Pbkdf2PasswordEncoder} bean.
     * @return Bean of configured {@link Pbkdf2PasswordEncoder}
     */
    @Bean
    public Pbkdf2PasswordEncoder pbkdf2PasswordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    /**
     * Configure {@link BCryptPasswordEncoder} bean.
     * @return Bean of configured {@link BCryptPasswordEncoder}
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configure {@link PropertySourcesPlaceholderConfigurer} bean.
     * @param properties Property files to be read
     * @return Bean of configured {@link PropertySourcesPlaceholderConfigurer}
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(
            @Value("classpath*:/META-INF/spring/*.properties") Resource... properties) {
        PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
        bean.setLocations(properties);
        return bean;
    }

    /**
     * Configure {@link MessageSource} bean.
     * @return Bean of configured {@link ResourceBundleMessageSource}
     */
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
        bean.setBasenames("i18n/application-messages");
        return bean;
    }

    /**
     * Configure {@link ExceptionCodeResolver} bean.
     * @return Bean of configured {@link SimpleMappingExceptionCodeResolver}
     */
    @Bean("exceptionCodeResolver")
    public ExceptionCodeResolver exceptionCodeResolver() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("ResourceNotFoundException", "w.xx.0001");
        map.put("BusinessException", "w.xx.0002");
        map.put("InvalidTransactionTokenException", "i.xx.0010");
        map.put("InvalidCSRFTokenException", "i.xx.0010");
        map.put("IndexOutOfBoundsException", "w.xx.0011");
        SimpleMappingExceptionCodeResolver bean = new SimpleMappingExceptionCodeResolver();
        bean.setExceptionMappings(map);
        bean.setDefaultExceptionCode("e.xx.9999");
        return bean;
    }

    /**
     * Configure {@link ExceptionCodeResolver} bean.
     * @return Bean of configured {@link SimpleMappingExceptionCodeResolver}
     */
    @Bean("exceptionCodeResolverNoSet")
    public ExceptionCodeResolver exceptionCodeResolverNoSet() {
        SimpleMappingExceptionCodeResolver bean = new SimpleMappingExceptionCodeResolver();
        return bean;
    }

    /**
     * Configure {@link ExceptionCodeResolver} bean.
     * @return Bean of configured {@link SimpleMappingExceptionCodeResolver}
     */
    @Bean("messageExceptionCodeResolver")
    public ExceptionCodeResolver messageExceptionCodeResolver() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("BusinessMessageException5_6 Error", "w.xx.0001");
        MessageMappingExceptionCodeResolver bean = new MessageMappingExceptionCodeResolver();
        bean.setExceptionMessageMappings(map);
        bean.setDefaultExceptionCode("e.xx.9999");
        return bean;
    }

    /**
     * Configure {@link ExceptionLogger} bean.
     * @param exceptionCodeResolver Bean defined by #exceptionCodeResolver
     * @return Bean of configured {@link ExceptionLogger}
     */
    @Bean("exceptionLogger")
    public ExceptionLogger exceptionLogger(
            ExceptionCodeResolver exceptionCodeResolver) {
        ExceptionLogger bean = new ExceptionLogger();
        bean.setExceptionCodeResolver(exceptionCodeResolver);
        return bean;
    }

    /**
     * Configure {@link ExceptionLogger} bean.
     * @param exceptionCodeResolver Bean defined by #exceptionCodeResolver
     * @param variationExceptionLevelResolver Bean defined by #variationExceptionLevelResolver
     * @return Bean of configured {@link ExceptionLogger}
     */
    @Bean("variationExceptionLogger")
    public ExceptionLogger variationExceptionLogger(
            ExceptionCodeResolver exceptionCodeResolver,
            VariationExceptionLevelResolver variationExceptionLevelResolver) {
        ExceptionLogger bean = new ExceptionLogger();
        bean.setExceptionCodeResolver(exceptionCodeResolver);
        bean.setExceptionLevelResolver(variationExceptionLevelResolver);
        return bean;
    }

    /**
     * Configure {@link VariationExceptionLevelResolver} bean.
     * @return Bean of configured {@link VariationExceptionLevelResolver}
     */
    @Bean("variationExceptionLevelResolver")
    public VariationExceptionLevelResolver variationExceptionLevelResolver() {
        VariationExceptionLevelResolver bean = new VariationExceptionLevelResolver();
        return bean;
    }

    /**
     * Configure {@link ExceptionLogger} bean.
     * @return Bean of configured {@link ExceptionLogger}
     */
    @Bean("changeCodeAndMessageExceptionLogger")
    public ExceptionLogger changeCodeAndMessageExceptionLogger() {
        ExceptionLogger bean = new ExceptionLogger();
        bean.setDefaultMessage("DEFAULT ERROR");
        bean.setDefaultCode("e.00.9999");
        return bean;
    }

    /**
     * Configure {@link ExceptionLogger} bean.
     * @param exceptionCodeResolver Bean defined by #exceptionCodeResolver
     * @return Bean of configured {@link ExceptionLogger}
     */
    @Bean("changeFormatExceptionLogger")
    public ExceptionLogger changeFormatExceptionLogger(
            ExceptionCodeResolver exceptionCodeResolver) {
        ExceptionLogger bean = new ExceptionLogger();
        bean.setExceptionCodeResolver(exceptionCodeResolver);
        bean.setTrimLogMessage(false);
        bean.setLogMessageFormat("[{0}][{1}]");
        return bean;
    }

    /**
     * Configure {@link ExceptionLogger} bean.
     * @return Bean of configured {@link ExceptionLogger}
     */
    @Bean("messageExceptionLogger")
    public ExceptionLogger messageExceptionLogger(
            ExceptionCodeResolver messageExceptionCodeResolver) {
        ExceptionLogger bean = new ExceptionLogger();
        bean.setExceptionCodeResolver(messageExceptionCodeResolver);
        return bean;
    }

    /**
     * Configure {@link ExceptionLoggingFilter} bean.
     * @param exceptionLogger Bean defined by #exceptionLogger
     * @return Bean of configured {@link ExceptionLoggingFilter}
     */
    @Bean("exceptionLoggingFilter")
    public ExceptionLoggingFilter exceptionLoggingFilter(
            ExceptionLogger exceptionLogger) {
        ExceptionLoggingFilter bean = new ExceptionLoggingFilter();
        bean.setExceptionLogger(exceptionLogger);
        return bean;
    }

    /**
     * Configure {@link ExceptionLoggingFilter} bean.
     * @param exceptionLogger Bean defined by #exceptionLogger
     * @return Bean of configured {@link ExceptionLoggingFilter}
     */
    @Bean("variationExceptionLoggingFilter")
    public ExceptionLoggingFilter variationExceptionLoggingFilter(
            ExceptionLogger variationExceptionLogger) {
        ExceptionCodeExceptionLoggingFilter bean = new ExceptionCodeExceptionLoggingFilter();
        bean.setExceptionLogger(variationExceptionLogger);
        return bean;
    }
}
