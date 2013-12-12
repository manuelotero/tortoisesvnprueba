package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;


public class CreateACourseWithInstructorRole extends MyProjPage{
	
	
	@FindBy(xpath = ".//*[@id='title']")
	private WebElement coursetitle;
	
	@FindBy(xpath = ".//*[@id='number']")
	private WebElement courseNumber;
	
	@FindBy(xpath = ".//*[@id='start_date']")
	private WebElement startDateField;
	
	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")
	private WebElement startDateValue;
	
	@FindBy(xpath = ".//*[@id='end_date']")
	private WebElement endDateField;
	
	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a")
	private WebElement endDateValue;
	
	@FindBy(xpath = ".//*[@id='role-2']")
	private WebElement instructorRadioButton;
	
	@FindBy(xpath = "	.//*[@id='license-1']")
	private WebElement yesRatioButton;
	
	@FindBy(xpath = ".//*[@id='institutionCode']")
	private WebElement institutionCode;
	
	@FindBy(xpath = ".//*[@id='createCourse']")
	private WebElement createCourseButton;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[3]/a")
	private WebElement courseSettings;
	
	@FindBy(xpath = ".//*[@id='delete-course']")
	private WebElement deleteCourse;
	
	@FindBy(xpath = "html/body/div[7]/div[3]/div/button[1]")
	private WebElement acceptDeleteCourse;
	
	
	public CreateACourseWithInstructorRole fillCourseLeader(String code){
		coursetitle.clear();
		coursetitle.sendKeys("Sherlock Holmes");
		courseNumber.clear();
		courseNumber.sendKeys("SKHS 01");
		startDateField.click();
		startDateValue.click();
		endDateField.click();
		endDateValue.click();
		instructorRadioButton.click();
		yesRatioButton.click();
		institutionCode.clear();
		institutionCode.sendKeys(code);
		return this;
	}
	
	public CreateACourseWithInstructorRole createCourse(){
		createCourseButton.click();
		courseSettings.click();
		deleteCourse.click();
		acceptDeleteCourse.click();
		return this;
	}
	
	public CreateACourseWithInstructorRole deleteCourse(){
		return this;
	}
	
	@Override
	public CreateACourseWithInstructorRole then() {
		return this;
	}

	@Override
	public CreateACourseWithInstructorRole and() {
		return this;
	}

	public CreateACourseWithInstructorRole and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator successfulMessageMustBePresent() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='messages']/div[2]/div[1]/div"));

				boolean thereIsAnSuccessfulMessage = successfulMessage != null;
				Assert.assertTrue(thereIsAnSuccessfulMessage);
			}
		};
	}
	

	
}
