package com.cy.pro.sysadmin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.cy.pro.BaseAction;
import com.cy.pro.domain.Module;
import com.cy.pro.domain.Role;
import com.cy.pro.service.ModuleService;
import com.cy.pro.service.RoleService;
import com.cy.pro.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

public class RoleAction extends BaseAction implements ModelDriven<Role> {

    private String moduleIds;

    public void setModuleIds(String moduleIds) {
        this.moduleIds = moduleIds;
    }

    private Role dept = new Role();

    public void setRoleService(RoleService deptService) {
        this.roleService = deptService;
    }

    private RoleService roleService;
    private ModuleService moduleService;

    public void setModuleService(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public void setUser(Role dept) {
        this.dept = dept;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    private Page page = new Page();

    @Override
    public Role getModel() {
        return dept;
    }


    public String list() throws Exception {
        roleService.findPage("from Role", page, Role.class, null);
        page.setUrl("roleAction_list");
        pushVs(page);
        return "dept_list";
    }

    public String toview() {
        dept = roleService.get(Role.class, dept.getId());
        pushVs(dept);
        return "dept_toView";
    }

    public String tocreate() {
        return "tocreate";
    }

    public String insert() {
        roleService.saveOrUpdate(dept);
        return "insertsucceed";
    }

    public String toupdate() {
        dept = roleService.get(Role.class, dept.getId());
        pushVs(dept);
        return "updatedept";
    }

    public String update() {
        Role d = roleService.get(Role.class, dept.getId());//先查询数据库中的当前条值，然后将要修改的值提交上去
        d.setName(dept.getName());
        d.setRemark(dept.getRemark());
        roleService.saveOrUpdate(d);
        return "insertsucceed";
    }

    public String delete() {
        String ids = dept.getId();
        roleService.delete(Role.class, ids.split(","));
        return "insertsucceed";
    }

    public String tomodule() {
        Role role = roleService.get(Role.class, dept.getId());
        pushVs(role);
        return "role_to_module";
    }

    public String roleModuleJsonStr() throws Exception {
        Role role = roleService.get(Role.class, dept.getId());
        Set<Module> modules = role.getModules();
        List<Module> moduleList = moduleService.find("from Module", Module.class, null);
        JSONArray array = new JSONArray();
        for (int i = 0; i < moduleList.size(); i++) {
            Module module = moduleList.get(i);
            JSONObject obj = new JSONObject();
            obj.put("id", module.getId());
            obj.put("pId", module.getParent_id());
            obj.put("name", module.getName());
            obj.put("checked", modules.contains(module) ? true : false);
            array.add(obj);
        }
        String res = JSONArray.toJSONString(array);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(res);
        return NONE;
    }

    /**
     * 保存节点
     *
     * @return
     */
    public String module() {
        Role role = roleService.get(Role.class, dept.getId());
        Set<Module> modules = role.getModules();
        modules.clear();
        String[] ids = moduleIds.split(",");
        for (int i = 0; i < ids.length; i++) {
            Module module = moduleService.get(Module.class, ids[i]);
            modules.add(module);
        }
        role.setModules(modules);
        roleService.saveOrUpdate(role);
        return "insertsucceed";
    }
}
