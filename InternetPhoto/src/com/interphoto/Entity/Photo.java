package com.interphoto.Entity;

import java.sql.Blob;
import java.util.Date;

public class Photo 
{
	private int id;//��Ƭ���id
	private String createTime;//����ʱ��
	private String photoName;//��Ƭ����
	private String photoInfo;//��Ƭ˵��
	private String photoPath;//��Ƭ·��
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	private int folderid;//���id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhotoInfo() {
		return photoInfo;
	}
	public void setPhotoInfo(String photoInfo) {
		this.photoInfo = photoInfo;
	}
	public int getFolderid() {
		return folderid;
	}
	public void setFolderid(int folderid) {
		this.folderid = folderid;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	

}
