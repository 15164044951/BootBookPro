package com.test.sibo.service;

import java.util.List;
import java.util.Map;

import com.test.sibo.entity.HouseEntity;

public interface HouseService {

	//查询所有房屋信息
	public List<HouseEntity> listHouse(Map<String,Object> map);
	//查询最新的五条房源信息
	public List<HouseEntity> listHouseFive();
	
	//获取详情根据id
	public HouseEntity getHouseDetails(int houseid);
	
	//添加房源
	public void insertHouse(HouseEntity hosue);
}
