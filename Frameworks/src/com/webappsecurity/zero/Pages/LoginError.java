package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginError {

	
	@FindBy(css="#login_form > div.alert.alert-error")
	private WebElement errMsgBox;
	
	public LoginError(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getErrorMsg() {
		String errMsg = errMsgBox.getText();
		return errMsg;
	}
}
