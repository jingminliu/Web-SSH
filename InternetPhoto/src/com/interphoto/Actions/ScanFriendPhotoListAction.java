package com.interphoto.Actions;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.interphoto.Entity.User;
import com.interphoto.InterDao.InterFolder;
import com.interphoto.InterDao.InterPhoto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ScanFriendPhotoListAction extends ActionSupport
{
	private int id;
	private InterPhoto interPhoto;
	private InterFolder interFolder;	
	private int totalPage;//该属性表示总页数
	private int pageIndex;//该属性表示当前页数
	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String pageNumber=request.getParameter("pageIndex");
		totalPage=interPhoto.getTotalPage(id);
		if(totalPage==0){
			pageIndex=1;
		}else{
		  if(pageNumber==null||pageNumber.trim().equals("")){
			pageNumber="1";
		   }	
		   pageIndex=Integer.parseInt(pageNumber);
		   if(pageIndex<1){
			pageIndex=1;
	       }if(pageIndex>totalPage){
			pageIndex=totalPage;
		   }
		}
	     User user=(User)ActionContext.getContext().getSession().get("user");
		 User friend=(User)ActionContext.getContext().getSession().get("friend");
		 boolean flag=interFolder.othersIfCanScanFolder(user.getId(),friend.getId(),id);
		 if(flag){
		  List firendphotoList=interPhoto.getPhotoList(id,pageIndex);
		  if(firendphotoList.size()==0){
			  firendphotoList=null;
		  }
		  if(ActionContext.getContext().getSession().containsKey("firendphotoList")){
			  ActionContext.getContext().getSession().remove("firendphotoList");
		  }
		 ActionContext.getContext().getSession().put("firendphotoList",firendphotoList);
		return "success";
		 }else{
			 return "nolimit";
		 }
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InterPhoto getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(InterPhoto interPhoto) {
		this.interPhoto = interPhoto;
	}
	public InterFolder getInterFolder() {
		return interFolder;
	}

	public void setInterFolder(InterFolder interFolder) {
		this.interFolder = interFolder;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}


}
