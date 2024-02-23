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

import com.PersonalInventorySystem.bean.IncomeCategoryBean;
import com.PersonalInventorySystem.bean.UsersBean;
import com.PersonalInventorySystem.dao.IncomeCategoryDAO;
import com.PersonalInventorySystem.dao.UsersDAO;

/**
 * Servlet implementation class incomeCategory
 */
public class incomeCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public incomeCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int call = Integer.parseInt(request.getParameter("myid"));
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
	//	String name=(String)h.getAttribute("name");
		int userid=(Integer)h.getAttribute("userid");		
	//	out.println("<h1>'"+name+"'</h1>");
		
	//	UsersBean b =d.findByEmpNo(id);
		out.println("<br>");
		out.println("<form action='icupdateprofileAdd' method='post' ");
		out.println("<table>");
		out.println(" <tr>");
		out.println(" <th><h2>Income Category</h2></th>");
		out.println(" <th></th>");
		out.println(" <th></th>");
		out.println(" </tr><br>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Category Name</th>");
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
		
		IncomeCategoryDAO d=new IncomeCategoryDAO();
		ArrayList<IncomeCategoryBean> al=d.findAll(userid);
		
		for(IncomeCategoryBean fi:al) {
		out.println(" <tr>");
		out.println(" <th>"+fi.getInc_catname()+"</th>");
		out.println(" <th>"+fi.getInc_catdetails()+"</th>");
		out.println("<td><a href='icupdateprofileEdit?myidic="+fi.getInc_catid()+"'>Edit</a></td>");
		out.println("<td><a href='icupdateprofileDelete?myid="+fi.getInc_catid()+"'>delete</a></td>");
		out.println(" </tr>");  
		}
		
		out.println("</table>");
		out.println("</form>");
	/*	
		if(call==){
			
		}
		
      if(call){
			
		}

     if(call){
	
       }
     if(call){
	
     }
		
		*/
	}

}
