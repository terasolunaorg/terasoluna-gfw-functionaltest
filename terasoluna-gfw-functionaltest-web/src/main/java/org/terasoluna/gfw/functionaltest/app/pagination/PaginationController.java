/*
 * Copyright(c) 2013 NTT DATA Corporation.
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.functionaltest.domain.model.Person;
import org.terasoluna.gfw.functionaltest.domain.service.pagination.PaginationService;

@Controller
@RequestMapping(value = "pagination")
public class PaginationController {

    @Inject
    protected PaginationService paginationService;

    @GetMapping
    public String index() {
        return "pagination/index";
    }

    @GetMapping(value = "1_1")
    public String fuinctionTest_1_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_2")
    public String fuinctionTest_1_2(Model model,
            @PageableDefault(value = 30) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_3")
    public String fuinctionTest_1_3(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_4")
    public String fuinctionTest_1_4(Model model,
            @PageableDefault Pageable pageable) {

        List<Person> nameList = new ArrayList<Person>();

        model.addAttribute("page", new PageImpl<Person>(nameList));

        return "pagination/pagination";
    }

    @GetMapping(value = "1_5")
    public String fuinctionTest_1_5(Model model,
            @PageableDefault Pageable pageable) {

        model.addAttribute("page", null);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_6")
    public String fuinctionTest_1_6(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_7")
    public String fuinctionTest_1_7(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_8")
    public String fuinctionTest_1_8(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_9")
    public String fuinctionTest_1_9(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_10")
    public String fuinctionTest_1_10(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "1_11")
    public String fuinctionTest_1_11(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pagination";
    }

    @GetMapping(value = "2_1")
    public String fuinctionTest_2_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pathtmpl";
    }

    @GetMapping(value = "3_1")
    public String fuinctionTest_3_1(Model model,
            @PageableDefault(value = 100, sort = { "firstname",
                    "lastname" }, direction = Direction.DESC) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/querytmpl";
    }

    @GetMapping(value = "4_1")
    public String fuinctionTest_4_1(Model model,
            @PageableDefault(value = 10) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/maxDisplayCountTwenty";
    }

    @GetMapping(value = "4_2")
    public String fuinctionTest_4_2(Model model,
            @PageableDefault(value = 10) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/maxDisplayCountZero";
    }

    @GetMapping(value = "4_3")
    public String fuinctionTest_4_3(Model model,
            @PageableDefault(value = 10) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/maxDisplayCountBlank";
    }

    @GetMapping(value = "5_1")
    public String fuinctionTest_5_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/outerElement";
    }

    @GetMapping(value = "6_1")
    public String fuinctionTest_6_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/innerElement";
    }

    @GetMapping(value = "7_1")
    public String fuinctionTest_7_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLinkText";
    }

    @GetMapping(value = "7_2")
    public String fuinctionTest_7_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLinkTextBlank";
    }

    @GetMapping(value = "8_1")
    public String fuinctionTest_8_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/previousLinkText";
    }

    @GetMapping(value = "8_2")
    public String fuinctionTest_8_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/previousLinkTextBlank";
    }

    @GetMapping(value = "9_1")
    public String fuinctionTest_9_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/nextLinkText";
    }

    @GetMapping(value = "9_2")
    public String fuinctionTest_9_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/nextLinkTextBlank";
    }

    @GetMapping(value = "10_1")
    public String fuinctionTest_10_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/lastLinkText";
    }

    @GetMapping(value = "10_2")
    public String fuinctionTest_10_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/lastLinkTextBlank";
    }

    @GetMapping(value = "11_1")
    public String fuinctionTest_11_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledHref";
    }

    @GetMapping(value = "11_2")
    public String fuinctionTest_11_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledHrefBlank";
    }

    @GetMapping(value = "12_1")
    public String fuinctionTest_12_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/activeClass";
    }

    @GetMapping(value = "12_2")
    public String fuinctionTest_12_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/activeClassBlank";
    }

    @GetMapping(value = "13_1")
    public String fuinctionTest_13_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledClass";
    }

    @GetMapping(value = "13_2")
    public String fuinctionTest_13_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledClassBlank";
    }

    @GetMapping(value = "14_1")
    public String fuinctionTest_14_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pathQueryTmpl";
    }

    @GetMapping(value = "14_1/{page}/{size}")
    public String fuinctionTest_14_1_confirm(@PathVariable("page") int page,
            @PathVariable("size") int size, Model model) {

        Page<Person> namePage = paginationService.findPerson(PageRequest.of(
                page, size));

        model.addAttribute("page", namePage);

        return "pagination/pathQueryTmpl";
    }

    @GetMapping(value = "15_1")
    public String fuinctionTest_15_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/InOutElement";
    }

    @GetMapping(value = "16_1")
    public String fuinctionTest_16_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLastLink";
    }

    @GetMapping(value = "16_2")
    public String fuinctionTest_16_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/firstLastLinkBlank";
    }

    @GetMapping(value = "17_1")
    public String fuinctionTest_17_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/prevNextLink";
    }

    @GetMapping(value = "18_1")
    public String fuinctionTest_18_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/outerElementClass";
    }

    @GetMapping(value = "18_2")
    public String fuinctionTest_18_2(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/innerElementClass";
    }

    @GetMapping(value = "18_3")
    public String fuinctionTest_18_3(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/anchorClass";
    }

    @GetMapping(value = "19_1")
    public String fuinctionTest_19_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/pager";
    }

    @GetMapping(value = { "20_1", "20_2", "20_3", "20_4", "20_5" })
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

    @GetMapping(value = { "21_1", "21_1/{page}/{size}", "21_2",
            "21_2/{page}/{size}" })
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

    @GetMapping(value = { "22_1", "22_2" })
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

    @GetMapping(value = { "23_1", "23_1/{page}/{size}", "23_2",
            "23_2/{page}/{size}" })
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

    @GetMapping(value = "24_1")
    public String fuinctionTest_24_1(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/enableLinkOfCurrentPage";
    }

    @GetMapping(value = "25_1")
    public String fuinctionTest_25_1(Model model,
            @PageableDefault(value = 15) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/disabledPageLinkWithJavaScript";
    }

    @GetMapping(value = "26_1")
    public String fuinctionTest_26_1(Model model,
            @PageableDefault(value = 100) Pageable pageable) {

        Page<Person> page = paginationService.findPerson(pageable);

        model.addAttribute("page", page);

        return "pagination/tagConfiguration";
    }

}
