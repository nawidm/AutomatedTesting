package com.qa.quickstart.demoQA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demoQATest {

	ChromeDriver driver;
	@BeforeClass
	public static void initialise() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://demoqa.com/";
		driver.navigate().to(url);
	}
	
	@Test
	public void testDroppable() {

		driver.findElement(By.linkText("Droppable")).click();
		WebElement From=driver.findElement(By.id("draggableview"));
		WebElement To=driver.findElement(By.id("droppableview"));
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
	    assertTrue(driver.findElement(By.id("droppableview")).getText().matches("Dropped!"));
	}
	
	
	@After
	public void tearDown() {
		driver.close();
	}
}
