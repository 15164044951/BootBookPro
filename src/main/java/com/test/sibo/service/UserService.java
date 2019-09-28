package com.test.sibo.service;

import java.util.List;

import com.test.sibo.entity.UserEntity;

public interface UserService {

	//更新Token
	public void updateToken(UserEntity user);
	
	//获得Token
	public String getToken(String username);
}
