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
import com.taihu.model.CartItem;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
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
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		CartItemDao cartItemDao= new CartItemDao();
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		list = cartItemDao.getUserCartItem(uid);
		if(list==null) System.out.println("kongde");
		else System.out.println("you");
		for(CartItem cartItem:list) {
			System.out.println(cartItem);
		}
		session.setAttribute("CartItemList", list);
		request.getRequestDispatcher("showCart.jsp").forward(request, response);
		
	}

}
