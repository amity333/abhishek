package com.cg.obs.dao;

import com.cg.obs.exception.BankException;

public interface CustomerDao
{
	public void addCustomer(String custName, String custEmail, String custAddr, String custPAN, long custMob, long accId) throws BankException;
}
