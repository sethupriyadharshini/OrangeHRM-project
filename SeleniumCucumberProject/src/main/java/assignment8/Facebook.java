package assignment8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {
	
	public static WebDriver driver;
	
	public static void Task1()
	{
		String given_text = "Facebook helps you connect and share with the people in your life";
		String capture_text = driver.findElement(By.xpath("//*[contains(text(),'Facebook helps')]")).getText();
		System.out.println("Capture text : "+capture_text);
		if(given_text.equals(capture_text))
		{
			System.out.println("Text Matched");
		}
		else
		{
			System.out.println("Text not Matched");
		}
	}
	
	public static void Task2()
	{
		WebElement ele = driver.findElement(By.xpath("//*[@id='pageFooter']"));
		List<WebElement> footer_list = ele.findElements(By.tagName("a"));
		for(WebElement e:footer_list)
		{
			System.out.println("Footer Text are : "+e.getText());
			if(e.getText().equals("Create Page"))
			{
				e.click();
				System.out.println("*****SUCESSFULLY LOADED*****");
				break;
			}
		}
	}
	
	public static void Task3() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
		String f_name = "Sethupriyan";
		String l_name = "S";
		String mail = "sethupriyadharshinis@gmail.com";
		String new_pwd = "Hello@123";
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@name,'first')]")).sendKeys(f_name);
		driver.findElement(By.xpath("//*[contains(@name,'last')]")).sendKeys(l_name);
		driver.findElement(By.xpath("//*[contains(text(),'Mobile')]/following::input[1]")).sendKeys(mail);
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//*[contains(@name,'reg_email_con')]")).sendKeys(mail);
		driver.findElement(By.xpath("//*[contains(@aria-label,'New')]")).sendKeys(new_pwd);
		Thread.sleep(2000);
		Select ss = new Select(driver.findElement(By.xpath("//*[contains(@title,'Day')]")));
		List<WebElement> days =ss.getOptions();
		for(WebElement d:days)
		{
			String dd =d.getText();
			String s ="3";
			if(dd.equals(s))
			{
				d.click();
				break;
			}
		}
		
		Select ss1 = new Select(driver.findElement(By.xpath("//*[contains(@title,'Month')]")));
		List<WebElement> months =ss1.getOptions();
		for(WebElement m:months)
		{
			String mm =m.getText();
			String mon ="Feb";
			if(mm.equals(mon))
			{
				m.click();
				break;
			}
		}
		
		Select ss2=new Select(driver.findElement(By.xpath("//*[contains(@title,'Year')]")));
		List<WebElement> years =ss2.getOptions();
		for(WebElement y:years)
		{
			String yy =y.getText();
			String yr ="1995";
			if(yy.equals(yr))
			{
				y.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[contains(@value,'1')]")).click();
		
		driver.findElement(By.xpath("//button[contains(@name,'websubmit')]")).click();
		
	}
	
	public static void Task4() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a[data-testid*='open']")).click();
		String f_name = "Sethupriyan";
		String l_name = "S";
		String mail = "sethupriyadharshinis@gmail.com";
		String new_pwd = "Hello@123";
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[name*='first']")).sendKeys(f_name);
		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys(l_name);
		driver.findElement(By.cssSelector("input[aria-label*='Mobile']")).sendKeys(mail);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[aria-label*='Re-enter']")).sendKeys(mail);
		driver.findElement(By.cssSelector("input[aria-label*='New pas']")).sendKeys(new_pwd);
		Thread.sleep(2000);
		
		Select ss = new Select(driver.findElement(By.cssSelector("select#day")));
		List<WebElement> days =ss.getOptions();
		for(WebElement d:days)
		{
			String dd =d.getText();
			String s ="3";
			if(dd.equals(s))
			{
				d.click();
				break;
			}
		}
		
		Select ss1 = new Select(driver.findElement(By.cssSelector("select#month")));
		List<WebElement> months =ss1.getOptions();
		for(WebElement m:months)
		{
			String mm =m.getText();
			String mon ="Feb";
			if(mm.equals(mon))
			{
				m.click();
				break;
			}
		}
		
		Select ss2=new Select(driver.findElement(By.cssSelector("select#year")));
		List<WebElement> years =ss2.getOptions();
		for(WebElement y:years)
		{
			String yy =y.getText();
			String yr ="1995";
			if(yy.equals(yr))
			{
				y.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("span>input[value*='2']")).click();
		
		driver.findElement(By.cssSelector("button[name*='web']")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		Facebook.Task1();
		Facebook.Task2();
		Facebook.Task3();
		Facebook.Task4();
		driver.quit();
	}

}
