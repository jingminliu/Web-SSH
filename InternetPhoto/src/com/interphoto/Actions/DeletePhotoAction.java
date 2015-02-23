package com.interphoto.Actions;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.interphoto.InterDao.InterPhoto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class DeletePhotoAction extends ActionSupport{
	private int id;//相册id
	private int pid;//相片id
	private int totalPage;//该属性表示总页数
	private int pageIndex;//该属性表示当前页数	
	private InterPhoto interPhoto;
	public String execute()	{
		interPhoto.deletePhoto(pid);
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
	  List photoList=interPhoto.getPhotoList(id,pageIndex);
		if(photoList.size()==0){
			photoList=null;
		}if(ActionContext.getContext().getSession().containsKey("photoList")){
			  ActionContext.getContext().getSession().remove("photoList");
		}
		ActionContext.getContext().getSession().put("photoList",photoList);
		return "success";
	}
	public InterPhoto getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(InterPhoto interPhoto) {
		this.interPhoto = interPhoto;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

}
