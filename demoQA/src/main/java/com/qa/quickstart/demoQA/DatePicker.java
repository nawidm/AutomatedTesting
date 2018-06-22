package com.qa.quickstart.demoQA;

import java.text.DateFormatSymbols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePicker {

	@FindBy(id = "datepicker1")
	WebElement dateInTextBox;
	
	//@FindBy(className ="  ui-datepicker-current-day")
	WebElement selectedDate;
	
	@FindBy(className = " ui-datepicker-days-cell-over  ui-datepicker-today")
	WebElement todaysDate;
	
	@FindBy(className = "ui-datepicker-prev")
	WebElement prevButton;
	
	@FindBy(className = "ui-datepicker-next")
	WebElement nextButton;
	
	WebElement date;
	
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
		return dateInTextBox.getAttribute("value");
	}
	
	public String getYear() {
		return date.getAttribute("data-year");
	}
	
	public String getMonth() {
		int month = Integer.parseInt(date.getAttribute("data-month"));
		return new DateFormatSymbols().getMonths()[month];
		
	}
	
	public String getDay() {
		System.out.println(selectedDate.getAttribute("innerHTML"));
		return selectedDate.getAttribute("innerHTML");
	}
	
	public void selectDate(String day, WebDriver driver) {
		selectedDate = driver.findElement(By.linkText(day));
		date = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[1]"));
		selectedDate.click();
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}


}
