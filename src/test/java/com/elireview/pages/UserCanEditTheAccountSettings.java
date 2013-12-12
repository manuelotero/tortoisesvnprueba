package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class UserCanEditTheAccountSettings extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='userMenu']")
	private WebElement userDropDown;
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div[3]/div/div[2]")
	private WebElement settingsButton;
	
	@FindBy(xpath = ".//*[@id='firstNameUpdate']")
	private WebElement firstName;
	
	@FindBy(xpath = ".//*[@id='lastNameUpdate']")
	private WebElement lastName;
	
	@FindBy(xpath = ".//*[@id='fullName']")
	private WebElement editButton;
	
	public UserCanEditTheAccountSettings goToSetttings(){
		userDropDown.click();
		settingsButton.click();
		return this;
		}
	
	public UserCanEditTheAccountSettings editName(String fistName,String lastName){
		editButton.click();
		firstName.clear();
		firstName.sendKeys(fistName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		editButton.click();
		return this;
	}
	
	
	public UserCanEditTheAccountSettings and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='messagesIndicator']/div"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	

}
