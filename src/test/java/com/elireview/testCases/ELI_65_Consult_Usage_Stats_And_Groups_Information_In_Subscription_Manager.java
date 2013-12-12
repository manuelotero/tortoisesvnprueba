package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ConsultUsageStatsAndGroupsInformationInSubscriptionManager;
import com.elireview.pages.LoginPage;

public class ELI_65_Consult_Usage_Stats_And_Groups_Information_In_Subscription_Manager extends MyProjTestCaseUtils{
	
	public ELI_65_Consult_Usage_Stats_And_Groups_Information_In_Subscription_Manager(){
		super(BrowserType.FIREFOX);
	}

	
	ConsultUsageStatsAndGroupsInformationInSubscriptionManager consultUsageStatsAndGroupsInformation;
	LoginPage loginPage;
	User user = new User("otero","123456");
	
	@Test
	public void ConsultUsageStatsAndGroupsInformation(){
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
	    .using(consultUsageStatsAndGroupsInformation = uiInstance.consultUsageStatsAndGroupsInformation()
	    .and(uiInstance)
	    .goTosubcriptionManager()
	    .goToDepartment())
	    .check(consultUsageStatsAndGroupsInformation.statusOfSubscriptionUsage())
	    .and()
	    .using(consultUsageStatsAndGroupsInformation = uiInstance.consultUsageStatsAndGroupsInformation().and(uiInstance))
	    .check(consultUsageStatsAndGroupsInformation.availableSubscriptions())
	    .and()
	    .using(consultUsageStatsAndGroupsInformation = uiInstance.consultUsageStatsAndGroupsInformation().and(uiInstance))
	    .check(consultUsageStatsAndGroupsInformation.subscriptionGroupsAndAccessCodes());
		
		
	}
}
