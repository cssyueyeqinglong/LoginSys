package com.cy.pro.domain;

import java.io.Serializable;

public class ExtEproduct implements Serializable {
    /*EXT_EPRODUCT_ID      varchar2(40)                    not null,
   factory_id           varchar2(40),
   export_product_id    varchar2(40),
   product_no           varchar2(50),
   product_image        varchar2(200),
   product_desc         varchar2(600),
   cnumber              int,
   packing_unit         varchar2(10),
   price                number(10,2),
   amount               number(10,2),
   product_request      varchar2(2000),
   order_no             int,*/
    private String id;
    private String product_no;
    private String product_image;
    private String product_desc;
    private String cnumber;
    private String product_request;

    private String packing_unit;
    private String price;
    private String amount;
    private String order_no;
    private Factory factory;
    private ExportProduct ep;


    public String getProduct_request() {
        return product_request;
    }

    public void setProduct_request(String product_request) {
        this.product_request = product_request;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getPacking_unit() {
        return packing_unit;
    }

    public void setPacking_unit(String packing_unit) {
        this.packing_unit = packing_unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public ExportProduct getEp() {
        return ep;
    }

    public void setEp(ExportProduct ep) {
        this.ep = ep;
    }
}
