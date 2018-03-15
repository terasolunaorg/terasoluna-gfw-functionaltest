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
@RequestMapping(value = "logging/xTrackMDCPutFilter")
public class XTrackMDCPutFilterController {

    @Inject
    protected MDCService mdcService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "logging/xTrackMDCPutFilter";
    }

    @RequestMapping(value = "1_1", method = RequestMethod.GET)
    public String createDefaultXTrackMDC_01_01(Model model) {

        // case of default attribute name
        String mdc = mdcService.getMDC("X-Track");
        model.addAttribute("attributeName", "X-Track");
        model.addAttribute("xTrackMDC", mdc);

        return "logging/xTrackMDCPutFilter";
    }

    @RequestMapping(value = "1_2", method = RequestMethod.GET)
    public String createCustomXTrackMDC_01_02(Model model) {

        // case of custom attribute name
        String mdc = mdcService.getMDC("X-TrackId");
        model.addAttribute("attributeName", "X-TrackId");
        model.addAttribute("xTrackMDC", mdc);

        return "logging/xTrackMDCPutFilter";
    }

    @RequestMapping(value = "1_3", method = RequestMethod.GET)
    public String removeXTrackMDC_01_03(Model model) {

        // Under construction
        return "logging/xTrackMDCPutFilter";
    }

    @RequestMapping(value = "1_4", method = RequestMethod.GET)
    public String checkConsistencyXtrackMDCRequestToResponse_01_04(
            Model model) {

        // If you check(change Request Header to response) with the case, use selenium.
        return "logging/xTrackMDCPutFilter";
    }

}
