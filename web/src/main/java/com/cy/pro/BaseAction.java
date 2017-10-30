package com.cy.pro;

import java.util.Map;

import com.cy.pro.domain.User;
import com.cy.pro.utils.SysConstant;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description:
 * @Author: 传智播客 java学院	传智.宋江
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月31日
 */

//通过RequestAware, SessionAware, ApplicationAware实行接口获得request,session,application对象，action中就可直接调用

public class BaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {
    private static Logger log = Logger.getLogger(BaseAction.class);

    private static final long serialVersionUID = 1L;

    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;

    public User getUser() {
        user=(User) session.get(SysConstant.CURRENT_USER_INFO);
        return user;
    }


    private User user;

    public Map<String, Object> getRequest() {
        return request;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Map<String, Object> getApplication() {
        return application;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    public void setVs(String key, Object value) {
        ActionContext.getContext().put(key, value);
    }

    public void pushVs(Object value) {
        ActionContext.getContext().getValueStack().push(value);
    }
}