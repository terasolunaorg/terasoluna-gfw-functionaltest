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
package org.terasoluna.gfw.functionaltest.app.transactiontoken;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenContext;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

@Controller
@RequestMapping("transactiontoken")
@TransactionTokenCheck("transactiontoken")
public class TransactionTokenFlow1Controller {

    @PostMapping(value = "flow1", params = "confirm")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String flow1Step2() {
        return "transactiontoken/flow1Step2";
    }

    @PostMapping(value = "flow1", params = "confirmError")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String flow1Step2_withError() {
        return "transactiontoken/flowAllStep1";
    }

    @PostMapping(value = "flow1", params = "confirmDiffNamespace")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String flow1Step2_toDifferentNamespace() {
        return "transactiontoken/flow1Step2ToDifferentNamespace";
    }

    @PostMapping(value = "flow1", params = "redo1")
    public String flow1Step2Back() {
        return "transactiontoken/flowAllStep1";
    }

    @PostMapping(value = "flow1", params = "intermediate")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String flow1Step3() {
        return "transactiontoken/flow1Step3";
    }

    @PostMapping(value = "flow1", params = "intermediateWithFinishError")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String flow1Step3_withFinishError(TransactionTokenContext transactionTokenContext) {
        // Navigate to intermediate screen again
        // Transaction token will be updated
        return "transactiontoken/flow1Step2";
    }

    @PostMapping(value = "flow1", params = "redo2")
    @TransactionTokenCheck
    public String flow1Step3Back() {
        return "transactiontoken/flow1Step2";
    }

    @PostMapping(value = "flow1", params = "finalize")
    @TransactionTokenCheck(type = TransactionTokenType.END)
    public String flow1Step4() {
        return "transactiontoken/flow1Step4";
    }

    @PostMapping(value = "flow1", params = "finalizeError")
    @TransactionTokenCheck(type = TransactionTokenType.END)
    public String flow1Step4_withError() {
        // return to first step screen due to business error
        return "transactiontoken/flowAllStep1";
    }

    @GetMapping(value = "flow1", params = "download01")
    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String flow1Step2Download_01() {
        return "imageFileDownloadView";
    }

    @PostMapping(value = "flow1", params = "check")
    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String flow1Step2Check() {
        return "transactiontoken/flow1Step3";
    }

}
