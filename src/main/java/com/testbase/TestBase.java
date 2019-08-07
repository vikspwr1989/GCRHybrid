package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	static public Logger logger = Logger.getLogger(TestBase.class);
	static public FileInputStream stream;
	static public Properties properties;
	static public WebDriver driver;
	
	public TestBase() {
		
		try {
			stream = new FileInputStream("src/test/resources/or.properties");
			properties = new Properties();
			properties.load(stream);
		} catch (FileNotFoundException e) {
			logger.error("Properties File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Properties File Not Loaded");
			e.printStackTrace();
		}
		
	}
	
	public static void init()
	{
		if(properties.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(properties.getProperty("browserName").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(properties.getProperty("browserName").equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
			logger.info("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		
	}

}
