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

import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.DelegatingAccessDeniedHandler;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;

/**
 * Bean definition to configure SpringSecurity.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/resources/**", "/webjars/**");
    }

    /**
     * Configure {@link SecurityFilterChain} bean.
     * @param http Builder class for setting up authentication and authorization
     * @return Bean of configured {@link SecurityFilterChain}
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.securityMatcher("/logging/**");

        http.authorizeHttpRequests(authz -> authz.requestMatchers("/**").permitAll());

        http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));

        http.formLogin(login -> login.loginPage("/logging/userIdMDCPutFilter")
                .loginProcessingUrl("/logging/login")
                .defaultSuccessUrl("/logging/userIdMDCPutFilter/login"));

        http.logout(logout -> logout.logoutUrl("/logging/userIdMDCPutFilter/logout")
                .logoutSuccessUrl("/logging/userIdMDCPutFilter").deleteCookies("JSESSIONID"));
        return http.build();
    }

    /**
     * Configure {@link AccessDeniedHandler} bean.
     * @return Bean of configured {@link AccessDeniedHandler}
     */
    @Bean("accessDeniedHandler")
    public AccessDeniedHandler accessDeniedHandler() {
        LinkedHashMap<Class<? extends AccessDeniedException>, AccessDeniedHandler> errorHandlers =
                new LinkedHashMap<>();

        // Invalid CSRF authenticator error handler
        AccessDeniedHandlerImpl invalidCsrfTokenErrorHandler = new AccessDeniedHandlerImpl();
        invalidCsrfTokenErrorHandler.setErrorPage("/WEB-INF/views/common/error/csrfTokenError.jsp");
        errorHandlers.put(InvalidCsrfTokenException.class, invalidCsrfTokenErrorHandler);

        // Default error handler
        AccessDeniedHandlerImpl defaultErrorHandler = new AccessDeniedHandlerImpl();
        defaultErrorHandler.setErrorPage("/WEB-INF/views/common/error/accessDeniedError.jsp");

        return new DelegatingAccessDeniedHandler(errorHandlers, defaultErrorHandler);
    }

    /**
     * Configure {@link AuthenticationProvider} bean.
     * @param passwordEncoder PasswordEncoder defined by ApplicationContextConfig#passwordEncoder()
     * @return Bean of configured {@link AuthenticationProvider}
     */
    @Bean
    public AuthenticationProvider authProvider(
            @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider(userDetailsService());
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
                "{pbkdf2}791fdc5436f05d2fae222ce5e5ccd0872a82907bc99be1bf974d8f95faf8ae8d43e39b589674bf70b3f52c6898cc8687")
                .build());
        manager.createUser(User.builder().username("user2").password(
                "{pbkdf2}370ee0a26860c0290604bd872582842093a737e4726b7a3d4cee8318d2dfd2c09133c449b958b4f873e2286236c02728")
                .build());
        manager.createUser(User.builder().username("user3").password(
                "{pbkdf2}2c1df137d1f93cac0dbdecf0326e64dfa9602f1b4bfcff31a1e433aca722a51b8a4852055b828a7f340e16b5696817f5")
                .build());
        return manager;
    }

}
