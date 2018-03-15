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
package org.terasoluna.gfw.functionaltest.app.transactiontoken;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

@Controller
@RequestMapping("transactiontoken")
public class TransactionTokenFlow2Controller {

    @RequestMapping(value = "flow2", method = RequestMethod.POST, params = "confirm")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String flow2Step2() {
        return "transactiontoken/flow2Step2";
    }

    @RequestMapping(value = "flow2", method = RequestMethod.POST, params = "redo1")
    public String flow2Step2Back() {
        return "transactiontoken/flowAllStep1";
    }

    @RequestMapping(value = "flow2", method = RequestMethod.POST, params = "intermediate")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String flow2Step3() {
        return "transactiontoken/flow2Step3";
    }

    @RequestMapping(value = "flow2", method = RequestMethod.POST, params = "redo2")
    @TransactionTokenCheck
    public String flow2Step3Back() {
        return "transactiontoken/flow2Step2";
    }

    @RequestMapping(value = "flow2", method = RequestMethod.POST, params = "finalize")
    @TransactionTokenCheck(type = TransactionTokenType.END)
    public String flow2Step4() {
        return "transactiontoken/flow2Step4";
    }

    @RequestMapping(value = "flow2", method = RequestMethod.POST, params = "check")
    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String flow1Step2Check() {
        return "transactiontoken/flow2Step3";
    }
}
