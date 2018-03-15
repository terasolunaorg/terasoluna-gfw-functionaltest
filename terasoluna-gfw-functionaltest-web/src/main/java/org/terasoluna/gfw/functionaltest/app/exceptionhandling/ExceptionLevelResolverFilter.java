/*
 * Copyright (C) 2013-2018 NTT DATA Corporation
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
package org.terasoluna.gfw.functionaltest.app.exceptionhandling;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.terasoluna.gfw.functionaltest.domain.exception.BusinessTestException;

public class ExceptionLevelResolverFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // Workaround for application servers that don't provide getServletPath(), eg. WebSphere Liberty Profile 8.5.
        String path = request.getServletPath();
        if (path == null || path.length() == 0) {
            path = request.getPathInfo();
        }

        if (path.equals("/exceptionhandling/5_1")) {
            throw new BusinessTestException("n.cc.0000", "Error");
        } else if (path.equals("/exceptionhandling/5_2")) {
            throw new BusinessTestException("a.cc.0000", "Error");
        } else if (path.equals("/exceptionhandling/5_3")) {
            throw new BusinessTestException("d.cc.0000", "Error");
        }
    }

}
