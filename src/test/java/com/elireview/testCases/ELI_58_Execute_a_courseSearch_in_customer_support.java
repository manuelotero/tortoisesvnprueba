package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.LoginPage;
import com.elireview.pages.ExecuteACourseSearchInCustomerSupport;

public class ELI_58_Execute_a_courseSearch_in_customer_support extends MyProjTestCaseUtils{
	
	public ELI_58_Execute_a_courseSearch_in_customer_support(){
		super(BrowserType.FIREFOX);
	}
	
	LoginPage loginPage;
	ExecuteACourseSearchInCustomerSupport ExecuteACourseSearch;
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
	    
	    .using(ExecuteACourseSearch = uiInstance.executeACourseSearch()
		    .and(uiInstance)
		    .goToCustomerSupport()
		    .goToCourseSearch()
		    .executeACourseSearch())
	    .check(ExecuteACourseSearch.result())
	    
	    .and()
	    .using(ExecuteACourseSearch = uiInstance.executeACourseSearch()
			    .and(uiInstance)
			    .goToCustomerSupport()
			    .goToCourseSearch()
			    .executeACourseSearch()
			    .goToCourse())
	    .check(ExecuteACourseSearch.courseID());
	}
}
