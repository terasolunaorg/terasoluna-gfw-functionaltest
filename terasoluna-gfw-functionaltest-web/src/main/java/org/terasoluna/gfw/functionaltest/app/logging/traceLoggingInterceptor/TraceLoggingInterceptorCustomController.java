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
package org.terasoluna.gfw.functionaltest.app.logging.traceLoggingInterceptor;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.functionaltest.domain.service.logging.TraceLoggingInterceptorService;

@Controller
@RequestMapping(value = "logging/traceLoggingInterceptor/customWarnHandling")
public class TraceLoggingInterceptorCustomController {

    @Inject
    protected TraceLoggingInterceptorService traceLoggingInterceptorService;

    private static final Logger logger = LoggerFactory.getLogger(
            TraceLoggingInterceptorCustomController.class);

    @RequestMapping(value = "4_3", method = RequestMethod.GET)
    public String customTraceLoggingAsTraceLevel_04_03(Model model) {

        long startTime = traceLoggingInterceptorService.getTime();
        logger.trace("request customTraceLoggingAsTraceLevel_04_03");

        // after sleep, output log message as trace level.
        traceLoggingInterceptorService.sleep(4800);

        long finishTime = traceLoggingInterceptorService.getTime();

        model.addAttribute("requestType",
                "request custom traceLogging as trace level");
        model.addAttribute("processingTime", traceLoggingInterceptorService
                .calcProcessingTime(startTime, finishTime));

        return "logging/traceLoggingInterceptor";
    }

    @RequestMapping(value = "4_4", method = RequestMethod.GET)
    public String customTraceLoggingAsWarnLevel_04_04(Model model) {

        long startTime = traceLoggingInterceptorService.getTime();
        logger.trace("request customTraceLoggingAsWarnLevel_04_04");

        // after sleep, output log message as warn level.
        traceLoggingInterceptorService.sleep(5100);

        long finishTime = traceLoggingInterceptorService.getTime();

        model.addAttribute("requestType",
                "request custom traceLogging as warn level");
        model.addAttribute("processingTime", traceLoggingInterceptorService
                .calcProcessingTime(startTime, finishTime));

        return "logging/traceLoggingInterceptor";
    }
}
