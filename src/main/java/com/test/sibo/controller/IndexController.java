package com.test.sibo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.entity.Result;
import com.test.sibo.util.ResultGenerator;

/**
 * 首页信息
 * 
 * */
@RestController
@RequestMapping("/index")
public class IndexController {
	
	
	
   @GetMapping("/indexss")
   public Result getindexss() {
	 
	   return ResultGenerator.genOkResult("asd");
   }
   	


}
