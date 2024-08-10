package com.jsp.DAO;

import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.entity.UserInformation;

public class BankDAOImpl implements BankDAO {
	
	private final static String update = "update UserInformation userInfo set userInfo.amount =:amount where userInfo.email_id=:email and userInfo.password=:password";

	@Override
	public boolean insertBankCustomerDetails() {
		Scanner scan = new Scanner(System.in);
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("BankingApplication");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		UserInformation userInformation = new UserInformation();
		
		System.out.println("Enter First Name: ");
		String firstName = scan.next();
		userInformation.setFirst_name(firstName);
		
		System.out.println("Enter Last Name: ");
		String lastName = scan.next();
		userInformation.setLast_name(lastName);
		
		System.out.println("Enter Your Date Of Birth: ");
		String dateOfBirth = scan.next();
		userInformation.setDate_of_birth(dateOfBirth);
		
		System.out.println("Enter Gender: ");
		String gender = scan.next();
		userInformation.setGender(gender);
		
		System.out.println("Enter Email Id: ");
		String emailId = scan.next();
		userInformation.setEmail_id(emailId);
		
		System.out.println("Enter Password: ");
		String password = scan.next();
		userInformation.setPassword(password);
		
		System.out.println("Enter Mobile Number");
		long mobile = scan.nextLong();
		userInformation.setMobile_number(mobile);
		
		System.out.println("Enter Amount to Deposit: ");
		double amount = scan.nextDouble();
		userInformation.setAmount(amount);
		
		Random random = new Random();
		int number = random.nextInt(1000000);
		if(number < 100000)
		{
			number += 100000;
		}
		
		userInformation.setAccount_number(number);
		
		try {
			manager.persist(userInformation);
			transaction.commit();
			
			manager.close();
			managerFactory.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean creditAmountInAccount(UserInformation userInformation, double creditAmount) {
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("BankingApplication");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
			Query query = manager.createQuery(update);
			String email =userInformation.getEmail_id();
			String password = userInformation.getPassword();
			
			query.setParameter("email", email);
			query.setParameter("password", password);
			query.setParameter("amount", creditAmount);
			
			int result = query.executeUpdate();
			transaction.commit();
			manager.close();
			managerFactory.close();
			
			if(result != 0)
			{
				userInformation.setAmount(creditAmount);
				return true;
			}
			else
			{
				return false;
			}
			
		
	}

	@Override
	public boolean debitAmountFromAccount(UserInformation userInformation, double debitAmount) {

		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("BankingApplication");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
			Query query = manager.createQuery(update);
			String email =userInformation.getEmail_id();
			String password = userInformation.getPassword();
			
			query.setParameter("email", email);
			query.setParameter("password", password);
			query.setParameter("amount", debitAmount);
			
			int result = query.executeUpdate();
			transaction.commit();
			manager.close();
			managerFactory.close();
			
			if(result != 0)
			{
				userInformation.setAmount(debitAmount);
				return true;
			}
			else
			{
				return false;
			}
		
	}

	@Override
	public boolean changePasswordByUsingId(UserInformation userInformation, String password) {
		
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("BankingApplication");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		String update_password = "update UserInformation userInfo set userInfo.password =:newpassword where userInfo.email_id=:email and userInfo.password=:password";
	
		
		Query query = manager.createQuery(update_password);
		String email =userInformation.getEmail_id();
		String oldPassword = userInformation.getPassword();
		
		query.setParameter("email", email);
		query.setParameter("password", oldPassword);
		query.setParameter("newpassword", password);
		
		int result = query.executeUpdate();
		transaction.commit();
		manager.close();
		managerFactory.close();
		
		if(result != 0)
		{
			userInformation.setPassword(password);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public UserInformation searchUserAccountDetailsByUsingMobileAndPassword(String email, String password) {

		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("BankingApplication");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		String select = "select userInfo from UserInformation userInfo where userInfo.email_id=:email and userInfo.password=:password";
		
		Query query = manager.createQuery(select);
		
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		UserInformation userInformation = (UserInformation) query.getSingleResult();
		
		manager.close();
		managerFactory.close();
		
		return userInformation;
	}

}
