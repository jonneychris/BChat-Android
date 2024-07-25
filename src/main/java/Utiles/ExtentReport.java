package Utiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReport  {

	static ExtentReports  extent;
	
	public static ExtentReports report() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report =new ExtentSparkReporter(path);
		report.config().setReportName("BChat-Android Report");
		report.config().setDocumentTitle("Test results");
		
	    extent = new ExtentReports();

		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Chris");
		return extent;
		//extent.flush();
	}

}
