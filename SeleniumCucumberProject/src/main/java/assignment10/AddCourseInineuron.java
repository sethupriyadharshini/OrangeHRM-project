package assignment10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class AddCourseInineuron {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String uname ="ineuron@ineuron.ai";
		String pwd ="ineuron";
		driver.findElement(By.id("email1")).sendKeys(uname);
		driver.findElement(By.id("password1")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		Thread.sleep(3000);
		WebElement manage = driver.findElement(By.xpath("(//span[contains(text(),'Manage')])[1]"));
		Actions act = new Actions(driver);
		
		act.moveToElement(manage).build().perform();
		driver.findElement(By.xpath("//a[contains(@href,'course/manage')]")).click();
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//button[text()='Add New Course ']"));
        //WebElement element = driver.findElement(By.xpath("//*[@href='/course/manage']"));
        je.executeScript("arguments[0].click();",element);
		
		
		driver.findElement(By.xpath("//input[@id='thumbnail']")).sendKeys("C:\\Users\\sksunthayaalan\\Desktop\\cypress.png");
        Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Cypress");
		driver.findElement(By.id("description")).sendKeys("Cypress");
		driver.findElement(By.id("instructorNameId")).sendKeys("Priya");
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("2000");
		driver.findElement(By.xpath("//input[contains(@name,'startDate')]")).click();
		
		String month ="March";
		String year ="2023";
		driver.findElement(By.xpath("//*[@aria-selected='true']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'endDate')]")).click();
		
		while(true)
		{
			String monthyear = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();
			String a[]=monthyear.split(" ");
			String mon = a[0];
			String yr = a[1];
			if(mon.equals(month)&&yr.equals(year))
			{
				driver.findElement(By.xpath("//div[contains(@class,'day--009')]")).click();
				break;
				
			}
			else
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
		}
		driver.findElement(By.xpath("//div[text()='Select Category']")).click();
		driver.findElement(By.xpath("//button[text()='Testing']")).click();
	
		
		//VERIFY COURSE IS ADDED
		Thread.sleep(2000);
		List<WebElement> v=driver.findElements(By.xpath("//tbody/tr/td[2]"));
		System.out.println(v.size());
		for(WebElement e:v)
		{
			String chck=e.getText();
			if(chck.contains("Cypress")) {
				System.out.println("Present");
				Thread.sleep(2000);
				WebElement del=driver.findElement(By.xpath("//tbody/tr/td[text()='Cypress']/following-sibling::td/button[text()='Delete']"));
				je.executeScript("arguments[0].scrollIntoView(true);", del);
				je.executeScript("arguments[0].click();", del);
			}
			else
			{
				System.out.println("Not Present");
			}
		}
		
		//VERIFY COURSE IS DELETED
				Thread.sleep(2000);
				List<WebElement> v1=driver.findElements(By.xpath("//tbody/tr/td[2]"));
				System.out.println(v1.size());
				for(WebElement e:v1)
				{
					String chck=e.getText();
					if(chck.contains("Cypress")) {
						System.out.println("Present");
					}
					else
					{
						System.out.println("Not Present");
					}
				}
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
		
	}

}
