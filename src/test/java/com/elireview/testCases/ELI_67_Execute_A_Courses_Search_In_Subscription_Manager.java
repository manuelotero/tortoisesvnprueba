package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ExecuteACoursesSearchInSubscriptionManager;
import com.elireview.pages.LoginPage;

public class ELI_67_Execute_A_Courses_Search_In_Subscription_Manager extends MyProjTestCaseUtils{

	public ELI_67_Execute_A_Courses_Search_In_Subscription_Manager(){
		super(BrowserType.FIREFOX);
	}

	ExecuteACoursesSearchInSubscriptionManager executeACoursesSearch;
	LoginPage loginPage;
	User user = new User("otero","123456");
	
	@Test
	public void executeACoursesSearch(){
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
	    
	    .using(executeACoursesSearch = uiInstance.executeACoursesSearchInSubscriptionManager()
	    		.and(uiInstance)
	    		.goToSubscriptionManager()
	    		.goToIntitution()
	    		.goToCourseSetion()
	    		.UncheckheckedCheckBox()
	    		.clickSearchButton()
	    		.searchCourse("00AUTO"))
	    		
	    .check(executeACoursesSearch.successfulCourse())
	    
	    .and()
	    
	    .using(executeACoursesSearch = uiInstance.executeACoursesSearchInSubscriptionManager()
	    		.and(uiInstance).goToCourseInfo())
	    .check(executeACoursesSearch.courseDetails())
	    
	    .and()
	    .using(executeACoursesSearch = uiInstance.executeACoursesSearchInSubscriptionManager()
	    		.and(uiInstance))
	    .check(executeACoursesSearch.successfulUserInstructors());
	   
	}
}
