package helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;
	static Actions act;
	static JavascriptExecutor js;
	
	public static void typeValuesInTextBox(WebDriver driver, By locator, String values)
	{
		driver.findElement(locator).sendKeys(values);
	}
	
	public static void clickElement(WebDriver driver, By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {

			try {
				System.out.println("Trying with JS Click1");
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", driver.findElement(locator));
			} catch (Exception e2) {
				System.out.println("Trying with JS Click2 using scroll");
				js = (JavascriptExecutor) driver;
				//js.executeScript("window.scrollIntoView(true)", driver.findElement(locator));
				js.executeScript("arguments[0].click()", driver.findElement(locator));
				try {
					System.out.println("Trying with actions class click");
					act = new Actions(driver);
					act.moveToElement(driver.findElement(locator)).click().build().perform();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void elementToMove(WebDriver driver, By locator)
	{
		act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).build().perform();
	}
	
	public static void clickElementPassingUserInput(WebDriver driver,By locator,String input) {
		List<WebElement> values = driver.findElements(locator);
		for(WebElement e:values) {
			if(e.getText().contains(input)) {
				//waitForSeconds(2000);
				e.click();
				break;
			}
		}
	}
	
	public static void clickElementByPassingUserInputInTable(WebDriver driver,By row_locator,By col_locator,
			By checkbox_locator,By deleticon_locator, String input) {
		
		List<WebElement> row = driver.findElements(row_locator);
		List<WebElement> col = driver.findElements(col_locator);
		for(WebElement e:row) {
			for(WebElement e1:col) {
				if(e1.getText().contains(input)) {
					clickElement(driver, checkbox_locator);
					clickElement(driver, deleticon_locator);
					break;
				}
			}
		}	
	}
	
	public static boolean isDisplayedCheck(WebDriver driver, By locator) {
		try {
		boolean b = driver.findElement(locator).isDisplayed();
		return b ;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	public static void waitForSeconds(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static WebElement explicitWait(WebDriver driver, int sec, By locator) {
		WebDriverWait wb= new WebDriverWait(driver, Duration.ofSeconds(sec));
		WebElement ele = wb.until(ExpectedConditions.elementToBeClickable(locator));
		return ele;
	}

	public static String getCurrentTime() {
		String date = new SimpleDateFormat("HH-MM-SS_DD_MMM_YYYY").format(new Date());
		return date;
	}
	
	public static String captureScreenshotInBase64(WebDriver driver)
	{
	
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String base64=ts.getScreenshotAs(OutputType.BASE64);
		
		return base64;
		
	}
	
}
