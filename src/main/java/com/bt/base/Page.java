package com.bt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.bt.utilities.ExcelReader;
import com.bt.utilities.ExtentManager;
import com.bt.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page {
	
	/*
	 * HomePage IS-A page
	 * LoginPage IS-A page  etc...
	 * 
	 * Wherever we have IS-A relationship then Inheritance comes into the picture.
	 * Now we are initializing WebDriver in Page class's constructor.
	 * 
	 */

	public static WebDriver driver;			//if you are making WebDriver static means now each	
	
	
	public static Properties config=new Properties();
	public static Properties or=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
//	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\resources\\excel\\testdata.xlsx");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep=ExtentManager.getIntance();
	public static ExtentTest test;
	public static String browser;
	 
	public static TopMenu menu;

	
	
	public Page() {
		
		if(driver==null)
		{
			//Loading all the properties file....
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded....");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			or.load(fis);
			log.debug("OR file loaded....");

		} catch (IOException e) {
			e.printStackTrace();
		}		
			
		
		//Jenkins browser filter configuration...
		if(System.getenv("browser")!=null && System.getenv("browser").isEmpty()) {
			browser= System.getenv("browser");
		}else
		{
			browser=config.getProperty("browser");
		}		
		config.setProperty("browser", browser);
		
		
		
		
		if(config.getProperty("browser").equals("chrome")) {
			
			  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\executables\\chromedriver.exe");				  
			  Map<String,Object> prefs=new HashMap<String,Object>();
			  prefs.put("profile.default_content_setting_values.notifications", 2);
			  prefs.put("credentials_enable_service", false);
			  prefs.put("profile.password_manager_enabled", false);
			  ChromeOptions options=new ChromeOptions();
			  options.setExperimentalOption("prefs", prefs);
			  options.addArguments("--disable-extensions");
			  options.addArguments("--disable-infobars");
			  driver=new ChromeDriver(options);  
			 
			log.debug("chrome launched....");

		}
		else if(config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\executables\\chromedriver.exe");
			driver= new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("ie")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\executables\\chromedriver.exe");
			driver= new InternetExplorerDriver();
		}
			
			driver.get(config.getProperty("url"));
			log.debug("Navigated to...."+config.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 5);
			
			menu=new TopMenu(driver); 
		}		
	}	
	
	
	
	public static void quit() {
		driver.quit();
	}
		
		public static void click(String locator) {
			if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(locator))).click();
			}else if(locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locator))).click();
			}else if(locator.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locator))).click();
			} 
			log.debug("Clicking on the Element: "+locator);
			test.log(LogStatus.INFO, "Clicking on "+locator.toUpperCase());
		}
		
		
		public static void type(String locator, String value) {
			if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value); 
			}else if(locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value); 
			}else if(locator.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locator))).sendKeys(value); 
			} 
			log.debug("Typing in an element: "+locator+ " entered value: "+value);
			test.log(LogStatus.INFO, "TYping in : "+locator.toUpperCase()+" entered value as: "+value);
		}
		
		
		
		public static boolean isElementPresent(By by) {
			try {
				driver.findElement(by);
				return true;			
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				return false;	
			}
		}
		
		
		static WebElement dropdown;
		public static void select(String locator, String value) {
			if(locator.endsWith("_CSS")) {
				dropdown=driver.findElement(By.cssSelector(or.getProperty(locator))); 
			}else if(locator.endsWith("_XPATH")) {
				dropdown=driver.findElement(By.xpath(or.getProperty(locator))); 
			}else if(locator.endsWith("_ID")) {
				dropdown=driver.findElement(By.id(or.getProperty(locator))); 
			} 
			
			Select select=new Select(dropdown);
			select.selectByVisibleText(value);
			log.debug("Selecting from drop down : "+locator+" and value as: "+value);
			test.log(LogStatus.INFO, "Selecting from drop down : "+locator.toUpperCase()+" and value as: "+value);
		}
		
		
		
		public static void verifyEquals(String excepted, String actual) throws IOException {		
			try {
				Assert.assertEquals(actual, excepted);
			} catch (Throwable t) {
				// TODO: handle exception
				Utilities.captureScreenshot();
				//ReportNG
				Reporter.log("<br>"+" Verification Failure: "+t.getMessage()+"<br>");
				Reporter.log("<a target=\"blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");			
				Reporter.log("<br>");
				Reporter.log("<br>");
				//Extent Report
				test.log(LogStatus.FAIL, " Verification Failed with Exception: "+t.getMessage());
				test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));				
			}
		}	
}
