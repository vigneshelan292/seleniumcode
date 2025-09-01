package screeenshotforfailed;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener {
	
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		File f1=new File("C:\\Users\\New\\eclipse-workspace\\seleniumcode\\src\\test\\java\\screeenshotforfailed\\report.html");
		ExtentSparkReporter report=new ExtentSparkReporter(f1);
		report.config().setDocumentTitle("NewDoc");
		report.config().setReportName("Vignesh");
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("tester", "vicky");
		
	}


	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());//create a new test entry for every test
		driver=new ChromeDriver();
	}



	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.pass("test passed");
		driver.quit();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());//gets the error/exception(like nosuchelemnt,assertionerror)
		//take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//use double back slash or single forward slash
		String path="C:\\Users\\New\\eclipse-workspace\\seleniumcode\\screenshots\\"+result.getMethod().getMethodName()+".png";
		
		File destfile=new File(path);
		try {
			destfile.getParentFile().mkdir();//create directory if no exists 
			Files.copy(srcFile.toPath(), destfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			//If a file with the same name already exists at the destination, delete it and save the new one instead."
			test.addScreenCaptureFromPath(path);//attach screenshot to report
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
		
		
		
		
		
		
		
		
		
	
	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();//Save & close the report properly at the end
	}

}
