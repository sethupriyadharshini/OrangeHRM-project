package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class ViewUser {
	
	WebDriver driver;
	
	public ViewUser(WebDriver driver) {
		this.driver = driver;
	}
	
	By user_name = By.xpath("(//input[contains(@class,'oxd-input ')])[2]");
	
	By user_role_arrow = By.xpath("(//div[contains(@class,'oxd-select-text')]/i)[1]");
	
	By select_user_role = By.xpath("//div[@role = 'listbox']/child::div");
	
	By employee_name = By.xpath("//input[@placeholder='Type for hints...']");
	
	By employee_name_ddown = By.xpath("//div[@role='listbox']/div[@role='option']");
	
	By status_arrow = By.xpath("(//div[contains(@class,'oxd-select-text')]/i)[2]");
	
	By select_status = By.xpath("//div[@role = 'listbox']/child::div");
	
	By submit_btn = By.xpath("//button[.=' Search ']");
	
	By webtable_row = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");
	
	By webtable_cell = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[@role='cell'][2]");
	
	By webtable_cell_checkbox = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[@role='cell'][1]");
	
	By webtable_cell_delete = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[@role='cell'][6]//button[1]");
	
	By delete_btn = By.xpath("//button[.=' Yes, Delete ']");
	
	public Logout searchUser(String name,String role,String e_name,String emp_name,String status) {
		Utility.waitForSeconds(6000);
		Utility.typeValuesInTextBox(driver, user_name, name);
		Utility.clickElement(driver, user_role_arrow);
		Utility.clickElementPassingUserInput(driver, select_user_role, role);
		/*Utility.typeValuesInTextBox(driver, employee_name, e_name);//Peter Mac Anderson
		Utility.waitForSeconds(5000);
		Utility.clickElementPassingUserInput(driver, employee_name, emp_name);
		Utility.clickElement(driver, status_arrow);
		Utility.clickElementPassingUserInput(driver, employee_name, status);*/
		Utility.clickElement(driver, submit_btn);
		Utility.clickElementByPassingUserInputInTable(driver, webtable_row, webtable_cell, webtable_cell_checkbox, webtable_cell_delete, name);
		Utility.waitForSeconds(2000);
		driver.findElement(delete_btn).click();
		return new Logout(driver);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
}
