package com.qa.quickstart.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	@FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/b")
	WebElement PIMbtn;
	
	public void moveToPIM(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(PIMbtn).perform();;
	}
	
	public void ClickAddEmployee(WebDriver driver) {
		driver.findElement(By.id("menu_pim_addEmployee")).click();
	}
	
	public void navToAddEmployee(WebDriver driver) {
		moveToPIM(driver);
		ClickAddEmployee(driver);
	}
}
