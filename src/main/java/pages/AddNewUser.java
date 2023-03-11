package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class AddNewUser {

	WebDriver driver;
	
	public AddNewUser(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By user_role_arrow = By.xpath("(//div/i[contains(@class,'oxd-icon bi-caret-down-')])[1]");
	
	By select_user_role = By.xpath("//div[@role = 'listbox']/child::div");
	
	By employee_name = By.xpath("//input[@placeholder='Type for hints...']");
	
	By employee_name_ddown = By.xpath("//div[@role='listbox']/div[@role='option']");
	
	By status_arrow = By.xpath("(//div/i[contains(@class,'oxd-icon bi-caret-down-')])[2]");	
	
	By select_status = By.xpath("//div[@role = 'listbox']/child::div");
	
	By new_username = By.xpath("(//input[contains(@class,'oxd-input')])[2]");
	
	By password = By.xpath("(//input[contains(@class,'oxd-input')])[3]");
	
	By confirm_password = By.xpath("(//input[contains(@class,'oxd-input')])[4]");
	
	By save_btn = By.xpath("//button[.=' Save ']"); 
	
	By success_msg = By.xpath("//div[contains(@class,'oxd-toast-content ')]/p[.='Successfully Saved']");
	
	public ViewUser addNewUser(String role,String e_name,String emp_name,String status,String name,String pwd) {
		Utility.clickElement(driver, user_role_arrow);
		Utility.clickElementPassingUserInput(driver, select_user_role, role);
		Utility.typeValuesInTextBox(driver, employee_name, e_name);//Peter Mac Anderson
		Utility.waitForSeconds(3000);
		//Utility.explicitWait(driver, 30, employee_name_ddown);
		Utility.clickElementPassingUserInput(driver, employee_name_ddown, emp_name);
		Utility.clickElement(driver, status_arrow);
		Utility.clickElementPassingUserInput(driver, select_status, status);
		Utility.typeValuesInTextBox(driver, new_username, name);
		Utility.typeValuesInTextBox(driver, password, pwd);
		Utility.typeValuesInTextBox(driver, confirm_password, pwd);
		Utility.waitForSeconds(5000);
		System.out.println(Utility.explicitWait(driver, 50, save_btn).isDisplayed());
		Utility.clickElement(driver, save_btn);
		Utility.waitForSeconds(3000);
		return new ViewUser(driver);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean verifySavedStatus() {
		if(Utility.isDisplayedCheck(driver, success_msg)) {
			return true;
		}
		return false;
	}
	
}
