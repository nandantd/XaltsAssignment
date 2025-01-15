package Testcases;

import org.testng.annotations.Test;

import GenericLibrary.Baseclass;
import POM.WalletAddresspage;

public class TC_005_AddWalletAddressesAndSubmit extends Baseclass {

	@Test(retryAnalyzer = GenericLibrary.retryAnalyzer.class)
	public void TestWalletAddress() throws InterruptedException {

		TC_004_VerifyUseriaAbleToAddallNodes Addnode = new TC_004_VerifyUseriaAbleToAddallNodes();

		Addnode.AddNodestolist();

		WalletAddresspage walletaddress = new WalletAddresspage(driver);
		walletaddress.addWalletAddresses(driver, 3);
		

	}

}
