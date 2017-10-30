package com.cy.pro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role extends BaseUser implements Serializable {
    /*ROLE_ID              VARCHAR2(40)                    not null,
   NAME                 VARCHAR2(30),
   REMARK               VARCHAR2(200),
   ORDER_NO             INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   UPDATE_BY            VARCHAR2(40),
   UPDATE_TIME          TIMESTAMP,
   constraint PK_ROLE_P primary key (ROLE_ID)*/
    private String id;
    private String name;
    private String remark;
    private String order_no;
    private Set<User> users = new HashSet<>();
    private Set<Module> modules=new HashSet<>(0);

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }
}
