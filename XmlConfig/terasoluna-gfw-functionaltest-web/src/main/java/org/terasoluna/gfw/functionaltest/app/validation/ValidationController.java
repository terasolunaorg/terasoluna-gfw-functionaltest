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
package org.terasoluna.gfw.functionaltest.app.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

@Controller
@RequestMapping(value = "validation")
public class ValidationController {

    private static final ResultMessage SUCCESS = ResultMessage.fromText(
            "Validation successfully!");

    @ModelAttribute
    public ValidationForm setUpForm() {
        return new ValidationForm();
    }

    @GetMapping
    public String index(Model model) {
        return "validation/index";
    }

    @GetMapping(value = "bytemin")
    public String bytemin(Model model) {
        return "validation/bytemin";
    }

    @PostMapping(value = "bytemin")
    public String validateByteMin(@Validated({
            ValidationForm.ValidateByteMin.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return bytemin(model);
        }

        attributes.addFlashAttribute(ResultMessages.success().add(SUCCESS));
        return "redirect:/validation/bytemin";
    }

    @GetMapping(value = "bytemax")
    public String bytemax(Model model) {
        return "validation/bytemax";
    }

    @PostMapping(value = "bytemax")
    public String validateByteMax(@Validated({
            ValidationForm.ValidateByteMax.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return bytemax(model);
        }

        attributes.addFlashAttribute(ResultMessages.success().add(SUCCESS));
        return "redirect:/validation/bytemax";
    }

    @GetMapping(value = "bytesize")
    public String bytesize(Model model) {
        return "validation/bytesize";
    }

    @PostMapping(value = "bytesize")
    public String validateByteSize(@Validated({
            ValidationForm.ValidateByteSize.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return bytesize(model);
        }

        attributes.addFlashAttribute(ResultMessages.success().add(SUCCESS));
        return "redirect:/validation/bytesize";
    }

    @GetMapping(value = "compare")
    public String compare(Model model) {
        return "validation/compare";
    }

    @PostMapping(value = "compare")
    public String validateCompare(@Validated({
            ValidationForm.ValidateCompare.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "eq")
    public String validateCompareOperatorEqual(@Validated({
            ValidationForm.ValidateCompareOperatorEqual.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "ne")
    public String validateCompareOperatorNotEqual(@Validated({
            ValidationForm.ValidateCompareOperatorNotEqual.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "gt")
    public String validateCompareOperatorGreaterThan(@Validated({
            ValidationForm.ValidateCompareOperatorGreaterThan.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "ge")
    public String validateCompareGreaterThanOrEqual(@Validated({
            ValidationForm.ValidateCompareOperatorGreaterThanOrEqual.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "lt")
    public String validateCompareOperatoressThan(@Validated({
            ValidationForm.ValidateCompareOperatorLessThan.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "le")
    public String validateCompareOperatoressThanOrEqual(@Validated({
            ValidationForm.ValidateCompareOperatorLessThanOrEqual.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "prop")
    public String validateComparePathSource(@Validated({
            ValidationForm.ValidateCompareNodeProperty.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    @PostMapping(value = "compare", params = "root")
    public String validateCompareOperatorPathRootBean(@Validated({
            ValidationForm.ValidateCompareNodeRootBean.class }) ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        return internalValidateCompare(form, bindingResult, model, attributes);
    }

    private String internalValidateCompare(ValidationForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return compare(model);
        }

        attributes.addFlashAttribute(ResultMessages.success().add(SUCCESS));
        return "redirect:/validation/compare";
    }
}
