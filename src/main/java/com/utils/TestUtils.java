package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.testbase.TestBase;

public class TestUtils extends TestBase{
	
	static public int PAGE_LOAD_TIME_OUT = 30;
	static public int IMPLICIT_WAIT = 45;
	static public int EXPLICIT_WAIT = 45;
	static File src;
	static File dest;
	
	public static String getScreenShot(String ssName)
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		try {
			src = screenshot.getScreenshotAs(OutputType.FILE);
			dest = new File("src/test/resources/SS/"+ssName+".png");
			
			FileUtils.copyFile(src,dest );
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dest.getAbsolutePath();
	}
	

}
