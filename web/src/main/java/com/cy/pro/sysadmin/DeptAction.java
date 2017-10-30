package com.cy.pro.sysadmin;

import com.cy.pro.BaseAction;
import com.cy.pro.domain.Dept;
import com.cy.pro.service.DeptService;
import com.cy.pro.utils.Page;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class DeptAction extends BaseAction implements ModelDriven<Dept> {

    private Dept dept = new Dept();

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    private DeptService deptService;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    private Page page = new Page();

    @Override
    public Dept getModel() {
        return dept;
    }


    public String list() throws Exception {
        deptService.findPage("from Dept", page, Dept.class, null);
        page.setUrl("deptAction_list");
        pushVs(page);
        return "dept_list";
    }

    public String toview() {
        dept = (Dept) deptService.get(Dept.class, dept.getId());
        pushVs(dept);
        return "dept_toView";
    }

    public String tocreate() {
        List<Dept> depts = deptService.find("from Dept where state=1", Dept.class, null);
        setVs("depts", depts);
        return "tocreate";
    }

    public String insert() {
        deptService.saveOrUpdate(dept);
        return "insertsucceed";
    }

    public String toupdate() {
        dept = deptService.get(Dept.class, dept.getId());
        pushVs(dept);
        List<Dept> depts = deptService.find("from Dept where state=1", Dept.class, null);
        setVs("depts", depts);
        return "updatedept";
    }

    public String update() {
        Dept d = deptService.get(Dept.class, dept.getId());//先查询数据库中的当前条值，然后将要修改的值提交上去
        d.setDept_name(dept.getDept_name());
        d.setParent(dept.getParent());
        deptService.saveOrUpdate(d);
        return "insertsucceed";
    }

    public String delete() {
        String ids = dept.getId();
        deptService.delete(Dept.class, ids.split(","));
        return "insertsucceed";
    }

}
