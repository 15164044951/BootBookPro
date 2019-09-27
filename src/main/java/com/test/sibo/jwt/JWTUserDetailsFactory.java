package com.test.sibo.jwt;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.test.sibo.entity.UserEntity;

public class JWTUserDetailsFactory {

	

    private JWTUserDetailsFactory(){

    }

    public static JWTUserDetails create(User user, Long userId, Instant date){
        return new JWTUserDetails(userId, user.getUsername(), user.getPassword(),user.getAuthorities(), date);
    }

    public static JWTUserDetails create(User user, UserEntity userDetail){
        return new JWTUserDetails(userDetail,user.getAuthorities());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
