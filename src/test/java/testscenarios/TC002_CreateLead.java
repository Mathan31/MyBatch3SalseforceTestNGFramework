package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC002_CreateLead  extends BaseClass{
	
	@Test(priority = 1)
	public void createLead() {
		boolean result = new LoginPage()
				.enterUserName("mathan@credosystemz.sanbox")
				.enterPassword("Mylearning$8")
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
