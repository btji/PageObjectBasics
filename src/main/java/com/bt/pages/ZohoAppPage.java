package com.bt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bt.base.Page;
import com.bt.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page{
	
	//Code..1 replaced with extends Page
	/*
	 * WebDriver driver;
	 * 
	 * public ZohoAppPage(WebDriver driver) { this.driver=driver; }
	 */	
		public void goToBooks() {
			driver.findElement(By.cssSelector("._logo-books._logo-x96.zod-app-logo")).click();
		}
		
		public void goToCalender() {
			driver.findElement(By.cssSelector("._logo-calendar._logo-x96.zod-app-logo")).click();			
		}

		public CRMHomePage goToCRM() {
			click("crmlink_CSS");			
			return new CRMHomePage();
		}
		
}
