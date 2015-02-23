package com.interphoto.ImplDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BaseDao 
{
	private static Connection con;
	/**
	 * ��������
	 */
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * ������ݿ�����
	 * @return
	 */
	public static Connection getConnection()
	{
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internetphoto?useUnicode=true&characterEncoding=gb2312","root","1111");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	/**
	 * �ر������ݿ������
	 * @param rs
	 * @param ps
	 * @param con
	 */
	public static void cloasAll(ResultSet rs,PreparedStatement ps,Connection con){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}