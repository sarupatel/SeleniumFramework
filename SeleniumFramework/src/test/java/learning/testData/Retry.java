package learning.testData;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int count=0;
	int maxTry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry) {
			count++;
			return true; //for Listener to retry failed test case, it should return true.
		}
		return false;
	}

}
