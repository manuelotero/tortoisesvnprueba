package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.LoginPage;
import com.elireview.pages.UpdateTheCourseDetails;

public class ELI_47_Update_the_Course_Details_in_Course_Settings_options extends MyProjTestCaseUtils{

	public ELI_47_Update_the_Course_Details_in_Course_Settings_options(){
		super(BrowserType.FIREFOX);
	}
	
	UpdateTheCourseDetails 	updateTheCourseDetails;
	LoginPage loginpage;
	User user = new User("Manuel","123456");
	
	@Test
	public void updateTheCourseDetails(){
		
		using(loginpage = uiInstance.getLoginPage()
				.and(uiInstance).clearLogin()
				.fillLogin(user)
				.and()
				.send())
		.check(loginpage.successfulMessageMustBePresent())
		
		.and()
		
		.using(updateTheCourseDetails = uiInstance
			.updateTheCourseDetails()
			.and(uiInstance)
			.goToCoruse()
			.then()
			.goToCoruseSetting()
			.and()
			.editCourseDetails("Name-Edit", "00-Edit",true).saveCourseDetails())
		.check(updateTheCourseDetails.successfulMessageMustBePresent())
		
		.and()
		
		.using(updateTheCourseDetails = uiInstance
				.updateTheCourseDetails()
				.and(uiInstance)
				.goToCoruse()
				.then()
				.goToCoruseSetting()
				.and()
				.editCourseDetails("Auto-course", "00-AC",false).saveCourseDetails())
		.check(updateTheCourseDetails.successfulMessageMustBePresent());
		
		
	}
}
