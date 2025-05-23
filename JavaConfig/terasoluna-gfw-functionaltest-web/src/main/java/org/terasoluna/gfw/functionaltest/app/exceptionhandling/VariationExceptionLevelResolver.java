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
package org.terasoluna.gfw.functionaltest.app.exceptionhandling;

import org.springframework.util.StringUtils;
import org.terasoluna.gfw.common.exception.ExceptionLevel;
import org.terasoluna.gfw.common.exception.ExceptionLevelResolver;
import org.terasoluna.gfw.functionaltest.domain.exception.BusinessTestException;

public class VariationExceptionLevelResolver implements ExceptionLevelResolver {

    public ExceptionLevel resolveExceptionLevel(Exception ex) {
        BusinessTestException we = (BusinessTestException) ex;
        String exceptionCode = we.getResultMessages().getList().get(0).getCode();

        if (!StringUtils.hasText(exceptionCode)) {
            return ExceptionLevel.ERROR;
        }
        String exceptionCodePrefix = exceptionCode.substring(0, 1).toLowerCase();
        if ("d".equals(exceptionCodePrefix)) {
            return ExceptionLevel.ERROR;
        }
        if ("a".equals(exceptionCodePrefix)) {
            return ExceptionLevel.WARN;
        }
        if ("n".equals(exceptionCodePrefix)) {
            return ExceptionLevel.INFO;
        }
        return ExceptionLevel.ERROR;
    }
}
