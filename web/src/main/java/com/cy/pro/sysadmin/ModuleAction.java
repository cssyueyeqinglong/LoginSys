package com.cy.pro.sysadmin;

import com.cy.pro.BaseAction;
import com.cy.pro.domain.Module;
import com.cy.pro.domain.Role;
import com.cy.pro.service.ModuleService;
import com.cy.pro.utils.Page;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class ModuleAction extends BaseAction implements ModelDriven<Module> {

    private Module dept = new Module();

    public void setModuleService(ModuleService deptService) {
        this.moduleService = deptService;
    }

    private ModuleService moduleService;

    public void setUser(Module dept) {
        this.dept = dept;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    private Page page = new Page();

    @Override
    public Module getModel() {
        return dept;
    }


    public String list() throws Exception {
        moduleService.findPage("from Module", page, Module.class, null);
        page.setUrl("moduleAction_list");
        pushVs(page);
        return "dept_list";
    }

    public String toview() {
        dept = moduleService.get(Module.class, dept.getId());
        pushVs(dept);
        return "dept_toView";
    }

    public String tocreate() {
        return "tocreate";
    }

    public String insert() {
        moduleService.saveOrUpdate(dept);
        return "insertsucceed";
    }

    public String toupdate() {
        dept = moduleService.get(Module.class, dept.getId());
        pushVs(dept);
        List<Module> modules = moduleService.find("from Module where ctype=?", Module.class, new Integer[]{0});
        setVs("moduleList", modules);
        return "updatedept";
    }

    public String update() {
        Module d = moduleService.get(Module.class, dept.getId());//先查询数据库中的当前条值，然后将要修改的值提交上去
        d.setName(dept.getName());
        d.setLayer_num(dept.getLayer_num());
        d.setCpermission(dept.getCpermission());
        d.setCurl(dept.getCurl());
        d.setCtype(dept.getCtype());
        d.setState(dept.getState());
        d.setBelong(dept.getBelong());
        d.setCwhich(dept.getCwhich());
        d.setRemark(dept.getRemark());
        d.setParent_id(dept.getParent_id());

        d.setOrder_no(dept.getOrder_no());
        moduleService.saveOrUpdate(d);
        return "insertsucceed";
    }

    public String delete() {
        String ids = dept.getId();
        moduleService.delete(Module.class, ids.split(","));
        return "insertsucceed";
    }

}
