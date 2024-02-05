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
package org.terasoluna.gfw.functionaltest.app.el;

import java.util.List;

public class SearchAndBatchUpdateUserForm3 {
    private SearchUserCriteriaForm3 criteria;

    private List<User3> users;

    public SearchAndBatchUpdateUserForm3(SearchUserCriteriaForm3 criteria,
            List<User3> users) {
        this.criteria = criteria;
        this.users = users;
    }

    public SearchAndBatchUpdateUserForm3() {
    }

    public SearchUserCriteriaForm3 getCriteria() {
        return criteria;
    }

    public void setCriteria(SearchUserCriteriaForm3 criteria) {
        this.criteria = criteria;
    }

    public List<User3> getUsers() {
        return users;
    }

    public void setUsers(List<User3> users) {
        this.users = users;
    }
}
