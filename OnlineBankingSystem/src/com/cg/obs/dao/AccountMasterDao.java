package com.cg.obs.dao;

import java.util.ArrayList;

import com.cg.obs.dto.AccountMaster;
import com.cg.obs.exception.BankException;

public interface AccountMasterDao
{

	public boolean addAccount(String custName,String custEmail,String custAddr,String custPAN,String custPwd,String custQues,String custTPwd,String accType,long custMob, double balance) throws BankException;
	public ArrayList<AccountMaster> getBalance(long  uid) throws BankException;
}
