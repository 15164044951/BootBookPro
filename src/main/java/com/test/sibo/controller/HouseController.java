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
import com.test.sibo.entity.HouseEntity;
import com.test.sibo.entity.Result;
import com.test.sibo.service.HouseService;
import com.test.sibo.util.ResultGenerator;

/**
 * 房屋相关
 * 
 * */
@RestController
@RequestMapping("/house")
public class HouseController {

	
	
	@Autowired
	HouseService houseservice;
	
	/**
	 * 获取全部房源信息
	 * */
	@PostMapping("/listHouseALL")
	public Result listHouseALL(@RequestBody Map<String ,Object> housemap) {	
		List<HouseEntity> houselist= houseservice.listHouse(housemap);
		PageInfo<HouseEntity> pageinfo =null;
		if(housemap.get("pageNum")!=null&&housemap.get("pageSize")!=null) {
			//分页
			int pageNum = Integer.parseInt(housemap.get("pageNum").toString());
			int pageSize = Integer.parseInt(housemap.get("pageSize").toString());
			PageHelper.startPage(pageNum, pageSize);
			pageinfo = new PageInfo<HouseEntity>(houselist);			
		}		
		return ResultGenerator.genOkResult(pageinfo);
	}
	
	
	/**
	 * 根据id获取房屋详情信息
	 * */
	@PostMapping("/getHouseDetails")
	public Result getHouseDetails(@RequestBody Map<String ,String> housemap) {
		
		int id=Integer.parseInt(housemap.get("id"));
		HouseEntity house=houseservice.getHouseDetails(id);
		
		//租赁价格显示
		if(house.house_rentalprice!=0) {
			house.setHouse_rentalpricetext(house.house_rentalprice+"/月");
		}else {
			house.setHouse_rentalpricetext("无");
		}
		//售价显示
		if(house.getHouse_sellingprice()!=0) {			
			house.setHouse_sellingpricetext((house.getHouse_sellingprice()/10000)+"万");
		}else {
			house.setHouse_sellingpricetext("无");
		}
		//房屋租赁类型
		if(house.getHouse_rentalstate()!=null) {
			switch (house.getHouse_rentalstate()) {
					case "0":
						house.setHouse_rentalstateText("押一付三");
						break;
					case "1":
						house.setHouse_rentalstateText("押一付一");
						break;	
					case "2":
						house.setHouse_rentalstateText("押一付二");
						break;	
					case "3":
						house.setHouse_rentalstateText("押三付三");
						break;	
					default:
						break;
			}
		}else {
			house.setHouse_rentalstateText("无");
		}
		// 房屋买卖类型
		if(house.getHouse_selltype()!=null) {
			if(house.getHouse_selltype().equals("0")) {
				house.setHouse_selltypeText("使用权");
			}else {
				house.setHouse_selltypeText("产权");
			}
		}else {
			house.setHouse_selltypeText("无");
		}
		int shi = house.getHouse_shi();//室
		int ting = house.getHouse_ting();//厅
		int wei = house.getHouse_wei();//卫
		int chu = house.getHouse_chu();//厨
		//获得户型
		house.setHouse_huxingText(shi+"室"+ting+"厅"+wei+"卫"+chu+"厨");
		return ResultGenerator.genOkResult(house);
	}
	
	@PostMapping("/insertHouse")
	public Result insertHouse(@RequestBody Map<String ,HouseEntity> housemap) {
		if(housemap.get("hosueentity")!=null) {
			//得到前台穿的参
			HouseEntity house=(HouseEntity) housemap.get("hosueentity");
			//拼接搜索条件
			StringBuffer strb=new StringBuffer();
			strb.append(house.getHouse_name());
			//备注信息
			if(house.house_remarks!=null) {
				strb.append(house.getHouse_remarks());
			}
			strb.append(house.getHouse_address());
			strb.append(house.getHouse_owner());
			strb.append(house.getHouse_phone());
			//出租金额
			if(house.getHouse_rentalprice()!=0) {
				strb.append(house.getHouse_rentalprice());
			}
			//出租类型
			if(house.getHouse_rentalstate()!=null) {
				if(house.getHouse_rentalstate().equals("0")) {
					strb.append("押一付三");
				}else if(house.getHouse_rentalstate().equals("1")){
					strb.append("押一付一");
				}else if(house.getHouse_rentalstate().equals("2")){
					strb.append("押一付二");
				}else if(house.getHouse_rentalstate().equals("3")){
					strb.append("押三付三");
				}
			}
			
			if(house.getHouse_sellingprice()!=0) {
				strb.append((house.getHouse_sellingprice()*10000));
			}
			//买卖类型
			if(house.getHouse_selltype()!=null) {
				if(house.getHouse_selltype().equals("0")) {
					strb.append("使用权");
				}else if(house.getHouse_selltype().equals("1")){
					strb.append("产权");
				}
			}
			
			strb.append(house.getHouse_area()+"平米");
			strb.append(house.getHouse_shi()+"室");
			strb.append(house.getHouse_ting()+"厅");
			strb.append(house.getHouse_wei()+"卫");
			strb.append(house.getHouse_chu()+"厨");
			//拼接后的搜索条件
			house.setHouse_searchtext(strb.toString());
			//创建房屋信息
			houseservice.insertHouse(house);	

		}

		return ResultGenerator.genOkResult();
	}
}
