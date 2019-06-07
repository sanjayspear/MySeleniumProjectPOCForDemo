package com.vivek.facebook.pom.util;

import java.util.Hashtable;

public class FBConstants {
	public static final boolean GRID_RUN=true;
	
	//paths
	public static final String CHROME_DRIVER_EXE="F:\\chromedriver.exe";
	
	
	// locators
	public static final String LOGIN_USERNAME = "//*[@id='email']";
	public static final String LOGIN_PASSWORD = "//*[@id='pass']";
	public static final String PROFILEPAGE_LINK = "//*[@id='pagelet_welcome_box']/ul/li[1]/div/a";
	public static final String NAVIGATION_LABEL = "html/body/div[1]/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div[2]/div/div/a";
	public static final String SETTINGS_LINK = "//span[text()='Settings']";
	public static final String PASSWORD_CHANGE = "//*[@id='SettingsPage_Content']/ul/li[4]/a";
	public static final String OLD_PASSWORD = "//*[@id='password_old']";
	public static final String NEW_PASSWORD = "//*[@id='password_new']";
	public static final String CONFIRM_CHANGE = "//*[@id='password_confirm']";
	public static final String SAVE_CHANGES = "//label[@class='submit uiButton uiButtonConfirm']";
	public static final String KILL_SESSION = "//input[@value='kill_sessions']";
	public static final String CONTINUE_PASSWORD_CHANGE_BUTTON = "//button[text()='Continue']";
	
	// URLs-prod
	public static final String PROD_HOMEPAGE_URL = "http://facebook.com";
	public static final String PROD_USERNAME = "joglekar.vivek@gmail.com";
	public static final String PROD_PASSWORD = "vivek@789";
	
	// URLs-uat
	public static final String UAT_HOMEPAGE_URL = "http://uat.facebook.com";
	public static final String UAT_USERNAME = "joglekar.vivek@gmail.com";
	public static final String UAT_PASSWORD = "vivek";
		
	
	public static final String ENV="PROD"; //PROD, UAT,SAT 
			

	//paths
	public static final String REPORTS_PATH = "D:\\reports\\";
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";
	
	public static Hashtable<String,String> table;
	
	public static Hashtable<String,String> getEnvDetails(){
		if(table==null){
			table = new Hashtable<String,String>();
			if(ENV.equals("PROD")){
				table.put("url", PROD_HOMEPAGE_URL);
				table.put("username", PROD_USERNAME);
				table.put("password", PROD_PASSWORD);
			}else if(ENV.equals("UAT")){
				table.put("url", UAT_HOMEPAGE_URL);
				table.put("username", UAT_USERNAME);
				table.put("password", UAT_PASSWORD);
			}
			
		}
		return table;
		 
	}




	


	


	




	



	

}
