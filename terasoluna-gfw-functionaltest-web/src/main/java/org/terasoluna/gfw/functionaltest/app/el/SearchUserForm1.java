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
