package com.interphoto.Actions;
import com.interphoto.Entity.Comment;
import com.interphoto.InterDao.InterComment;
import com.interphoto.InterDao.InterFolder;
import com.interphoto.InterDao.InterPhoto;
import com.interphoto.InterDao.InterUser;
import com.opensymphony.xwork2.ActionSupport;
public class ScanCommentAction extends ActionSupport {	
    private InterComment interComment;
    private InterUser interUser;
    private InterFolder interFolder;
    private InterPhoto interPhoto;
    private int id;//评论信息id
    private String friendName;//评论好友名称
    private String folderName;//评论的相册名称
    private String photoName;//评论的相册名称
    private String contentTime;//评论时间
    private String content;//评论内容
	public String execute(){		
    	Comment comment=interComment.getComment(id);
        interComment.updateCommentStatu(id);
        this.setFriendName(interUser.selectUserInfo(comment.getFriendid()).getUserName());//查询好友名称
        this.setFolderName(interFolder.getFolderName(comment.getFolderid()));//查询相册名称
        this.setPhotoName(interPhoto.getPhoto(comment.getPhotoid()).getPhotoName());//查询相片名称
        this.setContentTime(comment.getContentTime());//查询评论时间
    	this.setContent(comment.getContent());//查询评论内容
		return "success";
	}
    public InterComment getInterComment() {
		return interComment;
	}
	public void setInterComment(InterComment interComment) {
		this.interComment = interComment;
	}
	public InterUser getInterUser() {
		return interUser;
	}
	public void setInterUser(InterUser interUser) {
		this.interUser = interUser;
	}
	public InterFolder getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(InterFolder interFolder) {
		this.interFolder = interFolder;
	}
	public InterPhoto getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(InterPhoto interPhoto) {
		this.interPhoto = interPhoto;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getContentTime() {
		return contentTime;
	}

	public void setContentTime(String contentTime) {
		this.contentTime = contentTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
