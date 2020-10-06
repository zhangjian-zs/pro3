package com.mynb.shiro.realm;

import com.mynb.pojo.Rights;
import com.mynb.pojo.Userinfo;
import com.mynb.service.ICardService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义realm
 */
@Component
public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    private ICardService service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取身份信息
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("调用授权验证: "+primaryPrincipal);
        //根据主身份信息获取角色 和 权限信息
        Userinfo userinfo = service.findRoleByUserLogin(primaryPrincipal);
        //授权角色信息
        if(userinfo!=null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole(userinfo.getRole().getRolename());
            //权限信息
            List<Rights> rights = service.findPermsByRoleId(userinfo.getRole().getRoleid());
            if(!CollectionUtils.isEmpty(rights)){
                rights.forEach(right->{
                    simpleAuthorizationInfo.addStringPermission(right.getRightname());
                });
            }
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            System.out.println("---------------------------------------------------");
            //获取身份信息
            String principal = (String) authenticationToken.getPrincipal();
            //数据库中查找该身份信息对应的密码
            Userinfo userinfo = service.selectUserByName(principal);
            if(userinfo!=null){
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, userinfo.getUserPasswd(),
                        ByteSource.Util.bytes("haha"), this.getName());
                System.out.println("认证返回的结果："+info);
                return info;
            }
        return null;
    }
}
