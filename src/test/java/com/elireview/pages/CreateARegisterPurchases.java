package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class CreateARegisterPurchases extends MyProjPage{
	
	@FindBy(xpath=".//*[@id='subMenu']/div[7]/a")
	private WebElement systemAdministradorLink;
	
	@FindBy(xpath=".//*[@id='bulkPurchaseLink']")
	private WebElement registerBulkPurchasesLink;
	
	@FindBy(xpath=".//*[@id='institution']")
	private WebElement institution;
	
	@FindBy(xpath=".//*[@id='department']")
	private WebElement department;
	
	@FindBy(xpath=".//*[@id='country']")
	private WebElement country;
	
	@FindBy(xpath=".//*[@id='state']/option[1]")
	private WebElement state;
	
	@FindBy(xpath=".//*[@id='zip_code']")
	private WebElement zipCode;
	
	@FindBy(xpath=".//*[@id='manager']")
	private WebElement manager;
	
	@FindBy(xpath=".//*[@id='seats']")
	private WebElement seats;
	
	@FindBy(xpath=".//*[@id='validOn']")
	private WebElement validOn;

	@FindBy(xpath=".//*[@id='ui-datepicker-div']/div/a[2]/span")
	private WebElement next;

	@FindBy(xpath=".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[5]/a")
	private WebElement validOnDate;
	
	@FindBy(xpath=".//*[@id='expiresOn']")
	private WebElement expiresOn;

	@FindBy(xpath=".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[6]/a")
	private WebElement expiresOnDate;
	
	@FindBy(xpath=".//*[@id='purchase']")
	private WebElement registerPurchaseButton;
	

	public CreateARegisterPurchases goToSystemAdministrador(){
		systemAdministradorLink.click();
		return this;
	}
	
	public CreateARegisterPurchases goToRegisterBulkPurchases(){
		registerBulkPurchasesLink.click();
		return this;
	}
	
	
	public CreateARegisterPurchases fillRegisterInstitutionalPurchase(String department){
		institution.clear();
		institution.sendKeys("Institution_Auto");
		this.department.clear();
		this.department.sendKeys(department);
		zipCode.clear();
		zipCode.sendKeys("36311");
		manager.clear();
		manager.sendKeys("OscarTeacher");
		seats.clear();
		seats.sendKeys("1");
		validOn.click();
		next.click();
		validOnDate.click();
		expiresOn.click();
		next.click();
		expiresOnDate.click();
		return this;
	}
	
	public CreateARegisterPurchases registerPurchase(){
		registerPurchaseButton.click();
		return this;
	}
	
	@Override
	public CreateARegisterPurchases then() {
		return this;
	}

	@Override
	public CreateARegisterPurchases and() {
		return this;
	}

	public CreateARegisterPurchases and(UI uiInstance) {
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
