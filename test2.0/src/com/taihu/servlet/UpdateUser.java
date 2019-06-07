package com.taihu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taihu.dao.ProductDao;
import com.taihu.dao.UsersDao;
import com.taihu.model.Product;
import com.taihu.model.Users;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/updateuser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		request.setCharacterEncoding("utf-8");
		String suid = request.getParameter("uid");
		String username = request.getParameter("username");
		String userpasswd = request.getParameter("userpasswd");
		String gender = request.getParameter("gender");
		int uid=0;
		
		if(suid!=null) {
			uid = Integer.parseInt(suid);
			
		}
		Users users = new Users();
		users.setUid(uid);
		users.setUsername(username);
		users.setUserpasswd(userpasswd);
		users.setGender(gender);
		
		UsersDao usersDao = new UsersDao();
		boolean result = usersDao.updateUser(users);
		if (result) {
			response.sendRedirect("userManger");
					
		}
	}

}
