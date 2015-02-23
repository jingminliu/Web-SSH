package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class AdminScanAction extends ActionSupport 
{
	private int id;//���ڽ��մ�ҳ�洫����id����
	private User userinfo;//��ҳ��ֱ�Ӵ�������
	
	public String execute()
	{
		
		InterUser interUser=new ImplUser();
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

}
