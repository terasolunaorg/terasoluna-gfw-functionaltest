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

import java.util.List;

public class BatchUpdateUserForm2 {
    private List<UpdateUserCriteriaForm2> criteria;

    private LogicalOperator2 operator;

    public BatchUpdateUserForm2(List<UpdateUserCriteriaForm2> criteria,
            LogicalOperator2 operator) {
        this.criteria = criteria;
        this.operator = operator;
    }

    public BatchUpdateUserForm2() {
    }

    public List<UpdateUserCriteriaForm2> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<UpdateUserCriteriaForm2> criteria) {
        this.criteria = criteria;
    }

    public LogicalOperator2 getOperator() {
        return operator;
    }

    public void setOperator(LogicalOperator2 operator) {
        this.operator = operator;
    }
}
