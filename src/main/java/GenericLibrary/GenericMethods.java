package GenericLibrary;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods extends Baseclass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public int generateRandomDigits(int size) throws InterruptedException {
		int randomDigit = 0;
		for (int i = 0; i < size; i++) {
			randomDigit = RandomUtils.nextInt(0, size);

			System.out.print(randomDigit+ "");
		}
		return randomDigit;
	}
	


	public String generateRandomDigitsinString(int size) {
	    StringBuilder randomDigits = new StringBuilder(); // To accumulate digits as a string
	    
	    for (int i = 0; i < size; i++) {
	        int randomDigit = RandomUtils.nextInt(0, size); // Random digit between 0 and 9
	        randomDigits.append(randomDigit); // Append the digit to the StringBuilder
	    }
	    
	    return randomDigits.toString(); // Return the result as a string
	}


	
	
	public static String GenerateRandomEmail() {

		// Generate random local part (alphanumeric string of length 8-12)
		String localPart = RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(8, 13));

		// Generate random domain name (alphanumeric string of length 5-10)
		String domain = RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(5, 11));

		// Generate random top-level domain
		String[] tlds = { "com", "org", "net", "io", "edu" };
		String tld = tlds[RandomUtils.nextInt(0, tlds.length)];

		String EmailId = localPart + "@" + domain + "." + tld;

		return EmailId;

	}
	public static StringBuilder GenerateHexadecimal(int size) {
		StringBuilder hexString=null;

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
	     hexString = sb.append(Integer.toHexString(random.nextInt(16)));
		}
		System.out.println(hexString);
		return hexString;

	}
	
	

	public String GenerateAlpNumericandSpecialcharacters(int length) {

		// Define the character set: letters, digits, and special characters
		String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + // Uppercase letters
				"abcdefghijklmnopqrstuvwxyz" + // Lowercase letters
				"0123456789" + // Numbers
				"@"; // Special characters
		String randomalphanumandspecialchar = RandomStringUtils.random(length, characterSet);

		System.out.println(randomalphanumandspecialchar);
		return randomalphanumandspecialchar;
	}

	public void waitTillelementisVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitTillelementinvisible(WebElement Element) {

		wait.until(ExpectedConditions.invisibilityOf(Element));
	}

	public void waitTillelementisClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void ScrollTillElementisvisible(WebElement element, WebDriver driver) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void Srollup(WebDriver driver, int Yoffset) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, arguments[0]);", -Yoffset);

	}

	public void Srolldown(WebDriver driver, int Yoffset) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,arguments[0);", Yoffset);

	}

	public void Alertshandle() {
		Alert alert = null;
		try {
			 alert = driver.switchTo().alert();

			alert.accept();

			System.out.println("Alert text: " + alert.getText());
		}catch (NoAlertPresentException e) {
			
	        // Continue if no alert is present
	        System.out.println("No alert found.");
	    }
		catch (UnhandledAlertException e) {
			 System.out.println("No alert found.");
		}
	}

}
