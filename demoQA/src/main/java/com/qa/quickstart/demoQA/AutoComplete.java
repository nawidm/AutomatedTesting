package com.qa.quickstart.demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AutoComplete {
	
	@FindBy(id = "tagss")
	WebElement searchBox;
	
	@FindBy(id = "ui-id-7")
	WebElement firstResult;
	
	public void enterValue(String s) {
		searchBox.sendKeys(s);
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectFirstValue(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(firstResult).click().perform();
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
