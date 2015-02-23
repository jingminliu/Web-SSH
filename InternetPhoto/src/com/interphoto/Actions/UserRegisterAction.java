package com.interphoto.Actions;

import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegisterAction extends ActionSupport
{
	private User user;
	private InterUser interUser;
	public String execute()
	{
	   boolean flag=interUser.ifexistUserName(user.getUserName());
	    if(flag)
	    {
	    	return "input";
	    }
	    interUser.register(user);
		return "success";
	}
	public InterUser getInterUser() {
		return interUser;
	}

	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
