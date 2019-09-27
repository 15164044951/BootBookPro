package com.test.sibo.handlerinterceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationEntryPointHandler implements AuthenticationEntryPoint{

	   @Override
	    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
	        StringBuffer msg = new StringBuffer("请求访问: ");
	        msg.append(httpServletRequest.getRequestURI()).append(" 接口， 因为登录超时，无法访问系统资源.");
//	        log.info(msg.toString());
//	        ResultUtil.writeJavaScript(httpServletResponse,ErrorCodeEnum.LOGIN_WITHOUT,msg.toString());

	      /*  boolean ajaxRequest = HttpUtils.isAjaxRequest(httpServletRequest);
	        if (ajaxRequest){
	            //如果是ajax请求 则返回自定义错误
	            ResultUtil.writeJavaScript(httpServletResponse,ErrorCodeEnum.LOGIN,map);
	        }else {
	            // 非ajax请求 则跳转到指定的403页面
	            //此处省略...................
	        }*/
	    }

}
