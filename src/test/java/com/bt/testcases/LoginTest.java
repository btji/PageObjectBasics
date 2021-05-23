package com.bt.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bt.pages.HomePage;
import com.bt.pages.LoginPage;
import com.bt.pages.ZohoAppPage;
import com.bt.utilities.Utilities;



public class LoginTest extends BaseTest{
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) {
			
		  HomePage home = new HomePage(); 
		  LoginPage lp= home.goToSignIn(); 
		  lp.doLogin(data.get("username"), data.get("pasword"));
		  
//		  Assert.fail("login test failed..");
	
	}
}
