package com.cg.obs.dao;

import java.util.HashMap;

import com.cg.obs.exception.BankException;

public interface ServiceTrackerDao
{
	public int requestCheque(long accNo) throws BankException; 
	public String searchByServNo(int reqNo) throws BankException; 
	public HashMap<Integer,String> searchByAccNo(long accNo) throws BankException;
}
