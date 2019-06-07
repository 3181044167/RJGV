package com.taihu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taihu.dao.CartItemDao;
import com.taihu.dao.ProductDao;
import com.taihu.model.Cart;
import com.taihu.model.CartItem;
import com.taihu.model.Product;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/addCart.do")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String spid = request.getParameter("pid");
	
		int pid = Integer.parseInt(spid);
		System.out.println(pid);
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		System.out.println(uid);
		ProductDao productDao  = new ProductDao();
		Product product = productDao.getById(pid);
		CartItemDao cartItemDao = new CartItemDao();
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		CartItem cartItem=new CartItem(product);
		cartItem.setUid(uid);
		boolean result1 =false;
		if(cartItemDao.addCartItemFirst(cartItem)==null) {
			cartItem.setCount(1);
			boolean result2= cartItemDao.addCartItem(cartItem);
			
			
		}else {
			int num=cartItemDao.addCartItemFirst(cartItem).getCount();
			num=num+1;
			 result1 = cartItemDao.addCartItem(num, uid, pid);
			
			
		}
		
			
			response.sendRedirect("showcart");
		
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
