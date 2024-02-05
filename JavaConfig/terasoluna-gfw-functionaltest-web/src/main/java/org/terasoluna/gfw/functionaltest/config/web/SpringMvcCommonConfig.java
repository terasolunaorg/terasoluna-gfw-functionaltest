/*
 * Copyright(c) 2024 NTT DATA Group Corporation.
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
package org.terasoluna.gfw.functionaltest.config.web;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import org.terasoluna.gfw.web.codelist.CodeListInterceptor;
import org.terasoluna.gfw.web.logging.TraceLoggingInterceptor;
import org.terasoluna.gfw.web.mvc.support.CompositeRequestDataValueProcessor;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenContextHandlerMethodArgumentResolver;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenInterceptor;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenRequestDataValueProcessor;

/**
 * Configuration of SpringMVC common part.
 */
@Configuration
@ComponentScan(basePackages = { "org.terasoluna.gfw.functionaltest.app" })
public class SpringMvcCommonConfig implements WebMvcConfigurer {

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
     * {@inheritDoc}
     */
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(pageableHandlerMethodArgumentResolver());
        argumentResolvers.add(
                transactionTokenContextHandlerMethodArgumentResolver());
    }

    /**
     * Configure {@link PageableHandlerMethodArgumentResolver} bean.
     * @return Bean of configured {@link PageableHandlerMethodArgumentResolver}
     */
    @Bean
    public PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver() {
        return new PageableHandlerMethodArgumentResolver();
    }

    /**
     * Configure {@link TransactionTokenContextHandlerMethodArgumentResolver} bean.
     * @return Bean of configured {@link TransactionTokenContextHandlerMethodArgumentResolver}
     */
    @Bean
    public TransactionTokenContextHandlerMethodArgumentResolver transactionTokenContextHandlerMethodArgumentResolver() {
        return new TransactionTokenContextHandlerMethodArgumentResolver();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome/index");
        registry.addViewController("redirect/withgoto/loginWithGoTo")
                .setViewName("redirect/withgoto/loginWithGoTo");
        registry.addViewController("redirect/withwhitelist/loginWithWhiteList")
                .setViewName("redirect/withwhitelist/loginWithWhiteList");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations(
                "/resources/", "classpath:META-INF/resources/").setCachePeriod(
                        60 * 60);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        addInterceptor(registry, traceLoggingInterceptor(), "/**",
                "/resources/**",
                "/logging/traceLoggingInterceptor/customWarnHandling/**");
        addInterceptor(registry, transactionTokenInterceptor(), "/**",
                "/resources/**",
                "/transactiontoken/customTransactionStoreSize2/**",
                "/transactiontoken/customTransactionStoreSize1/**");
        addInterceptor(registry, size2TransactionTokenInterceptor(),
                "/transactiontoken/customTransactionStoreSize2/**");
        addInterceptor(registry, size1TransactionTokenInterceptor(),
                "/transactiontoken/customTransactionStoreSize1/**");
        addInterceptor(registry, localeChangeInterceptor(), "/**",
                "/resources/**");
        addWebRequestInterceptor(registry, openEntityManagerInViewInterceptor(),
                "/**", "/resources/**");
        addInterceptor(registry, anyPathCodeListInterceptor(), "/**",
                "/resources/**", "/codelist/noPattern/**",
                "/codelist/jdbcCodeListTestDBError/**");
        addInterceptor(registry, multiplePatternListInterceptor(),
                "/codelist/multiplePattern/**");
        addInterceptor(registry, jdbcCodeListInterceptor(),
                "/codelist/jdbcCodeListTestDBError/**");
        addInterceptor(registry, warnHandlingTraceLoggingInterceptor(),
                "/logging/traceLoggingInterceptor/customWarnHandling/**");
    }

    /**
     * Common processes used in #addInterceptors.
     * @param registry {@link InterceptorRegistry}
     * @param interceptor {@link HandlerInterceptor}
     * @param mappingPath target path
     * @param excludePath paths to exclude
     */
    private void addInterceptor(InterceptorRegistry registry,
            HandlerInterceptor interceptor, String mappingPath,
            String... excludePath) {
        registry.addInterceptor(interceptor).addPathPatterns(mappingPath)
                .excludePathPatterns(excludePath);
    }

    /**
     * Common processes used in #addInterceptors.
     * @param registry {@link InterceptorRegistry}
     * @param interceptor {@link WebRequestInterceptor}
     * @param mappingPath target path
     * @param excludePath paths to exclude
     */
    private void addWebRequestInterceptor(InterceptorRegistry registry,
            WebRequestInterceptor interceptor, String mappingPath,
            String... excludePath) {
        registry.addWebRequestInterceptor(interceptor).addPathPatterns(
                mappingPath).excludePathPatterns(excludePath);
    }

    /**
     * Configure {@link TraceLoggingInterceptor} bean.
     * @return Bean of configured {@link TraceLoggingInterceptor}
     */
    @Bean
    public TraceLoggingInterceptor traceLoggingInterceptor() {
        return new TraceLoggingInterceptor();
    }

    /**
     * Configure {@link TransactionTokenInterceptor} bean.
     * @return Bean of configured {@link TransactionTokenInterceptor}
     */
    @Bean
    public TransactionTokenInterceptor transactionTokenInterceptor() {
        return new TransactionTokenInterceptor();
    }

    /**
     * Configure {@link TransactionTokenInterceptor} bean.
     * @return Bean of configured {@link TransactionTokenInterceptor}
     */
    @Bean
    public TransactionTokenInterceptor size2TransactionTokenInterceptor() {
        TransactionTokenInterceptor bean = new TransactionTokenInterceptor(2);
        return bean;
    }

    /**
     * Configure {@link TransactionTokenInterceptor} bean.
     * @return Bean of configured {@link TransactionTokenInterceptor}
     */
    @Bean
    public TransactionTokenInterceptor size1TransactionTokenInterceptor() {
        TransactionTokenInterceptor bean = new TransactionTokenInterceptor(1);
        return bean;
    }

    /**
     * Configure {@link LocaleChangeInterceptor} bean.
     * @return Bean of configured {@link LocaleChangeInterceptor}
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    /**
     * Configure {@link OpenEntityManagerInViewInterceptor} bean.
     * @return Bean of configured {@link OpenEntityManagerInViewInterceptor}
     */
    @Bean
    public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
        return new OpenEntityManagerInViewInterceptor();
    }

    /**
     * Configure {@link CodeListInterceptor} bean.
     * @return Bean of configured {@link CodeListInterceptor}
     */
    @Bean
    public CodeListInterceptor anyPathCodeListInterceptor() {
        CodeListInterceptor bean = new CodeListInterceptor();
        bean.setCodeListIdPattern(Pattern.compile("CL_.+"));
        return bean;
    }

    /**
     * Configure {@link CodeListInterceptor} bean.
     * @return Bean of configured {@link CodeListInterceptor}
     */
    @Bean
    public CodeListInterceptor multiplePatternListInterceptor() {
        CodeListInterceptor bean = new CodeListInterceptor();
        bean.setCodeListIdPattern(Pattern.compile("CL_.+|SAMPLE_.+"));
        return bean;
    }

    /**
     * Configure {@link CodeListInterceptor} bean.
     * @return Bean of configured {@link CodeListInterceptor}
     */
    @Bean
    public CodeListInterceptor jdbcCodeListInterceptor() {
        CodeListInterceptor bean = new CodeListInterceptor();
        bean.setCodeListIdPattern(Pattern.compile("CL_CODELIST_WRONG_ITEM"));
        return bean;
    }

    /**
     * Configure {@link TraceLoggingInterceptor} bean.
     * @return Bean of configured {@link TraceLoggingInterceptor}
     */
    @Bean
    public TraceLoggingInterceptor warnHandlingTraceLoggingInterceptor() {
        TraceLoggingInterceptor bean = new TraceLoggingInterceptor();
        bean.setWarnHandlingNanos(5L * 1000L * 1000L * 1000L);
        return bean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.beanName();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    /**
     * Configure {@link SessionLocaleResolver} bean.
     * @return Bean of configured {@link SessionLocaleResolver}
     */
    @Bean("localeResolver")
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver bean = new SessionLocaleResolver();
        bean.setDefaultLocale(Locale.ENGLISH);
        return bean;
    }

    /**
     * Configure {@link StandardServletMultipartResolver} bean.
     * @return Bean of configured {@link StandardServletMultipartResolver}
     */
    @Bean("multipartResolver")
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    /**
     * Configure {@link RequestDataValueProcessor} bean.
     * @return Bean of configured {@link CompositeRequestDataValueProcessor}
     */
    @Bean("requestDataValueProcessor")
    public RequestDataValueProcessor requestDataValueProcessor() {
        return new CompositeRequestDataValueProcessor(csrfRequestDataValueProcessor(), transactionTokenRequestDataValueProcessor());
    }

    /**
     * Configure {@link CsrfRequestDataValueProcessor} bean.
     * @return Bean of configured {@link CsrfRequestDataValueProcessor}
     */
    @Bean
    public CsrfRequestDataValueProcessor csrfRequestDataValueProcessor() {
        return new CsrfRequestDataValueProcessor();
    }

    /**
     * Configure {@link TransactionTokenRequestDataValueProcessor} bean.
     * @return Bean of configured {@link TransactionTokenRequestDataValueProcessor}
     */
    @Bean
    public TransactionTokenRequestDataValueProcessor transactionTokenRequestDataValueProcessor() {
        return new TransactionTokenRequestDataValueProcessor();
    }
}
