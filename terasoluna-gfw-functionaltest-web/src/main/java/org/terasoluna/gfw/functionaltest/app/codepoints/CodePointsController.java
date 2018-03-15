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
package org.terasoluna.gfw.functionaltest.app.codepoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.common.codepoints.CodePoints;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Katakana;

@Controller
@RequestMapping(value = "codepoints")
public class CodePointsController {

    @ModelAttribute
    public ContainsAllForm1 setUpContainsAllForm1() {
        return new ContainsAllForm1();
    }

    @ModelAttribute
    public ContainsAllForm2 setUpContainsAllForm2() {
        return new ContainsAllForm2();
    }

    @ModelAttribute
    public ContainsAllForm3 setUpContainsAllForm3() {
        return new ContainsAllForm3();
    }

    @ModelAttribute
    public ContainsAllForm4 setUpContainsAllForm4() {
        return new ContainsAllForm4();
    }

    @ModelAttribute
    public FirstExcludedCodePointForm setUpFirstExcludedCodePointForm() {
        return new FirstExcludedCodePointForm();
    }

    @ModelAttribute
    public ExcludedCodePointsForm setUpExcludedCodePointsForm() {
        return new ExcludedCodePointsForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {

        return "codepoints/index";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.GET, params = {
            "form1" })
    public String containsAll_form1() {
        return "codepoints/containsAll_form1";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "useInstanceKind=codePointsOf" })
    public String containsAllCodePointsOf(Model model, ContainsAllForm1 form) {

        CodePoints codePoints1 = CodePoints.of(JIS_X_0208_Katakana.class);
        CodePoints codePoints2 = CodePoints.of(JIS_X_0208_Katakana.class);

        model.addAttribute("instanceCheck", codePoints1.equals(codePoints2));
        model.addAttribute("containsAll", codePoints1.containsAll(form
                .getTargetValue()));

        return "codepoints/result_instanceCheckAndcontainsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "useInstanceKind=newJIS_X_0208_Katakana" })
    public String containsAllNewJIS_X_0208_Katakana(Model model,
            ContainsAllForm1 form) {

        CodePoints codePoints = new JIS_X_0208_Katakana();

        model.addAttribute("containsAll", codePoints.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.GET, params = {
            "form2" })
    public String containsAll_form2(ContainsAllForm2 form) {
        form.setCodePoints(new Integer[2]);
        return "codepoints/containsAll_form2";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "useInstanceKind=newCodePointsWithIntegerArray" })
    public String containsAllNewCodePointsWithIntegerArray(Model model,
            @Validated ContainsAllForm2 form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return containsAll_form2(form);
        }

        CodePoints codePoints = new CodePoints(form.getCodePoints());

        model.addAttribute("containsAll", codePoints.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "useInstanceKind=newCodePointsWithIntegerSet" })
    public String containsAllNewCodePointsWithIntegerSet(Model model,
            @Validated ContainsAllForm2 form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return containsAll_form2(form);
        }

        Set<Integer> codePoints4Constructor = new HashSet<Integer>(Arrays
                .asList(form.getCodePoints()));
        CodePoints codePoints = new CodePoints(codePoints4Constructor);

        model.addAttribute("containsAll", codePoints.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "useInstanceKind=newCodePonitsWithString" })
    public String containsAllNewCodePonitsWithString(Model model,
            ContainsAllForm1 form) {

        String targetValue = form.getTargetValue();
        CodePoints codePoints = new CodePoints(targetValue);

        model.addAttribute("containsAll", codePoints.containsAll(targetValue));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.GET, params = {
            "form3" })
    public String containsAll_form3(ContainsAllForm3 form) {
        form.setCodePoints(new String[2]);
        return "codepoints/containsAll_form3";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "newCodePointsWithStringArray" })
    public String containsAllNewCodePointsWithStringArray(Model model,
            ContainsAllForm3 form) {

        CodePoints codePoints = new CodePoints(form.getCodePoints());

        model.addAttribute("containsAll", codePoints.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.GET, params = {
            "form4=union" })
    public String containsAll_form4_union(ContainsAllForm4 form) {
        form.setCodePointsA(new Integer[2]);
        form.setCodePointsB(new Integer[2]);
        return "codepoints/containsAll_form4";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "operation=union" })
    public String containsAllUnion(Model model,
            @Validated ContainsAllForm4 form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return containsAll_form4_union(form);
        }

        CodePoints abCp = new CodePoints(form.getCodePointsA());
        CodePoints cdCp = new CodePoints(form.getCodePointsB());
        CodePoints abcdCp = abCp.union(cdCp);

        model.addAttribute("containsAll", abcdCp.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.GET, params = {
            "form4=subtract" })
    public String containsAll_form4_subtract(ContainsAllForm4 form) {
        form.setCodePointsA(new Integer[4]);
        form.setCodePointsB(new Integer[2]);
        return "codepoints/containsAll_form4";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "operation=subtract" })
    public String containsAllSubtract(Model model,
            @Validated ContainsAllForm4 form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return containsAll_form4_subtract(form);
        }

        CodePoints abcdCp = new CodePoints(form.getCodePointsA());
        CodePoints cdCp = new CodePoints(form.getCodePointsB());
        CodePoints abCp = abcdCp.subtract(cdCp);

        model.addAttribute("containsAll", abCp.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.GET, params = {
            "form4=intersect" })
    public String containsAll_form4_intersect(ContainsAllForm4 form) {
        form.setCodePointsA(new Integer[4]);
        form.setCodePointsB(new Integer[3]);
        return "codepoints/containsAll_form4";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "operation=intersect" })
    public String containsAllIntersect(Model model,
            @Validated ContainsAllForm4 form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return containsAll_form4_intersect(form);
        }

        CodePoints abcdCp = new CodePoints(form.getCodePointsA());
        CodePoints cdeCp = new CodePoints(form.getCodePointsB());
        CodePoints cdCp = abcdCp.intersect(cdeCp);

        model.addAttribute("containsAll", cdCp.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "containsAll", method = RequestMethod.POST, params = {
            "useInstanceKind=codePointsOfWithJIS_X_0208_Katakana" })
    public String containsAllCodePointsOfWithJIS_X_0208_Katakana(Model model,
            ContainsAllForm1 form) {

        CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);

        model.addAttribute("containsAll", jisX208KanaCp.containsAll(form
                .getTargetValue()));

        return "codepoints/result_containsAll";
    }

    @RequestMapping(value = "firstExcludedCodePoint", method = RequestMethod.GET, params = {
            "form" })
    public String firstExcludedCodePoint_form() {
        return "codepoints/firstExcludedCodePoint_form";
    }

    @RequestMapping(value = "firstExcludedCodePoint", method = RequestMethod.POST)
    public String firstExcludedCodePoint(Model model,
            FirstExcludedCodePointForm form) {

        CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);

        model.addAttribute("firstExcludedCodepoint", jisX208KanaCp
                .firstExcludedCodePoint(form.getTargetValue()));

        return "codepoints/result_firstExcludedCodepoint";
    }

    @RequestMapping(value = "excludedCodePoints", method = RequestMethod.GET, params = {
            "form" })
    public String excludedCodePoints_form() {
        return "codepoints/excludedCodePoints_form";
    }

    @RequestMapping(value = "excludedCodePoints", method = RequestMethod.POST)
    public String excludedCodePoints(Model model, ExcludedCodePointsForm form) {

        CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
        Set<Integer> excludedCodePoints4Constructor = jisX208KanaCp
                .allExcludedCodePoints(form.getTargetValue());

        List<Integer> excludedCodePoints = new ArrayList<Integer>(excludedCodePoints4Constructor);
        model.addAttribute("excludedCodePoints", excludedCodePoints);

        return "codepoints/result_excludedCodepoints";
    }

}
