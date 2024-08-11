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
	@Override
	public boolean BankCustomerDetails() {
		
		UserInformation userInformation = new UserInformation();
		boolean valid = true;
		
		System.out.println("Enter First Name: ");
		String firstName = scan.next();
		
		outer: while(valid)
		{
			if(firstName == null)
			{
				firstName = scan.next();
				continue;
			}
			for(int i=0;i<firstName.length();i++)
			{
				char ch = firstName.charAt(i);
				if(Character.isDigit(ch))
				{
					firstName = scan.next();
					continue outer;
				}
			}
			
			valid = false;
		}
		userInformation.setFirst_name(firstName);
		
		System.out.println("Enter Last Name: ");
		String lastName = scan.next();
		valid = true;
		outer: while(valid)
		{
			if(lastName == null)
			{
				System.err.println("Enter Valid First Name: ");
				lastName = scan.next();
				continue;
			}
			for(int i=0;i<lastName.length();i++)
			{
				char ch = lastName.charAt(i);
				if(Character.isDigit(ch))
				{
					System.err.println("Enter Valid First Name: ");
					lastName = scan.next();
					continue outer;
				}
			}
			
			valid = false;
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
		while(year < 1 || year > 31)
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
		
	
			UserInformation userInformation = bankDAO.searchUserAccountDetailsByUsingMobileAndPassword(emailId, password);
			
			
			return userInformation;
//		}
//		catch(Exception e)
//		{
//			return null;
//		}
//		
		
	}
}
