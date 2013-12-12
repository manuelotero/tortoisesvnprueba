package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ConsultAPurchaseHistory extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement subcriptionManagerLink;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[2]/td[2]/a")
	private WebElement institutoAutoLink;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[9]/a")
	private WebElement purchaseHistoryLink;
	
	@FindBy(xpath = ".//*[@id='year']/option[2]")
	private WebElement yearOption;
	
	@FindBy(xpath = ".//*[@id='quarter']/option[4]")
	private WebElement quarter;
	
	public ConsultAPurchaseHistory goToSubscriptionManager(){
		subcriptionManagerLink.click();
		return this;
	}
	
	public ConsultAPurchaseHistory goToIntitution(){
		institutoAutoLink.click();
		return this;
	}
	
	
	public ConsultAPurchaseHistory goToPurchaseHistory(){
		purchaseHistoryLink.click();
		return this;
	}
	
	public ConsultAPurchaseHistory selectYearAndQuarter(){
		yearOption.click();
		quarter.click();
		return this;
	}
	
	@Override
	public ConsultAPurchaseHistory then() {
		return this;
	}

	@Override
	public ConsultAPurchaseHistory and() {
		return this;
	}

	public ConsultAPurchaseHistory and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator purchesDate() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='purchaseList']/tbody/tr[2]/td[1]"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator numberSeats() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='purchaseList']/tbody/tr[2]/td[2]"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator unused() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[4]/table"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
}
