package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class CreateACustomerSupportAdministratorRole extends MyProjPage{
	
	@FindBy(xpath=".//*[@id='subMenu']/div[9]/a")
	private WebElement customerSupportLink;
	
	@FindBy(xpath=".//*[@id='criteria']")
	private WebElement searchUsers;
	
	@FindBy(xpath=".//*[@id='search']")
	private WebElement searchButton;
	
	@FindBy(xpath=".//*[@id='usersTable']/tbody/tr[3]/td[2]/a")
	private WebElement userLink;
	
	@FindBy(xpath=".//*[@id='mainContentCenter']/div[3]/div/div[1]/div[2]/span[1]/a")
	private WebElement promoteCustomerLink;
	
	@FindBy(xpath=".//*[@id='subMenu']/div[9]/a")
	private WebElement supportStaff;
	
	@FindBy(xpath=".//*[@id='Otero, Manuel']")
	private WebElement disableLink;
	
	@FindBy(xpath="html/body/div[6]/div[3]/div/button[1]")
	private WebElement disableSupportButton;
	
	//.//*[@id='messages']/div[2]/div[1]/div
	
	public CreateACustomerSupportAdministratorRole goToCustomerSupport(){
		customerSupportLink.click();
		return this;
	}
	
	public CreateACustomerSupportAdministratorRole searchUser(){
		searchUsers.clear();
		searchUsers.sendKeys("otero");
		searchButton.click();
		return this;
	}
	
	public CreateACustomerSupportAdministratorRole selectUser(){
		userLink.click();
		return this;
	}
	
	public CreateACustomerSupportAdministratorRole promoteCustomer(){
		promoteCustomerLink.click();
		return this;
	}
	
	public CreateACustomerSupportAdministratorRole cleaner(){
		supportStaff.click();
		disableLink.click();
		disableSupportButton.click();
		return this;
	}
	
	
	@Override
	public CreateACustomerSupportAdministratorRole then() {
		return this;
	}

	@Override
	public CreateACustomerSupportAdministratorRole and() {
		return this;
	}

	public CreateACustomerSupportAdministratorRole and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='messages']/div[2]/div[1]/div"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	
}
