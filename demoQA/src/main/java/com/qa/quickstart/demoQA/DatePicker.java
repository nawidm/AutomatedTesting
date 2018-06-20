package com.qa.quickstart.demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePicker {

	@FindBy(name = "selected_date")
	WebElement dateInTextBox;
	
	//@FindBy(className ="  ui-datepicker-current-day")
	WebElement selectedDate;
	
	@FindBy(className = " ui-datepicker-days-cell-over  ui-datepicker-today")
	WebElement todaysDate;
	
	@FindBy(className = "ui-datepicker-prev")
	WebElement prevButton;
	
	@FindBy(className = "ui-datepicker-next")
	WebElement nextButton;
	
	public void clickBox() {
		dateInTextBox.click();
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickPrevMonth() {
		prevButton.click();
	}
	
	public void clickNextMonth() {
		nextButton.click();
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getDateTxt() {
		return dateInTextBox.getText();
	}
	
	public String getYear() {
		return selectedDate.getAttribute("data-year");
	}
	
	public String getMonth() {
		return selectedDate.getAttribute("data-month");
	}
	
	public String getDay() {
		return selectedDate.getText();
	}
	
	public void selectDate(String day, WebDriver driver) {
		selectedDate = driver.findElement(By.linkText(day));
		selectedDate.click();
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
