package assignment12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.Utility;

public class TestNGTask {

	public static WebDriver driver;

	@Parameters({ "browser", "URL" })
	@BeforeTest
	public void setUp(@Optional("I'm browser optional") String br, @Optional("I'm URL optional") String url) {
		driver = Utility.startBrowser(br, url);
	}

	@Test(priority = 0)
	public void loginScenario() {
		Reporter.log("*****Login method started*****", true);
		String uname = "ineuron@ineuron.ai";
		String pwd = "ineuron";
		driver.findElement(By.id("email1")).sendKeys(uname);
		driver.findElement(By.id("password1")).sendKeys(pwd);
		By submit = By.xpath("//button[contains(@type,'submit')]");
		Utility.clickElement(driver, submit);
		String actual_title = driver.getTitle();
		String expected_title = "iNeuron Courses";
		Assert.assertEquals(actual_title,expected_title);
		Reporter.log("*****Login method stopped*****", true);
	}

	@Test(priority = 1, dependsOnMethods = "loginScenario")
	public void clickManageCourse() {
		Reporter.log("*****Manage course method started*****", true);
		By manage = By.xpath("//span[text()='Manage']");
		Utility.elementMove(driver, manage);
		By manage_course = By.xpath("//span[contains(text(),'Manage Courses')]");
		Utility.clickElement(driver, manage_course);
		String actual_url = driver.getCurrentUrl();
		String expcted_msg = "manage";
		Assert.assertEquals(actual_url.contains(expcted_msg), true);
		Reporter.log("*****Manage course method stopped*****", true);
	}

	@Test(priority = 2, dependsOnMethods = "clickManageCourse")
	public void clickAddNewCourse() {
		Reporter.log("*****Add new course method started*****", true);
		By addnewcouse_button = By.xpath("//*[contains(text(),'Add New')]");
		Utility.clickElement(driver, addnewcouse_button);
		String actual_url = driver.getCurrentUrl();
		String expcted_msg = "manage";
		Assert.assertEquals(actual_url.contains(expcted_msg), true);
		Reporter.log("*****Add new course method stopped*****", true);
	}

	@Test(priority = 4, dependsOnMethods = "clickAddNewCourse")
	public void addNewCourseForm() throws InterruptedException {
		Reporter.log("*****Add new course Form method started*****", true);
		driver.findElement(By.xpath("//input[@id='thumbnail']"))
				.sendKeys("C:\\Users\\sksunthayaalan\\Desktop\\cypress.png");
		driver.findElement(By.id("name")).sendKeys("Cypress");
		driver.findElement(By.id("description")).sendKeys("Cypress");
		driver.findElement(By.id("instructorNameId")).sendKeys("Priya");
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("2000");
		By startdate = By.xpath("//input[contains(@name,'startDate')]");
		Utility.clickElement(driver, startdate);

		String month = "April";
		String year = "2023";
		By currentdate = By.xpath("//*[@aria-selected='true']");
		Utility.clickElement(driver, currentdate);
		By endson = By.xpath("//input[contains(@name,'endDate')]");
		Utility.clickElement(driver, endson);

		while (true) {
			String monthyear = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"))
					.getText();
			String a[] = monthyear.split(" ");
			String mon = a[0];
			String yr = a[1];
			if (mon.equals(month) && yr.equals(year)) {
				By course_startdate = By.xpath("//div[contains(@class,'day--009')]");
				Utility.clickElement(driver, course_startdate);
				break;

			} else {
				By nextmontharrow = By.xpath("//button[@aria-label='Next Month']");
				Utility.clickElement(driver, nextmontharrow);
			}
		}
		By course_category_dropdown = By.xpath("//div[text()='Select Category']");
		Utility.clickElement(driver, course_category_dropdown);
		By select_category = By.xpath("//button[text()='Testing']");
		Utility.clickElement(driver, select_category);
		By save_button = By.xpath("//button[text()='Save']");
		Utility.clickElement(driver, save_button);
		List<WebElement> v = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		Thread.sleep(2000);
		System.out.println(v.size());
		Reporter.log("*****Add new course Form method stopped*****", true);
	}

	@Test(priority = 5, dependsOnMethods = "addNewCourseForm")
	public void verifyCourse() {
		Reporter.log("*****Verify new course method started*****", true);
		List<WebElement> v = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		// Utility.waitForElement(v, "Cypress");
		System.out.println(v.size());
		for (WebElement e : v) {
			String chck = e.getText();
			System.out.println(chck);
			if (chck.contains("Cypress")) {
				By del = By.xpath("//tbody/tr/td[text()='Cypress']/following-sibling::td/button[text()='Delete']");
				Utility.clickElement(driver, del);
				System.out.println("Deleted the given course");
			} else {
				System.out.println("Not Present");
			}
		}
		Reporter.log("*****Verify new course method stopped*****", true);
	}

	@Test(priority = 6, dependsOnMethods = "verifyCourse")
	public void verifyCourseDeleted() throws InterruptedException {
		Reporter.log("*****Verify course delted method started*****", true);
		// VERIFY COURSE IS DELETED
		Thread.sleep(2000);
		List<WebElement> v1 = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		System.out.println(v1.size());
		for (WebElement e : v1) {
			String chck = e.getText();
			if (chck.contains("Cypress")) {
				System.out.println("Present - Not deleted");
			} else {
				System.out.println("Not Present - Deleted");
			}
		}
		Reporter.log("*****Verify course delted method stopped*****", true);
	}

	@Test(priority = 7, dependsOnMethods = "verifyCourseDeleted")
	public void signOut() {
		Reporter.log("*****Sign out method started*****", true);
		By signout = By.xpath("//button[normalize-space()='Sign out']");
		Utility.clickElement(driver, signout);
		Reporter.log("*****Sign out method stopped*****", true);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
