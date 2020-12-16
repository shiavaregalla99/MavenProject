package com.xyz.OrangeHrmApplication.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.OrangeHrmApplication.BaseClass.BaseClass;

public class LoginPage {

	
	@FindBy(id="txtUsername")
	public WebElement userName;
	@FindBy(id="txtPassword")
	public WebElement password;
	@FindBy(id="btnLogin")
	public WebElement LoginButton;
	@FindBy(xpath="//span[@id='spanMessage']")
	public WebElement errorMessage;
	
	
	public LoginPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
