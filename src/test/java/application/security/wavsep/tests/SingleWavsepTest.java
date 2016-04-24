package application.security.wavsep.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleWavsepTest {
	
	String testURL = "http://wavsep.test:8080/wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-GET/index.jsp";
	
	// A simple test case which opens a URL and clicks the first link
	@Test
	public void singleWivetTest() {
		
		// Initialize WebDriver
		HtmlUnitDriver driver = new HtmlUnitDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		
		driver.get(testURL);

		// First link on the page: Case01-Tag2HtmlPageScope.jsp
		String xpathLink = "/html/body/b[1]/a";

		// Wait for page load, click link
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(xpathLink)));
		driver.findElement(By.xpath(xpathLink)).click();

		driver.quit();

		return;

	}
}
