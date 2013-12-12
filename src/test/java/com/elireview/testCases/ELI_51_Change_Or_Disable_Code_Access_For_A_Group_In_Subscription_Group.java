package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup;
import com.elireview.pages.LoginPage;

public class ELI_51_Change_Or_Disable_Code_Access_For_A_Group_In_Subscription_Group extends MyProjTestCaseUtils{

	public ELI_51_Change_Or_Disable_Code_Access_For_A_Group_In_Subscription_Group(){
		super(BrowserType.FIREFOX);
	}
	
	ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup ChangeOrDisableCodeAccess;
	LoginPage Loginpage;
	User user = new User("oscarteacher","password");
	
	
	@Test
	public void CreateACustomerSupportAdministratorRole(){
		using(
				Loginpage = uiInstance.getLoginPage()
						.and(uiInstance)
						.clearLogin()
						.and()
						.fillLogin(user)
						.and()
						.send())
	    .check(
	    		Loginpage.institutionSubscriptionManager())
		
	    .and()
	    
	    .using(ChangeOrDisableCodeAccess = uiInstance.changeOrDisableCodeAccess()
		    .and(uiInstance)
		    .goToInstitution()
		    .goToChangeCodeGroup()
		    .changeCode())
	    .check(ChangeOrDisableCodeAccess.successfulMessageMustBePresent())
	    
	    .and()
	    
	    .using(ChangeOrDisableCodeAccess = uiInstance.changeOrDisableCodeAccess()
	    		.and(uiInstance)
			    .goToInstitution()
			    .goToChangeCodeGroup()	    
			    .disableCodeGroup())
	    .check(ChangeOrDisableCodeAccess.disableCode());
	    
	}
	
}
