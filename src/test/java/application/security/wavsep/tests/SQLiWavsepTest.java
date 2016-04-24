package application.security.wavsep.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import application.security.wavsep.tests.util.BrowserUtil;
import application.security.wavsep.tests.util.Url;

public class SQLiWavsepTest {

	// All SQL injection tests (136)
	@Test
	public void sqliWavsepTest() throws InterruptedException {

		// Initialize WebDriver
		HtmlUnitDriver driver = new HtmlUnitDriver();
		
		// Starting pages of the test
		List<Url> urlList = new ArrayList<Url>();

		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-500Error/index.jsp", 20));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-200Error/index.jsp", 20));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-200Valid/index.jsp", 20));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-200Identical/index.jsp", 23));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-500Error/index.jsp", 20));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-200Error/index.jsp", 20));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-200Valid/index.jsp", 20));
		urlList.add(new Url("http://wavsep.test:8080/wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-200Identical/index.jsp", 23));
		
		
		for(Url url : urlList){
			
			driver.get(url.getUrl());
			BrowserUtil.clickAllLinks(driver, url.getCount(),0);
			
		}

		driver.quit();

		return;

	}
	
}
