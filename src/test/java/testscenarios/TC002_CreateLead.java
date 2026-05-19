package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC002_CreateLead  extends BaseClass{
	

	@BeforeTest
	public void dataSetup() {
		excelFileName = "TC02";
		authors = "Aravind";
		category = "Sanity";
		testName = "Salesforce Create Lead";
		testDescription = "Validate all the mandatory fields and create a lead by providing only mandatory fields";
		testModule = "Create Lead";
	}
	
	@Test(priority = 1,dataProvider = "TestCaseData")
	public void createLead(String userName,String password) {
		boolean result = new LoginPage(driver,node)
				.enterUserName(userName)
				.enterPassword(password)
				.clickOnLogin()
				.verifyHomeElement()
				.clickOnAppLauncher()
				.clickOnViewAll()
				.clickOnSales()
				.clickOnLeadsLink()
				.clickOnNewButton()
				.enterLastName(FakerDataFactory.getLastName())
				//.clickAndSelectLeadStatus()
				.enterCompanyName(FakerDataFactory.getCompanyName())
				.clickOnSaveButton()
				.clickUserImg()
				.clickLogout()
				.verifyLoginElements();
				
				Assert.assertEquals(result, true);
	}

}
