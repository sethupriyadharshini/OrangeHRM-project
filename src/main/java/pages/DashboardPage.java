package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By admin = By.linkText("Admin");
	By add_new_user_btn = By.xpath("//button[text()=\" Add \"]");
	static By verify_url_contains_dashboard = By.linkText("Dashboard");
	
	public AddNewUser clickManageCourse() {
		Utility.clickElement(driver, admin);
		Utility.clickElement(driver, add_new_user_btn);
		return new AddNewUser(driver);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	
}
