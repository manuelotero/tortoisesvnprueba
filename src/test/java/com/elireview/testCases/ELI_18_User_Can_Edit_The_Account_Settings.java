package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.data.User;
import com.elireview.pages.LoginPage;
import com.elireview.pages.UserCanEditTheAccountSettings;

public class ELI_18_User_Can_Edit_The_Account_Settings extends MyProjTestCaseUtils{
	
	public ELI_18_User_Can_Edit_The_Account_Settings() {
		super(BrowserType.FIREFOX);

	}
	
	UserCanEditTheAccountSettings userCanEditTheAccountSettings;
	LoginPage loginPage;
	User user = new User("Manuel","123456");
	
	@Test
	public void SignUpPage() {
		
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
				userCanEditTheAccountSettings = uiInstance.userCanEditTheAccountSettings()
				.and(uiInstance)
				.goToSetttings()
				.editName("Cristobal","Hernadez"))
.check(
		userCanEditTheAccountSettings.successfulMessageMustBePresent())
		.and()
		.using(userCanEditTheAccountSettings = uiInstance.userCanEditTheAccountSettings()
				.and(uiInstance)
				.goToSetttings()
				.editName("Manuel","Otero")).
				check(userCanEditTheAccountSettings.successfulMessageMustBePresent());
		}
	}
