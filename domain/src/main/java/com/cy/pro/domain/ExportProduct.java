package com.cy.pro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ExportProduct implements Serializable {
    /*export_product_id    varchar2(40)                    not null,
   export_id            varchar2(40),
   factory_id           varchar2(40),
   product_no           varchar2(50),
   packing_unit         varchar2(10),
   cnumber              int,
   box_num              int,
   gross_weight         number(10,2),
   net_weight           number(10,2),
   size_length          number(10,2),
   size_width           number(10,2),
   size_height          number(10,2),
   ex_price             number(10,2),
   price                number(10,2),
   tax                  number(10,2),
   order_no             int,*/
    private String id;
    private Export export;
    private Factory factory;
    private String product_no;
    private String packing_unit;
    private Integer cnumber;
    private Integer box_num;
    private Double gross_weight;
    private Double net_weight;
    private Double size_length;
    private Double size_width;
    private Double size_height;
    private Double ex_price;
    private Double price;
    private Double tax;
    private Integer order_no;
    private Set<ExtEproduct> extEproducts=new HashSet<>();

    public Set<ExtEproduct> getExtEproducts() {
        return extEproducts;
    }

    public void setExtEproducts(Set<ExtEproduct> extEproducts) {
        this.extEproducts = extEproducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Export getExport() {
        return export;
    }

    public void setExport(Export export) {
        this.export = export;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
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

    public Integer getBox_num() {
        return box_num;
    }

    public void setBox_num(Integer box_num) {
        this.box_num = box_num;
    }

    public Double getGross_weight() {
        return gross_weight;
    }

    public void setGross_weight(Double gross_weight) {
        this.gross_weight = gross_weight;
    }

    public Double getNet_weight() {
        return net_weight;
    }

    public void setNet_weight(Double net_weight) {
        this.net_weight = net_weight;
    }

    public Double getSize_length() {
        return size_length;
    }

    public void setSize_length(Double size_length) {
        this.size_length = size_length;
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

    public Double getEx_price() {
        return ex_price;
    }

    public void setEx_price(Double ex_price) {
        this.ex_price = ex_price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }
}
