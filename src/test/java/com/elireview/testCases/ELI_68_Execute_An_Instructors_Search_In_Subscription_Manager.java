package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ExecuteAnInstructorsSearchInSubscriptionManager;
import com.elireview.pages.LoginPage;

public class ELI_68_Execute_An_Instructors_Search_In_Subscription_Manager extends MyProjTestCaseUtils{

	public ELI_68_Execute_An_Instructors_Search_In_Subscription_Manager(){
		super(BrowserType.FIREFOX);
	}

	ExecuteAnInstructorsSearchInSubscriptionManager executeAnInstructorsSearchIn;
	LoginPage loginPage;
	User user = new User("otero","123456");
	
	@Test
	public void executeAnInstructorsSearchIn(){
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
	    
	    .using(executeAnInstructorsSearchIn = uiInstance.executeAnInstructorsSearchIn()
	    		.and(uiInstance)
	    		.goToSubscriptionManager()
	    		.goToIntitution()
	    		.goToInstructorSetion()
	    		.UncheckheckedCheckBox()
	    		.clickSearchButton()
	    		.searchInstructor("Otero"))
	    		
	    .check(executeAnInstructorsSearchIn.successfulCourse())
	    
	    .and()
	    
	    .using(executeAnInstructorsSearchIn = uiInstance.executeAnInstructorsSearchIn()
	    		.and(uiInstance).goToInstructorInfo())
	    .check(executeAnInstructorsSearchIn.courseDetails())
	    
	    .and()
	    .using(executeAnInstructorsSearchIn = uiInstance.executeAnInstructorsSearchIn()
	    		.and(uiInstance))
	    .check(executeAnInstructorsSearchIn.successfulUserInstructors());
	   
	}
}
