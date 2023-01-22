package assignment11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility;

public class SnapShot {
	
	public static String getCurrentTime()
	{
		String date = new SimpleDateFormat("HH:MM:SS_DD_MMM_YYYY").format(new Date());
		return date;
	}
	
	public static void captureScreenShotForWebelement(WebElement element)
	{
		try {
			
			File src = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/Screenshot_"+getCurrentTime()+".png");
					//+ "./screenshots/Snapshots_"+Utility.getCurrentTime()+".png");
			FileHandler.copy(src, dest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		}
	

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		//TakesScreenshot ts = (TakesScreenshot)driver;
		//File src = ts.getScreenshotAs(OutputType.FILE);
		/*driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Boolean b =wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='demo']"), "WebDriver"));
		System.out.println("WebDriver present status : "+b);
		File src = driver.findElement(By.xpath("//p[@id='demo']")).getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/FirstScreenshot1.png");
		FileHandler.copy(src, dest);*/
		WebElement button = driver.findElement(By.xpath("//button[text()='Click me to start timer']"));
		Utility.captureScreenShotForWebelement(button);
		System.out.println(SnapShot.getCurrentTime());
		driver.quit();
	}

}
