package com.cg.obs.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.obs.dto.Customer;
import com.cg.obs.dto.Transactions;
import com.cg.obs.exception.BankException;

public interface TransactionsDao
{
	public ArrayList<Transactions> viewTransaction(LocalDate date) throws BankException; 
	public ArrayList<Transactions> viewTransaction(int period, String duration) throws BankException; 
	public ArrayList<Transactions> viewMini(long accNo) throws BankException; 
	public ArrayList<Transactions> viewDetailed(int accNo,LocalDate startDate,LocalDate endDate) throws BankException; 
	public Customer getData(long uid) throws BankException; 
	public String addTransaction(long debitAcc, String payeeNickName, int amt, String tranPwd)throws BankException; 
}
