package testng;

import org.testng.annotations.Test;

public class dependsongroups {
	
	@Test(groups={"smoke"})
	public void a() {
		System.out.println("a");
	}
	
	@Test(groups={"smoke"})
	public void b() {
		System.out.println("b");
	}
	
	@Test(groups={"regression"})
	public void c() {
		System.out.println("c");
	}
	
	@Test(groups={"regression"})
	public void D() {
		System.out.println("D");
	}
	
	@Test(dependsOnGroups={"smoke"})
	public void real1() {
		System.out.println("realtest1");
	}
	@Test(dependsOnGroups={"regression"})
	public void real2() {
		System.out.println("realtest2");
	}
  

}
