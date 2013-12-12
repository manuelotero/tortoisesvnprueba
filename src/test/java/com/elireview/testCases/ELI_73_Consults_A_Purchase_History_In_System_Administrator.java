package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ConsultsAPurchaseHistoryInSystemAdministrator;
import com.elireview.pages.LoginPage;

public class ELI_73_Consults_A_Purchase_History_In_System_Administrator extends MyProjTestCaseUtils{
	
	public ELI_73_Consults_A_Purchase_History_In_System_Administrator(){
		super(BrowserType.FIREFOX);
	}
	
	
	ConsultsAPurchaseHistoryInSystemAdministrator consultsAPurchaseHistory;
	LoginPage loginPage;
	User user = new User("oscarteacher","password");
	
	@Test
	public void ExecuteAnStudentsSearch(){
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
	    
	    .using(consultsAPurchaseHistory = uiInstance.consultsAPurchaseHistoryInSystemAdministrator()
	    		.and(uiInstance)
	    		.goToSystemAdministrator()
	    		.goToInstitutionUsageReport()
	    		.goToTestDepartment1()
	    		.goToPurchaseHistory()
	    		.selectYear()
	    		)
	    		
	    .check(consultsAPurchaseHistory.institutionalPurchaseHistory())
	    
	    .and()
	    .using(consultsAPurchaseHistory = uiInstance.consultsAPurchaseHistoryInSystemAdministrator()
	    		.and(uiInstance))
	    		
	    .check(consultsAPurchaseHistory.table())
	    
	    .and()
	    .using(consultsAPurchaseHistory = uiInstance.consultsAPurchaseHistoryInSystemAdministrator()
	    		.and(uiInstance))
	    		
	    .check(consultsAPurchaseHistory.IndependentStudentPurchases());
	   
	}

}
