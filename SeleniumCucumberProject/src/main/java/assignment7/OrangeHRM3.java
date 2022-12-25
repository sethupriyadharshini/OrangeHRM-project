package assignment7;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRM3 {

	public static WebDriver driver;
	
	public static void Task1()
	{
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		String verify_text="Required";
		String u_req = driver.findElement(By.xpath("(//div[contains(@class,'oxd-input')]/span)[1]")).getText();
		System.out.println("u:"+u_req);
		String p_req = driver.findElement(By.xpath("(//div[contains(@class,'oxd-input')]/span)[2]")).getText();
		System.out.println("p:"+p_req);
		if(u_req.contains(verify_text)&&p_req.contains(verify_text))
		{
			System.out.println("Required text is present");
		}
		else
		{
			System.out.println("Required text is not present");
		}
		
		String u_border= driver.findElement(By.xpath("//*[@name='username']")).getCssValue("border");
		System.out.println(u_border);
		String p_border= driver.findElement(By.xpath("//*[@name='password']")).getCssValue("border");
		System.out.println(p_border);		
	}
	
	public static void Task2()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String verify_text="Required";
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		String p_req = driver.findElement(By.xpath("//div[contains(@class,'oxd-input')]/span")).getText();
		if(p_req.contains(verify_text))
		{
			System.out.println("Required text is present");
		}
		else
		{
			System.out.println("Required text is not present");
		}
	}
	
	public static void Task3()
	{
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("mukesh");
		driver.findElement(By.xpath("//button[(text()=' Login ')]")).click();
		String invalid_cred=driver.findElement(By.xpath("//p[contains(@class,'oxd-text')]")).getText();
		String verify_text="Invalid credentials";
		if(invalid_cred.contains(verify_text))
		{
			System.out.println("Invalid credentials text is present");
		}
		else
		{
			System.out.println("Invalid credentials text is not present");
		}
	}
	
	public static void Task4()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[(text()=' Login ')]")).click();
		String url = driver.getCurrentUrl();
		String check_url="dashboard";
		if(url.contains(check_url))
		{
			System.out.println("Dashboard is present in URL");
		}
		else
		{
			System.out.println("Dashboard is not present in URL");
		}
		
		driver.findElement(By.xpath("(//img[@alt='profile picture'])[1]")).click();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
		String verify_text1=driver.findElement(By.tagName("h5")).getText();
		if(verify_text1.contains("Login"))
		{
			System.out.println("Navigated to homepage");
		}
		else
		{
			System.out.println("Not Navigated to homepage");
		}
	}
	
	public static void Task5()
	{
		driver = new FirefoxDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.close();
		
		driver=new EdgeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.close();
		
	}
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		OrangeHRM3.Task1();
		OrangeHRM3.Task2();
		OrangeHRM3.Task3();
		OrangeHRM3.Task4();
		OrangeHRM3.Task5();
		driver.quit();
	}

}
