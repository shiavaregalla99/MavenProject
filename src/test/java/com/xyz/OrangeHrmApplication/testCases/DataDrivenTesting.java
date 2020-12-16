package com.xyz.OrangeHrmApplication.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xyz.OrangeHrmApplication.BaseClass.BaseClass;
import com.xyz.OrangeHrmApplication.pages.LoginPage;
import com.xyz.OrangeHrmApplication.utils.ConfigReader;
import com.xyz.OrangeHrmApplication.utils.ExcelReader;

public class DataDrivenTesting {

	@Test(dataProvider="DataFromExcel")
	public void dataDrivenTest(String Username,String Password,String ErrorMessage) throws InterruptedException {
		BaseClass.setUp();
		LoginPage lp= new LoginPage();
		
		lp.userName.sendKeys(Username);
		lp.password.sendKeys(Password);
		lp.LoginButton.click();
		String actualText=   lp.errorMessage.getText();
		Assert.assertEquals(actualText, ErrorMessage);
		Thread.sleep(5000);
		BaseClass.tearDown();
	}
	@DataProvider(name="DataFromExcel")
	public Object[][] getData(){
		return ExcelReader.excelToArray("C:\\Users\\Pranitha Regalla\\Desktop\\TestData1.xlsx", "Sheet4");
		
	}
}
