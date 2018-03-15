package customlistner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testbase.TestBase;


public class Listener extends TestBase implements ITestListener, ISuiteListener {
	private static final Logger log = LogManager.getLogger(Listener.class.getName());
   
	public void onFinish(ITestContext arg0) {
		log.info("end time only----test has been finished" + arg0.getName());
	}

	public void onStart(ITestContext arg0) {
		log.info("First time only -- test has been started" + arg0.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult result) {
/*		if(!result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/";
				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		log.info("on test failure" + result.getName());
		
	}


	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	public void onTestStart(ITestResult arg0) {
		log.info(" Actual stating @TEST ..has been started" + arg0.getName());
	}

	public void onTestSuccess(ITestResult arg0) {
		log.info(" Actual stating @TEST ..on test success " + arg0.getName());
}

	
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
		log.info("suite has been finished" +arg0.getName());
		Reporter.log("About to end executing Suite " + arg0.getName(), true);
		 
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
		log.info("suite has been started" +arg0.getName());
		
	}
}