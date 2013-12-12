package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.CreateARegisterPurchases;
import com.elireview.pages.LoginPage;

public class ELI_62_Create_A_Register_Purchases_In_System_Administrator extends MyProjTestCaseUtils{

	public ELI_62_Create_A_Register_Purchases_In_System_Administrator(){
		super(BrowserType.FIREFOX);
	}
	
	LoginPage loginPage;
	CreateARegisterPurchases createARegisterPurchases;
	User user = new User("oscarteacher","password");
	
	//########### Cambiar el nombre del departameto al correr el TC
	@Test
	public void createARegisterPurchases(){
		using(
				loginPage = uiInstance.getLoginPage()
						.and(uiInstance)
						.clearLogin()
						.and()
						.fillLogin(user)
						.and()
						.send())
	    .check(
	    		loginPage.institutionSubscriptionManager())
		
	    .and()
	    
	    .using(createARegisterPurchases = uiInstance.createARegisterPurchases()
		    .and(uiInstance)
		    .goToSystemAdministrador()
		    .then()
		    .goToRegisterBulkPurchases()
		    .and()
		    .fillRegisterInstitutionalPurchase("Deparment_Auto7")
		    .then()
		    .registerPurchase())
	    .check(createARegisterPurchases.successfulMessageMustBePresent());
	}


	
}
