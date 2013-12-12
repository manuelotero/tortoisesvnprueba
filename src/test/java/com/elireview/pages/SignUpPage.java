package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.elireview.data.User;
import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class SignUpPage extends MyProjPage {

	@FindBy(xpath = ".//*[@id='firstName']")
	private WebElement firstName;

	@FindBy(xpath = ".//*[@id='lastName']")
	private WebElement lastName;

	@FindBy(xpath = ".//*[@id='emailAddress']")
	private WebElement emailAddress;
	
	@FindBy(xpath = ".//*[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath = ".//*[@id='answer']")
	private WebElement answer;
	
	@FindBy(xpath = ".//*[@id='user_role-2']")
	private WebElement instructorRadioButton;
	
	@FindBy(xpath = ".//*[@id='user_role-1']")
	private WebElement studentRadioButton;
	
	@FindBy(xpath = ".//*[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = ".//*[@id='verifyPassword']")
	private WebElement verifypassword;
	
	@FindBy(xpath = ".//*[@id='acceptTerms']")
	private WebElement acceptTermsCheckBox;
	
	@FindBy(xpath = ".//*[@id='submitAccount']")
	private WebElement CreateAccountButton;

	private @FindBy(className = ".//*[@id='mainContentCenter']/div[3]/div/div[2]/div/div[1]" )
	WebElement title;
	
	private @FindBy(className = ".//*[@id='mainContentCenter']/div[3]/div/div[2]/div/span" )
	WebElement subTitle;
	
	public SignUpPage fillSignUpFrom(User user){
		firstName.sendKeys(user.getFirstName());
		lastName.sendKeys(user.getLastName());
		emailAddress.sendKeys(user.getEmailAddress());
		userName.sendKeys(user.getUserName());
		answer.sendKeys("Mon");
		instructorRadioButton.click();
		password.sendKeys(user.getPassword());
		verifypassword.sendKeys(user.getPassword());
		acceptTermsCheckBox.click();
		return this;
	}
	
	public SignUpPage signUp(){
		CreateAccountButton.click();
		return this;
	}
	
	@Override
	public SignUpPage then() {
		return this;
	}

	@Override
	public SignUpPage and() {
		return this;
	}

	public SignUpPage and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}

	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver().findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[2]/div/div[1]")).getText().trim(), "Welcome to Eli!");			
				
			}
		};
	}

}
