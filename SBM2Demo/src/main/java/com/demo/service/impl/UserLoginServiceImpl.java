package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.demo.data.ResultData;
import com.demo.mapper.DemoUserMapper;
import com.demo.model.User;
import com.demo.pojo.DemoUser;
import com.demo.pojo.DemoUserExample;
import com.demo.service.UserLoginService;
import com.demo.tools.CryptoUtils;
import com.demo.tools.Tools;
import com.demo.vo.UserLoginVo;

@Service
@Primary
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private DemoUserMapper demoUserMapper;

	@Override
	public ResultData loginIsSuccess(UserLoginVo userLoginVo) {
		// TODO Auto-generated method stub
		if (!Tools.objectIsNullOrNot(userLoginVo.getUsername()) && !Tools.objectIsNullOrNot(userLoginVo.getPassword())) {
			DemoUserExample demoUserExample = new DemoUserExample();
			DemoUserExample.Criteria criteria = demoUserExample.createCriteria();
			criteria.andUUsernameEqualTo(userLoginVo.getUsername());
			
			List<DemoUser> demoUsers = this.demoUserMapper.selectByExample(demoUserExample);
			
			if (!Tools.objectIsNullOrNot(demoUsers) && !Tools.objectIsNullOrNot(demoUsers.get(0))) {
				DemoUser demoUser = demoUsers.get(0);
				
				if (CryptoUtils.verify(demoUser.getuPassword(), userLoginVo.getPassword(), demoUser.getuSalt())) {
					User user = new User(demoUser.getuId(), demoUser.getuName(), demoUser.getuAge(), demoUser.getuSex(), demoUser.getuBirthday());
					
					return new ResultData(10000, "ok", user, System.currentTimeMillis());
				} else {
					return new ResultData(10103, "登陆密码错误", null, System.currentTimeMillis());
				}
				
			} else {
				return new ResultData(10104, "登陆用户不存在", null, System.currentTimeMillis());
			}
		}
		
		return new ResultData(10102, "登陆失败", null, System.currentTimeMillis());
	}

}
