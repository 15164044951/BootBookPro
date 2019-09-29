package com.test.sibo.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.sibo.entity.UserEntity;
import com.test.sibo.mapper.UserMapper;

public class CustomUserDetailsService implements UserDetailsService {
	
	private final static Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
        //--------------------认证账号
        UserEntity user = mapper.loadUserByUsername(username);
        if (user == null) {
        	log.error("username:"+username+"该账号不存在");
            throw new UsernameNotFoundException("账号不存在");
        }
 
        //-------------------开始授权
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole_name());
        //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
        grantedAuthorities.add(grantedAuthority);
        return new User(user.getUser_name(),user.getUser_password(),grantedAuthorities);
    }
}
