package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class UserModifyAction extends ActionSupport {
	private User userinfo;
	public String execute(){
		InterUser interuser=new ImplUser();
		int id=interuser.getUserid(userinfo.getUsername(), userinfo.getPassword());
		int roleid=interuser.getUserroleId(id);
		userinfo.setId(id);
		userinfo.setRoleId(roleid);
		int count=interuser.modifyUserInfo(userinfo);
		if(count>0){
			return "success";
		}else{
			return "error";
		}
	}
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	
}
