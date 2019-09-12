package com.cg.obs.service;

import java.util.HashMap;

import com.cg.obs.dao.ServiceTrackerDaoImpl;
import com.cg.obs.exception.BankException;

public class ServiceTrackerServiceImpl implements ServiceTrackerService {

	ServiceTrackerDaoImpl dao;
	public ServiceTrackerServiceImpl() {
		 dao = new ServiceTrackerDaoImpl();
	}

	@Override
	public int requestCheque(long accNo) throws BankException {
		return dao.requestCheque(accNo);
	}

	@Override
	public String searchByServNo(int reqNo) throws BankException {
		return dao.searchByServNo(reqNo);
	}

	@Override
	public HashMap<Integer, String> searchByAccNo(long accNo) throws BankException {
		return dao.searchByAccNo(accNo);
	}

}
