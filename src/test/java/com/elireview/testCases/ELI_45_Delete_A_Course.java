package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.CreateACourseWithInstructorRole;
import com.elireview.pages.LoginPage;
import com.elireview.utils.Constant;


public class ELI_45_Delete_A_Course extends MyProjTestCaseUtils{
	
	public ELI_45_Delete_A_Course() {
		super(BrowserType.FIREFOX);

	}
	
	CreateACourseWithInstructorRole CreateACourse;
	LoginPage loginPage;
	User user = new User("Manuel","123456");
	
	@Test
	public void CreateACourseWithInstructorRole() {
		
		using(
				loginPage = uiInstance.getLoginPage()
						.and(uiInstance)
						.clearLogin()
						.and()
						.fillLogin(user)
						.and()
						.send())
	    .check(
	    		loginPage.successfulMessageMustBePresent())
		
	    .and()
				
	    .using(
	    		CreateACourse = uiInstance.createACourse()
				.and(uiInstance)
				.fillCourseLeader(Constant.accessCodeGroup)
				.createCourse())
				
		.check(CreateACourse.successfulMessageMustBePresent());

		}

}