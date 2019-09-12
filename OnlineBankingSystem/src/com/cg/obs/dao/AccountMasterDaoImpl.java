package com.cg.obs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.obs.dto.AccountMaster;
import com.cg.obs.exception.BankException;
import com.cg.obs.util.DBUtil;
import com.cg.obs.util.MyStringDateUtil;

public class AccountMasterDaoImpl implements AccountMasterDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	CustomerDao cusDao;
	UserTableDao userDao;
	public AccountMasterDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		con=DBUtil.getconnection();
		cusDao=new CustomerDaoImpl();
		userDao=new UserTableDaoImpl();
	}
	@Override
	public boolean addAccount(String custName, String custEmail,
			String custAddr, String custPAN, String custPwd, String custQues,
			String custTPwd, String accType, long custMob, double balance) throws BankException {
		// TODO Auto-generated method stub
		try {
			pst=con.prepareStatement(QueryMapper.CREATE_ACCOUNT);
			pst.setString(1, accType);
			pst.setDouble(2, balance);
			long accId=0;
			int upd=pst.executeUpdate();
			if(upd>0)
			{
				st=con.createStatement();
				ResultSet rs=st.executeQuery(QueryMapper.GET_CURR_ACCID);
				while(rs.next())
				{
					accId=rs.getLong(1);
				}
			}
			else
			{
				return false;
			}
			cusDao.addCustomer(custName, custEmail, custAddr, custPAN, custMob, accId);
			userDao.addUser(custPwd, custQues, custTPwd, accId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
		return true;
	}
	public ArrayList<AccountMaster> getBalance(long  uid) throws BankException {
		// TODO Auto-generated method stub
		
		ArrayList<AccountMaster> al = new ArrayList<>();	
			try {
				pst=con.prepareStatement(QueryMapper.GET_BALANCE);
			pst.setLong(1, uid);
				ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							int id = rs.getInt(1);
							String type = rs.getString(2);
							int balance = rs.getInt(3);
							Date date=rs.getDate(4);
							al.add(new AccountMaster(id, type, balance,MyStringDateUtil.fromSqlToLocalDate(date)));
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new BankException(e.getMessage());
			}
		
		return al;
	}
}
