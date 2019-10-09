package com.test.sibo.entity;


/**
 * 付款类（租赁）
 * */
public class LeasePaymentEntitu {
	public int id;
	public int transaontion_id;//成交ID
	public String payment_up;//上次付款时间
	public String payment_down;//下次付款时间
	public int payment_advance;//提前几天付款
	public int payment_datetype;//0：季付，1：半年付，2：年付
	public int payment_priceall;//付款累计金额
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTransaontion_id() {
		return transaontion_id;
	}
	public void setTransaontion_id(int transaontion_id) {
		this.transaontion_id = transaontion_id;
	}
	public String getPayment_up() {
		return payment_up;
	}
	public void setPayment_up(String payment_up) {
		this.payment_up = payment_up;
	}
	public String getPayment_down() {
		return payment_down;
	}
	public void setPayment_down(String payment_down) {
		this.payment_down = payment_down;
	}
	public int getPayment_advance() {
		return payment_advance;
	}
	public void setPayment_advance(int payment_advance) {
		this.payment_advance = payment_advance;
	}
	public int getPayment_datetype() {
		return payment_datetype;
	}
	public void setPayment_datetype(int payment_datetype) {
		this.payment_datetype = payment_datetype;
	}
	public int getPayment_priceall() {
		return payment_priceall;
	}
	public void setPayment_priceall(int payment_priceall) {
		this.payment_priceall = payment_priceall;
	}
	
	
	
}
