package com.PersonalInventorySystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.BankBookBean;
import com.PersonalInventorySystem.bean.ExpensesCategoryBean;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class ExpensesCategoryDAO {
	
public int addEmployee(ExpensesCategoryBean ex) {
		
		Connection conn=ConnectionPool.connectDB();
		String sql="insert into expenses_category values('"+ex.getExp_catid()+"','"+ex.getExp_catname()+"','"+ex.getExp_catdetails()+"','"+ex.getUserid()+"')";
		
		int r=0;
		try {
		      Statement stmt= conn.createStatement();
		      r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		     e.printStackTrace();
	      }
		
	return r;
	}

	
		public int UpdateEmployee(ExpensesCategoryBean ex) {

		Connection conn=ConnectionPool.connectDB();
		
		String sql="update expenses_category set exp_catdetails='"+ex.getExp_catdetails()+"',exp_catname='"+ex.getExp_catname()+"',userid='"+ex.getUserid()+"' where exp_catid='"+ex.getExp_catid()+"' ";

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

		String sql=" delete from expenses_category where exp_catid='"+exp_catid+"'";
		
		int r=0;
		try {			
		      Statement stmt=conn.createStatement();
		      r=stmt.executeUpdate(sql);     
		   } catch (SQLException e) {
	     	e.printStackTrace();
		   }
	return r;
	}
		
		
		
		public ArrayList<ExpensesCategoryBean>findAll(int userid){
			ArrayList<ExpensesCategoryBean>eal=new ArrayList<ExpensesCategoryBean>();

			Connection conn=ConnectionPool.connectDB();
			
			String sql="select * from expenses_category where userid between '"+userid+"' and '"+userid+"' ";
			
			try {
			   Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery(sql);
			    while(rs.next()) {	
			    	ExpensesCategoryBean ex=new ExpensesCategoryBean(); 
			    	
			    	ex.setExp_catdetails(rs.getString("exp_catdetails"));
			    	ex.setExp_catid(rs.getInt("exp_catid"));
			    	ex.setExp_catname(rs.getString("exp_catname"));
			    	ex.setUserid(rs.getInt("userid"));		    
			    	
			        eal.add(ex);
			      }
			     conn.close();
			} catch (SQLException e) {
			      e.printStackTrace();
			}

		return eal;
	  }
		
			public ExpensesCategoryBean findByEmpNo(int exp_catid){
				
				ExpensesCategoryBean ex=new ExpensesCategoryBean();
			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select * from expenses_category where exp_catid='"+exp_catid+"' ";

			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        while(rs.next()) {
			        	ex.setExp_catdetails(rs.getString("exp_catdetails"));
				    	ex.setExp_catid(rs.getInt("exp_catid"));
				    	ex.setExp_catname(rs.getString("exp_catname"));
				    	ex.setUserid(rs.getInt("userid"));		 
			       }
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
		return ex;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ExpensesCategoryDAO bbd=new ExpensesCategoryDAO();
			
		 ExpensesCategoryBean bbb=new  ExpensesCategoryBean();
            bbb.setExp_catdetails("abcdgh");
            bbb.setExp_catid(3);
            bbb.setExp_catname("sajid");
            bbb.setUserid(12353);
            
	        int show=4;
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
			    int r2=bbd.DeleteEmployee(2);
			    if(r2>0)System.out.println("your  table data are deleted");
			    else System.out.println("your  table data are not deleted");
			}
			if(show==4) {
			    for( ExpensesCategoryBean b:bbd.findAll(1)) {
				   System.out.println("  "+b.getExp_catid()+"  "+b.getExp_catname()+"  "+b.getExp_catdetails()+"  "+b.getUserid());			
			    }
			}
			if(show==5) {
				 ExpensesCategoryBean  b=bbd.findByEmpNo(2);
				System.out.println("  "+b.getExp_catid()+"  "+b.getExp_catname()+"  "+b.getExp_catdetails()+"  "+b.getUserid());			
			}
		}

}
