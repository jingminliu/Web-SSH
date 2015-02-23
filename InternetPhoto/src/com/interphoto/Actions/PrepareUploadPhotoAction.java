package com.interphoto.Actions;
import java.util.List;
import com.interphoto.Entity.Folder;
import com.interphoto.InterDao.InterFolder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class PrepareUploadPhotoAction extends ActionSupport{
	private int id;
    private String folderName;
	private InterFolder interFolder;
	public String execute(){

	   this.setFolderName(interFolder.getFolderName(id));
	   if(folderName!=null) {
			  return "success";
		  }			
			return "input";		
	}
	public InterFolder getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(InterFolder interFolder) {
		this.interFolder = interFolder;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
