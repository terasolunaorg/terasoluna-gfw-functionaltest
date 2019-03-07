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
package org.terasoluna.gfw.functionaltest.app.codelist;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.terasoluna.gfw.common.codelist.CodeList;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.functionaltest.domain.model.ItemCode;
import org.terasoluna.gfw.functionaltest.domain.service.codelist.CodeListService;
import org.terasoluna.gfw.functionaltest.domain.service.codelist.ExistInCodeListService;

@Controller
@RequestMapping(value = "codelist")
public class CodeListController {

    @Inject
    CodeListService codeListService;

    @Inject
    ExistInCodeListService existInCodeListService;

    @Inject
    @Qualifier("CODELIST_WRONG_ITEM")
    CodeList codeList;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "codelist/index";
    }

    @ModelAttribute
    public CodeListForm setUpCodeListForm() {
        return new CodeListForm();
    }

    @ModelAttribute
    public CodeListMngForm setUpCodeListMngForm() {
        return new CodeListMngForm();
    }

    @ModelAttribute
    public ExistInCheckForm setUpExistInCheckForm() {
        return new ExistInCheckForm();
    }

    @ModelAttribute
    public ExistInCheckWrongCodeListForm setUpCodeListWrongCodeListForm() {
        return new ExistInCheckWrongCodeListForm();
    }

    @RequestMapping(value = "next", method = RequestMethod.GET, params = "confirm")
    public String confirm(CodeListForm form, Model model) {
        return "codelist/confirm";
    }

    // test case 01_01
    @RequestMapping(value = "01_01_form", method = RequestMethod.GET)
    public String test01_01_form(CodeListForm form, Model model) {
        return "codelist/01_01_form";
    }

    // test case 01_02
    @RequestMapping(value = "01_02_form", method = RequestMethod.GET)
    public String test01_02_form(CodeListForm form, Model model) {
        return "codelist/01_02_form";
    }

    // test case 02_01
    @RequestMapping(value = "02_01_form", method = RequestMethod.GET)
    public String test02_01_form(CodeListForm form, Model model) {
        return "codelist/02_01_form";
    }

    // test case 02_02
    @RequestMapping(value = "02_02_form", method = RequestMethod.GET)
    public String test02_02_form(CodeListForm form, Model model) {
        return "codelist/02_02_form";
    }

    // test case 02_03
    @RequestMapping(value = "02_03_form", method = RequestMethod.GET)
    public String test02_03_form(CodeListForm form, Model model) {
        return "codelist/02_03_form";
    }

    // test case 02_04
    @RequestMapping(value = "02_04_form", method = RequestMethod.GET)
    public String test02_04_form(CodeListForm form, Model model) {
        return "codelist/02_04_form";
    }

    // test case 03_01
    @RequestMapping(value = "jdbcCodeListTestReflesh", method = RequestMethod.GET)
    public String testJdbcCodeListTestReflesh(CodeListForm form, Model model) {
        return "codelist/jdbcCodeListTestReflesh";
    }

    // test case 03_01
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "jdbcCodeListTestSelectCodeList")
    public String testJdbcCodeListTestSelectCodeList(CodeListForm form,
            Model model) {
        model.addAttribute("jdbcCodeList", codeListService.findCodeList());
        return "codelist/jdbcCodeListTestSelectCodeList";
    }

    // test case 03_01
    @RequestMapping(value = "next/{id}", method = RequestMethod.GET)
    public String testJdbcCodeListTestEditCodeList(
            @PathVariable("id") Integer id, CodeListMngForm form, Model model) {
        ItemCode code = codeListService.findOne(id);
        form.setCode(code.getCode());
        form.setValue(code.getLabel());
        return "codelist/jdbcCodeListTestEditCodeList";
    }

    @RequestMapping(value = "next", method = RequestMethod.POST, params = "jdbcCodeListTestUpdateCodeList")
    public String testJdbcCodeListTestUpdateCodeList(CodeListMngForm form,
            Model model) {
        ItemCode row = codeListService.findOne(form.getId());
        row.setCode(form.getCode());
        row.setLabel(form.getValue());
        codeListService.save(row);
        return "codelist/jdbcCodeListTestUpdateCodeList";
    }

    @RequestMapping(value = "next", method = RequestMethod.GET, params = "jdbcCodeListTestRefreshCodeList")
    public String testJdbcCodeListTestRefreshCodeList(CodeListMngForm form,
            Model model) {
        codeListService.refresh();
        return "codelist/jdbcCodeListTestReflesh";
    }

    // test case 03_02
    @RequestMapping(value = "jdbcCodeListTestCodeListIsEmpty", method = RequestMethod.GET)
    public String testJdbcCodeListTestCodeListIsEmpty(CodeListForm form,
            Model model) {
        return "codelist/jdbcCodeListTestCodeListIsEmpty";
    }

    // test case 03_03
    @RequestMapping(value = "jdbcCodeListTestDBError", method = RequestMethod.GET)
    public String testJdbcCodeListTestDBError(CodeListForm form,
            HttpServletRequest request, Model model) {
        request.setAttribute("clCodeListWrongItem", codeList.asMap());
        return "codelist/jdbcCodeListTestDBError";
    }

    // test case 06_01
    @RequestMapping(value = "06_01_form", method = RequestMethod.GET)
    public String test06_01_form(CodeListForm form, Model model) {
        return "codelist/06_01_form";
    }

    // test case 06_04
    @RequestMapping(value = "/fallbackToEn/06_04_form", method = RequestMethod.GET)
    public String test06_04_form(CodeListForm form, Model model) {
        return "codelist/06_04_form";
    }

    // test case 06_05
    @RequestMapping(value = "/fallbackToFr/06_05_form", method = RequestMethod.GET)
    public String test06_05_form(CodeListForm form, Model model) {
        return "codelist/06_05_form";
    }

    // test case 06_06
    @RequestMapping(value = "06_06_form", method = RequestMethod.GET)
    public String test06_06_form(CodeListForm form, Model model) {
        return "codelist/06_06_form";
    }

    // test case 06_07
    @RequestMapping(value = "06_07_form", method = RequestMethod.GET)
    public String test06_07_form(CodeListForm form, Model model) {
        return "codelist/06_07_form";
    }

    // test case 06_08
    @RequestMapping(value = "06_08_form", method = RequestMethod.GET)
    public String test06_08_form(CodeListForm form, Model model) {
        return "codelist/06_08_form";
    }

    // test case 06_09
    @RequestMapping(value = "06_09_form", method = RequestMethod.GET)
    public String test06_09_form(CodeListForm form, Model model) {
        return "codelist/06_09_form";
    }

    // test case 06_10
    @RequestMapping(value = "06_10_form", method = RequestMethod.GET)
    public String test06_10_form(CodeListForm form, Model model) {
        return "codelist/06_10_form";
    }

    // test case 06_11
    @RequestMapping(value = "06_11_form", method = RequestMethod.GET)
    public String test06_11_form(CodeListForm form, Model model) {
        return "codelist/06_11_form";
    }

    // test case 07_01
    @RequestMapping(value = "07_01_form", method = RequestMethod.GET)
    public String test07_01_form(CodeListForm form, Model model) {
        return "codelist/07_01_form";
    }

    // test case 07_03
    @RequestMapping(value = "/multiplePattern/07_03_form", method = RequestMethod.GET)
    public String test07_03_form(CodeListForm form, Model model) {
        return "codelist/07_03_form";
    }

    // test case 08_01
    @RequestMapping(value = "/08_01_form", method = RequestMethod.GET)
    public String test08_01_form(ExistInCheckForm form, Model model) {
        return "codelist/08_01_form";
    }

    // test case 08_01
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckString")
    public String test08_01_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_01_form";
    }

    // test case 08_02
    @RequestMapping(value = "/08_02_form", method = RequestMethod.GET)
    public String test08_02_form(ExistInCheckForm form, Model model) {
        return "codelist/08_02_form";
    }

    // test case 08_02
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckCharacter")
    public String test08_02_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_02_form";
    }

    // test case 08_03
    @RequestMapping(value = "/08_03_form", method = RequestMethod.GET)
    public String test08_03_form(ExistInCheckWrongCodeListForm form,
            Model model) {
        return "codelist/08_03_form";
    }

    // test case 08_03
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckWrongCodeList")
    public String test08_03_check(@Valid ExistInCheckWrongCodeListForm form,
            BindingResult result, Model model) {
        return "codelist/08_03_form";
    }

    // test case 08_04
    @RequestMapping(value = "/08_04_form", method = RequestMethod.GET)
    public String test08_04_form(ExistInCheckForm form, Model model) {
        return "codelist/08_04_form";
    }

    // test case 08_04
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckMethodAnnotation")
    public String test08_04_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_04_form";
    }

    // test case 08_05
    @RequestMapping(value = "/08_05_form", method = RequestMethod.GET)
    public String test08_05_form(ExistInCheckForm form, Model model) {
        return "codelist/08_05_form";
    }

    // test case 08_05
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckCustomMessage")
    public String test08_05_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_05_form";
    }

    // test case 08_06
    @RequestMapping(value = "/08_06_form", method = RequestMethod.GET)
    public String test08_06_form(ExistInCheckForm form, Model model) {
        return "codelist/08_06_form";
    }

    // test case 08_06
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckExtendedCodeList")
    public String test08_06_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_06_form";
    }

    // test case 08_06
    @RequestMapping(value = "/08_07_form", method = RequestMethod.GET)
    public String test08_07_form(ExistInCheckForm form, Model model) {
        return "codelist/08_07_form";
    }

    // test case 08_07
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckMultipleCustomCodeList")
    public String test08_07_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_07_form";
    }

    // test case 08_08
    @RequestMapping(value = "/08_08_form", method = RequestMethod.GET)
    public String test08_08_form(CodeListForm form, Model model) {
        return "codelist/08_08_form";
    }

    // test case 08_08
    @RequestMapping(value = "next", method = RequestMethod.GET, params = "existInCheckParamAnnotation")
    public String test08_08_check(CodeListForm form, Model model) {
        try {
            model.addAttribute("item1Label", existInCodeListService.getLabel(
                    form.getItem1()));
        } catch (ConstraintViolationException e) {
            model.addAttribute("item1Error", e.getConstraintViolations()
                    .iterator().next().getMessage());
            return "codelist/08_08_form";
        }
        return "codelist/08_08_form";
    }

    // test case 09_01
    @RequestMapping(value = "09_01_form", method = RequestMethod.GET)
    public String test09_01_form(CodeListForm form, Model model) {
        return "codelist/09_01_form";
    }

    // test case 10_01
    @RequestMapping(value = "10_01_form", method = RequestMethod.GET)
    public String test10_01_form(CodeListForm form, Model model) {
        return "codelist/10_01_form";
    }

    // Exception handler for test10_01_form
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ModelAndView handleBusinessException(BusinessException e) {
        ExtendedModelMap modelMap = new ExtendedModelMap();
        modelMap.addAttribute(e.getResultMessages());
        modelMap.addAttribute(setUpCodeListForm());
        return new ModelAndView("codelist/10_01_form", modelMap);
    }

}
