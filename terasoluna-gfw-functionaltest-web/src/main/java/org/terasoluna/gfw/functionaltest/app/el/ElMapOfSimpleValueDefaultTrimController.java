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
import java.util.LinkedHashMap;
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
public class ElMapOfSimpleValueDefaultTrimController {

    @InitBinder
    public void bindTrimmingEditor(WebDataBinder binder) {
        binder.registerCustomEditor(String.class,
                new StringTrimmerEditor(true));
    }

    @ModelAttribute
    public MapForm setUpForm() {
        MapForm mapForm = new MapForm(new LinkedHashMap<String, String>() {
            {
                put("a", "1");
                put("b", "2");
                put("c", "3");
            }
        }, new MapFormItem(new LinkedHashMap<String, String>() {
            {
                put("d", "4");
                put("e", "5");
                put("f", "6");
            }
        }));

        return mapForm;
    }

    @RequestMapping(value = "6_17", method = RequestMethod.GET)
    public String init(Model model) {

        return "el/mapOfSimpleValueDefaultTrimQueryOutput";
    }

    @RequestMapping(value = "6_17/search", method = RequestMethod.GET)
    public String nestedJavaBeanQueryString(MapForm mapForm,
            @PageableDefault Pageable pageable, Model model) {

        // Create Dummy Data
        List<String> dummyList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            dummyList.add("Dummy");
        }

        Page<String> dummyPage = new PageImpl<String>(dummyList, pageable, 100);
        model.addAttribute("page", dummyPage);

        String mapA0String = Objects.toString(mapForm.getMapA().get("a"));
        String mapA1String = Objects.toString(mapForm.getMapA().get("b"));
        String mapA2String = Objects.toString(mapForm.getMapA().get("c"));

        model.addAttribute("mapA0String", mapA0String);
        model.addAttribute("mapA1String", mapA1String);
        model.addAttribute("mapA2String", mapA2String);

        String mapA0StringItem = Objects.toString(mapForm.getItem().getMapA()
                .get("d"));
        String mapA1StringItem = Objects.toString(mapForm.getItem().getMapA()
                .get("e"));
        String mapA2StringItem = Objects.toString(mapForm.getItem().getMapA()
                .get("f"));

        model.addAttribute("mapA0StringItem", mapA0StringItem);
        model.addAttribute("mapA1StringItem", mapA1StringItem);
        model.addAttribute("mapA2StringItem", mapA2StringItem);

        return "el/mapOfSimpleValueDefaultTrimQueryOutput";
    }
}
