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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.terasoluna.gfw.common.exception.ExceptionCodeProvider;
import org.terasoluna.gfw.common.exception.ExceptionCodeResolver;

public class MessageMappingExceptionCodeResolver implements
                                                 ExceptionCodeResolver {

    private String defaultExceptionCode;

    private Map<String, String> exceptionMessageMappings;

    public void setExceptionMessageMappings(
            LinkedHashMap<String, String> exceptionMessageMappings) {
        this.exceptionMessageMappings = exceptionMessageMappings;
    }

    public void setDefaultExceptionCode(String defaultExceptionCode) {
        this.defaultExceptionCode = defaultExceptionCode;
    }

    @Override
    public String resolveExceptionCode(Exception ex) {
        if (ex instanceof ExceptionCodeProvider) {
            String code = ((ExceptionCodeProvider) ex).getCode();
            if (code != null) {
                return code;
            }
        }

        if (exceptionMessageMappings == null || exceptionMessageMappings
                .isEmpty()) {
            return defaultExceptionCode;
        }

        for (Entry<String, String> entry : exceptionMessageMappings
                .entrySet()) {
            String targetMessageException = entry.getKey();
            Class<?> exceptionClass = ex.getClass();
            String message = ex.getMessage();
            while (exceptionClass != Object.class) {
                String messageException = exceptionClass.getName() + message;

                if (messageException.contains(targetMessageException)) {
                    return entry.getValue();
                }
                exceptionClass = exceptionClass.getSuperclass();
            }
        }

        return defaultExceptionCode;
    }

}
