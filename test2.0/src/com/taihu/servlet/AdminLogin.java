package com.taihu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taihu.dao.AdminDao;
import com.taihu.dao.ProductDao;
import com.taihu.model.Product;
import com.taihu.model.Admin;
import com.taihu.tools.JDBCTools;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/admincheck")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 1、取出参数，用户名和密码
		String adminName = request.getParameter("adminname");
		String adminPasswd = request.getParameter("adminpasswd");
		
		// 2、数据有效性验证
		if (adminName == null || adminName.equals("") || adminPasswd == null || adminPasswd.equals("")) {
			response.sendRedirect("adminL.jsp?error=1");
			return;
		}
		
		Admin a = new Admin(adminName, adminPasswd);
		
		JDBCTools jdbcTools = new JDBCTools();
		// url,name,password(数据库链接的基本信息)
		String url = "jdbc:mysql://localhost:3306/test";
		String name = "root";
		String password = "root";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
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
				HttpSession session = request.getSession();
				session.setAttribute("admin", a);
				
				ServletContext  application = request.getServletContext();
				Integer count = (Integer)application.getAttribute("count");
				
				if(count==null) {
					application.setAttribute("count", 1);
				}else {
					application.setAttribute("count", count+1);
				}
				
				response.sendRedirect("adminIndex.jsp");
				return;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcTools.close(conn, st, rs);
		}

		// 登陆失败
		response.sendRedirect("adminL.jsp?error=2");
	
	}
}
