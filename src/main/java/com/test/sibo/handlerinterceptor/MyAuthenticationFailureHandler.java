package com.test.sibo.handlerinterceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //用户登录时身份认证未通过
        if (e instanceof BadCredentialsException){
//            log.info("用户登录时：用户名或者密码错误.");
//            ResultUtil.writeJavaScript(httpServletResponse,ErrorCodeEnum.LOGIN_INCORRECT);
        }else{
//            ResultUtil.writeJavaScript(httpServletResponse,ErrorCodeEnum.LOGIN_FAIL);
        }
    }
}