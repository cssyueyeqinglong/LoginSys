package com.cy.pro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Factory extends BaseUser implements Serializable {
    /*FACTORY_ID           varchar2(40)                    not null,
   ctype                varchar2(10),
   full_name            varchar2(200),
   factory_name         varchar2(50),
   contacts             varchar2(30),
   phone                varchar2(20),
   mobile               varchar2(20),
   fax                  varchar2(20),
   address              varchar2(200),
   inspector            varchar2(30),
   remark               varchar2(2000),
   order_no             int,
   state                char(1),
   create_by            varchar2(40),
   create_dept          varchar2(40),
   create_time          timestamp,
   update_by            varchar2(40),
   update_time          timestamp,*/
    private String id;
    private String ctype;
    private String full_name;
    private String factory_name;
    private String contacts;
    private String phone;
    private String mobile;
    private String fax;
    private String address;
    private String inspector;
    private String remark;
    private Integer order_no;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
