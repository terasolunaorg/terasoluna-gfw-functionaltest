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
package org.terasoluna.gfw.functionaltest.domain.service.codelist;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.codelist.ReloadableCodeList;
import org.terasoluna.gfw.functionaltest.domain.TransactionManagers;
import org.terasoluna.gfw.functionaltest.domain.model.ItemCode;
import org.terasoluna.gfw.functionaltest.domain.repository.codelist.CodeListRepository;

@Service
@Transactional(value = TransactionManagers.JPA)
public class CodeListServiceImpl implements CodeListService {

    @Inject
    protected CodeListRepository codeListRepository;

    @Inject
    @Named(value = "CL_CODELIST_ITEM1")
    protected ReloadableCodeList clCodeListItem1;

    @Override
    @Transactional(value = TransactionManagers.JPA, readOnly = true)
    public List<ItemCode> findCodeList() {
        return codeListRepository.findAll();
    }

    @Override
    public ItemCode findOne(Integer code) {
        return codeListRepository.findById(code).orElse(null);
    }

    @Override
    public ItemCode save(ItemCode row) {
        return codeListRepository.save(row);
    }

    @Override
    public void refresh() {
        clCodeListItem1.refresh();
    }
}
