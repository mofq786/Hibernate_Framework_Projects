package com.jsp;

import com.jsp.DAO.UserDAO;
import com.jsp.DAO.UserDAOimpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDAO userDAO = new UserDAOimpl();
        userDAO.insertUserInformationObject();
    }
}
