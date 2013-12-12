package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteAUserSearchInCustomerSupport extends MyProjPage{
	
	@FindBy(xpath=".//*[@id='subMenu']/div[9]/a")
	private WebElement customerSupportLink;
	
	@FindBy(xpath=".//*[@id='criteria']")
	private WebElement searchUsers;
	
	@FindBy(xpath=".//*[@id='search']")
	private WebElement searchButton;
	
	public ExecuteAUserSearchInCustomerSupport goToCustomerSupport(){
		customerSupportLink.click();
		return this;
	}
	
	public ExecuteAUserSearchInCustomerSupport searchUser(){
		searchUsers.clear();
		searchUsers.sendKeys("otero");
		searchButton.click();
		return this;
	}
	
	@Override
	public ExecuteAUserSearchInCustomerSupport then() {
		return this;
	}

	@Override
	public ExecuteAUserSearchInCustomerSupport and() {
		return this;
	}

	public ExecuteAUserSearchInCustomerSupport and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='usersTable']"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}

}
