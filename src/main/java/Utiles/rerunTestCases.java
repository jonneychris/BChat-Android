package Utiles;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class rerunTestCases implements IRetryAnalyzer {

	private int retrycount=0;
	private static final int maxcount=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retrycount<maxcount) {
			retrycount++;
			return true;
		}
		return false;
	}

}
