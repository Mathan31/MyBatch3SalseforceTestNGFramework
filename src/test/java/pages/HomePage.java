package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class HomePage extends MenuPage{
	

	//private WebDriver driver;

//	public HomePage(WebDriver driver, ExtentTest node) {
//		super(driver, node);
//		this.driver = driver;
//		this.node = node;
//		oWrap = new SeleniumWrapper(driver, node);
//	}

	public HomePage verifyHomeElement() {
		if (driver.findElement(applauncherIcon).isDisplayed()
				&& driver.findElement(userImg).isDisplayed()) {
			System.out.println("User landed to the home page");
			return this;
		} else {
			System.out.println("User not landed to the home page");
			return this;
		}
	}

}
