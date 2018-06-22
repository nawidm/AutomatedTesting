package com.qa.quickstart.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddEmployeePage {
	
	@FindBy(id = "firstName")
	WebElement firstNameBox;
	
	@FindBy(id = "middleName")
	WebElement middleNameBox;
	
	@FindBy(id = "lastName")
	WebElement lastNameBox;
	
	@FindBy(id = "employeeId")
	WebElement employeeIdBox;
	
	@FindBy(id = "photofile")
	WebElement photoBtn;
	
	@FindBy(id = "chkLogin")
	WebElement checkBox;
	
	@FindBy(id = "btnSave")
	WebElement saveBtn;
	
	@FindBy(id = "user_name")
	WebElement userNameBox;
	
	@FindBy(id = "user_password")
	WebElement pass1Box;
	
	@FindBy(id = "re_password")
	WebElement pass2Box;
	
	@FindBy(id = "status")
	WebElement statusBox;
	
	public void setFirstName(String s) {
		firstNameBox.sendKeys(s);
	}
	
	public void setMiddleName(String s) {
		middleNameBox.sendKeys(s);
	}
	
	public void setLastName(String s) {
		lastNameBox.sendKeys(s);
	}
	
	public void setEmployeeId(String s) {
		employeeIdBox.sendKeys(s);
	}
	
	public void clickCheckBox() {
		checkBox.click();
		
	}
	
	public void clickSave() {
		saveBtn.click();
	}
	
	public void setUserName(String u) {
		if(userNameBox.isDisplayed()) {
			userNameBox.sendKeys(u);
		}
	}
	
	public void setPassword(String p) {
		if(pass1Box.isDisplayed()) {
			pass1Box.sendKeys(p);
		}
	}
	
	public void setPasswordConfirm(String p) {
		if(pass2Box.isDisplayed()) {
			pass2Box.sendKeys(p);
		}
	}
	
	public void changeStatus(WebDriver driver) {
		if(statusBox.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(statusBox).click().perform();
			if(statusBox.getAttribute("value").matches("Enabled")) {
				action.moveToElement(driver.findElement(By.xpath("//*[@id=\"status\"]/option[2]"))).click().perform();
			} else if(statusBox.getAttribute("value").matches("Disabled")) {
				action.moveToElement(driver.findElement(By.xpath("//*[@id=\"status\"]/option[1]"))).click().perform();
			}
		}
	}
}
