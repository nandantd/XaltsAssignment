package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import GenericLibrary.Baseclass;
import GenericLibrary.GenericMethods;
import GenericLibrary.TestData;

public class Nodespage extends SignIn {

	Baseclass base = new Baseclass();
	GenericMethods generic = new GenericMethods();

	public Nodespage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div//h2[contains(text(),'Onboard OCN Node')]")
	protected WebElement OnboardOCNNodeTitle;

	@FindBy(xpath = "//section//h1[contains(text(),'Onboard OCN Node')]")
	private WebElement onboardOCNSection;

	@FindBy(xpath = "//label[contains(text(),'Node ID')]/..//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement nodeIDTextField;

	@FindBy(xpath = "//label[contains(text(),'Public IP')]/..//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement publicIPTextField;

	@FindBy(xpath = "//label[contains(text(),'Select')]/..//div[@id=\"node-type-select\"]")
	private WebElement nodeTypeSelect;

	@FindBy(xpath = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/child::li[1]")
	private WebElement nodeOptions;

	@FindBy(xpath = "//button[contains(text(),'+ Add Node')]")
	private WebElement addNode;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	public void verifyOnboardpageisdisplayed() {
		generic.waitTillelementisVisible(OnboardOCNNodeTitle);
		OnboardOCNNodeTitle.click();
	}

	public void nodesPageFunctionality(WebDriver driver, int numOfNodesCreation) throws InterruptedException {
		//generic.waitTillelementisVisible(onboardOCNSection);
		//onboardOCNSection.isDisplayed();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < numOfNodesCreation; i++) {

			generic.waitTillelementisVisible(nodeIDTextField);
			String nodeId = "NodeID-".concat(generic.generateRandomDigitsinString(10));

			nodeIDTextField.click();
			nodeIDTextField.sendKeys(nodeId);

			publicIPTextField.click();
			publicIPTextField.sendKeys(TestData.IPAddress.concat(generic.generateRandomDigitsinString(3)));

			generic.waitTillelementisClickable(nodeTypeSelect);
			nodeTypeSelect.click();

			generic.waitTillelementisClickable(nodeOptions);
			nodeOptions.click();

			generic.waitTillelementisClickable(addNode);
			addNode.click();

			// Scroll within the node list container
			for (int scrollCount = 0; scrollCount < 3; scrollCount++) {
				js.executeScript(
						"document.querySelector('#root > div > main > section:nth-child(3) > div > div > div:nth-child(2) > div.MuiDataGrid-root > div.MuiDataGrid-main > div:nth-child(2) > div').scrollBy(0, 1000);");
				Thread.sleep(3000);
				js.executeScript(
						"document.querySelector('#root > div > main > section:nth-child(3) > div > div > div:nth-child(2) > div.MuiDataGrid-root > div.MuiDataGrid-main > div:nth-child(2) > div').scrollBy(0, -1000);");
			}

			Thread.sleep(2000); // Use a more dynamic wait if possible

			List<WebElement> listOfNodesCreated = driver.findElements(By.xpath("//div[contains(@title,'NodeID')]"));
			boolean isNodeFound = false;

			for (WebElement webElement : listOfNodesCreated) {
				if (webElement.getText().equals(nodeId)) {
					isNodeFound = true;
					break;
				}
			}

			Assert.assertTrue(isNodeFound, "Node ID " + nodeId + " not found in the created nodes list.");
		}

		generic.waitTillelementisClickable(nextButton);
		nextButton.click();
	}
}
