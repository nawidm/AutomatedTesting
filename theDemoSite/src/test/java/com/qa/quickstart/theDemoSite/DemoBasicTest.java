package com.qa.quickstart.theDemoSite;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoBasicTest {

	ChromeDriver driver;
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
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		driver.navigate().to(url);
		
	    driver.findElement(By.linkText("3. Add a User")).click();
	    driver.findElement(By.xpath("//form/div/center/table/tbody/tr/td/div/center/table")).click();
	    driver.findElement(By.name("username")).sendKeys("Nawid");
	    driver.findElement(By.name("password")).sendKeys("somethin");
	    driver.findElement(By.name("FormsButton2")).click();
	    driver.findElement(By.linkText("4. Login")).click();
	    driver.findElement(By.name("username")).sendKeys("Nawid");
	    driver.findElement(By.name("password")).sendKeys("somethin");
	    driver.findElement(By.name("FormsButton2")).click();
	    driver.findElement(By.xpath("//center/b")).click();
	    assertTrue(driver.findElement(By.xpath("//center/b")).getText().matches("^[\\s\\S]*[\\s\\S]*Successful Login[\\s\\S]*[\\s\\S]*$"));
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}

