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
	private File file;//封装上传文件的属性
	private int id;//相册编号id
	private String photoName;//相片名称
	private String photoInfo;//图片说明
	private String fileFileName;//封装上传文件的名称属性
	private String targetName;//保存文件名称属性
	private String  dir;//保存文件路径属性	
	private InterPhoto interPhoto;
	
	public String execute() throws Exception{
		String realpath=ServletActionContext.getRequest().getRealPath("/upload");//获得upload路径的真实路径
		if(fileFileName==null|| (fileFileName.trim()).equals("")){
			this.addFieldError("file","文件不能为空");
		}else{
	         targetName=generateFileName(fileFileName);
	         this.setDir(realpath+"\\"+targetName);
	         File target=new File(realpath,targetName);
	         FileUtils.copyFile(file,target);//将临时文件复制到目标文件                 
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
