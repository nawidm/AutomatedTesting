package com.qa.quickstart.demoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class demoQAHome {

	@FindBy(linkText = "Droppable")
	WebElement droppableButton;
	
	@FindBy(linkText = "Selectable")
	WebElement selectableButton;
	
	@FindBy(linkText = "Accordion")
	WebElement accordionButton;
	
	@FindBy(linkText = "Autocomplete")
	WebElement autoCompleteButton;
	
	@FindBy(linkText = "Datepicker")
	WebElement datePickerButton;
	
	@FindBy(linkText = "Menu")
	WebElement menuButton;
	
	@FindBy(linkText = "Slider")
	WebElement sliderButton;
	
	@FindBy(linkText = "Tabs")
	WebElement tabsButton;
	
	@FindBy(linkText = "Tooltip")
	WebElement tooltipButton;
}
