package com.interphoto.Actions;
import java.util.List;
import com.interphoto.Entity.Folder;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterFolder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class DeleteFolderAction extends ActionSupport{
	private int id;
	private InterFolder interFolder;
	public String execute()	{
		int num=interFolder.deleteFolder(id);
		if(num>0){
			User user=(User)ActionContext.getContext().getSession().get("user");
			List<Folder> allFolderList=interFolder.getFolderList(user.getId());//查找用户所有相册
			if(allFolderList.size()==0){
				allFolderList=null;
			}
			if(ActionContext.getContext().getSession().containsKey("allFolderList")){
				ActionContext.getContext().getSession().remove("allFolderList");
			}
			ActionContext.getContext().getSession().put("allFolderList",allFolderList);			
		}		
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public InterFolder getInterFolder() {
		return interFolder;
	}

	public void setInterFolder(InterFolder interFolder) {
		this.interFolder = interFolder;
	}
	

}
