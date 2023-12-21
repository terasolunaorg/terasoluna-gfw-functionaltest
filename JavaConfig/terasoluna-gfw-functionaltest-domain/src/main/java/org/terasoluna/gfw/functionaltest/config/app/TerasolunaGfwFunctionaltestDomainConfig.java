/*
 * Copyright(c) 2023 NTT Corporation.
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
package org.terasoluna.gfw.functionaltest.config.app;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.terasoluna.gfw.common.exception.ExceptionLogger;
import org.terasoluna.gfw.common.exception.ResultMessagesLoggingInterceptor;
import org.terasoluna.gfw.functionaltest.domain.exception.ResultMessagesInfoLoggingInterceptor;

/**
 * Bean definitions for domain layer.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "org.terasoluna.gfw.functionaltest.domain" })
@Import({ TerasolunaGfwFunctionaltestInfraConfig.class,
        TerasolunaGfwFunctionaltestCodeListConfig.class,
        TerasolunaGfwFunctionaltestJodaConfig.class,
        TerasolunaGfwFunctionaltestJsr310Config.class })
public class TerasolunaGfwFunctionaltestDomainConfig {

    /**
     * Configure {@link LocalValidatorFactoryBean} bean.
     * @return Bean of configured {@link LocalValidatorFactoryBean}
     */
    @Bean("validator")
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    /**
     * Configure {@link MethodValidationPostProcessor} bean.
     * @return Bean of configured {@link MethodValidationPostProcessor}
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(localValidatorFactoryBean());
        return postProcessor;
    }

    /**
     * Configure {@link ResultMessagesLoggingInterceptor} bean.
     * @param exceptionLogger Bean defined by ApplicationContextConfig#exceptionLogger
     * @see org.terasoluna.gfw.functionaltest.config.app.ApplicationContextConfig#exceptionLogger()
     * @return Bean of configured {@link ResultMessagesLoggingInterceptor}
     */
    @Bean("resultMessagesLoggingInterceptor")
    public ResultMessagesLoggingInterceptor resultMessagesLoggingInterceptor(
            @Qualifier("exceptionLogger") ExceptionLogger exceptionLogger) {
        ResultMessagesLoggingInterceptor bean = new ResultMessagesLoggingInterceptor();
        bean.setExceptionLogger(exceptionLogger);
        return bean;
    }

    /**
     * Configure {@link ResultMessagesInfoLoggingInterceptor} bean.
     * @param exceptionLogger Bean defined by ApplicationContextConfig#exceptionLogger
     * @see org.terasoluna.gfw.functionaltest.config.app.ApplicationContextConfig#exceptionLogger()
     * @return Bean of configured {@link ResultMessagesInfoLoggingInterceptor}
     */
    @Bean("resultMessagesInfoLoggingInterceptor")
    public ResultMessagesInfoLoggingInterceptor resultMessagesInfoLoggingInterceptor(
            @Qualifier("exceptionLogger") ExceptionLogger exceptionLogger) {
        ResultMessagesInfoLoggingInterceptor bean = new ResultMessagesInfoLoggingInterceptor();
        bean.setExceptionLogger(exceptionLogger);
        return bean;
    }

    /**
     * Configure messages logging AOP advisor.
     * @param resultMessagesLoggingInterceptor Bean defined by #resultMessagesLoggingInterceptor
     * @see #resultMessagesLoggingInterceptor(ExceptionLogger)
     * @return Advisor configured for PointCut
     */
    @Bean
    public Advisor resultMessagesLoggingInterceptorAdvisor(
            @Qualifier("resultMessagesLoggingInterceptor") ResultMessagesLoggingInterceptor resultMessagesLoggingInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(
                "@within(org.springframework.stereotype.Service) && !@within(org.terasoluna.gfw.functionaltest.domain.exception.InfoLogging)");
        return new DefaultPointcutAdvisor(pointcut, resultMessagesLoggingInterceptor);
    }

    /**
     * Configure messages logging AOP advisor.
     * @param resultMessagesInfoLoggingInterceptor Bean defined by #resultMessagesInfoLoggingInterceptor
     * @see #resultMessagesInfoLoggingInterceptor(ExceptionLogger)
     * @return Advisor configured for PointCut
     */
    @Bean
    public Advisor resultMessagesInfoLoggingInterceptorAdvisor(
            @Qualifier("resultMessagesInfoLoggingInterceptor") ResultMessagesInfoLoggingInterceptor resultMessagesInfoLoggingInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(
                "@within(org.terasoluna.gfw.functionaltest.domain.exception.InfoLogging)");
        return new DefaultPointcutAdvisor(pointcut, resultMessagesInfoLoggingInterceptor);
    }
}
