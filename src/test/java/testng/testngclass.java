package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testngclass {
	@Parameters({"devurl"})
	@Test
	public void demo(String devurlname) {
		System.out.println("Hello");
		System.out.println(devurlname);
	}
	
	
	@BeforeTest
	public void beoforefirst() {
		System.out.println("execute first");
}
}