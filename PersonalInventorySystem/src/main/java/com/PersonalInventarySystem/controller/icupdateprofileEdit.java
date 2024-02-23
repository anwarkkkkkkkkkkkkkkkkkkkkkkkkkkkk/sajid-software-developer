package com.PersonalInventarySystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.PersonalInventorySystem.bean.IncomeCategoryBean;
import com.PersonalInventorySystem.dao.IncomeCategoryDAO;

/**
 * Servlet implementation class updateprofileEdit
 */
public class icupdateprofileEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public icupdateprofileEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out=response.getWriter();
			int idic = Integer.parseInt(request.getParameter("myidic"));
			 
			IncomeCategoryDAO d=new IncomeCategoryDAO();
			IncomeCategoryBean b=d.findByEmpNo(idic);

			HttpSession hs=request.getSession();
			hs.setAttribute("myidic", idic);
			out.println("<br>");
			out.println("<form action='icupdateAdd' method='post'>");
			out.println("<br>");
			out.println("Name<input type = 'text' name = 'name' value="+b.getInc_catname()+">");
			out.println("<br>");
			out.println("details<input type = 'text' name = 'details' value="+b.getInc_catdetails()+">");
			out.println("<input type = 'submit' value = 'update' target='_parents'>");

			out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
