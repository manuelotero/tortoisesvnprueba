package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteACodeSearchInCustomerSupport extends MyProjPage{
	@FindBy(xpath=".//*[@id='subMenu']/div[9]/a")
	private WebElement customerSupport;
	
	@FindBy(xpath=".//*[@id='subMenu']/div[5]/a")
	private WebElement codeLink;
	
	@FindBy(xpath=".//*[@id='criteria']")
	private WebElement codeSearchName;
	
	@FindBy(xpath=".//*[@id='search']")
	private WebElement searchCodeButton;
	
	@FindBy(xpath=".//*[@id='codesTable']/tbody/tr/td[1]/a")
	private WebElement result;
	
	public ExecuteACodeSearchInCustomerSupport goToCustomerSupport(){
		customerSupport.click();
		return this;
	}
	
	public ExecuteACodeSearchInCustomerSupport goToCourseSearch(){
		codeLink.click();
		return this;
	}
	
	public ExecuteACodeSearchInCustomerSupport executeACourseSearch(){
		codeSearchName.clear();
		codeSearchName.sendKeys("HNMCM-SCUUZ-FBWGZ-KBCHZ");
		searchCodeButton.click();
		return this;
	}
	
	public ExecuteACodeSearchInCustomerSupport goToCourse(){
		result.click();
		return this;
	}
	
	
	@Override
	public ExecuteACodeSearchInCustomerSupport then() {
		return this;
	}

	@Override
	public ExecuteACodeSearchInCustomerSupport and() {
		return this;
	}

	public ExecuteACodeSearchInCustomerSupport and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	
	public Validator result() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver().findElement(By.xpath(".//*[@id='codesTable']/tbody/tr/td[1]/a")).getText().trim(), "HNMCM-SCUUZ-FBWGZ-KBCHZ");			
				
			}
		};
	}
	
	public Validator courseID() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver().findElement(By.xpath(".//*[@id='group']/tbody/tr[2]/td[2]")).getText().trim(), "Subscription Code");			
				
			}
		};
	}


}
