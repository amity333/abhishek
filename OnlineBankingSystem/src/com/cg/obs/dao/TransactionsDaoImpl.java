package com.cg.obs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.obs.dto.Customer;
import com.cg.obs.dto.Transactions;
import com.cg.obs.exception.BankException;
import com.cg.obs.util.DBUtil;
import com.cg.obs.util.MyStringDateUtil;

public class TransactionsDaoImpl implements TransactionsDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	@Override
	public ArrayList<Transactions> viewTransaction(LocalDate date) throws BankException {
		// TODO Auto-generated method stub
		Date sqlDate=MyStringDateUtil.fromLocalToSqlDate(date);
		ArrayList<Transactions> transactionsList=new ArrayList<Transactions>();
		try {
			pst=con.prepareStatement(QueryMapper.DISPLAY_DAILY_TRANSACTIONS);
			pst.setDate(1, sqlDate);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				int transId=rs.getInt(1);
				String transDesc=rs.getString(2);
				LocalDate transDate=MyStringDateUtil.fromSqlToLocalDate(rs.getDate(3));
				String transType=rs.getString(4);
				double transamt=rs.getDouble(5);
				long accId=rs.getLong(6);
				Transactions tr=new Transactions(transId, transDesc, transDate, transType, transamt , accId);
				transactionsList.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
		
		return transactionsList;
	}
	@Override
	public ArrayList<Transactions> viewTransaction(int period,
			String duration) throws BankException {
		// TODO Auto-generated method stub
		LocalDate start,end;
		if(duration.equalsIgnoreCase("monthly"))
		{
			start=LocalDate.of(2019, period , 1);
			if(period==2)
				end=LocalDate.of(2019, period, 28);
			else if(period==1 || period==3 || period==5 ||period==7 || period==8 || period==10 || period==12)
				end=LocalDate.of(2019, period, 31);
			else
				end=LocalDate.of(2019, period, 30);
		}
		if(duration.equalsIgnoreCase("yearly"));
		{
			start=LocalDate.of(period, 1 , 1);
			end=LocalDate.of(period, 12 , 31);
		}
		Date sqlStart=MyStringDateUtil.fromLocalToSqlDate(start);
		Date sqlEnd=MyStringDateUtil.fromLocalToSqlDate(end);
		ArrayList<Transactions> transactionsList=new ArrayList<Transactions>();
		try {
			pst=con.prepareStatement(QueryMapper.DISPLAY_ALL_TRANSACTIONS);
			pst.setDate(1, sqlStart);
			pst.setDate(2, sqlEnd);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				int transId=rs.getInt(1);
				String transDesc=rs.getString(2);
				LocalDate transDate=MyStringDateUtil.fromSqlToLocalDate(rs.getDate(3));
				String transType=rs.getString(4);
				double transamt=rs.getDouble(5);
				long accId=rs.getLong(6);
				Transactions tr=new Transactions(transId, transDesc, transDate, transType, transamt , accId);
				transactionsList.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
		
		return transactionsList;
	}
	public ArrayList<Transactions> viewMini(long accNo) throws BankException {
		// TODO Auto-generated method stub
		
		ArrayList<Transactions> al = new ArrayList<>();
		int dataInserted=0;
		con=DBUtil.getconnection();
		
		
			try {
				pst=con.prepareStatement(QueryMapper.MINI_STATEMENT);
			pst.setLong(1, accNo);
				ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							int id = rs.getInt(1);
							String discription = rs.getString(2);
							Date date=rs.getDate(3);
							String type = rs.getString(4);
							int amount = rs.getInt(5);
							long accn = rs.getLong(6);
							
						
							al.add(new Transactions(id, discription,MyStringDateUtil.fromSqlToLocalDate(date), type,amount,accn));
							
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new BankException(e.getMessage());
			}
		
		return al;
	}
	public ArrayList<Transactions> viewDetailed(int accNo,LocalDate startDate,LocalDate endDate) throws BankException {
		// TODO Auto-generated method stub
		
		ArrayList<Transactions> al = new ArrayList<>();
		int dataInserted=0;
		con=DBUtil.getconnection();
		
		
			try {
				pst=con.prepareStatement(QueryMapper.DETAILED_STATEMENT);
			pst.setInt(1, accNo);
			pst.setDate(2, MyStringDateUtil.fromLocalToSqlDate(startDate));
			pst.setDate(3, MyStringDateUtil.fromLocalToSqlDate(endDate));
			ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							int id = rs.getInt(1);
							String discription = rs.getString(2);
							Date date=rs.getDate(3);
							String type = rs.getString(4);
							int amount = rs.getInt(5);
							long accn = rs.getLong(6);
							
						
							al.add(new Transactions(id, discription,MyStringDateUtil.fromSqlToLocalDate(date), type,amount,accn));
							
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new BankException(e.getMessage());
			}
		
		return al;
	}
		public Customer getData(long uid) throws BankException {
		// TODO Auto-generated method stub
		con=DBUtil.getconnection();
		Customer e2=null;
	
		try {
			pst=con.prepareStatement(QueryMapper.FETCH_DATA);
			pst.setLong(1, uid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				
				e2 = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getLong(6));
									}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
		return e2;
	}
		public String addTransaction(long debitAcc, String payeeNickName, int amt, String tranPwd)throws BankException
		{
			con = DBUtil.getconnection();
			String pwd="";
			int bal = 0;
			int dataInsertedBal1 = 0;
			int dataInserted = 0;
			long payeeAcc = 0;
			LocalDate today = LocalDate.now();
			java.sql.Date sqlToday = java.sql.Date.valueOf(today);
			try
			{
				pst = con.prepareStatement(QueryMapper.GET_PWD_BY_ID);
				pst.setLong(1, debitAcc);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					pwd = rs.getString(1);
				}
				if(tranPwd.equals(pwd))
				{
					pst = con.prepareStatement(QueryMapper.GET_BALANCE);
					pst.setLong(1, debitAcc);
					rs = pst.executeQuery();
					while(rs.next())
					{
						bal= rs.getInt(1);
					}
					
					if(bal>=amt)
					{
						bal = bal - amt;
						pst = con.prepareStatement(QueryMapper.UPDATE_BALANCE);
						pst.setInt(1, bal);
						pst.setLong(2, debitAcc);
						dataInsertedBal1 = pst.executeUpdate();
						pst = con.prepareStatement(QueryMapper.GET_PAYEE_BY_NAME);
						pst.setString(1, payeeNickName);
						rs = pst.executeQuery();
						while(rs.next())
						{
							payeeAcc = rs.getLong(2);
						}
						pst = con.prepareStatement(QueryMapper.ADD_TRANSFER);
						pst.setLong(1,debitAcc);
						pst.setLong(2,payeeAcc);
						pst.setDate(3,sqlToday);
						pst.setInt(4,amt);
						dataInserted = pst.executeUpdate();
					}
					else
					{
						throw new BankException("Insufficient balance!");
					}
				}
				else
				{
					throw new Exception("Password is incorrect.");
				}
				
			}
			catch(Exception e)
			{
				throw new BankException(e.getMessage());
			}
			
			if(dataInserted>0 && dataInsertedBal1>0)
			{
				return "Transaction successful!";
			}
			else
				return "Transaction unsuccessful!";
		
		}
	
}
