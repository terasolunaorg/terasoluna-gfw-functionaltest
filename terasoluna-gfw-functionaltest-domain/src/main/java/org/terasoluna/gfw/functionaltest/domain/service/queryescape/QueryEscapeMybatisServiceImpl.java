/*
 * Copyright (C) 2013-2014 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.domain.service.queryescape;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.query.QueryEscapeUtils;
import org.terasoluna.gfw.functionaltest.domain.TransactionManagers;
import org.terasoluna.gfw.functionaltest.domain.model.Todo;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.TodoMybatisRepository;

@Transactional(value = TransactionManagers.DATASOURCE, readOnly = true)
@Service("queryEscapeMybatisService")
public class QueryEscapeMybatisServiceImpl implements QueryEscapeService {

    @Inject
    TodoMybatisRepository queryEscapeMybatisRepository;

    @Override
    public List<Todo> findAllByTitleLikePrefix(String title) {
        String condition = QueryEscapeUtils.toStartingWithCondition(title);
        return queryEscapeMybatisRepository.findAllByTitleLike(condition);
    }

    @Override
    public List<Todo> findAllByTitleLikeSuffix(String title) {
        String condition = QueryEscapeUtils.toEndingWithCondition(title);
        return queryEscapeMybatisRepository.findAllByTitleLike(condition);
    }

    @Override
    public List<Todo> findAllByTitleLikePartical(String title) {
        String condition = QueryEscapeUtils.toContainingCondition(title);
        return queryEscapeMybatisRepository.findAllByTitleLike(condition);
    }
}
