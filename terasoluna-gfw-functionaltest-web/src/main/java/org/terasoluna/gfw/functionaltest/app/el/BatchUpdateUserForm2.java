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
