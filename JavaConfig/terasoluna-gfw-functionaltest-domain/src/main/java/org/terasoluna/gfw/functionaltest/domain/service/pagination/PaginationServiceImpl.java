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
package org.terasoluna.gfw.functionaltest.domain.service.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.terasoluna.gfw.functionaltest.domain.model.Person;
import org.terasoluna.gfw.functionaltest.domain.repository.person.PersonRepository;

import jakarta.inject.Inject;

@Service
public class PaginationServiceImpl implements PaginationService {

    @Inject
    protected PersonRepository personRepostiroy;

    @Override
    public Page<Person> findPerson(Pageable pageable) {
        return personRepostiroy.findAll(pageable);
    }

    public Page<Person> findPersonByName(String name, Pageable pageable) {
        return personRepostiroy.findPageByName(name, pageable);
    }

}
