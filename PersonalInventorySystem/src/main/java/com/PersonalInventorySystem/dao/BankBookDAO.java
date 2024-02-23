package com.PersonalInventorySystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.BankBookBean;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class BankBookDAO {
	
	public int addEmployee(BankBookBean bbb) {
		
		Connection conn=ConnectionPool.connectDB();
		String sql="insert into bank_book values('"+bbb.getAcid()+"','"+bbb.getAccount()+"','"+bbb.getTransaction_date()+"','"+bbb.getAmount()+"','"+bbb.getUserid()+"','"+bbb.getOperation()+"')";
		
		int r=0;
		try {
		      Statement stmt= conn.createStatement();
		      r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		     e.printStackTrace();
	      }
		
	return r;
	}

	
		public int UpdateEmployee(BankBookBean bbb) {

		Connection conn=ConnectionPool.connectDB();
		
		String sql="update bank_book set account='"+bbb.getAccount()+"',amount='"+bbb.getAmount()+"',transaction_date='"+bbb.getTransaction_date()+"',userid='"+bbb.getUserid()+"',operation='"+bbb.getOperation()+"' where acid='"+bbb.getAcid()+"'";

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

		String sql=" delete from bank_book where acid='"+acid+"'";
		
		int r=0;
		try {			
		      Statement stmt=conn.createStatement();
		      r=stmt.executeUpdate(sql);     
		   } catch (SQLException e) {
	     	e.printStackTrace();
		   }
	return r;
	}
		
		
		
		public ArrayList<BankBookBean>findAll(){
			ArrayList<BankBookBean>bal=new ArrayList<BankBookBean>();

			Connection conn=ConnectionPool.connectDB();
			
			String sql="select * from bank_book";
			
			try {
			   Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery(sql);
			    while(rs.next()) {	
			    	BankBookBean bbb=new BankBookBean(); 
			    	bbb.setAcid(rs.getInt("acid"));
			    	bbb.setAccount(rs.getString("account"));
			    	bbb.setTransaction_date(rs.getString("transaction_date"));
			    	bbb.setAmount(rs.getDouble("amount"));
			    	bbb.setUserid(rs.getInt("userid"));
			    	bbb.setOperation(rs.getString("operation"));
			    	
			        bal.add(bbb);
			      }
			     conn.close();
			} catch (SQLException e) {
			      e.printStackTrace();
			}

		return bal;
	  }
		
			public BankBookBean findByEmpNo(int acid){
				
				BankBookBean bbb=new BankBookBean();
			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select * from bank_book where acid='"+acid+"' ";

			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        while(rs.next()) {
			        	bbb.setAcid(rs.getInt("acid"));
				    	bbb.setAccount(rs.getString("account"));
				    	bbb.setTransaction_date(rs.getString("transaction_date"));
				    	bbb.setAmount(rs.getDouble("amount"));
				    	bbb.setUserid(rs.getInt("userid"));
				    	bbb.setOperation(rs.getString("operation"));
			       }
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
		return bbb;
		}
			
    public ArrayList<BankBookBean> findAllDateWise(String sdate,String edate,int userid){
    	
    	ArrayList<BankBookBean>bl=new ArrayList<BankBookBean>();

			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select transaction_date,amount,operation from bank_book where "
			    		+ "userid='"+userid+"' and  transaction_date between '"+sdate+"'and '"+edate+"' ";

			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        while(rs.next()) {
			        	BankBookBean bbb=new BankBookBean();
				    	bbb.setTransaction_date(rs.getString("transaction_date"));
				    	bbb.setAmount(rs.getDouble("amount"));
				    	bbb.setOperation(rs.getString("operation"));
				    	bl.add(bbb);
			       }
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
		return bl;
		}	
    
    public double closingBalance(int userid) {

		Connection conn = ConnectionPool.connectDB();

		String sql = " select sum(amount) from bank_book where userid='" + userid
				+ "' and operation='receive'";
		String sq2=" select sum(amount) from bank_book where userid='" + userid
				+ "' and operation='Pay' ";
		double closing = 0.0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			 rs.next();
			 	closing = rs.getDouble(1);
			ResultSet rs1 = stmt.executeQuery(sq2);
			   rs1.next();
			   closing=closing-rs1.getDouble(1);
			   conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return closing;
	}
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankBookDAO bbd=new BankBookDAO();
		
        LocalDate d=LocalDate.of(2022,8,6);
     //   LocalDate d1=LocalDate.now();
     //   System.out.println(Date.valueOf(d));
      //  System.out.println(Date.valueOf("2002-3-2"));
      //  System.out.println(d);  System.out.println(d1);
	//	Date d=new Date(10,8,2022);
        
		BankBookBean bbb=new BankBookBean();
		bbb.setAccount("boi");
		bbb.setAcid(100);
	    bbb.setAmount(125323.03);
		bbb.setOperation("online");
		bbb.setTransaction_date("2022-8-7");
		bbb.setUserid(12);
		
		int show=6;
		
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
		    int r2=bbd.DeleteEmployee(123);
		    if(r2>0)System.out.println("your  table data are deleted");
		    else System.out.println("your  table data are not deleted");
		}
		if(show==4) {
		    for(BankBookBean b:bbd.findAll()) {
			   System.out.println("  "+b.getAcid()+"  "+b.getAccount()+"  "+b.getTransaction_date()+"  "+b.getAmount()+"  "+b.getUserid()+"  "+b.getOperation());			
		    }
		}
		if(show==5) {
		    BankBookBean  b=bbd.findByEmpNo(1);
			System.out.println("  "+b.getAcid()+"  "+b.getAccount()+"  "+b.getTransaction_date()+"  "+b.getAmount()+"  "+b.getUserid()+"  "+b.getOperation());			
		}
		if(show==6) {
		    for(BankBookBean b:bbd.findAllDateWise("2022-03-10","2022-10-10",12)) {
			   System.out.println("  "+b.getTransaction_date()+"  "+b.getAmount()+"  "+b.getOperation());			
		    }
		}
		
		
	}

}
