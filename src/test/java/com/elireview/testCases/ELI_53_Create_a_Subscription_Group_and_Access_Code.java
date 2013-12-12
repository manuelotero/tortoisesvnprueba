package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.CreateASubscriptionGroupAndAccessCode;
import com.elireview.pages.LoginPage;

public class ELI_53_Create_a_Subscription_Group_and_Access_Code extends MyProjTestCaseUtils{
	
	public ELI_53_Create_a_Subscription_Group_and_Access_Code(){
		super(BrowserType.FIREFOX);
	}
	
	CreateASubscriptionGroupAndAccessCode createASubscriptionAccessCode;
	LoginPage loginPage;
	User user = new User("oscarteacher","password");
	
	
	@Test
	public void CreateASubscriptionGroupAndAccessCode(){
		
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
	    
	    .using(
	    		createASubscriptionAccessCode = uiInstance.createASubscriptionGroupAndAccessCode()
			    .and(uiInstance)
			    .goToSubscriptionManager() 
			    .goToIntitution()
			    .goToUsageStantsGroupsLink()
			    .goToAddGruop()
			    .createGruop()
			    .deleteGroup())
	   .check(createASubscriptionAccessCode.successfulMessageMustBePresent());

	    
		
	}

}
