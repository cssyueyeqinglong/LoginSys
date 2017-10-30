package com.cy.pro.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Contract extends BaseUser implements Serializable {
    /*contract_id          varchar2(40)                    not null,
   offeror              varchar2(200),
   contract_no          varchar2(50),
   signing_date         datetime,
   input_by             varchar2(30),
   check_by             varchar2(30),
   inspector            varchar2(30),
   total_amount         number(10,2),
   crequest             varchar2(2000),
   custom_name          varchar2(200),
   ship_time            timestamp,
   import_num           int,
   delivery_period      timestamp,
   old_state            int,
   out_state            int,
   trade_terms          varchar2(30),
   print_style          char(1),
   remark               varchar2(600),
   state                int,
   create_by            varchar2(40),
   create_dept          varchar2(40),
   create_time          timestamp,
   update_by            varchar2(40),
   update_time          TIMESTAMP,*/
    private String id;
    private String offeror;
    private String contract_no;
    private Date signing_date;
    private String input_by;
    private String check_by;
    private String inspector;
    private Double total_amount;
    private String crequest;
    private String custom_name;
    private Date ship_time;
    private Integer import_num;
    private Date delivery_period;
    private Integer old_state;
    private Integer out_state;
    private String trade_terms;
    private String print_style;
    private String remark;
    private Integer state;
    private Set<ContractProduct> cps=new HashSet<>(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfferor() {
        return offeror;
    }

    public void setOfferor(String offeror) {
        this.offeror = offeror;
    }

    public String getContract_no() {
        return contract_no;
    }

    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    public Date getSigning_date() {
        return signing_date;
    }

    public void setSigning_date(Date signing_date) {
        this.signing_date = signing_date;
    }

    public String getInput_by() {
        return input_by;
    }

    public void setInput_by(String input_by) {
        this.input_by = input_by;
    }

    public String getCheck_by() {
        return check_by;
    }

    public void setCheck_by(String check_by) {
        this.check_by = check_by;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getCrequest() {
        return crequest;
    }

    public void setCrequest(String crequest) {
        this.crequest = crequest;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }

    public Date getShip_time() {
        return ship_time;
    }

    public void setShip_time(Date ship_time) {
        this.ship_time = ship_time;
    }

    public Integer getImport_num() {
        return import_num;
    }

    public void setImport_num(Integer import_num) {
        this.import_num = import_num;
    }

    public Date getDelivery_period() {
        return delivery_period;
    }

    public void setDelivery_period(Date delivery_period) {
        this.delivery_period = delivery_period;
    }

    public Integer getOld_state() {
        return old_state;
    }

    public void setOld_state(Integer old_state) {
        this.old_state = old_state;
    }

    public Integer getOut_state() {
        return out_state;
    }

    public void setOut_state(Integer out_state) {
        this.out_state = out_state;
    }

    public String getTrade_terms() {
        return trade_terms;
    }

    public void setTrade_terms(String trade_terms) {
        this.trade_terms = trade_terms;
    }

    public String getPrint_style() {
        return print_style;
    }

    public void setPrint_style(String print_style) {
        this.print_style = print_style;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set<ContractProduct> getCps() {
        return cps;
    }

    public void setCps(Set<ContractProduct> cps) {
        this.cps = cps;
    }
}
