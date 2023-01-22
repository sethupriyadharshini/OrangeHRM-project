
package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getCurrentTime() {
		String date = new SimpleDateFormat("HH-MM-SS_DD_MMM_YYYY").format(new Date());
		return date;
	}

	public static void captureScreenShotForWebelement(WebElement element) {
		try {
			FileHandler.copy(element.getScreenshotAs(OutputType.FILE),
					new File("./screenshots/Snapshots_" + getCurrentTime() + ".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void waitForElement(List<WebElement> findElement, String search_txt) {
		try {
			for (int i = 0; i <= 15; i++) {
				for (WebElement e : findElement) {
					if (e.getText().contains(search_txt)) {
						System.out.println("Element found");
						break;
					} else {
						System.out.println("Wait for WebDriver element to found");
						// System.out.println(e.getText());
						waitForSeconds(1);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
