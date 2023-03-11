package assignment6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM2 {
	
	public static WebDriver driver;

	public static void Task1()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean u1_xp=driver.findElement(By.xpath("//input[contains(@name,'username')]")).isDisplayed();
		System.out.println("u1_xp check:"+u1_xp);
		boolean p1_xp =driver.findElement(By.xpath("//input[contains(@name,'password')]")).isDisplayed();
		System.out.println("p1_xp check:"+p1_xp);
		boolean l1_xp =driver.findElement(By.xpath("//*[contains(@type,'submit')]")).isDisplayed();
		System.out.println("l1_xp check:"+l1_xp);
		
		boolean u2_xp=driver.findElement(By.xpath("//*[text()='Username']")).isDisplayed();
		System.out.println("u2_xp check:"+u2_xp);
		boolean p2_xp =driver.findElement(By.xpath("//*[text()='Password']")).isDisplayed();
		System.out.println("p2_xp check:"+p2_xp);
		boolean l2_xp=driver.findElement(By.xpath("//*[text()=' Login ']")).isDisplayed();
		System.out.println("l2_xp check:"+l2_xp);
		
		boolean u3_xp=driver.findElement(By.xpath("//*[@class='oxd-form-row'][1]/child::div//input")).isDisplayed();
		System.out.println("u3_xp check:"+u3_xp);
		boolean p3_xp=driver.findElement(By.xpath("//*[@class='oxd-form-row'][2]/child::div//input")).isDisplayed();
		System.out.println("p3_xp check:"+p3_xp);
		boolean l3_xp=driver.findElement(By.xpath("//*[@class='oxd-form']/child::div[3]/button")).isDisplayed();
		System.out.println("l3_xp check:"+l3_xp);
		
		boolean u1_cs=driver.findElement(By.cssSelector("input[name*='user']")).isDisplayed();
		System.out.println("u1_cs check:"+u1_cs);
		boolean p1_cs=driver.findElement(By.cssSelector("input[name*='pas']")).isDisplayed();
		System.out.println("p1_cs check:"+p1_cs);
		boolean l1_cs=driver.findElement(By.cssSelector("button[type*='sub']")).isDisplayed();
		System.out.println("l1_cs check:"+l1_cs);
		
		boolean u2_cs=driver.findElement(By.cssSelector("input[name^='us']")).isDisplayed();//startswith
		System.out.println("u2_cs check:"+u2_cs);
		boolean p2_cs=driver.findElement(By.cssSelector("input[name$='rd']")).isDisplayed();//endswith
		System.out.println("p2_cs check:"+p2_cs);
		boolean l2_cs=driver.findElement(By.cssSelector("button[type^='sub']")).isDisplayed();
		System.out.println("l2_cs check:"+l2_cs);
		
		boolean u3_cs=driver.findElement(By.cssSelector("input[placeholder='Username']")).isDisplayed();//startswith
		System.out.println("u3_cs check:"+u3_cs);
		boolean p3_cs=driver.findElement(By.cssSelector("input[placeholder='Password']")).isDisplayed();//endswith
		System.out.println("p3_cs check:"+p3_cs);
		boolean l3_cs=driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed();
		System.out.println("l3_cs check:"+l3_cs);
		
	}
	
	public static void Task2() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[(text()=' Login ')]")).click();
		
		//driver.findElement(By.xpath("//*[starts-with(@class,'oxd-icon bi-list ')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'admin')]")).click();
		driver.findElement(By.xpath("//*[text()=' Add ']")).click();
		
		driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text ')])[1]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/div[2]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
		List<WebElement> allopt=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		for(WebElement e:allopt)
		{
			System.out.println("Suggestion values when type A in Employee field : "+e.getText());
			if(e.getText().contains("Lisa Andrews"))
			{
				e.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text ')])[2]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/div[2]")).click();
		driver.findElement(By.xpath("(//div/input[contains(@class,'oxd-input')])[2]")).sendKeys("Anjana");
		driver.findElement(By.xpath("(//div/input[contains(@class,'oxd-input')])[3]")).sendKeys("Anjana@12");
		driver.findElement(By.xpath("(//div/input[contains(@class,'oxd-input')])[4]")).sendKeys("Anjana@12");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[type='submit']")).submit();
		//WebElement submit =driver.findElement(By.xpath("//button[@type='submit']"));
		/*JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//button[@type='submit']")));
		je.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@type='submit']")));
		/*Actions act =new Actions(driver);
		WebElement submit =driver.findElement(By.xpath("//button[@type='submit']"));
		act.moveToElement(submit).click().build().perform();*/
		System.out.println("COMPLETED TASK2");
	}
	
	public static void Task3() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[(text()=' Login ')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'admin')]")).click();
		driver.findElement(By.xpath("//*[text()=' Add ']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
		List<WebElement> allopt=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		for(WebElement e:allopt)
		{
			if(e.getText().contains("Lisa Andrews"))
			{
				e.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text ')])[1]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/div[2]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text ')])[2]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/div[2]")).click();
		driver.findElement(By.xpath("(//div/input[contains(@class,'oxd-input')])[2]")).sendKeys("Sanjana");
		driver.findElement(By.xpath("(//div/input[contains(@class,'oxd-input')])[3]")).sendKeys("Sanjana@12");
		driver.findElement(By.xpath("(//div/input[contains(@class,'oxd-input')])[4]")).sendKeys("Sanjana@12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String success_msg =driver.findElement(By.xpath("//p[contains(@class,'toast-mess')]")).getText();
		String search_msg="Successfully Saved";
		if(success_msg.equals(search_msg))
		{
			System.out.println("Successfully Added");
		}
		
		String search_op=driver.findElement(By.tagName("h5")).getText();
		String search_text="System Users";
		if(search_op.equals(search_text))
		{
			System.out.println("Entered into Search Flow");
		}
		driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[2]")).sendKeys("Sanjana");
		driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text ')])[1]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/div[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
		List<WebElement> allopt1=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		for(WebElement e:allopt1)
		{
			if(e.getText().contains("Lisa Andrews"))
			{
				e.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text ')])[2]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/div[2]")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).submit();
		driver.findElement(By.xpath("//button/i[contains(@class,'trash')]")).click();
		driver.findElement(By.xpath("//button/i[contains(@class,'trash oxd')]")).click();
		String del_msg =driver.findElement(By.xpath("//p[contains(@class,'toast-mess')]")).getText();
		String searchdel_msg="Successfully Deleted";
		if(del_msg.equals(searchdel_msg))
		{
			System.out.println("Successfully Deleted");
		}
		driver.findElement(By.xpath("(//img[@alt='profile picture'])[1]")).click();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		OrangeHRM2.Task1();
		OrangeHRM2.Task2();
		OrangeHRM2.Task3();
		driver.close();
	}

}
