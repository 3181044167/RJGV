package com.taihu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taihu.dao.ProductDao;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/delete.do")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String spid = request.getParameter("pid");
		int pid = Integer.parseInt(spid);
		
		ProductDao productDao = new ProductDao();
		
		boolean result = productDao.deleteProduct(pid);
		
	
		if(result) {
			//System.out.println("删除成功");
			response.sendRedirect("procuctManger");
			return;
		}else {
			//System.out.println("删除未成功");
			//response.sendRedirect("index.jsp");
		}
	}

}
