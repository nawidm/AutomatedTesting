package com.qa.quickstart.Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class assessmentSteps {
	
	WebDriver driver;
	static ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\AutomatedTesting\\Assessment\\chromedriver.exe");
		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\AutomatedTesting\\Assessment\\extent.html", true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		driver.navigate().to(url);
		test = extent.startTest("Testing Adding Employee");	
	}
	
	@Given("^the Add Employee Tab$")
	public void loadAddEmployeeTab() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.setUserAndPassValue("Admin", "admin");
		loginPage.clickLogin();
		test.log(LogStatus.INFO, "Logged in");
		DashboardPage dashPage = PageFactory.initElements(driver, DashboardPage.class);
		dashPage.navToAddEmployee(driver);
		test.log(LogStatus.INFO, "Navigated to Add employee");

	}
	
	
	@When("^I fill out the Employee Details correctly$")
	public void fillEmployeeDetails() {
		AddEmployeePage addEmpPage = PageFactory.initElements(driver, AddEmployeePage.class);
		addEmpPage.setFirstName("Nawid");
		addEmpPage.setLastName("Mujadidi");
		test.log(LogStatus.INFO, "Employee details filled");

	}
	
	@And("^I choose to create Login Details$")
	public void createLoginDetail() {
		AddEmployeePage addEmpPage = PageFactory.initElements(driver, AddEmployeePage.class);
		addEmpPage.clickCheckBox();
		test.log(LogStatus.INFO, "Chosen to create Login account");

	}
	
	@And("^I fill out the Login Details correctly$")
	public void fillLoginDetails() {
		AddEmployeePage addEmpPage = PageFactory.initElements(driver, AddEmployeePage.class);
		addEmpPage.setUserName("nawidmm");
		addEmpPage.setPassword("newpass");
		addEmpPage.setPasswordConfirm("newpass");
	}

	@And("^I click the Save button$")
	public void saveNewLogin() {
		AddEmployeePage addEmpPage = PageFactory.initElements(driver, AddEmployeePage.class);
		addEmpPage.clickSave();
	}

	
	@Then("^I can see information about the user$")
	public void checkDetailsAreShown() {
		ViewEmployeePage viewEmpPage = PageFactory.initElements(driver, ViewEmployeePage.class);
		try {
			assertEquals(viewEmpPage.getHeaderValue(), "Personal Details");
			test.log(LogStatus.PASS, "Header is personal details");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Header is not personal details");
		}
		try {
			assertEquals(viewEmpPage.getFirstName()+" "+viewEmpPage.getLastName(), "Nawid Mujadidi");
			test.log(LogStatus.PASS, "Name matches");
		} catch (AssertionError e) {
			
		}
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
		extent.endTest(test);
	}
}
