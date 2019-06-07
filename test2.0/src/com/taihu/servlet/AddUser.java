package com.taihu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.taihu.dao.ProductDao;
import com.taihu.dao.UsersDao;
import com.taihu.model.Product;
import com.taihu.model.Users;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users users = new Users();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sage = request.getParameter("age");
		//String sgender = request.getParameter("gender");
		int age = Integer.parseInt(sage);
		users.setUsername(username);
		users.setUserpasswd(password);
		users.setAge(age);
		
		
		//Ð´µ½Êý¾Ý¿â
		UsersDao usersDao = new UsersDao();
		
		boolean result = usersDao.insertUser(users);
		if (result)	
			response.sendRedirect("index");
		else
			response.sendRedirect("register.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
