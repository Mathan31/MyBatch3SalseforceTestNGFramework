package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import utils.PropertyFileUtil;

public class BaseClass {
	
	public String propFileName = "Environment";
	public WebDriver driver; // null --> 123 --> null
	public String browserType = PropertyFileUtil.readDataFromPropertyFile(propFileName, "Browser"); //chrome,firefox,edge,safari
	public String sURL = PropertyFileUtil.readDataFromPropertyFile(propFileName, "URL");
	public String excelFileName = "";
	
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
	

	@DataProvider(name="TestCaseData")
	public Object[][] excelData() throws Exception {
		Object[][] values = utils.DataProviderObject.getValue(excelFileName);
		return values;
	}

}
