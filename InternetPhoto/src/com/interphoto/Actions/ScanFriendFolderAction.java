package com.interphoto.Actions;
import java.util.List;
import com.interphoto.Entity.Folder;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterFolder;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ScanFriendFolderAction extends ActionSupport{
	  private int friendid;
	  private InterFolder interFolder;
	  private InterUser interUser;
      public String execute(){
       User friend=interUser.selectUserInfo(friendid);    	
    	if(ActionContext.getContext().getSession().containsKey("friend")){
    		ActionContext.getContext().getSession().remove("friend");
    	}
    	ActionContext.getContext().getSession().put("friend",friend);
    	List<Folder> allFriendFolderList=interFolder.getFolderList(friendid);//查找用户所有相册
    	if(allFriendFolderList.size()==0)
    	{
    		allFriendFolderList=null;
    	}
    	if(ActionContext.getContext().getSession().containsKey("allFriendFolderList"))
    	{
    		ActionContext.getContext().getSession().remove("allFriendFolderList");
    	}
    	ActionContext.getContext().getSession().put("allFriendFolderList",allFriendFolderList);
    	return "success";
    }
	public InterFolder getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(InterFolder interFolder) {
		this.interFolder = interFolder;
	}
	public InterUser getInterUser() {
		return interUser;
	}
	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}
	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

}
