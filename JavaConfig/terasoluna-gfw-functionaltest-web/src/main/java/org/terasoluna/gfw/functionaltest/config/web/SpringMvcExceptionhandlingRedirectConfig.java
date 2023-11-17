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
package org.terasoluna.gfw.functionaltest.config.web;

import java.util.Properties;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.terasoluna.gfw.common.exception.ExceptionCodeResolver;
import org.terasoluna.gfw.common.exception.ExceptionLogger;
import org.terasoluna.gfw.web.exception.HandlerExceptionResolverLoggingInterceptor;
import org.terasoluna.gfw.web.exception.SystemExceptionResolver;

/**
 * Configure SpringMVC.
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@Import(SpringMvcCommonConfig.class)
public class SpringMvcExceptionhandlingRedirectConfig implements
                                                      WebMvcConfigurer {

    /**
     * Configure {@link SystemExceptionResolver} bean.
     * @param exceptionCodeResolver Bean defined by ApplicationContext#exceptionCodeResolver
     * @see com.example.securelogin.config.app.ApplicationContext#exceptionCodeResolver()
     * @return Bean of configured {@link SystemExceptionResolver}
     */
    @Bean
    public SystemExceptionResolver systemExceptionResolver(
            ExceptionCodeResolver exceptionCodeResolver) {
        SystemExceptionResolver bean = new SystemExceptionResolver();
        bean.setExceptionCodeResolver(exceptionCodeResolver);
        bean.setOrder(3);

        Properties exceptionMappings = new Properties();
        exceptionMappings.setProperty("InvalidTransactionTokenException",
                "common/error/tokenError");
        exceptionMappings.setProperty("ResourceNotFoundException",
                "common/error/notFoundError");
        exceptionMappings.setProperty("BusinessException",
                "common/error/businessError");
        bean.setExceptionMappings(exceptionMappings);

        Properties statusCodes = new Properties();
        statusCodes.setProperty("common/error/tokenError", String.valueOf(
                HttpStatus.CONFLICT.value()));
        statusCodes.setProperty("common/error/notFoundError", String.valueOf(
                HttpStatus.NOT_FOUND.value()));
        statusCodes.setProperty("common/error/businessError", String.valueOf(
                HttpStatus.CONFLICT.value()));
        bean.setStatusCodes(statusCodes);

        bean.setDefaultErrorView("redirect:exceptionHandlingRedirect/3_4_1");
        bean.setDefaultStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return bean;
    }

    /**
     * Configure messages logging AOP.
     * @param exceptionLogger Bean defined by ApplicationContext#exceptionLogger
     * @see com.example.securelogin.config.app.ApplicationContext#exceptionLogger()
     * @return Bean of configured {@link HandlerExceptionResolverLoggingInterceptor}
     */
    @Bean("handlerExceptionResolverLoggingInterceptor")
    public HandlerExceptionResolverLoggingInterceptor handlerExceptionResolverLoggingInterceptor(
            ExceptionLogger exceptionLogger) {
        HandlerExceptionResolverLoggingInterceptor bean = new HandlerExceptionResolverLoggingInterceptor();
        bean.setExceptionLogger(exceptionLogger);
        return bean;
    }

    /**
     * Configure messages logging AOP advisor.
     * @param handlerExceptionResolverLoggingInterceptor Bean defined by #handlerExceptionResolverLoggingInterceptor
     * @see #handlerExceptionResolverLoggingInterceptor(ExceptionLogger)
     * @return Advisor configured for PointCut
     */
    @Bean
    public Advisor handlerExceptionResolverLoggingInterceptorAdvisor(
            HandlerExceptionResolverLoggingInterceptor handlerExceptionResolverLoggingInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(
                "execution(* org.springframework.web.servlet.HandlerExceptionResolver.resolveException(..))");
        return new DefaultPointcutAdvisor(pointcut, handlerExceptionResolverLoggingInterceptor);
    }
}
