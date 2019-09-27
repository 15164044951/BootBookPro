package com.test.sibo.entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Result {

	
	public HttpServletRequest httpServletRequest;
	public HttpServletResponse httpServletResponse;
	public String errorMsg;
	public String msg;
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}
	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	 @Override
	    public String toString() {
	        return "Result{" +
	                "httpServletRequest=" + httpServletRequest +
	                ", httpServletResponse='" + httpServletResponse + '\'' +
	                ", errorMsg=" + errorMsg +", msg=" + msg+
	                '}';
	    }

}
