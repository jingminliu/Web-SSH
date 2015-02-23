package com.interphoto.Actions;
import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterComment;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class AddCommentAction extends ActionSupport{
	private int id;
	private int folderid;
	private String content;
	private InterComment interComment;
	public String execute(){
		User friend=(User)ActionContext.getContext().getSession().get("friend");
		User user=(User)ActionContext.getContext().getSession().get("user");
		interComment.addComment(id, folderid,user.getId(),friend.getId(), content);
		return "success";
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFolderid() {
		return folderid;
	}
	public void setFolderid(int folderid) {
		this.folderid = folderid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public InterComment getInterComment() {
		return interComment;
	}
	public void setInterComment(InterComment interComment) {
		this.interComment = interComment;
	}

}
