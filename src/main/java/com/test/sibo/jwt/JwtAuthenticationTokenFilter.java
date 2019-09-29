package com.test.sibo.jwt;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.test.sibo.security.CustomUserDetailsService;
import com.test.sibo.service.UserService;


@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{
	
    private final static Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

 	@Autowired
	private CustomUserDetailsService custUserService;
	
	@Resource
	JwtUtil jutil;
	
   	@Autowired
    private	UserService userservice;
	


    public JwtAuthenticationTokenFilter() {

    }

    

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			javax.servlet.FilterChain filterChain) throws ServletException, IOException {

			//取得URL
	    	String url = request.getRequestURI();
	    	//过滤不需要验证的url
	        if(url.indexOf("/login")!=-1){	        
	            filterChain.doFilter(request, response);
	            return;
	        }

    		  //取得真正的token
    		  final String authToken =  jutil.getTokenFromRequest(request);
    		  if (authToken != null ) {
    		  //取得token内的账号名
    		  String useraccount = jutil.getUsername(authToken);
    		  if(useraccount!=null) {
    			  			UserDetails userDetails= custUserService.loadUserByUsername(useraccount);
//	        	    	UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(
//		                              userDetails, null, userDetails.getAuthorities());
    			  			//token用户认证
    			  			UsernamePasswordAuthenticationToken usernamePasswordAuthentication = jutil.getAuthentication(useraccount, authToken);
							//获得数据库内的token
							String usertoken=userservice.getToken(useraccount);
					        if(usertoken!=null&&!usertoken.equals("")) {
					        	//验证与数据库内的token的一致性
						        boolean tokenbl=authToken.equals(usertoken);
						        if(tokenbl) {
							        usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
							        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
							        filterChain.doFilter(request, response);
							        return;
						        }
		                    }
				        }	    			  
    		  }
    		  filterChain.doFilter(request, response);
			}

		
	}


