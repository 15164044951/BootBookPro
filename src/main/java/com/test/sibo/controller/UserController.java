package com.test.sibo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.entity.Result;
import com.test.sibo.entity.Result.ResultBuiler;
import com.test.sibo.entity.UserEntity;
import com.test.sibo.jwt.JwtUtil;
import com.test.sibo.security.CustomUserDetailsService;
import com.test.sibo.service.UserService;
import com.test.sibo.util.BCryptPasswordUtil;



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
	public ResultBuiler loginUser(@RequestBody Map<String ,String> usermap) {
		UserEntity userentity=new UserEntity();
		UserDetails userdetails=null;
		try {
			 userdetails=custUserService.loadUserByUsername(usermap.get("username"));
		} catch (Exception e) {
			
			return Result.builder()
								.code(403)
								.message("登录认证不通过")
								.data(userentity);
		}		
		String str;
		if(userdetails!=null) {
			System.out.println(userdetails.getPassword());
			if(BCryptPasswordUtil.passwordBCryptTorF(usermap.get("userpassword"), userdetails.getPassword())) {
				//生成Token
				str=jutil.sign(userdetails.getUsername(),userdetails.getAuthorities());
				userentity.setUser_name(userdetails.getUsername());
				userentity.setUser_token(str);
				//更新Token
				userservice.updateToken(userentity);				
				return Result.builder().code(200).message("登录成功").data(userentity);
			}else {
				return Result.builder()
						.code(403)
						.message("密码不正确")
						.data(userentity);
			}			
		}else {
			return Result.builder()
					.code(403)
					.message("查无此人")
					.data(userentity);
		}
		
	}
	
	

}
