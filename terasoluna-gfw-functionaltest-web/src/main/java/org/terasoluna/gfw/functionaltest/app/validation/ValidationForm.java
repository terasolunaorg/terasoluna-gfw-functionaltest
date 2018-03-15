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
package org.terasoluna.gfw.functionaltest.app.validation;

import java.io.Serializable;

import org.terasoluna.gfw.common.validator.constraints.ByteMax;
import org.terasoluna.gfw.common.validator.constraints.ByteMin;
import org.terasoluna.gfw.common.validator.constraints.Compare;

/**
 * Validation form object.
 */
@Compare.List({
        @Compare(left = "left", right = "right", operator = Compare.Operator.EQUAL, requireBoth = true, node = Compare.Node.PROPERTY, groups = {
                ValidationForm.ValidateCompare.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.EQUAL, groups = {
                ValidationForm.ValidateCompareOperatorEqual.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.NOT_EQUAL, groups = {
                ValidationForm.ValidateCompareOperatorNotEqual.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.GREATER_THAN, groups = {
                ValidationForm.ValidateCompareOperatorGreaterThan.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.GREATER_THAN_OR_EQUAL, groups = {
                ValidationForm.ValidateCompareOperatorGreaterThanOrEqual.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.LESS_THAN, groups = {
                ValidationForm.ValidateCompareOperatorLessThan.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.LESS_THAN_OR_EQUAL, groups = {
                ValidationForm.ValidateCompareOperatorLessThanOrEqual.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.EQUAL, node = Compare.Node.PROPERTY, groups = {
                ValidationForm.ValidateCompareNodeProperty.class }),
        @Compare(left = "left", right = "right", operator = Compare.Operator.EQUAL, node = Compare.Node.ROOT_BEAN, groups = {
                ValidationForm.ValidateCompareNodeRootBean.class }),

})
public class ValidationForm implements Serializable {
    private static final long serialVersionUID = 1L;

    static interface ValidateByteMin {
    };

    static interface ValidateByteMax {
    };

    static interface ValidateCompare {
    };

    static interface ValidateCompareOperatorEqual {
    };

    static interface ValidateCompareOperatorNotEqual {
    };

    static interface ValidateCompareOperatorGreaterThan {
    };

    static interface ValidateCompareOperatorGreaterThanOrEqual {
    };

    static interface ValidateCompareOperatorLessThan {
    };

    static interface ValidateCompareOperatorLessThanOrEqual {
    };

    static interface ValidateCompareNodeProperty {
    };

    static interface ValidateCompareNodeRootBean {
    };

    @ByteMin(value = 6, charset = "Shift_JIS", groups = {
            ValidateByteMin.class })
    @ByteMax(value = 6, charset = "Shift_JIS", groups = {
            ValidateByteMax.class })
    private String userName;

    private Integer left;

    private Integer right;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLeft() {
        return this.left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return this.right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

}
