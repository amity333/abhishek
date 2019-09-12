package com.cg.obs.service;

import java.util.ArrayList;

import com.cg.obs.dao.PayeeDaoImpl;
import com.cg.obs.dto.PayeeTable;
import com.cg.obs.exception.BankException;

public class PayeeServiceImpl implements PayeeService {

	PayeeDaoImpl dao;
	public PayeeServiceImpl() {
		dao = new PayeeDaoImpl();
	}

	@Override
	public boolean addPayee(PayeeTable payee) throws BankException {

		return dao.addPayee(payee);
	}

	@Override
	public ArrayList<PayeeTable> getPayee(long accNo) throws BankException {
		
		return dao.getPayee(accNo);
	}

}
