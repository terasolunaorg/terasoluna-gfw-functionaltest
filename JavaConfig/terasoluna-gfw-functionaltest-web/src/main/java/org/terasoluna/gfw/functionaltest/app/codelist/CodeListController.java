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
package org.terasoluna.gfw.functionaltest.app.codelist;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.terasoluna.gfw.common.codelist.CodeList;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessages;
import org.terasoluna.gfw.functionaltest.domain.model.I18nItemCode;
import org.terasoluna.gfw.functionaltest.domain.model.ItemCode;
import org.terasoluna.gfw.functionaltest.domain.service.codelist.CodeListService;
import org.terasoluna.gfw.functionaltest.domain.service.codelist.ExistInCodeListService;
import org.terasoluna.gfw.functionaltest.domain.service.codelist.I18nCodeListService;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "codelist")
public class CodeListController {

    @Inject
    CodeListService codeListService;

    @Inject
    I18nCodeListService i18nCodeListService;

    @Inject
    ExistInCodeListService existInCodeListService;

    @Inject
    @Qualifier("CODELIST_WRONG_ITEM")
    CodeList codeList;

    @GetMapping
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

    @GetMapping(value = "next", params = "confirm")
    public String confirm(CodeListForm form, Model model) {
        return "codelist/confirm";
    }

    // test case 01_01
    @GetMapping(value = "01_01_form")
    public String test01_01_form(CodeListForm form, Model model) {
        return "codelist/01_01_form";
    }

    // test case 01_02
    @GetMapping(value = "01_02_form")
    public String test01_02_form(CodeListForm form, Model model) {
        return "codelist/01_02_form";
    }

    // test case 02_01
    @GetMapping(value = "02_01_form")
    public String test02_01_form(CodeListForm form, Model model) {
        return "codelist/02_01_form";
    }

    // test case 02_02
    @GetMapping(value = "02_02_form")
    public String test02_02_form(CodeListForm form, Model model) {
        return "codelist/02_02_form";
    }

    // test case 02_03
    @GetMapping(value = "02_03_form")
    public String test02_03_form(CodeListForm form, Model model) {
        return "codelist/02_03_form";
    }

    // test case 02_04
    @GetMapping(value = "02_04_form")
    public String test02_04_form(CodeListForm form, Model model) {
        return "codelist/02_04_form";
    }

    // test case 03_01
    @GetMapping(value = "jdbcCodeListTestReflesh")
    public String testJdbcCodeListTestReflesh(CodeListForm form, Model model) {
        return "codelist/jdbcCodeListTestReflesh";
    }

    // test case 03_01
    @GetMapping(value = "next", params = "jdbcCodeListTestSelectCodeList")
    public String testJdbcCodeListTestSelectCodeList(CodeListForm form,
            Model model) {
        model.addAttribute("jdbcCodeList", codeListService.findCodeList());
        return "codelist/jdbcCodeListTestSelectCodeList";
    }

    // test case 03_01
    @GetMapping(value = "next/{id}")
    public String testJdbcCodeListTestEditCodeList(
            @PathVariable("id") Integer id, CodeListMngForm form, Model model) {
        ItemCode code = codeListService.findOne(id);
        form.setCode(code.getCode());
        form.setValue(code.getLabel());
        return "codelist/jdbcCodeListTestEditCodeList";
    }

    @PostMapping(value = "next", params = "jdbcCodeListTestUpdateCodeList")
    public String testJdbcCodeListTestUpdateCodeList(CodeListMngForm form,
            Model model) {
        ItemCode row = codeListService.findOne(form.getId());
        row.setCode(form.getCode());
        row.setLabel(form.getValue());
        codeListService.save(row);
        return "codelist/jdbcCodeListTestUpdateCodeList";
    }

    @GetMapping(value = "next", params = "jdbcCodeListTestRefreshCodeList")
    public String testJdbcCodeListTestRefreshCodeList(CodeListMngForm form,
            Model model) {
        codeListService.refresh();
        return "codelist/jdbcCodeListTestReflesh";
    }

    // test case 03_02
    @GetMapping(value = "jdbcCodeListTestCodeListIsEmpty")
    public String testJdbcCodeListTestCodeListIsEmpty(CodeListForm form,
            Model model) {
        return "codelist/jdbcCodeListTestCodeListIsEmpty";
    }

    // test case 03_03
    @GetMapping(value = "jdbcCodeListTestDBError")
    public String testJdbcCodeListTestDBError(CodeListForm form,
            HttpServletRequest request, Model model) {
        request.setAttribute("clCodeListWrongItem", codeList.asMap());
        return "codelist/jdbcCodeListTestDBError";
    }

    // test case 06_01
    @GetMapping(value = "06_01_form")
    public String test06_01_form(CodeListForm form, Model model) {
        return "codelist/06_01_form";
    }

    // test case 06_02
    @GetMapping(value = "06_02_form")
    public String test06_02_form(CodeListForm form, Model model) {
        return "codelist/06_02_form";
    }

    // test case 06_03
    @GetMapping(value = "06_03_form")
    public String test06_03_form(CodeListForm form, Model model) {
        return "codelist/06_03_form";
    }

    // test case 11_01
    @GetMapping(value = "11_01_form")
    public String test11_01_form(CodeListForm form, Model model) {
        return "codelist/11_01_form";
    }

    // test case 12_01
    @GetMapping(value = "12_01_form")
    public String test12_01_form(I18nCodeListForm form, Model model) {
        model.addAttribute("items", i18nCodeListService.findAll());
        return "codelist/12_01_form";
    }

    // test case 12_01
    @PostMapping(value = "12_01_form", params = "update")
    public String test12_01_form_update(I18nCodeListForm form, Model model) {
        I18nItemCode row = i18nCodeListService.findOne(form.getId());
        row.setCode(form.getCode());
        row.setLabelEn(form.getLabelEn());
        row.setLabelJa(form.getLabelJa());
        i18nCodeListService.save(row);
        model.addAttribute("items", i18nCodeListService.findAll());
        return "codelist/12_01_form";
    }

    // test case 12_01
    @PostMapping(value = "12_01_form", params = "refresh")
    public String test12_01_form_refrash(I18nCodeListForm form, Model model,
            @RequestParam(name = "recursive", required = false) Boolean recursive) {
        if (recursive == null) {
            i18nCodeListService.refresh();
        } else {
            i18nCodeListService.refresh(recursive);
        }
        model.addAttribute("items", i18nCodeListService.findAll());
        return "codelist/12_01_form";
    }

    // test case 12_01
    @PostMapping(value = "12_01_form", params = "refreshAll")
    public String test12_01_form_refrashAll(I18nCodeListForm form,
            Model model) {
        i18nCodeListService.refreshAll();
        model.addAttribute("items", i18nCodeListService.findAll());
        return "codelist/12_01_form";
    }

    // test case 07_01
    @GetMapping(value = "07_01_form")
    public String test07_01_form(CodeListForm form, Model model) {
        return "codelist/07_01_form";
    }

    // test case 07_03
    @GetMapping(value = "/multiplePattern/07_03_form")
    public String test07_03_form(CodeListForm form, Model model) {
        return "codelist/07_03_form";
    }

    // test case 10_01
    @GetMapping(value = "10_01_form")
    public String test10_01_form(CodeListForm form, Model model) {
        throw new BusinessException(ResultMessages.warning().add(
                "w.gt.me.0001"));
    }

    // test case 10_02
    @GetMapping(value = "10_02_form")
    public String test10_02_form(CodeListForm form, Model model) {
        try {
            throw new BusinessException(ResultMessages.warning().add(
                    "w.gt.me.0001"));
        } catch (BusinessException e) {
            model.addAttribute(e.getResultMessages());
        }
        return "codelist/10_02_form";
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

    // test case 08_01
    @GetMapping(value = "/08_01_form")
    public String test08_01_form(ExistInCheckForm form, Model model) {
        return "codelist/08_01_form";
    }

    // test case 08_01
    @GetMapping(value = "next", params = "existInCheckString")
    public String test08_01_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_01_form";
    }

    // test case 08_02
    @GetMapping(value = "/08_02_form")
    public String test08_02_form(ExistInCheckForm form, Model model) {
        return "codelist/08_02_form";
    }

    // test case 08_02
    @GetMapping(value = "next", params = "existInCheckCharacter")
    public String test08_02_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_02_form";
    }

    // test case 08_03
    @GetMapping(value = "/08_03_form")
    public String test08_03_form(ExistInCheckForm form, Model model) {
        return "codelist/08_03_form";
    }

    // test case 08_03
    @GetMapping(value = "next", params = "existInCheckNumber")
    public String test08_03_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_03_form";
    }

    // test case 08_04
    @GetMapping(value = "/08_04_form")
    public String test08_04_form(ExistInCheckForm form, Model model) {
        return "codelist/08_04_form";
    }

    // test case 08_04
    @GetMapping(value = "next", params = "existInCheckNumberFormatted")
    public String test08_04_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_04_form";
    }

    // test case 08_05
    @GetMapping(value = "/08_05_form")
    public String test08_05_form(ExistInCheckWrongCodeListForm form,
            Model model) {
        return "codelist/08_05_form";
    }

    // test case 08_05
    @GetMapping(value = "next", params = "existInCheckWrongCodeList")
    public String test08_05_check(@Valid ExistInCheckWrongCodeListForm form,
            BindingResult result, Model model) {
        return "codelist/08_05_form";
    }

    // test case 08_06
    @GetMapping(value = "/08_06_form")
    public String test08_06_form(ExistInCheckForm form, Model model) {
        return "codelist/08_06_form";
    }

    // test case 08_06
    @GetMapping(value = "next", params = "existInCheckMethodAnnotation")
    public String test08_06_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_06_form";
    }

    // test case 08_07
    @GetMapping(value = "/08_07_form")
    public String test08_07_form(ExistInCheckForm form, Model model) {
        return "codelist/08_07_form";
    }

    // test case 08_07
    @GetMapping(value = "next", params = "existInCheckCustomMessage")
    public String test08_07_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_07_form";
    }

    // test case 08_08
    @GetMapping(value = "/08_08_form")
    public String test08_08_form(ExistInCheckForm form, Model model) {
        return "codelist/08_08_form";
    }

    // test case 08_08
    @GetMapping(value = "next", params = "existInCheckExtendedCodeList")
    public String test08_08_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_08_form";
    }

    // test case 08_09
    @GetMapping(value = "/08_09_form")
    public String test08_09_form(ExistInCheckForm form, Model model) {
        return "codelist/08_09_form";
    }

    // test case 08_09
    @GetMapping(value = "next", params = "existInCheckMultipleCustomCodeList")
    public String test08_09_check(@Valid ExistInCheckForm form,
            BindingResult result, Model model) {
        return "codelist/08_09_form";
    }

    // test case 08_10
    @GetMapping(value = "/08_10_form")
    public String test08_10_form(CodeListForm form, Model model) {
        return "codelist/08_10_form";
    }

    // test case 08_10
    @GetMapping(value = "next", params = "existInCheckParamAnnotation")
    public String test08_10_check(CodeListForm form, Model model) {
        try {
            model.addAttribute("item1Label", existInCodeListService.getLabel(
                    form.getItem1()));
        } catch (ConstraintViolationException e) {
            model.addAttribute("item1Error", e.getConstraintViolations()
                    .iterator().next().getMessage());
            return "codelist/08_10_form";
        }
        return "codelist/08_10_form";
    }

    // test case 09_01
    @GetMapping(value = "09_01_form")
    public String test09_01_form(CodeListForm form, Model model) {
        return "codelist/09_01_form";
    }
}
