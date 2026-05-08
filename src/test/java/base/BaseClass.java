package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	public String browserType = "chrome"; // chrome,firefox,edge,safari
	public String sURL = "https://login.salesforce.com/";
	
	@BeforeClass
	public  void invokeBrowser() {
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.out.println("User option is "+browserType+",So invoking Chrome Browser.");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.out.println("User option is "+browserType+",So invoking Edge Browser.");
			driver = new EdgeDriver();
			break;
		case "firefox":
			System.out.println("User option is "+browserType+",So invoking Firefox Browser.");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("User option is wrong"+browserType+",So invoking the default Chrome Browser.");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get(sURL);
	}
	
	@AfterClass
	public  void closeBrowser() {
		driver.quit();
	}

}
