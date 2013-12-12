package com.elireview.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.PageFactory;

import com.elireview.pages.ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup;
import com.elireview.pages.ConsultAPurchaseHistory;
import com.elireview.pages.ConsultTheSubscriptionGroupDetailView;
import com.elireview.pages.ConsultUsageStatsAndGroupsInformationInSubscriptionManager;
import com.elireview.pages.ConsultsAPurchaseHistoryInSystemAdministrator;
import com.elireview.pages.ConsultsAUsageStatsGroupsInformationInSystemAdministrator;
import com.elireview.pages.CreateACourseWithInstructorRole;
import com.elireview.pages.CreateACustomerSupportAdministratorRole;
import com.elireview.pages.CreateARegisterPurchases;
import com.elireview.pages.CreateASubscriptionGroupAndAccessCode;
import com.elireview.pages.ExecuteACodeSearchInCustomerSupport;
import com.elireview.pages.ExecuteACourseSearchInCustomerSupport;
import com.elireview.pages.ExecuteACoursesSearchInSubscriptionManager;
import com.elireview.pages.ExecuteACoursesSearchInSystemAdministrator;
import com.elireview.pages.ExecuteAStudentsSearchInSubscriptionManager;
import com.elireview.pages.ExecuteAUserSearchInCustomerSupport;
import com.elireview.pages.ExecuteAnInstructorsSearchInSubscriptionManager;
import com.elireview.pages.ExecuteAnStudentsSearchInSystemAdministrator;
import com.elireview.pages.LoginPage;
import com.elireview.pages.SignUpPage;
import com.elireview.pages.UpdateTheCourseDetails;
import com.elireview.pages.UserCanEditTheAccountSettings;
import com.ts.commons.ChromeDriver;
import com.ts.commons.FirefoxDriver;
import com.ts.commons.InternetExplorerDriver;

public class UI {

	private WebDriver driver;

	public UI(String browserType) {

		switch (browserType) {
		case BrowserType.CHROME:
			driver = ChromeDriver.createInstance();
			break;
		case BrowserType.FIREFOX:
			driver = new FirefoxDriver();
			break;
		case BrowserType.IE:
			driver = InternetExplorerDriver.createInstance();
			break;

		default:
			driver = null;
			break;
		}
		driver.manage().window().maximize();
	}

	public LoginPage getLoginPage() {
		driver.get(Constant.url);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		return loginPage;
	}
	
	public SignUpPage signUpPage() {
		driver.get(Constant.url);
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		return signUpPage;
	}
	
	public UserCanEditTheAccountSettings userCanEditTheAccountSettings() {
		driver.get(Constant.url);
		UserCanEditTheAccountSettings userCanEditTheAccountSettings = PageFactory.initElements(driver, UserCanEditTheAccountSettings.class);
		return userCanEditTheAccountSettings;
	}
	
	public CreateACourseWithInstructorRole createACourse() {
		driver.get(Constant.url);
		CreateACourseWithInstructorRole createACourse = PageFactory.initElements(driver, CreateACourseWithInstructorRole.class);
		return createACourse;
	}
	
	public UpdateTheCourseDetails updateTheCourseDetails() {
		driver.get(Constant.url);
		UpdateTheCourseDetails updateTheCourseDetails = PageFactory.initElements(driver, UpdateTheCourseDetails.class);
		return updateTheCourseDetails;
	}
	
	public CreateASubscriptionGroupAndAccessCode createASubscriptionGroupAndAccessCode() {
		driver.get(Constant.url);
		CreateASubscriptionGroupAndAccessCode createASubscriptionGroupAndAccessCode = PageFactory.initElements(driver, CreateASubscriptionGroupAndAccessCode.class);
		return createASubscriptionGroupAndAccessCode;
	}
	
	public ConsultAPurchaseHistory consultAPurchaseHistor() {
		driver.get(Constant.url);
		ConsultAPurchaseHistory consultAPurchaseHistory = PageFactory.initElements(driver, ConsultAPurchaseHistory.class);
		return consultAPurchaseHistory;
	}
	
	public CreateARegisterPurchases createARegisterPurchases() {
		driver.get(Constant.url);
		CreateARegisterPurchases createARegisterPurchases = PageFactory.initElements(driver, CreateARegisterPurchases.class);
		return createARegisterPurchases;
	}
	
	public CreateACustomerSupportAdministratorRole createACustomerSupportAdministratorRole() {
		driver.get(Constant.url);
		CreateACustomerSupportAdministratorRole createACustomerSupportAdministratorRole = PageFactory.initElements(driver, CreateACustomerSupportAdministratorRole.class);
		return createACustomerSupportAdministratorRole;
	}
	
	public ExecuteAUserSearchInCustomerSupport executeAUserSearchInCustomerSupport() {
		driver.get(Constant.url);
		ExecuteAUserSearchInCustomerSupport executeAUserSearchInCustomerSupport = PageFactory.initElements(driver, ExecuteAUserSearchInCustomerSupport.class);
		return executeAUserSearchInCustomerSupport;
	}
	
	public ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup changeOrDisableCodeAccess() {
		driver.get(Constant.url);
		ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup changeOrDisableCodeAccess = PageFactory.initElements(driver, ChangeOrDisableCodeAccessForAGroupInSubscriptionGroup.class);
		return changeOrDisableCodeAccess;
	}	
	
	public ExecuteACourseSearchInCustomerSupport executeACourseSearch() {
		driver.get(Constant.url);
		ExecuteACourseSearchInCustomerSupport executeACourseSearch = PageFactory.initElements(driver, ExecuteACourseSearchInCustomerSupport.class);
		return executeACourseSearch;
	}
	
	public ConsultTheSubscriptionGroupDetailView consultTheSubscriptionGroupDetailView() {
		driver.get(Constant.url);
		ConsultTheSubscriptionGroupDetailView consultTheSubscriptionGroupDetailView = PageFactory.initElements(driver, ConsultTheSubscriptionGroupDetailView.class);
		return consultTheSubscriptionGroupDetailView;
	}
	
	public ExecuteACodeSearchInCustomerSupport executeACodeSearch() {
		driver.get(Constant.url);
		ExecuteACodeSearchInCustomerSupport executeACodeSearch = PageFactory.initElements(driver, ExecuteACodeSearchInCustomerSupport.class);
		return executeACodeSearch;
	}
	
	public ConsultsAUsageStatsGroupsInformationInSystemAdministrator consultsAUsageStatsGroupsInformation() {
		driver.get(Constant.url);
		ConsultsAUsageStatsGroupsInformationInSystemAdministrator consultsAUsageStatsGroupsInformation = PageFactory.initElements(driver, ConsultsAUsageStatsGroupsInformationInSystemAdministrator.class);
		return consultsAUsageStatsGroupsInformation;
	}
	
	public ExecuteAStudentsSearchInSubscriptionManager executeAStudentsSearchInSubscriptionManager() {
		ExecuteAStudentsSearchInSubscriptionManager executeAStudentsSearchInSubscriptionManager = PageFactory.initElements(driver, ExecuteAStudentsSearchInSubscriptionManager.class);
		return executeAStudentsSearchInSubscriptionManager;
	}
	
	public ExecuteACoursesSearchInSubscriptionManager executeACoursesSearchInSubscriptionManager() {
		ExecuteACoursesSearchInSubscriptionManager executeACoursesSearchInSubscriptionManager = PageFactory.initElements(driver, ExecuteACoursesSearchInSubscriptionManager.class);
		return executeACoursesSearchInSubscriptionManager;
	}
	
	public ExecuteAnInstructorsSearchInSubscriptionManager executeAnInstructorsSearchIn() {
		ExecuteAnInstructorsSearchInSubscriptionManager executeAnInstructorsSearchIn = PageFactory.initElements(driver, ExecuteAnInstructorsSearchInSubscriptionManager.class);
		return executeAnInstructorsSearchIn;
	}
	
	public ConsultUsageStatsAndGroupsInformationInSubscriptionManager consultUsageStatsAndGroupsInformation() {
		ConsultUsageStatsAndGroupsInformationInSubscriptionManager consultUsageStatsAndGroupsInformation = PageFactory.initElements(driver, ConsultUsageStatsAndGroupsInformationInSubscriptionManager.class);
		return consultUsageStatsAndGroupsInformation;
	}
	
	public ExecuteAnStudentsSearchInSystemAdministrator executeAnStudentsSearchInSystemAdministrator() {
		ExecuteAnStudentsSearchInSystemAdministrator executeAnStudentsSearchInSystemAdministrator = PageFactory.initElements(driver, ExecuteAnStudentsSearchInSystemAdministrator.class);
		return executeAnStudentsSearchInSystemAdministrator;
	}
	
	public ExecuteACoursesSearchInSystemAdministrator executeACoursesSearchInSystemAdministrator() {
		ExecuteACoursesSearchInSystemAdministrator executeACoursesSearchInSystemAdministrator = PageFactory.initElements(driver, ExecuteACoursesSearchInSystemAdministrator.class);
		return executeACoursesSearchInSystemAdministrator;
	}
	
	public ConsultsAPurchaseHistoryInSystemAdministrator consultsAPurchaseHistoryInSystemAdministrator() {
		ConsultsAPurchaseHistoryInSystemAdministrator consultsAPurchaseHistoryInSystemAdministrator = PageFactory.initElements(driver, ConsultsAPurchaseHistoryInSystemAdministrator.class);
		return consultsAPurchaseHistoryInSystemAdministrator;
	}
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}