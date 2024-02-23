package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class linkTableController
 */
public class linkTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public linkTableController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		     out.println("<style>");
				out.println(" #tablel{ border:2px dotted blue;padding:10px;background-color:black;}");
         		out.println(" a {text-decoration: none; font-size:20px; color:blue;} ");
				out.println("  a:hover {background-color:orange;border:1px black solid;}");
				out.println(" #master{background-color:red;} ");
	            out.println(" </style>");
	            
	            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
	    	    out.println("<script type='text/javascript' src='form.js'> </script>");
	
		out.println("<table id='tablel'>");
		out.println(" <tr><th><h1 id='master'>Master</h1></th></tr>");
		out.println(" <tr><td>   <a href='expensesCategory' target='framename' id='ec' >Expenses Category </a><br></td></tr>");
		out.println("<tr><td>    <a href=' incomeCategory' target='framename' id='ic' >Income Category</a><br></td></tr>");
	    out.println("<tr><td>   <a href='ExpensesController'  target='framename' id='e'>Expenses</a><br></td></tr>");
		out.println("<tr><td>   <a href='IncomeController'  target='framename' id='i'>Income</a><br></td></tr>");
		out.println("<tr><td>    <a href='CashBookController'  target='framename' id='cb'>Cash Book</a><br></td></tr>");
		out.println("<tr><td>   <a href='BankBookController'   target='framename' id='bb' >Bank Book</a><br></td></tr>");
		out.println(" <tr><td>  <a href='DayBookController'   target='framename' id='db' >Day Book</a><br></td></tr>");
		out.println(" <tr><td>   <a href='BalanceSheetController' target='framename' id='bc' >Balance Sheet</a><br> </td></tr>");                    
		out.println(" </table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
