package com.test.sibo.adapter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class HttpInterceptor extends HandlerInterceptorAdapter {

		    //private Logger logger = LoggerFactory.getLogger(HttpInterceptor.class);

		    private static final String START_TIME = "requestStartTime";

		    /**
		     * 拦截请求url和请求参数
		     * @param request
		     * @param response
		     * @param handler
		     * @return
		     * @throws Exception
		     */
		    @Override
		    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		        //请求时间和请求参数
		        String url = request.getRequestURI();
		        Map<String, String[]> parameterMap = request.getParameterMap();
		        long start = System.currentTimeMillis();
		        System.out.println(url+":::::::::::::::"+parameterMap.toString());
		       //为了方便所以new 了一个ObjectMapper,建议不要这么做,做成单例调用即可
		        //logger.info("request start | url : [{}], params : [{}]", url, new ObjectMapper().writeValueAsString(parameterMap));
		        //放入请求初始时间
		        request.setAttribute(START_TIME, start);
		        return true;
		    }


		    @Override
		    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		    }

		    /**
		     * 请求结束后，计算url花费时间
		     * @param request
		     * @param response
		     * @param handler
		     * @param ex
		     * @throws Exception
		     */
		    @Override
		    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		        String url  = request.getRequestURI();
		        long start = (long) request.getAttribute(START_TIME);
		        long end = System.currentTimeMillis();
		        long costTime = end - start;
		        //logger.info("request finished | url : [{}], costTime : [{}] ms ", url, costTime);
		    }
}
