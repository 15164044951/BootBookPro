package com.test.sibo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordUtil {


	
	
	//加密密码
	public static String getPasswordBCrypt(String password) {
		BCryptPasswordEncoder bcrytPwd= new BCryptPasswordEncoder();
		return bcrytPwd.encode(password);
	}
	//判断密码是否相同
	public static Boolean  passwordBCryptTorF(String rawPassword, String encodedPassword) {
		BCryptPasswordEncoder bcrytPwd= new BCryptPasswordEncoder();
		
		return bcrytPwd.matches(rawPassword, encodedPassword);
		
	}
	
}
