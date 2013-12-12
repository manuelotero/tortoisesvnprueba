package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ConsultTheSubscriptionGroupDetailView extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement subcriptionManagerLink;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[8]/td[2]/a")
	private WebElement institutionAutoLink;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[1]/a")
	private WebElement usageStatsGroups;
	
	@FindBy(xpath = ".//*[@id='groupListTable']/tbody/tr[3]/td[1]/a")
	private WebElement group;
	
	@FindBy(xpath = ".//*[@id='courseListTable']")
	private WebElement table;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/div/h2/span")
	private WebElement groupdetailsLabel;
	
	public ConsultTheSubscriptionGroupDetailView goToSubcriptionManager(){
		subcriptionManagerLink.click();
		return this;
	}
	
	public ConsultTheSubscriptionGroupDetailView goToInstitutionAuto(){
		institutionAutoLink.click();
		return this;
	}
	
	public ConsultTheSubscriptionGroupDetailView goToUsageStatsGroups(){
		usageStatsGroups.click();
		return this;
	}
	
	public ConsultTheSubscriptionGroupDetailView goToGroup(){
		group.click();
		return this;
	}
	
	@Override
	public ConsultTheSubscriptionGroupDetailView then() {
		return this;
	}

	@Override
	public ConsultTheSubscriptionGroupDetailView and() {
		return this;
	}

	public ConsultTheSubscriptionGroupDetailView and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	
	public Validator groupDetails() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div/h2/span"))
						.getText().trim(), "Group Details");			
				
			}
		};
	}
	
	public Validator courseTable() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='courseListTable']"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	
	
}
