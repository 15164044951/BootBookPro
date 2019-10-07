package com.test.sibo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sibo.entity.HouseEntity;
import com.test.sibo.mapper.HouseMapper;
import com.test.sibo.service.HouseService;
@Service
public class HouseServiceImpl  implements HouseService{

	
	@Autowired
	HouseMapper housemapper;

	@Override
	public HouseEntity getHouseDetails(int houseid) {

		return housemapper.getHouseDetails(houseid);
	}

	@Override
	public List<HouseEntity> listHouse(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return housemapper.listHouse(map);
	}

	@Override
	public List<HouseEntity> listHouseFive() {
		// TODO Auto-generated method stub
		return housemapper.listHouseFive();
	}

	@Override
	public void insertHouse(HouseEntity hosue) {
		// TODO Auto-generated method stub
		housemapper.insertHouse(hosue);
	}

}
