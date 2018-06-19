package com.qa.quickstart.demoQA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class demoQATest {

	ChromeDriver driver;
	static ExtentReports extent;
	@BeforeClass
	public static void initialise() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\AutomatedTesting\\demoQA\\extent.html", true);
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://demoqa.com/";
		driver.navigate().to(url);
	}
	
	@Ignore
	@Test
	public void testDroppable() {
		ExtentTest test = extent.startTest("Testing Droppable");
		demoQAHome homePage = PageFactory.initElements(driver, demoQAHome.class);
		DroppablePage droppablePage = PageFactory.initElements(driver, DroppablePage.class);
		
		homePage.droppableButton.click();
		test.log(LogStatus.INFO, "Droppable page loaded");
		WebElement From=droppablePage.elementToPickUp;
		test.log(LogStatus.INFO, "Element to be dragged identified");
		WebElement To=droppablePage.elementToDropOn;
		test.log(LogStatus.INFO, "Element to be dragged to identified");
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
		test.log(LogStatus.INFO, "Element dragged");
		try {
			assertTrue(To.getText().matches("Dropped!"));
			test.log(LogStatus.PASS, "Drag and drop successfully registered");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Drag and drop was not successful");
			fail();
		} finally {
			test.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test);
		}
	}
	
	@Test
	public void testSelectable() {
		ExtentTest test = extent.startTest("Testing multiple Selects");
		demoQAHome homePage = PageFactory.initElements(driver, demoQAHome.class);
		SelectablePage selectablePage = PageFactory.initElements(driver, SelectablePage.class);

		homePage.selectableButton.click();
		test.log(LogStatus.INFO, "Selectable page loaded");
		WebElement From=selectablePage.row1;
		test.log(LogStatus.INFO, "First Element to be selected identified");
		WebElement To=selectablePage.row6;
		test.log(LogStatus.INFO, "Element to be selected to identified");
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
		test.log(LogStatus.INFO, "Mouse Dragged");
		try {
			assertTrue(From.getAttribute("class").matches("ui-widget-content ui-corner-left ui-selectee ui-selected") &&
					   To.getAttribute("class").matches("ui-widget-content ui-corner-left ui-selectee ui-selected") &&
					   selectablePage.row3.getAttribute("class").matches("ui-widget-content ui-corner-left ui-selectee ui-selected") &&
					   !selectablePage.row7.getAttribute("class").matches("ui-widget-content ui-corner-left ui-selectee ui-selected"));
			test.log(LogStatus.PASS, "Multiple elements successfully selected");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Multiple selects were not possible");
			fail();
		} finally {
			test.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test);
		}
		
	}
	
	@Test
	public void testAccordion() {
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		extent.flush();
	}
}
