package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_LoginScenario extends BaseClass{
	
	@BeforeTest
	public void dataSetup() {
		excelFileName = "TC01";
	
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage(driver)
		.verifyLoginElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String userName,String password) {
		
		boolean result = new LoginPage(driver)
		.enterUserName(userName)
		.enterPassword(password)
		.clickOnLogin()
		.verifyHomeElement()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		Assert.assertTrue(result);
		
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage(driver)
		.enterUserName("mathan@credosystemz.sanbox")
		.enterPassword("Mylearning$10")
		.clickOnLoginWithInvalidCredential()
		.validateErrorMsg();
		Assert.assertTrue(result);
	}

}
