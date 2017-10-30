package com.cy.pro.shiro;

import com.cy.pro.utils.Encrypt;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 密码比较器
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken uptoken= (UsernamePasswordToken) token;
        //将用户输入的原始密码进行加密
        Object obj=Encrypt.md5(new String(uptoken.getPassword()),uptoken.getUsername());
        Object pwd=info.getCredentials();//取出数据库中加密过的密码
        return this.equals(obj,pwd);
    }
}
