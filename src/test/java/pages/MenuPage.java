package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class MenuPage extends BaseClass {

	protected By applauncherIcon = By.xpath("//div[@class='slds-icon-waffle']");
	protected By viewAllLink = By.xpath("//button[text()='View All']");
	protected By salesLink = By.xpath("//span[@part='formatted-rich-text']/p[text()='Sales']");
	protected By logoutLink = By.xpath("//a[text()='Log Out']");
	protected By userImg = By.xpath("(//span[@class='uiImage']/parent::div[@data-aura-class='forceEntityIcon'])[1]");
	private WebDriver driver;
//	private SeleniumWrapper oWrap;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
//		this.node = node;
//		oWrap = new SeleniumWrapper(driver, node);
	}

	public MenuPage clickOnAppLauncher() {
		driver.findElement(applauncherIcon).click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return this;
	}

	public SalesPage clickOnSales() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(salesLink)).perform();
		driver.findElement(salesLink).click();
		return new SalesPage(driver);
	}

	public MenuPage clickOnViewAll() {
		driver.findElement(viewAllLink).click();
		return this;
	}

	public MenuPage clickUserImg() {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.findElement(userImg).click();
		return this;
	}

	public LoginPage clickLogout() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.findElement(logoutLink).click();
		return new LoginPage(driver);
	}
}
