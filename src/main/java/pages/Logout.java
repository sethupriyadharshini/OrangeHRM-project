package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class Logout {
	
	WebDriver driver;
	
	public Logout(WebDriver driver) {
		
		this.driver = driver;
	}

	By image_click = By.className("oxd-userdropdown-tab");
	
	By logout_click = By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]");
	
	public void logoutTheApplication() {
		
		Utility.clickElement(driver, image_click);
		
		Utility.clickElement(driver, logout_click);
	}
	
}
