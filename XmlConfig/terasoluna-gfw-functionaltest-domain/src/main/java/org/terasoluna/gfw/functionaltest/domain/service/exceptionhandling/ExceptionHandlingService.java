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

import org.terasoluna.gfw.functionaltest.domain.exception.SubClassException;
import org.terasoluna.gfw.functionaltest.domain.exception.WrappingException;

public interface ExceptionHandlingService {

    void throwException(RuntimeException e);

    void throwAssertionError();

    void throwExceptionInSharedServiceCatchThis(RuntimeException e);

    void throwExceptionInSharedServiceNotCatchThis(RuntimeException e);

    void throwWrappingException() throws WrappingException;

    void throwSubClassException() throws SubClassException;
}
