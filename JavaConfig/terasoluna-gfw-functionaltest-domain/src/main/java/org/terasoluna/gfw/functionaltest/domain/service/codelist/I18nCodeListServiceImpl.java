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
package org.terasoluna.gfw.functionaltest.domain.service.codelist;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.codelist.ReloadableCodeList;
import org.terasoluna.gfw.common.codelist.i18n.ReloadableI18nCodeList;
import org.terasoluna.gfw.functionaltest.domain.TransactionManagers;
import org.terasoluna.gfw.functionaltest.domain.model.I18nItemCode;
import org.terasoluna.gfw.functionaltest.domain.repository.codelist.I18nCodeListRepository;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Service
@Transactional(value = TransactionManagers.JPA)
public class I18nCodeListServiceImpl implements I18nCodeListService {

    @Inject
    protected I18nCodeListRepository i18nCodeListRepository;

    @Inject
    @Named(value = "CL_CODELIST12_01")
    protected ReloadableI18nCodeList reloadableI18nCodeList;

    @Inject
    @Named(value = "CL_CODELIST_ITEM3_EN")
    protected ReloadableCodeList enCodeList;

    @Inject
    @Named(value = "CL_CODELIST_ITEM3_JA")
    protected ReloadableCodeList jaCodeList;

    @Override
    @Transactional(value = TransactionManagers.JPA, readOnly = true)
    public List<I18nItemCode> findAll() {
        return i18nCodeListRepository.findAll(Sort.by("code"));
    }

    @Override
    public I18nItemCode findOne(Integer id) {
        return i18nCodeListRepository.findById(id).orElse(null);
    }

    @Override
    public I18nItemCode save(I18nItemCode row) {
        return i18nCodeListRepository.save(row);
    }

    @Override
    public void refresh() {
        reloadableI18nCodeList.refresh();
    }

    @Override
    public void refresh(boolean recursive) {
        reloadableI18nCodeList.refresh(recursive);
    }

    @Override
    public void refreshAll() {
        enCodeList.refresh();
        jaCodeList.refresh();
        reloadableI18nCodeList.refresh(false);
    }
}
