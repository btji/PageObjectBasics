package com.bt.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bt.base.Page;
import com.bt.pages.HomePage;
import com.bt.pages.LoginPage;
import com.bt.pages.ZohoAppPage;
import com.bt.pages.crm.CRMHomePage;
import com.bt.pages.crm.accounts.AccountsPage;
import com.bt.pages.crm.accounts.CreateAccountPage;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		/* Code2..Moved to Page superclass of all the pages.
		 * 
		 * 
		 * System.setProperty("webdriver.chrome.driver",
		 * System.getProperty("user.dir")+"\\resources\\executables\\chromedriver.exe");
		 * WebDriver driver=new ChromeDriver(); driver.get("https://www.zoho.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 */
		  
		//In real-time you will not gonna find any driver instance in your test cases..
		//Below how the test cases looks like.
		
		/* Code3.. after page Object creation. replaced with below code
		 * 
		 * HomePage home = new HomePage(); home.goToSignIn(); LoginPage login=new
		 * LoginPage(); login.doLogin("lawlessbt@gmail.com", "Admin@0810");
		 * 
		 * ZohoAppPage zap=new ZohoAppPage(); zap.goToCRM();
		 * 
		 * Page.menu.goToAccounts();
		 * 
		 * AccountsPage account=new AccountsPage(); account.goToCreateAccounts();
		 * CreateAccountPage cap=new CreateAccountPage(); cap.createAccount("Brijesh");
		 */				  
		
		  HomePage home = new HomePage(); 
		  LoginPage lp= home.goToSignIn(); 
		  ZohoAppPage zap=lp.doLogin("brijeshtripathi.epri@gmail.com", "Meer@1210");
		  
		  zap.goToCRM();		  
		  AccountsPage account=Page.menu.goToAccounts();		  
		  CreateAccountPage cap= account.goToCreateAccounts();
		  cap.createAccount("Brijesh");
	}
}
