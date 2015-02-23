package com.interphoto.Actions;
import java.util.List;
import com.interphoto.Entity.Folder;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterFolder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class CreateFolderAction extends ActionSupport{
	private Folder folder;
	private InterFolder interFolder;
    public String execute(){
    	User user=(User)ActionContext.getContext().getSession().get("user");
    	interFolder.createFolder(user.getId(),folder);
    	List<Folder> allFolderList=interFolder.getFolderList(user.getId());//查找用户所有相册
    	if(allFolderList.size()==0)
    	{
    		allFolderList=null;
    	}
    	if(ActionContext.getContext().getSession().containsKey("allFolderList"))
    	{
    		ActionContext.getContext().getSession().remove("allFolderList");
    	}
    	ActionContext.getContext().getSession().put("allFolderList",allFolderList);
    	return "success";
    }
	public InterFolder getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(InterFolder interFolder) {
		this.interFolder = interFolder;
	}
	public Folder getFolder() {
		return folder;
	}
	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	

}
