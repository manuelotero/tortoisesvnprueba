package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ConsultTheSubscriptionGroupDetailView;
import com.elireview.pages.LoginPage;

public class ELI_52_Consult_the_Subscription_Group_Detail_View extends MyProjTestCaseUtils {
	
	public ELI_52_Consult_the_Subscription_Group_Detail_View(){
		super(BrowserType.FIREFOX);
	}
	
	ConsultTheSubscriptionGroupDetailView ConsultGroupDetailView;
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
	    
	    .using(ConsultGroupDetailView = uiInstance.consultTheSubscriptionGroupDetailView()
		    .and(uiInstance)
		    .goToSubcriptionManager()
		    .goToInstitutionAuto()
		    .goToUsageStatsGroups()
		    .goToGroup())
		.check(ConsultGroupDetailView.courseTable())
		.and()
		.using(ConsultGroupDetailView = uiInstance.consultTheSubscriptionGroupDetailView()
		    .and(uiInstance)
		    .goToSubcriptionManager()
		    .goToInstitutionAuto()
		    .goToUsageStatsGroups()
		    .goToGroup())
		.check(ConsultGroupDetailView.courseTable());
	    
	}

}
