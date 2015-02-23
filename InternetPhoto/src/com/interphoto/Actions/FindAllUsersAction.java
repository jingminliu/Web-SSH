package com.interphoto.Actions;
import java.util.List;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class FindAllUsersAction extends ActionSupport{
	private int id;//用户id
	private InterUser interUser;
	public String execute()	{
		List allUserList=interUser.findAllUsers(id);//查找所有用户
		 if(allUserList.size()==0)
		 {
			 allUserList=null;
		  }
		 if(ActionContext.getContext().getSession().containsKey("allUserList"))
		 {
			ActionContext.getContext().getSession().remove("allUserList");
		 }
		ActionContext.getContext().getSession().put("allUserList",allUserList);
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InterUser getInterUser() {
		return interUser;
	}
	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}
}
