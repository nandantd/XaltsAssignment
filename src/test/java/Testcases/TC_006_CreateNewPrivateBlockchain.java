package Testcases;

import org.testng.annotations.Test;

import GenericLibrary.Baseclass;
import POM.NewPrivateBlockchain;

public class TC_006_CreateNewPrivateBlockchain extends Baseclass {
	
	@Test(retryAnalyzer = GenericLibrary.retryAnalyzer.class)
	
	public void createaNewblockchain() throws InterruptedException {
		
		TC_002_SignIntoApplication signIn=new TC_002_SignIntoApplication();
		signIn.SignInToApplication();
		
		
		NewPrivateBlockchain blockchain=new NewPrivateBlockchain(driver);
		
		blockchain.AddAlltheNodesinPrivateBlockchain(driver);
		
		
	}

}
