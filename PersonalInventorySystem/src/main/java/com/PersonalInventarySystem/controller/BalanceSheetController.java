package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.ExpensesBean;
import com.PersonalInventorySystem.bean.IncomeBean;
import com.PersonalInventorySystem.dao.ExpensesDAO;
import com.PersonalInventorySystem.dao.IncomeDAO;
import com.PersonalInventorySystem.utility.ConnectionPool;

/**
 * Servlet implementation class BalanceSheetController
 */
public class BalanceSheetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceSheetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out=response.getWriter();	
		   out.println("<style>  #col1{ float:buttom;}  </style>");
		   
			out.println("<form action='BalanceSheetController'>");
			out.println("<h1>BalanceSheet  </h1> <br>");			
			out.println("<table id='col1'>");	
			
			out.println(" <tr>");
			out.println(" <th></th>");
			out.println(" <th>Date From  </th>");
			out.println(" <th>To   </th>");
			out.println(" <th></th>");
			out.println(" </tr>");  
			
			out.println(" <tr>");
			out.println(" <th>DayBook </th>");
			out.println(" <th><input type='Date' name='sdate' placeholder='yyyy-mm-dd'></th>");
			out.println(" <th><input type='Date' name='edate' placeholder='yyyy-mm-dd'></th>");
			out.println(" <th><input type='submit' value='Show'></th>");
			out.println(" </tr>"); 
			
			out.println(" <tr>");  	
			out.println(" <th>	Incomes   </th>");
			out.println(" <th>  </th>");
			out.println(" <th> Expenses </th>");
			out.println(" <th>  </th>");
			out.println(" </tr>"); 
			
			out.println(" <tr>");
			out.println(" <th>Incomes</th>");
			out.println(" <th>Amount </th>");
			out.println(" <th>Expenses</th>");
			out.println(" <th>Amount</th>");
			out.println(" </tr>");  
		//	out.println(" </table>");
				 
			HttpSession h=request.getSession();
			int userid=(Integer)h.getAttribute("userid");	
			
			String sdate=request.getParameter("sdate");
			String edate=request.getParameter("edate");			
			
			IncomeDAO d=new IncomeDAO();
			ExpensesDAO ed=new ExpensesDAO();
			int i=1;
			int j=1;
			String s="";
	//		out.println(" <div>");
			out.println("<style>  .column{ float:left;}  </style>");
			
			  out.println(" <table class='column'>");		
		   
			for(IncomeBean bl:d.findAllDateWise(sdate, edate, userid)) {

				out.println(" <tr>");
				out.println(" <th id='mar1'>"+bl.getInc_ac()+"</th>");
				out.println("<th> <pre>       <pre></th>");
				out.println("<th id='mar'>"+bl.getAmount()+"</th>");
				out.println("<th><pre>        <pre></th>");
				out.println(" </tr>");
				i++;

				}
			   out.println("</table>");//out.println(" </th>");
			   
			   out.println("<table class='column'>");

		for(ExpensesBean bl1:ed.findAllDateWise(sdate, edate, userid)) {	

			out.println(" <tr >");
			out.println(" <th id='mar1'>"+bl1.getExp_ac()+"</th>");
			out.println("<th><pre>       <pre></th>");
			out.println("<th id='mar'>"+bl1.getAmount()+"</th>");
			out.println(" </tr>");  
			j++;

	    }
	    
		 out.println("</table>");
		 
		 out.println("</table>");
		 out.println("<br>");

			   
		// for income 
		   Connection conn = ConnectionPool.connectDB();
		   String sql = " select sum(amount) from incomes where userid='" + userid+"'";
		  double total=0.0;
		   try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				 rs.next();
				 total = rs.getDouble(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   
		   
		// for expenses 
		   String sq2 = " select sum(amount) from expenses where userid='" + userid+"'";
		  double total1=0.0;
		   try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sq2);
				 rs.next();
				 total1 = rs.getDouble(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   
		   out.println("</table>");
		   
		   out.println("<table id='col1'>");
		   out.println(" <tr>");
	        out.println(" <td><pre> Total       <pre></td>");
		    out.println("<th>"+total+"</th>");
		    out.println("<td><pre>        Total     <pre></td>");
		    out.println("<th>"+total1+"</th>");
		  out.println(" </tr>");
		  
		  out.println(" <tr>");
	        out.println(" <th><pre>        <pre></th>");
		    out.println("<th><pre>         <pre></th>");
		    out.println(" <td><pre>    Gross Profit    <pre></td>");
		    out.println("<th>"+(total-total1)+"</th>");
		  out.println(" </tr >");
		//  out.println("</table>");
	        out.println("</table>");
	        
		out.println("</form>");
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
