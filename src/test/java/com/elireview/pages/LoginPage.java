package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.data.User;
import com.elireview.pages.LoginPage;
import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class LoginPage extends MyProjPage {
	
	@FindBy(xpath = "/html/body/div[3]/div[5]/div[2]/form/div/div[2]/input")
	private WebElement userName;

	@FindBy(xpath = "/html/body/div[3]/div[5]/div[2]/form/div/div[4]/input")
	private WebElement password;

	@FindBy(xpath = ".//*[@id='submitLogin']")
	private WebElement singInButton;

	public LoginPage send() {
		singInButton.click();
		return this;
	}

	public LoginPage fillLogin(User user) {
		userName.sendKeys(user.getUserName());
		password.sendKeys(user.getPassword());
		return this;
	}
	
	public LoginPage clearLogin() {
		userName.clear();
		password.clear();
		return this;
	}

	@Override
	public LoginPage then() {
		return this;
	}

	@Override
	public LoginPage and() {
		return this;
	}

	public LoginPage and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}

	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[1]/form/div/div[5]/div[2]"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator institutionSubscriptionManager() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/h2"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}


}
