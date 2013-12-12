package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ExecuteACodeSearchInCustomerSupport;
import com.elireview.pages.LoginPage;

public class ELI_60_Execute_A_Code_Search_In_Customer_Support extends MyProjTestCaseUtils{
	
	public ELI_60_Execute_A_Code_Search_In_Customer_Support(){
		super(BrowserType.FIREFOX);
	}
	
	LoginPage loginPage;
	ExecuteACodeSearchInCustomerSupport ExecuteACodeSearch;
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
	    
	    .using(ExecuteACodeSearch = uiInstance.executeACodeSearch()
		    .and(uiInstance)
		    .goToCustomerSupport()
		    .goToCourseSearch()
		    .executeACourseSearch())
	    .check(ExecuteACodeSearch.result())
	    
	    .and()
	    .using(ExecuteACodeSearch = uiInstance.executeACodeSearch()
			    .and(uiInstance)
			    .goToCustomerSupport()
			    .goToCourseSearch()
			    .executeACourseSearch()
			    .goToCourse())
	    .check(ExecuteACodeSearch.courseID());
	}
}
