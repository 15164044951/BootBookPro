package com.test.sibo.entity;


/**
 * 费用类
 * */
public class CostEntity {
   public int id;
   public int house_id;//房屋ID
   public int cost_number;//费用单号
   public int cost_type;//费用类别0：水费，1：电费，2：煤气费，3：网费，4：暖气费
   public String cost_uptime;//上次缴费时间
   public String cost_downtime;//下次缴费时间
   public int cost_dateinterval;//缴费间隔（月份）
   public int cost_state;//状态0：提示，1：不提示
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
public int getCost_number() {
	return cost_number;
}
public void setCost_number(int cost_number) {
	this.cost_number = cost_number;
}
public int getCost_type() {
	return cost_type;
}
public void setCost_type(int cost_type) {
	this.cost_type = cost_type;
}
public String getCost_uptime() {
	return cost_uptime;
}
public void setCost_uptime(String cost_uptime) {
	this.cost_uptime = cost_uptime;
}
public String getCost_downtime() {
	return cost_downtime;
}
public void setCost_downtime(String cost_downtime) {
	this.cost_downtime = cost_downtime;
}
public int getCost_dateinterval() {
	return cost_dateinterval;
}
public void setCost_dateinterval(int cost_dateinterval) {
	this.cost_dateinterval = cost_dateinterval;
}
public int getCost_state() {
	return cost_state;
}
public void setCost_state(int cost_state) {
	this.cost_state = cost_state;
}
   
   
}
