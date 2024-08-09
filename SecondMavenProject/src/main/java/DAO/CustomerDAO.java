package DAO;

import com.jsp.entity.Customer;

public interface CustomerDAO {
	void insertCustomerDetails();
	void selectCustomerDataUsingById(int id);
	void updateCustomerPasswordByUsingId(int id,String password);
	void deleteCustomerDetailsByUsingId(int id);
	void updateCustomerPasswordByUsingEmailId(String password, String emailid);
	void deleteCustomerDetailsByUsingMobileNumber(long mobileNumber);
	void selectCustomerDetailsByUsingCustomerId(int id);
	void selectAllCustomerDetails();
	void selectAllCustomerDetailsBasedonGender(String gender);
}
