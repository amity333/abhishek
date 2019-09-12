package com.cg.obs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.cg.obs.exception.BankException;
import com.cg.obs.util.DBUtil;

public class ServiceTrackerDaoImpl implements ServiceTrackerDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	public int requestCheque(long accNo) throws BankException {
		int dataInserted=0;
		con=DBUtil.getconnection();
		String desc="Checkbook Request";
		String status="Open";
			try {
		
			pst = con.prepareStatement(QueryMapper.ADD_CHEQUE_REQUEST);
			pst.setString(1, desc);
			pst.setLong(2, accNo);
			pst.setString(3, status);
			
		
			dataInserted = pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new BankException(e.getMessage());
		}
		return dataInserted;
	}
	
		public String searchByServNo(int reqNo) throws BankException {
		
		con=DBUtil.getconnection();
		String status=null;
			try {
		
			pst = con.prepareStatement(QueryMapper.GET_SERVICE_STATUS);
			pst.setInt(1, reqNo);
			
			
		
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			status = rs.getString(1);
			
		} catch (SQLException e) {
			throw new BankException(e.getMessage());
		}
		return status;
	}
	public HashMap<Integer,String> searchByAccNo(long accNo) throws BankException {
		// TODO Auto-generated method stub
		
		
		con=DBUtil.getconnection();
		HashMap<Integer, String> map = new HashMap<>();
		
			try {
				pst=con.prepareStatement(QueryMapper.GET_SERVICE_STATUS_BY_ACC);
			pst.setLong(1, accNo);
			
			ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							map.put(rs.getInt(1),rs.getString(2));
							
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new BankException(e.getMessage());
			}
		
		return map;
	}

}
