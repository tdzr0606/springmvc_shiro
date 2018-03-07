package com.wbkj.jet.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasRealm;


/**
 * springmvc_shiro
 * MyCasRealm
 *
 * @Author: 竺志伟
 * @Date: 2018-03-07 10:11
 */
public class MyCasRealm extends CasRealm
{


    /**
     * 处理 cas 服务返回的信息
     * Do get authentication info authentication info.
     *
     * @param token the token
     * @return the authentication info
     * @author:竺志伟
     * @date :2018-03-07 14:28:59
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);
        if(null != authc)
        {
            String account = (String) authc.getPrincipals().getPrimaryPrincipal();
            // 放入到session中，controller中可以通过 request.getSession()中获取
            SecurityUtils.getSubject().getSession().setAttribute("user", account);
        }
        return authc;
    }
}
