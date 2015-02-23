package com.interphoto.InterDao;

import java.io.File;
import java.util.List;

import com.interphoto.Entity.Folder;
import com.interphoto.Entity.Photo;
import com.interphoto.Entity.User;


public interface InterUser 
{
	int register(User user);//�û�ע��
	boolean login(User user);//�û���¼
	boolean ifexistUserName(String username);//�����Ƿ��Ѵ����û���
	boolean ifexistFriend(int userid,int friendid);//�����Ƿ��Ѵ��ں���
	int addFriend(int userid,int friendid);//��Ӻ���
	List findAllUsers(int id);//����ϵͳ�����û�
	User selectUserInfo(int id);//���Ҹ�����Ϣ
	int  delFriendInfo(int userid,int friend);//ɾ������
	List findAllFriends(int userid);//�������к���
	int getUserId(String userName,String userPassword);//����û�id���
	int modifyUserInfo(User userinfo);


}
