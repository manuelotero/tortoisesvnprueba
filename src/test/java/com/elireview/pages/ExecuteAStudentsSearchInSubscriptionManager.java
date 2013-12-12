package com.elireview.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elireview.utils.UI;
import com.ts.commons.Validator;

public class ExecuteAStudentsSearchInSubscriptionManager extends MyProjPage{
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[5]/a")
	private WebElement subcriptionManagerLink;
	
	@FindBy(xpath = ".//*[@id='mainContentCenter']/div[3]/div/table/tbody/tr[2]/td[2]/a")
	private WebElement institutoAutoLink;
	
	@FindBy(xpath = ".//*[@id='subMenu']/div[7]/a")
	private WebElement studentSetion;
	
	@FindBy(xpath = ".//*[@id='search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = ".//*[@id='active']")
	private WebElement checkBox;
	
	@FindBy(xpath = ".//*[@id='criteria']")
	private WebElement searchFields;
	
	@FindBy(xpath = ".//*[@id='studentsTable']/tbody/tr[1]/td[1]/a")
	private WebElement student;
	
	public ExecuteAStudentsSearchInSubscriptionManager goToSubscriptionManager(){
		subcriptionManagerLink.click();
		return this;
	}
	
	public ExecuteAStudentsSearchInSubscriptionManager goToIntitution(){
		institutoAutoLink.click();
		return this;
	}
	
	
	public ExecuteAStudentsSearchInSubscriptionManager goToStudentSetion(){
		studentSetion.click();
		return this;
	}
	
	public ExecuteAStudentsSearchInSubscriptionManager clickSearchButton(){
		searchButton.click();
		return this;
	}
	
	public ExecuteAStudentsSearchInSubscriptionManager checkedCheckBox(){
		checkBox.click();
		return this;
	}
	
	public ExecuteAStudentsSearchInSubscriptionManager searchStudent(String student){
		searchFields.click();
		searchFields.sendKeys(student);
		searchButton.click();
		return this;
	}
	
	public ExecuteAStudentsSearchInSubscriptionManager goToStudentInfo(){
		student.click();
		return this;
	}
	
	@Override
	public ExecuteAStudentsSearchInSubscriptionManager then() {
		return this;
	}

	@Override
	public ExecuteAStudentsSearchInSubscriptionManager and() {
		return this;
	}

	public ExecuteAStudentsSearchInSubscriptionManager and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}
	
	public Validator studenInfo() {
		return new Validator() {
			@Override
			public void Validate() {
				WebElement successfulMessage = uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[1]/h2/span"));

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
						.findElement(By.xpath(".//*[@id='takenCoursesList']"));

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
						.findElement(By.xpath(".//*[@id='mainContentCenter']/div[3]/div/div[1]/div/table/tbody/tr[2]/td[2]/span"))
						.getText().trim(), "Manuel");			
				
			}
		};
	}
	
	public Validator successfulCourse() {
		return new Validator() {
			@Override
			public void Validate() {
							
				Assert.assertEquals(uiInstance.getDriver()
						.findElement(By.xpath(".//*[@id='takenCoursesList']/tbody/tr[2]/td[1]/a"))
						.getText().trim(), "00AUTO");			
				
			}
		};
	}

}
