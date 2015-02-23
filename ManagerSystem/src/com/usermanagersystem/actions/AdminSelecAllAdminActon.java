package com.usermanagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class AdminSelecAllAdminActon extends ActionSupport {
	private String tip;
	public String getTip(){
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String execute(){
		User user=(User)ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0){
			this.setTip("��ǰ�û�Ϊ��ͨ�û�,���Թ���Ա��ݵ�¼������蹦��");
			return "failure";
		}
		else{
			InterUser interUser=new ImplUser();
			List allAdminList=interUser.findAllAdmins();
			ActionContext.getContext().getSession().put("allAdminList", allAdminList);
			if(user.getRoleId()==1){
				return "smalladmin";
			}else{
				return "bigadmin";
			}
		}
	}
}
