package com.jsp;

import java.util.Scanner;

import com.jsp.DAO.BankDAO;
import com.jsp.DAO.BankDAOImpl;
import com.jsp.entity.UserInformation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        System.out.println("====****    WELCOME TO BANKING APPLICATION    ****====");
        boolean status = true;
        
        while(status)
        {
        	System.out.println("\nEnter Any choice below.\n 1. User Registration\n 2. User Login\n 3. Exit");
        	int choice = sc.nextInt();
        	BankDAO bankDAO = new BankDAOImpl();
        	switch(choice)
        	{
        		case 1:{
        			if(bankDAO.insertBankCustomerDetails())
        			{
        				System.out.println("------ Registration Successfull ------");
        			}
        			else {
        				System.err.println("Registration Unsuccessfull");
        			}
        		}
        		break;
        		
        		case 2:{
        			
        			System.out.println("Enter Login Credentials\n");
        			
        			System.out.print("\nEnter Email Id: ");
        			String emailId = sc.next();
        			System.out.print("\nEnter Password: ");
        			String password = sc.next();
        			
        			UserInformation userInformation = bankDAO.searchUserAccountDetailsByUsingMobileAndPassword(emailId, password);
        			
        			if(userInformation != null)
        			{
        				System.out.println("\n****=====Login Successfull======****");
        				boolean loginStatus = true;
        				
        				while(loginStatus)
        				{
        					System.out.println("\nEnter Choise Options to perform operations\n  1.Credit Amount\n  2.Debit Amount\n  3.Change Password\n4.  4.Log-out\n");
        					int select = sc.nextInt();
        					double balance = userInformation.getAmount();
        					
        					switch(select)
        					{
        						case 1:{
        							System.out.println("Enter Amount to Credit into Account");
        							double creditAmount = sc.nextDouble();
        						
        							if(bankDAO.creditAmountInAccount(userInformation, balance+creditAmount))
        							{
        								System.out.println("Amount successfully credited into the account.");
        							}
        							else
        							{
        								System.err.println("Transaction Failed");
        							}
        							
        						}
        						break;
        						
        						case 2:{
        							
        							System.out.println("Enter Amount to Debit from Account");
        							double debitAmount = sc.nextDouble();
        							
        							if(balance >= debitAmount)
        							{
        								if(bankDAO.debitAmountFromAccount(userInformation, balance-debitAmount))
            							{
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
        						break;
        						
        						case 3:{
        							
        							System.out.println("Enter New Password");
        							String newPassword = sc.next();
        							
        							if(bankDAO.changePasswordByUsingId(userInformation, newPassword))
        							{
        								System.out.println("Password Changed Succesfully");
        							}
        							else
        							{
        								System.err.println("Transaction Failed");
        							}
        						}
        						break;
        						
        						case 4:
        						{
        							loginStatus = false;
        							System.out.println("Logged out successfully");
        						}
        						break;
        						
        						default: System.out.println("Enter valid option..");
        						break;
        					}
        				}
        			}
        			else 
        			{
        				System.out.println("\nNo Details found...");
        			}
            		
        		}
        		break;
        		
        		case 3:{
            		status = false;
        		}
        		break;
        		
        		default:{
        			System.out.println("\nEnter Valid Option\n");
        		}
        	}
        }
        
        System.out.println("*********======= Thank you for using my application =======**********");
        
    }
}
