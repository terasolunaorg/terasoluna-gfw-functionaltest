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
package org.terasoluna.gfw.functionaltest.app.string;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.common.fullhalf.DefaultFullHalf;

@Controller
@RequestMapping(value = "string/fullHalfConverter")
public class FullHalfConverterController {

    @ModelAttribute
    public FullHalfForm setUpFullHalfForm() {
        return new FullHalfForm();
    }

    @ModelAttribute("targetTitle")
    public String setUpTargetTitle() {
        return "FullHalfConverter Test";
    }

    @ModelAttribute("targetPath")
    public String setUpTargetPath() {
        return "fullHalfConverter";
    }

    @GetMapping(params = {"form"})
    public String form() {
        return "string/fullHalf";
    }

    @PostMapping(params = {"full"})
    public String toFullwidth(FullHalfForm form) {

        form.setFullwidth(DefaultFullHalf.INSTANCE.toFullwidth(form.getHalfwidth()));

        return "string/fullHalf";
    }

    @PostMapping(params = {"half"})
    public String toHalfwidth(FullHalfForm form) {

        form.setHalfwidth(DefaultFullHalf.INSTANCE.toHalfwidth(form.getFullwidth()));

        return "string/fullHalf";
    }

}
