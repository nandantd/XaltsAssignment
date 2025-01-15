package GenericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {

	public static WebDriver driver;

	Properties pr = new Properties();

	@BeforeClass
	public void InitializeDrivers() throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Enviornment.properties");
		pr.load(fis);
		String browsername = pr.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			LaunchURL();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			LaunchURL();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

			driver.manage().window().maximize();
			LaunchURL();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}

	}

	@BeforeClass
	public void LaunchURL() {

		driver.navigate().to(pr.getProperty("URL"));
	}

	@AfterClass
	public void QuitallBrowsers() {
		
		driver.quit();
	}
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File destination=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
		
	}
		

}
