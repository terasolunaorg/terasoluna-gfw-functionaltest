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
package org.terasoluna.gfw.functionaltest.app.redirect;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.functionaltest.domain.model.UserInfo;
import org.terasoluna.gfw.functionaltest.domain.service.redirect.RedirectService;

@Controller
@RequestMapping(value = "redirect")
public class RedirectController {

    @Inject
    RedirectService redirectService;

    @Value("${app.redirect.allowed.externalUrl}")
    String redirectionAllowedExternalUrl;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect/index";
    }

    @ModelAttribute
    public ListForm setUpListForm() {
        return new ListForm();
    }

    @ModelAttribute
    public DetailForm setUpDetailForm() {
        return new DetailForm();
    }

    @RequestMapping(value = "login")
    public String viewLoginForm() {
        return "redirect/login";
    }

    @RequestMapping(value = "listWithInternalPath", method = RequestMethod.GET)
    public String listWithInternalPath(Model model) {
        model.addAttribute("users", redirectService.findUserInfo());
        return "redirect/listWithInternalPath";
    }

    @RequestMapping(value = "listWithNoPath", method = RequestMethod.GET)
    public String listWithNoPath(Model model) {
        model.addAttribute("users", redirectService.findUserInfo());
        return "redirect/listWithNoPath";
    }

    @RequestMapping(value = "listWithExternalPath", method = RequestMethod.GET)
    public String listWithExternalPath(Model model) {
        model.addAttribute("users", redirectService.findUserInfo());
        return "redirect/listWithExternalPath";
    }

    @RequestMapping(value = "listWithGoTo", method = RequestMethod.GET)
    public String listWithGoTo(Model model) {
        model.addAttribute("users", redirectService.findUserInfo());
        return "redirect/listWithGoTo";
    }

    @RequestMapping(value = "listWithLinkInWhiteList", method = RequestMethod.GET)
    public String listWithLinkInWhiteList(Model model) {
        model.addAttribute("users", redirectService.findUserInfo());
        model.addAttribute("redirectionAllowedExternalUrl",
                redirectionAllowedExternalUrl);
        return "redirect/listWithLinkInWhiteList";
    }

    @RequestMapping(value = "listWithLinkNotInWhiteList", method = RequestMethod.GET)
    public String listWithLinkNotInWhiteList(Model model) {
        model.addAttribute("users", redirectService.findUserInfo());
        return "redirect/listWithLinkNotInWhiteList";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(Principal principal, DetailForm form, Model model) {
        UserInfo user = redirectService.findOne(principal.getName());
        form.setName(user.getName());
        form.setAddress(user.getAddress());
        model.addAttribute(form);
        return "redirect/detail";
    }

}
