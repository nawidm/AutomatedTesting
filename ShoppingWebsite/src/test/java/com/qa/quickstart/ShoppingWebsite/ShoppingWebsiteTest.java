package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class ShoppingWebsiteTest {

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
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);
	    driver.findElement(By.id("search_query_top")).click();
	    driver.findElement(By.id("search_query_top")).clear();
	    driver.findElement(By.id("search_query_top")).sendKeys("dress");
	    driver.findElement(By.name("submit_search")).click();
	    assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[6]/div/div[2]/h5/a")).getText().matches("Faded Short Sleeve T-shirts"));

	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
