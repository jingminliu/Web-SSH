package com.interphoto.Actions;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionSupport;
public class ModifyUserAction extends ActionSupport 
{ 
	private User userinfo;
    private InterUser interUser;
	public String execute()	{
		int id=interUser.getUserId(userinfo.getUserName(),userinfo.getUserPassword());
		userinfo.setId(id);
		interUser.modifyUserInfo(userinfo);
		return "success";
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
