package com.usermanagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;

public class AdminDeleteUserAction extends ActionSupport {
	private int id;
	private String tip;
	
	InterUser interUser=new ImplUser();
	List alluserList=interUser.findAllUsers();
	public String execute(){
		InterUser interUser=new ImplUser();
		int count=interUser.deleteUser(id);
		if(count!=0){
			this.setTip("删除普通用户成功");
			if(ActionContext.getContext().getSession().containsKey("alluserList")){
				ActionContext.getContext().getSession().remove("alluserList");
			}
			ActionContext.getContext().getSession().put("alluserList", alluserList);
			return "success";
		}else{
			this.setTip("删除普通用户失败");
			return "failure";
		}
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
}
