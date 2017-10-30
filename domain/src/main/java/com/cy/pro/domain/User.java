package com.cy.pro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User extends BaseUser implements Serializable {
    /* USER_ID              VARCHAR2(40)                    not null,
   DEPT_ID              VARCHAR2(40),
   USER_NAME            VARCHAR2(50),
   PASSWORD             VARCHAR2(64),
   STATE                INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   UPDATE_BY            VARCHAR2(40),
   UPDATE_TIME          TIMESTAMP,
   constraint PK_USER_P primary key (USER_ID)*/
    private String id;
    //        public String dept_id;
    private String user_name;
    private String password;
    private Integer state;
    private UserInfo userInfo;//用户与扩展信息
    private Dept dept;
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
