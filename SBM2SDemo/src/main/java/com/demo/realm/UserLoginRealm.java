package com.demo.realm;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.cred.Rfc2898CredentialsMatcher;
import com.demo.pojo.DemoPermission;
import com.demo.pojo.DemoRole;
import com.demo.pojo.DemoUser;
import com.demo.service.UserInfoService;
import com.demo.tools.Tools;


public class UserLoginRealm extends AuthorizingRealm {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userLoginRealm";
	}
	
	/**
	 * 获取授权信息
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		DemoUser demoUser = (DemoUser) principals.getPrimaryPrincipal();
		System.out.println(demoUser.getName());
		System.out.println("test");
		SimpleAuthorizationInfo authorizationInfo = null;
		
		if (!Tools.objectIsNullOrNot(demoUser)) {
			// 获取用户角色信息
			DemoRole demoRole = this.userInfoService.getUserRoleInfoByUserId(demoUser.getId());
			
			// 获取角色的所有权限
			if (!Tools.objectIsNullOrNot(demoRole)) {
				List<DemoPermission> demoPermissions = this.userInfoService.getRolePermissionsByRoleId(demoRole.getId());
				
				// 添加权限与角色
				if (!Tools.objectIsNullOrNot(demoPermissions)) {
					authorizationInfo = new SimpleAuthorizationInfo();
					System.out.println(demoRole.getKey());
					authorizationInfo.addRole(demoRole.getKey());
					
					for (DemoPermission demoPermission : demoPermissions) {
						authorizationInfo.addStringPermission(demoPermission.getKey());
					}
				}
			}
		}
		
		return authorizationInfo;
	}

	
	/**
	 * 获取身份验证相关信息
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = String.valueOf(token.getPrincipal());
		
		SimpleAuthenticationInfo authenticationInfo = null;
		
		// 获取用户信息
		DemoUser demoUser = this.userInfoService.getUserInfoByUsername(username);
		
		// 判断用户是否存在
		if (!Tools.objectIsNullOrNot(demoUser)) {
			
			// 判断用户是否已锁
			if (demoUser.getLocked()) {
				
				// 构造authenticationInfo给父类用于身份验证
				authenticationInfo = new SimpleAuthenticationInfo(
						demoUser, 
						demoUser.getPassword(), 
						ByteSource.Util.bytes(demoUser.getSalt()), 
						this.getName());
			} else {
				throw new LockedAccountException();
			}
		} else {
			throw new UnknownAccountException();
		}
		
		return authenticationInfo;
	}
	
	
	/**
	 * 设置验证规则
	 * 
	 * 
	 */
	@PostConstruct
	public void initCredentialsMatcher(){
		this.setCredentialsMatcher(new Rfc2898CredentialsMatcher());
	}

}
