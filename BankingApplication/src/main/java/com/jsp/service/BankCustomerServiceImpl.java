package com.jsp.service;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import com.jsp.DAO.BankDAO;
import com.jsp.DAO.BankDAOImpl;
import com.jsp.entity.UserInformation;

public class BankCustomerServiceImpl implements BankCustomerService {
	
	Scanner scan = new Scanner(System.in);
	BankDAO bankDAO = new BankDAOImpl();
	UserInformation userInformation;
	@Override
	public boolean BankCustomerDetails() {
		
		UserInformation userInformation = new UserInformation();
		boolean valid = true;
		
		System.out.println("Enter First Name: ");
		String firstName = scan.next();
		
		while(valid)
		{
			if(firstName == null)
			{
				System.err.println("Enter Valid Name: ");
				firstName = scan.next();
				continue;
			}
			int count = 0;
			for(int i=0;i<firstName.length();i++)
			{
				char ch = firstName.charAt(i);
				if(Character.isAlphabetic(ch))
				{
					count++;
				}
			}
			
			if(firstName.length() == count)
			{
				valid = false;
			}
			else
			{
				System.err.println("Enter Valid Name: ");
				firstName = scan.next();
				continue;
			}
		
		}
		userInformation.setFirst_name(firstName);
		
		System.out.println("Enter Last Name: ");
		String lastName = scan.next();
		valid = true;
		while(valid)
		{
			if(lastName == null)
			{
				System.err.println("Enter Valid First Name: ");
				lastName = scan.next();
				continue;
			}
			int count = 0;
			for(int i=0;i<lastName.length();i++)
			{
				char ch = lastName.charAt(i);
				if(Character.isAlphabetic(ch))
				{
					count++;
				}
			}
			
			if(lastName.length() == count)
			{
				valid = false;
			}
			else
			{
				System.err.println("Enter Valid Name: ");
				lastName = scan.next();
				continue;
			}
		}
		userInformation.setLast_name(lastName);
		
		System.out.println("Enter Your Date Of Birth: ");
		System.out.println("Date: ");
		int date = scan.nextInt();
		while(date < 1 || date > 31)
		{
			System.err.println("Enter Valid Date: ");
			date = scan.nextInt();
		}
		
		System.out.println("Month: ");
		int month = scan.nextInt();
		while(month < 1 || month > 12)
		{
			System.err.println("Enter Valid Month: ");
			month = scan.nextInt();
		}
		
		System.out.println("Year: ");
		int year = scan.nextInt();
		while(year < 1900 || year > 2005)
		{
			System.err.println("Enter Valid Year: ");
			year = scan.nextInt();
		}
		
		LocalDate localDate = LocalDate.of(year, month, date);
		userInformation.setDate_of_birth(localDate);
		System.out.println("Enter Gender: ");
		String gender = scan.next();
		userInformation.setGender(gender);
		System.out.println("Enter Email Id: ");
		String emailId = scan.next();
		userInformation.setEmail_id(emailId);
		
		System.out.println("Enter Password: ");
		String password = scan.next();
		while(password.length() != 4)
		{
			System.err.println("Enter Valid Password: ");
			password = scan.next();
		}
		userInformation.setPassword(password);
		
		System.out.println("Enter Mobile Number");
		long mobile = scan.nextLong();
		while((""+mobile).length() != 10)
		{
			System.err.println("Enter Valid Mobile Number: ");
			mobile = scan.nextLong();
		}
		userInformation.setMobile_number(mobile);
		
		System.out.println("Enter Amount to Deposit: ");
		double amount = scan.nextDouble();
		while(amount < 0)
		{
			System.err.println("Enter Valid Amount: ");
			amount = scan.nextDouble();
		}
		userInformation.setAmount(amount);
		
		Random random = new Random();
		int number = random.nextInt(1000000);
		if(number < 100000)
		{
			number += 100000;
		}
		userInformation.setAccount_number(number);
		
		int accountNumber = bankDAO.insertBankCustomerDetails(userInformation);
		
		if(accountNumber != 0)
		{
			return true;
		}
		
		
		
		return false;
		
	}
	@Override
	public UserInformation customerLogin() {
		
		System.out.println("Enter Login Credentials\n");
		
		System.out.print("\nEnter Email Id: ");
		String emailId = scan.next();
		System.out.print("\nEnter Password: ");
		String password = scan.next();
		
		try {
			
			userInformation = bankDAO.searchUserAccountDetailsByUsingMobileAndPassword(emailId, password);
			return userInformation;	
		}
		catch(Exception e)
		{
			return null;
		}
		
		
	}
	@Override
	public void debit() {
		System.out.println("Enter Amount to Debit from Account");
		double debitAmount = scan.nextDouble();
		
		if(debitAmount>=0)
		{
			double databaseAmount = userInformation.getAmount();
			if(databaseAmount >= debitAmount)
			{
				double balance = databaseAmount - debitAmount;
				if(bankDAO.updateAmountInAccount(userInformation, balance))
				{
					userInformation.setAmount(balance);
					System.out.println("Amount successfully debited from the account.");
				}
				else
				{
					System.err.println("Transaction Failed");
				}
			}
			else
			{
				System.err.println("Insufficient Balance");
			}
		}
	}
	@Override
	public void credit() {
		
		System.out.println("Enter Amount to Credit to Account");
		double creditAmount = scan.nextDouble();
		
		if(creditAmount>=0)
		{
			double balance = userInformation.getAmount()+creditAmount;
			if(bankDAO.updateAmountInAccount(userInformation, balance))
			{
				userInformation.setAmount(balance);
				System.out.println("Amount successfully Credited to the account.");
			}
			else
			{
				System.err.println("Transaction Failed");
			}
		}
		
	}
	@Override
	public void changePassword() {
		
		System.out.println("Enter New Password");
		String newPassword = scan.next();
		
		if(newPassword.length()==4)
		{
			String oldPassword = userInformation.getPassword();
			if(!newPassword.equals(oldPassword))
			{
				if(bankDAO.changePasswordByUsingId(userInformation, newPassword))
				{
					System.out.println("Password Changed Succesfully");
				}
				else
				{
					System.err.println("Transaction Failed");
				}
			}
			else
			{
				System.err.println("Password should not be same as previous password");
			}
		}
		else 
		{
			System.err.println("Invalid Password");
		}
	}
}
