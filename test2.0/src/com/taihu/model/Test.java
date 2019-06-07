package com.taihu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 添加一行记录(添加一个用户)
		// addUsers();

		// 删除一个用户
		// deleteUsers();

		// 修改一个用户信息
		// updateUsers();

		// 查询所有用户信息
		queryUsers();
	}

	private static void queryUsers() {
		// 1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(数据库链接的基本信息)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 2。创建链接
			conn = DriverManager.getConnection(url, name, password);
			// 3。创建Statement
			st = conn.createStatement();

			// 4.执行SQL
			String sql = "select uid,username,userpasswd,age,gender,weight from users_table";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			rs = st.executeQuery(sql);
			// 5处理执行的结果
			while(rs.next()) {
				System.out.println(rs.getInt("uid")+"--"
									+rs.getString("username")+" -- "
									+rs.getString("userpasswd")+" -- "
									+rs.getInt("age")+" -- "
									+rs.getString("gender")+" -- "
									+rs.getDouble("weight"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 6.关闭资源
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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

	private static void updateUsers() {
		// 1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(数据库链接的基本信息)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;
		try {
			// 2。创建链接
			conn = DriverManager.getConnection(url, name, password);
			// 3。创建Statement
			st = conn.createStatement();

			// 4.执行SQL
			String sql = "update users_table set userpasswd='123456' where uid=1";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			int count = st.executeUpdate(sql);
			// 5处理执行的结果
			System.out.println(count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 6.关闭资源
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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

	private static void deleteUsers() {
		// 1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(数据库链接的基本信息)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;
		try {
			// 2。创建链接
			conn = DriverManager.getConnection(url, name, password);
			// 3。创建Statement
			st = conn.createStatement();

			// 4.执行SQL
			String sql = "delete from users_table where uid = 3";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			int count = st.executeUpdate(sql);
			// 5处理执行的结果
			System.out.println(count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 6.关闭资源
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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

	private static void addUsers() {
		// 1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(数据库链接的基本信息)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;

		try {
			// 2。创建链接
			conn = DriverManager.getConnection(url, name, password);
			// 3。创建Statement
			st = conn.createStatement();

			// 4.执行SQL
			String sql = "insert into users_table(username,userpasswd,age,gender,weight) VALUES('tom','123456',20,'男',41.5)";
			// select 语句，使用st.executeQuery(sql)
			// insert,delete,update语句，使用st.executeUpdate(sql);
			int count = st.executeUpdate(sql);
			// 5处理执行的结果
			System.out.println(count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 6.关闭资源
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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
