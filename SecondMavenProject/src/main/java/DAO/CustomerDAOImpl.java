package DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	@Override
	public void insertCustomerDetails() {
		Scanner scan = new Scanner(System.in);
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Customer customer = new Customer();
		System.out.println("Enter First Name: ");
		customer.setFirstname(scan.next());
		System.out.println("Enter Last Name: ");
		customer.setLastname(scan.next());
		System.out.println("Enter Email-Id: ");
		customer.setEmailid(scan.next());
		System.out.println("Enter Password: ");
		customer.setPassword(scan.next());
		System.out.println("Enter Mobile Number: ");
		customer.setMobilenumber(scan.nextLong());
		System.out.println("Enter Gender: ");
		customer.setGender(scan.next());
		System.out.println("Enter Address: ");
		customer.setAddress(scan.next());
		
		manager.persist(customer);
		
		transaction.commit();
		
		manager.close();
		managerFactory.close();
	}

	@Override
	public void selectCustomerDataUsingById( int id) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Customer customer = manager.find(Customer.class, 1);
		
		if(customer!= null)
		{
			System.out.println("First Name: "+customer.getFirstname());
			System.out.println("Last Name: "+customer.getLastname());
		}
		else
		{
			System.out.println("Data not found...");
		}
		
		manager.close();
		managerFactory.close();
		
	}

	@Override
	public void updateCustomerPasswordByUsingId(int id, String password) {
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Customer customer = manager.find(Customer.class, id);
		
		if(customer!=null)
		{
			customer.setPassword(password);
			System.out.println("Password Updated");
		}
		else
		{
			System.out.println("No Details Found");
		}
		transaction.commit();
		
		manager.close();
		managerFactory.close();
		
	}

	@Override
	public void deleteCustomerDetailsByUsingId(int id) {
		
		EntityManagerFactory managerfactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerfactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Customer customer = manager.find(Customer.class, id);
		if(customer!= null)
		{
			manager.remove(customer);
			System.out.println("Data Deleted Successfully...");
		}
		else
		{
			System.out.println("No Details Found..");
		}
		
		transaction.commit();
		
		manager.close();
		managerfactory.close();
	}

	@Override
	public void updateCustomerPasswordByUsingEmailId(String password, String emailid) {
		
		String JPQLQuery = "update Customer customer set customer.password = ?1 where customer.emailid=?2";
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Query query = manager.createQuery(JPQLQuery);
		System.out.println(query);
		
		query.setParameter(1, password);
		query.setParameter(2, emailid);
		
		int result = query.executeUpdate();
		if(result!=0)
		{
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Data not updated");
		}
		transaction.commit();
		
	}

	@Override
	public void deleteCustomerDetailsByUsingMobileNumber(long mobileNumber) {
		String JPQLQuery = 
				"delete from Customer customer where customer.mobilenumber =:mobile";
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Query query = manager.createQuery(JPQLQuery);
		
		//query.setParameter(1, mobileNumber);
		query.setParameter("mobile", mobileNumber);
		
		int result = query.executeUpdate();
		
		if(result!=0)
		{
			System.out.println("Data Deleted Successfull");
		} 
		else
		{
			System.out.println("Unable to delete data");
		}
		transaction.commit();
	
		
	}

	@Override
	public void selectCustomerDetailsByUsingCustomerId(int id) {
		String select = 
				"Select customer from Customer customer where customer.customerid =:id";
		
		EntityManagerFactory managerfactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerfactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Query query = manager.createQuery(select);
		query.setParameter("id", id);
		try {
			Customer customer = (Customer) query.getSingleResult();
			System.out.println("Customer First Name: "+customer.getFirstname());
			System.out.println("Customer Last Name: "+customer.getLastname());
		}
		catch(Exception e)
		{
			System.out.println("No Data found");
		}
	}

	@Override
	public void selectAllCustomerDetails() {
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		String select = "select customer from Customer customer";
		Query query = manager.createQuery(select);
		
		try {
			List<Customer> customer = (List<Customer>)query.getResultList();
			
			for(Customer cust : customer)
			{
				System.out.println(cust);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("No data found");
		}
	}

	@Override
	public void selectAllCustomerDetailsBasedonGender(String gender) {
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondMavenProject");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		String select = "select customer from Customer customer where customer.gender=:gender";
		Query query = manager.createQuery(select);
		query.setParameter("gender", gender);
		
		try {
			List<Customer> customer = (List<Customer>)query.getResultList();
			
			for(Customer cust : customer) 
			{
				System.out.println(cust);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("No data found");
		}
		
	}

}
