package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrapper.SeleniumWrapper;


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
	private SeleniumWrapper oWrap;

	public SalesPage(WebDriver driver, ExtentTest node) {
		super(driver, node);
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}

	public SalesPage clickOnNewButton() {
		oWrap.click(driver.findElement(newBtn), "New Button");
		return this;
	}

	public SalesPage enterLastName(String lastName) {
		oWrap.type(driver.findElement(lastnameTxt), lastName);
		return this;
	}
	
	public SalesPage clickOnLeadsLink() {
		oWrap.moveToElementAndClick(driver.findElement(leadsLink), "Leads Link");
		return this;
	}
	

	public SalesPage clickAndSelectLeadStatus() {
		oWrap.moveToElement(driver.findElement(noOfEmployee), excelFileName);
		try {
			Thread.sleep(3000);
			oWrap.click(driver.findElement(leadStatusBtn), "Save Button");
			Thread.sleep(2000);
			oWrap.click(driver.findElement(statusTxt), "Save Button");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this;
	}

	public SalesPage enterCompanyName(String companyName) {
		oWrap.type(driver.findElement(companyTxt), companyName);
		return this;
	}

	public SalesPage clickOnSaveButton() {
		oWrap.click(driver.findElement(savebtn), "Save Button");
		return this;
	}

}
