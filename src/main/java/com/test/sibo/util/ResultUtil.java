package com.test.sibo.util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletResponse;

import com.alibaba.fastjson.JSON;

public class ResultUtil {

	
	   public static void out(ServletResponse response, Map<String, Object> resultMap){

	        PrintWriter out = null;
	        try {
	            response.setCharacterEncoding("UTF-8");
	            response.setContentType("application/json");
	            out = response.getWriter();
	            out.println(JSON.toJSONString(resultMap));
	        } catch (Exception e) {
	            
	        }finally{
	            if(out!=null){
	                out.flush();
	                out.close();
	            }
	        }
	    }

	    public static Map<String, Object> resultMap(Integer code, String msg){
	        Map<String, Object> resultMap = new HashMap<String, Object>();
	        resultMap.put("message", msg);
	        resultMap.put("status", code);
	        return resultMap;
	    }

	    public static Map<String, Object> resultMap( Integer status, String msg, Object data){
	        Map<String, Object> resultMap = new HashMap<String, Object>();
	        resultMap.put("message", msg);
	        resultMap.put("status", status);
	        resultMap.put("data", data);
	        return resultMap;
	    }
	
	

}
