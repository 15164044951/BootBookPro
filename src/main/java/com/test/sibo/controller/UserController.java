package com.test.sibo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.entity.UserEntity;
import com.test.sibo.jwt.JwtTokenUtil;
import com.test.sibo.security.CustomUserDetailsService;
import com.test.sibo.service.UserService;



@RestController
@RequestMapping("/login")
public class UserController {
	
	
	@Autowired
	CustomUserDetailsService custUserService;
	@Autowired
	JwtTokenUtil jtu;
	
	@Autowired
	UserService userservice;
	
	
	@PostMapping("/userlogin")
	public String loginUser(@RequestBody Map<String ,String> usermap) {
		UserEntity userentity=new UserEntity();
		UserDetails userdetails=null;
		try {
			 userdetails=custUserService.loadUserByUsername(usermap.get("username"));
		} catch (Exception e) {
			return e.getMessage();
		}
		
		String str;
		if(userdetails!=null) {
			if(userdetails.getPassword().equals(usermap.get("userpassword"))) {
				str=jtu.generateAccessToken(userdetails);
				userentity.setUser_name(userdetails.getUsername());
				userentity.setUser_token(str);
				//更新Token
				userservice.updateToken(userentity);
//				ResultUtil.out(response, ResultUtil.resultMap(200,"登录成功", str));
				return "登陆成功：："+str;
			}else {
				return "密码不正确";
			}
			
		}else {
			return "查无此人";
		}
		
	}
}
