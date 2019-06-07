package com.taihu.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
	List<CartItem>  items = new ArrayList<CartItem>();

	public List<CartItem> getItems() {
		return items;
	}

	
	//��Ϊ:
	//1.���һ��item�����ﳵ
	public void add(CartItem cartItem) {
		Iterator<CartItem> iter = items.iterator();
		while(iter.hasNext()) {
			CartItem item = iter.next();
			if(item.getProduct().getPid() == cartItem.getProduct().getPid()) {
				//int count = item.getCount()+1;
				//item.setCount(count);
				item.setCount(item.getCount()+1);
				return;
			}
		}
		
		items.add(cartItem);
		
	}
	
	//2.���ܼ�
	public double getTotalPrice() {
		double total = 0;
		Iterator<CartItem> iter = items.iterator();
		while(iter.hasNext()) {
			CartItem item = iter.next();
			total+= item.getProduct().getPrice()*item.getCount();
		}
		
		return total;
	}

}
