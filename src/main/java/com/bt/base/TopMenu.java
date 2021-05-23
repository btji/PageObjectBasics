package com.bt.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bt.pages.crm.accounts.AccountsPage;
import com.mongodb.gridfs.CLI;

public class TopMenu {
	
	/*
	 * HomePage HAS-A TopMenu
	 * AccountsPage HAS-A TopMenu...etc
	 * 
	 * Wherever we have HAS-A relationship.. Encapsulation takes place.
	 * 
	 */
WebDriver driver;

public TopMenu(WebDriver driver) {
	this.driver=driver;
}
	
	public void goToHome() {
		
	}
	public void goToLeads() {
		
	}

	public void goToContacts() {
		
	}

	public AccountsPage goToAccounts() {
//		Page.driver.findElement(By)
		Page.click("acountstab_XPATH");
		return new AccountsPage();
	
	}

	public void goToDeals() {
		
	}

	public void goToReports() {
		
	}

	public void signOut() {
		
	}

	

}
