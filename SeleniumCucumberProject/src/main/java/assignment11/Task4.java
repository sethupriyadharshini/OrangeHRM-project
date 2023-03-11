package assignment11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import helper.Utility;

public class Task4 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		List<WebElement> findElement = driver.findElements(By.id("demo"));
		String search_txt = "WebDriver";
		// System.out.println(findElement.getText());
		Utility.waitForElement(findElement, search_txt);
		driver.close();
	}

}
