package com.cy.pro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Module extends BaseUser implements Serializable {

    private String id;
    private String parent_id;
    private String name;
    private String parent_name;
    private Integer layer_num;
    private Integer is_leaf;
    private String ico;
    private String cpermission;
    private String curl;
    private Integer ctype;
    private Integer state;
    private String belong;
    private String cwhich;
    private Integer quote_num;
    private String remark;
    private Integer order_no;
    private Set<Role> roles=new HashSet<>(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public Integer getLayer_num() {
        return layer_num;
    }

    public void setLayer_num(Integer layer_num) {
        this.layer_num = layer_num;
    }

    public Integer getIs_leaf() {
        return is_leaf;
    }

    public void setIs_leaf(Integer is_leaf) {
        this.is_leaf = is_leaf;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getCpermission() {
        return cpermission;
    }

    public void setCpermission(String cpermission) {
        this.cpermission = cpermission;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getCwhich() {
        return cwhich;
    }

    public void setCwhich(String cwhich) {
        this.cwhich = cwhich;
    }

    public Integer getQuote_num() {
        return quote_num;
    }

    public void setQuote_num(Integer quote_num) {
        this.quote_num = quote_num;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    /*MODULE_ID            VARCHAR2(40)                    not null,
   PARENT_ID            VARCHAR2(40),
   PARENT_NAME          VARCHAR2(100),
   NAME                 VARCHAR2(100),
   LAYER_NUM            INT,
   IS_LEAF              INT,
   ICO                  VARCHAR2(20),
   CPERMISSION          VARCHAR2(20),
   CURL                 VARCHAR2(200),
   CTYPE                INT,
   STATE                INT,
   BELONG               VARCHAR2(100),
   CWHICH               VARCHAR2(20),
   QUOTE_NUM            INT,
   REMARK               VARCHAR2(100),
   ORDER_NO             INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   UPDATE_BY            VARCHAR2(40),
   UPDATE_TIME          TIMESTAMP,*/
}
