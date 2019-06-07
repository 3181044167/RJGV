package com.taihu.tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * 
 * @author ��־Զ
 * JDBC������
 * MVC  model2ʵ�֣�JSP+ Servletʵ��)
 * M:model --ʵ���� 
 * 				�����㣺ʵ���ࣨmodel�� dao(�������ݿ�Ĵ��룩��service��ר�Ŵ���ҵ��Ĵ��룩��
 * 
 * V��view --��ͼ  (JSP ,HTML)
 * 
 * C:control  -- ����  ��servlet)
 *
 */

public class JDBCTools {
	
	private String url = "jdbc:mysql://localhost:3306/test";
	private String name = "root";
	private String password = "root";
	private Connection conn = null;
	
	
	
	//��������
	static {//ִֻ��һ��
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e.getMessage());//ͨ��throws �׳���
		}
	}
	//��������
	public Connection getConnection() throws SQLException {
		/*try {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		conn = DriverManager.getConnection(url,name,password);
		return conn;
	}

	//�ر���Դ
	
	public void close(Connection conn,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}							
				}
			}
		}
	
	}
}
