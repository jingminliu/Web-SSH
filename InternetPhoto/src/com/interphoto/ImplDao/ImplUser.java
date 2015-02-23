package com.interphoto.ImplDao;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.interphoto.Entity.Folder;
import com.interphoto.Entity.Photo;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterUser;
public class ImplUser implements InterUser {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
/**
 * 查找用户编号id
 */
  public int getUserId(String userName,String userPassword)
	{
	    con=BaseDao.getConnection();
	    int id=0;
	    try {
			ps=con.prepareStatement("select id from t_user where userName=? and userPassword=?");
			ps.setString(1, userName);
			ps.setString(2,userPassword);
			rs=ps.executeQuery();
			if(rs.next())
			{
			  id=rs.getInt(1);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		return id;
	}
	/**
	 * 添加好友
	 */
	public int addFriend(int userid,int friendid) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();//获得数据库连接
		int num=0;
		try {
			ps=con.prepareStatement("insert into t_friend values(null,?,?)");
			ps.setInt(1, userid);
			ps.setInt(2,friendid);
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
    * 检查用户名是否已存在
    */
	public boolean ifexistUserName(String username) {
		// TODO Auto-generated method stub
		
		con=BaseDao.getConnection();
		boolean flag=false;
        try {
			ps=con.prepareStatement("select * from t_user where userName=?");
			ps.setString(1,username);
			rs=ps.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}       
		return flag;
	}
   /**
    * 用户登录功能
    */
	public boolean login(User user) {
		// TODO Auto-generated method stub
    	con=BaseDao.getConnection();//获得数据库连接
		boolean flag=false;
		try {
			ps=con.prepareStatement("select * from t_user where userName=? and userPassword=?");
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getUserPassword());
			rs=ps.executeQuery();
			if(rs.next())
			{
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setBirthday(rs.getTimestamp(5));
				user.setTelephone(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setRemark(rs.getString(9));
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);//关闭数据库的连接
		}
		return flag;
	}
   /**
    * 用户注册功能
    */
	public int register(User user) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		int num=0;
		try {
			ps=con.prepareStatement("insert into t_user values(null,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getUserName());
			ps.setString(2,user.getUserPassword());
			ps.setString(3,user.getSex());
			ps.setTimestamp(4,user.getBirthday());
			ps.setString(5, user.getTelephone());
			ps.setString(6,user.getEmail());
			ps.setString(7,user.getAddress());
			ps.setString(8,user.getRemark());
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
    * 查找系统所有用户
    */
	public List findAllUsers(int id)
    {
    	List userList=new ArrayList();
    	con=BaseDao.getConnection();
    	try {
			ps=con.prepareStatement("select * from t_user where id!=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				  User user=new User();
				  user.setId(rs.getInt(1));
		          user.setUserName(rs.getString(2));
		          user.setUserPassword(rs.getString(3));
		          user.setSex(rs.getString(4));
		          user.setBirthday(rs.getTimestamp(5));
		          user.setTelephone(rs.getString(6));
		          user.setEmail(rs.getString(7));
		          user.setAddress(rs.getString(8));
		          user.setRemark(rs.getString(9));
			      userList.add(user);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{
    		BaseDao.cloasAll(rs, ps, con);
    	}   	
    	return userList;
    }
	/**
	 * 查找个人信息
	 */
    public User selectUserInfo(int id)
    {
    	User user=new User();
    	con=BaseDao.getConnection();
    	try {
			ps=con.prepareStatement("select * from t_user where id=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				  user.setId(rs.getInt(1));
		          user.setUserName(rs.getString(2));
		          user.setUserPassword(rs.getString(3));
		          user.setSex(rs.getString(4));
		          user.setBirthday(rs.getTimestamp(5));
		          user.setTelephone(rs.getString(6));
		          user.setEmail(rs.getString(7));
		          user.setAddress(rs.getString(8));
		          user.setRemark(rs.getString(9));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
 
    	return user;
    }
    /**
     * 查找是否已存在此好友
     */
    public boolean ifexistFriend(int userid,int friendid)
    {
    	con=BaseDao.getConnection();
    	boolean flag=false;
    	try {
			ps=con.prepareStatement("select * from t_friend where userid=?&&friendid=?||userid=?&&friendid=?");
		    ps.setInt(1,userid);
			ps.setInt(2,friendid);
			ps.setInt(3,friendid);
			ps.setInt(4,userid);
			rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
    	return flag;
    }
    /**
     * 删除好友
     */
    public int  delFriendInfo(int userid,int friendid)
    {
    	con=BaseDao.getConnection();
    	int num=0;
    	try {
			ps=con.prepareStatement("delete from t_friend where userid=? and friendid=?");
			ps.setInt(1,userid);
			ps.setInt(2,friendid);
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
     * 查看用户所有好友	
     */
    public List findAllFriends(int userid){
    	con=BaseDao.getConnection();
    	List friendList=new ArrayList();
    	try {
			ps=con.prepareStatement("select * from t_user where id in(select friendid from t_friend where userid=?)||id in (SELECT userid from t_friend where friendid=?)");
			ps.setInt(1,userid);
			ps.setInt(2, userid);
			rs=ps.executeQuery();
			while(rs.next()){
				  User user=new User();
				  user.setId(rs.getInt(1));
		          user.setUserName(rs.getString(2));
		          user.setUserPassword(rs.getString(3));
		          user.setSex(rs.getString(4));
		          user.setBirthday(rs.getTimestamp(5));
		          user.setTelephone(rs.getString(6));
		          user.setEmail(rs.getString(7));
		          user.setAddress(rs.getString(8));
		          user.setRemark(rs.getString(9));
		          friendList.add(user);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
    	return friendList;
    }
    /**
     * 修改用户信息
     */
    public int modifyUserInfo(User userinfo){
    	con=BaseDao.getConnection();
    	int num=0;
    	try {
			ps=con.prepareStatement("update t_user set userName=?,userPassword=?,sex=?,birthday=?,"
					+"telephone=?,email=?,address=?,remark=? where id=?");
			ps.setString(1,userinfo.getUserName());
			ps.setString(2,userinfo.getUserPassword());
			ps.setString(3,userinfo.getSex());
			ps.setTimestamp(4,userinfo.getBirthday());
			ps.setString(5,userinfo.getTelephone());
			ps.setString(6,userinfo.getEmail());
			ps.setString(7,userinfo.getAddress());
			ps.setString(8,userinfo.getRemark());
			ps.setInt(9,userinfo.getId());
			num=ps.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
		return num;
    }
}
