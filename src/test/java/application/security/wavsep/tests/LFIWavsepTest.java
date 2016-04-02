package application.security.wavsep.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import application.security.wavsep.tests.util.BrowserUtil;
import application.security.wavsep.tests.util.Url;

public class LFIWavsepTest {

	// All Local File Inclusion tests (68)
	@Test
	public void lfiWavsepTest() throws InterruptedException {

		// Initialize WebDriver
		WebDriver driver = new FirefoxDriver();
		
		// Starting pages of the test
		List<Url> urlList = new ArrayList<Url>();

		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-GET-500Error/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-GET-404Error/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-GET-200Error/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-GET-302Redirect/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-GET-200Valid/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-GET-200Identical/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-POST-500Error/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-POST-404Error/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-POST-200Error/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-POST-302Redirect/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-POST-200Valid/index.jsp", 69));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/LFI/LFI-Detection-Evaluation-POST-200Identical/index.jsp", 69));

		
		for(Url url : urlList){
			
			driver.get(url.getUrl());
			BrowserUtil.clickAllLinks(driver, url.getCount(),12);
			
		}

		driver.quit();

		return;

	}
	
}
