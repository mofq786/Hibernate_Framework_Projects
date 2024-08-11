package com.jsp.DAO;

import com.jsp.entity.UserInformation;

public interface BankDAO {
	
	boolean insertBankCustomerDetails();
	boolean creditAmountInAccount(UserInformation userInformation, double creditAmount);
	boolean debitAmountFromAccount(UserInformation userInformation, double debitAmount);
	boolean changePasswordByUsingId(UserInformation userInformation, String password);
	UserInformation searchUserAccountDetailsByUsingMobileAndPassword(String mobileNumber,String password);

}
