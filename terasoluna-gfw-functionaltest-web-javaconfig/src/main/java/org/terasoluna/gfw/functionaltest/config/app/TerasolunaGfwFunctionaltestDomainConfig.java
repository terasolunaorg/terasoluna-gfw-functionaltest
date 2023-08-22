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
import org.terasoluna.gfw.common.exception.ExceptionCodeResolver;
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
     * @param validator Validator defined by #localValidatorFactoryBean()
     * @return Bean of configured {@link MethodValidationPostProcessor}
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(
            @Qualifier("validator") LocalValidatorFactoryBean localValidatorFactoryBean) {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(localValidatorFactoryBean);
        return postProcessor;
    }

    /**
     * Configure {@link ResultMessagesLoggingInterceptor} bean.
     * @param exceptionLogger Bean defined by ApplicationContextConfig#exceptionLogger
     * @see org.terasoluna.gfw.functionaltest.config.app.ApplicationContextConfig#exceptionLogger(ExceptionCodeResolver)
     * @return Bean of configured {@link ResultMessagesLoggingInterceptor}
     */
    @Bean("resultMessagesLoggingInterceptor")
    public ResultMessagesLoggingInterceptor resultMessagesLoggingInterceptor(
            ExceptionLogger exceptionLogger) {
        ResultMessagesLoggingInterceptor bean = new ResultMessagesLoggingInterceptor();
        bean.setExceptionLogger(exceptionLogger);
        return bean;
    }

    /**
     * Configure {@link ResultMessagesInfoLoggingInterceptor} bean.
     * @param exceptionLogger Bean defined by ApplicationContextConfig#exceptionLogger
     * @see org.terasoluna.gfw.functionaltest.config.app.ApplicationContextConfig#exceptionLogger(ExceptionCodeResolver)
     * @return Bean of configured {@link ResultMessagesInfoLoggingInterceptor}
     */
    @Bean("resultMessagesInfoLoggingInterceptor")
    public ResultMessagesInfoLoggingInterceptor resultMessagesInfoLoggingInterceptor(
            ExceptionLogger exceptionLogger) {
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
            ResultMessagesLoggingInterceptor resultMessagesLoggingInterceptor) {
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
            ResultMessagesInfoLoggingInterceptor resultMessagesInfoLoggingInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(
                "@within(org.terasoluna.gfw.functionaltest.domain.exception.InfoLogging)");
        return new DefaultPointcutAdvisor(pointcut, resultMessagesInfoLoggingInterceptor);
    }
}
