package com.taihu.servlet;

import java.io.IOException;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.taihu.dao.UsersDao;
import com.taihu.model.Users;
import com.taihu.tools.JDBCTools;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/check")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1、取出参数，用户名和密码
		String username = request.getParameter("username");
		String userpasswd = request.getParameter("userpasswd");
		// 2、数据有效性验证
		if (username == null || username.equals("") || userpasswd == null || userpasswd.equals("")) {
			response.sendRedirect("login.jsp?error=1");
			return;
		}

		Users u = new Users(username, userpasswd);
		UsersDao usersDao = new UsersDao();
		Users user=null;
		user=usersDao.loginCheck(u);
		if (user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("uid",user.getUid());
			
			response.sendRedirect("manger");
			
			
			return;
		}
		response.sendRedirect("login.jsp?error=2");
		
	}

}
