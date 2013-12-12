package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteACoursesSearchInSubscriptionManager extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement subcriptionManagerLink;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[2]/td[2]/a")
	private WebElement institutoAutoLink;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[3]/a")
	private WebElement coursetSetion;
	
	@FindBy(xpath = ".//*[@id='active']")
	private WebElement limitToActiveCourse;
	
	@FindBy(xpath = ".//*[@id='subscriptionsOnly']")
	private WebElement LimitToCoursesUsingSubscriptions;
	
	@FindBy(xpath = ".//*[@id='search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = ".//*[@id='criteria']")
	private WebElement searchFields;
	
	@FindBy(xpath = ".//*[@id='coursesTable']/tbody/tr/td[1]/a")
	private WebElement course;
	
	public ExecuteACoursesSearchInSubscriptionManager goToSubscriptionManager(){
		subcriptionManagerLink.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSubscriptionManager goToIntitution(){
		institutoAutoLink.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSubscriptionManager goToCourseSetion(){
		coursetSetion.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSubscriptionManager clickSearchButton(){
		searchButton.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSubscriptionManager UncheckheckedCheckBox(){
		limitToActiveCourse.click();
		LimitToCoursesUsingSubscriptions.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSubscriptionManager searchCourse(String course){
		searchFields.click();
		searchFields.sendKeys(course);
		searchButton.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSubscriptionManager goToCourseInfo(){
		course.click();
		return this;
	}
	
	@Override
	public ExecuteACoursesSearchInSubscriptionManager then() {
		return this;
	}

	@Override
	public ExecuteACoursesSearchInSubscriptionManager and() {
		return this;
	}

	public ExecuteACoursesSearchInSubscriptionManager and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulCourse() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='coursesTable']/tbody/tr/td[1]/a"))
						.getText().trim(), "00AUTO");			
				
			}
		};
	}
	
	public Validator courseDetails() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div[1]/div/h2"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator successfulUserInstructors() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div[1]/div/div[2]/table/tbody/tr[1]/td[2]/ul/li/span[1]"))
						.getText().trim(), "Otero user qa");			
				
			}
		};
	}
	
	

}
