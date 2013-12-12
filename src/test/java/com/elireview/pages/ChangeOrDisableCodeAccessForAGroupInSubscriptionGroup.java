package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup extends MyProjPage{
	
	@FindBy(xpath=".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[2]/td[2]/a")
	private WebElement institution;
	               //.//*[@id='subMenu']/div[1]/a
	@FindBy(xpath=".//*[@id='subMenu']/div[1]/a")
	private WebElement usageStandGroup;
	
	@FindBy(xpath=".//*[@id='groupListTable']/tbody/tr[2]/td[1]/a")
	private WebElement changeCodeGroup;
	
	@FindBy(xpath=".//*[@id='new_code']")
	private WebElement newCode;
	
	@FindBy(xpath=".//*[@id='passcode']")
	private WebElement passcode;
	
	@FindBy(xpath=".//*[@id='disable_code']")
	private WebElement disableCode;
	
	@FindBy(xpath="html/body/div[6]/div[3]/div/button[1]")
	private WebElement yesDisableCode;
	
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup goToInstitution(){
		institution.click();
		return this;
	}
	
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup goToUsageStandGroup(){
		usageStandGroup.click();
		return this;
	}
	
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup goToChangeCodeGroup(){
		changeCodeGroup.click();
		return this;
	}
	
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup changeCode(){
		newCode.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup disableCodeGroup(){
		disableCode.click();
		yesDisableCode.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	

	@Override
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup then() {
		return this;
	}

	@Override
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup and() {
		return this;
	}

	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='passcode']"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator disableCode() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='passcode']")).getText().trim(), "- - - - - - - -");			
				
			}
		};
	}
}
