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

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.functionaltest.domain.model.Todo;
import org.terasoluna.gfw.functionaltest.domain.service.queryescape.QueryEscapeService;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Controller
@RequestMapping("queryescape/JPA")
public class QueryEscapeJpaController {

    @Inject
    @Named("queryEscapeJpaService")
    QueryEscapeService queryEscapeService;

    @Inject
    QueryEscapeHelper queryEscapeHelper;

    @ModelAttribute
    public TodoForm setUpForm() {
        TodoForm form = new TodoForm();
        return form;
    }

    @ModelAttribute("targetORMapper")
    public String setUpTargetORMapper() {
        return "JPA";
    }

    @GetMapping
    public String index(Model model) {
        return "queryescape/todoList";
    }

    @GetMapping(value = "search", params = "prefix")
    public String searchWithPrefix_04_XX(TodoForm form, Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikePrefix(form.getTodoTitle());

        queryEscapeHelper.bindToModel("prefix search", list, model);

        return "queryescape/todoList";
    }

    @GetMapping(value = "search", params = "suffix")
    public String searchWithSuffix_05_XX(TodoForm form, Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikeSuffix(form.getTodoTitle());

        queryEscapeHelper.bindToModel("suffix search", list, model);

        return "queryescape/todoList";
    }

    @GetMapping(value = "search", params = "partical")
    public String searchWithPartical_06_XX(TodoForm form, Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikePartical(form.getTodoTitle());

        queryEscapeHelper.bindToModel("partical search", list, model);

        return "queryescape/todoList";
    }

    @GetMapping(value = "search", params = "nullTodoTitle")
    public String searchWithPrefix_XX_YY(Model model) {

        List<Todo> list = queryEscapeService.findAllByTitleLikePrefix(null);

        queryEscapeHelper.bindToModel("null todo title search", list, model);

        return "queryescape/todoList";
    }
}
