package com.interphoto.Actions;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionSupport;
public class ScanUserAction extends ActionSupport{
	private int id;
	private User userinfo;	
	private InterUser interUser;
	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String execute()
	{
		this.setUserinfo(interUser.selectUserInfo(id));
		return "success";
	}
	public InterUser getInterUser() {
		return interUser;
	}
}
