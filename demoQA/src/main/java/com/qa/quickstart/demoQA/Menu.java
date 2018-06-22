package com.qa.quickstart.demoQA;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Menu {
	
	@FindBy(className = "ui-corner-left")
	List<WebElement> buttons;
	
	WebElement currentHighlighted;
	WebElement newTarget;
	
	public void getCurrentHighlighted(WebDriver driver) {
		for(WebElement e : buttons) {
			if(e.getCssValue("background-color").matches("rgba(255, 153, 0, 1)")) {
				System.out.println("test");
				currentHighlighted = e;
			}
		}
	}
	
	public String getInitialHighlightedColourNow() {
		return currentHighlighted.getCssValue("background-color");
	}
	
	public String getNewTargetsColor() {
		return newTarget.getCssValue("background-color");
	}
	
	public void moveToNewTarget(String target, WebDriver driver) {
		for(WebElement e : buttons) {
			if(e.getText().matches(target)) {
				newTarget = e;
				Actions action = new Actions(driver);
				action.moveToElement(newTarget).perform();
				System.out.println(newTarget.getCssValue("background-color"));
				try {
					Thread.sleep(1000);
				} catch(InterruptedException d) {
					d.printStackTrace();
				}
			}
		}
	}
}
