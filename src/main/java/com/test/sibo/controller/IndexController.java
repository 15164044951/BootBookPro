package com.test.sibo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.entity.Result;
import com.test.sibo.entity.Result.ResultBuiler;
import com.test.sibo.util.BCryptPasswordUtil;

@RestController
@RequestMapping("/index")
public class IndexController {
	
	
	@GetMapping("/indexText")
	public ResultBuiler index() {		
		return Result.builder()
				.code(200)
				.message("访问成功");
	}
	
	
	@PostMapping("/getBCryptPwd")
	public ResultBuiler getPasswordBCrypt(@RequestBody Map<String ,String> usermap) {
		
		String enpassword=BCryptPasswordUtil.getPasswordBCrypt(usermap.get("userpassword"));
		return Result.builder()
				.code(200)
				.message("访问成功")
				.data(enpassword);
	}

}
