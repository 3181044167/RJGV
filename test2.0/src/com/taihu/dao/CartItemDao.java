package com.taihu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.taihu.model.Cart;
import com.taihu.model.CartItem;
import com.taihu.model.Product;
import com.taihu.tools.JDBCTools;


public class CartItemDao {
	private JDBCTools jdbcTools = new JDBCTools();

	private Connection conn = null;
	private PreparedStatement  ps = null;  //‘§¥¶¿Ì”Ôæ‰
	private ResultSet rs = null;
	Statement st =null;
	
	public ArrayList<CartItem> getUserCartItem(int uid){
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		CartItem cartItem = null;
		Product product=null;
		try {
			conn = jdbcTools.getConnection();
			
			String sql = "select uid,pid,pname,price,num from cartItem_table where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				product = new Product();
				product.setPrice(rs.getDouble("price"));
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				//product.setImgName(rs.getString("image"));
				cartItem = new CartItem(product);
				cartItem.setCount(rs.getInt("num"));
				list.add(cartItem);
				
	
			}
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}finally {
				jdbcTools.close(conn, st, rs);
			}
		
		return list;
	}
	
	public CartItem addCartItemFirst(CartItem c) {
		boolean result=false;
		CartItem cartItem=null;
		Product product=null;
		try {
			conn = jdbcTools.getConnection();
			String sql = "select * from cartItem_table  where uid=? && pid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getUid());
			ps.setInt(2, c.getProduct().getPid());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				product = new Product();
				cartItem = new CartItem(product);
				cartItem.setCount(rs.getInt("num"));
				cartItem.setUid(rs.getInt("uid"));
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				cartItem.setProduct(product);
			}
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}finally {
				jdbcTools.close(conn, st, rs);
			}
		
		
		
		
		return cartItem;
	}
	
	
	public boolean addCartItem(CartItem c) {
		boolean result=false;
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "insert into  cartItem_table(uid,pid,price,num,pname) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getUid());
			ps.setInt(2, c.getProduct().getPid());
			ps.setDouble(3, c.getProduct().getPrice());
			
			ps.setInt(4, c.getCount());
			ps.setString(5, c.getProduct().getPname());
			int count = ps.executeUpdate();
			if(count == 1) {
				result = true;
			}
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}finally {
				jdbcTools.close(conn, st, rs);
			}
		
		
		
		return result;
	}
	
	public boolean addCartItem(int count,int uid,int pid) {
		boolean result=false;
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "update cartItem_table set num=? where pid=? && uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setInt(2, pid);
			ps.setInt(3, uid);
			
			int a=ps.executeUpdate();
			if(a==1) result=true;
			
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}finally {
				jdbcTools.close(conn, st, rs);
			}
		
		
		
		return result;
	}
	public boolean deletePay(int uid) {
		boolean result=false;
		try {
			conn = jdbcTools.getConnection();
			String sql = "delete from  cartItem_table where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			
			int count = ps.executeUpdate();
			
				result = true;
			
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}finally {
				jdbcTools.close(conn, st, rs);
			}
		
		
		return result;
	}
	
	public int getCartItemByUP(int uid,int pid) {
		CartItem cartItem=null;
		int id=0;
		Product product=null;
		try {
			conn = jdbcTools.getConnection();
			
			String sql = "select pid,price,num from cartItem_table  where uid=? && pid=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, pid);
			rs = ps.executeQuery();
			if(rs.next()) {
				id=rs.getInt("pid");
				product.setPid(pid);
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				cartItem.setProduct(product);
				cartItem.setUid(uid);
				cartItem.setCount(rs.getInt("num"));
				
				
			}
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}finally {
				jdbcTools.close(conn, st, rs);
			}
		return id;
	}

}
