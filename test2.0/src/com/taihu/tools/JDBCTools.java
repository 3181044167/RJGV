package com.taihu.tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * 
 * @author 胡志远
 * JDBC工具类
 * MVC  model2实现（JSP+ Servlet实现)
 * M:model --实体类 
 * 				分三层：实体类（model） dao(处理数据库的代码），service（专门处理业务的代码）；
 * 
 * V：view --视图  (JSP ,HTML)
 * 
 * C:control  -- 控制  （servlet)
 *
 */

public class JDBCTools {
	
	private String url = "jdbc:mysql://localhost:3306/test";
	private String name = "root";
	private String password = "root";
	private Connection conn = null;
	
	
	
	//加载驱动
	static {//只执行一次
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e.getMessage());//通过throws 抛出；
		}
	}
	//创建连接
	public Connection getConnection() throws SQLException {
		/*try {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		conn = DriverManager.getConnection(url,name,password);
		return conn;
	}

	//关闭资源
	
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
