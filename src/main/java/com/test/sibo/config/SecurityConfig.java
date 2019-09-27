package com.test.sibo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.test.sibo.handlerinterceptor.MyAccessDeniedHandler;
import com.test.sibo.handlerinterceptor.MyAuthenticationEntryPointHandler;
import com.test.sibo.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法权限控制
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder  auth) throws  Exception{
        auth.userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }
 
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers("/login").permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
//                .and().exceptionHandling()
//                // 认证配置当用户请求了一个受保护的资源，但是用户没有通过登录认证，则抛出登录认证异常，MyAuthenticationEntryPointHandler类中commence()就会调用
//                .authenticationEntryPoint(myAuthenticationEntryPoint())
//                //用户已经通过了登录认证，在访问一个受保护的资源，但是权限不够，则抛出授权异常，MyAccessDeniedHandler类中handle()就会调用
//                .accessDeniedHandler(myAccessDeniedHandler())
//                .and()
//                .formLogin().loginPage("/login").successForwardUrl("/index").failureForwardUrl("/login?error=1")
//                .and()
                //权限拒绝的页面
//                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable();;
 
        http.logout().logoutSuccessUrl("/login");
    }
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    /**
     * 自定义UserDetailsService，授权
     * @return
     */
    @Bean
    public CustomUserDetailsService customUserDetailsService(){
        return new CustomUserDetailsService();
    }
    
    /**
     * 注册  登录认证 bean
     * @return
     */
    @Bean
    public AuthenticationEntryPoint myAuthenticationEntryPoint(){

       return new MyAuthenticationEntryPointHandler();
        //return new JwtAuthenticationEntryPoint();
    }
    
//    /**
//     * 注册  认证权限不足处理 bean
//     * @return
//     */
//    @Bean
//    public AccessDeniedHandler myAccessDeniedHandler(){
//        return new MyAccessDeniedHandler();
//    }
 
    /**
     * AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
