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
package org.terasoluna.gfw.functionaltest.app.el;

public class SearchUserForm1 {
    private SearchUserCriteriaForm1 criteria;

    private boolean rememberCriteria;

    public SearchUserForm1(SearchUserCriteriaForm1 criteria,
            boolean rememberCriteria) {
        this.criteria = criteria;
        this.rememberCriteria = rememberCriteria;
    }

    public SearchUserForm1() {
    }

    public SearchUserCriteriaForm1 getCriteria() {
        return criteria;
    }

    public void setCriteria(SearchUserCriteriaForm1 criteria) {
        this.criteria = criteria;
    }

    public boolean isRememberCriteria() {
        return rememberCriteria;
    }

    public void setRememberCriteria(boolean rememberCriteria) {
        this.rememberCriteria = rememberCriteria;
    }
}
