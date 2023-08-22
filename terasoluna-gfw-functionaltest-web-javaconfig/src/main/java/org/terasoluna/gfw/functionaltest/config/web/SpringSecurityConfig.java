package org.terasoluna.gfw.functionaltest.config.web;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.DelegatingAccessDeniedHandler;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Bean definition to configure SpringSecurity.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    /**
     * Configure {@link SecurityFilterChain} bean.
     * @param http Builder class for setting up authentication and authorization
     * @return Bean of configured {@link SecurityFilterChain}
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authz -> authz.requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll());

        http.exceptionHandling(ex -> ex.accessDeniedHandler(
                accessDeniedHandler()));

        http.formLogin(login -> login.loginPage("/logging/userIdMDCPutFilter")
                .loginProcessingUrl("/logging/login").defaultSuccessUrl(
                        "/logging/userIdMDCPutFilter/login"));

        http.logout(logout -> logout.logoutUrl(
                "/logging/userIdMDCPutFilter/logout").logoutSuccessUrl(
                        "/logging/userIdMDCPutFilter").deleteCookies(
                                "JSESSIONID"));
        return http.build();
    }

    /**
     * Configure {@link AccessDeniedHandler} bean.
     * @return Bean of configured {@link AccessDeniedHandler}
     */
    @Bean("accessDeniedHandler")
    public AccessDeniedHandler accessDeniedHandler() {
        LinkedHashMap<Class<? extends AccessDeniedException>, AccessDeniedHandler> errorHandlers = new LinkedHashMap<>();

        // Invalid CSRF authenticator error handler
        AccessDeniedHandlerImpl invalidCsrfTokenErrorHandler = new AccessDeniedHandlerImpl();
        invalidCsrfTokenErrorHandler.setErrorPage(
                "/WEB-INF/views/common/error/csrfTokenError.jsp");
        errorHandlers.put(InvalidCsrfTokenException.class,
                invalidCsrfTokenErrorHandler);

        // Default error handler
        AccessDeniedHandlerImpl defaultErrorHandler = new AccessDeniedHandlerImpl();
        defaultErrorHandler.setErrorPage(
                "/WEB-INF/views/common/error/accessDeniedError.jsp");

        return new DelegatingAccessDeniedHandler(errorHandlers, defaultErrorHandler);
    }

    /**
     * Configure {@link AuthenticationProvider} bean.
     * @param userDetailsService UserDetailsService defined by #userDetailsService()
     * @param passwordEncoder PasswordEncoder defined by ApplicationContextConfig#passwordEncoder()
     * @return Bean of configured {@link AuthenticationProvider}
     */
    @Bean
    public AuthenticationProvider authProvider(
            @Qualifier("userService") UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    /**
     * Configure {@link UserDetailsService} bean.
     * @return Bean of configured {@link UserDetailsService}
     */
    @Bean("userService")
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.builder().username("user1").password(
                "{pbkdf2}48f3120ce077244ade1ffe16df9f764b26c4fe03608fb2ab65462305fb5203f54e8f238177a1436c")
                .build());
        manager.createUser(User.builder().username("user2").password(
                "{pbkdf2}8e287bcd70c68b8a9f1c7acdb73ad40824dfdb67c55ed8c09314ed795d3754b1be7062c910f3f1ea")
                .build());
        manager.createUser(User.builder().username("user3").password(
                "{pbkdf2}22dbc480b2444d53faa057ef10edcbb0f827c1618557fa72db09b71cf640c4ff21c14c6a80292dc5")
                .build());
        return manager;
    }

    /**
     * Configure {@link DefaultWebSecurityExpressionHandler} bean.
     * @return Bean of configured {@link DefaultWebSecurityExpressionHandler}
     */
    @Bean("webexpressionHandler")
    public DefaultWebSecurityExpressionHandler webExpressionHandler() {
        return new DefaultWebSecurityExpressionHandler();
    }
}
