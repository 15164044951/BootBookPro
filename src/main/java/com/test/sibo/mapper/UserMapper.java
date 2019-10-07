package com.test.sibo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.sibo.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	//查询账号信息
	public UserEntity loadUserByUsername(String username);
	
	
	//更新Token
	public void updateToken(UserEntity user);
	
	//获得Token
	public String getToken(String username);
}
