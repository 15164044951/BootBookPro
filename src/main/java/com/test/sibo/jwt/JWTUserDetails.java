package com.test.sibo.jwt;

import java.time.Instant;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.sibo.entity.UserEntity;

public class JWTUserDetails implements UserDetails {

    private Long userId;         //用户ID
    private String password;       //用户密码
    private final String username; //用户名
    private final Collection<? extends GrantedAuthority> authorities;  //用户角色权限
    private final Boolean isAccountNonExpired;       //账号是否过期
    private final Boolean isAccountNonLocked;        //账户是否锁定
    private final Boolean isCredentialsNonExpired;   //密码是否过期
    private  Boolean enabled;                   //是否激活
//    private final Instant lastPasswordResetDate;        //上次密码重置时间
    private UserEntity userInfo;

    public JWTUserDetails(Long userId, String username, String password, Collection<? extends GrantedAuthority> authorities,Instant lastPasswordResetDate) {
        this(userId, username, password, true, true, true, true, authorities,lastPasswordResetDate);
    }

    public JWTUserDetails(UserEntity userInfo, Collection<? extends GrantedAuthority> authorities) {
        this.userInfo = userInfo;
        if (userInfo != null && StringUtils.isEmpty(userInfo.getUser_name())) {
            this.userId = Long.parseLong(String.valueOf(userInfo.getUser_id()));
            this.username = userInfo.getUser_name();
            this.password = userInfo.getUser_password();
            this.enabled = userInfo.getEnabled() ? false : true;
            this.isAccountNonExpired = true;
            this.isAccountNonLocked = true;
            this.isCredentialsNonExpired = true;
            this.authorities = authorities;
//            this.lastPasswordResetDate = userInfo.getLastPasswordResetDate();
        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }

    public JWTUserDetails(Long userId, String username, String password, boolean enabled, boolean isAccountNonExpired, boolean isCredentialsNonExpired, boolean isAccountNonLocked, Collection<? extends GrantedAuthority> authorities,Instant lastPasswordResetDate) {
        if (username != null && !"".equals(username) && password != null) {
            this.userId = userId;
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.isAccountNonExpired = isAccountNonExpired;
            this.isAccountNonLocked = isAccountNonLocked;
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            this.authorities = authorities;
            //this.lastPasswordResetDate = lastPasswordResetDate;
        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

//    @JsonIgnore
//    public Instant getLastPasswordResetDate() {
//        return lastPasswordResetDate;
//    }

    public UserEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserEntity userInfo) {
        this.userInfo = userInfo;
    }


}
