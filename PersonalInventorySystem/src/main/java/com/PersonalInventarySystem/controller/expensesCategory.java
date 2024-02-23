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

import com.PersonalInventorySystem.bean.ExpensesCategoryBean;
import com.PersonalInventorySystem.bean.IncomeCategoryBean;
import com.PersonalInventorySystem.dao.ExpensesCategoryDAO;
import com.PersonalInventorySystem.dao.IncomeCategoryDAO;

/**
 * Servlet implementation class expensesCategory
 */
public class expensesCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public expensesCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
	//	String name=(String)h.getAttribute("name");
		int userid=(Integer)h.getAttribute("userid");
		
		out.println("<br>");
	//	UsersBean b =d.findByEmpNo(id);
	   
		out.println("<form action='expensesCategoryAdd' method='post' ");
		out.println("<table>");
		out.println(" <tr>");
		out.println(" <th><h2>Expenses Category</h2></th>");
		out.println(" <th></th>");
		out.println(" <th></th>");
		out.println(" </tr><br>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Expenses Name</th>");
		out.println(" <td><input type='text'  name='name'></td>");
		out.println(" </tr><br>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Category Details</th>");
		out.println(" <td><input type='text'  name='details'></td>");
		out.println(" </tr><br>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <td><input type='submit' value='Add' target='_parent' ></td>");
		out.println(" <td><input type='reset' value='Cancle'></td>");
		out.println(" </tr>");  	
		
		out.println("</table>");
		out.println("</form>");
		
		//*************************************************
	//	out.println("<td><a href='MyUpdate?myid="+eb.getEmpno()+"'>Edit</a></td>");
		
		out.println("<form >");
		out.println("<table>");	
		out.println(" <tr>");
		out.println(" <th>Category Name</th>");
		out.println(" <th>Category Details</th>");
		out.println(" <th>Edit</th>");
		out.println(" <th>Delete</th>");
		out.println(" </tr>");  
		
		ExpensesCategoryDAO d=new ExpensesCategoryDAO();
		
		ArrayList<ExpensesCategoryBean> al=d.findAll(userid);
		
		for(ExpensesCategoryBean fe:al) {
		out.println(" <tr>");
		out.println(" <th>"+fe.getExp_catname()+"</th>");
		out.println(" <th>"+fe.getExp_catdetails()+"</th>");
		out.println("<td><a href='expensesCategoryEdit?myidic="+fe.getExp_catid()+"'>Edit</a></td>");
		out.println("<td><a href='expensesCategoryDelete?myid="+fe.getExp_catid()+"'>delete</a></td>");
		out.println(" </tr>");  
		}
		
		out.println("</table>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
