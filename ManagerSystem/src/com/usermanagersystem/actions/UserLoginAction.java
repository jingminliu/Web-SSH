package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class UserLoginAction extends ActionSupport
{
	private User user;
	private String loginerror;
	
	public String execute()
	{
		InterUser interUser=new ImplUser();
		boolean flag=interUser.login(user);//����ImplUser���login�����ж��û��Ƿ����
		if(flag){
			ActionContext.getContext().getSession().put("user",user);
			return "success";
		}
		this.setLoginerror("�û����������������");
		return "input";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginerror() {
		return loginerror;
	}
	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}
}
