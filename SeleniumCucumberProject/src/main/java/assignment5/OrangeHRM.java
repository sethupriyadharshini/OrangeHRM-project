package assignment5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {
	
	public static WebDriver driver;
	
	public static void Task1()
	{
		boolean endcheck = driver.getCurrentUrl().endsWith("login");
		System.out.println("Login Check : "+endcheck);
		boolean containscheck = driver.getCurrentUrl().contains("demo");
		System.out.println("Demo Check : "+containscheck);
		boolean titlecheck = driver.getTitle().contains("HRM");
		System.out.println("HRM Check : "+titlecheck);
	}
	
	public static void Task2()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		boolean logo_check=driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']/img[@alt='orangehrm-logo']")).isDisplayed();
		if(logo_check==true)
		{
			System.out.println("Logo displayed");
		}
		else
		{
			System.out.println("Logo is not displayed");
		}
	}
	
	public static void Task3() throws InterruptedException
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		List<WebElement> element1 = element.findElements(By.tagName("a"));
        Thread.sleep(2000);
		int count = element1.size();
		System.out.println("Social media icon count : "+count);
	}
	
	public static void Task4() throws InterruptedException
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		List<WebElement> element1 = element.findElements(By.tagName("a"));
        Thread.sleep(2000);
        List<WebElement> add1=new ArrayList<WebElement>();
        for(WebElement e:element1)
        {
        	//e.getAttribute("href");
        	add1.add(e);
        }
        List<String> s = new ArrayList<String>();
        s.add("Linkedin");
        s.add("Facebook");
        s.add("Twitter");
        s.add("Youtube");
        
        Map<String, String> m=new LinkedHashMap<String, String>();
          	 for(int j=0;j<add1.size();j++)
             {
             	m.put(s.get(j),add1.get(j).getAttribute("href"));
             }
             System.out.println(m);
        
       
	}
	
	public static void Task5() throws InterruptedException
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		List<WebElement> element1 = element.findElements(By.tagName("a"));
        Thread.sleep(2000);
        for(WebElement e:element1)
        {
        	if(e.getAttribute("href").contains("youtube"))
        	{
        		System.out.println("Youtube present");
        		break;
        	}
        }
	}

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		OrangeHRM.Task1();
		OrangeHRM.Task2();
		OrangeHRM.Task3();
		OrangeHRM.Task4();
		OrangeHRM.Task5();
		//driver.close();
	}

}
