package application.security.wavsep.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import application.security.wavsep.tests.util.BrowserUtil;
import application.security.wavsep.tests.util.Url;

public class RFIWavsepTest {

	// All Remote File Inclusion tests (9)
	@Test
	public void rfiWavsepTest() throws InterruptedException {

		// Initialize WebDriver
		HtmlUnitDriver driver = new HtmlUnitDriver();
		
		// Starting pages of the test
		List<Url> urlList = new ArrayList<Url>();

		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-GET-500Error/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-GET-404Error/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-GET-200Error/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-GET-302Redirect/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-GET-200Valid/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-GET-200Identical/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-POST-500Error/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-POST-404Error/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-POST-200Error/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-POST-302Redirect/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-POST-200Valid/index.jsp", 10));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/RFI/RFI-Detection-Evaluation-POST-200Identical/index.jsp", 10));
		
		for(Url url : urlList){
			
			driver.get(url.getUrl());
			BrowserUtil.clickAllLinks(driver, url.getCount(),12);
			
		}

		driver.quit();

		return;

	}
	
}
