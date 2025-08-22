package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	
	
	@DataProvider(name="setofdata")
	public Object[][] setdata() {
		Object[][] obj =new Object[][] {{"test1","test2"},{"test3","test4"},{"test5","test6"}};
		return obj;
	}
	

	@Test(dataProvider="setofdata")
	public void getdata(String user,String pwd) {
		System.out.println(user);
		System.out.println(pwd);
	}
}
