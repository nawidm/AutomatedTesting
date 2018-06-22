package com.qa.quickstart.DDT;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class LoginDDT {

	ChromeDriver driver;
	static ExtentReports extent;
	@BeforeClass
	public static void initialise() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\AutomatedTesting\\DDT\\extent.html", true);
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/index.php";
		driver.navigate().to(url);
	}
	
	@Test
	public void testLoginWithFileInput() {
		
	//	driver.navigate().to(Constant.URL1);

		FileInputStream file = null;
			try {
				
				file = new FileInputStream (Constant.Path_TestData + Constant.File_TestData);
			} catch (FileNotFoundException e) {}
			
			
		
			XSSFWorkbook workbook = null;
			try {
				
				workbook = new XSSFWorkbook(file);
				System.out.println("test");
			} catch (IOException e) {}
			XSSFSheet sheet = workbook.getSheetAt(0);
			System.out.println("test");
			System.out.println(sheet.getLastRowNum());
			
			FileOutputStream file2 = null;
			try {
				file2 = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
				workbook.write(file2);
			} catch (IOException e) {}
			XSSFSheet sheetResults = workbook.createSheet();
			
			for(int i=1; i<=sheet.getLastRowNum(); i++ ) {
				workbook.setActiveSheet(0);
				driver.navigate().to(Constant.URL1);
				XSSFCell inputUsername = sheet.getRow(i).getCell(0);
				XSSFCell inputPassword = sheet.getRow(i).getCell(1);
				
				XSSFCell output = sheetResults.createRow(i).createCell(0);
				
				WebElement username = driver.findElement(By.name("username"));
				WebElement password = driver.findElement(By.name("password"));
				
				username.sendKeys(inputUsername.getStringCellValue());
				password.sendKeys(inputPassword.getStringCellValue());
				driver.findElement(By.name("FormsButton2")).click();
			
				driver.navigate().to(Constant.URL2);
				
				WebElement username2 = driver.findElement(By.name("username"));
				WebElement password2 = driver.findElement(By.name("password"));
				
				username2.sendKeys(inputUsername.getStringCellValue());
				password2.sendKeys(inputPassword.getStringCellValue());	
				driver.findElement(By.name("FormsButton2")).click();
				System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
				try {
					assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText(),"**Successful Login**");
				} catch (AssertionError e) {}
				finally {
					workbook.setActiveSheet(1);
					output.setCellValue(driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
					
				}
				
				try {
					workbook.write(file2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	}

	@After
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
}
