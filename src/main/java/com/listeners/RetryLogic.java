package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{

	int counter=1;
	int max_counter=3;
	
	public boolean retry(ITestResult result) {
		
		if(counter<max_counter)
		{
			counter++;
			return true;
		}
		return false;
	}

}
