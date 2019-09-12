package com.cg.obs.service;

import java.util.ArrayList;

import com.cg.obs.dto.PayeeTable;
import com.cg.obs.exception.BankException;

public interface PayeeService {

	public boolean addPayee(PayeeTable payee)throws BankException;
	public ArrayList<PayeeTable> getPayee(long accNo)throws BankException;
}
