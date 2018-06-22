package com.qa.quickstart.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewEmployeePage {
	@FindBy(xpath = "//*[@id=\"pdMainContainer\"]/div[1]/h1")
	WebElement header;
	
	@FindBy(id = "personal_txtEmpFirstName")
	WebElement firstName;
	
	@FindBy(id = "personal_txtEmpLastName")
	WebElement lastName;
	
	
	@FindBy(id = "personal_txtEmployeeId")
	WebElement EmployeeId;
	
	public String getHeaderValue() {
		return header.getText();
	}
	
	public String getFirstName() {
		return firstName.getAttribute("value");
	}
	
	public String getLastName() {
		return lastName.getAttribute("value");
	}
	
	public String getEmployeeId() {
		return EmployeeId.getAttribute("value");
	}
}
