package com.test.sibo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


/**
 * 登陆类
 * 
 * */
@RestController
@RequestMapping("/login")
public class UserController {
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	CustomUserDetailsService custUserService;
	
	@Autowired
	JwtUtil jutil;
	
	@Autowired
	UserService userservice;

	/**
	 * 账号登陆
	 *  userlogin
	 * */
	@PostMapping("/userlogin")
	public Result loginUser(@RequestBody Map<String ,String> usermap) {
		
		UserDetails userdetails=null;
		//登陆认证
		userdetails=custUserService.loadUserByUsername(usermap.get("username"));	
		String str;
		if(userdetails!=null) {
			//以工具类BCryptPasswordUtil，验证密码是否一致
			if(BCryptPasswordUtil.passwordBCryptTorF(usermap.get("userpassword"), userdetails.getPassword())) {
				UserEntity userentity=getloginUsers(userdetails.getUsername());				
				//生成Token
				str=jutil.sign(userdetails.getUsername(),userdetails.getAuthorities());	
				userentity.setUser_token(str);
				//更新Token
				userservice.updateToken(userentity);	
				//去头返回token.substring("Bearer ".length())
				userentity.setUser_token(str);
				log.info("账号："+userentity.getUser_name()+"登陆成功");
				return ResultGenerator.genOkResult(userentity);
			}else {
				log.error("账号："+usermap.get("username")+"登陆失败，密码错误");
				return ResultGenerator.genFailedResult("密码不通过");
			}			
		}
			log.error("账号："+usermap.get("username")+"查无此人");
			return ResultGenerator.genFailedResult("查无此人");
		
		
	}
	
	/**
	 * 加密密码接口
	 * */
	@PostMapping("/getBCryptPwd")
	public Result getPasswordBCrypt(@RequestBody Map<String ,String> usermap) {
		String enpassword=BCryptPasswordUtil.getPasswordBCrypt(usermap.get("userpassword"));
		return ResultGenerator.genOkResult(enpassword);
	}
	
	private UserEntity getloginUsers(String username) {
		
		return userservice.loadUserByUsername(username);
		
	}
	
	

}
