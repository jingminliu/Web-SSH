package com.interphoto.Actions;
import java.util.List;
import com.interphoto.Entity.Folder;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterFolder;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserLoginAction extends ActionSupport
{
	private User user;
	InterUser interUser;
	InterFolder interFolder;
	public String execute(){
	  	boolean flag=interUser.login(user);
	  	if(flag){
	        int userid=interUser.getUserId(user.getUserName(),user.getUserPassword());	  		
	  		List allFriendList=interUser.findAllFriends(userid);//查找用户所有好友
	  		List<Folder> allFolderList=interFolder.getFolderList(userid);//查找用户所有相册
	  		ActionContext.getContext().getSession().put("user",user);
	  		if(allFolderList.size()==0){
	  			allFolderList=null;
	  		}
	  		if(allFriendList.size()==0)
	  		{
	  			allFriendList=null;
	  		}
	  		ActionContext.getContext().getSession().put("allFriendList",allFriendList);
	  		ActionContext.getContext().getSession().put("allFolderList",allFolderList);
	  		return "success";
	  	}
	  return "input";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public InterUser getInterUser() {
		return interUser;
	}
	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}
	public InterFolder getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(InterFolder interFolder) {
		this.interFolder = interFolder;
	}
}
