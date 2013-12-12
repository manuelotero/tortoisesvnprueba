package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteACourseSearchInCustomerSupport extends MyProjPage {
	
	@FindBy(xpath=".//*[@id='subMenu']/div[9]/a")
	private WebElement customerSupport;
	
	@FindBy(xpath=".//*[@id='subMenu']/div[3]/a")
	private WebElement courseLink;
	
	@FindBy(xpath=".//*[@id='criteria']")
	private WebElement courseSearchName;
	
	@FindBy(xpath=".//*[@id='search']")
	private WebElement searchCourseButton;
	
	@FindBy(xpath=".//*[@id='usersTable']/tbody/tr/td[1]/a")
	private WebElement result;
	
	public ExecuteACourseSearchInCustomerSupport goToCustomerSupport(){
		customerSupport.click();
		return this;
	}
	
	public ExecuteACourseSearchInCustomerSupport goToCourseSearch(){
		courseLink.click();
		return this;
	}
	
	public ExecuteACourseSearchInCustomerSupport executeACourseSearch(){
		courseSearchName.clear();
		courseSearchName.sendKeys("auto");
		searchCourseButton.click();
		return this;
	}
	
	public ExecuteACourseSearchInCustomerSupport goToCourse(){
		result.click();
		return this;
	}
	
	
	@Override
	public ExecuteACourseSearchInCustomerSupport then() {
		return this;
	}

	@Override
	public ExecuteACourseSearchInCustomerSupport and() {
		return this;
	}

	public ExecuteACourseSearchInCustomerSupport and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	
	public Validator result() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='usersTable']/tbody/tr/td[1]/a")).getText()
						.trim(), "Auto-course (00-AC)");			
				
			}
		};
	}
	
	public Validator courseID() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[2]/table/tbody/tr[2]/td[2]"))
						.getText().trim(), "1073");			
				
			}
		};
	}

}
