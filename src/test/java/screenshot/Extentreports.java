package screenshot;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
	static ExtentReports rep;
	
	@BeforeTest
	public static ExtentReports reportcode() {
		
		
		File f1=new File("C:\\Users\\New\\eclipse-workspace\\seleniumcode\\src\\test\\java\\screenshot\\new.html");
		ExtentSparkReporter report=new ExtentSparkReporter(f1);
		report.config().setReportName("Newreport");
		report.config().setDocumentTitle("Extentdomain");
		
		 rep=new ExtentReports();
		rep.attachReporter(report);
		rep.setSystemInfo("tester", "vicky");
		return rep;
		
	}
	
	
	
	
	
	@Test
	public void logincode() {
		
		ExtentTest test=rep.createTest("initialdemo");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://internalqa1euc1.realizeitglobal.com/RealizeitApp/RealizeIt.aspx");
		test.fail("fail purposely");
		
		rep.flush();
		
	}

}
