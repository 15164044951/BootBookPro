package com.test.sibo.service;

import java.util.List;

import com.test.sibo.entity.UserEntity;

public interface UserService {
	
	
	//查询账号信息
	public UserEntity loadUserByUsername(String username);
	//更新Token
	public void updateToken(UserEntity user);
	
	//获得Token
	public String getToken(String username);
}
