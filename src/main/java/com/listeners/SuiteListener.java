package com.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.reports.ReportGenerator;

public class SuiteListener implements ISuiteListener{

	public void onStart(ISuite suite) {
		ReportGenerator.testSuiteStart("src/test/resources/Reports/MyReport.html", "Viki");
		
	}

	public void onFinish(ISuite suite) {
		ReportGenerator.testSuiteEnd();
		
	}

}
