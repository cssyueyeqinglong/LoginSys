package com.cy.pro;

public class SysException extends Exception {
    private String msg;

    public SysException(String message) {
        this.msg = message;
    }

    public String getMsg() {
        return this.msg;
    }
}
