
package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Utility {

	public static WebDriver driver;
	public static Actions act;

	public static String getCurrentTime() {
		String date = new SimpleDateFormat("HH-MM-SS_DD_MMM_YYYY").format(new Date());
		return date;
	}

	public static void captureScreenShotForWebelement(WebElement element) {
		try {
			FileHandler.copy(element.getScreenshotAs(OutputType.FILE),
					new File("./screenshots/Snapshots_" + getCurrentTime() + ".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void waitForElement(List<WebElement> findElement, String search_txt) {
		try {
			for (int i = 0; i <= 15; i++) {
				for (WebElement e : findElement) {
					if (e.getText().contains(search_txt)) {
						System.out.println("Element found");
						break;
					} else {
						System.out.println("Wait for WebDriver element to found");
						// System.out.println(e.getText());
						waitForSeconds(1);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver startBrowser(String br, String url) {

		if (br.contains("Chrome")) {
			driver = new ChromeDriver();
		} else if (br.contains("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			Reporter.log("This" + br + "is not available");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public static void clickElement(WebDriver driver, By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {

			try {
				System.out.println("Trying with JS Click1");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", driver.findElement(locator));
			} catch (Exception e2) {
				System.out.println("Trying with JS Click2");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollIntoView(true)", driver.findElement(locator));
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

	public static void elementwait(WebDriver driver, Duration ofSeconds, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, ofSeconds);
			WebElement s = wait.until(ExpectedConditions.elementToBeClickable(locator));
			System.out.println(s.getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void elementMove(WebDriver driver, By locator) {
		try {
			waitForSeconds(2);
			act = new Actions(driver);
			act.moveToElement(driver.findElement(locator)).build().perform();
		} catch (Exception e) {
			act.moveByOffset(100, 10).click().build().perform();
		}
	}

}
