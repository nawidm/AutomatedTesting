package com.qa.quickstart.demoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accordion {

	@FindBy(xpath = "//*[@id=\"ui-id-4\"]")
	WebElement section1;
	
	@FindBy(xpath = "//*[@id=\"ui-id-6\"]")
	WebElement section2;
	
	public void clickSection2() {
		section2.click();
	}
}
