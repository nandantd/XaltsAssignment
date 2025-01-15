package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import GenericLibrary.GenericMethods;

public class WalletAddresspage extends Nodespage {

    public WalletAddresspage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[contains(text(),'Wallet Address')]/..//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
    private WebElement walletAddressTextField;

    @FindBy(xpath = "//label[contains(text(),'Select')]/..//div[@id='node-type-select']")
    private WebElement selectWalletType;

    @FindBy(xpath = "//button[contains(text(),' + Add Wallet ')]")
    private WebElement addWalletButton;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css')]/child::li[1]")
    private WebElement walletOption;
    
    @FindBy(xpath="//button[contains(text(),'Submit')]")
    private WebElement Submit;
    

    public void addWalletAddresses(WebDriver driver, int numOfWalletAddrs) throws InterruptedException {
        GenericMethods generic = new GenericMethods();

        generic.waitTillelementisVisible(walletAddressTextField);

        for (int i = 0; i < numOfWalletAddrs; i++) {
            // Generate a unique hexadecimal wallet address
            String hexanum = "0x" + generic.GenerateHexadecimal(40).toString();

            // Enter wallet address
            walletAddressTextField.click();
            walletAddressTextField.sendKeys(hexanum);

            // Select wallet type
            generic.waitTillelementisVisible(selectWalletType);
            selectWalletType.click();
            generic.waitTillelementisClickable(walletOption);
            walletOption.click();

            // Add wallet
            addWalletButton.click();

            // Scroll the wallet list container
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int scrollCount = 0; scrollCount < 3; scrollCount++) {
                js.executeScript(
                        "document.querySelector('#root > div > main > section:nth-child(3) > div > div > div:nth-child(2) > div.MuiDataGrid-root > div.MuiDataGrid-main > div:nth-child(2) > div').scrollBy(0, 1000);");
                Thread.sleep(3000);
                js.executeScript(
                        "document.querySelector('#root > div > main > section:nth-child(3) > div > div > div:nth-child(2) > div.MuiDataGrid-root > div.MuiDataGrid-main > div:nth-child(2) > div').scrollBy(0, -1000);");
            }

            // Verify if the wallet address is added
            List<WebElement> listOfWalletAddresses = driver.findElements(By.xpath("//div[contains(@title,'0x')]"));
            boolean isWalletFound = false;

            for (WebElement wallet : listOfWalletAddresses) {
                if (wallet.getText().equals(hexanum)) {
                    isWalletFound = true;
                    break;
                }
            }

            Assert.assertTrue(isWalletFound, "Wallet Address " + hexanum + " not found in the list.");
        }
        generic.waitTillelementisVisible(nextButton);
        nextButton.click();
        
        generic.waitTillelementisClickable(Submit);
        Submit.click();
        
        
        
        
    }
}
