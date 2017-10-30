package com.cy.pro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ContractProduct implements Serializable {
    /*contract_product_id  varchar2(40)                    not null,
   contract_id          varchar2(40),
   factory_id           varchar2(40),
   factory_name         varchar2(200),
   product_no           varchar2(50),
   product_image        varchar2(200),
   product_desc         varchar2(600),
   loading_rate         varchar2(30),
   box_num              int,
   packing_unit         varchar2(10),
   cnumber              int,
   out_number           int,
   finished             int,
   product_request      varchar2(2000),
   price                number(10,2),
   amount               number(10,2),
   order_no             int,*/
    private String id;
    private String contract_id;
    private String factory_id;
    private String factory_name;
    private String product_no;
    private String product_image;
    private String product_desc;
    private String loading_rate;
    private Integer box_num;
    private String packing_unit;
    private Integer cnumber;
    private Integer out_number;
    private Integer finished;
    private String product_request;
    private Double price;
    private Double amount;
    private Integer order_no;
    private Contract contract;
    private Factory factory;
    private Set<ExtCproduct> extCproducts=new HashSet<>(0);

    public Set<ExtCproduct> getExtCproducts() {
        return extCproducts;
    }

    public void setExtCproducts(Set<ExtCproduct> extCproducts) {
        this.extCproducts = extCproducts;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(String factory_id) {
        this.factory_id = factory_id;
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

    public String getLoading_rate() {
        return loading_rate;
    }

    public void setLoading_rate(String loading_rate) {
        this.loading_rate = loading_rate;
    }

    public Integer getBox_num() {
        return box_num;
    }

    public void setBox_num(Integer box_num) {
        this.box_num = box_num;
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

    public Integer getOut_number() {
        return out_number;
    }

    public void setOut_number(Integer out_number) {
        this.out_number = out_number;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getProduct_request() {
        return product_request;
    }

    public void setProduct_request(String product_request) {
        this.product_request = product_request;
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

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
