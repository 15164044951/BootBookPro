package com.test.sibo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sibo.entity.CustomerEntity;
import com.test.sibo.mapper.CustomerMapper;
import com.test.sibo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerMapper customermapper;
	
	//获得最新的五条客户信息


	@Override
	public List<CustomerEntity> listCustomer(Map<String, String> map) {
		// TODO Auto-generated method stub
		return customermapper.listCustomer(map);
	}

	@Override
	public List<CustomerEntity> listCustomerFive() {
		// TODO Auto-generated method stub
		return customermapper.listCustomerFive();
	}

	@Override
	public CustomerEntity getCustomer(int id) {
		// TODO Auto-generated method stub
		return customermapper.getCustomer(id);
	}

	@Override
	public void insertCustomer(CustomerEntity customer) {
		customermapper.insertCustomer(customer);
		
	}

}
