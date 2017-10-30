package com.cy.pro.sysadmin;

import com.cy.pro.BaseAction;
import com.cy.pro.domain.Dept;
import com.cy.pro.domain.Role;
import com.cy.pro.domain.User;
import com.cy.pro.service.DeptService;
import com.cy.pro.service.RoleService;
import com.cy.pro.service.UserService;
import com.cy.pro.utils.Page;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;
import java.util.Set;

public class UserAction extends BaseAction implements ModelDriven<User> {

    private String[] roleIds;

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    private User dept = new User();

    public void setUserService(UserService deptService) {
        this.userService = deptService;
    }

    private UserService userService;
    private DeptService deptService;
    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    public void setUser(User dept) {
        this.dept = dept;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    private Page page = new Page();

    @Override
    public User getModel() {
        return dept;
    }


    public String list() throws Exception {
        userService.findPage("from User", page, User.class, null);
        page.setUrl("userAction_list");
        pushVs(page);
        return "dept_list";
    }

    public String toview() {
        dept = userService.get(User.class, dept.getId());
        pushVs(dept);
        return "dept_toView";
    }

    public String tocreate() {
        List<Dept> depts = deptService.find("from Dept where state=1", Dept.class, null);
        setVs("deptList", depts);
        List<User> users = userService.find("from User where state=1", User.class, null);
        setVs("userList", users);
        return "tocreate";
    }

    public String insert() {

        userService.saveOrUpdate(dept);
        return "insertsucceed";
    }

    public String toupdate() {
        List<Dept> depts = deptService.find("from Dept where state=1", Dept.class, null);
        setVs("deptList", depts);
        dept = userService.get(User.class, dept.getId());
        pushVs(dept);
        return "updatedept";
    }

    public String update() {
        User d = userService.get(User.class, dept.getId());//先查询数据库中的当前条值，然后将要修改的值提交上去
        d.setUser_name(dept.getUser_name());
        d.setDept(dept.getDept());
        d.setState(dept.getState());
        userService.saveOrUpdate(d);
        return "insertsucceed";
    }

    public String delete() {
        userService.delete(User.class, dept.getId().split(","));
        return "insertsucceed";
    }

    /**
     * 跳转到角色页面
     *
     * @return
     */
    public String torole() {
        User user = userService.get(User.class, dept.getId());
        pushVs(user);
        List<Role> roleList = roleService.find("from Role", Role.class, null);
        setVs("roleList", roleList);
        Set<Role> roles = user.getRoles();
        StringBuffer sb = new StringBuffer();
        for (Role role :
                roles) {
            sb.append(role.getName() + ",");
        }
        setVs("userRoleStr",sb);
        return "user_to_role";
    }

    /**
     * 保存用户角色
     * @return
     */
    public String role(){
        User user = userService.get(User.class, dept.getId());
        Set<Role> roles = user.getRoles();
        roles.clear();
        for (int i = 0; i < roleIds.length; i++) {
            Role role = roleService.get(Role.class, roleIds[i]);
            roles.add(role);
        }
        user.setRoles(roles);
        userService.saveOrUpdate(user);
        return "insertsucceed";
    }
}
