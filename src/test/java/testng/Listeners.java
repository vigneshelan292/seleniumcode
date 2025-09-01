package testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import screenshot.Extentreports;
import screenshot.ScreenshotExample;

public class Listeners extends ScreenshotExample implements ITestListener {
	
	ExtentTest test;
	ExtentReports repo;
	@Override
	public void onTestStart(ITestResult result) {
		repo=Extentreports.reportcode();
		
		 test=repo.createTest(result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    test.fail(result.getThrowable());
	    WebDriver driver = new ChromeDriver(); 
	   // or get driver from your test class
	    try {
	        String path = screen(result.getMethod().getMethodName(), driver);
	        test.addScreenCaptureFromPath(path);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("executeaftermytestskipp");
	}
	
	
	
}
