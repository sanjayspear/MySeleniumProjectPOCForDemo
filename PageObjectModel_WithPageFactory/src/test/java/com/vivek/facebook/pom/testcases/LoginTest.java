package com.vivek.facebook.pom.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vivek.facebook.pom.pages.LaunchPage;
import com.vivek.facebook.pom.pages.LoginPage;
import com.vivek.facebook.pom.pages.session.LandingPage;
import com.vivek.facebook.pom.testcases.base.BaseTest;
import com.vivek.facebook.pom.util.DataUtil;
import com.vivek.facebook.pom.util.FBConstants;

public class LoginTest extends BaseTest{
	String testCaseName="LoginTest";
	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data){
		test = extent.startTest("Login Test");
		
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(FBConstants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		
		test.log(LogStatus.INFO, "Starting login test");
		test.log(LogStatus.INFO, "Opening browser");
		init(data.get("Browser"));
		
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.takeScreenShot();
		test.log(LogStatus.INFO, "Logging in");
		Object page=loginPage.doLogin(data.get("Username"), data.get("Password"));
		String actualResult="";
		// if i am logged in
		if(page instanceof LandingPage)
			actualResult="Success";
		else
			actualResult="Unsuccessful";
		
		if(!actualResult.equals(data.get("ExpectedResult"))){
			
			reportFailure("failure message");
		}
		
		test.log(LogStatus.PASS, "Login Test Passed");
		
		
	}
	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
	

}
