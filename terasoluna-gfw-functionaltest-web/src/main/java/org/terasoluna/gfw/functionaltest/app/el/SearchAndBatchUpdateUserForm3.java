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
