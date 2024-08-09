package com.jsp;

import java.util.Scanner;

import DAO.CustomerDAO;
import DAO.CustomerDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        	CustomerDAO customerDAO = new CustomerDAOImpl();
//        	customerDAO.insertCustomerDetails();
//        	customerDAO.selectCustomerDataUsingById(1);
//        	customerDAO.updateCustomerPasswordByUsingId(1, "5678");
//        	customerDAO.deleteCustomerDetailsByUsingId(1);
//        	customerDAO.updateCustomerPasswordByUsingEmailId("1234", "mofq@gmail.com");
//        	Scanner scan = new Scanner(System.in);
//        	System.out.println("Enter mobile number to delete the record");
//        	long mobileNumber = scan.nextLong();
//        	customerDAO.deleteCustomerDetailsByUsingMobileNumber(mobileNumber);
        	
//        	customerDAO.selectCustomerDetailsByUsingCustomerId(1);
        	
//        	customerDAO.selectAllCustomerDetails();
        	customerDAO.selectAllCustomerDetailsBasedonGender("M");
    }
}
