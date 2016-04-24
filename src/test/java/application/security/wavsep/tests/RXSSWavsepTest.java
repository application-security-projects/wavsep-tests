
package application.security.wavsep.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import application.security.wavsep.tests.util.BrowserUtil;
import application.security.wavsep.tests.util.Url;

public class RXSSWavsepTest {

	// All RXSS tests (64)
	@Test
	public void rxssWavsepTest() throws InterruptedException {

		// Initialize WebDriver
		HtmlUnitDriver driver = new HtmlUnitDriver();
		
		// Starting pages of the test
		List<Url> urlList = new ArrayList<Url>();

		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-GET/index.jsp", 33));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-POST/index.jsp", 33));
		
		for(Url url : urlList){
			
			driver.get(url.getUrl());
			BrowserUtil.clickAllLinks(driver, url.getCount(),0);
			
		}

		driver.quit();

		return;

	}
	
}
