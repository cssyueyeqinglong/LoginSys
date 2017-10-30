package com.cy.pro.shiro;

import com.cy.pro.domain.Module;
import com.cy.pro.domain.Role;
import com.cy.pro.domain.User;
import com.cy.pro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限认证
 * */
public class AuthRealm extends AuthorizingRealm{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.print("授权");
        User user = (User) principalCollection.fromRealm(this.getName()).iterator().next();
        List<String> permissions=new ArrayList<>();
        for (Role item:user.getRoles()) {
            for(Module module:item.getModules()){
                permissions.add(module.getName());
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//为用户添加权限
        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken uptoken= (UsernamePasswordToken) authenticationToken;
        List<User> users = userService.find("from User where user_name=?", User.class, new String[]{uptoken.getUsername()});
        if(users!=null&&users.size()>0){
            User user = users.get(0);
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
            return info;//返回后会立即调用密码比较器
        }
        return null;
    }
}
