package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteACoursesSearchInSystemAdministrator extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[7]/a")
	private WebElement SystemAdministratorLink;
	
	@FindBy(xpath = ".//*[@id='institutionUsageReport']")
	private WebElement InstitutionUsageReport;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-header-44']/span")
	private WebElement testInstitution1;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-panel-44']/a")
	private WebElement testDepartment1;
	
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[3]/a")
	private WebElement CoursessectionLink;
	
	@FindBy(xpath = ".//*[@id='active']")
	private WebElement LimitToActiveCourses;
	
	@FindBy(xpath = ".//*[@id='subscriptionsOnly']")
	private WebElement LimitToCoursesUsingSubscriptions;
	
	@FindBy(xpath = ".//*[@id='search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = ".//*[@id='criteria']")
	private WebElement searchFields;
	
	@FindBy(xpath = ".//*[@id='coursesTable']/tbody[2]/tr[1]/td[1]/a")
	private WebElement courseLink;
	
	public ExecuteACoursesSearchInSystemAdministrator goToSystemAdministrator(){
		SystemAdministratorLink.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSystemAdministrator goToInstitutionUsageReport(){
		InstitutionUsageReport.click();
		return this;
	}
	
	
	public ExecuteACoursesSearchInSystemAdministrator goToTestDepartment1(){
		testInstitution1.click();
		testDepartment1.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSystemAdministrator goToCourseSection(){
		CoursessectionLink.click();
		return this;
	}
	
	public ExecuteACoursesSearchInSystemAdministrator searchCourse(String student){
		LimitToCoursesUsingSubscriptions.click();
		LimitToActiveCourses.click();
		searchFields.sendKeys(student);
		searchButton.click();
		return this;
	}
	

	public ExecuteACoursesSearchInSystemAdministrator goToCourseInfo(){
		courseLink.click();
		return this;
	}
	
	@Override
	public ExecuteACoursesSearchInSystemAdministrator then() {
		return this;
	}

	@Override
	public ExecuteACoursesSearchInSystemAdministrator and() {
		return this;
	}

	public ExecuteACoursesSearchInSystemAdministrator and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator CourseRoster() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='rosterList']/tbody/tr[2]/td[1]/a"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator Coursedetails() {
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

	
	public Validator successfulUserNameInstructor() {
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
