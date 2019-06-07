package com.vivek.facebook.pom.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vivek.facebook.pom.base.BasePage;
import com.vivek.facebook.pom.pages.session.LandingPage;
import com.vivek.facebook.pom.util.FBConstants;

public class LoginPage extends BasePage{
	
	@FindBy(xpath=FBConstants.LOGIN_USERNAME)
	public WebElement email;
	
	@FindBy(xpath=FBConstants.LOGIN_PASSWORD)
	public WebElement password;
	
	
	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	
	
	
	
	
	public Object doLogin(String usName,String pWord){
		test.log(LogStatus.INFO, "Logging in -"+usName+"/"+pWord);
		email.sendKeys(usName);
		password.sendKeys(pWord);
		password.sendKeys(Keys.ENTER);
		// logic - validate
		boolean loginSuccess=isElementPresent(FBConstants.PROFILEPAGE_LINK);
		
		if(loginSuccess){
			test.log(LogStatus.INFO, "Login Success");
			LandingPage landingPage = new LandingPage(driver,test);
			PageFactory.initElements(driver, landingPage);
			return landingPage;
		}
		else{
			test.log(LogStatus.INFO, "Login Not Success");
			LoginPage loginPage = new LoginPage(driver,test);
			PageFactory.initElements(driver, loginPage);
			return loginPage;
		}

		
	}
	

	
	

}
