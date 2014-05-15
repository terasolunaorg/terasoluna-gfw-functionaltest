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
package org.terasoluna.gfw.functionaltest.infra.repository.queryescape;

import java.util.List;

import javax.inject.Inject;

import jp.terasoluna.fw.dao.QueryDAO;

import org.springframework.stereotype.Repository;
import org.terasoluna.gfw.functionaltest.domain.model.Todo;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.TodoMybatisRepository;

@Repository
public class TodoMybatis2RepositoryImpl implements TodoMybatisRepository {

    @Inject
    protected QueryDAO queryDAO;

    @Override
    public List<Todo> findAllByTitleLike(String todoTitle) {
        return queryDAO.executeForObjectList("queryescape.findAllByTitleLike", todoTitle);
    }

}
