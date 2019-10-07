package com.test.sibo.service;

import java.util.List;
import java.util.Map;

import com.test.sibo.entity.CustomerEntity;

public interface CustomerService {

	
	
	//获取全部的客源信息
	public List<CustomerEntity> listCustomer(Map<String,String> map);
	//获取最新的五条信息
	public List<CustomerEntity> listCustomerFive();
	//查询单个客户信息
	public CustomerEntity getCustomer(int id);
	//创建客源信息
	public void insertCustomer(CustomerEntity customer);
}
