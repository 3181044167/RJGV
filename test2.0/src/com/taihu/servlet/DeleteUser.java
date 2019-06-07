package com.taihu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taihu.dao.ProductDao;
import com.taihu.dao.UsersDao;
import com.taihu.model.Users;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteusers.do")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
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
		String spid = request.getParameter("uid");
		int uid=0;
		uid = Integer.parseInt(spid);
		UsersDao usersDao = new UsersDao();
		//Users user = usersDao.getUserById(uid);
		boolean result = usersDao.delete(uid);
		
	
		if(result) {
			response.sendRedirect("userManger");
			return;
		}
	}

}
