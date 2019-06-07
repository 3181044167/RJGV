package com.taihu.model;

public class Product {
	int pid;
	private String pname;
	private double price;
	private double weight;
	private String detail;
	private String imgName;
	
	public Product() {
		
	}
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public String getImgName() {
		return this.imgName;
	}

	public Product(String pname,double price) {
		this.pname = pname;
		this.price = price;
	}

	public String getPname() {
		return pname;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPid() {
		return this.pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return pname+"--"+price+","+detail;
	}
}
