package com.cy.pro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable {

    /* Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
     DEPT_ID	DEPT_ID	varchar2(40)	40		TRUE	FALSE	TRUE
     部门名称	DEPT_NAME	varchar2(50)	50		FALSE	FALSE	FALSE
     PARENT_ID	PARENT_ID	varchar2(40)	40		FALSE	FALSE	FALSE
     状态	STATE	NUMBER(6,0)	6		FALSE	FALSE	FALSE*/
    private String id;
    private String dept_name;
    private Dept parent;
    private Integer state;
    private Set<User> users = new HashSet<>(0);

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
