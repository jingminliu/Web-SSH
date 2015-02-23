package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.entity.User;

public class IfCanAddAdmin extends ActionSupport 
{
	private String tip;
	public String execute()
	{
		User user=(User)ActionContext.getContext().getSession().get("user");
	    if(user.getRoleId()==0)
	    {
	    	this.setTip("��ǰ�û�Ϊ��ͨ�û�,���Գ�������Ա��ݵ�¼������蹦��");
	    	return "failure";
	    }
	    else if(user.getRoleId()==1)
	    {
	    	this.setTip("��ǰ�û�Ϊ����Ա,���Գ�������Ա��ݵ�¼������蹦��");
	    	return "failure";
	    }
		return "success";
	}
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}



}
