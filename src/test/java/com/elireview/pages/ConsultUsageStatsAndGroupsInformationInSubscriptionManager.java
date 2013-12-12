package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ConsultUsageStatsAndGroupsInformationInSubscriptionManager extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement subcriptionManagerLink;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[2]/td[2]/a")
	private WebElement departmentLink;
	
	public ConsultUsageStatsAndGroupsInformationInSubscriptionManager goTosubcriptionManager(){
		subcriptionManagerLink.click();
		return this;
	}
	
	public ConsultUsageStatsAndGroupsInformationInSubscriptionManager goToDepartment(){
		departmentLink.click();
		return this;
	}
	
	@Override
	public ConsultUsageStatsAndGroupsInformationInSubscriptionManager then() {
		return this;
	}

	@Override
	public ConsultUsageStatsAndGroupsInformationInSubscriptionManager and() {
		return this;
	}

	public ConsultUsageStatsAndGroupsInformationInSubscriptionManager and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator subscriptionGroupsAndAccessCodes() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/h2[2]"))
						.getText().trim(), "Subscription Groups and Access Codes");			
				
			}
		};
	}

	public Validator statusOfSubscriptionUsage() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/h2[1]"))
						.getText().trim(), "Status of Subscription Usage");			
				
			}
		};
	}
	
	public Validator availableSubscriptions() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[5]/td[1]"))
						.getText().trim(), "Available Subscriptions:");			
				
			}
		};
	}
	
	

}
