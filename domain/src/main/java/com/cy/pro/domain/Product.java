package com.cy.pro.domain;

import java.io.Serializable;
import java.util.Date;

public class Product extends BaseUser implements Serializable{
    /*product_id           varchar(40)                     not null,
   product_no           varchar(40),
   product_image        varchar(200),
   description          varchar(200),
   factory_id           varchar(40),
   factory_name         varchar(250),
   price                numeric(10,3),
   size_lenght          numeric(10,3),
   size_width           numeric(10,3),
   size_height          numeric(10,3),
   color                varchar(200),
   packing              varchar(20),
   packing_unit         varchar(10),
   type20               numeric(10,3),
   type40               numeric(10,3),
   type40hc             numeric(10,3),
   qty                  int,
   cbm                  numeric(10,3),
   mpsize_lenght        numeric(10,3),
   mpsize_width         numeric(10,3),
   mpsize_height        numeric(10,3),
   remark               varchar(500),
   input_time           datetime,
   create_by            varchar(40),
   create_dept          varchar(40),
   create_time          datetime,*/
    private String id;
    private String product_no;
    private String product_image;
    private String description;
    private String factory_id;
    private String factory_name;
    private Double price;
    private Double size_lenght;
    private Double size_width;
    private Double size_height;
    private String color;
    private String packing;
    private String packing_unit;
    private Double type20;
    private Double type40;
    private Double type40hc;
    private Integer qty;
    private Double cbm;
    private Double mpsize_lenght;
    private Double mpsize_width;
    private Double mpsize_height;
    private String remark;
    private Date input_time;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize_lenght() {
        return size_lenght;
    }

    public void setSize_lenght(Double size_lenght) {
        this.size_lenght = size_lenght;
    }

    public Double getSize_width() {
        return size_width;
    }

    public void setSize_width(Double size_width) {
        this.size_width = size_width;
    }

    public Double getSize_height() {
        return size_height;
    }

    public void setSize_height(Double size_height) {
        this.size_height = size_height;
    }

    public Double getType20() {
        return type20;
    }

    public void setType20(Double type20) {
        this.type20 = type20;
    }

    public Double getType40() {
        return type40;
    }

    public void setType40(Double type40) {
        this.type40 = type40;
    }

    public Double getType40hc() {
        return type40hc;
    }

    public void setType40hc(Double type40hc) {
        this.type40hc = type40hc;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getCbm() {
        return cbm;
    }

    public void setCbm(Double cbm) {
        this.cbm = cbm;
    }

    public Double getMpsize_lenght() {
        return mpsize_lenght;
    }

    public void setMpsize_lenght(Double mpsize_lenght) {
        this.mpsize_lenght = mpsize_lenght;
    }

    public Double getMpsize_width() {
        return mpsize_width;
    }

    public void setMpsize_width(Double mpsize_width) {
        this.mpsize_width = mpsize_width;
    }

    public Double getMpsize_height() {
        return mpsize_height;
    }

    public void setMpsize_height(Double mpsize_height) {
        this.mpsize_height = mpsize_height;
    }

    public Date getInput_time() {
        return input_time;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getPacking_unit() {
        return packing_unit;
    }

    public void setPacking_unit(String packing_unit) {
        this.packing_unit = packing_unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
