/*
 * Copyright (C) 2013-2017 NTT DATA Corporation
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
package org.terasoluna.gfw.functionaltest.app.csrf;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "csrf")
public class CsrfController {

    @ModelAttribute
    public FileUploadForm setUpFileUploadForm() {
        return new FileUploadForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "csrf/index";
    }

    @RequestMapping(value = "csrfHeadSet", method = RequestMethod.GET)
    public String headCsrfTokenSendDisplay(
            @RequestParam("method") String method, Model model) {
        model.addAttribute("method", method);
        return "csrf/headCsrfTokenSend";
    }

    @RequestMapping(value = "fileUpload", method = RequestMethod.GET)
    public String fileUploadDisplay() {
        return "csrf/fileupload";
    }

    @RequestMapping(value = "csrfTokenHeadAndFormSetting", method = RequestMethod.GET)
    public String csrfTokenHeadAndFormSetting() {
        return "csrf/csrfTokenHeadAndFormSetting";
    }

    @RequestMapping(value = "1_1", method = RequestMethod.GET)
    public String springFormNormalCsrfTokenSend_HttpMethodGet_01_01(
            Model model) {
        model.addAttribute("testName", Thread.currentThread().getStackTrace()[1]
                .getMethodName());
        return "csrf/success";
    }

    @RequestMapping(value = "1_2", method = RequestMethod.GET)
    public String springFormAlterCsrfTokenSend_HttpMethodGet_01_02(
            Model model) {
        model.addAttribute("testName", Thread.currentThread().getStackTrace()[1]
                .getMethodName());
        return "csrf/success";
    }

    @RequestMapping(value = "1_3", method = RequestMethod.POST)
    public String springFormNormalCsrfTokenSend_HttpMethodPost_01_03(
            Model model) {
        model.addAttribute("testName", Thread.currentThread().getStackTrace()[1]
                .getMethodName());
        return "csrf/success";
    }

    @RequestMapping(value = "1_4", method = RequestMethod.POST)
    public String springFormAlterCsrfTokenSend_HttpMethodPost_01_04() {
        return "csrf/success";
    }

    @RequestMapping(value = "1_5", method = RequestMethod.POST)
    public String formNormalCsrfTokenSend_HttpMethodPost_01_05(Model model) {
        model.addAttribute("testName", Thread.currentThread().getStackTrace()[1]
                .getMethodName());
        return "csrf/success";
    }

    @RequestMapping(value = "1_6", method = RequestMethod.POST)
    public String formAlterCsrfTokenSend_HttpMethodPost_01_06() {
        return "csrf/success";
    }

    @RequestMapping(value = "ajax")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String headCsrfTokenSend() {
        return "OK";
    }

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String upload() {
        return "csrf/index";
    }
}
