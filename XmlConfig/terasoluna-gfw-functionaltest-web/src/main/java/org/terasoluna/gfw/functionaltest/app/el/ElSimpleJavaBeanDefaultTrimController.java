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
package org.terasoluna.gfw.functionaltest.app.el;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "el")
public class ElSimpleJavaBeanDefaultTrimController {

    @InitBinder
    public void bindTrimmingEditor(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute
    public UserForm setUpForm() {
        UserForm userForm = new UserForm("yamada", 20, new UserFormItem("tanaka", 50));
        return userForm;
    }

    @GetMapping(value = "6_15")
    public String init(Model model) {

        return "el/simpleJavaBeanDefaultTrimQueryOutput";
    }

    @GetMapping(value = "6_15/search")
    public String nestedJavaBeanQueryString(UserForm userForm, @PageableDefault Pageable pageable,
            Model model) {

        // Create Dummy Data
        List<String> dummyList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            dummyList.add("Dummy");
        }

        Page<String> dummyPage = new PageImpl<String>(dummyList, pageable, 100);
        model.addAttribute("page", dummyPage);

        String nameString = Objects.toString(userForm.getName());
        String ageString = Objects.toString(userForm.getAge());

        model.addAttribute("nameString", nameString);
        model.addAttribute("ageString", ageString);

        String nameStringItem = Objects.toString(userForm.getItem().getName());
        String ageStringItem = Objects.toString(userForm.getItem().getAge());

        model.addAttribute("nameStringItem", nameStringItem);
        model.addAttribute("ageStringItem", ageStringItem);

        return "el/simpleJavaBeanDefaultTrimQueryOutput";
    }
}
