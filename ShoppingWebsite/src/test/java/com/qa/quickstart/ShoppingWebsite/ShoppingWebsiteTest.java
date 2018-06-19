package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ShoppingWebsiteTest {

	ChromeDriver driver;	
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Documents\\AutomatedTesting\\ShoppingWebsite\\extent.html", true);
	ExtentTest test;
	@BeforeClass
	public static void initialise() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();	
	}
	
	@Test
	public void test() {
		test = extent.startTest("Verify application search bar");
		driver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);
		test.log(LogStatus.INFO, "Page Loaded");
	    driver.findElement(By.id("search_query_top")).click();
	    driver.findElement(By.id("search_query_top")).clear();
	    driver.findElement(By.id("search_query_top")).sendKeys("dress");
	    driver.findElement(By.name("submit_search")).click();
	    test.log(LogStatus.INFO, "Results Loaded");
	    try {
	    	assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[6]/div/div[2]/h5/a")).getText().matches("Faded Short Sleeve T-shirts"));
	    	test.log(LogStatus.PASS, "Specific item loaded in results");
	    } catch (AssertionError e) {
	    	test.log(LogStatus.FAIL, "Specific item was not found");
	    	fail();
	    }finally {
			test.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test);
		}

	}
	
	@After
	public void tearDown() {
		extent.flush();
		driver.close();
		
	}

}
