package application.security.wavsep.tests.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {
	
	private static boolean isRedirectTest = false;
	

	public static void clickAllLinksRedirect(WebDriver driver, int count, int offset) throws InterruptedException{
		
		isRedirectTest = true;
		
		clickAllLinks(driver, count, offset);
		
	}
	
	public static void clickAllLinks(WebDriver driver, int count, int offset) throws InterruptedException{
		
		String origURL = driver.getCurrentUrl();
		
		int i = 1+offset;
		while (i < count+offset) {
			
			// Wait for page load, click link
			String xpathLink = "/html/body/b["+ i +"]/a";
			
			try{
				new WebDriverWait(driver, 1).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(xpathLink)));
				
				driver.findElement(By.xpath(xpathLink)).click();
			} catch (Exception e){
				i++;
				continue;
			}
			
			if(isRedirectTest){
				JavascriptExecutor executor = (JavascriptExecutor)(driver);
				executor.executeScript("window.stop();");
			}
			
			//Handle alerts
			try{		
				Alert alert = driver.switchTo().alert();
				Thread.sleep(2000);
				alert.accept();
			} catch (NoAlertPresentException ex) {
				// Continue
			}

			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			boolean formExists = driver.findElements(By.id("frmInput")).size() != 0;
			
			if(formExists){
				WebElement form = driver.findElement(By.id("frmInput"));
				List<WebElement> allFormChildElements = form.findElements(By.xpath("*"));
				
				for(WebElement item : allFormChildElements )
				{
				    try {
						if(item.getTagName().equals("input")) {
						    switch(item.getAttribute("id")) {
						    default: 
						    	String type = item.getAttribute("type");
						    	if(type == "hidden"){
						    		break;
						    	}
						    	else{
						    		item.sendKeys("myinput");
						    	}
						        			            
						        break;
						    case "target":
						        //Send default values
						        break;
						    }
						}
					} catch (Exception e) {
						continue;
					}
				}
				
				BrowserUtil.submitFormAndHandleAlerts(driver,form);
				
			}
			
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			driver.navigate().to(origURL);
			
			i++;
		}
	}
	
	static void submitFormAndHandleAlerts(WebDriver driver, WebElement form) throws InterruptedException{
		
		form.submit();
		
		//Handle alerts
		try{		
			Alert alert = driver.switchTo().alert();
			Thread.sleep(2000);
			alert.accept();
		} catch (NoAlertPresentException ex) {
			// Continue
		}
		
		driver.navigate().back();
	}

}
