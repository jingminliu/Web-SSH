package com.interphoto.Entity;

public class Folder
{
	private int id;//�����id
	private String folderName;//�������
	private String folderInfo;//���˵��
	private int limit;//������Ȩ��
	private int userId;//�û�id
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
