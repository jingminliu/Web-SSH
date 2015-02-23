package com.interphoto.Actions;
import java.util.List;
import com.interphoto.Entity.User;
import com.interphoto.ImplDao.ImplComment;
import com.interphoto.InterDao.InterComment;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class GetNewCommentAction  extends ActionSupport{
	private InterComment interComment;
	public String execute()
	{
		User user=(User)ActionContext.getContext().getSession().get("user");
		List commentList=interComment.getAllComments(user.getId());
		if(commentList.size()==0){
			commentList=null;
		}
		if(ActionContext.getContext().getSession().containsKey("commentList")){
			ActionContext.getContext().getSession().remove("commentList");
		}
		ActionContext.getContext().getSession().put("commentList",commentList);
		return "success";
	}
	public InterComment getInterComment() {
		return interComment;
	}
	public void setInterComment(InterComment interComment) {
		this.interComment = interComment;
	}
}
