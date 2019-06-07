package com.taihu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.taihu.model.Product;
import com.taihu.tools.JDBCTools;

public class ProductDao {
	
	private JDBCTools jdbcTools = new JDBCTools();

	private Connection conn = null;
	private PreparedStatement  ps = null;  //预处理语句
	private ResultSet rs = null;
	// 1.根据ID查询一个商品信息
	public Product getById(int pid) {
		Product p = null;
		try {
			conn = jdbcTools.getConnection();
			String sql = "select * from product_table where pid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getDouble("price"));
				p.setDetail(rs.getString("detail"));
				p.setImgName(rs.getString("imgName"));
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcTools.close(conn, ps, rs);
		}
		
		return p;
	}

	// 2根据ID删除一个商品信息
	public boolean deleteProduct(int pid) {
		boolean result = false;
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "delete from product_table where pid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			int num=ps.executeUpdate();
			if(num==1)
				result = true;
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			jdbcTools.close(conn, ps, rs);
		}
		return result;
	}
	// 3修改一个商品信息
	public boolean updateProduct(Product product) {
		boolean result = false;
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "update product_table set pname=?,  price=? ,detail=? where pid=?";
			ps = conn.prepareStatement(sql);
			//绑定参数
			ps.setString(1, product.getPname());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getDetail());
			ps.setDouble(4, product.getPid());
			
			
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcTools.close(conn, ps, null);
		}
		
		
		
		
		return result;
	}
	// 4查询所有商品信息
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "select * from product_table order by pid";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getDouble("price"));
				p.setDetail(rs.getString("detail"));
				p.setImgName(rs.getString("imgName"));
				
				list.add(p);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcTools.close(conn, ps, rs);
			//jdbcTools.closeResource(conn, ps, rs);
		}
		
		return list;
	}
	
	
	
	//5添加一个商品信息
	public boolean insertProduct(Product product) {
		boolean result = false;
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "insert into product_table(pname,price,detail,imgName) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			//绑定参数
			ps.setString(1, product.getPname());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getDetail());
			ps.setString(4, product.getImgName());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcTools.close(conn, ps, null);
		}
		
		
		
		
		return result;
	}
	
	
	//6模糊查询一个商品信息
	
	//分页查询
	public ArrayList<Product> getProductsByPage(int pageNow, int pageCount){
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "select * from product_table order by pid limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNow-1)*pageCount);
			ps.setInt(2, pageCount);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getDouble("price"));
				p.setDetail(rs.getString("detail"));
				p.setImgName(rs.getString("imgName"));
				
				list.add(p);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcTools.close(conn, ps, rs);
		}
		
		return list;
	}
	

}
