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
package org.terasoluna.gfw.functionaltest.app.el;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElListOfSimpleValueDefaultTrimController {

    @InitBinder
    public void bindTrimmingEditor(WebDataBinder binder) {
        binder.registerCustomEditor(String.class,
                new StringTrimmerEditor(true));
    }

    @ModelAttribute
    public ListForm setUpForm() {
        ListForm listForm = new ListForm(Arrays.asList("a0", "a1", "a2"), Arrays
                .asList("b0", "b1", "b2"), Arrays.asList("c0", "c1",
                        "c2"), new ListFormItem(Arrays.asList("aa0", "aa1",
                                "aa2"), Arrays.asList("bb0", "bb1",
                                        "bb2"), Arrays.asList("cc0", "cc1",
                                                "cc2")));
        return listForm;
    }

    @RequestMapping(value = "6_16", method = RequestMethod.GET)
    public String init(Model model) {

        return "el/listOfSimpleValueDefaultTrimQueryOutput";
    }

    @RequestMapping(value = "6_16/search", method = RequestMethod.GET)
    public String nestedJavaBeanQueryString(ListForm listForm,
            @PageableDefault Pageable pageable, Model model) {

        // Create Dummy Data
        List<String> dummyList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            dummyList.add("Dummy");
        }

        Page<String> dummyPage = new PageImpl<String>(dummyList, pageable, 100);
        model.addAttribute("page", dummyPage);

        String listA0String = Objects.toString(listForm.getListA().get(0));
        String listA1String = Objects.toString(listForm.getListA().get(1));
        String listA2String = Objects.toString(listForm.getListA().get(2));
        String listBString = Objects.toString(listForm.getListB());
        String listCString = Objects.toString(listForm.getListC());

        model.addAttribute("listA0String", listA0String);
        model.addAttribute("listA1String", listA1String);
        model.addAttribute("listA2String", listA2String);
        model.addAttribute("listBString", listBString);
        model.addAttribute("listCString", listCString);

        String listA0StringItem = Objects.toString(listForm.getItem().getListA()
                .get(0));
        String listA1StringItem = Objects.toString(listForm.getItem().getListA()
                .get(1));
        String listA2StringItem = Objects.toString(listForm.getItem().getListA()
                .get(2));
        String listBStringItem = Objects.toString(listForm.getItem()
                .getListB());
        String listCStringItem = Objects.toString(listForm.getItem()
                .getListC());

        model.addAttribute("listA0StringItem", listA0StringItem);
        model.addAttribute("listA1StringItem", listA1StringItem);
        model.addAttribute("listA2StringItem", listA2StringItem);
        model.addAttribute("listBStringItem", listBStringItem);
        model.addAttribute("listCStringItem", listCStringItem);

        return "el/listOfSimpleValueDefaultTrimQueryOutput";
    }
}
