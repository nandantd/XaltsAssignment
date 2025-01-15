package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import GenericLibrary.Baseclass;
import POM.Signup;

public class TC_001_VerifyUserIsAbleToSignUpThePage extends Baseclass  {

	@Test(retryAnalyzer = GenericLibrary.retryAnalyzer.class)
	public void signUptopage() throws IOException, InterruptedException {

		Signup signup = new Signup(driver);

		signup.SignUpthePage();
		

	}

}
