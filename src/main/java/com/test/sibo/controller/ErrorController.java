package com.test.sibo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/error")
public class ErrorController  {

	@GetMapping("/403")
	public String errortext() {
		return "没有账号";
	}
}
