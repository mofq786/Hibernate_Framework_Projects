package com.jsp.service;

import com.jsp.entity.UserInformation;

public interface BankCustomerService {
	boolean BankCustomerDetails();
	UserInformation customerLogin();
	void debit();
	void credit();
	void changePassword();
}
