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

import org.terasoluna.gfw.functionaltest.domain.model.I18nItemCode;

public interface I18nCodeListService {

    List<I18nItemCode> findAll();

    I18nItemCode findOne(Integer id);

    I18nItemCode save(I18nItemCode row);

    void refresh();

    void refresh(boolean recursive);

    void refreshAll();
}
