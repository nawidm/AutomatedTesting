package com.qa.quickstart.demoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage {
	@FindBy(id = "draggableview")
	WebElement elementToPickUp;
	
	@FindBy(id = "droppableview")
	WebElement elementToDropOn;

	public void drag(WebDriver driver) {
		Actions act = new Actions(driver);
		act.dragAndDrop(elementToPickUp, elementToDropOn).build().perform();
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
