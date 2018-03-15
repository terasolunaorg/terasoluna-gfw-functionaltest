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
package org.terasoluna.gfw.functionaltest.domain.repository.queryescape;

import java.util.List;

import org.terasoluna.gfw.functionaltest.domain.model.Todo;

public interface TodoMybatisRepository {

    List<Todo> findAllByTitleLikePrefix(String todoTitle);

    List<Todo> findAllByTitleLikeSuffix(String todoTitle);

    List<Todo> findAllByTitleLikePartical(String todoTitle);

    List<Todo> findAllByTitleLikePrefixEscapingFullWidthWildCard(
            String todoTitle);

    List<Todo> findAllByTitleLikeSuffixEscapingFullWidthWildCard(
            String todoTitle);

    List<Todo> findAllByTitleLikeParticalEscapingFullWidthWildCard(
            String todoTitle);
}
