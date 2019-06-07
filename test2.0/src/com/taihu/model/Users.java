package com.taihu.model;

public class Users {
	//属性
	private int uid;
	private String username;
	private String userpasswd;
	private int age;
	private String gender;
	private double weight;
	
	//默认构造方法
	public Users() {
		
	}

	public Users(String username,String userpasswd) {
		this.username  = username;
		this.userpasswd = userpasswd;
	}
	
	//行为
	public void learn() {
		System.out.println(username+" open eclipse");
	}
	public void setUid(int uid) {
		this.uid = uid;
		
	}
	public int getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpasswd() {
		return userpasswd;
	}

	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
