package com.jsp.DAO;

import com.jsp.entity.UserInformation;

public interface BankDAO {
	
	int insertBankCustomerDetails(UserInformation userInformation);
	boolean updateAmountInAccount(UserInformation userInformation, double balance);
	boolean changePasswordByUsingId(UserInformation userInformation, String password);
	UserInformation searchUserAccountDetailsByUsingMobileAndPassword(String emailId,String password);

}
