package com.test.sibo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
	
	
	@GetMapping("/indexText")
	public String index() {
		
		return "你访问到我了";
	}

}
