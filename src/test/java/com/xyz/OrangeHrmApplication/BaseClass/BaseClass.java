package com.xyz.OrangeHrmApplication.BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.xyz.OrangeHrmApplication.utils.ConfigReader;


public class BaseClass {

	public static WebDriver driver;
	
	//initalize the driver
	//close the driver
	
	public static WebDriver setUp() {
	ConfigReader.readProperties(".\\src\\test\\resources\\Configs\\config.properties");

	 switch(ConfigReader.getProperty("BrowserName")) {
	 case "chrome":
		 System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
		 driver= new ChromeDriver();
		 break;
	 case "firefox":
		 System.setProperty("webdriver.gecko.driver",".\\src\\test\\resources\\Drivers\\geckodriver.exe");
         driver= new InternetExplorerDriver();
         break;
         
	 case "ie":
		 System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\Drivers\\IEDriverServer.exe");
         driver= new InternetExplorerDriver();
         break;
         
         default:
        	 throw new RuntimeException("Browser is not supported");
	 
	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.get(ConfigReader.getProperty("URL"));
	  return driver;
	
}

public static void tearDown() {
	if(driver!=null) {
	driver.quit();
	}
}
}
