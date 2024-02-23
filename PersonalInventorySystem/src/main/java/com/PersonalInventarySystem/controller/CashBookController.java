package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.BankBookBean;
import com.PersonalInventorySystem.bean.CashBookBean;
import com.PersonalInventorySystem.dao.BankBookDAO;
import com.PersonalInventorySystem.dao.CashBookDAO;

/**
 * Servlet implementation class CashBookController
 */
public class CashBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashBookController() {
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
			out.println("<form action='CashBookController'>");
			out.println("<h1>CashBook</h1> <br>");	
			
			out.println("<table>");	
			
			out.println(" <tr>");
			out.println(" <th></th>");
			out.println(" <th>Date From</th>");
			out.println(" <th>To</th>");
			out.println(" <th></th>");
			out.println(" </tr>");  
			
			out.println(" <tr>");
			out.println(" <th>CashBook</th>");
			out.println(" <th><input type='Date' name='sdate' placeholder='yyyy-mm-dd'></th>");
			out.println(" <th><input type='Date' name='edate' placeholder='yyyy-mm-dd'></th>");
			out.println(" <th><input type='submit' value='Show'></th>");
			out.println(" </tr>"); 
				
			out.println(" <tr>");
			out.println(" <th>S.No</th>");
			out.println(" <th>Date</th>");
			out.println(" <th>Amount</th>");
			out.println(" <th>Pay/Receive</th>");
			out.println(" </tr>");  
				 
			HttpSession h=request.getSession();
			//String name=(String)h.getAttribute("name");
			int userid=(Integer)h.getAttribute("userid");	
			
			String sdate=request.getParameter("sdate");
			String edate=request.getParameter("edate");
			
		//	new BankBookDAO().findAllDateWise(sdate, edate, userid);
			
			CashBookDAO d=new CashBookDAO();
			//ArrayList<CashBookBean> al=d.findAllDateWise(sdate, edate, userid);
			int i=1;
		//	d.closingBalance(userid);
			
		for(CashBookBean bl:d.findAllDateWise(sdate, edate, userid)) {
			out.println(" <tr>");
			out.println(" <th>"+i+"</th>");
			out.println(" <th>"+bl.getTransaction_date()+"</th>");
			out.println("<td>"+bl.getAmount()+"</td>");
			out.println("<td>"+bl.getOperation()+"</td>");
			out.println(" </tr>");  
			i++;
		   }
			out.println(" <tr>");
			out.println(" <th><pre>Closing Balance</pre></th>");
			out.println(" <th></th>");
			out.println("<td>"+d.closingBalance(userid)+"</td>");
			out.println("<td></td>");
			out.println(" </tr>");  
			
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
