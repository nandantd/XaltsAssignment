package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLibrary.GenericMethods;

public class SignOut extends SignIn {
	
	public SignOut(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//button[contains(text(),'Sign Out')]")
	private WebElement Signout;
	
	
	public void SignoutFromthepage() {
		
		GenericMethods generic=new GenericMethods();
		generic.waitTillelementisClickable(Signout);
		
		Signout.click();
		
		generic.waitTillelementisVisible(HomeHeadline);
		HomeHeadline.isDisplayed();
		
	}
	
	
	

}
