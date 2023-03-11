package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By user_id = By.name("username");
	By pass = By.name("password");
	By sign_in = By.xpath("//button[.=' Login ']");
	
	public DashboardPage loginToApplication(String username, String password)
	{
		Utility.typeValuesInTextBox(driver,user_id,username);
		Utility.typeValuesInTextBox(driver,pass,password);
		Utility.clickElement(driver, sign_in);
		return new DashboardPage(driver);
	}
	
}
