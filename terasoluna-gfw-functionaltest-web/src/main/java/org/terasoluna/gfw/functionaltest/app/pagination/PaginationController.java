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
package org.terasoluna.gfw.functionaltest.app.pagination;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.functionaltest.domain.model.Person;
import org.terasoluna.gfw.functionaltest.domain.service.pagination.PaginationService;

@Controller
@RequestMapping(value = "pagination")
public class PaginationController {

    @Inject
    protected PaginationService paginationService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "pagination/index";
    }

    @RequestMapping(value = "1_1", method = RequestMethod.GET)
    public String fuinctionTest_1_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_2", method = RequestMethod.GET)
    public String fuinctionTest_1_2(Model model,
            @PageableDefault(value = 30) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_3", method = RequestMethod.GET)
    public String fuinctionTest_1_3(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_4", method = RequestMethod.GET)
    public String fuinctionTest_1_4(Model model,
            @PageableDefault Pageable pageable) {

        List<Person> nameList = new ArrayList<Person>();

        model.addAttribute("page", new PageImpl<Person>(nameList));

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_5", method = RequestMethod.GET)
    public String fuinctionTest_1_5(Model model,
            @PageableDefault Pageable pageable) {

        model.addAttribute("page", null);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_6", method = RequestMethod.GET)
    public String fuinctionTest_1_6(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_7", method = RequestMethod.GET)
    public String fuinctionTest_1_7(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_8", method = RequestMethod.GET)
    public String fuinctionTest_1_8(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_9", method = RequestMethod.GET)
    public String fuinctionTest_1_9(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_10", method = RequestMethod.GET)
    public String fuinctionTest_1_10(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "1_11", method = RequestMethod.GET)
    public String fuinctionTest_1_11(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @RequestMapping(value = "2_1", method = RequestMethod.GET)
    public String fuinctionTest_2_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pathtmpl";
    }

    @RequestMapping(value = "3_1", method = RequestMethod.GET)
    public String fuinctionTest_3_1(Model model,
            @PageableDefault(value = 100, sort = { "firstname",
                    "lastname" }, direction = Direction.DESC) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/querytmpl";
    }

    @RequestMapping(value = "4_1", method = RequestMethod.GET)
    public String fuinctionTest_4_1(Model model,
            @PageableDefault(value = 10) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/maxDisplayCountTwenty";
    }

    @RequestMapping(value = "4_2", method = RequestMethod.GET)
    public String fuinctionTest_4_2(Model model,
            @PageableDefault(value = 10) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/maxDisplayCountZero";
    }

    @RequestMapping(value = "4_3", method = RequestMethod.GET)
    public String fuinctionTest_4_3(Model model,
            @PageableDefault(value = 10) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/maxDisplayCountBlank";
    }

    @RequestMapping(value = "5_1", method = RequestMethod.GET)
    public String fuinctionTest_5_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/outerElement";
    }

    @RequestMapping(value = "6_1", method = RequestMethod.GET)
    public String fuinctionTest_6_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/innerElement";
    }

    @RequestMapping(value = "7_1", method = RequestMethod.GET)
    public String fuinctionTest_7_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLinkText";
    }

    @RequestMapping(value = "7_2", method = RequestMethod.GET)
    public String fuinctionTest_7_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLinkTextBlank";
    }

    @RequestMapping(value = "8_1", method = RequestMethod.GET)
    public String fuinctionTest_8_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/previousLinkText";
    }

    @RequestMapping(value = "8_2", method = RequestMethod.GET)
    public String fuinctionTest_8_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/previousLinkTextBlank";
    }

    @RequestMapping(value = "9_1", method = RequestMethod.GET)
    public String fuinctionTest_9_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/nextLinkText";
    }

    @RequestMapping(value = "9_2", method = RequestMethod.GET)
    public String fuinctionTest_9_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/nextLinkTextBlank";
    }

    @RequestMapping(value = "10_1", method = RequestMethod.GET)
    public String fuinctionTest_10_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/lastLinkText";
    }

    @RequestMapping(value = "10_2", method = RequestMethod.GET)
    public String fuinctionTest_10_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/lastLinkTextBlank";
    }

    @RequestMapping(value = "11_1", method = RequestMethod.GET)
    public String fuinctionTest_11_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledHref";
    }

    @RequestMapping(value = "11_2", method = RequestMethod.GET)
    public String fuinctionTest_11_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledHrefBlank";
    }

    @RequestMapping(value = "12_1", method = RequestMethod.GET)
    public String fuinctionTest_12_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/activeClass";
    }

    @RequestMapping(value = "12_2", method = RequestMethod.GET)
    public String fuinctionTest_12_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/activeClassBlank";
    }

    @RequestMapping(value = "13_1", method = RequestMethod.GET)
    public String fuinctionTest_13_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledClass";
    }

    @RequestMapping(value = "13_2", method = RequestMethod.GET)
    public String fuinctionTest_13_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledClassBlank";
    }

    @RequestMapping(value = "14_1", method = RequestMethod.GET)
    public String fuinctionTest_14_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pathQueryTmpl";
    }

    @RequestMapping(value = "14_1/{page}/{size}", method = RequestMethod.GET)
    public String fuinctionTest_14_1_confirm(@PathVariable("page") int page,
            @PathVariable("size") int size, Model model) {

        Page<Person> namePage = paginationService.findPerson(
                new PageRequest(page, size));

        model.addAttribute("page", namePage);

        return "pagination/pathQueryTmpl";
    }

    @RequestMapping(value = "15_1", method = RequestMethod.GET)
    public String fuinctionTest_15_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/InOutElement";
    }

    @RequestMapping(value = "16_1", method = RequestMethod.GET)
    public String fuinctionTest_16_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLastLink";
    }

    @RequestMapping(value = "16_2", method = RequestMethod.GET)
    public String fuinctionTest_16_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLastLinkBlank";
    }

    @RequestMapping(value = "17_1", method = RequestMethod.GET)
    public String fuinctionTest_17_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/prevNextLink";
    }

    @RequestMapping(value = "18_1", method = RequestMethod.GET)
    public String fuinctionTest_18_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/outerElementClass";
    }

    @RequestMapping(value = "19_1", method = RequestMethod.GET)
    public String fuinctionTest_19_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pager";
    }

    @RequestMapping(value = { "20_1", "20_2", "20_3", "20_4",
            "20_5" }, method = RequestMethod.GET)
    public String fuinctionTest_20_x(PersonSearchForm form,
            @PageableDefault(sort = "personId") Pageable pageable,
            Model model) {

        if (!StringUtils.hasLength(form.getName())) {
            return "pagination/search";
        }

        Page<Person> page = paginationService.findPersonByName(form.getName(),
                pageable);

        model.addAttribute("page", page);

        return "pagination/search";
    }

    @RequestMapping(value = { "21_1", "21_1/{page}/{size}", "21_2",
            "21_2/{page}/{size}" }, method = RequestMethod.GET)
    public String fuinctionTest_21_x(PersonSearchForm form,
            @PageableDefault(sort = "personId") Pageable pageable,
            Model model) {

        if (!StringUtils.hasLength(form.getName())) {
            return "pagination/searchPathTmplAndCriteriaQuery";
        }

        Page<Person> page = paginationService.findPersonByName(form.getName(),
                pageable);

        model.addAttribute("page", page);

        return "pagination/searchPathTmplAndCriteriaQuery";
    }

    @RequestMapping(value = { "22_1", "22_2" }, method = RequestMethod.GET)
    public String fuinctionTest_22_x(PersonSearchForm form,
            @PageableDefault(sort = "personId", direction = Direction.DESC) Pageable pageable,
            Model model) {

        if (!StringUtils.hasLength(form.getName())) {
            return "pagination/searchQueryTmplAndCriteriaQuery";
        }

        Page<Person> page = paginationService.findPersonByName(form.getName(),
                pageable);

        model.addAttribute("page", page);

        return "pagination/searchQueryTmplAndCriteriaQuery";
    }

    @RequestMapping(value = { "23_1", "23_1/{page}/{size}", "23_2",
            "23_2/{page}/{size}" }, method = RequestMethod.GET)
    public String fuinctionTest_23_x(PersonSearchForm form,
            @PageableDefault(sort = "firstname", direction = Direction.DESC) Pageable pageable,
            Model model) {

        if (!StringUtils.hasLength(form.getName())) {
            return "pagination/searchPathTmplAndQueryTmplAndCriteriaQuery";
        }

        Page<Person> page = paginationService.findPersonByName(form.getName(),
                pageable);

        model.addAttribute("page", page);

        return "pagination/searchPathTmplAndQueryTmplAndCriteriaQuery";
    }

    @RequestMapping(value = "24_1", method = RequestMethod.GET)
    public String fuinctionTest_24_1(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/enableLinkOfCurrentPage";
    }

    @RequestMapping(value = "25_1", method = RequestMethod.GET)
    public String fuinctionTest_25_1(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledPageLinkWithJavaScript";
    }

    @RequestMapping(value = "26_1", method = RequestMethod.GET)
    public String fuinctionTest_26_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/tagConfiguration";
    }

}
