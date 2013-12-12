package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ConsultsAPurchaseHistoryInSystemAdministrator extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[7]/a")
	private WebElement SystemAdministratorLink;
	
	@FindBy(xpath = ".//*[@id='institutionUsageReport']")
	private WebElement InstitutionUsageReport;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-header-44']/span")
	private WebElement testInstitution1;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-panel-44']/a")
	private WebElement testDepartment1;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[9]/a")
	private WebElement purchaseHistory;
	
	@FindBy(xpath = ".//*[@id='year']/option[2]")
	private WebElement selectYear;
	
	@FindBy(xpath = ".//*[@id='quarter']/option[4]")
	private WebElement selectQuarter;
	
	
	public ConsultsAPurchaseHistoryInSystemAdministrator goToSystemAdministrator(){
		SystemAdministratorLink.click();
		return this;
	}
	
	public ConsultsAPurchaseHistoryInSystemAdministrator goToInstitutionUsageReport(){
		InstitutionUsageReport.click();
		return this;
	}
	
	
	public ConsultsAPurchaseHistoryInSystemAdministrator goToTestDepartment1(){
		testInstitution1.click();
		testDepartment1.click();
		return this;
	}
	
	public ConsultsAPurchaseHistoryInSystemAdministrator goToPurchaseHistory(){
		purchaseHistory.click();
		return this;
	}
	public ConsultsAPurchaseHistoryInSystemAdministrator selectYear(){
		selectYear.click();
		selectQuarter.click();
		return this;
	}
	
	
	@Override
	public ConsultsAPurchaseHistoryInSystemAdministrator then() {
		return this;
	}

	@Override
	public ConsultsAPurchaseHistoryInSystemAdministrator and() {
		return this;
	}

	public ConsultsAPurchaseHistoryInSystemAdministrator and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator institutionalPurchaseHistory() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[2]/h2"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator table() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='purchaseList']"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}

	
	public Validator IndependentStudentPurchases() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[4]/h2"))
						.getText().trim(), "Independent Student Purchases");			
				
			}
		};
	}

}
