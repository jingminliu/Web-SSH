package com.interphoto.Entity;

import java.sql.Timestamp;

public class User 
{
	private int id; //�û����Id
	private String userName;//�û���
	private String userPassword;//�û�����	
	private String sex;//�û��Ա�
	private Timestamp birthday;//����
	private String telephone;//�绰
	private String email;//����
	private String address;//��ַ
	private String remark;//���
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
