package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.CreateACustomerSupportAdministratorRole;
import com.elireview.pages.LoginPage;

public class ELI_43_Create_a_Customer_Support_Administrator_role extends MyProjTestCaseUtils{
	
	public ELI_43_Create_a_Customer_Support_Administrator_role(){
		super(BrowserType.FIREFOX);
	}
	
	LoginPage loginPage;
	CreateACustomerSupportAdministratorRole createACustomerSuppor;
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
	    
	    .using(createACustomerSuppor = uiInstance.createACustomerSupportAdministratorRole()
		    .and(uiInstance)
		    .goToCustomerSupport()
		    .searchUser()
		    .selectUser()
		    .promoteCustomer()
		    .cleaner())
		.check(createACustomerSuppor.successfulMessageMustBePresent());
	    
	}
	

}
