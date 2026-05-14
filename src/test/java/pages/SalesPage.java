package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SalesPage extends MenuPage {

	private By leadsLink = By.xpath("//a/span[text()='Leads']");
	private By newBtn = By.xpath("//div[text()='New']");
	private By lastnameTxt = By.xpath("//input[@name='lastName']");
	private By companyTxt = By.xpath("//input[@name='Company']");
	// private By leadStatusBtn=By.xpath("//button[@data-value='Open - Not
	// Contacted']");
	private By leadStatusBtn = By.xpath("//label[contains(text(),'Lead Status')]/ancestor::div[@part='combobox']/div[1]//button");
	private By statusTxt = By.xpath("(//span[@title='Working - Contacted'])[2]");
	private By savebtn = By.xpath("//button[@name='SaveEdit']");
	private By noOfEmployee = By.xpath("//input[@name='NumberOfEmployees']");
	private WebDriver driver;
	
	public SalesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public SalesPage clickOnNewButton() {
		driver.findElement(newBtn).click();
		return this;
	}

	public SalesPage enterLastName(String lastName) {
		driver.findElement(lastnameTxt).sendKeys(lastName);
		return this;
	}
	
	public SalesPage clickOnLeadsLink() {
		driver.findElement(leadsLink).click();
		return this;
	}
	

//	public SalesPage clickAndSelectLeadStatus() {
//		oWrap.moveToElement(driver.findElement(noOfEmployee), excelFileName);
//		try {
//			Thread.sleep(3000);
//			oWrap.click(driver.findElement(leadStatusBtn), "Save Button");
//			Thread.sleep(2000);
//			oWrap.click(driver.findElement(statusTxt), "Save Button");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return this;
//	}

	public SalesPage enterCompanyName(String companyName) {
		driver.findElement(companyTxt).sendKeys(companyName);
		return this;
	}

	public SalesPage clickOnSaveButton() {
		driver.findElement(savebtn).click();
		return this;
	}

}
