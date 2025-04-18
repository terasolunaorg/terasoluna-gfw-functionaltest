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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public class ElMapOfSimpleValueDefaultTrimController {

    @InitBinder
    public void bindTrimmingEditor(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute
    public MapForm setUpForm() {
        Map<String, String> mapA = new LinkedHashMap<String, String>();
        mapA.put("a", "1");
        mapA.put("b", "2");
        mapA.put("c", "3");
        Map<String, String> itemMapA = new LinkedHashMap<String, String>();
        mapA.put("d", "4");
        mapA.put("e", "5");
        mapA.put("f", "6");
        return new MapForm(mapA, new MapFormItem(itemMapA));
    }

    @GetMapping(value = "6_17")
    public String init(Model model) {

        return "el/mapOfSimpleValueDefaultTrimQueryOutput";
    }

    @GetMapping(value = "6_17/search")
    public String nestedJavaBeanQueryString(MapForm mapForm, @PageableDefault Pageable pageable,
            Model model) {

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

        String mapA0StringItem = Objects.toString(mapForm.getItem().getMapA().get("d"));
        String mapA1StringItem = Objects.toString(mapForm.getItem().getMapA().get("e"));
        String mapA2StringItem = Objects.toString(mapForm.getItem().getMapA().get("f"));

        model.addAttribute("mapA0StringItem", mapA0StringItem);
        model.addAttribute("mapA1StringItem", mapA1StringItem);
        model.addAttribute("mapA2StringItem", mapA2StringItem);

        return "el/mapOfSimpleValueDefaultTrimQueryOutput";
    }
}
