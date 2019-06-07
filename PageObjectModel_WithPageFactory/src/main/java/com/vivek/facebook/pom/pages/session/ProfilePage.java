package com.vivek.facebook.pom.pages.session;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vivek.facebook.pom.base.BasePage;

public class ProfilePage extends BasePage{

	
	public ProfilePage(WebDriver driver,ExtentTest test){
		super(driver,test);
	}
	
	
	public void verifyProfile() {
		test.log(LogStatus.INFO, "Verifying profile");
	}


}
