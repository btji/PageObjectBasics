package com.bt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bt.base.Page;


public class HomePage extends Page{
	//Code..1 replaced with extends Page
	/*
	 * WebDriver driver;
	 * 
	 * public HomePage(WebDriver driver) { this.driver=driver; }
	 */
	
	public void goToSignUp()
	{
		driver.findElement(By.cssSelector(".zh-signup")).click();

	}	
	
	public LoginPage goToSignIn()
	{
		click("loginlink_CSS");
		
		return new LoginPage();
	}
	
	public void goToSupport()
	{
		driver.findElement(By.cssSelector(".zh-support")).click();
		
	}

	public void goToContactSales()
	{
		driver.findElement(By.cssSelector(".zh-contact")).click();
		
	}
	
	public void goToCustomers()
	{
		driver.findElement(By.cssSelector(".zh-customers")).click();
		
	}
	
	public void validateFooterLink()
	{
		driver.findElement(By.cssSelector(".common-links.common-links-js")).click();
	}
}
