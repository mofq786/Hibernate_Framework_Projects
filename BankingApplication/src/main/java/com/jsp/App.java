package com.jsp;

import java.util.Scanner;
import com.jsp.entity.UserInformation;
import com.jsp.service.BankCustomerService;
import com.jsp.service.BankCustomerServiceImpl;

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
        	BankCustomerService bankCustomerService = new BankCustomerServiceImpl();
        	switch(choice)
        	{
        		case 1:{
        			if(bankCustomerService.BankCustomerDetails())
        			{
        				System.out.println("------ Registration Successfull ------");
        			}
        			else {
        				System.err.println("Registration Unsuccessfull");
        			}
        		}
        		break;
        		
        		case 2:{
        			
        			UserInformation userInformation = bankCustomerService.customerLogin();
        			
        			if(userInformation != null)
        			{
        				System.out.println("\n****=====Login Successfull======****");
        				boolean loginStatus = true;
        				
        				while(loginStatus)
        				{
        					System.out.println("\nEnter Choice Options to perform operations\n  1.Credit Amount\n  2.Debit Amount\n  3.Change Password\n4.  4.Log-out\n");
        					int select = sc.nextInt();
        	
        					switch(select)
        					{
        						case 1:{
        							
        							bankCustomerService.credit();
        						}
        						break;
        						
        						case 2:{
        							
        							bankCustomerService.debit();
        							
        						}
        						break;
        						
        						case 3:{
        							
        							bankCustomerService.changePassword();
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
        
        sc.close();
        
    }
}
