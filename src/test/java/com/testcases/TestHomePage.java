package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.utils.TestUtils;

public class TestHomePage extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	By username = By.name("username");
	
	
	public TestHomePage() {
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		init();
		logger.info(properties.getProperty("browserName")+" Started");
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.loginAdmin(properties.getProperty("username"),properties.getProperty("password"));
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		logger.info(properties.getProperty("browserName")+" Closed");
	}
	
	@Test(priority=1)
	public void verifyLogOff()
	{
		homePage.logOff();
		if(driver.findElement(username).isDisplayed())
		{
			logger.info("Log Off Verified");
			ReportGenerator.stepDetails("PASS", "Log Off Verification", "Expected : Log Off Should Verified <br /> Actual : Log Off was Verified", TestUtils.getScreenShot("Logoff"));
		}
		else
		{
			logger.error("Log Off Not Verified");
			ReportGenerator.stepDetails("FAIL", "Log Off Verification", "Expected : Log Off Should Verified <br /> Actual : Log Off was not Verified", TestUtils.getScreenShot("Logoff"));
		}
		
	}

}
