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

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.common.fullhalf.FullHalfPairsBuilder;

@Controller
@RequestMapping(value = "string/fullHalfPairsBuilderWithStringTrimmer")
public class FullHalfPairsBuilderWithStringTrimmerController {

    @InitBinder
    public void initConvertPairFormWebDataBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class,
                new StringTrimmerEditor(true));
    }

    @ModelAttribute("targetTitle")
    public String setUpTargetTitle() {
        return "FullHalfPairsBuilder Test - handle the empty as null -";
    }

    @ModelAttribute("targetPath")
    public String setUpTargetPath() {
        return "fullHalfPairsBuilderWithStringTrimmer";
    }

    @ModelAttribute
    public FullHalfPairForm setUpFullHalfPairForm() {
        return new FullHalfPairForm();
    }

    @RequestMapping(method = RequestMethod.GET, params = { "form" })
    public String form() {
        return "string/pair";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String pair(Model model, FullHalfPairForm form) {

        String fullwidth = form.getFullwidth();
        String halfwidth = form.getHalfwidth();

        new FullHalfPairsBuilder().pair(fullwidth, halfwidth);

        model.addAttribute("resultMessage", "Set Pair SUCCESS!");

        return "string/pair";
    }

}
