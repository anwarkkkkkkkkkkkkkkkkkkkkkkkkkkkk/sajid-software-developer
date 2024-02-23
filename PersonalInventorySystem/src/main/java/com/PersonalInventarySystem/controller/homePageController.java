package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class homePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public homePageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession h=request.getSession();
		String name=(String)h.getAttribute("name");
		int userid=(Integer)h.getAttribute("userid");	
		
		out.println("<title>PersonalInventorySystem</title>");
		out.println("<style>");
		out.println("a {text-decoration: none; font-size:20px; color:blue;} ");
		out.println(" a:hover {background-color:orange;border:1px black solid;}");
		out.println(" #tablef{padding:10px;background-color:black;}");
		out.println(" #data{ background-color:brown;}");
		out.println(" #name{ background-color:orange; color:blue;}");
		out.println(" body{ background-color:green; font-size:20px}");
		
		 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
	 	 out.println("<script type='text/javascript' src='form.js'> </script>");
		
		//out.println(" #home{ background-color:red; font-size:20px}");
		
		
		out.println("</style>");
	   
		out.println(" <form > <table id='tablef' action='homePageController'>"); 
		out.println("  <tr>");
		out.println("  <th> <font color='blue' size='20px'>       Personal</font>");
		out.println("  <th> <a href='homePageController' id='home' target='_parent' style='padding:5px' >Home</a> </th>");
		out.println(" <th> <a href='userProfile' id='profile' target='framename' style='padding:5px' >Profile</a> </th>");
		out.println("  <th><a href='updateProfile' id='uprofile'  target='framename'style='padding:5px'  >Update Profile</a></th>");               
		out.println("<th><a href='login' id='login'  target='_parent' style='padding:5px' >Logout</a></th>");               
		out.println(" </tr>");
		out.println("  <tr>");
		out.println(" <th> <font color='orange' size='20p'>Inventory</font> <font color='green' size='20px'>System</font></th>");
		out.println(" </tr>");   		
		
		out.println(" </table>");
		out.println("</form>");
	
	//	if(name==null) response.sendRedirect("login"); 
		out.println("<h1 id='name'><marquee direction='right'>"+name+"</marquee></h1>");
	//	out.println("<marquee direction='right'>"+name+"</marquee>");
		out.println("<iframe src='linkTableController' height='330px' width='220px'></iframe>");
		out.println("<iframe id='data' src='' height='330px' width='600px' name='framename'></iframe>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
