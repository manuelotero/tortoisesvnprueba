package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.ExecuteACoursesSearchInSystemAdministrator;
import com.elireview.pages.LoginPage;

public class ELI_66_Execute_A_Courses_Search_In_System_Administrator extends MyProjTestCaseUtils{
	
	public ELI_66_Execute_A_Courses_Search_In_System_Administrator(){
		super(BrowserType.FIREFOX);
	}
	
	ExecuteACoursesSearchInSystemAdministrator executeACoursesSearch;
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
	    
	    .using(executeACoursesSearch = uiInstance.executeACoursesSearchInSystemAdministrator()
	    		.and(uiInstance)
	    		.goToSystemAdministrator()
	    		.goToInstitutionUsageReport()
	    		.goToTestDepartment1()
	    		.goToCourseSection()
	    		.searchCourse("Auto")
	    		.goToCourseInfo()
	    		)
	    		
	    .check(executeACoursesSearch.CourseRoster())
	    
	    .and()
	    .using(executeACoursesSearch = uiInstance.executeACoursesSearchInSystemAdministrator()
	    		.and(uiInstance))
	    		
	    .check(executeACoursesSearch.Coursedetails())
	    
	    .and()
	    .using(executeACoursesSearch = uiInstance.executeACoursesSearchInSystemAdministrator()
	    		.and(uiInstance))
	    		
	    .check(executeACoursesSearch.successfulUserNameInstructor());
	   
	}

}
