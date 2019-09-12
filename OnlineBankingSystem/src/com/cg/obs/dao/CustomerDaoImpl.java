package com.cg.obs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.obs.exception.BankException;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	@Override
	public void addCustomer(String custName, String custEmail, String custAddr, String custPAN, long custMob, long accId) throws BankException
	{
		try {
			pst=con.prepareStatement(QueryMapper.CREATE_ACCOUNT_CUSTOMER);
			pst.setLong(1, accId);
			pst.setString(2, custName);
			pst.setString(3, custEmail);
			pst.setString(4, custAddr);
			pst.setString(5, custPAN);
			pst.setLong(6, custMob);
			int upd=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
		
	}
}
