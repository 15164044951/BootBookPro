package com.test.sibo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.sibo.entity.CustomerEntity;
import com.test.sibo.entity.HouseEntity;
import com.test.sibo.entity.Result;
import com.test.sibo.service.CustomerService;
import com.test.sibo.util.ResultGenerator;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	
	   @Autowired
	   CustomerService customerservice;
	   /**
	    * 获取全部客源信息
	    * */
	   @PostMapping("/listCustomer")
	   public Result listCustomer(@RequestBody Map<String,String> map) {
		
		   List<CustomerEntity> list=customerservice.listCustomer(map);
		   PageInfo<CustomerEntity> pageinfo =null;
			if(map.get("pageNum")!=null&&map.get("pageSize")!=null) {
				//分页
				int pageNum = Integer.parseInt(map.get("pageNum").toString());
				int pageSize = Integer.parseInt(map.get("pageSize").toString());
				PageHelper.startPage(pageNum, pageSize);
				pageinfo = new PageInfo<CustomerEntity>(list);			
			}			   
		   return ResultGenerator.genOkResult(pageinfo);
		   
	   }
	   
	   /**
	    	* 根据id获取客户信息
	    * 
	    * */
	   @PostMapping("/getCustomerDetails")
	   public Result getCustomerDetails(@RequestBody Map<String,String> map) {
		   CustomerEntity customer=null;
		   if(map.get("id")!=null) {
			   int id = Integer.parseInt(map.get("id").toString());
			   customer = customerservice.getCustomer(id);
		   }
		   return ResultGenerator.genOkResult(customer);
		   	
	   }
	   @PostMapping("/insertCustomer")
	   public Result insertCustomer(@RequestBody Map<String,CustomerEntity> map) {
		   if(map.get("customer")!=null) {
			   CustomerEntity customer=map.get("customer");
			   //拼接查询条件
			   StringBuffer strb=new StringBuffer();
			   strb.append(customer.getCustomer_name());
			   strb.append(customer.getCustomer_phone());
			   strb.append(customer.getCustomer_details());
			   strb.append(customer.getCustomer_price());
		
				   if(customer.getCustomer_type()==0) {
					   strb.append("想租");
				   }else if(customer.getCustomer_type()==1) {
					   strb.append("想买");
				   }
			  
				   if(customer.getCustomer_fast()==0) {
					   strb.append("着急");
				   }else if(customer.getCustomer_fast()==1) {
					   strb.append("不急");
				   }
				   customer.setCustomer_searchtext(strb.toString());  	

			   customerservice.insertCustomer(customer);
		   }
		   
		   return ResultGenerator.genOkResult();
		}

}
