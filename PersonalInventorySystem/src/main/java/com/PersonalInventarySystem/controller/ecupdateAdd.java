package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import com.PersonalInventorySystem.utility.ConnectionPool;

/**
 * Servlet implementation class ecupdateAdd
 */
public class ecupdateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ecupdateAdd() {
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
		String s1=request.getParameter("name");
		String s2=request.getParameter("details");
	//	int id=Integer.parseInt(request.getParameter("id"));
		
		HttpSession h=request.getSession();
		int id=(Integer)h.getAttribute("myidic");
		
		String q="update expenses_category set exp_catdetails='"+s2+"',exp_catname='"+s1+"'where exp_catid="+id+" ";
		int x=0;
		try {
		     Statement stmt=ConnectionPool.connectDB().createStatement();
		     x=stmt.executeUpdate(q);
	
		  } catch (SQLException e) {
		      e.printStackTrace();
	     	}
		if(x>0){
			response.sendRedirect("expensesCategory");
		}

	}

}
