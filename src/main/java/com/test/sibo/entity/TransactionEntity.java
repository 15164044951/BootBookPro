package com.test.sibo.entity;

/**
 * 成交记录表
 * */
public class TransactionEntity {

	public int id;
	public int house_id;//房屋id
	public int customer_id;//客户id
	public int transaction_type;//成交类型：0：买卖，1：租赁
	public int transaction_rentaltype;//租赁类型：0：代理，1：托管
	public int transaction_maintaintype;//维护类型：0：其他，1：自己的
	public int transaction_rentalstate;//租赁付款类型：0：押一付三，1：押一付一，2:押一付二，3：押三付三，4押一付六，5押一付十二
	public int transaction_price;//成交价格
	public String transaction_startstime;//成交时间
	public String transaction_imgcontract;//成交合同图片
	public int transaction_years;//成交合同年限
	public String transaction_endtime;//成交合同到期时间
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
	public int getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(int transaction_type) {
		this.transaction_type = transaction_type;
	}
	public int getTransaction_rentaltype() {
		return transaction_rentaltype;
	}
	public void setTransaction_rentaltype(int transaction_rentaltype) {
		this.transaction_rentaltype = transaction_rentaltype;
	}
	public int getTransaction_maintaintype() {
		return transaction_maintaintype;
	}
	public void setTransaction_maintaintype(int transaction_maintaintype) {
		this.transaction_maintaintype = transaction_maintaintype;
	}
	public int getTransaction_rentalstate() {
		return transaction_rentalstate;
	}
	public void setTransaction_rentalstate(int transaction_rentalstate) {
		this.transaction_rentalstate = transaction_rentalstate;
	}
	public int getTransaction_price() {
		return transaction_price;
	}
	public void setTransaction_price(int transaction_price) {
		this.transaction_price = transaction_price;
	}
	public String getTransaction_startstime() {
		return transaction_startstime;
	}
	public void setTransaction_startstime(String transaction_startstime) {
		this.transaction_startstime = transaction_startstime;
	}
	public String getTransaction_imgcontract() {
		return transaction_imgcontract;
	}
	public void setTransaction_imgcontract(String transaction_imgcontract) {
		this.transaction_imgcontract = transaction_imgcontract;
	}
	public int getTransaction_years() {
		return transaction_years;
	}
	public void setTransaction_years(int transaction_years) {
		this.transaction_years = transaction_years;
	}
	public String getTransaction_endtime() {
		return transaction_endtime;
	}
	public void setTransaction_endtime(String transaction_endtime) {
		this.transaction_endtime = transaction_endtime;
	}
	
	
	
}
