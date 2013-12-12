package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ExecuteAnStudentsSearchInSystemAdministrator;
import com.elireview.pages.LoginPage;

public class ELI_72_Execute_An_Students_Search_In_System_Administrator extends MyProjTestCaseUtils{
	
	public ELI_72_Execute_An_Students_Search_In_System_Administrator(){
		super(BrowserType.FIREFOX);
	}

	ExecuteAnStudentsSearchInSystemAdministrator executeAnStudentsSearch;
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
	    
	    .using(executeAnStudentsSearch = uiInstance.executeAnStudentsSearchInSystemAdministrator()
	    		.and(uiInstance)
	    		.goToSystemAdministrator()
	    		.goToInstitutionUsageReport()
	    		.goToTestDepartment1()
	    		.goToStudentsSection()
	    		.searchStudent("otero")
	    		.goToStudentInfo()
	    		)
	    		
	    .check(executeAnStudentsSearch.successfulUserName())
	    
	    .and()
	    .using(executeAnStudentsSearch = uiInstance.executeAnStudentsSearchInSystemAdministrator()
	    		.and(uiInstance))
	    		
	    .check(executeAnStudentsSearch.Userdetails())
	    
	    .and()
	    .using(executeAnStudentsSearch = uiInstance.executeAnStudentsSearchInSystemAdministrator()
	    		.and(uiInstance))
	    		
	    .check(executeAnStudentsSearch.CoursesTakenby());
	   
	}
	
}
