package com.interphoto.Actions;
import com.interphoto.Entity.Photo;
import com.interphoto.InterDao.InterPhoto;
import com.opensymphony.xwork2.ActionSupport;
public class ScanPhotoAction extends ActionSupport{
	private int id;//�鿴�����id
	private int type;
	private int pid;//��Ƭid
	private int pageIndex;//�����Ա�ʾ��ǰҳ��
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
