package application.security.wavsep.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import application.security.wavsep.tests.util.BrowserUtil;
import application.security.wavsep.tests.util.Url;

public class RedirectWavsepTest {

	// All Open Redirect tests (15)
	@Test
	public void redirectWavsepTest() throws InterruptedException {

		// Initialize WebDriver
		WebDriver driver = new FirefoxDriver();
		
		// Starting pages of the test
		List<Url> urlList = new ArrayList<Url>();

		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Unvalidated-Redirect/Redirect-Detection-Evaluation-GET-302Redirect/index.jsp", 16));
		//urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Unvalidated-Redirect/Redirect-JavaScript-Detection-Evaluation-GET-200Valid/index.jsp", 16));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Unvalidated-Redirect/Redirect-Detection-Evaluation-POST-302Redirect/index.jsp", 16));
		//urlList.add(new Url("http://wavsep.test:8080/wavsep/active/Unvalidated-Redirect/Redirect-JavaScript-Detection-Evaluation-POST-200Valid/index.jsp", 16));

		
		for(Url url : urlList){
			
			driver.get(url.getUrl());
			BrowserUtil.clickAllLinksRedirect(driver, url.getCount(),12);
			
		}

		driver.quit();

		return;

	}
	
}
