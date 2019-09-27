package com.test.sibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.security.CustomUserDetailsService;



@RestController
@RequestMapping("/login")
public class UserController {
	
	
	@Autowired
	CustomUserDetailsService custUserService;
	@GetMapping("/userlogin")
	public String loginUser() {
//		custUserService.loadUserByUsername(username)String username
		return "登陆失败";
		
	}
}
