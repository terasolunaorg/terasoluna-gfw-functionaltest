/*
 * Copyright (C) 2013-2016 NTT DATA Corporation
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

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.terasoluna.gfw.functionaltest.domain.model.Person;
import org.terasoluna.gfw.functionaltest.domain.service.pagination.PaginationService;

@Controller
@RequestMapping(value = "pagination")
@SessionAttributes(value = {"personSearchForSessionForm"})
public class PaginationForSessionController {

    @Inject
    protected PaginationService paginationService;

    @ModelAttribute(value = "personSearchForSessionForm")
    public PersonSearchForSessionForm setUpForm() {
        return new PersonSearchForSessionForm();
    }

    @RequestMapping(value = { "27_1" })
    public String fuinctionTest_27_x(
            PersonSearchForSessionForm form,
            SessionStatus sessionStatus,
            @PageableDefault(sort = "personId") Pageable pageable,
            Model model) {

        if (!StringUtils.hasLength(form.getName())) {
            sessionStatus.setComplete();

            return "pagination/searchForSession";
        }

        Page<Person> page = paginationService.findPersonByName(form.getName(),
                pageable);

        model.addAttribute("page", page);

        return "pagination/searchForSession";
    }

}
