package com.qa.quickstart.theDemoSite;

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


public class DemoBasicTest {

	ChromeDriver driver;
	static ExtentReports extent;
	
	@BeforeClass
	public static void initialise() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\AutomatedTesting\\theDemoSite\\extent.html", true);
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		driver.navigate().to(url);
	}
	
	@Test
	public void test() {
		
		ExtentTest test = extent.startTest("Verify register and login works");

	    driver.findElement(By.linkText("3. Add a User")).click();
	    test.log(LogStatus.INFO, "Add user page loaded");
	    driver.findElement(By.xpath("//form/div/center/table/tbody/tr/td/div/center/table")).click();
	    fillBoxes("Nawid","mypass");
	    test.log(LogStatus.INFO, "Text boxes filled in");
	    driver.findElement(By.linkText("4. Login")).click();
	    test.log(LogStatus.INFO, "Login page loaded");
	    fillBoxes("Nawid", "mypass");
	    test.log(LogStatus.INFO, "Text boxes filled in");
	    driver.findElement(By.xpath("//center/b")).click();
	    try {
	    	assertTrue(driver.findElement(By.xpath("//center/b")).getText().matches("^[\\s\\S]*[\\s\\S]*Successful Login[\\s\\S]*[\\s\\S]*$"));
	    	test.log(LogStatus.PASS, "Login successful");
	    } catch(AssertionError e) {
	    	test.log(LogStatus.FAIL, "Login was not successful");
	    	fail();
	    } finally {
	    	test.log(LogStatus.INFO, "Current URL: "+ driver.getCurrentUrl());
	    	extent.endTest(test);
	    }
		
	}
	
	private void fillBoxes(String u, String p) {
		driver.findElement(By.name("username")).sendKeys(u);
	    driver.findElement(By.name("password")).sendKeys(p);
	    driver.findElement(By.name("FormsButton2")).click();
	}
	
	@After
	public void tearDown() {
		driver.close();
		extent.flush();
	}

}

