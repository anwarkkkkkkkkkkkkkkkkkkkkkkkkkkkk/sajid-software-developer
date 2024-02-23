package com.PersonalInventorySystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.PersonalInventorySystem.bean.BankBookBean;
import com.PersonalInventorySystem.bean.ExpensesBean;
import com.PersonalInventorySystem.bean.ExpensesCategoryBean;
import com.PersonalInventorySystem.bean.IncomeBean;
import com.PersonalInventorySystem.utility.ConnectionPool;

public class ExpensesDAO {
	
public int addEmployee(ExpensesBean ex) {
		
		Connection conn=ConnectionPool.connectDB();
		String sql="insert into expenses(exp_ac,userid,exp_catid,amount,transaction_date,payby,remark) values('"+ex.getExp_ac()+"','"+ex.getUserid()+"','"+ex.getExp_catid()+"','"+ex.getAmount()+"','"+ex.getTransaction_date()+"','"+ex.getPayby()+"','"+ex.getRemark()+"')";
		
		int r=0;
		try {
		      Statement stmt= conn.createStatement();
		      r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		     e.printStackTrace();
	      }
		
	return r;
	}

	
		public int UpdateEmployee(ExpensesBean ex) {

		Connection conn=ConnectionPool.connectDB();
		
		String sql="update expenses set exp_ac='"+ex.getExp_ac()+"',userid='"+ex.getUserid()+"',transaction_date='"+ex.getTransaction_date()+"',exp_catid='"+ex.getExp_catid()+"',amount='"+ex.getAmount()+"',payby='"+ex.getPayby()+"',remark='"+ex.getRemark()+"' where exp_id='"+ex.getExp_id()+"' ";

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

		String sql=" delete from expenses where exp_id='"+acid+"'";
		
		int r=0;
		try {			
		      Statement stmt=conn.createStatement();
		      r=stmt.executeUpdate(sql);     
		   } catch (SQLException e) {
	     	e.printStackTrace();
		   }
	return r;
	}
		
		
		
		public ArrayList<ExpensesBean>findAll(){
			ArrayList<ExpensesBean>eal=new ArrayList<ExpensesBean>();

			Connection conn=ConnectionPool.connectDB();
			
			String sql="select * from expenses";
			
			try {
			   Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery(sql);
			    while(rs.next()) {	
			    	ExpensesBean ex=new ExpensesBean(); 
			    	
			    	ex.setAmount(rs.getDouble("amount"));
			    	ex.setExp_ac(rs.getString("exp_ac"));
			    	ex.setExp_catid(rs.getInt("exp_catid"));
			    	ex.setUserid(rs.getInt("userid"));
			    	ex.setPayby(rs.getString("payby"));
			    	ex.setRemark(rs.getString("remark"));
			    	ex.setExp_id(rs.getInt("exp_id"));
			    	ex.setTransaction_date(rs.getString("transaction_date"));
			    	 	
			        eal.add(ex);
			      }
			     conn.close();
			} catch (SQLException e) {
			      e.printStackTrace();
			}

		return eal;
	  }
		
			public ExpensesBean findByEmpNo(int acid){
				
				ExpensesBean ex=new ExpensesBean();
			    Connection conn=ConnectionPool.connectDB();
			   
			    String sql="select * from expenses where exp_id='"+acid+"' ";

			try {
			     Statement stmt=conn.createStatement();
			     ResultSet rs=stmt.executeQuery(sql);
			        while(rs.next()) {
			        	ex.setAmount(rs.getDouble("amount"));
				    	ex.setExp_ac(rs.getString("exp_ac"));
				    	ex.setExp_catid(rs.getInt("exp_catid"));
				    	ex.setUserid(rs.getInt("userid"));
				    	ex.setPayby(rs.getString("payby"));
				    	ex.setRemark(rs.getString("remark"));
				    	ex.setExp_id(rs.getInt("exp_id"));
				    	ex.setTransaction_date(rs.getString("transaction_date"));
				    	 	
			       }
			     conn.close();
			}catch (SQLException e) {
			      e.printStackTrace();
			}
		return ex;
		}

			public ArrayList<ExpensesBean> findAllDateWise(String sdate, String edate, int userid) {

				ArrayList<ExpensesBean> bal = new ArrayList<ExpensesBean>();

				Connection conn = ConnectionPool.connectDB();

				String sql = "select * from expenses where userid='" + userid + "' and  transaction_date between '" + sdate
						+ "'and '" + edate + "' ";

				try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						
						ExpensesBean bbb = new ExpensesBean();
				        bbb.setAmount(rs.getDouble("amount"));
				        bbb.setExp_ac(rs.getString("exp_ac"));
				        bbb.setPayby(rs.getString("payby"));
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
		
		// TODO Auto-generated method stub
		 ExpensesDAO bbd=new ExpensesDAO();
			
		 ExpensesBean bbb=new  ExpensesBean();
		 
		   bbb.setExp_ac("boi");
       //    bbb.setExp_catid(7);
           bbb.setUserid(12);
           bbb.setExp_catid(11);
           bbb.setAmount(12312.36);
           bbb.setTransaction_date("2022-10-3");
           bbb.setPayby("check");
           bbb.setRemark("done");
           
	        int show=1;
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
			    for( ExpensesBean b:bbd.findAll()) {
				   System.out.println(b.getExp_id()+"  "+b.getExp_ac()+"  "+b.getUserid()+"  "+b.getExp_catid()+"  "+b.getTransaction_date()+"  "+b.getPayby()+"  "+b.getRemark());			
			    }
			}
			if(show==5) {
				 ExpensesBean  b=bbd.findByEmpNo(2);
				  System.out.println(b.getExp_id()+"  "+b.getExp_ac()+"  "+b.getUserid()+"  "+b.getExp_catid()+"  "+b.getTransaction_date()+"  "+b.getPayby()+"  "+b.getRemark());			
			}
			if(show==6) {
			    for( ExpensesBean b:bbd.findAllDateWise("2022-5-03","2022-10-03", 12353)) {
				   System.out.println(b.getExp_ac()+"  "+b.getAmount()+"  "+b.getTransaction_date()+"  "+b.getPayby()+"  "+b.getRemark());			
			    }
			}
		}

}
