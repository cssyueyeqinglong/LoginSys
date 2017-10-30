package com.cy.pro.domain;

import java.io.Serializable;

public class ExtCproduct implements Serializable {
    /*EXT_CPRODUCT_ID      varchar2(40)                    not null,
   contract_product_id  varchar2(40),
   factory_id           varchar2(40),
   factory_name         varchar2(200),
   product_no           varchar2(50),
   product_image        varchar2(200),
   product_desc         varchar2(600),
   packing_unit         varchar2(10),
   cnumber              int,
   price                number(10,2),
   amount               number(10,2),
   product_request      varchar2(2000),
   order_no             int,*/
    private String id;
    private String factory_name;
    private String product_no;
    private String product_image;
    private String product_desc;
    private String packing_unit;
    private Integer cnumber;
    private Double price;
    private Double amount;
    private String product_request;
    private Integer order_no;
    private ContractProduct cp;
    private Factory factory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getPacking_unit() {
        return packing_unit;
    }

    public void setPacking_unit(String packing_unit) {
        this.packing_unit = packing_unit;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProduct_request() {
        return product_request;
    }

    public void setProduct_request(String product_request) {
        this.product_request = product_request;
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    public ContractProduct getCp() {
        return cp;
    }

    public void setCp(ContractProduct cp) {
        this.cp = cp;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
