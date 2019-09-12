package com.cg.obs.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.obs.dao.TransactionsDaoImpl;
import com.cg.obs.dto.Customer;
import com.cg.obs.dto.Transactions;
import com.cg.obs.exception.BankException;

public class TransactionServiceImpl implements TransactionService {

	TransactionsDaoImpl dao;
	public TransactionServiceImpl() {
		dao = new TransactionsDaoImpl();
	}

	@Override
	public ArrayList<Transactions> viewTransaction(LocalDate date) throws BankException {
		return dao.viewTransaction(date);
	}

	@Override
	public ArrayList<Transactions> viewTransaction(int period, String duration) throws BankException {
		return dao.viewTransaction(period, duration);
	}

	@Override
	public ArrayList<Transactions> viewMini(long accNo) throws BankException {
		return dao.viewMini(accNo);
	}

	@Override
	public ArrayList<Transactions> viewDetailed(int accNo, LocalDate startDate, LocalDate endDate)
			throws BankException {
		return dao.viewDetailed(accNo, startDate, endDate);
	}

	@Override
	public Customer getData(long uid) throws BankException {
		return dao.getData(uid);
	}

	@Override
	public String addTransaction(long debitAcc, String payeeNickName, int amt, String tranPwd) throws BankException {
		return dao.addTransaction(debitAcc, payeeNickName, amt, tranPwd);
	}

}
