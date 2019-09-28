package com.test.sibo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.test.sibo.adapter.HttpInterceptor;

//@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public HttpInterceptor httpInterceptor() {
    	return new HttpInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpInterceptor()).addPathPatterns("/**");
    }
    

}