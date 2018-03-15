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

@Controller
@RequestMapping("transactiontoken")
public class TransactionTokenFunctionalTestController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "transactiontoken/index";
    }

    // Contents confirmation testing
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String functionTestContentsConfirmation() {
        return "transactiontoken/createInput";
    }

    // flow testing
    @RequestMapping(value = "flow", method = RequestMethod.GET)
    public String functionTestFlow() {
        return "transactiontoken/flowAllStep1";
    }

    // flow @AliasFor namespace testing
    @RequestMapping(value = "flow_namespace", method = RequestMethod.GET)
    public String functionTestFlowNamespace() {
        return "transactiontoken/flowAllNamespaceStep1";
    }

}
