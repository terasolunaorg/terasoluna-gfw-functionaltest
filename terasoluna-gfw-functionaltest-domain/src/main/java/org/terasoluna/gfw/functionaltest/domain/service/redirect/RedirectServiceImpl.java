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
package org.terasoluna.gfw.functionaltest.domain.service.redirect;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.functionaltest.domain.TransactionManagers;
import org.terasoluna.gfw.functionaltest.domain.model.UserInfo;
import org.terasoluna.gfw.functionaltest.domain.repository.user.UserRepository;

@Service
@Transactional(value = TransactionManagers.JPA)
public class RedirectServiceImpl implements RedirectService {

    @Inject
    protected UserRepository userRepository;

    @Override
    @Transactional(value = TransactionManagers.JPA, readOnly = true)
    public List<UserInfo> findUserInfo() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(value = TransactionManagers.JPA, readOnly = true)
    public UserInfo findOne(String code) {
        return userRepository.findById(code).orElse(null);
    }

    @Override
    public UserInfo save(UserInfo row) {
        return userRepository.save(row);
    }

}
