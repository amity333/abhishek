package com.cg.obs.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.obs.dto.Customer;
import com.cg.obs.dto.Transactions;
import com.cg.obs.dto.UserTable;
import com.cg.obs.exception.BankException;
import com.cg.obs.service.AccountMasterServiceImpl;
import com.cg.obs.service.ServiceTrackerServiceImpl;
import com.cg.obs.service.TransactionServiceImpl;
import com.cg.obs.service.UserTableServiceImpl;

public class OnlineBankingSystemUI {

	//Service 
	static UserTableServiceImpl userService;
	static TransactionServiceImpl transactionService;
	static AccountMasterServiceImpl accountService;
	static ServiceTrackerServiceImpl serviceTrackerService;  
	//Dto
	static Customer customer;
	static UserTable usertable;
	//input
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void userHomePage(int userId) throws NumberFormatException, IOException
	{
		System.out.println("*****************************************HomePage***************************************************\n\n\n");
		System.out.println("\t\t Welcome "+ customer.getCustomer_name() +"  to our Online Banking System");
		try {
			int userChoice;
			System.out.println("Your Account Balance is "+ accountService.getBalance(userId));
			System.out.println("1. View Mini/Detailed statement \n2.Change in address/mobile number \n3.Request for Cheque Book \n4.Track Service request \n5.Fund Transfer \n6.Change Password");
			userChoice = Integer.parseInt(br.readLine());
			switch(userChoice)
			{
			case 1:viewMini(customer.getAccount_id());
					break;
			case 2://dao is yet to be implemented
					break;
			case 3:requestCheque(customer.getAccount_id());
					break;
			case 4:searchByAccNo(customer.getAccount_id());
					break;
			case 5:
					break;
			case 6:	System.out.println("Enter new password");
					String newPwd=br.readLine();
					changePwd(userId,newPwd);
					
			}
		}
		catch (BankException e) 
		{
			System.out.println(e);
			//e.printStackTrace();
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}
	}
	

	public static void main(String[] args) 

	{
		try
		{
		int userId;
		int adminId;
		String userPassword;
		String adminPassword;
		boolean userLogin;
		boolean adminLogin;
		System.out.println("**********************************************Welcome to Online Banking System**********************************************\n\n\n");
		System.out.println("Login as : 1.User 2.Admin");
		String logger = br.readLine();
		System.out.println("hi");
		if(logger.equals("1"))
		{
			userService = new UserTableServiceImpl();
			System.out.println("Enter your userId:	");
			userId = Integer.parseInt(br.readLine());
			try {
				if(userService.validateUserId(userId) == true)
					{
					System.out.println("Enter your password:	");
					userPassword = br.readLine();
					userLogin = userService.validateLogin(userId, userPassword);
						if(userLogin == true ) // need to add & user.lockStatus == false
							{
							customer = transactionService.getData(userId);
							userHomePage(userId);
							}
					}
			}
			catch (BankException e) 
			{
				//e.printStackTrace();
				System.out.println(e);
			}
		}
		else if(logger.equals("2"))  //admin part
		{
			System.out.println("Enter Id:	");
			adminId = Integer.parseInt(br.readLine());
			try {
				if(userService.validateUserId(adminId) == true)
					{
					System.out.println("Enter your password:	");
					adminPassword = br.readLine();
					adminLogin = userService.validateLogin(adminId, adminPassword);
						if(adminLogin == true ) 
							{
							adminHomePage(adminId);
							}
					}
			}
			catch (BankException e) 
			{
				//e.printStackTrace();
				System.out.println(e);
			}
			
		}
		else
		{
			System.out.println("Enter a valid input");
		}
		}
	catch(IOException e)
		{
		e.printStackTrace();
		}
	}
	
	public static void adminHomePage(int adminId)
	{
		
		System.out.println("*****************************************HomePage***************************************************\n\n\n");
		System.out.println("\t\t Welcome admin to our Online Banking System");
		try {
			int adminChoice;
			System.out.println("1.Create New Account page\n2.View transactions of all accounts\n");
			adminChoice=Integer.parseInt(br.readLine());
			switch(adminChoice)
			{
			case 1:createNewAccount();
					break;
			case 2:viewAllTransactions();
					break;
			default:System.out.println("Invalid input");
			}
	}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
			
	
	private static void viewAllTransactions() {
		int period;
		System.out.println("1.Daily transactions 2.Monthly transaction 3.Yearly transactions");
		try
		{
		int userchoice=Integer.parseInt(br.readLine());
		ArrayList<Transactions> list;
		switch(userchoice)
		{
		case 1:System.out.println("Enter date");
				String date=br.readLine();
				DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");

				LocalDate formatedDate=LocalDate.parse(date,format);
				list=transactionService.viewTransaction(formatedDate);
				for(Transactions trans:list)
				{
					System.out.println(trans);
				}
				break;
		case 2:System.out.println("Enter period 1,3,5,7,8,10,12");
				period=Integer.parseInt(br.readLine());
				list=transactionService.viewTransaction(period,"monthly");
				for(Transactions trans:list)
				{
					System.out.println(trans);
				}
				break;
		case 3:
			System.out.println("Enter year");
			period=Integer.parseInt(br.readLine());
			list=transactionService.viewTransaction(period,"yearly");
			for(Transactions trans:list)
			{
				System.out.println(trans);
			}
			break;
		}
		}
		catch (BankException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}


	private static void createNewAccount(){
		
		try 
		{
			System.out.println("Enter Account Holder Name");
			String  custName= br.readLine();
			
			System.out.println("Enter Account Holder Password");
			String  custPwd= br.readLine();
			
			System.out.println("Confirm Password");
			String  confPwd= br.readLine();
			
			//validation
			
			System.out.println("Enter Account Holder Email");
			String  custEmail= br.readLine();
			
			System.out.println("Enter Account Holder Address");
			String  custAddr= br.readLine();
			
			System.out.println("Enter Account Holder Pan");
			String  custPAN=(br.readLine());
			
			System.out.println("Enter Security Question");
			String custQues=(br.readLine());
			
			System.out.println("Enter Account Holder Transaction pin");
			String custTPwd= (br.readLine());
			
			System.out.println("Enter Account Type");
			String accType= (br.readLine());
			
			System.out.println("Enter Account holder's mobile no.");
			long custMob= Long.parseLong(br.readLine());
			
			System.out.println("Enter Account Holder's balance");
			double balance= Double.parseDouble(br.readLine());
			accountService.addAccount(custName, custEmail, custAddr, custPAN, custPwd, custQues, custTPwd, accType, custMob, balance);
		} 
		catch (BankException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

	public static void viewMini(long accNo)
	{
		try 
		{
			ArrayList<Transactions> list=transactionService.viewMini(accNo);
			try 
			{
				for(Transactions t1:list)
					System.out.println(t1);
			}
			catch (Exception e) 
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		} 
		
		catch (BankException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public static void requestCheque(long accNo)
	{
		try 
		{
			if(serviceTrackerService.requestCheque(accNo)>0)
			{
				System.out.println("Cheque Book request is raised Successfully");
			}
			else
			{
				//if cheque request is already raised
				System.out.println();
			}
		} 
		catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void searchByAccNo(long accNo) 
	{
		try 
		{
			HashMap<Integer,String> hmap=serviceTrackerService.searchByAccNo(accNo);
			Set<Entry<Integer,String>> hashSet=hmap.entrySet();
	        for(Entry entry:hashSet ) {
	            System.out.println("id="+entry.getKey()+", Status="+entry.getValue());
	        }
		} 
		catch (BankException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void changePwd(int userId,String newPwd)
	{
		try 
		{
			boolean isChanged=userService.changePwd(userId, newPwd);
			if(isChanged)
				System.out.println("Password is changed successfully");
			else
				System.out.println("Operation cannot be completed");
		} 
		catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
