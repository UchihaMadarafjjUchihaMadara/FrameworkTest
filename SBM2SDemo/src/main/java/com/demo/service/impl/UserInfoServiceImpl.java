package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.demo.mapper.DemoPermissionMapper;
import com.demo.mapper.DemoPermissionRoleMapper;
import com.demo.mapper.DemoRoleMapper;
import com.demo.mapper.DemoRoleUserMapper;
import com.demo.mapper.DemoUserMapper;
import com.demo.pojo.DemoPermission;
import com.demo.pojo.DemoPermissionRole;
import com.demo.pojo.DemoPermissionRoleExample;
import com.demo.pojo.DemoRole;
import com.demo.pojo.DemoRoleUser;
import com.demo.pojo.DemoRoleUserExample;
import com.demo.pojo.DemoUser;
import com.demo.pojo.DemoUserExample;
import com.demo.service.UserInfoService;
import com.demo.tools.Tools;

/**
 * 用户信息业务类
 * 
 * @author DELL
 *
 */

@Service
@Primary
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private DemoUserMapper demoUserMapper;
	@Autowired
	private DemoRoleMapper demoRoleMapper;
	@Autowired
	private DemoPermissionMapper demoPermissionMapper;
	@Autowired
	private DemoRoleUserMapper demoRoleUserMapper;
	@Autowired
	private DemoPermissionRoleMapper demoPermissionRoleMapper;

	/**
	 * 通过username获取用户的DemoUser信息
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public DemoUser getUserInfoByUsername(String username) {
		// TODO Auto-generated method stub
		DemoUser demoUser = null;
		
		if (!Tools.objectIsNullOrNot(username)) {
			DemoUserExample demoUserExample = new DemoUserExample();
			DemoUserExample.Criteria criteria = demoUserExample.createCriteria();
			criteria.andUsernameEqualTo(username);
			
			List<DemoUser> demoUsers = this.demoUserMapper.selectByExample(demoUserExample);
			
			if (!Tools.objectIsNullOrNot(demoUsers) && !Tools.objectIsNullOrNot(demoUsers.get(0))) {
				demoUser = demoUsers.get(0);
			}
		}
		
		return demoUser;
	}
	
	
	
	/**
	 * 通过user_id获取用户角色DemoRole信息
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public DemoRole getUserRoleInfoByUserId(Integer userId) {
		// TODO Auto-generated method stub
		DemoRole demoRole = null;
		
		if (!Tools.objectIsNullOrNot(userId)) {
			DemoRoleUserExample demoRoleUserExample = new DemoRoleUserExample();
			DemoRoleUserExample.Criteria criteria = demoRoleUserExample.createCriteria();
			criteria.andUserIdEqualTo(userId);
			
			List<DemoRoleUser> demoRoleUsers = this.demoRoleUserMapper.selectByExample(demoRoleUserExample);
			
			if (!Tools.objectIsNullOrNot(demoRoleUsers) && !Tools.objectIsNullOrNot(demoRoleUsers.get(0))) {
				DemoRoleUser demoRoleUser = demoRoleUsers.get(0);
				
				demoRole = this.demoRoleMapper.selectByPrimaryKey(demoRoleUser.getRoleId());
			}
		}
		
		return demoRole;
	}
	
	
	
	/**
	 * 通过角色的role_id获取该角色的所有权限DemoPermission列表
	 * 
	 * @param roleId
	 * @return
	 */
	@Override
	public List<DemoPermission> getRolePermissionsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<DemoPermission> list = null;
		
		if (!Tools.objectIsNullOrNot(roleId)) {
			DemoPermissionRoleExample demoPermissionRoleExample = new DemoPermissionRoleExample();
			DemoPermissionRoleExample.Criteria criteria = demoPermissionRoleExample.createCriteria();
			criteria.andRoleIdEqualTo(roleId);
			
			List<DemoPermissionRole> demoPermissionRoles = this.demoPermissionRoleMapper.selectByExample(demoPermissionRoleExample);
			
			if (!Tools.objectIsNullOrNot(demoPermissionRoles)) {
				list = new ArrayList<DemoPermission>();
				
				for (DemoPermissionRole demoPermissionRole : demoPermissionRoles) {
					DemoPermission demoPermission = this.demoPermissionMapper.selectByPrimaryKey(demoPermissionRole.getPermissionId());
					list.add(demoPermission);
				}
			}
		}
		
		return list;
	}

}
