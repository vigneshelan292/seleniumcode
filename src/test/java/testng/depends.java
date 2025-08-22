package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class depends {
	@Parameters({"url"})
	@Test(dependsOnMethods= {"B"})
	public void A(String urlname) {
		
		System.out.println("execute first");
		System.out.println(urlname);
		
		
		
	}
	
	@Test
	public void B() {
		System.out.println("execute second");
	}
	
	@Test(enabled=false)
	public void donexecute() {
		System.out.println("enabled");
	}
	
	@Test(timeOut=4000)
	public void time() {
		System.out.println("timeout");
	}
	
	

}
