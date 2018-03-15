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
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.GET)
    public String index() {

        return "el/index";
    }

    @RequestMapping(value = "1", method = RequestMethod.GET)
    public String xSSMeasures() {
        return "el/xssOutput";
    }

    @RequestMapping(value = "output_01", method = RequestMethod.POST)
    public String xSSMeasures_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/xssOutput";
    }

    @RequestMapping(value = "2", method = RequestMethod.GET)
    public String urlEncoding() {
        return "el/urlOutput";
    }

    @RequestMapping(value = "output_02", method = RequestMethod.POST)
    public String urlEncoding_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/urlOutput";
    }

    @RequestMapping(value = "3", method = RequestMethod.GET)
    public String newLine() {
        return "el/newLineOutput";
    }

    @RequestMapping(value = "output_03", method = RequestMethod.POST)
    public String newLine_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/newLineOutput";
    }

    @RequestMapping(value = "4", method = RequestMethod.GET)
    public String cutString() {
        return "el/cutOutput";
    }

    @RequestMapping(value = "output_04", method = RequestMethod.POST)
    public String cutString_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/cutOutput";
    }

    @RequestMapping(value = "5", method = RequestMethod.GET)
    public String urlLinkString() {
        return "el/linkOutput";
    }

    @RequestMapping(value = "5_4", method = RequestMethod.GET)
    public String urlEncodeLinkString() {
        return "el/linkUOutput";
    }

    @RequestMapping(value = "output_05", method = RequestMethod.POST)
    public String urlLink_InputData(
            @RequestParam("outputData") String outputData, Model model) {
        model.addAttribute("outputData", outputData);

        return "el/linkOutput";
    }

    @RequestMapping(value = "output_05_04")
    public String urlULink_InputDatas(String URLPath, String outputQueryParam,
            Model model) {
        model.addAttribute("URLPath", URLPath);
        model.addAttribute("outputQueryParam", outputQueryParam);

        return "el/linkUOutput";
    }

    @RequestMapping(value = "6_1-2", method = RequestMethod.GET)
    public String queryString(Model model) {
        DateTime dt = new DateTime(2013, 10, 01, 0, 0, 0);

        Map<String, Object> outputQueryData = new LinkedHashMap<String, Object>();
        outputQueryData.put("Date", dt.toDate());
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

    @RequestMapping(value = "6_3-", method = RequestMethod.GET)
    public String beanQueryString(Model model) {

        return "el/beanQueryOutput";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
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

    @RequestMapping(value = "6_7", method = RequestMethod.GET)
    public String returnQuerySupportObject(Model model) {

        List<String> listData = new ArrayList<String>();
        listData.add("Output Message!!");

        model.addAttribute("outputData", listData);

        return "el/noSupportQueryOutput";
    }

    @RequestMapping(value = "7_1", method = RequestMethod.GET)
    public String javascriptXSSMeasures_07_01(Model model) {

        model.addAttribute("xssAttack",
                "</script><script>alert('XSS Attack');</script>");

        return "el/javascriptOutput";
    }

    @RequestMapping(value = "7_2", method = RequestMethod.GET)
    public String javascriptXSSMeasures_07_02(Model model) {

        model.addAttribute("xssAttack",
                "</script><script>alert(\"XSS Attack\");</script>");

        return "el/javascriptOutput";
    }

    @RequestMapping(value = "7_3", method = RequestMethod.GET)
    public String javascriptXSSMeasures_07_03(Model model) {

        model.addAttribute("xssAttack", "Spring Framework");

        return "el/javascriptOutput";
    }

    @RequestMapping(value = "8_1", method = RequestMethod.GET)
    public String eventHandlerXSSMeasures_08_01(Model model) {

        model.addAttribute("xssAttack", "');alert('XSS Attack');// . )");

        return "el/eventHandlerOutput";
    }

    @RequestMapping(value = "8_2", method = RequestMethod.GET)
    public String eventHandlerXSSMeasures_08_02(Model model) {

        model.addAttribute("xssAttack", "');alert(\"XSS Attack\");// . )");

        return "el/eventHandlerOutput";
    }

    @RequestMapping(value = "8_3", method = RequestMethod.GET)
    public String eventHandlerXSSMeasures_08_03(Model model) {

        model.addAttribute("xssAttack", "Spring Framework");

        return "el/eventHandlerOutput";
    }
}
