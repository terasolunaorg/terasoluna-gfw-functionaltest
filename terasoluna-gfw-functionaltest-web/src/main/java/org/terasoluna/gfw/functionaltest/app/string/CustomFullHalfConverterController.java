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
package org.terasoluna.gfw.functionaltest.app.string;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "string/customFullHalfConverter")
public class CustomFullHalfConverterController {

    @ModelAttribute
    public FullHalfForm setUpFullHalfForm() {
        return new FullHalfForm();
    }

    @ModelAttribute("targetTitle")
    public String setUpTargetTitle() {
        return "CustomFullHalfConverter Test";
    }

    @ModelAttribute("targetPath")
    public String setUpTargetPath() {
        return "customFullHalfConverter";
    }

    @RequestMapping(method = RequestMethod.GET, params = { "form" })
    public String form() {
        return "string/fullHalf";
    }

    @RequestMapping(method = RequestMethod.POST, params = { "full" })
    public String toFullwidth(FullHalfForm form) {

        form.setFullwidth(CustomFullHalf.INSTANCE.toFullwidth(form
                .getHalfwidth()));

        return "string/fullHalf";
    }

    @RequestMapping(method = RequestMethod.POST, params = { "half" })
    public String toHalfwidth(FullHalfForm form) {

        form.setHalfwidth(CustomFullHalf.INSTANCE.toHalfwidth(form
                .getFullwidth()));

        return "string/fullHalf";
    }

}
