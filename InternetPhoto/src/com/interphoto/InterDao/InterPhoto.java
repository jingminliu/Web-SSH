package com.interphoto.InterDao;

import java.io.File;
import java.util.List;

import com.interphoto.Entity.Photo;

public interface InterPhoto 
{
	int uploadPhoto(int folderid,String photoName,String photoPath,String photoInfo);//�ϴ���Ƭ
    int deletePhoto(int photoid);//ɾ����Ƭ
    List getAllPhoto(int folderid);//�����Ƭ
    Photo getPhoto(int photoid);//�鿴��Ƭ��ϸ��Ϣ
    List getPhotoList(int folderid,int page);
    int getTotalPage(int folderid);
}
