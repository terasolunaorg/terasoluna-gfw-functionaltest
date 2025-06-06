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
package org.terasoluna.gfw.functionaltest.domain.service.exceptionhandling;

import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.functionaltest.domain.exception.CauseException;
import org.terasoluna.gfw.functionaltest.domain.exception.SubClassException;
import org.terasoluna.gfw.functionaltest.domain.exception.WrappingException;

import jakarta.inject.Inject;

@Service
public class ExceptionHandlingServiceImpl implements ExceptionHandlingService {

    @Inject
    protected ExceptionHandlingSharedService exceptionHandlingSheradService;

    @Override
    public void throwException(RuntimeException e) {
        throw e;
    }

    @Override
    public void throwAssertionError() {

        throw new AssertionError();

    }

    @Override
    public void throwExceptionInSharedServiceNotCatchThis(RuntimeException e) {
        exceptionHandlingSheradService.throwException(e);
    }

    @Override
    public void throwExceptionInSharedServiceCatchThis(RuntimeException e) {
        try {
            exceptionHandlingSheradService.throwException(e);
        } catch (BusinessException be) {
            // non op
        }
    }

    @Override
    public void throwWrappingException() throws WrappingException {

        throw new WrappingException(new CauseException());

    }

    @Override
    public void throwSubClassException() throws SubClassException {

        throw new SubClassException();

    }

}
