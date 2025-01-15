package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.invokers.TestMethodWithDataProviderMethodWorker;

import GenericLibrary.GenericMethods;
import GenericLibrary.TestData;

public class Signup {
	
	@FindBy(xpath="//div[@class='headline']/h1")
	protected WebElement HomeHeadline;
	
	
	@FindBy(xpath="//button[contains(text(),'Get Started')]")
	protected WebElement GetstartedButton;
	
	@FindBy(xpath = "//label[contains(text(),'E-Mail')]/..//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	protected WebElement EmailTextfield;
	
	
	@FindBy(xpath = "//label[text()='Password']/..//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	protected WebElement Password ;
	
	@FindBy(xpath = "//label[text()='Confirm Password']/..//input[contains(@class,\"MuiInputBase-input MuiOutlinedInput-input\")]")
	private WebElement ConfirmPassword ;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	private WebElement SignUpButton;
	
	
	@FindBy(xpath="//div//h2[contains(text(),'Onboard OCN Node')]")
	protected WebElement OnboardOCNNodeTitle;
	
	
	public Signup(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}  


	public void SignUpthePage() throws InterruptedException {
	    GenericMethods generic = new GenericMethods();

	    // Wait for the headline to be visible
	    generic.waitTillelementisVisible(HomeHeadline);

	    // Click on the "Get Started" button
	    generic.waitTillelementisClickable(GetstartedButton);
	    GetstartedButton.click();

	    // Enter a random email
	    EmailTextfield.click();
	    EmailTextfield.sendKeys(generic.GenerateRandomEmail());

	    Password.click();
	    Password.sendKeys(TestData.Password);
	    
	    ConfirmPassword.click();
	    ConfirmPassword.sendKeys(TestData.Password);

	    // Click on the "Sign Up" button
	    generic.waitTillelementisClickable(SignUpButton);
	    SignUpButton.click();

	    generic.waitTillelementisClickable(GetstartedButton);
	    GetstartedButton.click();
	    
	    // Wait for the "Onboard OCN Node" title to become visible
	    generic.waitTillelementisVisible(OnboardOCNNodeTitle);
	    

	    // Verify that the Onboard OCN Node title is displayed
	    if (OnboardOCNNodeTitle.isDisplayed()) {
	        System.out.println("Sign-up successful: 'Onboard OCN Node' title is displayed.");
	    } else {
	    	System.out.println("Sign-up failed: 'Onboard OCN Node' title is not displayed.");
	    }
	}

	
	
	
}
