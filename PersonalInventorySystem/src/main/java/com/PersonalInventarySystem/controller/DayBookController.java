package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.PersonalInventorySystem.bean.BankBookBean;
import com.PersonalInventorySystem.bean.ExpensesBean;
import com.PersonalInventorySystem.bean.IncomeBean;
import com.PersonalInventorySystem.dao.BankBookDAO;
import com.PersonalInventorySystem.dao.ExpensesDAO;
import com.PersonalInventorySystem.dao.IncomeDAO;

/**
 * Servlet implementation class DaySheetController
 */
public class DayBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DayBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out=response.getWriter();	
		    out.println("<br>");
			out.println("<form action='DayBookController'>");
			out.println("<h1>DayBook  </h1> <br>");			
			out.println("<table>");	
			
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
			out.println(" <th>S.No</th>");
			out.println(" <th>Account Name</th>");
			out.println(" <th>Date</th>");
			out.println(" <th>Amount </th>");
			out.println(" <th>Pay/Receive</th>");
			out.println(" <th>Remark</th>");
			out.println(" </tr>");  
				 
			HttpSession h=request.getSession();
			//String name=(String)h.getAttribute("name");
			int userid=(Integer)h.getAttribute("userid");	
			
			String sdate=request.getParameter("sdate");
			String edate=request.getParameter("edate");			
			
			IncomeDAO d=new IncomeDAO();
			ExpensesDAO ed=new ExpensesDAO();
			int i=1;
			int j=1;
			
			for(ExpensesBean bl:ed.findAllDateWise(sdate, edate, userid)) {			
			if(j==1)out.println("<tr><th><h2>Expenses</h2></th></tr>");
			out.println(" <tr>");
			out.println(" <th>"+j+"</th>");
			out.println(" <th>"+bl.getExp_ac()+"</th>");
			out.println("<td>"+bl.getTransaction_date()+"</td>");
			out.println("<td>"+bl.getAmount()+"</td>");
			out.println("<td>"+bl.getPayby()+"</td>");
			out.println(" <th>"+bl.getRemark()+"</th>");
			out.println(" </tr>");  
			j++;
			}		
			for(IncomeBean bl:d.findAllDateWise(sdate, edate, userid)) {				
				if(i==1) out.println("<tr><th><h2>Incomes</h2></th></tr>");
				out.println(" <tr>");
				out.println(" <th>"+i+"</th>");
				out.println(" <th>"+bl.getInc_ac()+"</th>");
				out.println("<td>"+bl.getTransaction_date()+"</td>");
				out.println("<td>"+bl.getAmount()+"</td>");
				out.println("<td>"+bl.getReceivby()+"</td>");
				out.println(" <th>"+bl.getRemark()+"</th>");
				out.println(" </tr>");  
				i++;
				}
		
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
