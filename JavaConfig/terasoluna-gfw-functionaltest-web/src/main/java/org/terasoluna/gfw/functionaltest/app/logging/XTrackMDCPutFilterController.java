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
package org.terasoluna.gfw.functionaltest.app.logging;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.functionaltest.domain.service.logging.MDCService;

import jakarta.inject.Inject;

@Controller
@RequestMapping(value = "logging/xTrackMDCPutFilter")
public class XTrackMDCPutFilterController {

    @Inject
    protected MDCService mdcService;

    @GetMapping
    public String index() {
        return "logging/xTrackMDCPutFilter";
    }

    @GetMapping(value = "1_1")
    public String createDefaultXTrackMDC_01_01(Model model) {

        // case of default attribute name
        String mdc = mdcService.getMDC("X-Track");
        model.addAttribute("attributeName", "X-Track");
        model.addAttribute("xTrackMDC", mdc);

        return "logging/xTrackMDCPutFilter";
    }

    @GetMapping(value = "1_2")
    public String createCustomXTrackMDC_01_02(Model model) {

        // case of custom attribute name
        String mdc = mdcService.getMDC("X-TrackId");
        model.addAttribute("attributeName", "X-TrackId");
        model.addAttribute("xTrackMDC", mdc);

        return "logging/xTrackMDCPutFilter";
    }

    @GetMapping(value = "1_3")
    public String removeXTrackMDC_01_03(Model model) {

        // Under construction
        return "logging/xTrackMDCPutFilter";
    }

    @GetMapping(value = "1_4")
    public String checkConsistencyXtrackMDCRequestToResponse_01_04(
            Model model) {

        // If you check(change Request Header to response) with the case, use selenium.
        return "logging/xTrackMDCPutFilter";
    }

}
