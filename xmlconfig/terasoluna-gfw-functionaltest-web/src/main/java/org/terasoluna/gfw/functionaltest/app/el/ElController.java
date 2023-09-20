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
package org.terasoluna.gfw.functionaltest.app.el;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.terasoluna.gfw.functionaltest.domain.repository.customer.CustomerSearchCriteria;

@Controller
@RequestMapping(value = "el")
public class ElController {

    @ModelAttribute
    public CustomerSearchCriteria setUpForm() {
        CustomerSearchCriteria criteria = new CustomerSearchCriteria();
        return criteria;
    }

    @GetMapping
    public String index() {

        return "el/index";
    }

    @GetMapping(value = "1")
    public String xSSMeasures() {
        return "el/xssOutput";
    }

    @PostMapping(value = "output_01")
    public String xSSMeasures_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/xssOutput";
    }

    @GetMapping(value = "2")
    public String urlEncoding() {
        return "el/urlOutput";
    }

    @PostMapping(value = "output_02")
    public String urlEncoding_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/urlOutput";
    }

    @GetMapping(value = "3")
    public String newLine() {
        return "el/newLineOutput";
    }

    @PostMapping(value = "output_03")
    public String newLine_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/newLineOutput";
    }

    @GetMapping(value = "4")
    public String cutString() {
        return "el/cutOutput";
    }

    @PostMapping(value = "output_04")
    public String cutString_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/cutOutput";
    }

    @GetMapping(value = "5")
    public String urlLinkString() {
        return "el/linkOutput";
    }

    @GetMapping(value = "5_4")
    public String urlEncodeLinkString() {
        return "el/linkUOutput";
    }

    @PostMapping(value = "output_05")
    public String urlLink_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/linkOutput";
    }

    @PostMapping(value = "output_05_04")
    public String urlULink_InputDatas(
            @RequestParam("outputQueryParam") String outputQueryParam,
            Model model) {
        model.addAttribute("outputQueryParam", outputQueryParam);

        return "el/linkUOutput";
    }

    @GetMapping(value = "6_1-2")
    public String queryString(Model model) {
        LocalDateTime dt = LocalDateTime.of(2013, 10, 01, 0, 0, 0);

        Map<String, Object> outputQueryData = new LinkedHashMap<String, Object>();
        outputQueryData.put("Date", dt.toLocalDate());
        outputQueryData.put("String", "Spring");
        outputQueryData.put("int", 100);

        model.addAttribute("outputData", outputQueryData);

        outputQueryData = new LinkedHashMap<String, Object>();
        outputQueryData.put("&String", "framework");
        outputQueryData.put("Long", 100L);
        outputQueryData.put("boolean", true);
        outputQueryData.put("DateTime", dt);

        model.addAttribute("noAndDoubleOutput", outputQueryData);

        return "el/mapQueryOutput";
    }

    @GetMapping(value = "6_3-")
    public String beanQueryString(Model model) {

        return "el/beanQueryOutput";
    }

    @GetMapping(value = "search")
    public String search(CustomerSearchCriteria criteria,
            @PageableDefault Pageable pageable, Model model) {

        // Create Dummy Data
        List<String> customerList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            customerList.add("Customer");
        }

        Page<String> customer = new PageImpl<String>(customerList, pageable, 100);

        model.addAttribute("page", customer);

        return "el/beanQueryOutput";
    }

    @GetMapping(value = "6_7")
    public String returnQuerySupportObject(Model model) {

        List<String> listData = new ArrayList<String>();
        listData.add("Output Message!!");

        model.addAttribute("outputData", listData);

        return "el/noSupportQueryOutput";
    }

    @GetMapping(value = "7_1")
    public String javascriptXSSMeasures_07_01(Model model) {

        model.addAttribute("xssAttack",
                "</script><script>alert('XSS Attack');</script>");

        return "el/javascriptOutput";
    }

    @GetMapping(value = "7_2")
    public String javascriptXSSMeasures_07_02(Model model) {

        model.addAttribute("xssAttack",
                "</script><script>alert(\"XSS Attack\");</script>");

        return "el/javascriptOutput";
    }

    @GetMapping(value = "7_3")
    public String javascriptXSSMeasures_07_03(Model model) {

        model.addAttribute("xssAttack", "Spring Framework");

        return "el/javascriptOutput";
    }

    @GetMapping(value = "8_1")
    public String eventHandlerXSSMeasures_08_01(Model model) {

        model.addAttribute("xssAttack", "');alert('XSS Attack');// . )");

        return "el/eventHandlerOutput";
    }

    @GetMapping(value = "8_2")
    public String eventHandlerXSSMeasures_08_02(Model model) {

        model.addAttribute("xssAttack", "');alert(\"XSS Attack\");// . )");

        return "el/eventHandlerOutput";
    }

    @GetMapping(value = "8_3")
    public String eventHandlerXSSMeasures_08_03(Model model) {

        model.addAttribute("xssAttack", "Spring Framework");

        return "el/eventHandlerOutput";
    }
}
