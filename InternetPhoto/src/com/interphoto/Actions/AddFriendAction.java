package com.interphoto.Actions;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class AddFriendAction extends ActionSupport{
	  private int id;
	  private InterUser interUser;
   public String execute()
   {
    	User user=(User)ActionContext.getContext().getSession().get("user");
    	if(interUser.ifexistFriend(user.getId(),id)){
    	 return "input";
    	}
    	interUser.addFriend(user.getId(),id);
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
