package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.LoginPage;
import com.elireview.pages.ExecuteAUserSearchInCustomerSupport;

public class ELI_42_Execute_A_User_Search_In_Customer_Support extends MyProjTestCaseUtils{
	
	public ELI_42_Execute_A_User_Search_In_Customer_Support(){
		super(BrowserType.FIREFOX);
	}
	
	ExecuteAUserSearchInCustomerSupport ExecuteAUserSearchInCustomer;
	LoginPage loginPage;
	User user = new User("oscarteacher","password");
	
	
	@Test
	public void CreateACustomerSupportAdministratorRole(){
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
	    
	    .using(ExecuteAUserSearchInCustomer = uiInstance.executeAUserSearchInCustomerSupport()
		    .and(uiInstance)
		    .goToCustomerSupport()
		    .searchUser())
		.check(ExecuteAUserSearchInCustomer.successfulMessageMustBePresent());
	    
	}

}
