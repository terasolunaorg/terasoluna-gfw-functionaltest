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

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.terasoluna.gfw.web.exception.ExceptionLoggingFilter;

public class ExceptionCodeExceptionLoggingFilter extends
                                                 ExceptionLoggingFilter {

    @Override
    protected void logIOException(IOException ex, ServletRequest request,
            ServletResponse response) {
        getExceptionLogger().log(ex);
    }

    @Override
    protected void logServletException(ServletException ex,
            ServletRequest request, ServletResponse response) {
        getExceptionLogger().log(ex);
    }

    @Override
    protected void logRuntimeException(RuntimeException ex,
            ServletRequest request, ServletResponse response) {
        getExceptionLogger().log(ex);
    }

}
