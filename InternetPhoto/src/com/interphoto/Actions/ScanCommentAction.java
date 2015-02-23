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
    private int id;//������Ϣid
    private String friendName;//���ۺ�������
    private String folderName;//���۵��������
    private String photoName;//���۵��������
    private String contentTime;//����ʱ��
    private String content;//��������
	public String execute(){		
    	Comment comment=interComment.getComment(id);
        interComment.updateCommentStatu(id);
        this.setFriendName(interUser.selectUserInfo(comment.getFriendid()).getUserName());//��ѯ��������
        this.setFolderName(interFolder.getFolderName(comment.getFolderid()));//��ѯ�������
        this.setPhotoName(interPhoto.getPhoto(comment.getPhotoid()).getPhotoName());//��ѯ��Ƭ����
        this.setContentTime(comment.getContentTime());//��ѯ����ʱ��
    	this.setContent(comment.getContent());//��ѯ��������
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
