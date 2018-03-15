package testbase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
	
	public static WebDriver driver;
	public String startTime;
	public static int indexSI = 1;
	//public static ExtentReports extent;
	//public static ExtentTest test;
	private static final Logger log = LogManager.getLogger(TestBase.class.getName());

	public void init() throws IOException {
		//String log4jConfPath = "log4j.properties";
		//PropertyConfigurator.configure(log4jConfPath);
		//loadPropertiesFile();
		//selectBrowser(Repository.getProperty("browser"));
		//driver.get(Repository.getProperty("url"));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void selectBrowser(String browser){
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("firefox")){
				//https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				//https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
		else if(System.getProperty("os.name").contains("Mac")){
			System.out.println(System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
				driver = new ChromeDriver();
			}
		}
	}
	
	@AfterMethod()
	public void afterMethod(ITestResult result) {
		//getresult(result);
		
		log.info("in after method"+result.getName());
		System.out.println("After method has been executed ");
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		/*test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");*/
		log.info("in Before method"+result.getName());
		System.out.println("Before method has been executed ");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		//closeBrowser();
		
		log.info("browser closed");
		System.out.println("Browser closed ");
	}

	public void closeBrowser() {
	/*	extent.endTest(test);
		extent.flush();*/
	}
}
