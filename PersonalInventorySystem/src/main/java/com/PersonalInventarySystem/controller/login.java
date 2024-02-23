package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		 h.invalidate();
		 
		 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
 	     out.println("<script type='text/javascript' src='form.js'> </script>");
		 
		out.println("<style>");
		out.println("a {text-decoration: none; font-size:20px; color:blue;} ");
		out.println(" a:hover {background-color:orange;border:1px black solid;}");
		out.println(" #tablef{ border:2px dotted blue;padding:10px;background-color:black;}");
		out.println("</style>");
	   
		out.println(" <form > <table id='tablef'>"); 
		out.println("  <tr>");
		out.println("  <th> <font color='blue' size='20px'>       Personal</font>");
		//out.println("  <th> <a href='homePageController' target='_parent' style='padding:5px '>Home</a> </th>");
		out.println("  <th><a href='Registration Form.html' target='_parent' style='padding:5px' id='ru'>RegisterUser</a></th>");               
		out.println("<th><a href='login' target='_parent' style='padding:5px' id='li' >Login</a></th>");               
		out.println(" </tr>");
		out.println("  <tr>");
		out.println(" <th> <font color='orange' size='20p'>Inventory</font> <font color='green' size='20px'>System</font></th>");
		out.println(" </tr>");      
		out.println(" </table>");
		out.println("</form>");
		
		out.println("<form style=' color:blue' action='loginController' method='post' id='sf'>");
		out.println("<fieldset>");
		out.println("<legend align='left' >");
		out.println("<strong> Login </strong>");
		out.println("</legend>");
		out.println("<table >");
		out.println(" <tr> <th>Username: </th> <td><input type='text' name='username' id='lu'></td> </tr>");
		out.println(" <tr> <th>Password:</th> <td><input type='password' name='password' id='lp'></td></td>");
		out.println("<tr> <th></th> <th><input type='submit' value='login' > </th>");
		out.println(" <th> <input type='submit' value='Clear' ></th> </tr>");
		out.println("</table>");
		out.println("</fieldset>");
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
