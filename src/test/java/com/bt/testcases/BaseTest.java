package com.bt.testcases;

import org.testng.annotations.AfterSuite;

import com.bt.base.Page;


public class BaseTest{
	
	@AfterSuite
	public void tearDown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Page.quit();
	}
}
