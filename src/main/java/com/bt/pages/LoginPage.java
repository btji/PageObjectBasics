package com.bt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bt.base.Page;

public class LoginPage extends Page{
	
	//Code..1 replaced with extends Page
	/*
	 * WebDriver driver;
	 * 
	 * public LoginPage(WebDriver driver) { this.driver=driver; }
	 */

	public ZohoAppPage doLogin(String username, String password) {
				
		type("email_XPATH", username);
		click("next_XPATH");
		type("pwd_XPATH",password);
		click("submit_XPATH");
		
//		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys(username);
//		driver.findElement(By.xpath("//*[@id='login']/button")).click();
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
//		driver.findElement(By.xpath("//*[@id='login']/button")).click();

		return new ZohoAppPage();
	}
	
	public void goToContactSales() {
		
	}
	
}
