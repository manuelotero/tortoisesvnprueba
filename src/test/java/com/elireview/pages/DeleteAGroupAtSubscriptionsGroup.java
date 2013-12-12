package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class DeleteAGroupAtSubscriptionsGroup extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement subcriptionManagerLink;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[2]/td[2]/a")
	private WebElement institutoAutoLink;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[1]/a")
	private WebElement usageStantsGroupsLink;
	
	@FindBy(xpath = ".//*[@id='add-group']")
	private WebElement addGroup;
	
	@FindBy(xpath = ".//*[@id='name']")
	private WebElement groupName;
	
	@FindBy(xpath = ".//*[@id='subscription_limit']")
	private WebElement subscriptions;
	
	@FindBy(xpath = "html/body/div[6]/div[3]/div/button[1]")
	private WebElement createGroup;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/div/h1/span")
	private WebElement nameTitle;
	
	@FindBy(xpath = ".//*[@id='delete_group']")
	private WebElement deleteButtton;
	
	@FindBy(xpath = "html/body/div[8]/div[3]/div/button[1]")
	private WebElement acceptDelete;
	
	@FindBy(xpath = "html/body/div[8]/div[3]/div/button[1]")
	private WebElement institutionName;
			
	public DeleteAGroupAtSubscriptionsGroup goToSubscriptionManager(){
		subcriptionManagerLink.click();
		return this;
	}
	
	public DeleteAGroupAtSubscriptionsGroup goToIntitution(){
		institutoAutoLink.click();
		return this;
	}
	
	public DeleteAGroupAtSubscriptionsGroup goToUsageStantsGroupsLink(){
		usageStantsGroupsLink.click();
		return this;
	}
	
	public DeleteAGroupAtSubscriptionsGroup goToAddGruop(){
		addGroup.click();
		groupName.clear();
		groupName.sendKeys("Auto");
		subscriptions.clear();
		subscriptions.sendKeys("10");
		return this;
	}
	
	public DeleteAGroupAtSubscriptionsGroup createGruop(){
		createGroup.click();
		return this;
	}
	
	public DeleteAGroupAtSubscriptionsGroup deleteGroup(){
		deleteButtton.click();
		acceptDelete.click();
		return this;
	}
	
	
	@Override
	public DeleteAGroupAtSubscriptionsGroup then() {
		return this;
	}

	@Override
	public DeleteAGroupAtSubscriptionsGroup and() {
		return this;
	}

	public DeleteAGroupAtSubscriptionsGroup and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/h2[1]"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}

}
