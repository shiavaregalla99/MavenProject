package com.xyz.OrangeHrmApplication.testCases;

import org.testng.annotations.Test;

import com.xyz.OrangeHrmApplication.BaseClass.BaseClass;
import com.xyz.OrangeHrmApplication.pages.LoginPage;
import com.xyz.OrangeHrmApplication.utils.CommonMethods;
import com.xyz.OrangeHrmApplication.utils.ConfigReader;

public class testCase_001 {

	
	@Test
	public void test_001() {
		BaseClass.setUp();
		LoginPage lp= new LoginPage();
		lp.userName.sendKeys(ConfigReader.getProperty("UserName"));
		CommonMethods.takeScreenShot("username");
		lp.password.sendKeys(ConfigReader.getProperty("Password"));
		CommonMethods.takeScreenShot("password");
		lp.LoginButton.click();
		CommonMethods.takeScreenShot("loginAction");
		BaseClass.tearDown();
	}
	
	
}
