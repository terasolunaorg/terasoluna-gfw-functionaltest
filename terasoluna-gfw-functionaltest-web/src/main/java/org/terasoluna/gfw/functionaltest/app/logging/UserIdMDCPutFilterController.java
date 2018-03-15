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
package org.terasoluna.gfw.functionaltest.app.logging;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.functionaltest.domain.service.logging.MDCService;

@Controller
@RequestMapping(value = "logging/userIdMDCPutFilter")
public class UserIdMDCPutFilterController {

    @Inject
    protected MDCService mdcService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "logging/userIdMDCPutFilter";
    }

    @RequestMapping(value = "2_1", method = RequestMethod.GET)
    public String createDefaultUserIdMDC_02_01(Model model) {

        // case of default attribute name before login
        String mdc = mdcService.getMDC("USER");
        model.addAttribute("attributeName", "USER");
        model.addAttribute("userIdMDC", mdc);

        return "logging/userIdMDCPutFilter";
    }

    @RequestMapping(value = "2_2", method = RequestMethod.GET)
    public String createCustomUserIdMDC_02_02(Model model) {

        // case of custom attribute name before login
        String mdc = mdcService.getMDC("X-UserId");
        model.addAttribute("attributeName", "X-UserId");
        model.addAttribute("userIdMDC", mdc);

        return "logging/userIdMDCPutFilter";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String forwardAuthenticationPage(Model model) {
        // redirect
        return "logging/userIdMDCPutFilterAfterLogin";
    }

    @RequestMapping(value = "2_4", method = RequestMethod.GET)
    public String createDefaultUserIdMDCAfterLogin_02_04(Model model) {

        // case of default attribute name after login
        String mdc = mdcService.getMDC("USER");
        model.addAttribute("attributeName", "USER");
        model.addAttribute("userIdMDC", mdc);

        return "logging/userIdMDCPutFilterAfterLogin";
    }
}
