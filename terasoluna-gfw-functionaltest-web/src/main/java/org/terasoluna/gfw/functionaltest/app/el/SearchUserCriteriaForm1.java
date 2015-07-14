package org.terasoluna.gfw.functionaltest.app.el;

public class SearchUserCriteriaForm1 {
    private String name;

    private Integer age;

    public SearchUserCriteriaForm1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public SearchUserCriteriaForm1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
