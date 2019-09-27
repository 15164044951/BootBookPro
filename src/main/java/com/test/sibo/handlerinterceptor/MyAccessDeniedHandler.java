package com.test.sibo.handlerinterceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


//@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		  StringBuffer msg = new StringBuffer("请求: ");
	        msg.append(request.getRequestURI()).append(" 权限不足，无法访问系统资源.");
//	        log.info(msg.toString());
	       // ResultUtil.writeJavaScript(response,ErrorCodeEnum.AUTHORITY,msg.toString());
		
	}
	
}
