package com.bt.pages.crm.accounts;


import com.bt.base.Page;

public class CreateAccountPage extends Page{
		
	public void createAccount(String accountName) {
		 
		 type("accountname_XPATH", accountName);
	}
}
