package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class AccessToInstitutionalSubscriptionManagerOption extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[7]/a")
	private WebElement systemAdministratorLink;
	
	@FindBy(xpath = ".//*[@id='institutionUsageReport']")
	private WebElement institutionUsageReport;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-header-120']/span")
	private WebElement testIntitution;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-panel-120']/a[3]")
	private WebElement testdepartment;
	
	@FindBy(xpath = ".//*[@id='courseListTable']")
	private WebElement table;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/div/h2/span")
	private WebElement groupdetailsLabel;
	
	
	public AccessToInstitutionalSubscriptionManagerOption goToSystemAdministrator(){
		systemAdministratorLink.click();
		return this;
	}
	
	public AccessToInstitutionalSubscriptionManagerOption goToInstitutionUsageReport(){
		institutionUsageReport.click();
		return this;
	}
	
	public AccessToInstitutionalSubscriptionManagerOption goToTestIntitution(){
		testIntitution.click();
		testdepartment.click();
		return this;
	}
	
	@Override
	public AccessToInstitutionalSubscriptionManagerOption then() {
		return this;
	}

	@Override
	public AccessToInstitutionalSubscriptionManagerOption and() {
		return this;
	}

	public AccessToInstitutionalSubscriptionManagerOption and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	
	public Validator managersAndUsageStats() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver().findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/h2[1]")).getText().trim(), "Managers and Usage Stats");			
				
			}
		};
	}
	
	public Validator groupTable() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='groupListTable']"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}

}
