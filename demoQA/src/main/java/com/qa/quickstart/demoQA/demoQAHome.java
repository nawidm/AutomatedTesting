package com.qa.quickstart.demoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class demoQAHome {

	@FindBy(linkText = "Droppable")
	private WebElement droppableButton;
	
	@FindBy(linkText = "Selectable")
	private WebElement selectableButton;
	
	@FindBy(linkText = "Accordion")
	private WebElement accordionButton;
	
	@FindBy(linkText = "Autocomplete")
	private WebElement autoCompleteButton;
	
	@FindBy(linkText = "Datepicker")
	private WebElement datePickerButton;
	
	@FindBy(linkText = "Menu")
	private WebElement menuButton;
	
	@FindBy(linkText = "Slider")
	private WebElement sliderButton;
	
	@FindBy(linkText = "Tabs")
	private WebElement tabsButton;
	
	@FindBy(linkText = "Tooltip")
	private WebElement toolTipButton;
	
	public void clickDroppable() {
		droppableButton.click();
	}
	
	public void clickSelectable() {
		selectableButton.click();
	}
	
	public void clickAccordion() {
		accordionButton.click();
	}
	
	public void clickAutoComplete() {
		autoCompleteButton.click();
	}
	
	public void clickDatePicker() {
		datePickerButton.click();
	}	
	public void clickMenu() {
		menuButton.click();
	}	
	public void clickSlider() {
		sliderButton.click();
	}	
	public void tabs() {
		tabsButton.click();
	}	
	public void toolTip() {
		toolTipButton.click();
	}	

}
