package com.interphoto.Actions;
import com.interphoto.Entity.Photo;
import com.interphoto.InterDao.InterPhoto;
import com.opensymphony.xwork2.ActionSupport;
public class ScanPhotoAction extends ActionSupport{
	private int id;//查看的相册id
	private int type;
	private int pid;//相片id
	private int pageIndex;//该属性表示当前页数
	private Photo photo;    
	private InterPhoto interPhoto;	
	public String execute(){
		photo=interPhoto.getPhoto(pid);
		if(type==0){
		return "success";
		}else{
			return "others";
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Photo getPhoto() {
			return photo;
	}
	public void setPhoto(Photo photo) {
			this.photo = photo;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public InterPhoto getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(InterPhoto interPhoto) {
		this.interPhoto = interPhoto;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
