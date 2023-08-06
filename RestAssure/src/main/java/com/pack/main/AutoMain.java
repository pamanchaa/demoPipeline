package com.pack.main;


import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutoMain {

	public static WebDriver driver;
	
	//create the htmlReporter object
//	public static ExtentSparkReporter htmlReporter;
//	public static ExtentReports extent;
//	public static ExtentTest test1,test2;
	
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;


////////////////////////////////////////////////////////////
		@BeforeSuite
		public void setup() throws FileNotFoundException {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String actTimeStamp = sdf1.format(timestamp);
			
			String extentPath=System.getProperty("user.dir") + "\\extentReports\\"+"extentReport_"+actTimeStamp+".html";
			extentSparkReporter = new ExtentSparkReporter(extentPath);
			System.out.println("Extent path ="+extentPath);
			// create ExtentReports and attach reporter(s)
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);

			
			//////////////////////////////////
//			DesiredCapabilities cap = new DesiredCapabilities();
//	        cap.setJavascriptEnabled(true);
//	        ChromeOptions opt = new ChromeOptions();
//	        opt.addArguments("disable-infobars");
//	        opt.merge(cap);
	        
			//////////////////////////////////
			
			// initializing and starting the browser
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver = new ChromeDriver(opt);
			
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\pamancha\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-firefox-driver\\3.14.0\\selenium-firefox-driver-3.14.0.jar");
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\pamancha\\Documents\\geckodriver.exe");
			
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability("marionette",true);
//			driver=new FirefoxDriver(capabilities);
			
			
			
			
			
			
			///////////////////////////////////////
//			//sand
//			
//			//alert
//			Alert alert = driver.switchTo().alert();
//			
//			//select
//			WebElement we = driver.findElement(null);
//			Select select = new Select(we);
//			
//			
//			//File
//			File file= new File("");
//			FileInputStream fip = new FileInputStream("");
//			
//			//Actions
//			Actions actions = new Actions(driver);
////			actions
//				//rightclick
//			actions.contextClick();
//			
//			//Remote
////			driver = new RemoteWebDriver(null);
			
			//Keys
//			Keys keys = null;
//			keys.chord(keys.SHIFT,keys.CONTROL);
//			
//			Actions a = new Actions(driver);
//			a.keyDown(Keys.ALT).keyDown(Keys.SHIFT) .keyDown(Keys.CONTROL).sendKeys() .build() .perform();
					
			///////////////////////////////////////
		}
////////////////////////////////////////////////////////////	


////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////

		
////////////////////////////////////////////////////////////
	@AfterSuite
	public void tearDown() {
//		driver.quit();
		extentTest.pass("closed the browser");
		extentTest.info("test completed");

		// write results into the file
		extentReports.flush();
	}
////////////////////////////////////////////////////////////
	
	

}
