package Testcases;

import POM.SignOut;

import org.testng.annotations.Test;

import GenericLibrary.Baseclass;

public class TC_003_SignOut extends Baseclass {

	@Test(retryAnalyzer = GenericLibrary.retryAnalyzer.class)
	public void SignOut() throws InterruptedException {

		TC_002_SignIntoApplication signIn = new TC_002_SignIntoApplication();

		signIn.SignInToApplication();

		SignOut signout = new SignOut(driver);
		signout.SignoutFromthepage();

	}

}
