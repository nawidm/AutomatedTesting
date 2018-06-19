package com.qa.quickstart.demoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage {
	@FindBy(id = "draggableview")
	WebElement elementToPickUp;
	
	@FindBy(id = "droppableview")
	WebElement elementToDropOn;
}
