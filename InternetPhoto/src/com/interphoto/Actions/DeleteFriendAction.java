package com.interphoto.Actions;
import java.util.List;
import com.interphoto.Entity.User;
import com.interphoto.ImplDao.ImplUser;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class DeleteFriendAction extends ActionSupport
{
	private int id;
	private InterUser interUser;
	public String execute(){
    	User user=(User)ActionContext.getContext().getSession().get("user");
    	interUser.delFriendInfo(user.getId(),id);
    	List myFriendsList=interUser.findAllFriends(user.getId());
		if(myFriendsList.size()==0)
		{
			myFriendsList=null;
		}
		if(ActionContext.getContext().getSession().containsKey("myFriendsList"))
		{
		   ActionContext.getContext().getSession().remove("myFriendsList");	
		}
		ActionContext.getContext().getSession().put("myFriendsList",myFriendsList);
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
