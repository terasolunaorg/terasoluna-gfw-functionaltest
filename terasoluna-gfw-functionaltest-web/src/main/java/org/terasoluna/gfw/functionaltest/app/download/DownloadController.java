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
package org.terasoluna.gfw.functionaltest.app.download;

import java.io.InputStream;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.functionaltest.domain.service.download.DownloadService;

@Controller
@RequestMapping(value = "download")
public class DownloadController {

    @Inject
    protected DownloadService downloadService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {

        return "download/index";
    }

    @RequestMapping(value = "1_1", method = RequestMethod.GET)
    public String fileDownload_01_01() {
        return "imageFileDownloadView";
    }

    @RequestMapping(value = "1_2", method = RequestMethod.GET)
    public String fileDownload_01_02(Model model) {

        InputStream contentsStream = downloadService.findContentsById(1);
        model.addAttribute("contents", contentsStream);

        return "textFileDownloadView";
    }
}
