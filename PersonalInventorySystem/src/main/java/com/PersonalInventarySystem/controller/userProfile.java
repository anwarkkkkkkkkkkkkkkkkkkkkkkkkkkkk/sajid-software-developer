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

public class userProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userProfile() {
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
		UsersBean b =d.findByEmpNo(userid);
	
		out.println("<table>");
		out.println(" <tr>");
		out.println(" <th><h2>User Profile</h2></th>");
		out.println(" <th></th>");
		out.println(" <th></th>");
		out.println(" </tr><br>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Name</th>");
		out.println(" <td>"+b.getName() +"</td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Username</th>");
		out.println(" <td>"+b.getUsername() +"</td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Password</th>");
		out.println(" <td>"+b.getPassword()+"</td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>PhoneNo</th>");
		out.println(" <td>"+b.getMobile()+"</td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Email</th>");
		out.println(" <td>"+b.getEmail()+"</td>");
		out.println(" </tr>");  
		
		out.println(" <tr>");
		out.println(" <th></th>");
		out.println(" <th>Address</th>");
		out.println(" <td>"+b.getAddress()+"</td>");
		out.println(" </tr>");  
			
		out.println("</table>");
		
		out.println("<style>");
		out.println(" #profile{ background-color:red; font-size:20px}");
		out.println("</style>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
