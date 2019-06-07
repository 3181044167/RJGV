package com.taihu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���һ�м�¼(���һ���û�)
		// addUsers();

		// ɾ��һ���û�
		// deleteUsers();

		// �޸�һ���û���Ϣ
		// updateUsers();

		// ��ѯ�����û���Ϣ
		queryUsers();
	}

	private static void queryUsers() {
		// 1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(���ݿ����ӵĻ�����Ϣ)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 2����������
			conn = DriverManager.getConnection(url, name, password);
			// 3������Statement
			st = conn.createStatement();

			// 4.ִ��SQL
			String sql = "select uid,username,userpasswd,age,gender,weight from users_table";
			// select ��䣬ʹ��st.executeQuery(sql)
			// insert,delete,update��䣬ʹ��st.executeUpdate(sql);
			rs = st.executeQuery(sql);
			// 5����ִ�еĽ��
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

			// 6.�ر���Դ
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
		// 1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(���ݿ����ӵĻ�����Ϣ)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;
		try {
			// 2����������
			conn = DriverManager.getConnection(url, name, password);
			// 3������Statement
			st = conn.createStatement();

			// 4.ִ��SQL
			String sql = "update users_table set userpasswd='123456' where uid=1";
			// select ��䣬ʹ��st.executeQuery(sql)
			// insert,delete,update��䣬ʹ��st.executeUpdate(sql);
			int count = st.executeUpdate(sql);
			// 5����ִ�еĽ��
			System.out.println(count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 6.�ر���Դ
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
		// 1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(���ݿ����ӵĻ�����Ϣ)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;
		try {
			// 2����������
			conn = DriverManager.getConnection(url, name, password);
			// 3������Statement
			st = conn.createStatement();

			// 4.ִ��SQL
			String sql = "delete from users_table where uid = 3";
			// select ��䣬ʹ��st.executeQuery(sql)
			// insert,delete,update��䣬ʹ��st.executeUpdate(sql);
			int count = st.executeUpdate(sql);
			// 5����ִ�еĽ��
			System.out.println(count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 6.�ر���Դ
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
		// 1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// url,name,password(���ݿ����ӵĻ�����Ϣ)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;

		try {
			// 2����������
			conn = DriverManager.getConnection(url, name, password);
			// 3������Statement
			st = conn.createStatement();

			// 4.ִ��SQL
			String sql = "insert into users_table(username,userpasswd,age,gender,weight) VALUES('tom','123456',20,'��',41.5)";
			// select ��䣬ʹ��st.executeQuery(sql)
			// insert,delete,update��䣬ʹ��st.executeUpdate(sql);
			int count = st.executeUpdate(sql);
			// 5����ִ�еĽ��
			System.out.println(count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 6.�ر���Դ
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
