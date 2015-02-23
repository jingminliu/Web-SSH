package com.interphoto.Actions;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionSupport;
public class SelectMyInfoAction extends ActionSupport
{
	private int id;
	private User userinfo;
	private InterUser interUser;	
	public String execute()	{
		this.setUserinfo(interUser.selectUserInfo(id));
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public InterUser getInterUser() {
		return interUser;
	}
	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}
}
