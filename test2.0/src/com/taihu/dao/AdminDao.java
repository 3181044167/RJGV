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
	// url,name,password(���ݿ����ӵĻ�����Ϣ)
	
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement  ps = null;  //Ԥ�������
	
	public Admin loginCheck(Admin a) {

		Admin admin = null;
		try {
			// 2����������
			conn = jdbcTools.getConnection();
			// 3������Statement
			st = conn.createStatement();
			// 4.ִ��SQL
			String sql = "select * from admin_table where adminname='"+a.getAdminName()+"' && adminpasswd='"+a.getAdminPasswd()+"'";
			// select ��䣬ʹ��st.executeQuery(sql)
			// insert,delete,update��䣬ʹ��st.executeUpdate(sql);
			rs = st.executeQuery(sql);
			// 5����ִ�еĽ��
			if(rs.next()) {
				//˵��������һ����¼
				//��¼�ɹ�
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
