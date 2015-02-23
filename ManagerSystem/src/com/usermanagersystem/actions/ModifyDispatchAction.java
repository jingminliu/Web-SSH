package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class ModifyDispatchAction extends ActionSupport {
	private User userinfo;
	private int id;
	
	public String execute(){
		InterUser interuser=new ImplUser();
		User user=(User)ActionContext.getContext().getSession().get("user");
		
			if(id!=0){
				this.setUserinfo(interuser.selectUserInfo(id));
				return "othersmodify";
			}else{
				this.setUserinfo(user);
				return "usermodify";
			}
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
}
