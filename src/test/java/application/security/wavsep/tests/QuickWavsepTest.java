package application.security.wavsep.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.security.wavsep.tests.util.BrowserUtil;
import application.security.wavsep.tests.util.Url;

public class QuickWavsepTest {

	// A simple test case which opens a list of URLs and clicks the first link
	// Covers each major vulnerability category in 
	@Test
	public void quickWivetTest() {

		// Initialize WebDriver
		WebDriver driver = new FirefoxDriver();
		
		// Starting pages of the test
		List<Url> urlList = new ArrayList<Url>();

		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-GET/index.jsp", 33));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-500Error/index.jsp", 20));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-GET-500Error/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-GET-500Error/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Unvalidated-Redirect/Redirect-Detection-Evaluation-GET-302Redirect/index.jsp", 16));
		
		for(Url url : urlList){
			
			driver.get(url.getUrl());
			
			System.out.println("Get URL: " + url.toString());
			
			// First link on the page: Case01-Tag2HtmlPageScope.jsp
			
			String xpathLink = "/html/body/b[13]/a";
			
			if(url.toString().contains("RXSS-Detection-Evaluation")||url.toString().contains("SInjection-Detection-Evaluation")){
				xpathLink = "/html/body/b[1]/a";
			}

			// Wait for page load, click link
			new WebDriverWait(driver, 60).until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(xpathLink)));
			driver.findElement(By.xpath(xpathLink)).click();
			
		}


		driver.quit();

		return;

	}
}
