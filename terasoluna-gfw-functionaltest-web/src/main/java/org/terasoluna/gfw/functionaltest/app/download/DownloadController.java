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
package org.terasoluna.gfw.functionaltest.app.download;

import java.io.InputStream;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.functionaltest.domain.service.download.DownloadService;

@Controller
@RequestMapping(value = "download")
public class DownloadController {

    @Inject
    protected DownloadService downloadService;

    @GetMapping
    public String index() {

        return "download/index";
    }

    @GetMapping(value = "1_1")
    public String fileDownload_01_01() {
        return "imageFileDownloadView";
    }

    @GetMapping(value = "1_2")
    public String fileDownload_01_02(Model model) {

        InputStream contentsStream = downloadService.findContentsById(1);
        model.addAttribute("contents", contentsStream);

        return "textFileDownloadView";
    }
}
