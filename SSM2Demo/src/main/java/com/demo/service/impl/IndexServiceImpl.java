package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.DemoUserMapper;
import com.demo.model.User;
import com.demo.pojo.DemoUser;
import com.demo.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private DemoUserMapper demoUserMapper;

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user = null;
		
		if (id != 0) {
			DemoUser demoUser = this.demoUserMapper.selectByPrimaryKey(id);
			
			if (demoUser != null) {
				user = new User(demoUser.getId(), demoUser.getUsername(), demoUser.getAge(), demoUser.getGender(), demoUser.getBirthday());
			}
		}
		
		return user;
	}

}
