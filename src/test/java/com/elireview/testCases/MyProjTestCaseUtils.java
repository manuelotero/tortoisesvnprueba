package com.elireview.testCases;

import org.testng.annotations.AfterClass;

import com.elireview.utils.UI;
import com.ts.commons.TestCaseUtil;

public class MyProjTestCaseUtils extends TestCaseUtil{
	
	protected UI uiInstance;

	public MyProjTestCaseUtils(String browserType) {
		uiInstance = new UI(browserType);
	}

	@AfterClass
	public void after() {
		uiInstance.getDriver().quit();
	}
	

}
