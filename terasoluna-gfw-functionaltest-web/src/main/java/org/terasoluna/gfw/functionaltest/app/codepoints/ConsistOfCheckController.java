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
package org.terasoluna.gfw.functionaltest.app.codepoints;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "codepoints")
public class ConsistOfCheckController {

    @ModelAttribute
    public ConsistOfCheckForm setConsistOfCheckForm() {
        return new ConsistOfCheckForm();
    }

    @RequestMapping(value = "consistOfCheck", method = RequestMethod.GET, params = {
            "form" })
    public String consistOfCheck_form() {

        return "codepoints/consistOfCheck_form";
    }

    @RequestMapping(value = "consistOfCheck", method = RequestMethod.POST)
    public String consistOfCheck(@Validated ConsistOfCheckForm form,
            BindingResult result) {

        if (result.hasErrors()) {
            return consistOfCheck_form();
        }

        return "codepoints/result_consistOfCheck";
    }
}
