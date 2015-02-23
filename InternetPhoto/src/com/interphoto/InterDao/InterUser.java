package com.interphoto.InterDao;

import java.io.File;
import java.util.List;

import com.interphoto.Entity.Folder;
import com.interphoto.Entity.Photo;
import com.interphoto.Entity.User;


public interface InterUser 
{
	int register(User user);//用户注册
	boolean login(User user);//用户登录
	boolean ifexistUserName(String username);//查找是否已存在用户名
	boolean ifexistFriend(int userid,int friendid);//查找是否已存在好友
	int addFriend(int userid,int friendid);//添加好友
	List findAllUsers(int id);//查找系统所有用户
	User selectUserInfo(int id);//查找个人信息
	int  delFriendInfo(int userid,int friend);//删除好友
	List findAllFriends(int userid);//查找所有好友
	int getUserId(String userName,String userPassword);//获得用户id编号
	int modifyUserInfo(User userinfo);


}
