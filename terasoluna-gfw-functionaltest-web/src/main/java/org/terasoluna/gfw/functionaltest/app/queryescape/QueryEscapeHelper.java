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

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.terasoluna.gfw.functionaltest.domain.model.Todo;

@Component
public class QueryEscapeHelper {

    public void bindToModel(String searchPattern, List<Todo> todoList,
            Model model) {
        model.addAttribute("searchPattern", searchPattern);
        model.addAttribute("hitNumber", todoList.size());
        model.addAttribute("todoList", todoList);
    }

}
