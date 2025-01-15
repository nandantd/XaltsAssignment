package GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class retryAnalyzer implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {

		int count = 0;
		int maxtry = 1;
		if (count < maxtry) {
			count++;
			return true;
		}

		return false;
	}

}
