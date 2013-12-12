package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class UpdateTheCourseDetails extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='activeCourses']/tbody/tr[2]/td[1]/div/div[1]")
	private WebElement autoInstructorCourseLink;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[3]/a")
	private WebElement courseSetting;
	
	@FindBy(xpath = ".//*[@id='title']")
	private WebElement title;
	
	@FindBy(xpath = ".//*[@id='number']")
	private WebElement number;
	
	@FindBy(xpath = ".//*[@id='start_date']")
	private WebElement startDate;
	
	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")
	private WebElement startDateBefore;
	
	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a")
	private WebElement startDateAfter;
	
	@FindBy(xpath = ".//*[@id='end_date']")
	private WebElement endDate;

	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[6]/a")
	private WebElement endDateBefore;
	
	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[5]/a")
	private WebElement endDateAfter;
	
	@FindBy(xpath = ".//*[@id='timezone']/option[1]")
	private WebElement timezoneBefore;
	
	@FindBy(xpath = ".//*[@id='timezone']/option[2]")
	private WebElement timezoneAfter;
	
	@FindBy(xpath = ".//*[@id='createCourse']")
	private WebElement saveCourseButton;

	public UpdateTheCourseDetails goToCoruse(){
		autoInstructorCourseLink.click();
		return this;
	}
	
	public UpdateTheCourseDetails goToCoruseSetting(){
		courseSetting.click();
		return this;
	}
	
	public UpdateTheCourseDetails editCourseDetails(String name,String number, boolean a){
		title.clear();
		title.sendKeys(name);
		this.number.clear();
		this.number.sendKeys(number);
		startDate.click();
		if(a){
			startDateAfter.click();
		}else{
			startDateBefore.click();
		}
		endDate.click();
		if(a){
			endDateAfter.click();
			timezoneAfter.click();
		}else{
			endDateBefore.click();
			timezoneBefore.click();
		}
		return this;
	}
	
	public UpdateTheCourseDetails saveCourseDetails(){
		saveCourseButton.click();
		return this;
	}
	
	@Override
	public UpdateTheCourseDetails then() {
		return this;
	}

	@Override
	public UpdateTheCourseDetails and() {
		return this;
	}

	public UpdateTheCourseDetails and(UI uiInstance) {
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
