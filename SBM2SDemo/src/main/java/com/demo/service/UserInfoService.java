package com.demo.service;

import java.util.List;

import com.demo.pojo.DemoPermission;
import com.demo.pojo.DemoRole;
import com.demo.pojo.DemoUser;

/**
 * 用户信息业务类
 * 
 * @author DELL
 *
 */
public interface UserInfoService {
	
	
	/**
	 * 通过username获取用户的DemoUser信息
	 * 
	 * @param username
	 * @return
	 */
	public DemoUser getUserInfoByUsername(String username);
	
	
	/**
	 * 通过user_id获取用户角色DemoRole信息
	 * 
	 * @param userId
	 * @return
	 */
	public DemoRole getUserRoleInfoByUserId(Integer userId);
	
	
	/**
	 * 通过角色的role_id获取该角色的所有权限DemoPermission列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<DemoPermission> getRolePermissionsByRoleId(Integer roleId);

}
