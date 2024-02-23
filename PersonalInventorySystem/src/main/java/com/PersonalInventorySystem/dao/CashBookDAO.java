package com.PersonalInventorySystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.BankBookBean;
import com.PersonalInventorySystem.bean.CashBookBean;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class CashBookDAO {
	
public int addEmployee(CashBookBean bbb) {
		
		Connection conn=ConnectionPool.connectDB();
		String sql="insert into cash_book values('"+bbb.getAcid()+"','"+bbb.getAccount()+"','"+bbb.getTransaction_date()+"','"+bbb.getAmount()+"','"+bbb.getUserid()+"','"+bbb.getOperation()+"')";
		
		int r=0;
		try {
		      Statement stmt= conn.createStatement();
		      r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		     e.printStackTrace();
	      }
		
	return r;
	}

	
		public int UpdateEmployee(CashBookBean bbb) {

		Connection conn=ConnectionPool.connectDB();
		
		String sql="update cash_book set account='"+bbb.getAccount()+"',amount='"+bbb.getAmount()+"',transaction_date='"+bbb.getTransaction_date()+"',userid='"+bbb.getUserid()+"',operation='"+bbb.getOperation()+"' where acid='"+bbb.getAcid()+"'";

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

		String sql=" delete from cash_book where acid='"+acid+"'";
		
		int r=0;
		try {			
		      Statement stmt=conn.createStatement();
		      r=stmt.executeUpdate(sql);     
		   } catch (SQLException e) {
	     	e.printStackTrace();
		   }
	return r;
	}
		
		
		
		public ArrayList<CashBookBean>findAll(){
			ArrayList<CashBookBean>bal=new ArrayList<CashBookBean>();

			Connection conn=ConnectionPool.connectDB();
			
			String sql="select * from cash_book";
			
			try {
			   Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery(sql);
			    while(rs.next()) {	
			    	CashBookBean bbb=new CashBookBean(); 
			    	
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
		
			public CashBookBean findByEmpNo(int acid){
				
				CashBookBean bbb=new CashBookBean();
			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select * from cash_book where acid='"+acid+"' ";

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

		public ArrayList<CashBookBean> findAllDateWise(String sdate, String edate, int userid) {

			ArrayList<CashBookBean> bal = new ArrayList<CashBookBean>();

			Connection conn = ConnectionPool.connectDB();

			String sql = "select * from cash_book where userid='" + userid + "' and  transaction_date between '" + sdate
					+ "'and '" + edate + "' ";

			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					CashBookBean bbb = new CashBookBean();
					bbb.setTransaction_date(rs.getString("transaction_date"));
					bbb.setAmount(rs.getDouble("amount"));
					bbb.setOperation(rs.getString("operation"));
					bal.add(bbb);
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bal;
		}

		public double closingBalance(int userid) {

			Connection conn = ConnectionPool.connectDB();

			String sql = " select sum(amount) from cash_book where userid='" + userid
					+ "' and operation='receive'";
			String sq2=" select sum(amount) from cash_book where userid='" + userid
					+ "' and operation='Pay' ";
			double closing = 0;
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
		
        CashBookDAO bbd=new CashBookDAO();
		
        CashBookBean bbb=new CashBookBean();
        
		bbb.setAccount("boi");
		bbb.setAcid(10);
		bbb.setOperation("online");
		String a="2022-8-3";
		//Date d=Date.
		bbb.setTransaction_date(a);
		bbb.setAmount(1253);
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
		    int r2=bbd.DeleteEmployee(1);
		    if(r2>0)System.out.println("your  table data are deleted");
		    else System.out.println("your  table data are not deleted");
		}
		if(show==4) {
		    for(CashBookBean b: bbd.findAll()) {
			   System.out.println("  "+b.getAcid()+"  "+b.getAccount()+"  "+b.getTransaction_date()+"  "+b.getAmount()+"  "+b.getUserid()+"  "+b.getOperation());			
		    }
		}
		if(show==5) {
			CashBookBean  b=bbd.findByEmpNo(5);
			System.out.println("  "+b.getAcid()+"  "+b.getAccount()+"  "+b.getTransaction_date()+"  "+b.getAmount()+"  "+b.getUserid()+"  "+b.getOperation());			
		}
		
		if(show==6) {
		    for(CashBookBean b: bbd.findAllDateWise("2022-8-3", "2022-10-11",12)) {
			   System.out.println("  "+b.getTransaction_date()+"  "+b.getAmount()+"  "+b.getOperation());			
		    }
	   }
		if(show==7) {
			   System.out.println("  "+bbd.closingBalance(12));			
		    }
	}


}
