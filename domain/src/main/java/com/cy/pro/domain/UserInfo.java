package com.cy.pro.domain;

import java.io.Serializable;
import java.util.Date;

public class UserInfo extends BaseUser implements Serializable {
    /*USER_INFO_ID         VARCHAR2(40)                    not null,
   NAME                 VARCHAR2(20),
   MANAGER_ID           VARCHAR2(40),
   JOIN_DATE            TIMESTAMP,
   SALARY               NUMERIC(8, 2),
   BIRTHDAY             TIMESTAMP,
   GENDER               CHAR(1),
   STATION              VARCHAR2(20),
   TELEPHONE            VARCHAR2(100),
   DEGREE               INT,
   REMARK               VARCHAR2(600),
   ORDER_NO             INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   UPDATE_BY            VARCHAR2(40),
   UPDATE_TIME          TIMESTAMP,
   constraint PK_USER_INFO_P primary key (USER_INFO_ID)*/

    private String user_info_id;
    private String name;
//    private String manager_id;
    private Date join_date;
    private Double salary;
    private Date birthday;
    private String gender;
    private String station;
    private String telephone;
    private Integer degree;
    private String remark;
    private Integer order_no;
    private String email;
    private User manager;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(String user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
