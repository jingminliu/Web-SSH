package com.interphoto.Entity;

import java.sql.Timestamp;

public class User 
{
	private int id; //用户编号Id
	private String userName;//用户名
	private String userPassword;//用户密码	
	private String sex;//用户性别
	private Timestamp birthday;//生日
	private String telephone;//电话
	private String email;//邮箱
	private String address;//地址
	private String remark;//简介
	public String getAddress() {
		return address;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public String getRemark() {
		return remark;
	}
	public String getSex() {
		return sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


}
