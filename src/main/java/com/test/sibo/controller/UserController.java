package com.test.sibo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.entity.Result;
import com.test.sibo.entity.UserEntity;
import com.test.sibo.jwt.JwtUtil;
import com.test.sibo.security.CustomUserDetailsService;
import com.test.sibo.service.UserService;
import com.test.sibo.util.BCryptPasswordUtil;
import com.test.sibo.util.ResultGenerator;



@RestController
@RequestMapping("/login")
public class UserController {
	
	
	@Autowired
	CustomUserDetailsService custUserService;
	@Autowired
	JwtUtil jutil;
	
	@Autowired
	UserService userservice;
	
	
	@PostMapping("/userlogin")
	public Result loginUser(@RequestBody Map<String ,String> usermap) {
		UserEntity userentity=new UserEntity();
		UserDetails userdetails=null;
		try {
			 userdetails=custUserService.loadUserByUsername(usermap.get("username"));
		} catch (Exception e) {
			return 	ResultGenerator.genFailedResult("登录认证不通过");
		}		
		String str;
		if(userdetails!=null) {
//			System.out.println(userdetails.getPassword());
			if(BCryptPasswordUtil.passwordBCryptTorF(usermap.get("userpassword"), userdetails.getPassword())) {
				//生成Token
				str=jutil.sign(userdetails.getUsername(),userdetails.getAuthorities());
				userentity.setUser_name(userdetails.getUsername());
				userentity.setUser_token(str);
				//更新Token
				userservice.updateToken(userentity);				
				//return Result.builder().code(200).message("登录成功").data(userentity);
				return ResultGenerator.genOkResult(userentity);
			}else {
				return ResultGenerator.genFailedResult("密码不通过");
			}			
		}
			return ResultGenerator.genFailedResult("查无此人");
		
		
	}
	
	

}
