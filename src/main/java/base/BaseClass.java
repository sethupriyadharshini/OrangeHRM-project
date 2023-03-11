package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass  {

	public static WebDriver driver;
	
	@BeforeTest
	public void setupBrowser()
	{
		System.out.println("LOG:INFO - Setting up browser");
		
		driver= BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));
		
		System.out.println("LOG:INFO - Application is up and running");
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		
		System.out.println("LOG:INFO - Closing the browser and application");
	}
	
}


						