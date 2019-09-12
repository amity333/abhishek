package com.cg.obs.dao;

import com.cg.obs.exception.BankException;

public interface FundTransferDao
{
	public boolean transferToSelf(long debitAcc, long creditAcc, int amt)throws BankException;
}
