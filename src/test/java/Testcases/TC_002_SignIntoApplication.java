package Testcases;

import org.testng.annotations.Test;

import GenericLibrary.Baseclass;
import POM.SignIn;

public class TC_002_SignIntoApplication extends Baseclass {
	
	
	@Test(retryAnalyzer = GenericLibrary.retryAnalyzer.class)
	public void SignInToApplication() throws InterruptedException {
		
		SignIn signin=new SignIn(driver);
		
		signin.SignInApplication();
	}

}
