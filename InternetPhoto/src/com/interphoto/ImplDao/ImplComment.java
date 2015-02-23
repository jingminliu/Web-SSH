package com.interphoto.ImplDao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.interphoto.Entity.Comment;
import com.interphoto.InterDao.InterComment;

public class ImplComment implements InterComment {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * 添加评论
	 */
	public int addComment(int photoid,int folderid,int friendid,int userid,String content) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		int num=0;
		try {
			ps=con.prepareStatement("insert into t_comment values(null,?,?,?,?,?,?,?)");
			ps.setInt(1,photoid);
			ps.setInt(2,folderid);
			ps.setInt(3,friendid);
			ps.setInt(4,userid);
			ps.setString(5,content);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
			ps.setString(6,sdf.format(new Date()));
			ps.setInt(7,0);
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
     *删除评论
     */
	public int delComment(int cmmentid) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		int num=0;
		try {
			ps=con.prepareStatement("delete from t_comment where id=?");
			ps.setInt(1,cmmentid);
		    num=ps.executeUpdate();	
		 }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }finally{
			BaseDao.cloasAll(rs, ps, con);
	   	}
		return num;
	}
    /**
     * 浏览评论
     */
	public List getAllComments(int userid) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		List commentList=new ArrayList();
		try{
			ps=con.prepareStatement("select * from t_comment where userid=? and status=0");
			ps.setInt(1,userid);
			rs=ps.executeQuery();
			while(rs.next()){
			   Comment comment=new Comment();
			   comment.setId(rs.getInt(1));
			   comment.setPhotoid(rs.getInt(2));
			   comment.setFolderid(rs.getInt(3));
			   comment.setFriendid(rs.getInt(4));
			   comment.setUserid(rs.getInt(5));
			   comment.setContent(rs.getString(6));
			   comment.setContentTime(rs.getString(7));
			   comment.setStatus(rs.getInt(8));
			   commentList.add(comment);
			 }
		    }
		  catch (SQLException e) {
			  e.printStackTrace();
		    }
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		return commentList;
	}
    /**
     * 查看评论
     */
	public Comment getComment(int commentid) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		Comment comment=null;
		try{
			ps=con.prepareStatement("select * from t_comment where id=?");
			ps.setInt(1,commentid);
		    rs=ps.executeQuery();
		    if(rs.next()){
		    	comment=new Comment();
		    	   comment.setId(rs.getInt(1));
				   comment.setPhotoid(rs.getInt(2));
				   comment.setFolderid(rs.getInt(3));
				   comment.setFriendid(rs.getInt(4));
				   comment.setUserid(rs.getInt(5));
				   comment.setContent(rs.getString(6));
				   comment.setContentTime(rs.getString(7));
				   comment.setStatus(rs.getInt(8));
		    }
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally
	    {
	    	BaseDao.cloasAll(rs, ps, con);
	    }
		return comment;
	}
    /**
     * 修改评论状态
     */
	public int updateCommentStatu(int id){
	  con=BaseDao.getConnection();
	  int num=0;
	  try {
		ps=con.prepareStatement("update t_comment set status=1 where id=?");
		ps.setInt(1, id);
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
}
