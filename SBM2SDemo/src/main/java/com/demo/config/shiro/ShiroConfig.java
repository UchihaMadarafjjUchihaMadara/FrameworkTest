package com.demo.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.realm.UserLoginRealm;


/**
 * @Description: shiro的配置类
 * 
 * @author DELL
 * 
 * @since 2017-05-04
 *
 */
@Configuration
public class ShiroConfig {
	
	/**
	 * ShiroFilterFactoryBean 处理拦截资源文件问题。
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
	 *
	 * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
	 * 3、部分过滤器可指定参数，如perms，roles
	 *
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		
		// 配置记住我或认证通过可以访问的地址
		
		filterChainDefinitionMap.put("/index", "user");
        filterChainDefinitionMap.put("/", "user");
        filterChainDefinitionMap.put("/login.do", "anon");
        
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
     	
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
     	shiroFilterFactoryBean.setLoginUrl("/login");
     	// 登录成功后要跳转的链接
     	shiroFilterFactoryBean.setSuccessUrl("/index");
		
		return shiroFilterFactoryBean;
	}
	
	
	/**
	 * 配置SecurityManager
	 * 
	 * @return
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		
		//设置用户登录realm.
	    securityManager.setRealm(this.userLoginRealm());
	    
		return securityManager;
	}
	
	
	/**
	 * 用户登录realm
	 * 
	 * @return
	 */
	@Bean
	public Realm userLoginRealm(){
		Realm userLoginRealm = new UserLoginRealm();
		
		return userLoginRealm;
	}
	
	
	/**
	 * 添加权限
	 * @param securityManager
	 * @return
	 */
	@Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
       AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
       authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
       return authorizationAttributeSourceAdvisor;
    }
	
//	/**  
//     * ShiroDialect，为了在thymeleaf里使用shiro的标签的bean  
//     * @return  
//     */  
//    @Bean  
//    public ShiroDialect shiroDialect(){  
//    	return new ShiroDialect();  
//    }

}
