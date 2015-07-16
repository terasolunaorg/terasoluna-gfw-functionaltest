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
public class ElDateTimeFormatController {

    @ModelAttribute
    public DateForm5 setUpForm() {
        DateForm5 dateForm5 = new DateForm5();
        return dateForm5;
    }

    @RequestMapping(value = "6_13", method = RequestMethod.GET)
    public String init(Model model) {

        return "el/dateTimeFormatQueryOutput";
    }

    @RequestMapping(value = "6_13/search", method = RequestMethod.GET)
    public String listOfJavaBeanQueryString(DateForm5 dateForm5,
            @PageableDefault Pageable pageable, Model model) {

        // Create Dummy Data
        List<String> dummyList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            dummyList.add("Dummy");
        }

        Page<String> dummyPage = new PageImpl<String>(dummyList, pageable, 100);
        model.addAttribute("page", dummyPage);

        return "el/dateTimeFormatQueryOutput";
    }
}
