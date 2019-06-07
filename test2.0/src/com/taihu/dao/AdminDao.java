package com.taihu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.SessionTrackingMode;

import com.taihu.model.Admin;
import com.taihu.model.Users;
import com.taihu.tools.JDBCTools;

public class AdminDao {
	private JDBCTools jdbcTools = new JDBCTools();
	// url,name,password(数据库链接的基本信息)
	
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement  ps = null;  //预处理语句
	
	public Admin loginCheck(Admin a) {

		Admin admin = null;
		try {
			// 2。创建链接
			conn = jdbcTools.getConnection();
			// 3。创建Statement
			st = conn.createStatement();
			// 4.执行SQL
			String sql = "select * from admin_table where adminname='"+a.getAdminName()+"' && adminpasswd='"+a.getAdminPasswd()+"'";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			rs = st.executeQuery(sql);
			// 5处理执行的结果
			if(rs.next()) {
				//说明至少有一条记录
				//登录成功
				admin = new Admin();
				admin.setAdminID(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminname"));
				admin.setAdminPasswd(rs.getString("adminpasswd"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTools.close(conn, st, rs);
		}
		return admin;
	}
	
	
}
