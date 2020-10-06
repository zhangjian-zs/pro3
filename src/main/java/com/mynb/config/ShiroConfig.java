package com.mynb.config;


import com.mynb.shiro.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 整合shiro框架相关的配置类
 */
@Configuration
public class ShiroConfig {
    //创建shiroFilter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统的受限资源
        Map<String, String> map = new HashMap<>();
        map.put("/card/login", "anon"); //anon表示公共资源，先设置登录页为公共资源，再在下面设置其他所有资源为需要认证授权的资源
        map.put("/card/stuLogin", "anon");
        map.put("/**", "authc");//authc表示请求该资源需要认证和授权, /**表示所有资源
        //配置系统公共资源

        //默认认证界面路径,
        System.out.println("默认界面路径=====" + shiroFilterFactoryBean.getLoginUrl());
        shiroFilterFactoryBean.setLoginUrl("/card/login");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);//设置哪些资源需要认证授权

        return shiroFilterFactoryBean;
    }

    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }


    //创建自定义realm
    @Bean
    public Realm getRealm(){
        System.out.println("========================================");
        CustomerRealm customerRealm = new CustomerRealm();
        //修改凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置假面算法为md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        //credentialsMatcher.setHashIterations(1024);

        customerRealm.setCredentialsMatcher(credentialsMatcher);
        return customerRealm;
    }
}
