package com.test.sibo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.entity.CustomerEntity;
import com.test.sibo.entity.HouseEntity;
import com.test.sibo.entity.Result;
import com.test.sibo.service.CustomerService;
import com.test.sibo.service.HouseService;
import com.test.sibo.util.ResultGenerator;

/**
 * 首页信息
 * 
 * */
@RestController
@RequestMapping("/index")
public class IndexController {
	
   @Autowired
   HouseService  houseservice;
   
   @Autowired
   CustomerService customerservice;
	
   /**
    * 首页信息获取
    * */
   @PostMapping("/indexText")
   public Result getIndexText(@RequestBody String username) {
	   //最新5条房源信息
	   List<HouseEntity> listhouse=houseservice.listHouseFive();
	   //最新五条客户信息
	   List<CustomerEntity> listcustomer=customerservice.listCustomerFive();
	   Map<String,Object> mapindex=new HashMap<String,Object>();
	   mapindex.put("listhouse", listhouse);
	   mapindex.put("listcustomer", listcustomer);
	   return ResultGenerator.genOkResult(mapindex);
   }
   	


}
