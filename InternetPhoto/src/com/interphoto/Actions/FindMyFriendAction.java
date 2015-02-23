package com.interphoto.Actions;
import java.util.List;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class FindMyFriendAction extends ActionSupport {
	private int id;
    private InterUser interUser;
	public String execute()	{
		List myFriendsList=interUser.findAllFriends(id);
		if(myFriendsList.size()==0){
			myFriendsList=null;
		}
		if(ActionContext.getContext().getSession().containsKey("myFriendsList")){
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
