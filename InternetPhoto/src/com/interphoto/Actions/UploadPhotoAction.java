package com.interphoto.Actions;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.interphoto.InterDao.InterPhoto;
import com.opensymphony.xwork2.ActionSupport;

public class UploadPhotoAction extends ActionSupport 
{
	private File file;//��װ�ϴ��ļ�������
	private int id;//�����id
	private String photoName;//��Ƭ����
	private String photoInfo;//ͼƬ˵��
	private String fileFileName;//��װ�ϴ��ļ�����������
	private String targetName;//�����ļ���������
	private String  dir;//�����ļ�·������	
	private InterPhoto interPhoto;
	
	public String execute() throws Exception{
		String realpath=ServletActionContext.getRequest().getRealPath("/upload");//���upload·������ʵ·��
		if(fileFileName==null|| (fileFileName.trim()).equals("")){
			this.addFieldError("file","�ļ�����Ϊ��");
		}else{
	         targetName=generateFileName(fileFileName);
	         this.setDir(realpath+"\\"+targetName);
	         File target=new File(realpath,targetName);
	         FileUtils.copyFile(file,target);//����ʱ�ļ����Ƶ�Ŀ���ļ�                 
	         interPhoto.uploadPhoto(id, photoName, targetName, photoInfo);
		}		
		return "success";
	}
	private String generateFileName(String fileName){
		DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		String formatdate=format.format(new Date());
		int random=new Random().nextInt(10000);
		int position=fileName.lastIndexOf(".");
		String extension=fileName.substring(position);
		String newfilename=formatdate+random+extension;
		return newfilename;
	}
	public String getPhotoInfo() {
		return photoInfo;
	}
	public void setPhotoInfo(String photoInfo) {
		this.photoInfo = photoInfo;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public InterPhoto getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(InterPhoto interPhoto) {
		this.interPhoto = interPhoto;
	}

}
