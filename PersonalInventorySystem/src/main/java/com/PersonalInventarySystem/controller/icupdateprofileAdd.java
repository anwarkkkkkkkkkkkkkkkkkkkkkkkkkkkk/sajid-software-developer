package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.PersonalInventorySystem.bean.IncomeCategoryBean;
import com.PersonalInventorySystem.dao.IncomeCategoryDAO;

/**
 * Servlet implementation class updateprofileAdd
 */
public class icupdateprofileAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public icupdateprofileAdd() {
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
		
	   	 String name=request.getParameter("name");
		 String details=request.getParameter("details");
		 IncomeCategoryBean b=new IncomeCategoryBean();
		 
			HttpSession h=request.getSession();
			//	String name=(String)h.getAttribute("name");
		   int userid=(Integer)h.getAttribute("userid");
		 //name=null;
		 String c="";
		 int x;
	  if(name!=c && details!=c) {
		 b.setInc_catname(name);
		 b.setInc_catdetails(details);
		 b.setUserid(userid);
		  x= new IncomeCategoryDAO().addEmployee(b);
		  response.sendRedirect("incomeCategory");
	  }
	  else 	response.sendRedirect("incomeCategory");
	}

}
