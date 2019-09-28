package com.test.sibo.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.test.sibo.security.CustomUserDetailsService;
import com.test.sibo.service.UserService;
import com.test.sibo.util.ResultUtil;


@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{

	
 	@Autowired
	private CustomUserDetailsService custUserService;
 	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
   	@Autowired
    private	UserService userservice;
	
    private RequestMatcher authenticationRequestMatcher;
    
    @Value("${jwt.header}")
    private String tokenHeader;
    
    @Value("${jwt.tokenHead}")
	private String tokenHead;

    public JwtAuthenticationTokenFilter() {

    }
    
    public JwtAuthenticationTokenFilter(RequestMatcher authenticationRequestMatcher) {
        this.authenticationRequestMatcher = authenticationRequestMatcher;
    }
    

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			javax.servlet.FilterChain filterChain) throws ServletException, IOException {
    	String url = request.getRequestURI();
    	//过滤不需要验证的url
        if(url.indexOf("/login")!=-1){
            filterChain.doFilter(request, response);
            return;
        }
    	

    	//获取头部token
    	 String authHeader = request.getHeader(this.tokenHeader);

    	 //判断header，查看是否以 tokenhead开头
    	  if (authHeader != null ) {
    		  //取得真正的token
    		  final String authToken = authHeader.substring(this.tokenHead.length());
    		  
    		  //取得token内的账号名
    		  String useraccount = jwtTokenUtil.getUsernameFromToken(authToken);
    		  
    		  if(useraccount!=null) {
    			  UserDetails userDetails= custUserService.loadUserByUsername(useraccount);
    			//验证token合法性
    			  if (jwtTokenUtil.validateToken(authToken, userDetails)) {
		        	    	UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(
		                              userDetails, null, userDetails.getAuthorities());

					        String usertoken=userservice.getToken(useraccount);
					        if(usertoken!=null&&!usertoken.equals("")) {
					        		//验证与数据库内的token的一致性
						        boolean tokenbl=authToken.equals(usertoken);
						        if(tokenbl) {
							        usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
							        		request));
							        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
							        filterChain.doFilter(request, response);
							        return;
						        }
		                    }
				        }
	        	    }		    			  
    		  }else {
    			  ResultUtil.out(response, ResultUtil.resultMap(404,"Token不合法"));
                  //log.info("token 无效.");
    			   throw new UsernameNotFoundException("Token 无效");
              }
    	  
    	  			ResultUtil.out(response, ResultUtil.resultMap(403,"Token不合法"));
    	      
			}

		
	}


