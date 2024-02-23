package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.PersonalInventorySystem.bean.ExpensesBean;
import com.PersonalInventorySystem.bean.ExpensesCategoryBean;
import com.PersonalInventorySystem.bean.IncomeBean;
import com.PersonalInventorySystem.bean.IncomeCategoryBean;
import com.PersonalInventorySystem.dao.ExpensesCategoryDAO;
import com.PersonalInventorySystem.dao.ExpensesDAO;
import com.PersonalInventorySystem.dao.IncomeCategoryDAO;
import com.PersonalInventorySystem.dao.IncomeDAO;

/**
 * Servlet implementation class IncomeController
 */
public class IncomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession h=request.getSession();
		int userid=(Integer)h.getAttribute("userid");
		
		 PrintWriter out=response.getWriter();	 
	 	out.println("<h1></h1> ");
	 	
		out.println("<form>");
		out.println("<h1>Incomes  </h1> <br>");			
		out.println("<table>");	
				
		out.println(" <tr>");
		out.println(" <th>Incomes </th>");
		out.println(" <th><input type='text' name='expenses' placeholder='bill/ticket/stationary'></th>");
		out.println(" </tr>"); 
		
		out.println(" <tr>");
		out.println(" <th>Category </th>");
		out.println(" <th>");
		out.println("<select name='category' style='width:150px'>");
		out.println("<optgroup lable='select' name='category'>");
		
		IncomeCategoryDAO bbd=new IncomeCategoryDAO();
		
		for(IncomeCategoryBean b:bbd.findAll(userid)) {
		     out.println("<option value='"+b.getInc_catname()+"'>"+b.getInc_catname()+"</option>");
		}
		
		out.println("</optgroup>");	
		out.println("</select>");	
		out.println("</th>");	
		out.println(" </tr>"); 
		
		out.println(" <tr>");
		out.println(" <th>Amount </th>");
		out.println(" <th><input type='number' name='amount'></th>");
		out.println(" </tr>"); 
		
		out.println(" <tr>");
		out.println(" <th>ReceiveBy </th>");
		out.println(" <th>");
		out.println("<select  name='payby' style='width:150px'>");
		out.println("<optgroup lable='select' name='payby'>");
		out.println("<option value='cash'>cash</option>");
		out.println("<option value='check'>check</option>");
		out.println("</optgroup>");	
		out.println("</select>");	
		out.println("</th>");	
		out.println(" </tr>"); 
		
		out.println(" <tr>");
		out.println(" <th>Date </th>");
		out.println(" <th><input type='date' name='date' placeholder='yyyy-mm-dd'></th>");
		out.println(" </tr>"); 
		
		out.println(" <tr>");
		out.println(" <th>Remark </th>");
		out.println(" <th><input type='text' name='remark'></th>");
		out.println(" </tr>"); 
		
		out.println(" <tr>");
		out.println(" <th><input type='submit' value='Add Incomes'></th>");
		out.println(" </tr>"); 
		
		out.println("</table>");
		out.println("</form>");
		
		
		String account=request.getParameter("expenses");
		double amount=Double.parseDouble(request.getParameter("amount"));
		String date=request.getParameter("date");
		String payby=request.getParameter("payby");
		String remark=request.getParameter("remark");
		
		IncomeBean b=new IncomeBean();
		
		String s="";
		if(s!=account && s!=date && s!=payby && s!=remark) {
		  b.setAmount(amount);
          b.setTransaction_date(date);
           b.setReceivby(payby);
           b.setRemark(remark);
          b.setInc_ac(account);
          b.setUserid(userid);
          b.setInc_catid(userid);		
		int x= new IncomeDAO().addEmployee(b);
		
		if(x>0) out.print("<h1>our data inserted successfully</h1>");
		else  out.print("<h1>our data not successfully</h1>");
		
		} else  out.print("<h1>our data not successfully</h1>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
