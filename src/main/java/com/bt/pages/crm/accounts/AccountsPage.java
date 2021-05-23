package com.bt.pages.crm.accounts;

import org.openqa.selenium.By;

import com.bt.base.Page;

public class AccountsPage extends Page{
		
	
	public CreateAccountPage goToCreateAccounts() {
		
		click("createaccount_CSS");
	
	return new CreateAccountPage();
	}
	
	public void goToImportAccounts() {
		
	}
	
	public void goToImportNotes() {
		
	}
}
