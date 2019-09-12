package com.cg.obs.service;

import java.util.ArrayList;

import com.cg.obs.exception.BankException;

public interface UserTableService {

	public boolean validateLogin(int uId, String pwd) throws BankException; 
	public boolean resetPassword(int uId, String ques) throws BankException; 
	public ArrayList<Long> getAccounts(int uId)throws BankException; 
	public boolean changePwd(int user_id, String newPwd)throws BankException; 
	public void addUser(String custPwd, String custQues, String custTPwd, long accId) throws BankException; 
	public boolean validateUserId(int userId) throws BankException;
}
