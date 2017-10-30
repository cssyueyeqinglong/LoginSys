package com.cy.pro.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Export extends BaseUser implements Serializable {
    private String id;
    private Date input_date;
    private String contract_ids;
    private String customer_contract;
    private String lcno;
    private String consignee;
    private String marks;
    private String shipment_port;
    private String destination_port;
    private String transport_mode;
    private String price_condition;
    private String remark;
    private Integer box_nums;
    private Double gross_weights;
    private Double measurements;
    private Integer state;
    private Set<ExportProduct> eps = new HashSet<>();

    public Set<ExportProduct> getEps() {
        return eps;
    }

    public void setEps(Set<ExportProduct> eps) {
        this.eps = eps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInput_date() {
        return input_date;
    }

    public void setInput_date(Date input_date) {
        this.input_date = input_date;
    }

    public String getContract_ids() {
        return contract_ids;
    }

    public void setContract_ids(String contract_ids) {
        this.contract_ids = contract_ids;
    }

    public String getCustomer_contract() {
        return customer_contract;
    }

    public void setCustomer_contract(String customer_contract) {
        this.customer_contract = customer_contract;
    }

    public String getLcno() {
        return lcno;
    }

    public void setLcno(String lcno) {
        this.lcno = lcno;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getShipment_port() {
        return shipment_port;
    }

    public void setShipment_port(String shipment_port) {
        this.shipment_port = shipment_port;
    }

    public String getDestination_port() {
        return destination_port;
    }

    public void setDestination_port(String destination_port) {
        this.destination_port = destination_port;
    }

    public String getTransport_mode() {
        return transport_mode;
    }

    public void setTransport_mode(String transport_mode) {
        this.transport_mode = transport_mode;
    }

    public String getPrice_condition() {
        return price_condition;
    }

    public void setPrice_condition(String price_condition) {
        this.price_condition = price_condition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBox_nums() {
        return box_nums;
    }

    public void setBox_nums(Integer box_nums) {
        this.box_nums = box_nums;
    }

    public Double getGross_weights() {
        return gross_weights;
    }

    public void setGross_weights(Double gross_weights) {
        this.gross_weights = gross_weights;
    }

    public Double getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Double measurements) {
        this.measurements = measurements;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    /*export_id            varchar2(40)                    not null,
   input_date           datetime,
   contract_ids         varchar2(200),
   customer_contract    varchar2(200),
   lcno                 varchar2(10),
   consignee            varchar2(100),
   marks                varchar2(1000),
   shipment_port        varchar2(100),
   destination_port     varchar2(100),
   transport_mode       varchar2(10),
   price_condition      varchar2(10),
   remark               varchar2(100),
   box_nums             int,
   gross_weights        number(10,2),
   measurements         number(10,2),
   state                int,
   create_by            varchar2(40),
   create_dept          varchar2(40),
   create_time          datetime,*/
}
