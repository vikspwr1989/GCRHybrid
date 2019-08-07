package com.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.utils.TestUtils;

public class TestLoginPage extends TestBase{
	
	Logger logger = Logger.getLogger(TestLoginPage.class);
	LoginPage loginPage;
	By logoffLink = By.xpath("//a[text()='Logoff']");
	
	public TestLoginPage() {
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		init();
		logger.info(properties.getProperty("browserName")+" Started");
		loginPage = new LoginPage();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		logger.info(properties.getProperty("browserName")+" Closed");
	}
	
	@Test(priority=1)
	public void verifyGetTitle()
	{
		Assert.assertEquals(loginPage.getTitle(), "GCR Shop" ,"Login Page Title Not Verified");
		logger.info("Login Page Title Verified");
		ReportGenerator.stepDetails("PASS", "Verify Title", "Expected Title should be GCR Shop: <br /> Actual Title was "+loginPage.getTitle()+"",TestUtils.getScreenShot("Title"));
	}
	
	@Test(priority=2)
	public void verifyLoginAdmin()
	{
		
		loginPage.loginAdmin(properties.getProperty("username"), properties.getProperty("password"));
		//Thread.sleep(2000);
		if(driver.findElement(logoffLink).isDisplayed())
		{
			logger.info("Admin Login Verified");
			ReportGenerator.stepDetails("PASS", "Verify Login Admin", "Expected : Login Admin Page Should verified <br /> Actual : Login Admin Page was verified", TestUtils.getScreenShot("AdminLogin"));
		}
		else
		{
			logger.error("Admin Login Not Verified");
			ReportGenerator.stepDetails("FAIL", "Verify Login Admin", "Expected : Login Admin Page Should verified <br /> Actual : Login Admin Page was not verified", TestUtils.getScreenShot("AdminLogin"));
		}
	}

}
