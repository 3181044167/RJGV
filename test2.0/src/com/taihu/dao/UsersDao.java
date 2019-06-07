package com.taihu.dao;


import java.sql.*;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;
import com.taihu.model.Users;
import com.taihu.tools.JDBCTools;

public class UsersDao {
	private JDBCTools jdbcTools = new JDBCTools();
	// url,name,password(数据库链接的基本信息)
	
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private int uid;
	private PreparedStatement  ps = null;  //预处理语句
	
	
	//1.登录验证
	public Users loginCheck(Users user) {
		Users u = null;
		
		try {
			// 2。创建链接
			conn = jdbcTools.getConnection();
			// 3。创建Statement
			st = conn.createStatement();
			// 4.执行SQL
			String sql = "select * from users_table where username='"+user.getUsername()+"' && userpasswd='"+user.getUserpasswd()+"'";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			rs = st.executeQuery(sql);
			// 5处理执行的结果
			if(rs.next()) {
				//说明至少有一条记录
				//登录成功
				u = new Users();
				u.setUid(rs.getInt("uid"));
				u.setAge(rs.getInt("age"));
				u.setGender(rs.getString("gender"));
				u.setWeight(rs.getDouble("weight"));
				u.setUsername(rs.getString("username"));
				u.setUserpasswd(rs.getString("userpasswd"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTools.close(conn, st, rs);
		}
		return u;
	}
	//2.讲一个对象插入数据库
	public boolean insertUser(Users user) {
		boolean result = false;
		
		try {
			conn = jdbcTools.getConnection();
			st = conn.createStatement();
			String sql = "insert into users_table(username,userpasswd,age) VALUES(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpasswd());
			ps.setInt(3, user.getAge());
			int count = ps.executeUpdate();
			if (count == 1)
				result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	//3.根据ID查询一个用户信息
	public Users getUserById(int id) {
		Users users=null;
		try {
			conn = jdbcTools.getConnection();
			// 3。创建Statement
			st = conn.createStatement();

			// 4.执行SQL
			String sql = "select uid,username,userpasswd,age,gender,weight from users_table";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				if(rs.getInt("uid") == id) {
					users.setAge(rs.getInt("age"));
					users.setGender(rs.getString("gender"));
					users.setWeight(rs.getDouble("weight"));
					users.setUsername(rs.getString("username"));
					users.setUserpasswd(rs.getString("userpasswd"));
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return users;
		
	}
	
	//4.删除
	public boolean delete(int uid) {
		boolean result = false;
		
		try {
			conn = jdbcTools.getConnection();
			String sql = "delete from users_table where uid = ?";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			int num=ps.executeUpdate();
			if(num==1)
				result = true;
			
				
		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	//5.修改
	public boolean updateUser(Users users) {
		boolean result = false;
		
		try {
			conn = jdbcTools.getConnection();
			// 3。创建Statement
			st = conn.createStatement();

			// 4.执行SQL
			String sql = "update users_table set username=?,userpasswd=?,gender=? where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, users.getUsername());
			ps.setString(2, users.getUserpasswd());
			ps.setString(3, users.getGender());
			ps.setInt(4, users.getUid());
			result = true;
				
		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	//6.查询所有
	public ArrayList<Users> getAllUsers(){
		
		ArrayList<Users> list = new ArrayList<Users>();
		try {
			conn = jdbcTools.getConnection();
			// 3。创建Statement
			st = conn.createStatement();

			// 4.执行SQL
			String sql = "select uid,username,userpasswd,age,gender,weight from users_table";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			rs = st.executeQuery(sql);
			
			
			while (rs.next()) {
				Users user = new Users();
				user.setUid(rs.getInt("uid"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				user.setWeight(rs.getDouble("weight"));
				user.setUsername(rs.getString("username"));
				user.setUserpasswd(rs.getString("userpasswd"));
				list.add(user);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list;
	}

}
