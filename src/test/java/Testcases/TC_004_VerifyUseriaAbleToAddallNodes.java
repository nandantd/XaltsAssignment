package Testcases;

import org.testng.annotations.Test;

import GenericLibrary.Baseclass;
import POM.Nodespage;

public class TC_004_VerifyUseriaAbleToAddallNodes extends Baseclass {
	
	
	
	@Test(retryAnalyzer = GenericLibrary.retryAnalyzer.class)
	public void AddNodestolist() throws InterruptedException {
	
		TC_002_SignIntoApplication signIn=new TC_002_SignIntoApplication();
		signIn.SignInToApplication();
		Nodespage nodeslist=new Nodespage(driver);
		nodeslist.verifyOnboardpageisdisplayed();
		nodeslist.nodesPageFunctionality(driver, 3);
		
	}

}
