package com.listeners;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class Reporter implements IReporter{

	Logger logger = Logger.getLogger(Reporter.class);
	int a;
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for (ISuite iSuite : suites) {
			
			Map<String, ISuiteResult> map = iSuite.getResults();
			
			for(ISuiteResult rs : map.values())
			{
				ITestContext tc = rs.getTestContext();
				logger.info("Total Test Cases Executed :"+tc.getAllTestMethods().length);
				logger.info("Total Passed Test Cases :"+tc.getPassedTests().size());
				logger.info("Total Failed Test Cases :"+tc.getFailedTests().size());
				logger.info("Total Skipped Test Case :"+tc.getSkippedTests().size());
				a = tc.getAllTestMethods().length;
				a++;
			}
			
		}
		
		logger.info("Total Tests Executed are :"+a);
		
	}

}
