package com.test.sibo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.sibo.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	public UserEntity loadUserByUsername(String username);
}
