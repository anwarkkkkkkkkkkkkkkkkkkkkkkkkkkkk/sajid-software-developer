package com.PersonalInventorySystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.ExpensesCategoryBean;
import com.PersonalInventorySystem.bean.IncomeCategoryBean;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class IncomeCategoryDAO {
	
public int addEmployee(IncomeCategoryBean ex) {
		
		Connection conn=ConnectionPool.connectDB();
		String sql="insert into income_category(inc_catname,inc_catdetails,userid) values('"+ex.getInc_catname()+"','"+ex.getInc_catdetails()+"','"+ex.getUserid()+"')";
		
		int r=0;
		try {
		      Statement stmt= conn.createStatement();
		      r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		     e.printStackTrace();
	      }
		
	return r;
	}

	
		public int UpdateEmployee(IncomeCategoryBean ex) {

		Connection conn=ConnectionPool.connectDB();
		
		String sql="update income_category set inc_catdetails='"+ex.getInc_catdetails()+"',inc_catname='"+ex.getInc_catname()+"',userid='"+ex.getUserid()+"' where inc_catid='"+ex.getInc_catid()+"' ";

		int r=0;
		try {
		     Statement stmt=conn.createStatement();
		     r=stmt.executeUpdate(sql);
		
		  } catch (SQLException e) {
		      e.printStackTrace();
	     	}
	return r;
	}

		public int DeleteEmployee(int exp_catid) {
			
		Connection conn=ConnectionPool.connectDB();

		String sql=" delete from income_category where inc_catid='"+exp_catid+"'";
		
		int r=0;
		try {			
		      Statement stmt=conn.createStatement();
		      r=stmt.executeUpdate(sql);     
		   } catch (SQLException e) {
	     	e.printStackTrace();
		   }
	return r;
	}
		
		
		
		public ArrayList<IncomeCategoryBean>findAll(int userid){
			ArrayList<IncomeCategoryBean>eal=new ArrayList<IncomeCategoryBean>();

			Connection conn=ConnectionPool.connectDB();
			
			String sql="select * from income_category where userid between '"+userid+"' and '"+userid+"' ";
			
			try {
			   Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery(sql);
			    while(rs.next()) {	
			    	IncomeCategoryBean ex=new IncomeCategoryBean(); 
			    	
			    	ex.setInc_catdetails(rs.getString("inc_catdetails"));
			    	ex.setInc_catid(rs.getInt("inc_catid"));
			    	ex.setInc_catname(rs.getString("inc_catname"));
			    	ex.setUserid(rs.getInt("userid"));		 	    
			    	
			        eal.add(ex);
			      }
			     conn.close();
			} catch (SQLException e) {
			      e.printStackTrace();
			}

		return eal;
	  }
		
			public IncomeCategoryBean findByEmpNo(int exp_catid){
				
				IncomeCategoryBean ex=new IncomeCategoryBean();
			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select * from income_category where inc_catid='"+exp_catid+"' ";

			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        while(rs.next()) {
			        	ex.setInc_catdetails(rs.getString("inc_catdetails"));
				    	ex.setInc_catid(rs.getInt("inc_catid"));
				    	ex.setInc_catname(rs.getString("inc_catname"));
				    	ex.setUserid(rs.getInt("userid"));		 
			       }
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
		return ex;
		}

	public static void main(String[] args) {
		
		 IncomeCategoryDAO bbd=new IncomeCategoryDAO();
			
		 IncomeCategoryBean bbb=new  IncomeCategoryBean();
           bbb.setInc_catdetails("abcdghffd");
           bbb.setInc_catid(5);
           bbb.setInc_catname("tangim");
           bbb.setUserid(123532);
           
	        int show=3;
	        if(show==1) {
			   int r=bbd.addEmployee(bbb);
			   if(r>0 &&show==1)System.out.println("your  table data are inserted");
			   else System.out.println("your table data are not inserted");
			}
			
			if(show==2) {
			   int r1=bbd.UpdateEmployee(bbb);
			   if(r1>0)System.out.println("your table data are updated");
			   else System.out.println("your table data are not updated");
			}
			if(show==3) {
			    int r2=bbd.DeleteEmployee(5);
			    if(r2>0)System.out.println("your  table data are deleted");
			    else System.out.println("your  table data are not deleted");
			}
			if(show==4) {
			    for( IncomeCategoryBean b:bbd.findAll(1)) {
				   System.out.println("  "+b.getInc_catid()+"  "+b.getInc_catname()+"  "+b.getInc_catdetails()+"  "+b.getUserid());			
			    }
			}
			if(show==5) {
				IncomeCategoryBean  b=bbd.findByEmpNo(5);
				System.out.println("  "+b.getInc_catid()+"  "+b.getInc_catname()+"  "+b.getInc_catdetails()+"  "+b.getUserid());			
			}
		}

}
