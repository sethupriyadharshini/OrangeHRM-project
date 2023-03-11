package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.Logout;
import pages.ViewUser;

public class ViewUsersTest extends BaseClass {

	@Test(dataProvider = "ViewUser",dataProviderClass = CustomDataProvider.class)
	public void viewUsers(String name,String role,String e_name,String emp_name,String status)
	{
		ViewUser vu = new ViewUser(driver);
		
		Logout logout = vu.searchUser(name,role,e_name,emp_name,status);
		
		// Logout
		
		logout.logoutTheApplication();
			
		// Assertion
		Assert.assertTrue(vu.getCurrentURL().contains("login"), "login displayed unsuccessfully");
				
	}
	
}
