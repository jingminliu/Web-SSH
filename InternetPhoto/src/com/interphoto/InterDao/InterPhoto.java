package com.interphoto.InterDao;

import java.io.File;
import java.util.List;

import com.interphoto.Entity.Photo;

public interface InterPhoto 
{
	int uploadPhoto(int folderid,String photoName,String photoPath,String photoInfo);//…œ¥´’’∆¨
    int deletePhoto(int photoid);//…æ≥˝’’∆¨
    List getAllPhoto(int folderid);//‰Ø¿¿’’∆¨
    Photo getPhoto(int photoid);//≤Èø¥’’∆¨œÍœ∏–≈œ¢
    List getPhotoList(int folderid,int page);
    int getTotalPage(int folderid);
}
