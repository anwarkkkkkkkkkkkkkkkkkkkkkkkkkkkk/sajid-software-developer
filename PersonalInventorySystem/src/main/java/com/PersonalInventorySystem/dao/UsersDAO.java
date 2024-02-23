package com.PersonalInventorySystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.IncomeBean;
import com.PersonalInventorySystem.bean.UsersBean;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class UsersDAO {
	
public int addEmployee(UsersBean ex) {
		
		Connection conn=ConnectionPool.connectDB();
		String sql="insert into users(username,password,name,address,mobile,email) values('"+ex.getUsername()+"','"+ex.getPassword()+"','"+ex.getName()+"','"+ex.getAddress()+"','"+ex.getMobile()+"','"+ex.getEmail()+"' )";
		
		int r=0;
		try {
		      Statement stmt= conn.createStatement();
		      r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		     e.printStackTrace();
	      }
		
	return r;
	}

	
		public int UpdateEmployee(UsersBean ex) {

		Connection conn=ConnectionPool.connectDB();
		
		String sql="update users set address='"+ex.getAddress()+"',password='"+ex.getPassword()+"',email='"+ex.getEmail()+"',name='"+ex.getName()+"',mobile='"+ex.getMobile()+"',username='"+ex.getUsername()+"'  where userid='"+ex.getUserid()+"' ";

		int r=0;
		try {
		     Statement stmt=conn.createStatement();
		     r=stmt.executeUpdate(sql);
		
		  } catch (SQLException e) {
		      e.printStackTrace();
	     	}
	return r;
	}

		public int DeleteEmployee(int acid) {
			
		Connection conn=ConnectionPool.connectDB();

		String sql=" delete from users where userid='"+acid+"'";
		
		int r=0;
		try {			
		      Statement stmt=conn.createStatement();
		      r=stmt.executeUpdate(sql);     
		   } catch (SQLException e) {
	     	e.printStackTrace();
		   }
	return r;
	}
		
		
		
		public ArrayList<UsersBean>findAll(){
			ArrayList<UsersBean>eal=new ArrayList<UsersBean>();

			Connection conn=ConnectionPool.connectDB();
			
			String sql="select * from users";
			
			try {
			   Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery(sql);
			    while(rs.next()) {	
			    	UsersBean ex=new UsersBean(); 
			    
			    	ex.setPassword(rs.getString("password"));
			    	ex.setUsername(rs.getString("username"));
			    	ex.setName(rs.getString("name"));
			    	ex.setAddress(rs.getString("address"));
			    	ex.setMobile(rs.getString("mobile"));
			    	ex.setEmail(rs.getString("email"));
			    	ex.setUserid(rs.getInt("userid"));
			    	 	
			        eal.add(ex);
			      }
			     conn.close();
			} catch (SQLException e) {
			      e.printStackTrace();
			}

		return eal;
	  }
		
			public UsersBean findByEmpNo(int acid){
				
				UsersBean ex=new UsersBean();
			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select * from users where userid='"+acid+"' ";

			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        while(rs.next()) {
			        	
				    	ex.setPassword(rs.getString("password"));
				    	ex.setUsername(rs.getString("username"));
				    	ex.setName(rs.getString("name"));
				    	ex.setAddress(rs.getString("address"));
				    	ex.setMobile(rs.getString("mobile"));
				    	ex.setEmail(rs.getString("email"));
				    	ex.setUserid(rs.getInt("userid"));
				    	 				    	 	
			       }
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
		return ex;
		}
       
	public UsersBean authenticate(String username,String password){
				
				UsersBean ex=new UsersBean();
			    Connection conn=ConnectionPool.connectDB();
			    UsersBean b=new UsersBean();
			    String sql="select name,userid from users where password='"+password+"' and username='"+username+"' ";
			    String name=null;
			    int id = 0;
			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        rs.next();
				       ex.setName(rs.getString("name"));
				       ex.setUserid(rs.getInt("userid"));
				       
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
			
		return ex;
		}	



	public static void main(String[] args) {

		 UsersDAO bbd=new  UsersDAO();
			
		 UsersBean bbb=new UsersBean();
		 
		  bbb.setPassword("sajid@12345");
          bbb.setUsername("hello01120");
          bbb.setName("sahid");
          bbb.setAddress("bhopal");
          bbb.setMobile("1234567890");
          bbb.setEmail("abas@gmail.com");
        //  bbb.setUserid(1);
          
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
			    int r2=bbd.DeleteEmployee(7);
			    if(r2>0)System.out.println("your  table data are deleted");
			    else System.out.println("your  table data are not deleted");
			}
			if(show==4) {
			    for(UsersBean b:bbd.findAll()) {
				   System.out.println(b.getUserid()+"  "+b.getUsername()+"  "+b.getPassword()+"  "+b.getName()+"  "+b.getAddress()+"  "+b.getMobile()+"  "+b.getEmail());			
			    }
			}
			if(show==5) {
				 UsersBean  b=bbd.findByEmpNo(1);
				 System.out.println(b.getUserid()+"  "+b.getUsername()+"  "+b.getPassword()+"  "+b.getName()+"  "+b.getAddress()+"  "+b.getMobile()+"  "+b.getEmail());						
			}
		}
}
