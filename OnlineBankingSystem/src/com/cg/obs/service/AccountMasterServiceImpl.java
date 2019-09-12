package com.cg.obs.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.obs.dao.AccountMasterDaoImpl;
import com.cg.obs.dto.AccountMaster;
import com.cg.obs.exception.BankException;

public class AccountMasterServiceImpl implements AccountMasterService {

	AccountMasterDaoImpl dao;
	public AccountMasterServiceImpl() {
		dao = new AccountMasterDaoImpl();	
	}

	@Override
	public boolean addAccount(String custName, String custEmail, String custAddr, String custPAN, String custPwd,
			String custQues, String custTPwd, String accType, long custMob, double balance) throws BankException {
		
		return dao.addAccount(custName, custEmail, custAddr, custPAN, custPwd, custQues, custTPwd, accType, custMob, balance);
	}

	@Override
	public ArrayList<AccountMaster> getBalance(long uid) throws BankException {
		
		return dao.getBalance(uid);
	}

	@Override
	public boolean validatePassword(String custPwd) throws BankException {
		String pwdPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[@#$%]).{6,20})";
		if(Pattern.matches(pwdPattern, custPwd))
		{
			return true;
		}
		else
		  {
			throw new BankException("Passowrd must contain one digit, one lowercase letter and a special character with min length 6 and max length 20");
		  }
	}
	
	/* (    # Start of group
 	(?=.*\d)		#   must contains one digit from 0-9
	(?=.*[a-z])		#   must contains one lowercase characters
	(?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
	 .		#     match anything with previous condition checking
	{6,20}	#        length at least 6 characters and maximum of 20	
	)
*/

	@Override
	public boolean validateMail(String custEmail) throws BankException{
		String mailPattern = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
		if(Pattern.matches(mailPattern, custEmail))
		{
			return true;
		}
		else
		  {
			throw new BankException("Enter a valid mail id");
		  }
	}


	
	
	@Override
	public boolean validateMobileNumber(long custMob) throws BankException{
		String custMobile = new Long(custMob).toString();
		String mobilePattern = "[0-9]{10}";
		if(Pattern.matches(mobilePattern, custMobile))
		{
			return true;
		}
		else
		  {
			throw new BankException("Mobile number must be 10 digit");
		  }
	}

	@Override
	public boolean validateName(String custName) throws BankException{
		String namePattern = "[A-Z]([a-z])*{5,20}";
		if(Pattern.matches(namePattern, custName))
		{
			return true;
		}
		else
		  {
			throw new BankException("Name must begin with capital letter with minimum 5 and maximum 20 characters");
		  }
	}

	@Override
	public boolean confirmPassword(String custPwd, String confirmPwd) throws BankException{
		if(custPwd.equals(confirmPwd))
			return true;
		else
		  {
			throw new BankException("Password must be same");
		  }
	}

}
