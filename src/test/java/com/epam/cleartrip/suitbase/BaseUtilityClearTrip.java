/**
 * 
 */
package com.epam.cleartrip.suitbase;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.epam.cleartrip.utility.JsonDataReader;

public class BaseUtilityClearTrip {
    
	protected static WebDriver driver = null;
	public Actions act = null;
	public static JsonDataReader jsonreader = null;
	
	@BeforeSuite
	public static void loadJsonData() throws IOException {		
		 new JsonDataReader().loadDatafromjson();		
	}

	@Parameters({ "browserType" })
	@BeforeTest
	public void selectBrowser(String browserType) {		
		switch (browserType) {
		
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.cleartrip.com/");
			act = new Actions(driver);
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\E\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.cleartrip.com/");
			act = new Actions(driver);
			break;

		case "ie":
			System.setProperty("webdriver.chrome.driver", "D:\\E\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.cleartrip.com/");
			act = new Actions(driver);
			break;

		}
	}

	@AfterSuite
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();

	}

	public WebDriver getDriver() {
		return driver;
	}
	
	/*public void selectAdultcountFJ(String count, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(count);
	}*/
	
	/*public void scrollToElement() {
		JavascriptExecutor javascriptobj = (JavascriptExecutor)driver;
		javascriptobj.executeScript("scroll(0, 1000);");
	}*/
	
	/*public void waitFor(long time) {	
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/

	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
   
	/*public void checkBoxCheck(WebElement element) {
		element.clear();
		element.click();
	}*/
}
