package com.interphoto.Entity;

public class Folder
{
	private int id;//相册编号id
	private String folderName;//相册名称
	private String folderInfo;//相册说明
	private int limit;//相册访问权限
	private int userId;//用户id
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolderInfo() {
		return folderInfo;
	}
	public void setFolderInfo(String folderInfo) {
		this.folderInfo = folderInfo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
