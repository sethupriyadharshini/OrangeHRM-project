package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(dataProvider = "loginDetails",dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String uname,String pass)
	{
		LoginPage login=new LoginPage(driver);
		
		DashboardPage dp = login.loginToApplication(uname, pass);
			
		// Assertion
		
		Assert.assertTrue(dp.getCurrentURL().contains("dashboard"),"It's matched");
		
		// Logout
		
		// Home
		
	}
	
}
