package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.AddNewUser;
import pages.ViewUser;

public class NewUserTest extends BaseClass {

	@Test(dataProvider = "addNewUser",dataProviderClass = CustomDataProvider.class)
	public void newUser(String role,String e_name,String emp_name,String status,String name,String pwd)
	{
		AddNewUser anu = new AddNewUser(driver);
		
		ViewUser vs = anu.addNewUser(role,e_name,emp_name,status,name,pwd);
			
		// Assertion
		System.out.println(vs.getCurrentURL());
		Assert.assertTrue(vs.getCurrentURL().contains("saveSystemUser"), "saveSystemUser displayed unsuccessfully");
		
		Assert.assertTrue(anu.verifySavedStatus(), "It should match but we got info as not matched");
		
		
	}
	
}
