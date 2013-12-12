package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteAnInstructorsSearchInSubscriptionManager extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement subcriptionManagerLink;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[2]/td[2]/a")
	private WebElement institutoAutoLink;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement courseInstructor;
	
	@FindBy(xpath = ".//*[@id='active']")
	private WebElement LimitToInstructorsWithActiveCourses;
	
	@FindBy(xpath = ".//*[@id='search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = ".//*[@id='criteria']")
	private WebElement searchFields;
	
	@FindBy(xpath = ".//*[@id='saInstructorsTable']/tbody/tr/td[1]/a")
	private WebElement instructor;
	
	public ExecuteAnInstructorsSearchInSubscriptionManager goToSubscriptionManager(){
		subcriptionManagerLink.click();
		return this;
	}
	
	public ExecuteAnInstructorsSearchInSubscriptionManager goToIntitution(){
		institutoAutoLink.click();
		return this;
	}
	
	public ExecuteAnInstructorsSearchInSubscriptionManager goToInstructorSetion(){
		courseInstructor.click();
		return this;
	}
	
	public ExecuteAnInstructorsSearchInSubscriptionManager clickSearchButton(){
		searchButton.click();
		return this;
	}
	
	public ExecuteAnInstructorsSearchInSubscriptionManager UncheckheckedCheckBox(){
		LimitToInstructorsWithActiveCourses.click();
		return this;
	}
	
	public ExecuteAnInstructorsSearchInSubscriptionManager searchInstructor(String course){
		searchFields.click();
		searchFields.sendKeys(course);
		searchButton.click();
		return this;
	}
	
	public ExecuteAnInstructorsSearchInSubscriptionManager goToInstructorInfo(){
		instructor.click();
		return this;
	}
	
	@Override
	public ExecuteAnInstructorsSearchInSubscriptionManager then() {
		return this;
	}

	@Override
	public ExecuteAnInstructorsSearchInSubscriptionManager and() {
		return this;
	}

	public ExecuteAnInstructorsSearchInSubscriptionManager and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulCourse() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='saInstructorsTable']/tbody/tr/td[1]/a"))
						.getText().trim(), "qa, Otero user");			
				
			}
		};
	}
	
	public Validator courseDetails() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[1]/h2"));

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
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[1]/div/table/tbody/tr[1]/td[2]/span"))
						.getText().trim(), "Otero user qa");			
				
			}
		};
	}

}
