package com.interphoto.ImplDao;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.interphoto.Entity.Photo;
import com.interphoto.InterDao.InterPhoto;

public class ImplPhoto implements InterPhoto {	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * 删除照片
	 */
	public int deletePhoto(int photoid) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		int num=0;
		try {
			ps=con.prepareStatement("delete from t_photo where id=?");
			ps.setInt(1,photoid);
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		return num;
	}
     /**
      * 浏览相册中所有照片
      */
	public List getAllPhoto(int folderid) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		List photoList=new ArrayList();
		try {
			ps=con.prepareStatement("select * from t_photo where folderid=?");
			ps.setInt(1,folderid);
			rs=ps.executeQuery();
			while(rs.next()){
				Photo photo=new Photo();
				photo.setId(rs.getInt(1));
				photo.setPhotoName(rs.getString(2));
				photo.setPhotoPath(rs.getString(3));
				photo.setPhotoInfo(rs.getString(4));
				photo.setCreateTime(rs.getString(5));
				photo.setFolderid(rs.getInt(6));
				photoList.add(photo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		
		return photoList;
	} 
	/**
	 * 上传照片
	 * 
	 * @return
	 */
	public int uploadPhoto(int folderid,String photoName,String photoPath,String photoInfo) {
		// TODO Auto-generated method stub
		int num=0;
		con=BaseDao.getConnection();
		try {
			ps=con.prepareStatement("insert into t_photo values(null,?,?,?,?,?)");
			ps.setString(1,photoName);
			ps.setString(2, photoPath);
			ps.setString(3,photoInfo);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss"); 
			String nowdate=sdf.format(new Date());
			ps.setString(4,nowdate);
			ps.setInt(5,folderid);
			num=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		return num;
	}
    /**
     * 查看相片详情
     */
	public Photo getPhoto(int photoid)
    {
    	con=BaseDao.getConnection();
    	Photo p=null;
    	try {
			ps=con.prepareStatement("select * from t_photo where id=?");
			ps.setInt(1, photoid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				p=new Photo();
				p.setId(rs.getInt(1));
				p.setPhotoName(rs.getString(2));
				p.setPhotoPath(rs.getString(3));
				p.setPhotoInfo(rs.getString(4));
				p.setCreateTime(rs.getString(5));
				p.setFolderid(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
    	return p;
    }
	/**
	 * 获得相册列表
	 */
	public List getPhotoList(int folderid,int page){
		con=BaseDao.getConnection();
		List photoList=new ArrayList();
		try {
			ps=con.prepareStatement("select * from t_photo where folderid=? limit "+2*(page-1)+","+2);
			ps.setInt(1,folderid);
			rs=ps.executeQuery();
			while(rs.next()){
				Photo photo=new Photo();
				photo.setId(rs.getInt(1));
				photo.setPhotoName(rs.getString(2));
				photo.setPhotoPath(rs.getString(3));
				photo.setPhotoInfo(rs.getString(4));
				photo.setCreateTime(rs.getString(5));
				photo.setFolderid(rs.getInt(6));
				photoList.add(photo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		
		return photoList;
	}
	/**
	 * 相册中相片数量
	 */
	public  int getTotalPage(int folderid)
	{
		int totalpage=0;
		int num=0;
		con=BaseDao.getConnection();
		try {
			ps=con.prepareStatement("select count(*) from t_photo where folderid=?");
			ps.setInt(1,folderid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				num=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		if(num>0)
		{
			totalpage=(num%2==0?(num/2):(num/2+1));
		}
		return totalpage;
	}
}
