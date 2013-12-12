package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ExecuteAStudentsSearchInSubscriptionManager;
import com.elireview.pages.LoginPage;

public class ELI_70_Execute_A_Students_Search_In_Subscription_Manager extends MyProjTestCaseUtils{
	
	public ELI_70_Execute_A_Students_Search_In_Subscription_Manager(){
		super(BrowserType.FIREFOX);
	}

	ExecuteAStudentsSearchInSubscriptionManager executeAStudentsSearch;
	LoginPage loginPage;
	User user = new User("otero","123456");
	
	@Test
	public void executeAStudentsSearch(){
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
	    
	    .using(executeAStudentsSearch = uiInstance.executeAStudentsSearchInSubscriptionManager()
	    		.and(uiInstance)
	    		.goToSubscriptionManager()
	    		.goToIntitution()
	    		.goToStudentSetion()
	    		.clickSearchButton()
	    		.checkedCheckBox()
	    		.searchStudent("otero")
	    		.goToStudentInfo())
	    		
	    .check(executeAStudentsSearch.studenInfo())
	    
	    .and()
	    .using(executeAStudentsSearch = uiInstance.executeAStudentsSearchInSubscriptionManager()
	    		.and(uiInstance))
	    		
	    .check(executeAStudentsSearch.successfulUserName())
	    
	    .and()
	    .using(executeAStudentsSearch = uiInstance.executeAStudentsSearchInSubscriptionManager()
	    		.and(uiInstance))
	    		
	    .check(executeAStudentsSearch.successfulCourse());
	   
	}
}
