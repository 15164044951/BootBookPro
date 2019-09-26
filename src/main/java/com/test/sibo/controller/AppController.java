package com.test.sibo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sibo.entity.Book;
import com.test.sibo.mapper.BookMapper;

/***/
@RestController
@RequestMapping("/app")
public class AppController {
	@Autowired
	 BookMapper bm;
	
	@GetMapping("/str")
	public List<Book> getStr(){	
		return bm.getBook();
	}
	

}
