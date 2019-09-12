package com.cg.obs.service;

import com.cg.obs.dao.CustomerDaoImpl;
import com.cg.obs.exception.BankException;

public class CustomerServiceImpl implements CustomerService {

	CustomerDaoImpl dao;
	
	public CustomerServiceImpl() {
		dao = new CustomerDaoImpl();
	}

	@Override
	public void addCustomer(String custName, String custEmail, String custAddr, String custPAN, long custMob,
			long accId) throws BankException {
		
		dao.addCustomer(custName, custEmail, custAddr, custPAN, custMob, accId);

	}

}
