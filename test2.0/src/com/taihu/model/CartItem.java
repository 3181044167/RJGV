package com.taihu.model;

public class CartItem {
	private Product product;
	private int count;
	int pid;
	int uid;
	String pname;
	double price;
	public CartItem(Product product) {
		// TODO Auto-generated constructor stub
		this.product = product;
		this.pid=product.getPid();
		this.pname=product.getPname();
		this.price=product.getPrice();
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getUid() {
		return this.uid;
	}
	
	
	
	

}
