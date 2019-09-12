package com.cg.obs.service;

import java.util.ArrayList;

import com.cg.obs.dto.AccountMaster;
import com.cg.obs.exception.BankException;

public interface AccountMasterService {

	public boolean addAccount(String custName,String custEmail,String custAddr,String custPAN,String custPwd,String custQues,String custTPwd,String accType,long custMob, double balance) throws BankException;
	public ArrayList<AccountMaster> getBalance(long  uid) throws BankException;
	public boolean validatePassword(String custPwd) throws BankException;
	public boolean validateMail(String custEmail) throws BankException;
	public boolean validateMobileNumber(long custMob) throws BankException;
	public boolean validateName(String custName) throws BankException;
	public boolean confirmPassword(String custPwd, String confirmPwd) throws BankException;
}
