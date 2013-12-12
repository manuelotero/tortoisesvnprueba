package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ConsultsAUsageStatsGroupsInformationInSystemAdministrator;
import com.elireview.pages.LoginPage;

public class ELI_64_Consults_A_Usage_Stats_Groups_Information_In_System_Administrator extends MyProjTestCaseUtils{
	
	public ELI_64_Consults_A_Usage_Stats_Groups_Information_In_System_Administrator(){
		super(BrowserType.FIREFOX);
	}
	
	LoginPage loginPage;
	ConsultsAUsageStatsGroupsInformationInSystemAdministrator ConsultsAUsageStatsGroupsInformation;
    User user = new User("otero","123456");
	
	
	@Test
	public void ConsultsAUsageStatsGroupsInformation(){
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
	    
	    .using(ConsultsAUsageStatsGroupsInformation = uiInstance.consultsAUsageStatsGroupsInformation()
		    .and(uiInstance)
		    .goToSystemAdministrator()
		    .goToInstitutionUsageReport()
		    .goToTestIntitution())
	    .check(ConsultsAUsageStatsGroupsInformation.managersAndUsageStats())
	    
	    .and()
	    .using(ConsultsAUsageStatsGroupsInformation = uiInstance.consultsAUsageStatsGroupsInformation()
			    .and(uiInstance)
			    .goToSystemAdministrator()
		    .goToInstitutionUsageReport()
		    .goToTestIntitution())
	    .check(ConsultsAUsageStatsGroupsInformation.groupTable());
	}
	

}
