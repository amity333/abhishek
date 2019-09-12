package com.cg.obs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.obs.dto.PayeeTable;
import com.cg.obs.exception.BankException;
import com.cg.obs.util.DBUtil;

public class PayeeDaoImpl implements PayeeDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	public boolean addPayee(PayeeTable payee)throws BankException
	{
		con = DBUtil.getconnection();
		int dataInserted = 0;
		try{
			pst = con.prepareStatement(QueryMapper.ADD_PAYEE);
			pst.setLong(1,payee.getAccount_id());
			pst.setLong(2,payee.getPayee_account_id());
			pst.setString(3, payee.getNick_name());
			dataInserted = pst.executeUpdate();
		}
		catch(Exception e)
		{
			throw new BankException(e.getMessage());
		}
		
		if(dataInserted>0)
			return true;
		else
			return false;
	}

	public ArrayList<PayeeTable> getPayee(long accNo)throws BankException
	{
		con = DBUtil.getconnection();
		ArrayList<PayeeTable> payeeList = new ArrayList<PayeeTable>();
		PayeeTable payee;
		try{
			pst = con.prepareStatement(QueryMapper.GET_PAYEE);
			pst.setLong(1, accNo);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				payee=new PayeeTable(rs.getLong(1), rs.getLong(2), rs.getString(3));
				payeeList.add(payee); 
			}
		}
		catch(Exception e)
		{
			throw new BankException(e.getMessage());
		}
		
		return payeeList;
	} 

}
