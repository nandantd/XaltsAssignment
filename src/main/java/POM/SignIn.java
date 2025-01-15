package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLibrary.GenericMethods;
import GenericLibrary.TestData;

public class SignIn extends Signup {
	
	public SignIn(WebDriver driver) {
		super(driver);
	
	}


	@FindBy(xpath="//button[contains(text(),'Already have an account? Click here to sign in')]")
	private WebElement SignLink;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement SignInButton;
	
	
	
	public void SignInApplication() throws InterruptedException {
		
	    GenericMethods generic = new GenericMethods();

	    // Wait for the headline to be visible
	    generic.waitTillelementisVisible(HomeHeadline);

	    // Click on the "Get Started" button
	    generic.waitTillelementisClickable(GetstartedButton);
	    GetstartedButton.click();

	    // Enter a random email
	    EmailTextfield.click();
	    EmailTextfield.sendKeys(TestData.genericEmailid);

	    Password.click();
	    Password.sendKeys(TestData.genericPassword);
	  
	    // Click on the "Sign Up" button
	    generic.waitTillelementisClickable(SignLink);
	    SignLink.click();
	    
	    generic.waitTillelementisClickable(SignInButton);
	    SignInButton.click();
	  
	  
	    generic.waitTillelementisClickable(GetstartedButton);
	    GetstartedButton.click();
	    
	    // Wait for the "Onboard OCN Node" title to become visible
	    generic.waitTillelementisVisible(OnboardOCNNodeTitle);

	    // Verify that the Onboard OCN Node title is displayed
	    if (OnboardOCNNodeTitle.isDisplayed()) {
	        System.out.println("Sign-IN successful: 'Onboard OCN Node' title is displayed.");
	    } else {
	    	System.out.println("Sign-IN failed: 'Onboard OCN Node' title is not displayed.");
	    }
	    
	    
	    
	    
	}
	
	
	

}
