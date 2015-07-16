/*
 * Copyright (C) 2013-2015 terasoluna.org
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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElArrayController {

    @ModelAttribute
    public ArrayForm6 setUpForm() {
        ArrayForm6 arrayForm6 = new ArrayForm6(new int[3], new double[2],
                new byte[3], new String[3], new ArrayFormItem6(new int[3],
                        new double[3], new byte[3], new String[3]));
        return arrayForm6;
    }

    @RequestMapping(value = "6_14", method = RequestMethod.GET)
    public String init(Model model) {

        return "el/arrayQueryOutput";
    }

    @RequestMapping(value = "6_14/search", method = RequestMethod.GET)
    public String listOfJavaBeanQueryString(ArrayForm6 arrayForm6,
            @PageableDefault Pageable pageable, Model model) {

        // Create Dummy Data
        List<String> dummyList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            dummyList.add("Dummy");
        }

        Page<String> dummyPage = new PageImpl<String>(dummyList, pageable, 100);
        model.addAttribute("page", dummyPage);

        return "el/arrayQueryOutput";
    }
}
