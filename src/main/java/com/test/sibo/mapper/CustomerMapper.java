package com.test.sibo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.test.sibo.entity.CustomerEntity;

@Mapper
public interface CustomerMapper {

	
	//获取全部的客源信息
	public List<CustomerEntity> listCustomer(Map<String,String> map);
	//获取最新的五条信息
	public List<CustomerEntity> listCustomerFive();
	
	//查询单个客户信息
	public CustomerEntity getCustomer(int id);
	//创建客源信息
	public void insertCustomer(CustomerEntity customer);
	//删除客源
	public void deleteCustomer(int id);
}
