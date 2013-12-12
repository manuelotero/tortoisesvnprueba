package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ConsultAPurchaseHistory;
import com.elireview.pages.LoginPage;

public class ELI_71_Consult_a_Purchase_History_in_Subscription_Manager extends MyProjTestCaseUtils{
	
	public ELI_71_Consult_a_Purchase_History_in_Subscription_Manager(){
		super(BrowserType.FIREFOX);
	}
	
	ConsultAPurchaseHistory consultAPurchaseHistory;
	LoginPage loginPage;
	User user = new User("otero","123456");
	
	@Test
	public void ConsultAPurchaseHistory(){
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
	    
	    .using(consultAPurchaseHistory = uiInstance.consultAPurchaseHistor()
	    		.and(uiInstance)
	    		.goToSubscriptionManager()
	    		.goToIntitution()
	    		.goToPurchaseHistory()
	    		.selectYearAndQuarter())
	    		
	    .check(consultAPurchaseHistory.numberSeats());
	   
	}
	

}
