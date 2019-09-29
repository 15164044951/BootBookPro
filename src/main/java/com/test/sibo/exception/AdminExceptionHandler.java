package com.test.sibo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.sibo.entity.Result;
import com.test.sibo.entity.Result.ResultBuiler;

/**
 * 全局异常处理
 * */
//@RestControllerAdvice
public class AdminExceptionHandler {

	private final static Logger log = LoggerFactory.getLogger(AdminExceptionHandler.class);
	
//	@
//    @ExceptionHandler(value = Exception.class)
	public  ResultBuiler defaultErrorHandler(Exception  ex) throws Exception  {
    	
    	log.error(ex.getMessage());
		return Result.builder()
				.code(400)
				.message(ex.getMessage());
	}
}
