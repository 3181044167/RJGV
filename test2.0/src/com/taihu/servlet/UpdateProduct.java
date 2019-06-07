package com.taihu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taihu.dao.ProductDao;
import com.taihu.model.Product;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
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
		String pname = request.getParameter("pname");
		String sprice = request.getParameter("price");
		String detail = request.getParameter("detail");
		int pid=0;
		double price = Double.parseDouble(sprice);
		if(spid!=null) {
			pid = Integer.parseInt(spid);
			
		}
		Product product = new Product();
		product.setPid(pid);
		product.setPname(pname);
		product.setPrice(price);
		product.setDetail(detail);
		
		ProductDao productDao = new ProductDao();
		boolean result = productDao.updateProduct(product);
		if (result) {
			response.sendRedirect("procuctManger");
					
		}
		
	}

}
