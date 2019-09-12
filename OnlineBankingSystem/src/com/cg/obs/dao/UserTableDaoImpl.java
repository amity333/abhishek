package com.cg.obs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.obs.exception.BankException;
import com.cg.obs.util.DBUtil;

public class UserTableDaoImpl implements UserTableDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	static int counter=0;
	@Override
	public boolean validateLogin(int uId, String pwd) throws BankException{
		// TODO Auto-generated method stub
		con=DBUtil.getconnection();
		try {
			pst=con.prepareStatement(QueryMapper.LOGIN_VALIDATION);
			pst.setInt(1, uId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String pass=rs.getString(3);
				String getlock=rs.getString(6);
				char lock=getlock.charAt(0);
				if(lock=='L')
					return false;
				else
				{
					if(pass.equals(pwd))
					{
						counter=0;
						return true;
					}
					else
					{
						if(counter==3)
							{
								lock='L';
								PreparedStatement pst1=con.prepareStatement(QueryMapper.SET_LOCK_STATUS);
								pst1.setString(1,"L");
								pst1.setInt(2, uId);
								int update=pst1.executeUpdate();
							}
						else
							counter++;
						return false;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
		
		return false;
	}
	
	@Override
	public boolean resetPassword(int uId, String ques) throws BankException {
		// TODO Auto-generated method stub
		try {
			pst=con.prepareStatement(QueryMapper.RESET_PWD);
			pst.setInt(1, uId);
			String ans="";
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ans=rs.getString(1);
			}
			if(ans.equalsIgnoreCase(ques))
			{
				PreparedStatement pst1=con.prepareStatement(QueryMapper.CHANGE_PWD);
				pst1.setString(1, "sbq500#");
				pst.setInt(2, uId);
				int upd = pst1.executeUpdate();
				if(upd>0)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
		return false;
	}
	
	public void addUser(String custPwd, String custQues, String custTPwd, long accId) throws BankException
	{
		try {
			pst=con.prepareStatement(QueryMapper.CREATE_ACCOUNT_CUSTOMER);
			pst.setLong(1, accId);
			pst.setString(2, custPwd);
			pst.setString(3, custQues);
			pst.setString(4, custTPwd);
			pst.setString(5, "U");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException(e.getMessage());
		}
	}
	
	
	
	//Get Accounts

	public ArrayList<Long> getAccounts(int uId)throws BankException
	{
		con = DBUtil.getconnection();
		ArrayList<Long> list = new ArrayList<Long>();
		try{
			pst = con.prepareStatement(QueryMapper.GET_ACCOUNTS);
			pst.setInt(1, uId);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				list.add(rs.getLong(1));
			}
		}
		catch(Exception e)
		{
			throw new BankException(e.getMessage());
		}
		
		return list;
	}

	public boolean changePwd(int user_id, String newPwd)throws BankException
	{
		int dataInserted = 0;
		try{
		pst = con.prepareStatement(QueryMapper.CHANGE_PWD);
		pst.setString(1, newPwd);
		pst.setInt(2, user_id);
		dataInserted = pst.executeUpdate();
		}
		catch(Exception e){
			throw new BankException(e.getMessage());
		}
		
		if(dataInserted>0)
			return true;
		else
			return false;
	} 
}
