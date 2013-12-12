package com.elireview.testCases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import com.elireview.data.User;
import com.elireview.pages.SignUpPage;


public class ELI_6_SignUpIntoEli extends MyProjTestCaseUtils{
	
	public ELI_6_SignUpIntoEli() {
		super(BrowserType.FIREFOX);

	}
	/////###Cambiar correo y user name
	SignUpPage SignUpPage;
	User user = new User("Manuel","Otero","motero+4@testingsoft.com","Manuel4","123456");
	
	@Test
	public void SignUpPage() {

		using(
				SignUpPage = uiInstance.signUpPage()
						.and(uiInstance)
						.fillSignUpFrom(user)
						.signUp())
		.check(
				SignUpPage.successfulMessageMustBePresent());

		
	}

}
