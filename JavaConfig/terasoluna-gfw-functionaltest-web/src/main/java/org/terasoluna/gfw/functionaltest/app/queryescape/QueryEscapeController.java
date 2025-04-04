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
package org.terasoluna.gfw.functionaltest.app.queryescape;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.functionaltest.domain.service.queryescape.DatabaseMetaInfoService;

import jakarta.inject.Inject;

@Controller
@RequestMapping("queryescape")
public class QueryEscapeController {

    @Inject
    DatabaseMetaInfoService databaseMetaInfoService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("databaseId", databaseMetaInfoService.getDatabaseId());
        model.addAttribute("databaseVersion", databaseMetaInfoService.getOracleVersion());
        return "queryescape/index";
    }
}
