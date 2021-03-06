package com.test.sibo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.test.sibo.entity.Result;
import com.test.sibo.exception.ExceptionResolver;
import com.test.sibo.util.ResultGenerator;



/**
 * 
 * */

@Component
@Aspect
public class SpringAop {
	
	 private final static Logger LOGGER = LoggerFactory.getLogger(SpringAop.class);
	 
	 @Autowired
	 ExceptionResolver exceptionR;
	 
	 @Pointcut("execution(public * com.test.sibo.controller.*.*(..))")
	 public void HttpAopLog(){
	 
	  }
	 

	 @Before("HttpAopLog()")
	 public void doBefore(JoinPoint joinPoint){

	     Object[] args = joinPoint.getArgs();
	     LOGGER.info("==================HTTPJoinPointRUN：开始===============");
		 LOGGER.info("参数为={}",args);
		 LOGGER.info("StringJoinpoint={}",joinPoint.toString());
		 LOGGER.info("JoingetSignature={}",joinPoint.getSignature());
		 LOGGER.info("==================HTTPJoinPointEND===============");
	 }
	 
//	 @Around("HttpAopLog()")
//	 public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		 LOGGER.info("pointObj={}",proceedingJoinPoint.toString());
//
//		 Result result=null;		 
//		 try {			 
//			 Object pointObj=proceedingJoinPoint.proceed();
//		     if (pointObj instanceof Result) {
//		    	 result = (Result) pointObj;
//	            } else {
//	            	ResultGenerator.genOkResult(pointObj);
//	            }
//			 LOGGER.info("pointObj={}",pointObj.toString());
//		 	 return result;
//		
//		}catch (NoHandlerFoundException e) {
//			 LOGGER.info("errorpointObj={}",e.getMessage());
//		 }//proceedingJoinPoint
//
//		 return null;
//
//	 
//	 }
	 
//	   @AfterReturning(pointcut = "HttpAopLog()",returning = "object")//打印输出结果
//	   public void doAfterReturing(Object object){
//	           LOGGER.info("response={}",object.toString());
//	   }
}
