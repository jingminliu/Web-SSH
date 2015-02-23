package com.interphoto.Actions;
import com.interphoto.Entity.Photo;
import com.interphoto.InterDao.InterPhoto;
import com.opensymphony.xwork2.ActionSupport;
public class PrepareCommentAction extends ActionSupport
{
	private int id;//œ‡∆¨id
	private Photo photo;	
	private InterPhoto interPhoto;	
	public String execute(){
		photo=interPhoto.getPhoto(id);
		return "success";		
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InterPhoto getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(InterPhoto interPhoto) {
		this.interPhoto = interPhoto;
	}

}
