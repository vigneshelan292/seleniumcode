package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngclassspetest {
	
	@AfterTest
	public void aftertest() {
		System.out.println("executelast");
	}
	
	
	@Test
	public void newone() {
		System.out.println("checking by creating new test");
	}
@BeforeMethod
public void beforeverymethod() {
	System.out.println("beforeverymethod");
}

@AfterMethod
public void aftermethod() {
	System.out.println("aftermethod");
}


@Test
public void skipp() {
	System.out.println("Skipping");
}

@Test
public void toteinclue() {
	System.out.println("totestinclude");
}

@Test
public void excluding30test() {
	System.out.println("excluding 30");
}

@Test
public void excluding29test() {
	System.out.println("excluding 29");
}

@BeforeTest
public void tocheck() {
	System.out.println("Beforetest");
}
@AfterSuite
public void aftersuite() {
	System.out.println("aftersuite");
}

}