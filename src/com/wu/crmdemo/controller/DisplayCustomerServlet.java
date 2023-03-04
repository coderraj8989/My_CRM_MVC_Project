package com.wu.crmdemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wu.crmdemo.dao.CustomerDAO;
import com.wu.crmdemo.entity.Customer;

/**
 * Servlet implementation class DisplayCustomerServlet
 */
@WebServlet("/DisplayCustomerServlet")
public class DisplayCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		CustomerDAO customerDAO=new CustomerDAO();
		ArrayList<Customer> customers = customerDAO.getCustomer();
		
//		System.out.println(customers);
		
		request.setAttribute("custdata", customers);
		RequestDispatcher rd=request.getRequestDispatcher("list-customers.jsp");
		rd.forward(request, response);
	}

}
