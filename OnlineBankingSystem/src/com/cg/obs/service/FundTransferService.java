package com.cg.obs.service;

import com.cg.obs.exception.BankException;

public interface FundTransferService {

	public boolean transferToSelf(long debitAcc, long creditAcc, int amt)throws BankException;
}
