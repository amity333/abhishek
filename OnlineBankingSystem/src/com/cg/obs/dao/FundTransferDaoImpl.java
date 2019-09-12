package com.cg.obs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import com.cg.obs.exception.BankException;
import com.cg.obs.util.DBUtil;

public class FundTransferDaoImpl implements FundTransferDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	public boolean transferToSelf(long debitAcc, long creditAcc, int amt)throws BankException
	{
		con = DBUtil.getconnection();
		LocalDate today = LocalDate.now();
		int dataInserted = 0;
		int dataInsertedBal1 = 0;
		int dataInsertedBal2 = 0;
		java.sql.Date sqlToday = java.sql.Date.valueOf(today);
		int currDebBal=0;
		int currCreBal=0;
		try{
		
			pst = con.prepareStatement(QueryMapper.GET_BALANCE);
			pst.setLong(1, debitAcc);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				currDebBal = rs.getInt(1);
			}
			
			pst = con.prepareStatement(QueryMapper.GET_BALANCE);
			pst.setLong(1, creditAcc);
			ResultSet rs1 = pst.executeQuery();
			while(rs1.next())
			{
				currCreBal = rs1.getInt(1);
			}
			
			if(currDebBal>=amt)
			{
				currDebBal = currDebBal - amt;
				currCreBal = currCreBal + amt;
				pst = con.prepareStatement(QueryMapper.UPDATE_BALANCE);
				pst.setInt(1, currDebBal);
				pst.setLong(2, debitAcc);
				dataInsertedBal1 = pst.executeUpdate();
				
				pst.setInt(1, currCreBal);
				pst.setLong(2, creditAcc);
				dataInsertedBal2 = pst.executeUpdate();
				
				pst = con.prepareStatement(QueryMapper.ADD_TRANSFER);
				pst.setLong(1,debitAcc);
				pst.setLong(2,creditAcc);
				pst.setDate(3,sqlToday);
				pst.setInt(4,amt);
				dataInserted = pst.executeUpdate();
			}
			else
			{
				throw new Exception("Insufficient Balance!");
			}	
		}
		catch(Exception e)
		{
			throw new BankException(e.getMessage());
		}
		
		if(dataInserted==1 || dataInsertedBal1==1 || dataInsertedBal2==1)
			return true;
		else
			return false;
	}


}
