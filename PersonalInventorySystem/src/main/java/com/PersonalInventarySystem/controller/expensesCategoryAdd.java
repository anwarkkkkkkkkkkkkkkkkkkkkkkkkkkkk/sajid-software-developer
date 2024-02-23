package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.PersonalInventorySystem.bean.ExpensesCategoryBean;
import com.PersonalInventorySystem.bean.IncomeCategoryBean;
import com.PersonalInventorySystem.dao.ExpensesCategoryDAO;
import com.PersonalInventorySystem.dao.IncomeCategoryDAO;

/**
 * Servlet implementation class expensesCategoryAdd
 */
public class expensesCategoryAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public expensesCategoryAdd() {
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
		 ExpensesCategoryBean b=new ExpensesCategoryBean();
	//	 System.out.println("  print name "+name);
		 //name=null;
		     HttpSession h=request.getSession();
			//	String name=(String)h.getAttribute("name");
				int userid=(Integer)h.getAttribute("userid");
		 String c="";
		 int x;
	  if(name!=c && details!=c) {
		 b.setExp_catname(name);
		 b.setExp_catdetails(details);
		 b.setUserid(userid);
		  x= new ExpensesCategoryDAO().addEmployee(b);
		  if(x>0)response.sendRedirect("expensesCategory");
		  else response.sendRedirect("expensesCategory");
	  }
	  else 	response.sendRedirect("expensesCategory");
	}

}
