package com.interphoto.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.interphoto.Entity.Folder;
import com.interphoto.InterDao.InterFolder;
import com.interphoto.InterDao.InterUser;

public class ImplFolder implements InterFolder {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
    private InterUser interUser;

	/**
	 * 创建相册
	 */
	public int createFolder(int userid,Folder folder) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		int num=0;
		try {
			ps=con.prepareStatement("insert into t_folder values(null,?,?,?,?)");
			ps.setString(1,folder.getFolderName());
			ps.setString(2,folder.getFolderInfo());
			ps.setInt(3,folder.getLimit());
			ps.setInt(4,userid);
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);//关闭数据库的连接
		}
		return num;
	}
    /**
     * 删除相册
     */
	public int deleteFolder(int folderid) {
		// TODO Auto-generated method stub
		int num=0;
		con=BaseDao.getConnection();
		try {
			ps=con.prepareStatement("delete from t_photo where folderid=?");
			ps.setInt(1,folderid);
			num=ps.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("delete from t_folder where id=?");
			ps2.setInt(1,folderid);
			num=ps2.executeUpdate();
			ps2.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.cloasAll(rs, ps, con);
		}		
		return num;
	}
	/**
	 * 取得用户所有相册
	 */
	public List<Folder> getFolderList(int userid){
		
		List<Folder> folderList=new ArrayList();
		con=BaseDao.getConnection();
		try {
			ps=con.prepareStatement("select * from t_folder where userid=?");
			ps.setInt(1,userid);
			rs=ps.executeQuery();
			while(rs.next()){
				Folder folder=new Folder();
				folder.setId(rs.getInt(1));
				folder.setFolderName(rs.getString(2));
				folder.setFolderInfo(rs.getString(3));
				folder.setLimit(rs.getInt(4));
				folder.setUserId(rs.getInt(5));
				folderList.add(folder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		return folderList;
	}
	/**
	 * 查找相册名称
	 */
   public String getFolderName(int folderid)
   {
	   con=BaseDao.getConnection();
	   String foldername="";
	   try {
		ps=con.prepareStatement("select folderName from t_folder where id=?");
		ps.setInt(1,folderid);
		rs=ps.executeQuery();
		if(rs.next())
		{
			foldername=rs.getString(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		BaseDao.cloasAll(rs, ps, con);
	}
	   return foldername;
   }
   /**
    * 取得相册访问权限字段值
    */
   public int getFolderLimit(int folderid)
   {
	  con=BaseDao.getConnection();//得到数据库连接
	  int limit=0;
	  try {
		ps=con.prepareStatement("select limitid from t_folder where id=?");
		ps.setInt(1,folderid);
		rs=ps.executeQuery();
		if(rs.next()){
			limit=rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		BaseDao.cloasAll(rs, ps, con);
	}
	return limit;
   }
   /**
    * 判断用户是否有权限浏览相册
    */
   public boolean othersIfCanScanFolder(int userid,int friendid,int folderid)
   {
	   int limit=this.getFolderLimit(folderid);
	   boolean flag=false;
	   if(limit==2)
	   {
		  flag=false;
	   }else if(limit==1){
		   if(interUser.ifexistFriend(userid, friendid)){
			   flag=true;
		   }else {
			   flag=false;
		   }	   
	   }else{
		   flag=true;
	   }	   
	   return flag;
   }
   public InterUser getInterUser() {
		return interUser;
	}
	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}
}
