package com.cg.obs.service;

import com.cg.obs.exception.BankException;

public interface CustomerService {

	public void addCustomer(String custName, String custEmail, String custAddr, String custPAN, long custMob, long accId) throws BankException;

}
