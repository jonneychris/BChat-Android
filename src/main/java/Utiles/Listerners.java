package Utiles;



import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utiles.ActionsClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class Listerners extends baseClass  implements ITestListener  {

		
	
	AppiumDriver driver;
	ExtentTest test;
	
	ExtentReports extent = ExtentReport.report();
	//ExtentReports extent = new ExtentReports();
	@Override
	public void onTestStart(ITestResult result) {
		//extent.createTest(result.getMethod().getMethodName());

	test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
				try {
					driver=(AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				test.addScreenCaptureFromPath(ActionsClass.getScreenshotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		driver.manage().logs().get("crashlogs");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
