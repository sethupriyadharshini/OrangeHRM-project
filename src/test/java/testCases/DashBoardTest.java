package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddNewUser;
import pages.DashboardPage;

public class DashBoardTest extends BaseClass {

	@Test
	public void dashBoardTest()
	{
		DashboardPage dp = new DashboardPage(driver);
		
		AddNewUser anu = dp.clickManageCourse();
			
		// Assertion
		Assert.assertTrue(anu.getCurrentURL().contains("saveSystemUser"), "saveSystemUser displayed unsuccessfully");
		
	}
	
}
