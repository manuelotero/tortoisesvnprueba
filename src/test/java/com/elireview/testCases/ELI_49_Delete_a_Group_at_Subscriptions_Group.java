package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.CreateASubscriptionGroupAndAccessCode;
import com.elireview.pages.LoginPage;

public class ELI_49_Delete_a_Group_at_Subscriptions_Group extends MyProjTestCaseUtils{
	
	public ELI_49_Delete_a_Group_at_Subscriptions_Group(){
		super(BrowserType.FIREFOX);
	}
	
	CreateASubscriptionGroupAndAccessCode createASubscriptionAccessCode;
	LoginPage loginPage;
	User user = new User("oscarteacher","password");
	
	
	@Test
	public void DeleteAGroupAtSubscriptionsGroup(){
		
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
