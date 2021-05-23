package com.bt.testcases;

import static org.testng.Assert.fail;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bt.base.Page;
import com.bt.pages.ZohoAppPage;
import com.bt.pages.crm.accounts.AccountsPage;
import com.bt.pages.crm.accounts.CreateAccountPage;
import com.bt.utilities.Utilities;

public class CreateAccountTest {

	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) {
		
		  ZohoAppPage zp=new ZohoAppPage();
		  zp.goToCRM();		  
		  AccountsPage account=Page.menu.goToAccounts();		  
		  CreateAccountPage cap= account.goToCreateAccounts();
		  cap.createAccount(data.get("accountname"));
		  
//		  Assert.fail("create account test fail");
		
	}
}
