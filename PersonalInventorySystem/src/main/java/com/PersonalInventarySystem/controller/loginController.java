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

/**
 * Servlet implementation class loginController
 */
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession();
		PrintWriter out=response.getWriter();
	   	    
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String check="";
		if(username!=check && password!=check) {
	       UsersBean b=new UsersDAO().authenticate(username,password);
	       int userid=b.getUserid();
	       String name=b.getName();
	       
	       if(userid>0) {
	    	   hs.setAttribute("userid",userid);	
	           hs.setAttribute("name",name);	
		        response.sendRedirect("homePageController");
	       }
	       else {
	    	   out.println("<h1><font color='red' size='20px'> please inter valide username and password </font></h1>");
		       request.getRequestDispatcher("login").include(request, response);
		   }
		} 
		else {
		 //  response.sendRedirect("login");
		   out.println("<h1><font color='red' size='20px'> please fill all field </font></h1>");
	       request.getRequestDispatcher("login").include(request, response);
	   }
		
		
		
	}

}
