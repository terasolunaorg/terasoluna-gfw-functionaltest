/*
 * Copyright (C) 2013-2014 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.domain.exception;

import org.terasoluna.gfw.common.exception.ResultMessagesNotificationException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

public class BusinessTestException extends ResultMessagesNotificationException {

    private static final long serialVersionUID = 1L;
    
    public BusinessTestException(String message) {
        super(ResultMessages.warn().add(ResultMessage.fromText(message)));
    }

    public BusinessTestException(String code, String message) {
        super(ResultMessages.warn().add(ResultMessage.fromCode(code, message)));
    }
    
}
