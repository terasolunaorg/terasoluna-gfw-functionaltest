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
package org.terasoluna.gfw.functionaltest.app.transactiontoken.customstoresize;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

@Controller
@RequestMapping("transactiontoken/customTransactionStoreSize1")
public class TransactionTokenCustomFlow1Controller {

    @GetMapping(value = "index")
    public String customflowMenu() {
        return "transactiontoken/customStoreSizeMenu";
    }

    @PostMapping(value = "createFlow")
    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String customflowStepBegin() {
        return "transactiontoken/customStoreSizeNext";
    }

    @PostMapping(value = "createFlow", params = "intermediate")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String customflowStepIn() {
        return "transactiontoken/customStoreSizeNext";
    }
}
