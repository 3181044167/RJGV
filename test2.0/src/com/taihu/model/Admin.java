package com.taihu.model;



import javax.servlet.SessionTrackingMode;

public class Admin {
	String adminName;
	int adminId;
	String adminPasswd;
	public Admin(String adminName,String adminPasswd){
		this.adminName = adminName;
		this.adminPasswd = adminPasswd;
	}
	public Admin(){
		
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public void setAdminPasswd(String adminPasswd) {
		this.adminPasswd = adminPasswd;
	}
	
	public void setAdminID(int adminId) {
		this.adminId = adminId;
	}
	
	public int getID() {
		return adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public String getAdminPasswd() {
		return adminPasswd;
	}
	

}
