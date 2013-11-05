package org.soap.entity;

import java.io.Serializable;


public class Recharge implements Serializable{

	private int sn;
	private String user_sn ;
	private String user_name ;
	private String user_id;
	private String admin_user_name;
	private int Recharge_count;
	private String remark;
	private String insert_time;
	private int gotMoney;
	private int ownMoney;
	private String gotMoneyTime;
	private String finace_remark;
	private String clearOwnMoneyPerson;
	private String clearOwnMoneyTime;
	private int clear_status;
	public int getClear_status() {
		return clear_status;
	}
	public void setClear_status(int clearStatus) {
		clear_status = clearStatus;
	}
	private int    user_balance;
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}


	public int getUser_balance() {
		return user_balance;
	}
	public void setUser_balance(int userBalance) {
		user_balance = userBalance;
	}

	public String getUser_sn() {
		return user_sn;
	}
	public void setUser_sn(String userSn) {
		user_sn = userSn;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	public String getAdmin_user_name() {
		return admin_user_name;
	}
	public void setAdmin_user_name(String adminUserName) {
		admin_user_name = adminUserName;
	}
	public int getRecharge_count() {
		return Recharge_count;
	}
	public void setRecharge_count(int rechargeCount) {
		Recharge_count = rechargeCount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insertTime) {
		insert_time = insertTime;
	}

	public int getGotMoney() {
		return gotMoney;
	}
	public void setGotMoney(int gotMoney) {
		this.gotMoney = gotMoney;
	}
	public int getOwnMoney() {
		return ownMoney;
	}
	public void setOwnMoney(int ownMoney) {
		this.ownMoney = ownMoney;
	}
	public String getGotMoneyTime() {
		return gotMoneyTime;
	}
	public void setGotMoneyTime(String gotMoneyTime) {
		this.gotMoneyTime = gotMoneyTime;
	}
	public String getFinace_remark() {
		return finace_remark;
	}
	public void setFinace_remark(String finaceRemark) {
		finace_remark = finaceRemark;
	}

	public String getClearOwnMoneyPerson() {
		return clearOwnMoneyPerson;
	}
	public void setClearOwnMoneyPerson(String clearOwnMoneyPerson) {
		this.clearOwnMoneyPerson = clearOwnMoneyPerson;
	}
	public String getClearOwnMoneyTime() {
		return clearOwnMoneyTime;
	}
	public void setClearOwnMoneyTime(String clearOwnMoneyTime) {
		this.clearOwnMoneyTime = clearOwnMoneyTime;
	}
}
