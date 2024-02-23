package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.PersonalInventorySystem.bean.UsersBean;
import com.PersonalInventorySystem.dao.UsersDAO;

public class updateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession h=request.getSession();
	//	String name=(String)h.getAttribute("name");
		int userid=(Integer)h.getAttribute("userid");	
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		
		UsersBean b =new UsersBean();
		
		b.setAddress(address);
		b.setEmail(email);
		b.setMobile(phone);
		b.setPassword(password);
		b.setUsername(username);
		b.setName(name);
		b.setUserid(userid);
		
		new UsersDAO().UpdateEmployee(b);
		//PrintWriter out=response.getWriter();
		response.sendRedirect("userProfile");
		//out.println("<h bgcolor='green'>SUCCESSFULLY UPDATED</h>");
		
	}

}
