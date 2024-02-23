package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.PersonalInventorySystem.bean.UsersBean;
import com.PersonalInventorySystem.dao.UsersDAO;

public class updateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfile() {
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
		int userid=(Integer)h.getAttribute("userid");	
		
		UsersDAO d=new UsersDAO();
		UsersBean b=d.findByEmpNo(userid);
		out.println("<br>");
		out.println("<form action='updateTable' method='post'>");
		out.println("<table>");
		out.println(" <tr>");
		out.println(" <th><h2>Update USER Profile</h2></th>");
		out.println(" <th></th>");
		out.println(" <th></th>");
		out.println(" </tr><br>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Name</th>");
		out.println(" <td><input type='text' value='"+b.getName()+"'name='name'></td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Username</th>");
		out.println(" <td><input type='text' value='"+b.getUsername()+"' name='username' readonly ></td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Password</th>");
		out.println(" <td><input type='text' value='"+b.getPassword()+"'name='password'></td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>PhoneNo</th>");
		out.println(" <td><input type='text' value='"+b.getMobile()+"'name='phone'></td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Email</th>");
		out.println(" <td><input type='text' value='"+b.getEmail()+"'name='email'></td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Address</th>");
		out.println(" <td><input type='text' value='"+b.getAddress()+"'name='address'></td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th></th>");
		out.println(" <td><input type='submit' value='Update' target='_self'></td>");
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
