package com.interphoto.InterDao;

import java.util.List;

import com.interphoto.Entity.Comment;

public interface InterComment 
{
	int addComment(int photoid,int folderid,int friendid,int userid,String content);//发表评论
	int delComment(int cmmentid);//删除评论
	Comment getComment(int commentid);//查看评论
	List getAllComments(int userid);//查看个人所有好友评论
	 int updateCommentStatu(int userid);//修改评论信息的状态

}
