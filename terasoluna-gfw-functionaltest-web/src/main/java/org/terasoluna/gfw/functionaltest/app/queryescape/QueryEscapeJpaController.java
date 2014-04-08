/*
 * Copyright (C) 2013 terasoluna.org
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

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.functionaltest.domain.model.Todo;
import org.terasoluna.gfw.functionaltest.domain.service.queryescape.QueryEscapeService;

@Controller
@RequestMapping("queryescape/JPA")
public class QueryEscapeJpaController {

    @Inject
    @Named("queryEscapeJpaService")
    protected QueryEscapeService queryEscapeService;

    @ModelAttribute
    public TodoForm setUpForm() {
        TodoForm form = new TodoForm();
        return form;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("targetORMapper", "JPA");
        return "queryescape/todoList";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, params = "prefix")
    public String searchWithPrefixUsingJpa_04_XX(TodoForm form, Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikePrefix(form
                .getTodoTitle());

        model.addAttribute("targetORMapper", "JPA");
        model.addAttribute("searchPattern", "prefix search");
        model.addAttribute("hitNumber", list.size());
        model.addAttribute("todoList", list);
        return "queryescape/todoList";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, params = "suffix")
    public String searchWithSuffixUsingJpa_05_XX(TodoForm form, Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikeSuffix(form
                .getTodoTitle());

        model.addAttribute("targetORMapper", "JPA");
        model.addAttribute("searchPattern", "suffix search");
        model.addAttribute("hitNumber", list.size());
        model.addAttribute("todoList", list);
        return "queryescape/todoList";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, params = "partical")
    public String searchWithParticalUsingJpa_06_XX(TodoForm form, Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikePartical(form
                .getTodoTitle());

        model.addAttribute("targetORMapper", "JPA");
        model.addAttribute("searchPattern", "partical search");
        model.addAttribute("hitNumber", list.size());
        model.addAttribute("todoList", list);
        return "queryescape/todoList";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, params = "nullTodoTitle")
    public String searchWithPrefixUsingJpa_XX_YY(Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikePrefix(null);

        model.addAttribute("targetORMapper", "JPA");
        model.addAttribute("searchPattern", "null todo title search");
        model.addAttribute("hitNumber", list.size());
        model.addAttribute("todoList", list);
        return "queryescape/todoList";
    }
}
