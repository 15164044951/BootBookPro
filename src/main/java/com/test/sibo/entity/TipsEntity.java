package com.test.sibo.entity;

/**
 * 提示信息
 * */
public class TipsEntity {
	public int id;
	public int house_id;//房屋ID
	public int customer_id;//客户ID
	public int transaotion_id;//成交id
	public String tips_text;//提示信息
	public int tips_stats;//状态：0：未读，1：已读
	public int tips_typepayment;//0:正常，1：未缴费
	public String tips_time;//创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getTransaotion_id() {
		return transaotion_id;
	}
	public void setTransaotion_id(int transaotion_id) {
		this.transaotion_id = transaotion_id;
	}
	public String getTips_text() {
		return tips_text;
	}
	public void setTips_text(String tips_text) {
		this.tips_text = tips_text;
	}
	public int getTips_stats() {
		return tips_stats;
	}
	public void setTips_stats(int tips_stats) {
		this.tips_stats = tips_stats;
	}
	public int getTips_typepayment() {
		return tips_typepayment;
	}
	public void setTips_typepayment(int tips_typepayment) {
		this.tips_typepayment = tips_typepayment;
	}
	public String getTips_time() {
		return tips_time;
	}
	public void setTips_time(String tips_time) {
		this.tips_time = tips_time;
	}
	
	
}
