package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLibrary.TestData;

public class NewPrivateBlockchain extends Nodespage {

	public NewPrivateBlockchain(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div//h2[contains(text(),'Launch OCN Child Network')]")
	private WebElement LaunchOCNChildNetworklink;

	@FindBy(xpath = "//label[contains(text(),'Network Name')]/..//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement NetworkTextfield;

	@FindBy(xpath = "//label[contains(text(),'Wallet Address')]/..//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement WalletAddress;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement Nextbutton;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement Submitbuton;

	@FindBy(xpath="//button[contains(text(),'Sign Out')]")
	private WebElement Signout;
	
	@FindBy(xpath="//div//h1[contains(text(),'Open Capital Network')]")
	private WebElement HomepageTitle;
	
	public void AddAlltheNodesinPrivateBlockchain(WebDriver driver) throws InterruptedException {

		generic.waitTillelementisVisible(LaunchOCNChildNetworklink);
		LaunchOCNChildNetworklink.click();
		
		generic.waitTillelementisVisible(NetworkTextfield);
		NetworkTextfield.click();
		NetworkTextfield.sendKeys(TestData.Networkname);
		
		WalletAddress.click();
		 String hexanum = "0x" + generic.GenerateHexadecimal(40).toString();
		WalletAddress.sendKeys(hexanum);
		
		generic.waitTillelementisClickable(Nextbutton);
		Nextbutton.click();
		
		nodesPageFunctionality(driver, 3);
		
		generic.ScrollTillElementisvisible(Submitbuton, driver);
		
		generic.waitTillelementisClickable(Submitbuton);
		Submitbuton.click();
		
		generic.ScrollTillElementisvisible(Signout, driver);
		generic.waitTillelementisClickable(Signout);
		Signout.click();
		
		generic.waitTillelementisVisible(HomepageTitle);
		HomepageTitle.isDisplayed();
		

	}

}
