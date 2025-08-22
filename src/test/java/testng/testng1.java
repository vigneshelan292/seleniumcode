package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testng1 {
	
	@BeforeSuite
	public void suite() {
		System.out.println("beforesuite");
	}
	
	@BeforeClass
	public void beforeclas() {
		System.out.println("beforeclas");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("@AfterClass");
	}
	
		
	
	
	@Test(groups={"Smoke"})
	public void newtest() {
		System.out.println("testnew");
	}
	
	@Parameters({"url"})
	@Test
	public void checkparam(String url) {
		System.out.println(url);
		
	}
	
	
	
	

}
