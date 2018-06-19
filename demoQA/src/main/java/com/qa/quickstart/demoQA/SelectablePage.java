package com.qa.quickstart.demoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectablePage {

	@FindBy(xpath = "//*[@id=\"selectable\"]/li[1]")
	WebElement row1;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[3]")
	WebElement row3;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[6]")
	WebElement row6;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[7]")
	WebElement row7;
	
}
