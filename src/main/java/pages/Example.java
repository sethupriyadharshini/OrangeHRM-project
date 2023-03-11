package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[.=' Login ']")).click();
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.xpath("//button[text()=\" Add \"]")).click();
		driver.findElement(By.xpath("(//div/i[contains(@class,'oxd-icon bi-caret-down-')])[1]")).click();
		List<WebElement> arrow1 = driver.findElements(By.xpath("//div[@role = 'listbox']/child::div"));
		for(WebElement e : arrow1)
		{
			System.out.println(e.getText());
			if(e.getText().contains("ESS"))
			{
				e.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("P");
		Thread.sleep(2000);
		List<WebElement> emp_name = driver.findElements(By.xpath("//div[@role='listbox']/div[@role='option']"));
		for(WebElement e : emp_name)
		{
			System.out.println(e.getText());
			if(e.getText().contains("Peter Mac Anderson"))
			{
				e.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//div/i[contains(@class,'oxd-icon bi-caret-down-')])[2]")).click();
		//By select_status = By.xpath("//span[.='Enabled']");
		List<WebElement> select_status = driver.findElements(By.xpath("//div[@role = 'listbox']/child::div"));
		for(WebElement e : select_status)
		{
			System.out.println(e.getText());
			if(e.getText().contains("Enabled"))
			{
				e.click();
				break;
			}
		}
		By save = By.xpath("//button[.=' Save ']");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(save)));
		driver.findElement(save).click();
	}

}
