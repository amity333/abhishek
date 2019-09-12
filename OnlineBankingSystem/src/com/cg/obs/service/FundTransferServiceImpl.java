package com.cg.obs.service;

import com.cg.obs.dao.FundTransferDaoImpl;
import com.cg.obs.exception.BankException;

public class FundTransferServiceImpl implements FundTransferService {

	FundTransferDaoImpl dao;
	
	public FundTransferServiceImpl() {
		dao = new FundTransferDaoImpl();		
	}

	@Override
	public boolean transferToSelf(long debitAcc, long creditAcc, int amt) throws BankException {
		
		return dao.transferToSelf(debitAcc, creditAcc, amt);
	}

}
