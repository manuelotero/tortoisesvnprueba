package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.elireview.testCases.MyProjTestCaseUtils;
import com.elireview.data.User;
import com.elireview.pages.LoginPage;


public class LoginTestCase extends MyProjTestCaseUtils{

	public LoginTestCase() {
		super(BrowserType.FIREFOX);

	}

	LoginPage login;
	User user = new User("Manuel","123456");
	
	@Test
	public void TheUserCanDeleteTheEportfolio() {

		using(
				login = uiInstance.getLoginPage()
						.and(uiInstance)
						.clearLogin()
						.and()
						.fillLogin(user)
						.and()
						.send())
		.check(
				login.successfulMessageMustBePresent());

		
	}
}
