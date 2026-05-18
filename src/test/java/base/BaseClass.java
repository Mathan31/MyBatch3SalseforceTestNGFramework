package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utils.PropertyFileUtil;
import wrapper.HTMLReport;

public class BaseClass extends HTMLReport {
	
	public String propFileName = "Environment";
	public WebDriver driver; // null --> 123 --> null
	public String browserType = PropertyFileUtil.readDataFromPropertyFile(propFileName, "Browser"); //chrome,firefox,edge,safari
	public String sURL = PropertyFileUtil.readDataFromPropertyFile(propFileName, "URL");
	public String excelFileName = "";
	public String testName,testDescription,testModule;
	
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	
	@AfterSuite
	public void bindReport() {
		endReport();
	}
	
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

	@Override
	public String takeScreenshot() {
		String sPath = System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		TakesScreenshot oShot = (TakesScreenshot)driver;
		File osrc = oShot.getScreenshotAs(OutputType.FILE);
		File dis = new File(sPath);
		try {
			FileUtils.copyFile(osrc, dis); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sPath;
	}


}
