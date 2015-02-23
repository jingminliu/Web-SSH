package com.interphoto.InterDao;

import java.util.List;

import com.interphoto.Entity.Folder;

public interface InterFolder
{
	int createFolder(int userid,Folder folder);//�������
	int deleteFolder(int folderid);//ɾ�����
	List<Folder> getFolderList(int userid);//ȡ���û��������
	String getFolderName(int folderid);
	boolean othersIfCanScanFolder(int userid,int friendid,int folderid);
	int getFolderLimit(int folderid);//ȡ�����Ȩ��
}
