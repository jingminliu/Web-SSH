package com.interphoto.InterDao;

import java.util.List;

import com.interphoto.Entity.Comment;

public interface InterComment 
{
	int addComment(int photoid,int folderid,int friendid,int userid,String content);//��������
	int delComment(int cmmentid);//ɾ������
	Comment getComment(int commentid);//�鿴����
	List getAllComments(int userid);//�鿴�������к�������
	 int updateCommentStatu(int userid);//�޸�������Ϣ��״̬

}
