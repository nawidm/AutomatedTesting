package com.qa.quickstart.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(id = "txtUsername")
	WebElement usernameBox;
	
	@FindBy(id = "txtPassword")
	WebElement passwordBox;	
	
	@FindBy(id = "btnLogin")
	WebElement loginBtn;
	
	public void setUserValue(String s) {
		usernameBox.sendKeys(s);
	}
	
	public void setPassValue(String s) {
		passwordBox.sendKeys(s);
	}
	
	public void setUserAndPassValue(String u, String p) {
		setUserValue(u);
		setPassValue(p);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
}
