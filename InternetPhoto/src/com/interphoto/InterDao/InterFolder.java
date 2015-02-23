package com.interphoto.InterDao;

import java.util.List;

import com.interphoto.Entity.Folder;

public interface InterFolder
{
	int createFolder(int userid,Folder folder);//创建相册
	int deleteFolder(int folderid);//删除相册
	List<Folder> getFolderList(int userid);//取得用户所有相册
	String getFolderName(int folderid);
	boolean othersIfCanScanFolder(int userid,int friendid,int folderid);
	int getFolderLimit(int folderid);//取的相册权限
}
