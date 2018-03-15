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
import org.terasoluna.gfw.web.token.transaction.TransactionTokenContext;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

@Controller
@RequestMapping("transactiontoken")
@TransactionTokenCheck("transactiontoken")
public class TransactionTokenFlow1Controller {

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "confirm")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String flow1Step2() {
        return "transactiontoken/flow1Step2";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "confirmError")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String flow1Step2_withError() {
        return "transactiontoken/flowAllStep1";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "confirmDiffNamespace")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String flow1Step2_toDifferentNamespace() {
        return "transactiontoken/flow1Step2ToDifferentNamespace";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "redo1")
    public String flow1Step2Back() {
        return "transactiontoken/flowAllStep1";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "intermediate")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String flow1Step3() {
        return "transactiontoken/flow1Step3";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "intermediateWithFinish")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String flow1Step3_withFinish(
            TransactionTokenContext transactionTokenContext) {
        transactionTokenContext.removeToken();
        // Navigate to final screen
        return "transactiontoken/flow1Step4";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "intermediateWithFinishError")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String flow1Step3_withFinishError(
            TransactionTokenContext transactionTokenContext) {
        // Navigate to intermediate screen again
        // Transaction token will be updated
        return "transactiontoken/flow1Step2";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "redo2")
    @TransactionTokenCheck
    public String flow1Step3Back() {
        return "transactiontoken/flow1Step2";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "finalize")
    @TransactionTokenCheck(type = TransactionTokenType.END)
    public String flow1Step4() {
        return "transactiontoken/flow1Step4";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "finalizeError")
    @TransactionTokenCheck(type = TransactionTokenType.END)
    public String flow1Step4_withError() {
        // return to first step screen due to business error
        return "transactiontoken/flowAllStep1";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.GET, params = "download01")
    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String flow1Step2Download_01() {
        return "imageFileDownloadView";
    }

    @RequestMapping(value = "flow1", method = RequestMethod.POST, params = "check")
    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String flow1Step2Check() {
        return "transactiontoken/flow1Step3";
    }

}
