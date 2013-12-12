package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteAnStudentsSearchInSystemAdministrator extends MyProjPage{

	@FindBy(xpath = ".//*[@id='subMenu']/div[7]/a")
	private WebElement SystemAdministratorLink;
	
	@FindBy(xpath = ".//*[@id='institutionUsageReport']")
	private WebElement InstitutionUsageReport;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-header-44']/span")
	private WebElement testInstitution1;
	
	@FindBy(xpath = ".//*[@id='ui-accordion-accordion-panel-44']/a")
	private WebElement testDepartment1;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[7]/a")
	private WebElement StudentsLink;
	
	@FindBy(xpath = ".//*[@id='active']")
	private WebElement LimitToStudentsEnrolledInActiveCoursesCheckbox;
	
	@FindBy(xpath = ".//*[@id='criteria']")
	private WebElement searchFields;
	
	@FindBy(xpath = ".//*[@id='search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = ".//*[@id='studentsTable']/tbody/tr[1]/td[1]/a")
	private WebElement studentLink;
	
	public ExecuteAnStudentsSearchInSystemAdministrator goToSystemAdministrator(){
		SystemAdministratorLink.click();
		return this;
	}
	
	public ExecuteAnStudentsSearchInSystemAdministrator goToInstitutionUsageReport(){
		InstitutionUsageReport.click();
		return this;
	}
	
	
	public ExecuteAnStudentsSearchInSystemAdministrator goToTestDepartment1(){
		testInstitution1.click();
		testDepartment1.click();
		return this;
	}
	
	public ExecuteAnStudentsSearchInSystemAdministrator goToStudentsSection(){
		StudentsLink.click();
		return this;
	}
	
	public ExecuteAnStudentsSearchInSystemAdministrator searchStudent(String student){
		LimitToStudentsEnrolledInActiveCoursesCheckbox.click();
		searchFields.sendKeys(student);
		searchButton.click();
		return this;
	}
	

	public ExecuteAnStudentsSearchInSystemAdministrator goToStudentInfo(){
		studentLink.click();
		return this;
	}
	
	@Override
	public ExecuteAnStudentsSearchInSystemAdministrator then() {
		return this;
	}

	@Override
	public ExecuteAnStudentsSearchInSystemAdministrator and() {
		return this;
	}

	public ExecuteAnStudentsSearchInSystemAdministrator and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator CoursesTakenby() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='takenCoursesList']"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	
	public Validator Userdetails() {
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

	
	public Validator successfulUserName() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[1]/div/table/tbody/tr[1]/td[2]/span"))
						.getText().trim(), "Manuel Otero");			
				
			}
		};
	}
	
	
}
