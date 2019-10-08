package com.test.sibo.entity;

/**
 * 客户
 * */
public class CustomerEntity {
	
	public int customer_id;//客户id
	public String customer_name;//客户姓名	
	public int customer_type;//客户类型0：买，1：租
	public String customer_phone;//客户电话
	public String customer_details;//客户需求条件
	public int customer_state;//0:未买，或租。1：已买已租
	public int customer_fast;//客户紧急情况0:不急，1：急
	public int customer_price;//客户需求价位
	public String customer_optime;//上次更新时间	
	public String customer_starttime;//创建时间
	public String customer_searchtext;//搜索条件
	public String customer_pricetext;//客源价位文本
	public int customer_deletetype;//显示信息0：可显示，1：不显示
	
	
	public int getCustomer_deletetype() {
		return customer_deletetype;
	}
	public void setCustomer_deletetype(int customer_deletetype) {
		this.customer_deletetype = customer_deletetype;
	}
	public String getCustomer_pricetext() {
		return customer_pricetext;
	}
	public void setCustomer_pricetext(String customer_pricetext) {
		this.customer_pricetext = customer_pricetext;
	}
	public String getCustomer_searchtext() {
		return customer_searchtext;
	}
	public void setCustomer_searchtext(String customer_searchtext) {
		this.customer_searchtext = customer_searchtext;
	}
	public String getCustomer_optime() {
		return customer_optime;
	}
	public void setCustomer_optime(String customer_optime) {
		this.customer_optime = customer_optime;
	}
	public String getCustomer_starttime() {
		return customer_starttime;
	}
	public void setCustomer_starttime(String customer_starttime) {
		this.customer_starttime = customer_starttime;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(int customer_type) {
		this.customer_type = customer_type;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_details() {
		return customer_details;
	}
	public void setCustomer_details(String customer_details) {
		this.customer_details = customer_details;
	}
	public int getCustomer_state() {
		return customer_state;
	}
	public void setCustomer_state(int customer_state) {
		this.customer_state = customer_state;
	}
	public int getCustomer_fast() {
		return customer_fast;
	}
	public void setCustomer_fast(int customer_fast) {
		this.customer_fast = customer_fast;
	}
	public int getCustomer_price() {
		return customer_price;
	}
	public void setCustomer_price(int customer_price) {
		this.customer_price = customer_price;
	}
	

}
