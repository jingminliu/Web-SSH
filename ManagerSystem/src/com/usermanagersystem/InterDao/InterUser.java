package com.usermanagersystem.InterDao;

import java.util.List;

import com.usermanagersystem.entity.User;

public interface InterUser {
	int addUser(User user);
	boolean login(User user);
	User selectUserInfo(int id);
	List findAllUsers();
	List findNewUsers();
	int modifyUserInfo(User user);
	int deleteUser(int id);
	List findAllAdmins();
	int addAdmin(User user);
	int getUserid(String username,String password);
	int getUserroleId(int id);
	boolean isExistUsername(String username);
}
