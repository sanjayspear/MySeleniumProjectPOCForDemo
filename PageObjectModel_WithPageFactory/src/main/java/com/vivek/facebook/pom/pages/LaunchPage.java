package com.vivek.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vivek.facebook.pom.base.BasePage;
import com.vivek.facebook.pom.util.FBConstants;

public class LaunchPage extends BasePage{
	
	
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver,test);
		
		
		
	}
	
	
	public LoginPage gotoLoginPage(){
		// log
		test.log(LogStatus.INFO, "Opening the url - "+FBConstants.getEnvDetails().get("url"));
		driver.get(FBConstants.getEnvDetails().get("url"));
		test.log(LogStatus.PASS, "URL Opened - "+FBConstants.getEnvDetails().get("url"));
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

	

}
