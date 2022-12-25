package assignment9;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IneuronSignup {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://ineuron-courses.vercel.app/signup");
        Thread.sleep(5000);
        String name ="Sethupriyadharshini";
        String u_name ="sethupriyadharshini55@gmail.com";
        String pwd ="sethu@123";
        JavascriptExecutor je = (JavascriptExecutor) driver;
        /*WebElement element = driver.findElement(By.xpath("//*[text()='Sign up']"));
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        boolean b = element.isEnabled();*/
        boolean b = driver.findElement(By.xpath("//*[text()='Sign up']")).isEnabled();
        System.out.println("Sign up button checking -before: "+b);
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("email")).sendKeys(u_name);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.xpath("//*[text()='Testing']//preceding::input[1]")).click();
        WebElement e = driver.findElement(By.xpath("//input[contains(@value,'Female')]"));
        je.executeScript("arguments[0].click();",e);
        Select select =new Select(driver.findElement(By.id("state")));
        select.selectByVisibleText("Tamil Nadu");
        boolean b1 = driver.findElement(By.xpath("//*[text()='Sign up']")).isEnabled();
        System.out.println("Sign up button checking -after : "+b1);
        //JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[text()='Sign up']"));
        je.executeScript("arguments[0].click();",element);
        Thread.sleep(2000);
        driver.findElement(By.id("email1")).sendKeys(u_name);
        driver.findElement(By.id("password1")).sendKeys(pwd);
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Sign out']")).click();
        driver.quit();
        }
    }