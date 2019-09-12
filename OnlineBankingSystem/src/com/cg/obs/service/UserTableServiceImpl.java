package com.cg.obs.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.obs.dao.UserTableDaoImpl;
import com.cg.obs.exception.BankException;

public class UserTableServiceImpl implements UserTableService{

	UserTableDaoImpl dao;
	public UserTableServiceImpl() {
		dao = new UserTableDaoImpl();
	}

	@Override
	public boolean validateLogin(int uId, String pwd) throws BankException {
		return dao.validateLogin(uId, pwd);
	}

	@Override
	public boolean resetPassword(int uId, String ques) throws BankException {
		return dao.resetPassword(uId, ques);
	}

	@Override
	public ArrayList<Long> getAccounts(int uId) throws BankException {
		return dao.getAccounts(uId);
	}

	@Override
	public boolean changePwd(int user_id, String newPwd) throws BankException {
		return dao.changePwd(user_id, newPwd);
	}

	@Override
	public void addUser(String custPwd, String custQues, String custTPwd, long accId) throws BankException {
		dao.addUser(custPwd, custQues, custTPwd, accId);
	}
	
	@Override
	public boolean validateUserId(int uId) throws BankException {
		String userId = new Integer(uId).toString();
		String uIdPattern = "[0-9]{8}";
		if(Pattern.matches(uIdPattern, userId))
		{
			return true;
		}
		else
		  {
			throw new BankException("UserId must contain only digits of length 8");
		  }
	}
}
