package assignment11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {
	
	public static WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	public void method1()
	{
		Boolean b =wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='demo']"), "WebDriver"));
		System.out.println("WebDriver present status : "+b);
	}
	
	public void method2()
	{
		Boolean b =wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//p[@id='demo']")), "WebDriver"));
		System.out.println("WebDriver present status : "+b);
		List<WebElement> w =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[@id='demo']")));
		for(WebElement e:w)
		{
			if(e.getText().contains("WebDriver"))
			{
				System.out.println("Element found");
			}
		}
	}
	
	public static void main(String[] args)
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		Task1 t1 = new Task1();
		t1.method1();
		t1.method2();
		driver.quit();
	}

}
