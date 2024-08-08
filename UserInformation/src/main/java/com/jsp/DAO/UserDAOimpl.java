package com.jsp.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.entity.Userinformation;

public class UserDAOimpl implements UserDAO {

	@Override
	public void insertUserInformationObject() {
		//For Reading Persistance.xml file
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("UserInformation");
		
		//For Creating the Connection and Platform
		EntityManager manager = managerFactory.createEntityManager();
		
		//For Transaction
		EntityTransaction transaction = manager.getTransaction();
		
		//To begin the Transaction
		transaction.begin();
		
		Userinformation userinformation = new Userinformation();
		userinformation.setFirstname("Mohammed Omar Farooq");
		userinformation.setLastname("Qureshi");
		userinformation.setEmailid("mofq9786@gmail.com");
		userinformation.setPassword("1234");
		userinformation.setGender("Male");
		userinformation.setMobilenumber(939895415);
		
		manager.persist(userinformation);
		System.out.println("Data Inserted Successfully");
		//To commit the transaction
		transaction.commit();
		
		//To Close the Platform
		manager.close();
		
		//To Close the Connection
		managerFactory.close();
		
	}

}
