package com.test.sibo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sibo.entity.UserEntity;
import com.test.sibo.mapper.UserMapper;
import com.test.sibo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserMapper usermapper;
	@Override
	public void updateToken(UserEntity user) {
		usermapper.updateToken(user);
		
	}
	
	@Override
	public String getToken(String username) {

		return usermapper.getToken(username);
	}

}
