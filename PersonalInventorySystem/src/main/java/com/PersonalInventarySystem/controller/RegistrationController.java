package com.PersonalInventarySystem.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.PersonalInventorySystem.bean.UsersBean;
import com.PersonalInventorySystem.dao.UsersDAO;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession hs=request.getSession();
		
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		UsersBean b=new UsersBean();
		
	//	String findide="select userid from users where username ="+username+" and password="+password+"";	
		
		 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
		 out.println("<script type='text/javascript' src='form.js'></script>");
         
		b.setAddress(address);
		b.setEmail(email);
		b.setMobile(phone);
		b.setName(name);
		b.setPassword(password);
		b.setUsername(username);		
		UsersDAO d=new UsersDAO();
		
		  hs.setAttribute("name",name);	
          hs.setAttribute("username",username);	
          hs.setAttribute("password",password);	
          hs.setAttribute("cpassword",cpassword);	
          hs.setAttribute("address", address);
          hs.setAttribute("phone", phone);
          hs.setAttribute("email", email);
          
		
		String s="";
		int count=0;
		if(s!=name && s!=address && s!=phone && s!=password && s!=username && s!=email && phone.length()==10)  {
		    		 
             if(cpassword.equals(password)) {
            	 
            	 for(UsersBean b1:d.findAll()) {
     				if(b1.getUsername().equals(b.getUsername()))
     				{ count++;break;}
     			}
     			
     			if(count==0) {
     		          int x=d.addEmployee(b);
     		          
     		          if(x>0) response.sendRedirect("login");  
     		          else { out.println("<h1><font color='red' size='20px'>please register </font></h1>");	
     		           request.getRequestDispatcher("form1.jsp").include(request, response);
     		         // response.sendRedirect("form1.jsp");  
     		           }
     		          
     			}else {  out.println("<h1><font color='red' size='20px'> please enter unique username </font></h1>");
     			       request.getRequestDispatcher("form1.jsp").include(request, response);
     			       // response.sendRedirect("form1.jsp");
     			      }
     			
             }	else {
                  out.println("<h1><font color='red' size='20px'> our conform password are not matching </font></h1>");
		          request.getRequestDispatcher("form1.jsp").include(request, response);
		         // response.sendRedirect("form1.jsp");
             }
             
		} else {
			  out.println("<h1><font color='red' size='20px'> please register all field </font></h1>");
			  //  response.sendRedirect("Registration Form.html");
				    RequestDispatcher rd=request.getRequestDispatcher("form1.jsp");
			          rd.include(request, response);
			      //response.sendRedirect("form1.jsp");
			    
		     }
		
		
 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
