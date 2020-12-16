package com.xyz.OrangeHrmApplication.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.xyz.OrangeHrmApplication.BaseClass.BaseClass;

public class CommonMethods {
	
	public static void takeScreenShot(String screenshotName) {
		File screenshotFile =      ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
	
		try {
			FileUtils.copyFile(screenshotFile, new File(".\\src\\test\\resources\\ScreenShot\\"+screenshotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
