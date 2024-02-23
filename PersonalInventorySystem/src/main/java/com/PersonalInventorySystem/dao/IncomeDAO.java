package com.PersonalInventorySystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.CashBookBean;
import com.PersonalInventorySystem.bean.ExpensesBean;
import com.PersonalInventorySystem.bean.IncomeBean;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class IncomeDAO {
	
public int addEmployee(IncomeBean ex) {
		
		Connection conn=ConnectionPool.connectDB();
		String sql="insert into incomes(inc_ac,userid,amount,transaction_date,receivby,remark,inc_catid) values('"+ex.getInc_ac()+"','"+ex.getUserid()+"','"+ex.getAmount()+"','"+ex.getTransaction_date()+"','"+ex.getReceivby()+"','"+ex.getRemark()+"','"+ex.getInc_catid()+"')";
		
		int r=0;
		try {
		      Statement stmt= conn.createStatement();
		      r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		     e.printStackTrace();
	      }
		
	return r;
	}

	
		public int UpdateEmployee(IncomeBean ex) {

		Connection conn=ConnectionPool.connectDB();
		
		String sql="update incomes set inc_ac='"+ex.getInc_ac()+"',userid='"+ex.getUserid()+"',transaction_date='"+ex.getTransaction_date()+"',inc_catid='"+ex.getInc_catid()+"',amount='"+ex.getAmount()+"',receivby='"+ex.getReceivby()+"',remark='"+ex.getRemark()+"' where inc_id='"+ex.getInc_id()+"' ";

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

		String sql=" delete from incomes where inc_id='"+acid+"'";
		
		int r=0;
		try {			
		      Statement stmt=conn.createStatement();
		      r=stmt.executeUpdate(sql);     
		   } catch (SQLException e) {
	     	e.printStackTrace();
		   }
	return r;
	}
		
		
		
		public ArrayList<IncomeBean>findAll(){
			ArrayList<IncomeBean>eal=new ArrayList<IncomeBean>();

			Connection conn=ConnectionPool.connectDB();
			
			String sql="select * from incomes";
			
			try {
			   Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery(sql);
			    while(rs.next()) {	
			    	IncomeBean ex=new IncomeBean(); 
			    	
			    	ex.setAmount(rs.getDouble("amount"));
			    	ex.setInc_ac(rs.getString("inc_ac"));
			    	ex.setInc_catid(rs.getInt("inc_catid"));
			    	ex.setUserid(rs.getInt("userid"));
			    	ex.setReceivby(rs.getString("receivby"));
			    	ex.setRemark(rs.getString("remark"));
			    	ex.setInc_id(rs.getInt("inc_id"));
			    	ex.setTransaction_date(rs.getString("transaction_date"));
			    	 	
			        eal.add(ex);
			      }
			     conn.close();
			} catch (SQLException e) {
			      e.printStackTrace();
			}

		return eal;
	  }
		
			public IncomeBean findByEmpNo(int acid){
				
				IncomeBean ex=new IncomeBean();
			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select * from incomes where inc_id='"+acid+"' ";

			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        while(rs.next()) {
			        	ex.setAmount(rs.getDouble("inc_amount"));
				    	ex.setInc_ac(rs.getString("inc_ac"));
				    	ex.setInc_catid(rs.getInt("catid"));
				    	ex.setUserid(rs.getInt("userid"));
				    	ex.setReceivby(rs.getString("receivby"));
				    	ex.setRemark(rs.getString("remark"));
				    	ex.setInc_id(rs.getInt("inc_id"));
				    	ex.setTransaction_date(rs.getString("transaction_date"));
				 
				    	 	
			       }
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
		return ex;
		}
			
			public ArrayList<IncomeBean> findAllDateWise(String sdate, String edate, int userid) {

				ArrayList<IncomeBean> bal = new ArrayList<IncomeBean>();

				Connection conn = ConnectionPool.connectDB();

				String sql = "select * from incomes where userid='" + userid + "' and  transaction_date between '" + sdate
						+ "'and '" + edate + "' ";

				try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						IncomeBean bbb = new IncomeBean();
				        bbb.setAmount(rs.getDouble("amount"));
				        bbb.setInc_ac(rs.getString("inc_ac"));
				        bbb.setReceivby(rs.getString("receivby"));
				        bbb.setRemark(rs.getString("remark"));
				        bbb.setTransaction_date(rs.getString("transaction_date"));
						bal.add(bbb);
					}
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return bal;
			}



	public static void main(String[] args) {
		
		 IncomeDAO bbd=new IncomeDAO();
			
		 IncomeBean bbb=new  IncomeBean();
		 
		   bbb.setInc_ac("boi");
           bbb.setInc_catid(3);
           bbb.setUserid(12353);
           bbb.setInc_id(102);
           bbb.setAmount(12302.36);
           bbb.setTransaction_date("2001-10-3");
           bbb.setReceivby("cash");
           bbb.setRemark("done");
           
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
			    for( IncomeBean b:bbd.findAll()) {
				   System.out.println(b.getInc_id()+"  "+b.getInc_ac()+"  "+b.getUserid()+"  "+b.getAmount()+"  "+b.getTransaction_date()+"  "+b.getReceivby()+"  "+b.getRemark()+"  "+b.getInc_catid());			
			    }
			}
			if(show==5) {
				IncomeBean  b=bbd.findByEmpNo(2);
				 System.out.println(b.getInc_id()+"  "+b.getInc_ac()+"  "+b.getUserid()+"  "+b.getAmount()+"  "+b.getTransaction_date()+"  "+b.getReceivby()+"  "+b.getRemark()+"  "+b.getInc_catid());	
			}
			if(show==6) {
			    for( IncomeBean b:bbd.findAllDateWise("2001-10-03","2001-10-03", 12353)) {
				   System.out.println(b.getInc_ac()+"  "+b.getAmount()+"  "+b.getTransaction_date()+"  "+b.getReceivby()+"  "+b.getRemark());			
			    }
			}
			
		}

}
