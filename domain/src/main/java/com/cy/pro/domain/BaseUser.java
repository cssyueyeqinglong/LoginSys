package com.cy.pro.domain;

import java.io.Serializable;
import java.util.Date;

public class BaseUser implements Serializable {
    protected String create_by;
    protected String create_dept;
    protected Date create_time;
    protected String update_by;
    protected Date update_time;

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getCreate_dept() {
        return create_dept;
    }

    public void setCreate_dept(String create_dept) {
        this.create_dept = create_dept;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

}
